/**
 * 
 */
package com.decathlon.parsers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.decathlon.beans.Athlete;
import com.decathlon.beans.FieldEventsResult;
import com.decathlon.beans.TrackEventsResult;
import com.decathlon.util.DecathlonException;

/**
 * This is the implementation of Parser for CSV file.  
 * @author Brajesh Chandak
 *
 */
public class CSVParser implements ParsingStrategy {
	
	/**
	 * Below method parses the CSV input file and returns the list of Athlete.  
	 * @author Brajesh Chandak
	 *
	 */

	@Override
	public List<Athlete> parseDocumentToAthletes(String fileName, String separator) throws DecathlonException {

		List<Athlete> list = new ArrayList<>();
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while ((line = br.readLine()) != null) {
				line = line.trim();
				String[] resultLine = line.split(separator);
				if (resultLine.length != 11) {
					throw new DecathlonException("input file data not valid");
				}
				Athlete athlete = new Athlete();
				athlete.getFieldEventsResult();
				athlete.setName(resultLine[0]);
				athlete.setTrackEventsResult(new TrackEventsResult(resultLine));
				athlete.setFieldEventsResult(new FieldEventsResult(resultLine));
				list.add(athlete);
			}

		} catch (Exception e) {
			throw new DecathlonException(e.getMessage(), e);
		}
		return list;
	}
}
