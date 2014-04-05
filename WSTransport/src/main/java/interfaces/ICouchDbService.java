package interfaces;

import data_types.Line;
import data_types.RatedLine;

public interface ICouchDbService {
	RatedLine getLineRatings(Line line);
	void registerLike(Line line);
	void registerDislike(Line line);
	
}