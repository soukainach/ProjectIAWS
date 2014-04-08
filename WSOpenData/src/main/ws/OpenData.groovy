package main.ws

import main.ws.TrustManager

import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import groovyx.net.http.*
import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.Method.*

/****
 * 
 * 
 * @author pc
 *  Dans cette partie on va commencer par la consommation d'un web service existant "Open Data Tisséo"
 *  qui va nous permettre de récupérer des informations sur 
 */

class OpenData {
	
	
	
	/*****
	 * 
	 * @return listes de arrets d'une ligne choisi par l'utilisateur 
	 * 
	 *****/
	
	def ListeArretsLigne(def lineid)
	{
		def retourJson = "Erreur"
		def adresseServeur = new HTTPBuilder("http://pt.data.tisseo.fr")
		def path='/stopAreasList?lineId='+lineid+'&key=a03561f2fd10641d96fb8188d209414d8&format=json'
	
    
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
	}

/********
 * 
 * Retourner la liste de prochains passages 
 * 
 *******/
	def ListeLignes(def stopId) {
		
		  def retourJson = "Erreur"
		  def adresseServeur = new HTTPBuilder("")
		  
		  def path= 'departureBoard?stopPointId='+stopId+'&key=a03561f2fd10641d96fb8188d209414d8&format=json'
		 
		  
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

	/****
	 * 
	 * @return The list of tisseo network lines 
	 * 
	 *****/
	
	def LignesTisseo() {
		
		  def retourJson = "Erreur"
		  def adresseServeur = new HTTPBuilder("http://pt.data.tisseo.fr")
		  
		  def path= '/linesList?format=json&network=Tisséo&key=a03561f2fd10641d96fb8188d209414d8'
		 
		  
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

	
	
	def LatLngPointArea() {
		 
		  def retourJson = "Erreur"
		  def adresseServeur = new HTTPBuilder("http://pt.data.tisseo.fr")
		  
		  def path= '/stopAreasList?displayLines=1&displayCoordXY=1&key=a03561f2fd10641d96fb8188d209414d8&format=json'
		 
		  
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
	
	def ToulouseBikesStations() {
		
		 def retourJson = "Erreur"
		 
		 def adresseServeur = new HTTPBuilder("https://api.jcdecaux.com")
		 
		 def path= '/vls/v1/stations?contract=Toulouse&apiKey=969f71318582304067419dfddc9ea08b16d567f6'
		
		 
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
