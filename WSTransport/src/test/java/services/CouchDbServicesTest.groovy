package services

import groovy.util.GroovyTestCase;
import services.CouchDbService

class CouchDbServicesTest extends GroovyTestCase  {

	
	
 void testgetLikes()
		 {
			
			CouchDbService data = new CouchDbService()
			def retour = data.getDataLike()
			println retour	
			assertTrue(retour != "Erreur")
		  }
	
	
	
	
	
	
	
	
	
	
}
