package data_types;

public class StopPoint {
	private final long mId;
	private final String mFriendlyName;
	
	public StopPoint(long id, String friendlyName) {
		mId = id;
		mFriendlyName = friendlyName;
	}
	
	public long getId() {
		return mId;
	}
	
	public String getFriendlyName() {
		return mFriendlyName;
	}
}
