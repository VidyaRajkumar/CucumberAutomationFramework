package com.Itv.stepdefinitions;


import com.Itv.pageObjects.HomePage;
import com.Itv.testBase.TestBase;
import java.io.FileInputStream;
import java.util.Properties;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class HomePageStepDefinitions extends TestBase{

	HomePage homePage = new HomePage(driver);
	public Properties prop;
	
	@Given("^I am on ITVHub website$")
	public void i_am_on_ITVHub_website() throws Throwable {
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\environment.properties");
		prop.load(fis);	
		String itvUrl=prop.getProperty("url");
		driver.get(itvUrl);
		
		//This accepts the cookies button if its not already set
		try{
			homePage.getAcceptCookiesButton().click();
		}catch(Exception e){
			
		}
	}

	@When("^I click on Categories section$")
	public void i_click_on_Categories_section() throws Throwable {
		homePage.getCategoriesLink().click();
	}

	
}