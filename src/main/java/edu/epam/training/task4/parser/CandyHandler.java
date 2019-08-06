package edu.epam.training.task4.parser;


import edu.epam.training.task4.bean.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class CandyHandler extends DefaultHandler  {

    private Set<Candy> candies;
    private Candy current = null;
    private CandyEnum currentEnum = null;
    private EnumSet<CandyEnum> withText;

    CandyHandler() {
        candies = new HashSet<>();
        withText = EnumSet.range (CandyEnum.NAME, CandyEnum.PRODUCTION);
    }

    public Set<Candy> getFlowers() {
        return candies;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {

        if ("candy".equals (localName)) {
            current = new Candy();
            current.setId (attrs.getValue (0));
            current.setType (CandyTypes.fromValue(attrs.getValue (1)));
            if (attrs.getValue (2) !=null) {
                current.setFilling (Filling.fromValue (attrs.getValue (2)));
            }else {
                current.setFilling (null);
            }
        }

        else {
            CandyEnum temp = CandyEnum.valueOf (localName.replace ("-","_").toUpperCase ());
            if (withText.contains (temp)) {
                currentEnum = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("candy".equals (localName)) {
            candies.add (current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String currentElem = new String (ch, start, length).trim ();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    current.setName (currentElem);
                    break;
                case ENERGY:
                    current.setEnergy(Integer.parseInt(currentElem));
                    break;
                case VANILLA:
                    current.getIngredients ().setVanilla (Integer.parseInt(currentElem));
                    break;
                case SUGAR:
                    current.getIngredients ().setSugar (Integer.parseInt(currentElem));
                    break;
                case FRUCTOSE:
                    current.getIngredients ().setFructose (Integer.parseInt(currentElem));
                    break;
                case WATER:
                    current.getIngredients ().setWater(Integer.parseInt(currentElem));
                    break;
                case CHOCOLATE_TYPE:
                    current.getIngredients ().setChocolateType(currentElem);
                    break;
                case FATS:
                    current.getValue().setFats (Integer.parseInt(currentElem));
                    break;
                case PROTEINS:
                    current.getValue ().setProteins (Integer.parseInt (currentElem));
                    break;
                case CARBOHYDRATES:
                    current.getValue().setCarbohydrates (Integer.parseInt(currentElem));
                    break;
                case PRODUCTION:
                    current.setProduction(Production.fromValue (currentElem));
                    break;
                default:
                    throw new EnumConstantNotPresentException (
                            currentEnum.getDeclaringClass (), currentEnum.name ());
            }
        }
        currentEnum = null;
    }
}


