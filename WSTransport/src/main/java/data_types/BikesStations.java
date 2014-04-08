package data_types;

import java.util.List;

public class BikesStations {
	private final int mNumber;
	private final String mContract;
	private final String mFriendlyName;
	private final double mlat;
	private final double mlng;

	public BikesStations(int number, String contract, String friendlyName, double lat, double lng) {
		mNumber = number;
		mContract = contract;
		mFriendlyName = friendlyName;
		mlat = lat;
		mlng = lng;
	}

	public int getNumber() {
		return mNumber;
	}

	public String getContract() {
		return mContract;
	}

	public String getFriendlyName() {
		return mFriendlyName;
	}
	public double getLat() {
		return mlat;
	}
	public double getLng() {
		return mlng;
	}
	/*public static BikeStation getBikeStationByNumberAndContract(int number,
			String contract, List<BikeStation> list) {
		for (BikeStation bikeStation : list) {
			if (bikeStation.mNumber == number
					&& contract.equals(bikeStation.mContract)) {
				return bikeStation;
			}
		}
		return null;
	}*/
}
