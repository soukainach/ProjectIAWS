package interfaces;

import java.util.Calendar;
import java.util.List;

import data_types.Line;
import data_types.StopPoint;

public interface ITisseoService {
	List<Line> getLines();
	List<Line> getLines(StopPoint stopPoint);
	List<StopPoint> getStopPoints();
	Calendar getNextStop(Line line, StopPoint stopPoint);
}
