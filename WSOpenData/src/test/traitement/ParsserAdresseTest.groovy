package test.traitement

import groovy.util.GroovyTestCase
import main.traitement.ParsserAdresse
import main.ws.WSOpenStreetMap
import main.traitement.DistanceDeplacement

class ParsserAdresseTest extends GroovyTestCase {

	
	
	void testParser() {
		
		WSOpenStreetMap positionTest = new WSOpenStreetMap()
		def docJsonTest = positionTest.positionOSM("rue maurice bécanne","31400","Toulouse")
		
		def parseur = new ParsserAdresse()
		parseur.parsserAdress(docJsonTest)
		println parseur.getLatitude()
		println parseur.getLongitude()
		
	}
	void testDistance()
	{
		DistanceDeplacement tt= new DistanceDeplacement(43.563602,1.4583148);
		double distance=tt.distance(43.5610851,1.4626835);
		System.out.println(" la distance entre paul sabatier et chez moi: "+distance);
	}
}
