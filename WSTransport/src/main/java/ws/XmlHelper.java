package ws;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import data_types.BikeStation;
import data_types.Line;
import data_types.RatedLine;
import data_types.StopPoint;

public class XmlHelper {
	private static final DocumentBuilder mBuilder;

	static {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// We should pray for this exception not to be thrown
			e.printStackTrace();
		}
		mBuilder = builder;
	}

	public static Element bikeStationsResponse(List<BikeStation> bikeStations) {
		Document document = mBuilder.newDocument();
		Element root = document.createElement("BikeStationsResponse");
		setupRootAttributes(root);
		document.appendChild(root);
		for (BikeStation bikeStation : bikeStations) {
			root.appendChild(bikeStation(document, bikeStation));
		}
		return document.getDocumentElement();
	}

	public static Element availableBikesResponse(BikeStation bikeStation,
			int availableBikes) {
		Document document = mBuilder.newDocument();
		Element root = document.createElement("AvailableBikesResponse");
		setupRootAttributes(root);
		document.appendChild(root);
		root.setAttribute("availableBikes", "" + availableBikes);
		root.appendChild(bikeStation(document, bikeStation));
		return document.getDocumentElement();
	}

	public static Element linesResponse(List<RatedLine> lines) {
		Document document = mBuilder.newDocument();
		Element root = document.createElement("LinesResponse");
		setupRootAttributes(root);
		document.appendChild(root);
		for (RatedLine line : lines) {
			root.appendChild(ratedLine(document, line));
		}
		return document.getDocumentElement();
	}

	public static Element stopPointsResponse(List<StopPoint> stopPoints) {
		Document document = mBuilder.newDocument();
		Element root = document.createElement("StopPointsResponse");
		setupRootAttributes(root);
		document.appendChild(root);
		for (StopPoint stopPoint : stopPoints) {
			root.appendChild(stopPoint(document, stopPoint));
		}
		return document.getDocumentElement();
	}

	public static Element stopTimeResponse(Line line, StopPoint stopPoint,
			String nextStop) {
		Document document = mBuilder.newDocument();
		Element root = document.createElement("StopTimeResponse");
		setupRootAttributes(root);
		document.appendChild(root);
		root.appendChild(line(document, line));
		root.appendChild(stopPoint(document, stopPoint));
		root.setAttribute("date", nextStop);
		return document.getDocumentElement();
	}

	private static Element stopPoint(Document document, StopPoint stopPoint) {
		Element ret = document.createElement("stopPoint");
		ret.setAttribute("id", "" + stopPoint.getId());
		ret.setAttribute("direction", stopPoint.getDirection());
		ret.setAttribute("friendlyName", stopPoint.getFriendlyName());
		return ret;
	}

	private static Element bikeStation(Document document,
			BikeStation bikeStation) {
		Element ret = document.createElement("station");
		ret.setAttribute("number", "" + bikeStation.getNumber());
		ret.setAttribute("contract", bikeStation.getContract());
		ret.setAttribute("friendlyName", bikeStation.getFriendlyName());
		return ret;
	}

	private static Element ratedLine(Document document, RatedLine line) {
		Element ret = document.createElement("line");
		ret.setAttribute("id", line.getId() + "");
		ret.setAttribute("shortName", line.getShortName());
		ret.setAttribute("friendlyName", line.getFriendlyName());
		ret.setAttribute("likes", "" + line.getLikes());
		ret.setAttribute("dislikes", "" + line.getDislikes());
		return ret;
	}

	private static Element line(Document document, Line line) {
		Element ret = document.createElement("line");
		ret.setAttribute("id", line.getId() + "");
		ret.setAttribute("shortName", line.getShortName());
		ret.setAttribute("friendlyName", line.getFriendlyName());
		return ret;
	}

	private static void setupRootAttributes(Element root) {
		root.setAttribute("xmlns", WSTransportEndpoint.NAMESPACE_URI);
		root.setAttribute("xmlns:xsi",
				"http://www.w3.org/2001/XMLSchema-instance");
		root.setAttribute("xsi:schemaLocation",
				WSTransportEndpoint.NAMESPACE_URI + " WSTransport.xsd");
	}

	private XmlHelper() {
	}
}
