package ws;

import static org.junit.Assert.assertTrue;
import interfaces.ICouchDbService;

import org.junit.Before;
import org.junit.Test;

import data_types.Line;
import data_types.RatedLine;
import services.CouchDbService;

public class CouchDbServiceTest {
	private ICouchDbService mCouchDbService;

	@Before
	public void setUp() {
		mCouchDbService = new CouchDbService();
	}

	@Test
	public void test() {
		Line line = new Line(3, "ABC", "");
		RatedLine ratedLine = mCouchDbService.getLineRatings(line);
		long likes = ratedLine.getLikes();
		long dislikes = ratedLine.getDislikes();
		mCouchDbService.registerLike(line);
		mCouchDbService.registerDislike(line);
		assertTrue(likes + 1 == mCouchDbService.getLineRatings(line).getLikes());
		assertTrue(dislikes + 1 == mCouchDbService.getLineRatings(line).getDislikes());
	}
}