package data_types;

public class RatedLine extends Line {
	private final int mLikes;
	private final int mDislikes;

	public RatedLine(Line line, int likes, int dislikes) {
		super(line.getId(), line.getFriendlyName());
		mLikes = likes;
		mDislikes = dislikes;
	}
	
	public int getLikes() {
		return mLikes;
	}
	
	public int getDislikes() {
		return mDislikes;
	}
}