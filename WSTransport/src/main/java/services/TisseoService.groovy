package services

import java.util.List;

import org.springframework.stereotype.Service;

import data_types.Line;
import data_types.StopPoint;
import groovy.json.JsonSlurper
import groovyx.net.http.HTTPBuilder
import interfaces.ITisseoService;

@Service
class TisseoService implements ITisseoService {

	public List<Line> getLines() {
		def jsonLines = linesRequest();
		return parseLines(jsonLines);
	}

	public List<StopPoint> getStopPoints(Line line) {
		def stopPoints = stopPointsRequest(line.getId());
		return parseStopPoints(stopPoints);
	}

	public String getNextStop(Line line, StopPoint stopPoint) {
		def stopTimes = stopTimesRequest;
		return parseStopTimes(stopTimes);
	}

	private def linesRequest() {
		def retourJson = "Erreur"
		def adresseServeur = new HTTPBuilder("http://pt.data.tisseo.fr")
		def path = '/linesList?format=json&network=Tisséo&key=a03561f2fd10641d96fb8188d209414d8'


		//Get request
		adresseServeur.request(Method.GET, JSON) {

			uri.path = path

			// success response handler
			response.success = { resp, json ->
				retourJson = json
			}

			// failure response handler
			response.failure = { resp -> println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}" }
		}

		retourJson
	}

	private List<Line> parseLines(def documentJson) {
		JsonSlurper sluuuurp = new JsonSlurper()
		def jsonParse = sluuuurp.parseText(documentJson.toString())

		Map jsonResult = (Map) jsonParse;
		Map lines = (Map) jsonResult.get("lines")

		List lig = (List) lines.get("line")

		List<Line> ret = [];

		for(int i=0;i<lig.size();i++)
		{
			Line l = new Line(lig[i].id, lig[i].name);
			ret.add(l);
		}

		return ret;
	}

	private def stopPointsRequest(def lineid)
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
			response.failure = { resp -> println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}" }
		}

		retourJson
	}

	private List<StopPoint> parseStopPoints(def documentJson) {
		JsonSlurper sluuuurp = new JsonSlurper()
		def jsonParse = sluuuurp.parseText(documentJson.toString())

		Map jsonResult = (Map) jsonParse;
		Map lines = (Map) jsonResult.get("stopAreas");

		List arr = (List) lines.get("stopArea");

		List<StopPoint> ret = [];

		for(int i=0;i<arr.size();i++)
		{
			StopPoint stopPoint = new StopPoint(arr[i].id, arr[i].name);
		}

		return ret;
	}

	def stopTimesRequest(def stopId) {

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
			response.failure = { resp -> println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}" }
		}

		retourJson
	}

	String parseStopTimes(def documentJson) {
		JsonSlurper sluuuurp = new JsonSlurper()
		def jsonParse = sluuuurp.parseText(documentJson.toString())

		Map jsonResult = (Map) jsonParse;
		Map departures = (Map) jsonResult.get("departures");


		List dept = (List) departures.get("departure");

		String ret;

		if(dept.size() < 1) {
			return "No stop in the short future";
		}

		return dept[0].dateTime;
	}
}