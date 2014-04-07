package services;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import data_types.Line;
import data_types.RatedLine;
import interfaces.ICouchDbService;

public class CouchDBServices implements ICouchDbService {

	
	public void sendPost() throws Exception {
		
		String host = "localhost";
		String port = "5984";
		String name ="Metro ups";
		String idLine = "0";
		String number = "1";
		
			System.out.println("Create bucket with Membase Rest API");
	 
			URL url = new URL("http://" + host + ":" + port
					+ "/test/763d9a738924c91acdb160edb00005a8");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setAllowUserInteraction(false);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			
			String[] paramName = { "idLine", "Name", "numberLike"};
			String[] paramVal = { idLine, name, number};
	 
			// Create the form content
			OutputStream out = conn.getOutputStream();
			Writer writer = new OutputStreamWriter(out, "UTF-8");
			for (int i = 0; i < paramName.length; i++) {
				writer.write(paramName[i]);
				writer.write("=");
				writer.write(URLEncoder.encode(paramVal[i], "UTF-8"));
				
			}
			writer.close();
			out.close();
	 
			System.out.println(conn.getResponseCode() + " : "
					+ conn.getResponseMessage());
			conn.disconnect();
	 
			System.out.println("Create succeded");
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
