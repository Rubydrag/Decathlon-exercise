/**
 * 
 */
package com.decathlon.parsers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.decathlon.beans.Athlete;
import com.decathlon.util.DecathlonException;

/**
 * Test class for DocumentParser.java
 * 
 * @author Brajesh Chandak
 *
 */
public class DocumentParserTest {

	DocumentParser documentParser = new DocumentParser();
	DocumentType type;
	String inputFile;

	@Before
	public void setUp() throws Exception {
		this.documentParser.setSeparator(";");
		this.type = DocumentType.CSV;
		this.inputFile = "src/test/resources/Decathlon_input.txt";
	}

	/**
	 * Test method for
	 * {@link com.decathlon.parsers.DocumentParser#getSeparator(java.lang.String)}.
	 */
	@Test
	public final void testgetSeparator() {
		assertTrue(";".equals(documentParser.getSeparator()));
	}

	/**
	 * Test method for
	 * {@link com.decathlon.parsers.DocumentParser#setSeparator(java.lang.String)}.
	 */
	@Test
	public final void testSetSeparator() {
		documentParser.setSeparator(",");
		assertTrue(",".equals(documentParser.getSeparator()));
	}

	/**
	 * Test method for
	 * {@link com.decathlon.parsers.DocumentParser#parseDocumentToAthletes(java.lang.String, com.decathlon.parsers.DocumentType)}.
	 * 
	 * @throws DecathlonException
	 */
	@Test
	public final void testParseDocumentToAthletes() throws DecathlonException {
		List<Athlete> athleteList = documentParser.parseDocumentToAthletes(this.inputFile, this.type);
		assertNotNull(athleteList);
		assertTrue(4 == athleteList.size());
		assertTrue("Siim Susi".equals(athleteList.get(0).getName()));
		assertTrue("Beata Kana".equals(athleteList.get(1).getName()));
		assertTrue("Jaana Lind".equals(athleteList.get(2).getName()));
		assertTrue("Anti Loop".equals(athleteList.get(3).getName()));
	}

}
