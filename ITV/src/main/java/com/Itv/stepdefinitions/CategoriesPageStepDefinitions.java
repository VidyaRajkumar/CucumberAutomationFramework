package com.Itv.stepdefinitions;

import java.util.List;
//import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Itv.helper.LoggerHelper;
import com.Itv.pageObjects.CategoriesPage;
import com.Itv.testBase.TestBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CategoriesPageStepDefinitions  extends TestBase {
	
	CategoriesPage catPage=new CategoriesPage(driver);
	List<WebElement> factualProgrammeList;
	WebDriverWait wait = new WebDriverWait(driver,45);
	private static Logger log =LoggerHelper.getLogger(CategoriesPageStepDefinitions.class);
	
	@When("^I click on Factual category$")
	public void i_click_on_Factual_category() throws Throwable {
	   catPage.getFactualLink().click();
	}

	@Then("^I see a list of Factual Programmes$")
	public void i_see_a_list_of_Factual_Programmes() throws Throwable {
	   factualProgrammeList=catPage.getFactualProgrammeList();
	   Assert.assertTrue(factualProgrammeList.size()>0);
	   log.info("User is seeing list of Factual Programs");
	   log.info("There are "+factualProgrammeList.size()+" Factual Programmes available");
	   
	}

	@When("^I click on a particular Factual Programme$")
	public void i_click_on_a_particular_Factual_Programme() throws Throwable {
		catPage.getProgWithLatestDocumentary().click();
	}
	
	/*This method can be used for random clicking on any factual programme but i have covered both positive and negative cases with and without latest documentaries separately in other scenarios.
	 *So this is not really required .For your reference
	 @Then("^I click on a random Factual Programme$")
	public void i_click_on_a_random_Factual_Programme() throws Throwable {
		Random r = new Random();
		int randomValue = r.nextInt(factualProgrammeList.size()); //Getting a random value that is between 0 and (list's size)-1
		
		try{
			factualProgrammeList.get(randomValue).click();
		}catch(NoSuchElementException e){
		
			log.info("There is no Latest documentary present for this Factual Programme:"+factualProgrammeList.get(randomValue).toString());
		}
	}*/
	
	@Then("^I see the latest available documentary$")
	public void i_see_the_latest_available_documentary() throws Throwable {
		Assert.assertTrue(catPage.getLatestDocumentary().isDisplayed());
		log.info("User sees the latest available documentary");
	}
	
	@Then("^I click on the latest available documentary$")
	public void i_click_on_the_latest_available_documentary() throws Throwable {
	   catPage.getLatestDocumentary().click();
	}

	@Then("^I click on play button$")
	public void i_click_on_play_button() throws Throwable {
		catPage.getPlayButton().click();
	}
	
	@Then("^I can view the latest available documentary$")
	public void i_can_view_the_latest_available_documentary() throws Throwable {
		
		//waiting for the actual video to play with a wait of 60 seconds with advertisement in the beginning ideally plays for 30-40seconds)
		Thread.sleep(60000);
		
		Actions action=new Actions(driver);
		//clicks on Pause button
		action.moveToElement(catPage.getTogglePlayPauseButton()).click().perform();
		Thread.sleep(5000);
		
		//clicks on Play button
		action.moveToElement(catPage.getTogglePlayPauseButton()).click().perform();
		log.info("The user with valid credentials can view the latest available documentary ");
	}

	@When("^I click on a Factual Programme$")
	public void i_click_on_a_Factual_Programme() throws Throwable {
		catPage.getProgWithoutLatestDocumentary().click();
			    
	}

	@Then("^I see there is no latest documentary available$")
	public void i_see_there_is_no_latest_documentary_available() throws Throwable {
		
		//here finding the list of latest documentary videos
	    List<WebElement> latestDocumentaries=catPage.getLatestDocumentaries();
	    
	    //the size of the list will be zero and hence verifies that there is no latest documentary available
	    Assert.assertFalse(latestDocumentaries.size()>0);
	    log.info("There is a Factual Program present without the latest documentary available");
	   
	}

}

