package ws;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import data_types.Line;
import data_types.StopPoint;
import interfaces.ITisseoService;

public class TisseoServiceDummy implements ITisseoService {

	public List<Line> getLines() {
		List<Line> ret = new ArrayList<Line>();
		ret.add(new Line(1, "Ligne lambda"));
		ret.add(new Line(2, "Ligne lambda 2"));
		return ret;
	}

	public List<StopPoint> getStopPoints() {
		List<StopPoint> ret = new ArrayList<StopPoint>();
		ret.add(new StopPoint(1, "Point d'arrêt 1"));
		ret.add(new StopPoint(2, "Point d'arrêt 2"));
		return ret;
	}

	public List<Line> getLines(StopPoint stopPoint) {
		// TODO Auto-generated method stub
		return null;
	}

	public Calendar getNextStop(Line line, StopPoint stopPoint) {
		// TODO Auto-generated method stub
		return null;
	}

}
