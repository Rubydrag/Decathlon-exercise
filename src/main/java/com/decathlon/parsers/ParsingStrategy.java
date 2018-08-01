/**
 * 
 */
package com.decathlon.parsers;

import java.util.List;

import com.decathlon.beans.Athlete;
import com.decathlon.util.DecathlonException;

/**
 * 
 * @author Brajesh Chandak
 *
 */
public interface ParsingStrategy {
	
	List<Athlete> parseDocumentToAthletes(String inputFile, String separator) throws DecathlonException;

}
