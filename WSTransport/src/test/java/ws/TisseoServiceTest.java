package ws;

import java.util.List;

import interfaces.ITisseoService;

import org.junit.Before;
import org.junit.Test;

import data_types.Line;
import data_types.StopPoint;
import services.TisseoService;

public class TisseoServiceTest {
	private ITisseoService mTisseoService;

	@Before
	public void setup() {
		mTisseoService = new TisseoService();
	}

	@Test
	public void test() {
		try {
			Line line = mTisseoService.getLines().get(8);
			List<StopPoint> stopPoints = mTisseoService.getStopPoints(line);
			for (StopPoint stopPoint : stopPoints) {
				System.out.println(stopPoint.getFriendlyName());
			}
			StopPoint stopPoint = stopPoints.get(4);
			System.out.println("StopTime:");
			System.out.println(mTisseoService.getNextStop(null, stopPoint));
		} catch (Exception e) {
			System.out.println("Tisseo test error");
		}
	}

}
