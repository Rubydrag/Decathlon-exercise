/**
 * 
 */
package com.decathlon.pointcalculator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.decathlon.beans.Athlete;

/**
 * This class is test class for RankCalculator.java
 * @author Brajesh Chandak
 *
 */
public class RankCalculatorTest {
	
	RankCalculator rankCalculator = new RankCalculator();
	Athlete athlete1;
	Athlete athlete2;
	Athlete athlete3;
	Athlete athlete4;
	List<Athlete> athletes = new ArrayList<Athlete>(); 

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		athlete1 = new Athlete();
		athlete1.setName("Siim Susi");
		athlete1.setTotalPoints(2400);
		
		athlete2 = new Athlete();
		athlete2.setName("Beata Kana");
		athlete2.setTotalPoints(3500);
		
		athlete3 = new Athlete();
		athlete3.setName("Jaana Lind");
		athlete3.setTotalPoints(2300);
		
		athlete4 = new Athlete();
		athlete4.setName("Anti Loop");
		athlete4.setTotalPoints(2300);
		
		athletes.add(athlete1);
		athletes.add(athlete2);
		athletes.add(athlete3);
		athletes.add(athlete4);
		
	}

	/**
	 * Test method for {@link com.decathlon.pointcalculator.RankCalculator#calculateRank(java.util.List)}.
	 */
	@Test
	public final void testcalculateRank() {
		rankCalculator.calculateRank(athletes);
		assertTrue("1".equals(athletes.get(0).getRanking()));
		assertTrue("Beata Kana".equals(athletes.get(0).getName()));
		assertTrue("2".equals(athletes.get(1).getRanking()));
		assertTrue("Siim Susi".equals(athletes.get(1).getName()));
	}
	
	/**
	 * Test method for {@link com.decathlon.pointcalculator.RankCalculator#calculateRank(java.util.List)}.
	 */
	@Test
	public final void testCalculateRankForSamePoints() {
		rankCalculator.calculateRank(athletes);
		assertTrue("3-4".equals(athletes.get(2).getRanking()));
		assertTrue("Anti Loop".equals(athletes.get(2).getName()));
		assertTrue("3-4".equals(athletes.get(3).getRanking()));
		assertTrue("Jaana Lind".equals(athletes.get(3).getName()));
	}

}
