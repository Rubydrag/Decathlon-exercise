package com.decathlon.beans;



public class FieldEventsResult {
	private float longJump;
	private float shotPutThrow;
	private float highJump;
	private float discusThrow;
	private float poleVaultJump;
	private float javelinThrow;
	
	
	public FieldEventsResult() {
		this.longJump = 0.0f;
		this.shotPutThrow = 0.0f ;
		this.highJump = 0.0f;
		this.discusThrow = 0.0f;
		this.poleVaultJump = 0.0f;
		this.javelinThrow = 0.0f;
	}
	
	
	public FieldEventsResult(String[] resultLine) {
		this.populate(resultLine);
	}
	
	/**
	 * Below function parses the values to float and sets it to the bean.
	 * 
	 */
	private void populate(String[] resultLine) {
		this.setLongJump(Float.parseFloat(resultLine[2]));
		this.setShotPutThrow(Float.parseFloat(resultLine[3]));
		this.setHighJump(Float.parseFloat(resultLine[4]));
		this.setDiscusThrow(Float.parseFloat(resultLine[7]));
		this.setPoleVaultJump(Float.parseFloat(resultLine[8]));
		this.setJavelinThrow(Float.parseFloat(resultLine[9]));
	}
	


	public float getLongJump() {
		return longJump;
	}

	public void setLongJump(float longJump) {
		this.longJump = longJump;
	}

	public float getShotPutThrow() {
		return shotPutThrow;
	}

	public void setShotPutThrow(float shotPutThrow) {
		this.shotPutThrow = shotPutThrow;
	}

	public float getHighJump() {
		return highJump;
	}

	public void setHighJump(float highJump) {
		this.highJump = highJump;
	}

	
	public float getDiscusThrow() {
		return discusThrow;
	}

	public void setDiscusThrow(float discusThrow) {
		this.discusThrow = discusThrow;
	}

	public float getPoleVaultJump() {
		return poleVaultJump;
	}

	public void setPoleVaultJump(float poleVaultJump) {
		this.poleVaultJump = poleVaultJump;
	}

	public float getJavelinThrow() {
		return javelinThrow;
	}

	public void setJavelinThrow(float javelinThrow) {
		this.javelinThrow = javelinThrow;
	}

}
