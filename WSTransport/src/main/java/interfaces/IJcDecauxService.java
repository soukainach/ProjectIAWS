package interfaces;

import java.util.List;

import data_types.BikeStation;
import data_types.BikesStations;

public interface IJcDecauxService {
	List<BikeStation> getBikeStations();
	int getAvailableBikes(BikeStation bikeStation);
	double getBikeLatLng(BikesStations bikesStations);
	
	
}
