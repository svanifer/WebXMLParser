package edu.epam.training.task4.parser;

import edu.epam.training.task4.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.IOException;
import java.io.InputStream;

public class SAXCandyParser extends AbstractCandyParser {

    private static final Logger LOGGER = LogManager.getLogger (SAXCandyParser.class);
    private CandyHandler candyHandler;
    private XMLReader reader;

    public SAXCandyParser() throws ParserException {
        super ();
        candyHandler = new CandyHandler();
        try {
            reader = XMLReaderFactory.createXMLReader ();
            reader.setContentHandler (candyHandler);
        } catch (SAXException e) {
            LOGGER.error ("Sax Constructor exception",e);
            throw new ParserException (e);
        }
    }

    public void buildSetCandies(InputStream fileName) {
        try {
            reader.parse (new InputSource (fileName));
            candies = candyHandler.getFlowers ();
        } catch (SAXException | IOException e) {
            LOGGER.error ("SAX parsing error! ", e);
        }
    }
}
