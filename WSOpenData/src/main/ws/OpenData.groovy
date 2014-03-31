package main.ws

import javax.net.ssl.X509TrustManager
import javax.net.ssl.SSLContext
import java.security.cert.X509Certificate
import javax.net.ssl.TrustManager
import java.security.SecureRandom
import org.apache.http.conn.ssl.SSLSocketFactory
import org.apache.http.conn.scheme.Scheme
import org.apache.http.conn.scheme.SchemeRegistry
import groovyx.net.http.*
import static groovyx.net.http.ContentType.JSON

/****
 * 
 * 
 * @author pc
 *  Dans cette partie on va commencer par la consommation d'un web service existant "Open Data Tisséo"
 *  qui va nous permettre de récupérer des informations sur 
 */

class OpenData {
	
	

/********
 * 
 * retourner des informations concernant les coordonnés XY et les prochains arrêtes 
 * 
 *******/
	def ListeLignes(Integer id) {
		
		  def retourJson = "Erreur"
		  def adresseServeur = new HTTPBuilder("http://pt.data.tisseo.fr")
		  
		  def path= 'departureBoard?stopPointId=1970324837185012&key=a03561f2fd10641d96fb8188d209414d8&format=json'
		 
		  
		  //Get request
		  adresseServeur.request(Method.GET, JSON) {
		  
			  uri.path = path
			
			  // success response handler
			  response.success = { resp, json ->
				  retourJson = json
			  }
			
			  // failure response handler 
			  response.failure = { resp ->
				  println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
			  }
		  }
		 
		  retourJson
	  }
	
	/***
	 * 
	 * @param number
	 * @return une station de velo a partir de son numéro
	 */
	
	def getJsonStation(def number) {
		def retourJson = null
			 
		  def adresseServeur = new HTTPBuilder("https://api.jcdecaux.com")
		 
		   adresseServeur.encoderRegistry = new EncoderRegistry(charset: "utf-8")
		  
	   
		   //=== SSL UNSECURE CERTIFICATE ===
	  
		   def sslContext = SSLContext.getInstance("SSL")
		   sslContext.init(null, [new X509TrustManager() {
			   public X509Certificate[] getAcceptedIssuers() {null }
	   
			   public void checkClientTrusted(X509Certificate[] certs, String authType) { }
	   
			   public void checkServerTrusted(X509Certificate[] certs, String authType) { }
		   }] as TrustManager[], new SecureRandom())
	   
		   //SSLSocketFactory sf = new org.apache.http.conn.ssl.SSLSocketFactory(sslContext, org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)
	   
		   SSLSocketFactory sf = new org.apache.http.conn.ssl.SSLSocketFactory(sslContext)
		   sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)
		   def httpsScheme = new Scheme("https", sf, 443)
		   adresseServeur.client.connectionManager.schemeRegistry.register(httpsScheme)
		 
		 
		  def path='/vls/v1/stations/${number}?contract=Toulouse&apiKey=969f71318582304067419dfddc9ea08b16d567f68'
		  //Get request
		  adresseServeur.request(Method.GET, ContentType.JSON) {
		  
			  uri.path = path
			  
			  headers.Accept = 'application/json'
			  
			  // success response handler
			  response.success = { resp, json ->
				  retourJson = json
			  }
			
			  // failure response handler 
			  response.failure = { resp ->
				  println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
			  }
		  }
		 
		  retourJson
		
	  }
	
	
	
	
}
