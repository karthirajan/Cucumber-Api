package com.google.stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//resources//features",
                     glue = "com.google.stepdefinition",
               monochrome = true,
                   plugin = "json:target/reports.json"
                     )

public class TestRunner {

}
