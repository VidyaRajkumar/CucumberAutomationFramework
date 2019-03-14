package com.Itv.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	By acceptCookiesBtn=By.id("cookie-message-accept");
	By categoriesLink=By.id("nav-primary-categories");
	
	
	public HomePage(WebDriver driver){
		this.driver=driver;
	}	
	
	public WebElement getAcceptCookiesButton(){
		return driver.findElement(acceptCookiesBtn);
	}
		
	public WebElement getCategoriesLink(){
		return driver.findElement(categoriesLink);
	}
	
	
	
}
