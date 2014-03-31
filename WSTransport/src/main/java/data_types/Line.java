package data_types;

public class Line {
	private final int mId;
	private final String mFriendlyName;
	
	public Line(int id, String friendlyName) {
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
