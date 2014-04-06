package ws;

import interfaces.ICouchDbService;

import org.junit.Before;
import org.junit.Test;

import data_types.Line;
import services.CouchDbService;

public class CouchDbServiceTest {
	private ICouchDbService mCouchDbService;

	@Before
	public void setUp() {
		mCouchDbService = new CouchDbService();
	}

	@Test
	public void test() {
		Line line = new Line(1, "");
		System.out.println(mCouchDbService.getLineRatings(line).getLikes());
		mCouchDbService.registerLike(line);
		System.out.println(mCouchDbService.getLineRatings(line).getLikes());
		System.out.println(mCouchDbService.getLineRatings(line).getDislikes());
		mCouchDbService.registerDislike(line);
		System.out.println(mCouchDbService.getLineRatings(line).getDislikes());
	}

}
