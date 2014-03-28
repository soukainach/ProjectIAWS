package test.ws
import main.ws.*

class WSOpenDataTEST extends GroovyTestCase {
	
	void testListeLigne() {
		OpenData ligneTest = new OpenData()
		def retour = ligneTest.ListeLignes()
		println retour
		assertTrue(retour != "Erreur")
	  }
	
	/******
	 * Tester listes de stations de velos de Toulouse
	 */
	void testStationVelos() {
		OpenData stationsTest = new OpenData()
		def retour = stationsTest.getJsonStation(195)
		println retour
		assertTrue(retour != "Erreur")
	  }
	
}
