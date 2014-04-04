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
		  def adresseServeur = new HTTPBuilder("http://pt.data.tisseo.fr")
		  
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
	
	
	
}
