package ws;

import java.util.ArrayList;
import java.util.List;

import interfaces.ICouchDbService;
import interfaces.IJcDecauxService;
import interfaces.ITisseoService;

import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.Namespace;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.XPathParam;
import org.w3c.dom.Element;

import data_types.BikeStation;
import data_types.Line;
import data_types.RatedLine;
import data_types.StopPoint;

@Endpoint
public class WSTransportEndpoint {
	public static final String NAMESPACE_URI = "http://iaws/ws/transports";

	private final ICouchDbService mCouchDbService;
	private final IJcDecauxService mJcDecauxService;
	private final ITisseoService mTisseoService;

	@Autowired
	public WSTransportEndpoint(ICouchDbService couchDbService,
			IJcDecauxService jcDecauxService, ITisseoService tisseoService)
			throws JDOMException {
		mCouchDbService = couchDbService;
		mJcDecauxService = jcDecauxService;
		mTisseoService = tisseoService;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "BikeStationsRequest")
	@ResponsePayload
	public Element handleBikeStationsRequest() throws Exception {
		return XmlHelper.bikeStationsResponse(mJcDecauxService
				.getBikeStations());
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "AvailableBikesRequest")
	@Namespace(prefix = "tr", uri = NAMESPACE_URI)
	@ResponsePayload
	public Element handleAvailableBikesRequest(
			@XPathParam("//tr:station/@number") Integer number,
			@XPathParam("//tr:station/@contract") String contract,
			@XPathParam("//tr:station/@friendlyName") String friendlyName)
			throws Exception {
		BikeStation bikeStation = new BikeStation(number, contract,
				friendlyName);
		int availableBikes = mJcDecauxService.getAvailableBikes(bikeStation);
		return XmlHelper.availableBikesResponse(bikeStation, availableBikes);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "StopPointsRequest")
	@Namespace(prefix = "tr", uri = NAMESPACE_URI)
	@ResponsePayload
	public Element handleStopPointsRequest(
			@XPathParam("//tr:line/@id") Long lineId,
			@XPathParam("//tr:line/@shortName") String shortName,
			@XPathParam("//tr:line/@friendlyName") String lineFriendlyName)
			throws Exception {
		Line line = new Line(lineId, shortName, lineFriendlyName);
		return XmlHelper.stopPointsResponse(mTisseoService.getStopPoints(line));
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "StopTimeRequest")
	@Namespace(prefix = "tr", uri = NAMESPACE_URI)
	@ResponsePayload
	public Element handleStopTimeRequest(
			@XPathParam("//tr:stopPoint/@id") Long stopPointId,
			@XPathParam("//tr:stopPoint/@direction") String direction,
			@XPathParam("//tr:stopPoint/@friendlyName") String stopPointFriendlyName,
			@XPathParam("//tr:line/@id") Long lineId,
			@XPathParam("//tr:line/@shortName") String lineShortName,
			@XPathParam("//tr:line/@friendlyName") String lineFriendlyName)
			throws Exception {
		StopPoint stopPoint = new StopPoint(stopPointId, direction,
				stopPointFriendlyName);
		Line line = new Line(lineId, lineShortName, lineFriendlyName);
		return XmlHelper.stopTimeResponse(line, stopPoint,
				mTisseoService.getNextStop(line, stopPoint));
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "LinesRequest")
	@ResponsePayload
	public Element handleLinesRequest() throws Exception {
		List<Line> lines = mTisseoService.getLines();
		List<RatedLine> ratedLines = new ArrayList<RatedLine>();
		for (Line line : lines) {
			ratedLines.add(mCouchDbService.getLineRatings(line));
		}
		return XmlHelper.linesResponse(ratedLines);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "RateRequest")
	@Namespace(prefix = "tr", uri = NAMESPACE_URI)
	public void handleRateRequest(
			@XPathParam("/tr:RateRequest/@action") String action,
			@XPathParam("//tr:line/@id") Long id,
			@XPathParam("//tr:line/@shortName") String shortName,
			@XPathParam("//tr:line/@friendlyName") String friendlyName)
			throws Exception {
		Line line = new Line(id, shortName, friendlyName);
		if (action.equals("like")) {
			mCouchDbService.registerLike(line);
		} else if (action.equals("dislike")) {
			mCouchDbService.registerDislike(line);
		}
	}

}