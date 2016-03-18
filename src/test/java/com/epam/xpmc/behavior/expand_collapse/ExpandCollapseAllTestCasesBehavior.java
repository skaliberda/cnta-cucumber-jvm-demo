package com.epam.xpmc.behavior.expand_collapse;

import java.util.List;

import com.epam.xpmc.behavior.BaseBehavior;
import com.epam.xpmcdata.TestCase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExpandCollapseAllTestCasesBehavior extends BaseBehavior {

  private ExpandCollapseAllTestCasesAssert expandCollapseAllTestCasesAssert = new ExpandCollapseAllTestCasesAssert();

  @Given("^tester enters a set of test cases with steps and expected results$")
  public void Tester_enters_a_set_of_test_cases_with_steps_and_expected_results
  (List<TestCase> listTestCases) throws Throwable {
	  //tester.login("Tester", "test1234");
	  tester.atPlanPage().open();
	  tester.atPlanPage().cleanAllFoldersAndTestCases();
	    
	  for (TestCase testCaseToAdd : listTestCases) {
		  tester.atPlanPage().createTestCase(testCaseToAdd.getFolderName(), testCaseToAdd.getTestCaseName(),
				  testCaseToAdd.getStep(), testCaseToAdd.getExpectedResult());
	  }
  }

  @When("^tester expands all test cases$")
  public void Tester_expands_all_test_cases() throws Throwable {
	  tester.atPlanPage().testStepsAreHidden();
	  tester.atPlanPage().expandsAllTestSteps();
  }

  @Then("^tester should see \"([^\"]*)\" steps and expected results for all test cases$")
  public void Tester_should_see_steps_and_expected_results_for_all_test_cases(String testCasesCount) throws Throwable {
	  expandCollapseAllTestCasesAssert.checkThatAllTestStepsAreExpanded(testCasesCount);
	  tester.logout();
  }
  
  @When("^tester collapses all test cases$")
  public void Tester_collapse_all_test_cases() throws Throwable {
	  tester.atPlanPage().testStepsAreShown();
	  tester.atPlanPage().collapseAllTestSteps();
  }

  @Then("^tester should not see \"([^\"]*)\" steps and expected results for all test cases$")
  public void Tester_should_not_see_steps_for_all_test_cases(String testCasesCount) throws Throwable {
	  expandCollapseAllTestCasesAssert.checkThatAllTestStepsAreCollapsed(testCasesCount);
	  tester.logout();
  }
}