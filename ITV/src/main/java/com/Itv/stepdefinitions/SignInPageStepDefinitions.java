package com.Itv.stepdefinitions;


import org.apache.log4j.Logger;
import org.testng.Assert;

import com.Itv.helper.LoggerHelper;
import com.Itv.pageObjects.SignInPage;
import com.Itv.testBase.TestBase;

import cucumber.api.java.en.Then;

public class SignInPageStepDefinitions  extends TestBase {
	
	SignInPage signInPage=new SignInPage(driver);
	private static Logger log =LoggerHelper.getLogger(SignInPageStepDefinitions.class);
	
	@Then("^I see Sign in page$")
	public void i_see_Sign_in_page() throws Throwable {
		Assert.assertTrue(signInPage.getSignInHeading().isDisplayed());
		log.info("User seeing a SignIn page on clicking the documentary play button");
	}

	@Then("^I enter valid Email \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void i_enter_valid_Email_and_Password(String email, String password) throws Throwable {
		signInPage.getEmail().sendKeys(email);
		signInPage.getPassword().sendKeys(password);
	}
	
	@Then("^I click on Sign in button$")
	public void i_click_on_Sign_in_button() throws Throwable {
		signInPage.getSignInButton().click();
	}

	@Then("^I enter valid Email \"([^\"]*)\" and invalid Password \"([^\"]*)\"$")
	public void i_enter_valid_Email_and_invalid_Password(String email, String password) throws Throwable {
		signInPage.getEmail().sendKeys(email);
		signInPage.getPassword().sendKeys(password);
	}

	@Then("^I see a error message$")
	public void i_see_a_error_message() throws Throwable {
		String expectedErrorMessage="Please check your email and password then try again";
		String actualErrorMessage = signInPage.getSignInError().getText();
		
		Assert.assertTrue(expectedErrorMessage.equals(actualErrorMessage));
		log.info("Error message thrown :"+actualErrorMessage);
		log.info("The user with invalid credentials cannot view the latest available documentary ");
		
	}	
}