package ws;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import data_types.BikeStation;

public class XmlHelper {
	private static final DocumentBuilder mBuilder;

	static {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
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

	public static Element availableBikesResponse(BikeStation bikeStation, int availableBikes) {
		Document document = mBuilder.newDocument();
		Element root = document.createElement("AvailableBikesResponse");
		setupRootAttributes(root);
		document.appendChild(root);
		root.setAttribute("availableBikes", "" + availableBikes);
		root.appendChild(bikeStation(document, bikeStation));
		return document.getDocumentElement();
	}

	private static Element bikeStation(Document document,
			BikeStation bikeStation) {
		Element ret = document.createElement("station");
		ret.setAttribute("number", "" + bikeStation.getNumber());
		ret.setAttribute("contract", bikeStation.getContract());
		ret.setAttribute("friendlyName", bikeStation.getFriendlyName());
		return ret;
	}

	private static void setupRootAttributes(Element root) {
		root.setAttribute("xmlns", WSTransportEndpoint.NAMESPACE_URI);
		root.setAttribute("xmlns:xsi",
				"http://www.w3.org/2001/XMLSchema-instance");
		root.setAttribute("xsi:schemaLocation",
				"http://www.example.org/WSTransport WSTransport.xsd");
	}

	private XmlHelper() {
	}
}
