package ws;

import java.util.ArrayList;
import java.util.List;

import data_types.BikeStation;
import interfaces.IJcDecauxService;

public class JcDecauxServiceDummy implements IJcDecauxService {

	public List<BikeStation> getBikeStations() {
		List<BikeStation> ret = new ArrayList<BikeStation>();
		ret.add(new BikeStation(1, "random contract", "Random station"));
		ret.add(new BikeStation(2, "random contract", "Another random station"));
		return ret;
	}

	public int getAvailableBikes(BikeStation bikeStation) {
		// It would be a shame if bikeStation was null
		bikeStation.getNumber();
		return 1;
	}

}