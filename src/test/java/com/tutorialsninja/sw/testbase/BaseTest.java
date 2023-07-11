package com.tutorialsninja.sw.testbase;


import com.tutorialsninja.sw.propertyReader.PropertyReader;
import com.tutorialsninja.sw.utilities.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod
    public void setUp(){
        selectBrowser(browser);
    }


        


    @AfterMethod
    public void tearDown(){
        closebrowser();
    }


    }

