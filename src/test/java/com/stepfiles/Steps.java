package com.stepfiles;

import java.util.ResourceBundle;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.TakesScreenshot;
import junit.framework.Assert;

public class Steps {
	WebDriver driver;
	Logger logger;
	
	@Before
	public void setup() {
		System.out.println("hello");
		logger=LogManager.getLogger(this.getClass());
	}
	
	@After
	public void tearDown(Scenario scenario) {
		System.out.println(scenario.getStatus());
		if(scenario.isFailed()) {
			
			 byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			 scenario.attach(screenshot, "image/png",scenario.getName());
		}
		driver.quit();
	}
	
	
	@Given("User Launch Browser")
	public void user_launch_browser() {
		logger.info("starting");
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		
	}
	

	@Given("opens url {string}")
	public void opens_url(String string) {
		driver.get(string);
	    
	}

	@When("I enter username as {string} and password as {string}")
	public void i_enter_username_as_and_password_as(String string, String string2) {
	  driver.findElement(By.id("email")).sendKeys(string);
	  driver.findElement(By.id("pass")).sendKeys(string2);
	}

	@When("click on login")
	public void click_on_login() {
		driver.findElement(By.name("login")).click();
	  
	}

	@Then("navigates to account page")
	public void navigates_to_account_page() {
		Boolean b=driver.findElement(By.xpath("//span[text()='Bhavya Sangam']")).isDisplayed();
		Assert.assertTrue(b);
		
	}

}
