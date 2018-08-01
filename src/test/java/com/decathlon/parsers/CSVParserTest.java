/**
 * 
 */
package com.decathlon.parsers;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.decathlon.beans.Athlete;
import com.decathlon.util.DecathlonException;

/**
 * This is test file for CSVParser.java
 * @author Brajesh Chandak
 *
 */
public class CSVParserTest {
	
	CSVParser csvParser = new CSVParser();
	String separator = ";";
	String inputFile;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.inputFile = "src/test/resources/Decathlon_input.txt";
	}

	/**
	 * Test method for {@link com.decathlon.parsers.CSVParser#parseDocumentToAthletes(java.lang.String, java.lang.String)}.
	 * @throws DecathlonException 
	 */
	@Test
	public final void testParseDocumentToAthletes() throws DecathlonException {
		List<Athlete> athleteList = csvParser.parseDocumentToAthletes(this.inputFile, this.separator);
		assertNotNull(athleteList);
		assertTrue(4 == athleteList.size());
		assertTrue("Siim Susi".equals(athleteList.get(0).getName()));
		assertTrue("Beata Kana".equals(athleteList.get(1).getName()));
		assertTrue("Jaana Lind".equals(athleteList.get(2).getName()));
		assertTrue("Anti Loop".equals(athleteList.get(3).getName()));
	}
	
	/**
	 * Test method for  {@link com.decathlon.parsers.CSVParser#parseDocumentToAthletes(java.lang.String, java.lang.String)}.
	 * @throws DecathlonException 
	 */
	@Test(expected = DecathlonException.class)
	public final void testParseDocumentToAthletesForFileNotFoundException() throws DecathlonException {
		this.inputFile = "wrongfile.txt";
		csvParser.parseDocumentToAthletes(this.inputFile, this.separator);
	
	}
	
	
	/**
	 * Test method for  {@link com.decathlon.parsers.CSVParser#parseDocumentToAthletes(java.lang.String, java.lang.String)}.
	 * @throws DecathlonException 
	 */
	@Test(expected = DecathlonException.class)
	public final void testParseDocumentToAthletesForInvalidData() throws DecathlonException {
		this.inputFile = "invalidData.txt";
		csvParser.parseDocumentToAthletes(this.inputFile, this.separator);
	
	}
	
	

}
