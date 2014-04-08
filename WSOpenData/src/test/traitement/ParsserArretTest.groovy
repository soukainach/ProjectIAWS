package test.traitement

import groovy.util.GroovyTestCase
import main.traitement.ParserInformations
import main.ws.OpenData

class ParsserArretTest extends GroovyTestCase {

	
	
	/****
	 * test la liste de lignes récuperer
	 * 
	 *****/
	
	void testParser() {
		
		OpenData arretsTest = new OpenData()
		
		def docJsonTest = arretsTest.LignesTisseo()
		
		def parseur = new ParserInformations()
		parseur.parserLignes(docJsonTest)
		
		
	}
	void testParserLngLat() {
		
		OpenData arretsTest = new OpenData()
		
		def docJsonTest = arretsTest.LatLngPointArea()
		
		def parseur = new ParserInformations()
		parseur.parserLatLng(docJsonTest)
		
		
	}
	
	/****
	 * 
	 * la fonction qui permet de recuperer la liste des arrêts d'une ligne choisi 
	 * 
	 ****/
	void testParserArretsLigne() {
		
		OpenData arretsligneTest = new OpenData()
		def docJsonTest = arretsligneTest.ListeArretsLigne(11821949021891694)
		def parseur = new ParserInformations()
		parseur.parserArretsLigne(docJsonTest)
		
		
	}
	
	/****
	 * test parsser prochain passage
	 * 
	 ****/
	void testPassage()
	{
		OpenData passageArretLigneTest = new OpenData()
		def docJsonTest = passageArretLigneTest.ListeLignes(1970324837184714)
		def parseur = new ParserInformations()
		parseur.parserArrets(docJsonTest)
	}
	
}
