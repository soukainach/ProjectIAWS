package services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import groovyx.net.http.*;
import static groovyx.net.http.ContentType.JSON;
import data_types.BikeStation;
import data_types.BikesStations;
import interfaces.IJcDecauxService;

@Service
public class JcDecauxService implements IJcDecauxService {
	private static final String API_KEY = "969f71318582304067419dfddc9ea08b16d567f6";
	private static final List<BikeStation> mUpsStations;

	static {
		mUpsStations = new ArrayList<BikeStation>();
		mUpsStations.add(new BikeStation(227, "Toulouse", "UPS métro"));
		mUpsStations.add(new BikeStation(232, "Toulouse", "64 RTE DE NARBONNE"));
		mUpsStations.add(new BikeStation(233, "Toulouse", "105 RTE DE NARBONNE"));
		mUpsStations.add(new BikeStation(231, "Toulouse", "RANGUEIL / CL ROCHE"));
		mUpsStations.add(new BikeStation(228, "Toulouse", "FACE 35 CHEMIN DES MARAICHERS"));
		mUpsStations.add(new BikeStation(230, "Toulouse", "141 AV DE RANGUEIL"));
	}

	public List<BikeStation> getBikeStations() {
		return mUpsStations;
	}

	public int getAvailableBikes(BikeStation bikeStation) {
		int id = bikeStation.getNumber();
		URL url;
		HttpURLConnection connection = null;
		InputStream is = null;
		JSONParser parser = new JSONParser();

		try {
			url = new URL(
					"https://api.jcdecaux.com/vls/v1/stations/"
					+ id
					+ "?contract=Toulouse&apiKey=" + API_KEY);
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



	public double getBikeLatLng(BikesStations bikesStations) {
		int id = bikesStations.getNumber();
		URL url;
		HttpURLConnection connection = null;
		InputStream is = null;
		JSONParser parser = new JSONParser();

		try {


			url = new URL(
					"https://api.jcdecaux.com/vls/v1/stations/"
					+ id
					+ "?contract=Toulouse&apiKey=" + API_KEY);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			is = connection.getInputStream();
			BufferedReader theReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String reply;
			while ((reply = theReader.readLine()) != null) {

				Object obj = parser.parse(reply);
				for(int i=0;i<obj.size();i++) {
					JSONObject jsonObject = ((JSONArray) obj).get(i);
					//filtrer le resultat
					number = (int) jsonObject.get("number");

					//float position = (float) jsonObject.get("lat");
					contract_name = (String) jsonObject.get("contract_name");
					StationName = (String) jsonObject.get("name");
					JSONObject position = jsonObject.get("position");

					//And then read attributes like
					return	(double) lat = position.get("lat");
					return	(double) lng = position.get("lng");
					// System.out.println("Numéro de la station :"+number+" Vile : "+contract_name+ " Nom de la station "+StationName+ " Vélos Disponibles: "+available_bikes+ " latitude "+lat+" longitude "+lng);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
