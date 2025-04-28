package com.google_finance.steps;

import com.google_finance.utility.BrowserUtils;
import com.google_finance.utility.ConfigurationReader;
import com.google_finance.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

/*
In this class I will be able to create "pre" and "post" condition
for ALL the SCENARIOS and even STEPS.
 */
public class Hooks {

    //importing the @Before coming from io.cucumber.java
    @Before(order = 1)
    public void setupMethod(){

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    public void before_each_scenario(){
        System.out.println("---> @Before: RUNNING BEFORE EACH SCENARIO");
    }

    @Before(value = "@login", order = 2)
    public void login_scenario_before(){
        System.out.println("---> @Before (tagged with @login): RUNNING BEFORE login scenarios");
    }


    /*
    @After will be executed automatically after EVERY scenario in the project.
     */
    @After
    public void teardownMethod(Scenario scenario){
        try {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        } finally {
            BrowserUtils.sleep(2);
            Driver.closeDriver();
        }
    }


    //@BeforeStep
    public void setupStep(){
        System.out.println("-----> @BeforeSTEP : Running before each step!");
    }

    //@AfterStep
    public void teardownStep(){
        System.out.println("-----> @AfterSTEP : Running after each step!");
    }


}
