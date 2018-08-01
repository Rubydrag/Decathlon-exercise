/**
 * 
 */
package com.decathlon.pointcalculator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This is standard values for as referred in wiki.
 * 
 * @author Brajesh Chandak
 *
 */
public class PointsCalculatorRefTable {

	public static final Map<GameType, Float> COLUMN_A = refValueColumnA();
	public static final Map<GameType, Float> COLUMN_B = refValueColumnB();
	public static final Map<GameType, Float> COLUMN_C = refValueColumnC();

	private static Map<GameType, Float> refValueColumnA() {
		// TODO Auto-generated method stub
		Map<GameType, Float> result = new HashMap<GameType, Float>();
		result.put(GameType.TRACK_100M, 25.4347f);
		result.put(GameType.TRACK_110M, 5.74352f);
		result.put(GameType.TRACK_400M, 1.53775f);
		result.put(GameType.TRACK_1500M, 0.03768f);
		result.put(GameType.FIELD_DISCUS_THROW, 12.91f);
		result.put(GameType.FIELD_JAVELIN_THROW, 10.14f);
		result.put(GameType.FIELD_SHOT_PUT, 51.39f);
		result.put(GameType.FIELD_LONG_JUMP, 0.14354f);
		result.put(GameType.FIELD_HIGH_JUMP, 0.8465f);
		result.put(GameType.FIELD_POLE_JUMP, 0.2797f);
		return Collections.unmodifiableMap(result);
	}

	private static Map<GameType, Float> refValueColumnC() {
		// TODO Auto-generated method stub
		Map<GameType, Float> result = new HashMap<GameType, Float>();
		result.put(GameType.TRACK_100M, 1.81f);
		result.put(GameType.TRACK_110M, 1.92f);
		result.put(GameType.TRACK_400M, 1.81f);
		result.put(GameType.TRACK_1500M, 1.85f);
		result.put(GameType.FIELD_DISCUS_THROW, 1.1f);
		result.put(GameType.FIELD_JAVELIN_THROW, 1.08f);
		result.put(GameType.FIELD_SHOT_PUT, 1.05f);
		result.put(GameType.FIELD_LONG_JUMP, 1.4f);
		result.put(GameType.FIELD_HIGH_JUMP, 1.42f);
		result.put(GameType.FIELD_POLE_JUMP, 1.35f);
		return Collections.unmodifiableMap(result);
	}

	private static Map<GameType, Float> refValueColumnB() {
		// TODO Auto-generated method stub
		Map<GameType, Float> result = new HashMap<GameType, Float>();
		result.put(GameType.TRACK_100M, 18f);
		result.put(GameType.TRACK_110M, 28.5f);
		result.put(GameType.TRACK_400M, 82f);
		result.put(GameType.TRACK_1500M, 480f);
		result.put(GameType.FIELD_DISCUS_THROW, 4f);
		result.put(GameType.FIELD_JAVELIN_THROW, 7f);
		result.put(GameType.FIELD_SHOT_PUT, 1.5f);
		result.put(GameType.FIELD_LONG_JUMP, 220f);
		result.put(GameType.FIELD_HIGH_JUMP, 75f);
		result.put(GameType.FIELD_POLE_JUMP, 100f);

		return Collections.unmodifiableMap(result);

	}

}
