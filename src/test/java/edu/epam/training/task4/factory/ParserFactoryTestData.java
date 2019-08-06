package edu.epam.training.task4.factory;

import edu.epam.training.task4.exception.ParserException;
import edu.epam.training.task4.parser.DOMCandyParser;
import edu.epam.training.task4.parser.SAXCandyParser;
import edu.epam.training.task4.parser.StAXCandyParser;
import org.testng.annotations.DataProvider;

public class ParserFactoryTestData {

    @DataProvider(name = "createFlowerParserData")
    public static Object[] createFlowerParserData() throws ParserException {

        String dom = "dom";
        String sax = "sax";
        String stax = "stax";
        ParserFactory factory = ParserFactory.getInstance ();

        return  new Object[][]{
                {
                        dom, factory, DOMCandyParser.class
                },
                {
                        sax, factory, SAXCandyParser.class
                },
                {
                        stax, factory, StAXCandyParser.class
                },
        };
    }
}
