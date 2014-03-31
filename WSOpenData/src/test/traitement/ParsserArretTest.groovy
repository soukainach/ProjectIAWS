package test.traitement

import groovy.util.GroovyTestCase
import main.traitement.ParserInformations
import main.ws.OpenData

class ParsserArretTest extends GroovyTestCase {

	
	void testParser() {
		
		OpenData arretsTest = new OpenData()
		
		def docJsonTest = arretsTest.ListeLignes()
		
		def parseur = new ParserInformations()
		parseur.parserArrets(docJsonTest)
		
		//assert list.get(2) == 7
		//assertEquals(parseur.getlineName(),"Ramonville Métro".toFloat())
	}
}
