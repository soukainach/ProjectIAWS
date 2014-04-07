package data_types;
public class BikeStation {
	private final int mNumber;
	private final String mContract;
	private final String mFriendlyName;

	public BikeStation(int number, String contract, String friendlyName) {
		mNumber = number;
		mContract = contract;
		mFriendlyName = friendlyName;
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
}
