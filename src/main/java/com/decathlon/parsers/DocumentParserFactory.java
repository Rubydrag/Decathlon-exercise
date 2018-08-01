/**

 * 
 */
package com.decathlon.parsers;

/**
 * This is the factory which will return the correct parser object based on Document type
 * 
 * @author Brajesh Chandak
 *
 */

public class DocumentParserFactory {
	private final ParsingStrategy csvParser = new CSVParser();

	public ParsingStrategy getParsingStrategy(DocumentType type) {

		switch (type) {
		case CSV:
			return csvParser;

		default:
			return csvParser;
		}
	}
}
