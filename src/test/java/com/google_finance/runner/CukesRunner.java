package com.google_finance.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/project_name/step_definitions",
        dryRun = true,
        tags = "",
        publish = true
)
public class CukesRunner extends AbstractTestNGCucumberTests {

}

