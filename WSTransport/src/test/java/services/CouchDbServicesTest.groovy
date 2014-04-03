package services

import groovy.util.GroovyTestCase;
import services.CouchDbService

class CouchDbServicesTest extends GroovyTestCase  {

	
	
void createBaseTest()
{
	CouchDbService test=new CouchDbService()
	def retour=test.getData()
	println retour
		
}
	
	
	
	
	
	
	
	
	
	
}
