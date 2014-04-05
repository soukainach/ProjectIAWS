package services;

import org.jcouchdb.db.Database;

import data_types.Line;
import data_types.RatedLine;
import interfaces.ICouchDbService;

public class CouchDbService implements ICouchDbService {
	private static final String DATABASE_HOST = "localhost";
	private static final String DATABASE_NAME = "iaws_ratings";

	private Database mDb;

	public RatedLine getLineRatings(Line line) {
		return new RatedLine(line, 0, 0);
	}

	public void registerLike(Line line) {
	}

	public void registerDislike(Line line) {
	}

	private Database getDatabase() {
		if (mDb == null) {
			mDb = new Database(DATABASE_HOST, DATABASE_NAME);
		}
		return mDb;
	}
}