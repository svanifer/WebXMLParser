package edu.epam.training.task4.validation;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.InputStream;

public class ValidatorXMLTest {

    @Test(dataProvider = "validateData", dataProviderClass = ValidatorXMLTestData.class)
    public void testValidate_InputStream_boolean(InputStream stream)  {

        boolean result = ValidatorXML.validate (stream);

        Assert.assertTrue (result);
    }
}
