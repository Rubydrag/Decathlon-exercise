/**
 * 
 */
package com.decathlon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.decathlon.beans.Athlete;
import com.decathlon.output.XMLWriter;
import com.decathlon.parsers.DocumentParser;
import com.decathlon.parsers.DocumentType;
import com.decathlon.pointcalculator.PointsCalculation;

/**
 * This is Decathon Competition main entry class.
 * 
 * @author Brajesh Chandak
 *
 */
public class DecathlonCompetition {

	public static void main(String[] args) {
		String inputFile = "";
		String outputFile = "";
		

		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Please provide input file: ");
			inputFile = br.readLine();
			if (inputFile.equals("")) {
				System.out.println("Wrong input file provided. System exiting.");
				System.exit(0);
			}
			System.out.println("Please provide output file:");
			outputFile = br.readLine();
			if (outputFile.equals("")) {
				System.out.println("Wrong output file provided. System exiting");
				System.exit(0);
			}
			DocumentParser parser = new DocumentParser();
			List<Athlete> athleteList = parser.parseDocumentToAthletes(inputFile, DocumentType.CSV);
			athleteList = PointsCalculation.calculateTotalPointsForAthletes(athleteList);
			XMLWriter xmlWriter = new XMLWriter();
			xmlWriter.writeToFile(outputFile, athleteList);

		} catch (Exception e) {
			System.out.println("Problem in running the application. The exception is   " + e.getMessage());
		}

	}

}
