package com.epam.xpmc.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import com.epam.xpmc.core.Driver;

public class BasePage {

  public WebDriver getDriver() {
    return Driver.getInstance();
  }
  
//  Simulation of keys to browser
  public void simulateKeys(Keys key){
	  Actions action = new Actions(getDriver());
	  action.sendKeys(key).build().perform();
  }
  
//  keys sending
	public void simulateKeys(WebElement element, Keys key){
		element.sendKeys(key);
	}
	
	public void simulateKeys(WebElement element, String key){
		element.sendKeys(key);
	}
	
	public void simulateKeys(WebElement element, Keys key, Keys key2){
		String keysChain = Keys.chord(key, key2);
		element.sendKeys(keysChain);
	}
	
	public void simulateKeys(WebElement element, Keys key, String key2){
		String keysChain = Keys.chord(key, key2);
		element.sendKeys(keysChain);
	}

//	element presence verification
	public boolean isElementPresent(WebElement element) {
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		} finally {
			getDriver().manage().timeouts()
					.implicitlyWait(10, TimeUnit.SECONDS);
		}
		return true;
	}
	
	public int getElementsCount(By locator ){
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		int elementsCount = getDriver().findElements(locator).size();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return elementsCount;
		
	}
}
