package data_types;

public class Line {
	private final long mId;
	private final String mFriendlyName;
	
	public Line(long id, String friendlyName) {
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
