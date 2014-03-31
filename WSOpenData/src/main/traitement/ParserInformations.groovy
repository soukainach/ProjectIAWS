package main.traitement;

import groovy.json.JsonSlurper;
import groovy.json.JsonSlurper.*
import net.sf.json.JSONObject.*
import groovy.json.JsonOutput.*
import java.util.List;
import java.util.Map;

/**
 * Cette classe  va parser le résultat Json retourné par le web service tisseo et permet  de
 * récupérer la liste 
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
	/***
	 * 
	 * @param documentJson
	 */
	void parserArrets(def documentJson) {
		JsonSlurper sluuuurp = new JsonSlurper()
		def jsonParse = sluuuurp.parseText(documentJson.toString())
		
		Map jsonResult = (Map) jsonParse;
		Map departures = (Map) jsonResult.get("departures");
		
		List dept = (List) departures.get("departure");
		
		for(int i=0;i<dept.size();i++)
		{
			
			System.out.println("la ligne :"+dept[i].line.name+ " Numéro de bus :"+dept[i].line.shortName)
	   // println ("la ligne : " +dept[i].line.name , " numéro de bus :" +dept[i].line.)
	//	println dept[i].dateTime 
	  
		
		
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
