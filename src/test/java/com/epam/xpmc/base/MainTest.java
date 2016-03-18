package com.epam.xpmc.base;

import java.io.IOException;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import com.epam.xpmc.core.Driver;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources" }, format = { "pretty",
		"html:target/reports/cucumber/html", "json:target/cucumber.json",
		"usage:target/usage.jsonx", "junit:target/junit.xml" }, tags = { "@done" }, glue = { "com.epam.xpmc" })
public class MainTest {

	@Before
	public static void setUp() {
		Driver.getInstance();
	}

	@After
	public static void tearDown() throws IOException {
		Driver.getInstance().quit();
	}
}