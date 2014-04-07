package processing

import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import groovyx.net.http.*
import static groovyx.net.http.ContentType.JSON
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/****
 * 
 * @author pc
 * l'objectif est de récuperer des informations concernant la disponibilité de vélos pour une station donnée
 */

class ParserBikeStations {

	private int number
	private String contract_name
	private int available_bikes
	private String StationName
	
	/*ParserBikeStations()
	{
		
		contract_name = ""
		available_bikes = ""
		StationName = ""
		
	}*/
	
	private void sendGet(Integer id) throws Exception {
		
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
						number = (int) jsonObject.get("number");
	 contract_name = (String) jsonObject.get("contract_name");
	 StationName = (String) jsonObject.get("name");
	 available_bikes = (int) jsonObject.get("available_bikes");
	 // System.out.println("Numero de la station"+number)
	   System.out.println("Numéro de la station :"+number+" Vile : "+contract_name+ " Nom de la station "+StationName+ " Vélos Disponibles: "+available_bikes);
				}
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		
	}
		
	
	/****
		 *
		 * Setters and getters
		 *
		 */
		
		String getVilleName()
		{
			contract_name
		}
		
		int getAvailableBikes()
		{
			available_bikes
		}
		String getStationName()
		{
			StationName
		}
		
		
	
	
}
