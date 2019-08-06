package edu.epam.training.task4.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class ValidatorXML {
    private static final Logger LOGGER = LogManager.getLogger(ValidatorXML.class);
    private static final String RESOURCE_XSD = "Task4xsd.xsd";
    public static boolean validate(InputStream xml) {
        try {
            ClassLoader classLoader = Thread.currentThread ().getContextClassLoader ();
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File (Objects.requireNonNull (classLoader.getResource (RESOURCE_XSD)).getFile ()));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource (xml));
        } catch (IOException | SAXException e){
            LOGGER.error("Validator xml error", e);
            return false;
        }
        return true;
    }
}
