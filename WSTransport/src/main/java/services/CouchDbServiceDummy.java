package services;

import org.springframework.stereotype.Service;

import data_types.Line;
import data_types.RatedLine;
import interfaces.ICouchDbService;

@Service
public class CouchDbServiceDummy implements ICouchDbService {

	public RatedLine getLineRatings(Line line) {
		return new RatedLine(line, 1, 0);
	}

	public void registerLike(Line line) {
	}

	public void registerDislike(Line line) {
	}

}