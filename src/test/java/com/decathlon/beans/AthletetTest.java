package com.decathlon.beans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AthletetTest {
	Athlete athlete;

	@Before
	public void setUp() throws Exception {
		athlete = new Athlete();
	}

	@Test
	public void testAthlete() {
		assertNull(athlete.getName());
		assertNull(athlete.getFieldEventsResult());
		assertNull(athlete.getTrackEventsResult());
		assertNull(athlete.getRanking());
		assertEquals(0, athlete.getTotalPoints());

	}

	@Test
	public void testGetName() {
		athlete.setName("Brajesh");
		assertTrue("Brajesh".equals(athlete.getName()));
	}

	@Test
	public void testSetName() {
		athlete.setName("Brajesh");
		assertTrue("Brajesh".equals(athlete.getName()));
	}

	@Test
	public void testSetRanking() {
		athlete.setRanking("1");
		assertTrue(athlete.getRanking() == "1");
	}

	@Test
	public void testGetRanking() {
		athlete.setRanking("3");
		assertTrue(athlete.getRanking() == "3");
	}

	@Test
	public void testGetTotalPoints() {
		athlete.setTotalPoints(1000);
		assertTrue(athlete.getTotalPoints() == 1000);
	}

	@Test
	public void testSetTotalPoints() {
		athlete.setTotalPoints(2400);
		assertTrue(athlete.getTotalPoints() == 2400);
	}

	@Test
	public void testGetFieldEventsResult() {
		FieldEventsResult fieldEventsResult = new FieldEventsResult();
		athlete.setFieldEventsResult(fieldEventsResult);
		assertTrue(athlete.getFieldEventsResult() == fieldEventsResult);
	}

	@Test
	public void testSetFieldEventsResult() {
		FieldEventsResult fieldEventsResult = new FieldEventsResult();
		athlete.setFieldEventsResult(fieldEventsResult);
		assertTrue(athlete.getFieldEventsResult() == fieldEventsResult);
	}

	@Test
	public void testGetTrackEventsResult() {
		TrackEventsResult trackEventsResult = new TrackEventsResult();
		athlete.setTrackEventsResult(trackEventsResult);
		assertTrue(athlete.getTrackEventsResult() == trackEventsResult);
	}

	@Test
	public void testSetTrackEventsResult() {
		TrackEventsResult trackEventsResult = new TrackEventsResult();
		athlete.setTrackEventsResult(trackEventsResult);
		assertTrue(athlete.getTrackEventsResult() == trackEventsResult);
	}

	@Test
	public void testCompareTo() {
		try {
			Athlete athlete1 = new Athlete();
			athlete1.setTotalPoints(2000);
			athlete1.setName("Athelete1");

			Athlete athlete2 = new Athlete();
			athlete2.setName("Athelet2");
			athlete2.setTotalPoints(2400);

			Athlete athlete3 = new Athlete();
			athlete3.setName("Athelet3");
			athlete3.setTotalPoints(2000);

			assertEquals(-1, athlete1.compareTo(athlete2));
			assertEquals(1, athlete2.compareTo(athlete3));
			assertEquals(0, athlete1.compareTo(athlete3));
			assertFalse(0 != athlete1.compareTo(athlete3));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
