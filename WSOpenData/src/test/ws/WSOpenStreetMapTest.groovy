package test.ws
import main.ws.*
class WSOpenStreetMapTest extends GroovyTestCase {

	void testDonneesOSM() {
		
		WSOpenStreetMap donTest = new WSOpenStreetMap()
		def retour = donTest.positionOSM("Rue Maurice B�canne","31400","Toulouse")
		println retour
		assertTrue(retour != "Erreur")
	  }
	
	
}
