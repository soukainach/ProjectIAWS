package interfaces;

import java.util.List;

import data_types.Line;
import data_types.StopPoint;

public interface ITisseoService {
	List<Line> getLines();
	List<StopPoint> getStopPoints(Line line);
	String getNextStop(Line line, StopPoint stopPoint);
}