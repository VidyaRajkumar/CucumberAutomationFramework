package com.Itv.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoriesPage {
	
public WebDriver driver;
	
	By factualLink=By.xpath("//a[text()='Factual']");
	By factualProgrammeList=By.cssSelector("ul.grid-list.list-reset>li");
	By noLatestDocumentary=By.cssSelector("ul.grid-list.list-reset>li:nth-child(14)");
	By latestDocumentary=By.xpath("//div[text()='Latest']");
	By playButton=By.id("play");
	By signInHeading=By.xpath("//h1[text()='Sign in']");
	By togglePlayPauseButton=By.cssSelector("button.controls-toggle_button--play-pause");
	
	public CategoriesPage(WebDriver driver){
		this.driver=driver;
	}	
	
	public WebElement getFactualLink(){
		return driver.findElement(factualLink);
	}
	
	public WebElement getProgWithLatestDocumentary(){
		return driver.findElement(factualProgrammeList);
	}
	
	public List<WebElement> getFactualProgrammeList(){
		return driver.findElements(factualProgrammeList);
	}

	public WebElement getProgWithoutLatestDocumentary(){
		return driver.findElement(noLatestDocumentary);
	}
	
	public WebElement getLatestDocumentary(){
		return driver.findElement(latestDocumentary);
	}
	
	public WebElement getPlayButton(){
		return driver.findElement(playButton);
	}

	public WebElement getTogglePlayPauseButton(){
		return driver.findElement(togglePlayPauseButton);
	}
	
	public List<WebElement> getLatestDocumentaries(){
		return driver.findElements(latestDocumentary);
	}
}
