package edu.epam.training.task4.parser;

import edu.epam.training.task4.bean.*;
import edu.epam.training.task4.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class DOMCandyParser extends AbstractCandyParser {

    private static final Logger LOGGER = LogManager.getLogger (DOMCandyParser.class);
    private DocumentBuilder documentBuilder;
    public DOMCandyParser() throws ParserException {
        super();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error ("DOM Constructor exception",e);
            throw  new ParserException (e);
        }
    }
    @Override
    public void buildSetCandies(InputStream dataStream) {
        try (InputStream stream = dataStream){
            Document document = documentBuilder.parse(stream);
            Element root = document.getDocumentElement();
            NodeList candy = root.getElementsByTagName(CandyEnum.CANDY.getField ());
            //NodeList dicotyledonsFlowers = root.getElementsByTagName(CandyEnum.DICOTYLEDONS_FLOWER.getField ());
            fillCandies (candy);
            //fillFlowers (dicotyledonsFlowers,"dicotyledons");
        } catch (SAXException | IOException e) {
           LOGGER.error ("DOM parsing error!",e);
        }
    }
    private Candy buildCandy(Element candyElement) {
        Candy candy;

        candy = new Candy();

        if(!candyElement.getAttribute (CandyEnum.FILLING.getField()).isEmpty ()) {
            candy.setFilling (Filling.fromValue (candyElement.getAttribute (CandyEnum.FILLING.getField ())));
        }else {
            candy.setFilling(null);
        }
        candy.setType (CandyTypes.fromValue(candyElement.getAttribute(CandyEnum.TYPE.getField())));
        candy.setId (candyElement.getAttribute(CandyEnum.ID.getField()));
        candy.setName(getElementTextContent(candyElement, CandyEnum.NAME.getField ()));
        candy.setIngredients (fillIngredients (candyElement));
        candy.setValue (fillValue (candyElement));
        candy.setProduction (Production.fromValue (getElementTextContent(candyElement, CandyEnum.PRODUCTION.getField ())));
        return candy;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        try {
            return node.getTextContent();
        }catch (NullPointerException e){
            return "";
        }
    }

    private void fillCandies(NodeList candiesList){
        for (int i = 0; i < candiesList.getLength(); i++) {
            Element candyElement = (Element) candiesList.item(i);
            Candy candy = buildCandy(candyElement);
            candies.add(candy);
        }
    }

    private Ingredients fillIngredients(Element candyElement){
        Ingredients ingredients = new Ingredients();
        Element ingredientElement = (Element) candyElement.getElementsByTagName(CandyEnum.INGREDIENTS.getField ()).item(0);
        ingredients.setChocolateType(getElementTextContent(ingredientElement, CandyEnum.CHOCOLATE_TYPE.getField ()));
        ingredients.setWater (Integer.parseInt(getElementTextContent(ingredientElement, CandyEnum.WATER.getField ())));
        ingredients.setFructose (Integer.parseInt(getElementTextContent(ingredientElement, CandyEnum.FRUCTOSE.getField ())));
        ingredients.setVanilla (Integer.parseInt(getElementTextContent(ingredientElement, CandyEnum.VANILLA.getField ())));
        ingredients.setSugar (Integer.parseInt(getElementTextContent(ingredientElement, CandyEnum.SUGAR.getField ())));
        return ingredients;
    }
    private NutritionValue fillValue(Element candyElement){
        NutritionValue value = new NutritionValue();
        Element valueElement = (Element)candyElement.getElementsByTagName (CandyEnum.VALUE.getField ()).item (0);
        value.setFats (Integer.parseInt (getElementTextContent (valueElement, CandyEnum.FATS.getField ())));
        value.setProteins (Integer.parseInt (getElementTextContent (valueElement, CandyEnum.PROTEINS.getField ())));
        value.setCarbohydrates (Integer.parseInt (getElementTextContent (valueElement, CandyEnum.CARBOHYDRATES.getField ())));
        return value;
    }
}
