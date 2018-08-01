/**
 * 
 */
package com.decathlon.parsers;

import java.util.List;

import com.decathlon.beans.Athlete;
import com.decathlon.util.DecathlonException;

/**
 * This class basically reads the input file and fills the model objects in list
 * and returns.
 * 
 * @author Brajesh Chandak
 *
 */
public class DocumentParser {
	private String separator = ";";
	private final DocumentParserFactory documentParserFactory = new DocumentParserFactory();

	public List<Athlete> parseDocumentToAthletes(String inputFile, DocumentType type) throws DecathlonException {
		ParsingStrategy parsingStrategy = documentParserFactory.getParsingStrategy(type);
		return parsingStrategy.parseDocumentToAthletes(inputFile, separator);

	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public String getSeparator() {
		return this.separator;
	}

}
