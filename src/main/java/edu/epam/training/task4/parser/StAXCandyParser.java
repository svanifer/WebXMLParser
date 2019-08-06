package edu.epam.training.task4.parser;

import edu.epam.training.task4.bean.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;

public class StAXCandyParser extends AbstractCandyParser {

    private static final Logger LOGGER = LogManager.getLogger (StAXCandyParser.class);
    private XMLInputFactory inputFactory;
    public StAXCandyParser() {
        super();
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildSetCandies(InputStream dataStream) {
        String name;
        try (InputStream stream = dataStream){
            XMLStreamReader reader = inputFactory.createXMLStreamReader (stream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals (CandyEnum.CANDY.getField ())){
                        Candy candy = buildCandies (reader, new Candy ());
                        candies.add (candy);
                    }
                }
            }
        } catch (XMLStreamException |IOException e) {
            LOGGER.error ("StAX parsing error! ",e);
        }
    }
    private Candy buildCandies(XMLStreamReader reader, Candy candy) throws XMLStreamException {
        candy.setId (reader.getAttributeValue (null, CandyEnum.ID.getField ()));
        candy.setType (CandyTypes.fromValue(reader.getAttributeValue (null, CandyEnum.TYPE.getField ())));
        if((reader.getAttributeValue (null, CandyEnum.FILLING.getField ()))!= null){
            candy.setFilling (Filling.fromValue (reader.getAttributeValue (null, CandyEnum.FILLING.getField ())));
        }else{
            candy.setFilling (null);
        }
        String name;
        while (reader.hasNext ()) {
            int type = reader.next ();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName ();
                    switch (CandyEnum.valueOf (name.replace ("-", "_").toUpperCase ())) {
                        case NAME:
                            candy.setName (getXMLText (reader));
                            break;
                        case ENERGY:
                            candy.setEnergy (Integer.parseInt(getXMLText (reader)));
                            break;
                        case VALUE:
                            candy.setValue (getXMLValue (reader));
                            break;
                        case INGREDIENTS:
                            candy.setIngredients (getXMLIngredients (reader));
                            break;
                        case PRODUCTION:
                            candy.setProduction (Production.fromValue(getXMLText (reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName ().replace ("-","_").toUpperCase ();
                    CandyEnum candyEnum = CandyEnum.valueOf (name);
                    if (candyEnum == CandyEnum.CANDY) {
                        return candy;
                    }
                    break;
            }
        }
        throw  new XMLStreamException ("Unknown element");
    }

    private NutritionValue getXMLValue(XMLStreamReader reader) throws XMLStreamException {
        NutritionValue value = new NutritionValue();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyEnum.valueOf(name.replace ("-","_").toUpperCase ())) {
                        case PROTEINS:
                            value.setProteins (Integer.parseInt (getXMLText (reader)));
                            break;
                        case FATS:
                            value.setFats (Integer.parseInt (getXMLText (reader)));
                            break;
                        case CARBOHYDRATES:
                            value.setCarbohydrates (Integer.parseInt (getXMLText (reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.replace ("-","_").toUpperCase ()) == CandyEnum.VALUE){
                        return value;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag growing-tips");
    }

    private Ingredients getXMLIngredients(XMLStreamReader reader) throws XMLStreamException {
        Ingredients ingredients = new Ingredients();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();

                    switch (CandyEnum.valueOf(name.replace ("-","_").toUpperCase ())) {
                        case VANILLA:
                            ingredients.setVanilla (Integer.parseInt (getXMLText (reader)));
                            break;
                        case SUGAR:
                            ingredients.setSugar (Integer.parseInt (getXMLText (reader)));
                            break;
                        case WATER:
                            ingredients.setWater (Integer.parseInt (getXMLText (reader)));
                            break;
                        case FRUCTOSE:
                            ingredients.setFructose (Integer.parseInt (getXMLText (reader)));
                            break;
                        case CHOCOLATE_TYPE:
                            try {
                                ingredients.setChocolateType(getXMLText(reader));
                            }catch (NullPointerException e){
                                ingredients.setChocolateType("");
                            }
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.replace ("-","_").toUpperCase ()) == CandyEnum.INGREDIENTS){
                        return ingredients;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag visual");
    }
    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
