package com.google_finance.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@target/rerun.txt", // Rerun file path
        glue = "com/project_name/step_definitions"
)

public class FailedTestRunner extends AbstractTestNGCucumberTests {

}

