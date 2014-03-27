package ws;

import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

@Endpoint
public class WSTransportEndpoint {
	private static final String NAMESPACE_URI = "http://www.example.org/WSTransport/";

	@Autowired
	public WSTransportEndpoint() throws JDOMException {
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "BikeStationsRequest")
	public void handleBikeStationsRequest() throws Exception {
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "AvailableBikesRequest")
	public void handleAvailableBikesRequest() throws Exception {
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