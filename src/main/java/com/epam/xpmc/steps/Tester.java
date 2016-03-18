package com.epam.xpmc.steps;

import org.openqa.selenium.support.PageFactory;

import com.epam.xpmc.core.Driver;
import com.epam.xpmc.pages.PlanPage;
import com.epam.xpmc.pages.LoginPage;

public class Tester {

  private LoginPage loginPage = PageFactory.initElements(Driver.getInstance(), LoginPage.class);
  private PlanPage planPage = PageFactory.initElements(Driver.getInstance(), PlanPage.class);

  public LoginPage atLoginPage() {
    if (loginPage == null) {
     loginPage = PageFactory.initElements(Driver.getInstance(), LoginPage.class);
    }
    return loginPage;
  }

  public PlanPage atPlanPage() {
	  if (planPage == null) {
		  planPage = PageFactory.initElements(Driver.getInstance(), PlanPage.class);
	  }
	  return planPage;
  }

  public void login(String login, String password) throws InterruptedException {
	atLoginPage().open();
      Thread.sleep(1000);
	if(atLoginPage().isElementPresent(atLoginPage().loginButton)){
	    atLoginPage().fillForm(login, password);
	    atLoginPage().clickLogInButton();
	}
//	atLoginPage().selectProject();
  }
  
  public void logout(){
	  atLoginPage().clickOnAvatar();
	  atLoginPage().clickOnLogOutButton();
  }

}
