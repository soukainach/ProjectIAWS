package test.ws
import main.ws.*
class WSOpenStreetMapTest extends GroovyTestCase {

	void testDonneesOSM() {
		
		WSOpenStreetMap donTest = new WSOpenStreetMap()
		def retour = donTest.positionOSM("Rue Jean Jaurès","31140","Aucamville")
		println retour
		assertTrue(retour != "Erreur")
	  }
	
	
}
