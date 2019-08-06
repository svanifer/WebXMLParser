package edu.epam.training.task4.validation;


import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ValidatorXMLTestData {

    @DataProvider(name = "validateData")
    public static Object[] validateData(){

        InputStream streamOne = null;
        InputStream streamTwo = null;
        InputStream streamThree = null;
        try {
            Path path = Paths.get("src/test/resources/testDataOne.xml");
            Path path2 = Paths.get("src/test/resources/testDataTwo.xml");
            Path path3 = Paths.get("src/main/resources/Task4.xml");
            streamOne = Files.newInputStream (path);
            streamTwo = Files.newInputStream (path2);
            streamThree = Files.newInputStream (path3);
        } catch (IOException e) {
            e.printStackTrace ();
        }

        return  new Object[][]{
                {
                    streamOne
                },
                {
                    streamTwo
                },
                {
                    streamThree
                }
        };
    }
}