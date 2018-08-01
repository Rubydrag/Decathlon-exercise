/**
 * 
 */
package com.decathlon.output;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.decathlon.beans.Athlete;
import com.decathlon.beans.FieldEventsResult;
import com.decathlon.beans.TrackEventsResult;

/**
 * This is the unit test file for XMLWriter.java
 * @author Brajesh Chandak
 *
 */
public class XMLWriterTest {
	
	List<Athlete> athletes = new ArrayList<Athlete>();
	XMLWriter xmlWriter = new XMLWriter();
	Athlete athlete;
	String fileName = "src/test/resources/output.xml";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		athlete = new Athlete();
		athlete.setName("Siim Susi");
		athlete.setRanking("1");
		athlete.setTotalPoints(4200);
		TrackEventsResult trackEventsResult = new TrackEventsResult();
		FieldEventsResult fieldEventsResult = new FieldEventsResult();
		trackEventsResult.setRun100M(12.61f);
		fieldEventsResult.setLongJump(5.00f);
		fieldEventsResult.setShotPutThrow(9.22f);
		fieldEventsResult.setHighJump(1.50f);
		trackEventsResult.setRun400M(60.39f);
		trackEventsResult.setRun110MHurdles(16.43f);
		fieldEventsResult.setDiscusThrow(21.60f);
		fieldEventsResult.setPoleVaultJump(2.60f);
		fieldEventsResult.setJavelinThrow(35.81f);
		trackEventsResult.setOriginal1500M("5.25.72");
		athlete.setTrackEventsResult(trackEventsResult);
		athlete.setFieldEventsResult(fieldEventsResult);
		athletes.add(athlete);
		
	}

	/**
	 * Test method for {@link com.decathlon.output.XMLWriter#writeToFile(java.lang.String, java.util.List)}.
	 */
	@Test
	public final void testWriteToFile() {
		xmlWriter.writeToFile(this.fileName, athletes);
		String line = "";
		List<String> readXMLFile = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
			while ((line = br.readLine()) != null) {
				line = line.trim();
				readXMLFile.add(line);
			}
			assertTrue("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>".equals(readXMLFile.get(0)));
			assertTrue("<athletes>".equals(readXMLFile.get(1)));
			assertTrue("<Athlete>".equals(readXMLFile.get(2)));
			assertTrue("<Name>Siim Susi</Name>".equals(readXMLFile.get(3)));
			assertTrue("<Total_POINTS>4200</Total_POINTS>".equals(readXMLFile.get(4)));
			assertTrue("<Rank>1</Rank>".equals(readXMLFile.get(5)));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@After
	public void tearDown() {
		File file = new File(this.fileName);
    	
		if(file.delete()){
			System.out.println(file.getName() + " is deleted!");
		}else{
			System.out.println("Delete operation is failed.");
		}
	}
}
