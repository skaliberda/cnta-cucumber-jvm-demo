package com.epam.xpmc.behavior.login;

import org.openqa.selenium.By;
import static junit.framework.Assert.assertTrue;

import com.epam.xpmc.pages.LoginPage;

public class LoginAssert extends LoginPage {

    public void checkThatUserOnLoginPage() {
        assertTrue(getDriver().findElement(By.id("login-form-submit")).isDisplayed());
    }

    public void checkErrorMessageOnLoginPage(String errorMessage) {
        assertTrue(getDriver().findElement(By.xpath("//p[contains(text(),'" + errorMessage + "')]")).isDisplayed());
    }

    public void checkThatTestManagemantPageOpened() {
        assertTrue(getDriver().findElement(By.id("plan-link")).isDisplayed());
    }
}
