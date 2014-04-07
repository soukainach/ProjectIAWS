package ws;

import java.util.ArrayList;
import java.util.List;

import data_types.Line;
import data_types.StopPoint;
import interfaces.ITisseoService;

public class TisseoServiceDummy implements ITisseoService {

	public List<Line> getLines() {
		List<Line> ret = new ArrayList<Line>();
		ret.add(new Line(1, "ABC", "Ligne lambda"));
		ret.add(new Line(2, "DEF", "Ligne lambda 2"));
		return ret;
	}

	public List<StopPoint> getStopPoints(Line line) {
		if (line.getId() != 1) {
			return new ArrayList<StopPoint>();
		}
		List<StopPoint> ret = new ArrayList<StopPoint>();
		ret.add(new StopPoint(1, "ABC", "Point d'arrêt 1"));
		ret.add(new StopPoint(2, "ABC", "Point d'arrêt 2"));
		return ret;
	}

	public String getNextStop(Line line, StopPoint stopPoint) {
		return "2002-05-30T09:30:10.5";
	}
}