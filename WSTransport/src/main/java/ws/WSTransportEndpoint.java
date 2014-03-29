package ws;

import java.util.List;

import interfaces.ICouchDbService;
import interfaces.IOpenDataService;
import interfaces.ITisseoService;

import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.XPathParam;
import org.jdom.Element;

import data_types.BikeStation;

@Endpoint
public class WSTransportEndpoint {
	private static final String NAMESPACE_URI = "http://www.example.org/WSTransport/";

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
	public Element handleBikeStationsRequest() throws Exception {
		return XmlHelper.bikeStationsResponse(mOpenDataService.getBikeStations());
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "AvailableBikesRequest")
	public Element handleAvailableBikesRequest(
			@XPathParam("/AvailableBikesRequest/number") Integer number,
			@XPathParam("/AvailableBikesRequest/contract") String contract)
			throws Exception {
		List<BikeStation> bikeStations = mOpenDataService.getBikeStations();
		BikeStation bikeStation = BikeStation.getBikeStationByNumberAndContract(number, contract, bikeStations);
		int availableBikes = mOpenDataService.getAvailableBikes(bikeStation);
		return XmlHelper.availableBikesResponse(availableBikes);
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