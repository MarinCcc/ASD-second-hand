package cn.second_hand;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

public class LoginTesterRunner {

	@RunWith(Cucumber.class)
	@CucumberOptions(features="src/test/java/logintester.features",tags={"@smokeTest","@LoginTest"})
	public class TestRunners {
	 
		
	}
}
