package services;

import junit.framework.TestCase;


public class CouchDbTest extends TestCase{
	void couchTest() throws Exception
	{
		
	
	CouchDBServices couch= new CouchDBServices();
	couch.sendPost();
		
	}
}
