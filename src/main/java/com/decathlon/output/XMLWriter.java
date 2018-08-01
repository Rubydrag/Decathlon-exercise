package com.decathlon.output;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.decathlon.beans.Athlete;
import com.decathlon.util.XMLConstants;

/**
 * This class will produce the ouput xml.
 * 
 * @author Brajesh Chandak
 *
 */
public class XMLWriter implements DocumentWriter {

	@Override
	public void writeToFile(String filename, List<Athlete> athletesList) {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement(XMLConstants.ATHLETES);
			doc.appendChild(rootElement);
			for (Athlete athlete : athletesList) {
				Element athleteElm = doc.createElement(XMLConstants.ATHLETE);
				rootElement.appendChild(athleteElm);

				Element name = doc.createElement(XMLConstants.ATHLETE_NAME);
				name.appendChild(doc.createTextNode(athlete.getName()));
				athleteElm.appendChild(name);

				Element totalPoints = doc.createElement(XMLConstants.TOTAL_POINTS);
				totalPoints.appendChild(doc.createTextNode(String.valueOf(athlete.getTotalPoints())));
				athleteElm.appendChild(totalPoints);

				Element rank = doc.createElement(XMLConstants.RANK);
				rank.appendChild(doc.createTextNode(String.valueOf(athlete.getRanking())));
				athleteElm.appendChild(rank);

				Element points = doc.createElement(XMLConstants.POINTS);
				athleteElm.appendChild(points);

				Element run100m = doc.createElement(XMLConstants.T_100M);
				run100m.appendChild(doc.createTextNode(String.valueOf(athlete.getTrackEventsResult().getRun100M())));
				points.appendChild(run100m);

				Element run110m = doc.createElement(XMLConstants.T_110M);
				run110m.appendChild(
						doc.createTextNode(String.valueOf(athlete.getTrackEventsResult().getRun110MHurdles())));
				points.appendChild(run110m);

				Element run400m = doc.createElement(XMLConstants.T_400M);
				run400m.appendChild(doc.createTextNode(String.valueOf(athlete.getTrackEventsResult().getRun400M())));
				points.appendChild(run400m);

				Element run1500m = doc.createElement(XMLConstants.T_1500M);
				run1500m.appendChild(doc.createTextNode(String.valueOf(athlete.getTrackEventsResult().getOriginal1500M())));
				points.appendChild(run1500m);

				Element longJump = doc.createElement(XMLConstants.F_LONG_JUMP);
				longJump.appendChild(doc.createTextNode(String.valueOf(athlete.getFieldEventsResult().getLongJump())));
				points.appendChild(longJump);

				Element shotPut = doc.createElement(XMLConstants.F_SHOT_PUT);
				shotPut.appendChild(
						doc.createTextNode(String.valueOf(athlete.getFieldEventsResult().getShotPutThrow())));
				points.appendChild(shotPut);

				Element highJump = doc.createElement(XMLConstants.F_HIGH_JUMP);
				highJump.appendChild(doc.createTextNode(String.valueOf(athlete.getFieldEventsResult().getHighJump())));
				points.appendChild(highJump);

				Element discusThrow = doc.createElement(XMLConstants.F_DISCUS_THROW);
				discusThrow.appendChild(
						doc.createTextNode(String.valueOf(athlete.getFieldEventsResult().getDiscusThrow())));
				points.appendChild(discusThrow);

				Element javelinThrow = doc.createElement(XMLConstants.F_JAVELIN_THROW);
				javelinThrow.appendChild(
						doc.createTextNode(String.valueOf(athlete.getFieldEventsResult().getJavelinThrow())));
				points.appendChild(javelinThrow);

				Element poleVault = doc.createElement(XMLConstants.F_POLE_JUMP);
				poleVault.appendChild(
						doc.createTextNode(String.valueOf(athlete.getFieldEventsResult().getPoleVaultJump())));
				points.appendChild(poleVault);
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			// Templates template = transformerFactory.newTemplates(new StreamSource(
			// new FileInputStream("src/main/resources/Decathlon_xsl.xsl"))); //XSL don't
			// work
			// Transformer transformer = template.newTransformer();

			Transformer transformer = transformerFactory.newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));
			transformer.transform(source, result);

			System.out.println("XML file created");

		} catch (ParserConfigurationException | TransformerException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

	}

}
