package ws;

import java.util.List;

import org.jdom.Element;

import data_types.BikeStation;

public class XmlHelper {
	public static Element bikeStationsResponse(List<BikeStation> bikeStations) {
		Element ret = new Element("BikeStationsResponse");
		for (BikeStation bikeStation : bikeStations) {
			ret.addContent(bikeStation(bikeStation));
		}
		return ret;
	}

	public static Element availableBikesResponse(int availableBikes) {
		Element ret = new Element("AvailableBikesResponse");
		ret.addContent(new Element("availableBikes").setText(""
				+ availableBikes));
		return ret;
	}

	private static Element bikeStation(BikeStation bikeStation) {
		Element ret = new Element("BikeStation");
		ret.addContent(new Element("number").setText(""
				+ bikeStation.getNumber()));
		ret.addContent(new Element("contract").setText(bikeStation
				.getContract()));
		ret.addContent(new Element("friendlyName").setText(bikeStation
				.getFriendlyName()));
		return ret;
	}

	private XmlHelper() {
	}
}
