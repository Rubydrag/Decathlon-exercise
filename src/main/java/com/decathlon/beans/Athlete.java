package com.decathlon.beans;

public class Athlete implements Comparable<Athlete> {
	private String name;
	private String ranking;
	private int totalPoints;
	private TrackEventsResult trackEventsResult;
	private FieldEventsResult fieldEventsResult;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public TrackEventsResult getTrackEventsResult() {
		return trackEventsResult;
	}

	public void setTrackEventsResult(TrackEventsResult trackEventsResult) {
		this.trackEventsResult = trackEventsResult;
	}

	public FieldEventsResult getFieldEventsResult() {
		return fieldEventsResult;
	}

	public void setFieldEventsResult(FieldEventsResult fieldEventsResult) {
		this.fieldEventsResult = fieldEventsResult;
	}

	/**
	 * compares two athletes based on the total points If points are same then
	 * return 0.
	 */
	@Override
	public int compareTo(Athlete athlete) {
		// TODO Auto-generated method stub

		int point1 = this.getTotalPoints();
		int point2 = athlete.getTotalPoints();
		if (point1 > point2) {
			return 1;
		}
		if (point1 < point2) {
			return -1;
		}
		return 0;
	}

}
