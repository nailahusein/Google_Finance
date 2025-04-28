package com.google_finance.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@target/rerun.txt", // Rerun file path
        glue = "com/google_finance/steps"
)

public class FailedTestRunner extends AbstractTestNGCucumberTests {

}

