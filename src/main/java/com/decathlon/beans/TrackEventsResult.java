package com.decathlon.beans;

public class TrackEventsResult {

	private float run100M;
	private float run400M;
	private float run110MHurdles;
	private float run1500M;
	private String original1500M;

	public TrackEventsResult() {
		this.run100M = 0.0f;
		this.run400M = 0.0f;
		this.run110MHurdles = 0.0f;
		this.run1500M = 0.0f;
		this.original1500M = "";

	}

	public TrackEventsResult(String[] resultLine) {
		this.populate(resultLine);

	}

	/**
	 * Below function parses the values to float and sets it to the bean.
	 * 
	 */
	private void populate(String[] resultLine) {
		this.setRun100M(Float.parseFloat(resultLine[1]));
		this.setRun400M(Float.parseFloat(resultLine[5]));
		this.setRun110MHurdles(Float.parseFloat(resultLine[6]));
		this.setRun1500M(getSeconds(resultLine[10]));
		this.setOriginal1500M(resultLine[10]);

	}

	/**
	 * Below function calculates the total seconds for athlete to run 1500M and
	 * parses it to float.
	 * 
	 */
	private static float getSeconds(String duration1500m) {
		String[] separateDuration = duration1500m.split("\\.");
		int minutes = 0;
		float seconds = 0.0f;
		float totalSeconds = 0.0f;
		if (separateDuration.length > 2) {
			if (!separateDuration[0].isEmpty() && !(null == separateDuration[0])) {
				minutes = Integer.parseInt(separateDuration[0]);
			}
			seconds = Float.parseFloat(separateDuration[1] + "." + separateDuration[2] + "f");
			totalSeconds = Math.multiplyExact(minutes, 60) + seconds;
		} else {
			totalSeconds = Float.parseFloat(separateDuration[0] + "." + separateDuration[1] + "f");
		}
		return totalSeconds;
	}

	public float getRun100M() {
		return run100M;
	}

	public void setRun100M(float run100m) {
		run100M = run100m;
	}

	public float getRun400M() {
		return run400M;
	}

	public void setRun400M(float run400m) {
		run400M = run400m;
	}

	public float getRun110MHurdles() {
		return run110MHurdles;
	}

	public void setRun110MHurdles(float run110mHurdles) {
		run110MHurdles = run110mHurdles;
	}

	public float getRun1500M() {
		return run1500M;
	}

	public void setRun1500M(float run1500m) {
		run1500M = run1500m;
	}

	public String getOriginal1500M() {
		return original1500M;
	}

	public void setOriginal1500M(String original1500m) {
		original1500M = original1500m;
	}

}
