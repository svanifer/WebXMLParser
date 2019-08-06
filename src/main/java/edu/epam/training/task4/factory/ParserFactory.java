package edu.epam.training.task4.factory;

import edu.epam.training.task4.exception.ParserException;
import edu.epam.training.task4.parser.AbstractCandyParser;
import edu.epam.training.task4.parser.DOMCandyParser;
import edu.epam.training.task4.parser.SAXCandyParser;
import edu.epam.training.task4.parser.StAXCandyParser;

public class ParserFactory {

    private static final ParserFactory INSTANCE =  new ParserFactory ();
    private enum TypeParser {
        SAX, STAX, DOM
    }

    private ParserFactory() {
    }

    public static ParserFactory getInstance() {
        return INSTANCE;
    }

    public AbstractCandyParser createFlowerParser(String typeParser) throws ParserException {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new DOMCandyParser();
            case STAX:
                return new StAXCandyParser();
            case SAX:
                return new SAXCandyParser();
            default:
                throw new EnumConstantNotPresentException (type.getDeclaringClass(), type.name());
        }
    }
}
