package services

import static groovyx.net.http.ContentType.JSON
import data_types.Line;
import data_types.RatedLine;
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.HttpURLClient
import groovyx.net.http.RESTClient
import interfaces.ICouchDbService

class CouchDbService implements ICouchDbService{

	
	def Likes() {
		
		  def retourJson = "Erreur"
		  def adresseServeur = new HTTPBuilder("http://localhost:5984")
		  
		  def path= '/test/763d9a738924c91acdb160edb00005a8'
		 
		  
		  //Get request
		  adresseServeur.request(Method.GET, JSON) {
		  
			  uri.path = path
			
			  // success response handler
			  response.success = { resp, json ->
				  retourJson = json
			  }
			
			  // failure response handler
			  response.failure = { resp ->
				  println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
			  }
		  }
		 
		  retourJson
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
