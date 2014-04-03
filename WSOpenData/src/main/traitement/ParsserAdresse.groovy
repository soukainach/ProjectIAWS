package main.traitement
import groovy.json.JsonSlurper;
import groovy.json.JsonSlurper.*
import net.sf.json.JSONObject.*
import groovy.json.JsonOutput.*

class ParsserAdresse {

	
	private float longitude
	private float latitude
		
	
	ParsserAdresse() {
		longitude = 0
		latitude = 0
	}
	
	/**
	 *
	 * @param documentJson
	 */
	void parsserAdress(def documentJson) {
		JsonSlurper sluuuurp = new JsonSlurper()
		def jsonParse = sluuuurp.parseText(documentJson.toString())
		
		if (!jsonParse.lon.toString().equals("[]")) {
			longitude = jsonParse.find().lon.toString().replace("[", "").replace("]", "").toFloat()
		}
	
		if (!jsonParse.lat.toString().equals("[]")) {
			latitude = jsonParse.find().lat.toString().replace("[", "").replace("]", "").toFloat()
		}
	
	}
	
	float getLongitude() {
		longitude
	}
	
	float getLatitude() {
		latitude
	}
	
	
}
