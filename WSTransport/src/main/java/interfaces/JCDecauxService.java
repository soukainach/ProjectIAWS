package interfaces;

import java.util.List;

import data_types.BikeStation;

public interface JCDecauxService {
	List<BikeStation> getBikeStations();
	int getAvailableBikes(BikeStation bikeStation);
}
