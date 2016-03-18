package com.epam.xpmc.behavior.expand_collapse;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.epam.xpmc.behavior.BaseBehavior;
import com.epam.xpmc.core.Driver;

public class ExpandCollapseAllTestCasesAssert extends BaseBehavior {

	public void checkThatAllTestStepsAreExpanded(String expectedTestDetailsNamber) {
		Assert.assertTrue(expectedTestDetailsNamber.equals(Integer.toString(Driver.getInstance().findElements(By.xpath("//div[contains(@class, 'tm-test-steps-node')]")).size())));  
	}

	public void checkThatAllTestStepsAreCollapsed(String expectedTestCasesCount) {
		Assert.assertTrue(expectedTestCasesCount.equals(Integer.toString(Driver.getInstance().findElements(By.xpath("//div[contains(@class, 'tm-test-case-hidden')]")).size())));
	}
}