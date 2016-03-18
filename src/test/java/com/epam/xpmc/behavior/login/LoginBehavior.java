package com.epam.xpmc.behavior.login;

import com.epam.xpmc.behavior.BaseBehavior;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginBehavior extends BaseBehavior {

	private LoginAssert loginAssert = new LoginAssert();

	@Given("^tester wants to login$")
	public void tester_wants_to_login() throws Throwable {
		tester.atLoginPage().open();
	}

	@When("^tester provides credentials - ([^\\\"]*) and ([^\\\"]*)$")
	public void tester_provides_correct_credentials(String username, String password) throws Throwable {
//		System.out.println("Coming here results" + username + " " + password);
		tester.login(username, password);
	}

	@Then("^tester should see Test Management plugin welcome page$")
	public void tester_should_see_Test_Management_plugin_welcome_page() throws Throwable {
		loginAssert.checkThatTestManagemantPageOpened();
		tester.logout();
	}

	@Then("^tester should see error message - ([^\\\"]*)$")
	public void tester_should_see_login_page(String errorMessage) throws Throwable {
		loginAssert.checkErrorMessageOnLoginPage(errorMessage);
//		tester.logout();
	}
}
