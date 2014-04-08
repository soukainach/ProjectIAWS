package main.traitement;

import groovy.json.JsonSlurper;
import groovy.json.JsonSlurper.*
import net.sf.json.JSONObject.*
import groovy.json.JsonOutput.*
import java.util.List;
import java.util.Map;

/**
 * Cette classe  va parser le résultat Json retourné par le web service tisseo et permet  de
 * récupérer la liste des lignes,arrêtes,et le prochains passages
 */
public class ParserInformations {

	private String dateTime
	private String LineName
	private String ShortName
	private String DestinationName
	
	
	
	ParserInformations(){
		
		dateTime = ""
		LineName = ""
		ShortName = ""
		DestinationName = ""
 	
	}
	
	/****
	 * 
	 *  l'objectif ici est de récuperer la liste de lignes de réseau tisséo
	 * 
	 ****/
	void parserLignes(def documentJson) {
		JsonSlurper sluuuurp = new JsonSlurper()
		def jsonParse = sluuuurp.parseText(documentJson.toString())
		
		Map jsonResult = (Map) jsonParse;
		Map lines = (Map) jsonResult.get("lines");
		
		List lig = (List) lines.get("line");
		
		for(int i=0;i<lig.size();i++)
		{
			
			System.out.println("la ligne : "+lig[i].shortName+ " Destination :"+lig[i].name+ "id: "+lig[i].id)
	   
		
		}
	
	}
	
	/*****
	 * 		
	 * @param documentJson
	 * @return la liste de arrêtes d'une ligne choisi 
	 */
	void parserArretsLigne(def documentJson) {
		JsonSlurper sluuuurp = new JsonSlurper()
		def jsonParse = sluuuurp.parseText(documentJson.toString())
		
		/*Map jsonResult = (Map) jsonParse;
		Map lines = (Map) jsonResult.get("stopAreas");
		
		List arr = (List) lines.get("stopArea");
		
		for(int i=0;i<arr.size();i++)
		{
			
			System.out.println(" Destination :"+arr[i].name+ "id: "+arr[i].id)
	   
		
		}*/
		Map jsonResult = (Map) jsonParse;
		Map lines = (Map) jsonResult.get("physicalStops");
		List arr = (List) lines.get("physicalStop");
		for(int i=0;i<arr.size();i++)
		{
			System.out.println(" Destination :"+arr[i].name+ "id: "+arr[i].id+"x"+x+"y"+y)
		}
	}
	
	
	/***
	 * l'objectif est de recuperer des informations concernant les prochains passage par un arrêt choisi par l'utilisateur 
	 * @param documentJson
	 * @return le prochain passage par un arrêt
	 */
	void parserArrets(def documentJson) {
		JsonSlurper sluuuurp = new JsonSlurper()
		def jsonParse = sluuuurp.parseText(documentJson.toString())
		
		Map jsonResult = (Map) jsonParse;
		Map departures = (Map) jsonResult.get("departures");
		
		
		List dept = (List) departures.get("departure");
		
		for(int i=0;i<dept.size();i++)
		{
			
			System.out.println("l'arrêt :"+dept[i].line.name+ " Numéro de bus :"+dept[i].line.shortName+ "prochain passage: "+dept[i].dateTime)
	  
	  
		
		
		}
		
		
		
	} 
	
	
	void parserLatLng(def documentJson) {
		JsonSlurper sluuuurp = new JsonSlurper()
		def jsonParse = sluuuurp.parseText(documentJson.toString())
		
		Map jsonResult = (Map) jsonParse;
		Map departures = (Map) jsonResult.get("physicalStops");
		
		
		List dept = (List) departures.get("physicalStop");
		
		for(int i=0;i<dept.size();i++)
		{
			
			System.out.println("l'arrêt :"+dept[i].name+ " latitude :"+dept[i].x+ "longitude: "+dept[i].y)
	  
	  
		
		
		}
		
		
		
	}

	/********
	 * 
	 * Getters and Setters
	 * 
	 *****/
	
	String getdateTime() {
		dateTime
	}
	
	String getlineName() {
		LineName
	}
	
	String getShortName(){
		ShortName
	}
	String getDestinationName(){
		
	   DestinationName 
	}
	
	
}
