package com.decathlon.beans;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FieldEventsResultTest {
	FieldEventsResult fieldEventsResult;
	private final String[] athlete1 = {"Athlete1", "12.61", "5.00", "9.22", "1.50", "60.39", "16.43", "21.60", "2.60", "35.81", "5.25.72"};
	
	
	@Before
	public void setUp() throws Exception {
		fieldEventsResult = new FieldEventsResult(this.athlete1);
	}
	
	

	@Test
	public void testFieldEventsResult() {
		assertTrue(5.00f==this.fieldEventsResult.getLongJump());
		assertTrue(9.22f==this.fieldEventsResult.getShotPutThrow());
		assertTrue(1.50f==this.fieldEventsResult.getHighJump());
		assertTrue(21.60f==this.fieldEventsResult.getDiscusThrow());
		assertTrue(2.60f==this.fieldEventsResult.getPoleVaultJump());
		assertTrue(35.81f==this.fieldEventsResult.getJavelinThrow());
		

	}


}
