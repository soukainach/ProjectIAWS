package services

import static groovyx.net.http.ContentType.JSON
import data_types.Line;
import data_types.RatedLine;
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.HttpURLClient
import groovyx.net.http.RESTClient
import interfaces.ICouchDbService

class CouchDbService implements ICouchDbService{

	
	private void sendGet(Integer id) throws Exception {
	
		URL url;
		
	try {
	url = new URL("http://localhost:5984/test");
    HttpURLConnection conn = url.openConnection();
    conn.setRequestMethod("POST");
    conn.setDoOutput(true);
 
    OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

    writer.write(data);
    writer.flush();
    String line;
    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    while ((line = reader.readLine()) != null) {
      System.out.println(line);
    }
    writer.close();
    reader.close();
	}
	catch (Exception e) {
		e.printStackTrace();
}
	
	}
	def getDataLike() 
	{
	     
		def retourJson = "Erreur"
		def adresseServeur = new RESTClient("http://localhost:5984")
		
		def resp = adresseServeur.get(path: "/test/763d9a738924c91acdb160edb00005a8", requestContentType: JSON, contentType: JSON)
		resp.charset("UTF-8")
		}

	public RatedLine getLineRatings(Line line) {
		// TODO Auto-generated method stub
		return null;
	}

	public void registerLike(Line line) {
		// TODO Auto-generated method stub
		
	}

	public void registerDislike(Line line) {
		// TODO Auto-generated method stub
		
	}
	
	



}
