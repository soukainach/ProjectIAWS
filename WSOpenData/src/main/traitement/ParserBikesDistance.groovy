package main.traitement
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import groovyx.net.http.*
import static groovyx.net.http.ContentType.JSON
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class ParserBikesDistance {

	private float lat
	private float lng
	
	
	private void LatLngGet(Integer id) throws Exception {
		
		URL url;
		HttpURLConnection connection = null;
		InputStream is = null;
		JSONParser parser = new JSONParser();

		try
		{
				url = new URL("https://api.jcdecaux.com/vls/v1/stations/"+id+"?contract=Toulouse&apiKey=969f71318582304067419dfddc9ea08b16d567f6");
				connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();
				is = connection.getInputStream();
				BufferedReader theReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				String reply;
				while ((reply = theReader.readLine()) != null)
				{
						 //afficher la reponse json telle qu'elle est
						//System.out.println(reply);
						Object obj = parser.parse(reply);
						JSONObject jsonObject = (JSONObject) obj;
						//filtrer le resultat
             Map jsonResult = (Map) obj;
             Map position = (Map) jsonResult.get("position");
	
	 lat=(float) position.get("lat");
	 lng=(float) position.get("lng");
						
	 // System.out.println("Numero de la station"+number)
	   System.out.println("latitude:"+lat+" longitude : "+lng);
						
				}
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	float getLongitude() {
		longitude
	}
	
	float getLatitude() {
		latitude
	}
	
}
