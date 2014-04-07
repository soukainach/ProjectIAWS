package data_types;

public class StopPoint {
	private final long mId;
	private final String mFriendlyName;
	private final String mDirection;
	
	public StopPoint(long id, String direction, String friendlyName) {
		mId = id;
		mDirection = direction;
		mFriendlyName = friendlyName;
	}
	
	public long getId() {
		return mId;
	}
	
	public String getDirection() {
		return mDirection;
	}
	
	public String getFriendlyName() {
		return mFriendlyName;
	}
}
