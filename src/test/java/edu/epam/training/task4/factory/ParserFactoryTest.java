package edu.epam.training.task4.factory;

import edu.epam.training.task4.exception.ParserException;
import edu.epam.training.task4.parser.AbstractCandyParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParserFactoryTest {

    @Test(dataProvider = "createFlowerParserData", dataProviderClass = ParserFactoryTestData.class)
    public void testCreateFlowerParser_String_Parser(String type, ParserFactory factory, Class expected) throws ParserException {

        AbstractCandyParser actual = factory.createFlowerParser (type);

        Assert.assertEquals (actual.getClass (), expected);
    }
}
