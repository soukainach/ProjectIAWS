package main.traitement;

import groovy.json.JsonSlurper;
import groovy.json.JsonSlurper.*
import net.sf.json.JSONObject.*
import groovy.json.JsonOutput.*

/**
 * Cette classe  va parser le résultat Json retourné par le web service tisseo et permet  de
 * récupérer la liste 
 */
public class ParserInformationsDepart {

	private String ligne
	private String nomDestination
	private String dateDepart
	private String ville
	
	ParserInformationsDepart(){
		
		ligne = ""
		nomDestination = ""
		dateDepart = ""
		ville = ""
		
	}
	
	
	void parserPosition(def documentJson) {
		JsonSlurper jslurp = new JsonSlurper()
		def jsonParse = jslurp.parseText(documentJson.toString())
		def arretsList = new ArrayList<ParserInformationsDepart>()
		
		jslurp.each {
			aArret ->
			  def arret = new ParserInformationsDepart()
			 
		  }
		
		arretsList.each {aUser -> println aUser}
		
		
	}
	
	
	
}
