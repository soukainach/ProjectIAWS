package test.ws
import main.ws.*
import main.traitement.ParserBikeStations
import main.ws.OpenDataProchainsPassages

class WSOpenDataTEST extends GroovyTestCase {
	

	/****
	 * test sur le prochain passage
	 * 
	 ****/
	
	
	void testListeLigne() {
		OpenData ligneTest = new OpenData()
		def retour = ligneTest.ListeLignes(1970324837184714)
		println retour
	
		assertTrue(retour != "Erreur")
	  }
	/****
	 * test sur le velo dispo 
	 * 
	 ***/
	void testJsonVelo()
	{
		ParserBikeStations VeloTest = new ParserBikeStations()
		def retour = VeloTest.sendGet(227)
		//println retour
		assertTrue(retour != "Erreur")
	}
	
	/****
	 * 
	 * 	test sur lignes de reseau de tisseo
	 * 
	 ****/
	void testLigneTisseo()
	{
		OpenData ligneTest = new OpenData()
		def retour = ligneTest.LignesTisseo()
		//println retour
		assertTrue(retour != "Erreur")
	}

	/*****
	 * test sur les arrete d'une ligne choisi
	 *
	 *****/
		
		void testListeArretsLigne()
		 {
			//OpenDataProchainsPassages ArretsligneTest = new OpenDataProchainsPassages()
			 OpenData ligneTestA = new OpenData()
			def retour = ligneTestA.ListeArretsLigne(11821949021891694)
			//println retour
		
			assertTrue(retour != "Erreur")
		  }
		
		
		
	
}
