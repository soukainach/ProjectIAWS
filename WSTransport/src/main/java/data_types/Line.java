package data_types;

public class Line {
	private final long mId;
	private final String mShortName;
	private final String mFriendlyName;
	
	public Line(long id, String shortName, String friendlyName) {
		mId = id;
		mShortName = shortName;
		mFriendlyName = friendlyName;
	}
	
	public long getId() {
		return mId;
	}
	
	public String getShortName() {
		return mShortName;
	}
	
	public String getFriendlyName() {
		return mFriendlyName;
	}
}
