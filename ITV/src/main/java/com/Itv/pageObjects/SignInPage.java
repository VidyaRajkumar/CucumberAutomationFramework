package com.Itv.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
	
public WebDriver driver;
	
	By signInHeading=By.xpath("//h1[text()='Sign in']");
	By email=By.id("login-email");
	By password=By.id("login-password");
	By signInButton=By.id("login-submit");
	//By signInError=By.id("form-login-error");
	By signInError=By.xpath("//div[text()='Please check your email and password then try again']");
	
	public SignInPage(WebDriver driver){
		this.driver=driver;
	}	
	
	public WebElement getSignInHeading(){
		return driver.findElement(signInHeading);
	}
	
	public WebElement getEmail(){
		return driver.findElement(email);
	}
	
	public WebElement getPassword(){
		return driver.findElement(password);
	}

	public WebElement getSignInButton(){
		return driver.findElement(signInButton);
	}
	
	public WebElement getSignInError(){
		return driver.findElement(signInError);
	}
	

}
