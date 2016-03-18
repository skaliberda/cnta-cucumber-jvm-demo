package com.epam.xpmc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	//login
	@FindBy(id = "login-form-username")
	private WebElement loginField;

	@FindBy(id = "login-form-password")
	private WebElement passwordField;
	
	@FindBy(id = "login-form-submit")
	public WebElement loginButton;
	
	//logout
	@FindBy(xpath="//span/img")
	private WebElement avatarImg;
	
	@FindBy(id="log_out")
	private WebElement logOutLink;
	
//	select a project  
	@FindBy(xpath="//div[@class='tm-project-selector']")
	private WebElement projectCarusel; 
	
	@FindBy(id="TA")
	private WebElement projectTA;
	
	@FindBy(xpath="//div[@class='tm-project-label']")
	private WebElement projectLabel;
	
	public void open() {
		getDriver().get("http://10.253.133.10:8080/secure/TestManagementAction.jspa?projectKey=TA");
	}
	
	public void fillForm(String username, String password) {
		loginField.sendKeys(username);
		passwordField.sendKeys(password);
	}

	public void clickLogInButton() {
		loginButton.click();
	}
	
	
	public void clickOnAvatar(){
		avatarImg.click();
	}
	
	public void clickOnLogOutButton(){
		logOutLink.click();
	}
	
	
	public void selectProject(){
		if(!projectLabel.getText().equals("Automation Test Management")){
			projectCarusel.click();
			projectTA.click();
		}
	}
}
