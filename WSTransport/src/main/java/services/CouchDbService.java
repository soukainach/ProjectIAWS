package services;

import java.util.HashMap;
import java.util.Map;

import org.jcouchdb.db.Database;

import data_types.Line;
import data_types.RatedLine;
import interfaces.ICouchDbService;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class CouchDbService implements ICouchDbService {
	private static final String DATABASE_HOST = "localhost";
	private static final String DATABASE_NAME = "iaws_ratings";

	private Database mDb;

	public RatedLine getLineRatings(Line line) {
		Database db = getDatabase();
		Map res = db.getDocument(Map.class, "" + line.getId());
		return new RatedLine(line, (Long) res.get("likes"),
				(Long) res.get("dislikes"));
	}

	public void registerLike(Line line) {
		Database db = getDatabase();
		Map res = db.getDocument(Map.class, "" + line.getId());
		if (res == null) {
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
		Map res = db.getDocument(Map.class, "" + line.getId());
		if (res == null) {
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