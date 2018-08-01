package com.decathlon.pointcalculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.decathlon.beans.Athlete;

/**
 * 
 * This class has all the methods to calculate the Rank for an Athlete.
 *  
 * @author Brajesh Chandak
 *
 */
public class RankCalculator {
	
	/**
	 * 
	 * Below mehod calculates and set Rank or athletes with different Points.
	 *
	 */

	public void calculateRank(List<Athlete> athletes) {
		if (athletes.size() == 1) {
			athletes.get(0).setRanking("1");
			return;
		}
		Collections.sort(athletes);
		Collections.reverse(athletes);
		for (int i = 0, j = 1; i < athletes.size(); i++, j++) {
			athletes.get(i).setRanking(Integer.toString(j));
		}
		
		calculateRankForSamePoints(athletes);
	}
	
	/**
	 * 
	 * Below method calculates Rank for athletes with same points.
	 *
	 */

	private void calculateRankForSamePoints(List<Athlete> athletes) {
		if (athletes.size() < 2) {
			return;
		}
		List<Athlete> list = new ArrayList<Athlete>();
		int foundSame = 0;
		int score1 = 0;
		int score2 = 0;
		for (int i = 0, j = 1; j < athletes.size(); i++, j++) {
			Athlete athlete1 = athletes.get(i);
			Athlete athlete2 = athletes.get(j);
			score1 = athlete1.getTotalPoints();
			score2 = athlete2.getTotalPoints();
			if (score1 == score2) {
				list.add(athletes.get(i));
				list.add(athletes.get(j));

				foundSame++;
				if (j == athletes.size() - 1) {
					writeUpdatedRanks(list);
					list = new ArrayList<Athlete>();
					foundSame = 0;
				}
			} else {
				if (foundSame > 0) {
					writeUpdatedRanks(list);
					list = new ArrayList<Athlete>();
					foundSame = 0;
				}
			}
		}
	}
	
	/**
	 * 
	 * Below method sets the ranks for athletes with same points.
	 *  
	 *
	 */

	private void writeUpdatedRanks(List<Athlete> athletes) {
		Set<Athlete> set = new LinkedHashSet<Athlete>();
		for (Athlete athlete : athletes) {
			set.add(athlete);
		}
		StringBuilder builder = new StringBuilder();
		for (Athlete a : set) {
			builder.append(a.getRanking()).append("-");
		}
		String updatedRank = builder.substring(0, builder.length() - 1);
		for (Athlete a : athletes) {
			a.setRanking(updatedRank);
		}
	}
}
