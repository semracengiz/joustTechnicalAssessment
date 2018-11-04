package com.joust.site.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions(
	features = { "resources/features" }, 
	glue = {"com.joust.site.steps" }, 
	monochrome = true, 
	tags = {}, 
	plugin = { "pretty", "html:output/cucumber", "json:output/cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:output/report.html" })

public class TestRun extends AbstractTestNGCucumberTests {
}

