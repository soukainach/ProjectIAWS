package data_types;

public class StopPoint {
	private final int mId;
	private final String mFriendlyName;
	
	public StopPoint(int id, String friendlyName) {
		mId = id;
		mFriendlyName = friendlyName;
	}
	
	public int getId() {
		return mId;
	}
	
	public String getFriendlyName() {
		return mFriendlyName;
	}
}
