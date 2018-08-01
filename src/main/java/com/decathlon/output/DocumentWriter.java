/**
 * 
 */
package com.decathlon.output;

import java.util.List;

import com.decathlon.beans.Athlete;



/**
 * This is the contract for writing the document.
 * @author Brajesh Chandak
 *
 */
public interface DocumentWriter {
	public void writeToFile(String filename, List<Athlete> athletesList);

}
