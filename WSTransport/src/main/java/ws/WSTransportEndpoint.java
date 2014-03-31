package ws;

import java.util.List;

import interfaces.ICouchDbService;
import interfaces.IOpenDataService;
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

@Endpoint
public class WSTransportEndpoint {
	public static final String NAMESPACE_URI = "http://iaws/ws/transports";

	private final ICouchDbService mCouchDbService;
	private final IOpenDataService mOpenDataService;
	private final ITisseoService mTisseoService;

	@Autowired
	public WSTransportEndpoint(ICouchDbService couchDbService,
			IOpenDataService openDataService, ITisseoService tisseoService)
			throws JDOMException {
		mCouchDbService = couchDbService;
		mOpenDataService = openDataService;
		mTisseoService = tisseoService;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "BikeStationsRequest")
	@ResponsePayload
	public Element handleBikeStationsRequest() throws Exception {
		return XmlHelper.bikeStationsResponse(mOpenDataService
				.getBikeStations());
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "AvailableBikesRequest")
	@Namespace(prefix="tr", uri=NAMESPACE_URI)
	@ResponsePayload
	public Element handleAvailableBikesRequest(
			@XPathParam("//tr:station/@number") Integer number,
			@XPathParam("//tr:station/@contract") String contract)
			throws Exception {
		List<BikeStation> bikeStations = mOpenDataService.getBikeStations();
		BikeStation bikeStation = BikeStation
				.getBikeStationByNumberAndContract(number, contract,
						bikeStations);
		int availableBikes = mOpenDataService.getAvailableBikes(bikeStation);
		return XmlHelper.availableBikesResponse(bikeStation, availableBikes);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "LinesRequest")
	public void handleLinesRequest() throws Exception {
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "StopPointsRequest")
	public void handleStopPointsRequest() throws Exception {
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "StopTimeRequest")
	public void handleStopTimeRequest() throws Exception {
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "RateRequest")
	public void handleRateRequest() throws Exception {
	}
}