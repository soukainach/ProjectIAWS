package services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import groovyx.net.http.*;
import static groovyx.net.http.ContentType.JSON;
import data_types.BikeStation;
import interfaces.IJcDecauxService;

@Service
public class JcDecauxService implements IJcDecauxService {
	private static final List<BikeStation> mUpsStations;

	static {
		mUpsStations = new ArrayList<BikeStation>();
		BikeStation bikeStation = new BikeStation(227, "Toulouse", "UPS métro");
		mUpsStations.add(bikeStation);
	}

	public List<BikeStation> getBikeStations() {
		return mUpsStations;
	}

	public int getAvailableBikes(BikeStation bikeStation) {
		bikeStation = new BikeStation(227, "", "");
		int id = bikeStation.getNumber();
		URL url;
		HttpURLConnection connection = null;
		InputStream is = null;
		JSONParser parser = new JSONParser();

		try {
			url = new URL(
					"https://api.jcdecaux.com/vls/v1/stations/"
					+ id
					+ "?contract=Toulouse&apiKey=969f71318582304067419dfddc9ea08b16d567f6");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			is = connection.getInputStream();
			BufferedReader theReader = new BufferedReader(
					new InputStreamReader(is, "UTF-8"));
			String reply;
			while ((reply = theReader.readLine()) != null) {
				// afficher la reponse json telle qu'elle est
				// System.out.println(reply);
				Object obj = parser.parse(reply);
				JSONObject jsonObject = (JSONObject) obj;
				// filtrer le resultat
				return (int) jsonObject.get("available_bikes");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
