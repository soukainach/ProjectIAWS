package data_types;

public class RatedLine extends Line {
	private final long mLikes;
	private final long mDislikes;

	public RatedLine(Line line, long likes, long dislikes) {
		super(line.getId(), line.getFriendlyName());
		mLikes = likes;
		mDislikes = dislikes;
	}
	
	public long getLikes() {
		return mLikes;
	}
	
	public long getDislikes() {
		return mDislikes;
	}
}