package main.Donnees

import main.ws.OpenData
import main.traitement.ParserInformations

class ArretsPaulSab {

	private String dateTime
	private String LineName
	private String ShortName
	private String DestinationName
	
	
	private static List<ArretsPaulSab> listeArrets = new ArrayList<ArretsPaulSab>()
	
	
	/*****
	 * creer une nouvelle Arret
	 * 
	 */
	ArretsPaulSab() {
		
		dateTime = ""
		LineName= ""
		ShortName = ""
		 DestinationName =""
	}
  /* 
	boolean recupererPosition(String adresse,int codePostal,String ville) {
		OpenData tisseo= new OpenData()
		ParserInformations parser = new ParserInformations()
		parser.parserArrets(tisseo.ListeLignes()
	
		// Si les informations de arrets n'ont pas pu être récupérées
		if (parser.getLatitude().equals(new Float("0")) && parser.getLongitude().equals(new Float("0"))) {
			return false
		}
		
		//Sinon, on enregistre les informations de arrets 
		//Et on valide !
		latitude = parser.getLatitude()
		longitude = parser.getLongitude()
		true 
	}
	

	*/
	
	
		 
}
