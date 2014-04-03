package main.ws

import groovyx.net.http.*
import static groovyx.net.http.ContentType.JSON

/****
 * on va utiliser le web service OpenStreetMap(OSM) pour récuperer la longitute and latitude d'une adresse donnée en entrée afin de calculer la distance 
 * entre cette adresse et le point de depart d'un deplacement prévu "Paul sabatier"
 * 
 ***/

class WSOpenStreetMap {
	/**
	 * 
	 * @param adresse
	 * @param codep
	 * @param ville
	 * @return
	 */
	def positionOSM(def adresse, def codep, def ville) {
		
		  def retourJson = "Erreur"
		  def adressem = new HTTPBuilder("http://nominatim.openstreetmap.org")
		  
		  //Build du path
		  def path = '/search/fr/' + adresse + '/' + codep + '/' + ville + '/?format=json'
		    
		  adressem.request(Method.GET, JSON) {
		  
			  uri.path = path
			
			  // En cas de reussite
			  response.success = { resp, json ->
				  retourJson = json
			  }
			
			  response.failure = { resp ->
				  println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
			  }
		  }
		  retourJson
	  }
	
}

