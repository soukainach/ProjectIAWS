package services;

import java.util.HashMap;
import java.util.Map;

import org.jcouchdb.db.Database;

import data_types.Line;
import data_types.RatedLine;
import interfaces.ICouchDbService;

/**
 * This implementation assumes that the database has already been created. If
 * not, create a database named DATABASE_NAME with futon. We also assume that
 * the database is not corrupt, else cast exceptions can be thrown (we do not
 * typecheck at all). Concurrent modifications could also throw an exception.
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class CouchDbService implements ICouchDbService {
	private static final String DATABASE_HOST = "localhost";
	private static final String DATABASE_NAME = "iaws_ratings";

	private Database mDb;

	public RatedLine getLineRatings(Line line) {
		Database db = getDatabase();
		Map res;
		try {
			res = db.getDocument(Map.class, "" + line.getId());
		} catch (Exception e) {
			return new RatedLine(line, 0, 0);
		}
		return new RatedLine(line, (Long) res.get("likes"),
				(Long) res.get("dislikes"));
	}

	public void registerLike(Line line) {
		Database db = getDatabase();
		Map res;
		try {
			res = db.getDocument(Map.class, "" + line.getId());
		} catch (Exception e) {
			res = new HashMap();
		}
		Long likes = (Long) res.get("likes");
		if (likes == null) {
			likes = 0L;
		}
		Long dislikes = (Long) res.get("dislikes");
		if (dislikes == null) {
			dislikes = 0L;
		}
		likes++;
		res.put("_id", "" + line.getId());
		res.put("likes", likes);
		res.put("dislikes", dislikes);
		db.createOrUpdateDocument(res);
	}

	public void registerDislike(Line line) {
		Database db = getDatabase();
		Map res;
		try {
			res = db.getDocument(Map.class, "" + line.getId());
		} catch (Exception e) {
			res = new HashMap();
		}
		Long likes = (Long) res.get("likes");
		if (likes == null) {
			likes = 0L;
		}
		Long dislikes = (Long) res.get("dislikes");
		if (dislikes == null) {
			dislikes = 0L;
		}
		dislikes++;
		res.put("_id", "" + line.getId());
		res.put("likes", likes);
		res.put("dislikes", dislikes);
		db.createOrUpdateDocument(res);
	}

	private Database getDatabase() {
		if (mDb == null) {
			mDb = new Database(DATABASE_HOST, DATABASE_NAME);
		}
		return mDb;
	}
}