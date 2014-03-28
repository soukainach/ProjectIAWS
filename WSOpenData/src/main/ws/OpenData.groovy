package main.ws
import groovyx.net.http.*
import static groovyx.net.http.ContentType.JSON

/****
 * 
 * 
 * @author pc
 *  Dans cette partie on va commencer par la consommation d'un web service existant "Open Data Tisséo"
 *  qui va nous permettre de récupérer des informations sur 
 */

class OpenData {
	
/********
 * 
 * retourner des informations concernant les coordonnés XY et les prochains arrêtes 
 * 
 *******/
	def ListeLignes() {
		
		  def retourJson = "Erreur"
		  def adresseServeur = new HTTPBuilder("http://pt.data.tisseo.fr")
		  
		  def path= 'departureBoard?stopPointId=1970324837185012&key=a03561f2fd10641d96fb8188d209414d8&format=json'
		 
		  
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
	
	

	/***
	 * 
	 * @param id
	 * @return une station de velo a partir de son numéro
	 */
	def getJsonStation(Integer id) {
		def retourJson = "Erreur"
			 
		  def adresseServeur = new HTTPBuilder("https://api.jcdecaux.com")
		  
		  def path='/vls/v1/stations/${id}?contract=Toulouse'
		 
		  
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
	
	
	
	
}
