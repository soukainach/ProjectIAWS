package interfaces;

import java.util.List;

import data_types.BikeStation;

public interface IJcDecauxService {
	List<BikeStation> getBikeStations();
	int getAvailableBikes(BikeStation bikeStation);
}
