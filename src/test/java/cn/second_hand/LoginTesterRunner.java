package cn.second_hand;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "com.javapointers",
        tags = "@SignUpFeature")
public class LoginTesterRunner {

	
}
