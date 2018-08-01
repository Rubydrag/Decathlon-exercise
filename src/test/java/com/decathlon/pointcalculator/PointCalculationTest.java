/**
 * 
 */
package com.decathlon.pointcalculator;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.decathlon.beans.Athlete;
import com.decathlon.beans.FieldEventsResult;
import com.decathlon.beans.TrackEventsResult;

/**
 * @author Brajesh Chandak
 *
 */
public class PointCalculationTest {

	List<Athlete> athletes = new ArrayList<Athlete>();
	Athlete athlete;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		athlete = new Athlete();
		athlete.setName("Siim Susi");
		TrackEventsResult trackEventsResult = new TrackEventsResult();
		FieldEventsResult fieldEventsResult = new FieldEventsResult();
		trackEventsResult.setRun100M(12.61f);
		fieldEventsResult.setLongJump(5.00f);
		fieldEventsResult.setShotPutThrow(9.22f);
		fieldEventsResult.setHighJump(1.50f);
		trackEventsResult.setRun400M(60.39f);
		trackEventsResult.setRun110MHurdles(16.43f);
		fieldEventsResult.setDiscusThrow(21.60f);
		fieldEventsResult.setPoleVaultJump(2.60f);
		fieldEventsResult.setJavelinThrow(35.81f);
		trackEventsResult.setRun1500M(325.72f);
		athlete.setTrackEventsResult(trackEventsResult);
		athlete.setFieldEventsResult(fieldEventsResult);
		athletes.add(athlete);

	}

	/**
	 * Test method for
	 * {@link com.decathlon.pointcalculator.PointsCalculation#calculateTotalPointsForAthletes(java.util.List)}.
	 */
	@Test
	public final void testCalculateTotalPointsForAthletes() {
		List<Athlete> athletes = PointsCalculation.calculateTotalPointsForAthletes(this.athletes);
		assertNotNull(athletes);
		assertTrue(4200 == athletes.get(0).getTotalPoints());

	}

}
