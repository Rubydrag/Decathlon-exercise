/**
 * 
 */
package com.decathlon.pointcalculator;

import java.util.ArrayList;
import java.util.List;

import com.decathlon.beans.Athlete;

/**
 * 
 * This class has all the methods to calculate points for TrackEvents and Field
 * Events
 * 
 * @author Brajesh Chandak
 *
 */
public class PointsCalculation {

	/**
	 * 
	 * Calculates scored points on passed TrackEvent and completion time.
	 *
	 */
	private static int calcPointsPerTrackEvent(GameType eventName, float completionTime) {
		int score = 0;
		if (completionTime != 0) {
			score = (int) Math.floor(PointsCalculatorRefTable.COLUMN_A.get(eventName)
					* Math.pow((PointsCalculatorRefTable.COLUMN_B.get(eventName) - completionTime),
							PointsCalculatorRefTable.COLUMN_C.get(eventName)));
		}
		return score;

	}

	/**
	 * 
	 * Calculates scored points on passed FieldEvent and completion time.
	 *
	 */
	private static int calcPointsPerFieldEvent(GameType eventName, float completion) {
		int score = 0;
		if (completion != 0) {
			if (eventName.equals(GameType.FIELD_LONG_JUMP) || eventName.equals(GameType.FIELD_HIGH_JUMP)
					|| eventName.equals(GameType.FIELD_POLE_JUMP)) {

				double completionDistanceInCM = (double) (completion * 100);
				score = (int) Math.floor(PointsCalculatorRefTable.COLUMN_A.get(eventName)
						* Math.pow((int) (completionDistanceInCM - PointsCalculatorRefTable.COLUMN_B.get(eventName)),
								PointsCalculatorRefTable.COLUMN_C.get(eventName)));

			} else {
				score = (int) Math.floor(PointsCalculatorRefTable.COLUMN_A.get(eventName)
						* Math.pow(completion - PointsCalculatorRefTable.COLUMN_B.get(eventName),
								PointsCalculatorRefTable.COLUMN_C.get(eventName)));

			}

		}

		return score;

	}

	/**
	 * 
	 * Calculates total points scored by an athlete for TrackGames.
	 *
	 */
	private static int calcTotalPointsForTrackEvents(Athlete athlete) {
		int trackScore = 0;
		trackScore += calcPointsPerTrackEvent(GameType.TRACK_100M, athlete.getTrackEventsResult().getRun100M());
		trackScore += calcPointsPerTrackEvent(GameType.TRACK_110M, athlete.getTrackEventsResult().getRun110MHurdles());
		trackScore += calcPointsPerTrackEvent(GameType.TRACK_1500M, athlete.getTrackEventsResult().getRun1500M());
		trackScore += calcPointsPerTrackEvent(GameType.TRACK_400M, athlete.getTrackEventsResult().getRun400M());
		return trackScore;

	}

	/**
	 * 
	 * Calculates total points scored by an athlete for FieldGames.
	 *
	 */
	private static int calcTotalPointsForFieldEvents(Athlete athlete) {
		int fieldScore = 0;
		fieldScore += calcPointsPerFieldEvent(GameType.FIELD_DISCUS_THROW,
				athlete.getFieldEventsResult().getDiscusThrow());
		fieldScore += calcPointsPerFieldEvent(GameType.FIELD_HIGH_JUMP, athlete.getFieldEventsResult().getHighJump());
		fieldScore += calcPointsPerFieldEvent(GameType.FIELD_JAVELIN_THROW,
				athlete.getFieldEventsResult().getJavelinThrow());
		fieldScore += calcPointsPerFieldEvent(GameType.FIELD_LONG_JUMP, athlete.getFieldEventsResult().getLongJump());
		fieldScore += calcPointsPerFieldEvent(GameType.FIELD_POLE_JUMP,
				athlete.getFieldEventsResult().getPoleVaultJump());
		fieldScore += calcPointsPerFieldEvent(GameType.FIELD_SHOT_PUT,
				athlete.getFieldEventsResult().getShotPutThrow());
		return fieldScore;

	}

	/**
	 * 
	 * Calculates Total points for athletes.
	 *
	 */
	public static List<Athlete> calculateTotalPointsForAthletes(List<Athlete> athletes) {
		// TODO Auto-generated method stub
		List<Athlete> newAtheletes = new ArrayList<Athlete>();
		for (Athlete athlete : athletes) {
			int totalPoints = 0;
			totalPoints += calcTotalPointsForTrackEvents(athlete);
			totalPoints += calcTotalPointsForFieldEvents(athlete);
			athlete.setTotalPoints(totalPoints);
			newAtheletes.add(athlete);
		}
		RankCalculator rankCalculator = new RankCalculator();
		rankCalculator.calculateRank(newAtheletes);

		return newAtheletes;

	}

}
