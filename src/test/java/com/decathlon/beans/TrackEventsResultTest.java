package com.decathlon.beans;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TrackEventsResultTest {
	TrackEventsResult trackEventsResult;
	private final String[] athlete1 = { "Athlete2", "13.04", "4.53", "7,79", "1.55", "64.72", "18.74", "24.20", "2.40",
			"28.20", "6.50.76" };

	@Before
	public void setUp() throws Exception {
		trackEventsResult = new TrackEventsResult(this.athlete1);
	}

	@Test
	public void testTrackEventsResultTest() {
		assertTrue(13.04f == this.trackEventsResult.getRun100M());
		assertTrue(64.72f == this.trackEventsResult.getRun400M());
		assertTrue(18.74f == this.trackEventsResult.getRun110MHurdles());
		assertTrue(410.76f == this.trackEventsResult.getRun1500M());

	}

}
