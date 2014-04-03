package main.ws
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



class OpenDataProchainsPassages {

	
	private void ListeArretsLigneGet(Integer id)  {
		
		URL url;
		HttpURLConnection connection = null;
		InputStream is = null;
		JSONParser parser = new JSONParser();
				
		url = new URL("http://pt.data.tisseo.fr/stopAreasList?lineId="+id+"&key=a03561f2fd10641d96fb8188d209414d8&format=json");
				connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();
				is = connection.getInputStream();
				BufferedReader theReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				String reply;
				while ((reply = theReader.readLine()) != null)
				{
						 //afficher la reponse json telle qu'elle est
						System.out.println(reply);
						Object obj = parser.parse(reply);
						JSONObject jsonObject = (JSONObject) obj;
						//filtrer le resultat
						
				}
		
		
	}
	
	
}
