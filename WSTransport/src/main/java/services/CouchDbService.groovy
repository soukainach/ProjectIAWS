package services
import data_types.Line;
import data_types.RatedLine;
import groovyx.net.http.RESTClient
import interfaces.ICouchDbService
import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient

class CouchDbService  implements ICouchDbService{
/*
	def getRESTClient(){ 
		
	def client =  new RESTClient("http://localhost:5498/testrest")
	def response = client.put(contentType: JSON)
	assert response.status == 200
	
	}*/
	public void getData() throws IOException
	{
	        DefaultHttpClient httpclient = new DefaultHttpClient();
 
           HttpGet get = new HttpGet("http://localhost:5984/test");
 
           HttpResponse response = httpclient.execute(get);
 
           HttpEntity entity=response.getEntity();
 
           InputStream instream = entity.getContent();
 
           BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
 
           String strdata = null;
		   String jsonString = "" ;
		   
					 while( (strdata =reader.readLine())!=null)
		   
					 {
		   
		                    System.out.println(strdata);
		   
							jsonString += strdata;
		   
					 }
		   
					  
		   
					 System.out.println("Json String: " + jsonString);
		   
					 Map<String, Object> jsonMap = getMapFromJsonString(jsonString);
					 if(jsonMap!=null)
					 
							   {
					 
								   System.out.println("total_rows: " + jsonMap.get("total_rows"));
					 
								   System.out.println("offset: " + jsonMap.get("offset"));
							   }
	}
	
	public RatedLine getLineRatings(Line line) {
		// TODO Auto-generated method stub
		return null;
	}

	public void registerLike(Line line) {
		// TODO Auto-generated method stub
		
		HttpClient httpclient = new DefaultHttpClient();
		
	   HttpGet get = new HttpGet("http://localhost:5984/test");
		
	   HttpResponse response = httpclient.execute(get);
		
	}

	public void registerDislike(Line line) {
		// TODO Auto-generated method stub
		
	}

}
