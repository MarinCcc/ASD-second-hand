package cn.second_hand;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Tester {

	WebDriver driver;
	
	@Given("^I enter into login page$")
	public void givenStatement() throws Exception{
		Class<? extends WebDriver> driverClass = FirefoxDriver.class;
		WebDriverManager.getInstance(driverClass).setup();
		driver = driverClass.newInstance();
		//driver.get("");
	}
	
	@When("^I Type account name and password$")
	public void whenStatement() {
		driver.get("https://dashboard.heroku.com/apps/second-hand-market");
	}
	
	@Then("^I login successful and enter main page$")
	public void thenStatement() {
		Assert.assertEquals("Home", driver.getTitle());
	}
}
