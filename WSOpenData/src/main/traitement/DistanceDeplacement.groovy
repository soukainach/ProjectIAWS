package main.traitement

/****
 * 
 * 
 * @author pc
 *
 */

class DistanceDeplacement {

	private float longitude
	private float latitude
	
	
	DistanceDeplacement (float longitude, float latitude) {
		this.latitude = latitude
		this.longitude = longitude
	}
	
	
	
	
	
	
	
	/**
	 * Calcul la distance entre deux coordonnées longitude/latitude
	 * 
	 * @param longitudeCible
	 * @param latitudeCible
	 * @return
	 */
	/*float calcdistance(float longitude2, float latitude2) {
		
		double theDistance = 
		   (Math.sin(Math.toRadians(latitude)) *
			Math.sin(Math.toRadians(latitude2)) +
			Math.cos(Math.toRadians(latitude)) *
			Math.cos(Math.toRadians(latitude2)) *
			Math.cos(Math.toRadians(longitude - longitude2)));

	return new Double((Math.toDegrees(Math.acos(theDistance))) * 111.12).intValue();
		
		
	}*/
	public double distance(double latitude, double longitude) {
		
		double theta = this.longitude - longitude;
		double dist = Math.sin(deg2rad(this.latitude)) * Math.sin(deg2rad(latitude)) +
		Math.cos(deg2rad(this.latitude)) * Math.cos(deg2rad(latitude)) *
		Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist) * 60 * 1.1515;
		
		   dist = dist * 1.609344;
		  
		return (dist);
	  }
	   
	  
	   
	  public static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	  }
	   
	  public static double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	  }
	
	 
}
