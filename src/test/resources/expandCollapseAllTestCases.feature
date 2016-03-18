@plan @done
Feature: Expand/Collapse all test cases functionality
         As a Tester 
	     I want an expand/collapse all test cases feature
	     So that I will be able to see test cases steps and expected results

  Scenario: As a Tester I want to see all steps for test cases 
    Given tester provides credentials - Tester and test1234
    And tester enters a set of test cases with steps and expected results
      | folderName        | testCaseName | step                        | expectedResult           |
      | Test Management   | login        | 1. open app                 | 1. application is opened |
      | Test Management   | login        | 2. login                    | 2. user is logged in     |
      | Test Management   | register     | 1. open app                 | 1. application is opened |
      | Test Management   | register     | 2. enter user name          | 2. user name is entered  |
      | Test Management   | register     | 3. enter password           | 3. password is entered   |
      | Test Management   | register     | 4. click register button    | 4. user is registered    |
    When tester expands all test cases
    Then tester should see "2" steps and expected results for all test cases
    
  Scenario: As a Tester I want to hide steps for test cases
    Given tester provides credentials - Tester and test1234
    And tester enters a set of test cases with steps and expected results
      | folderName        | testCaseName | step                        | expectedResult           |
      | Test Management   | login        | 1. open app                 | 1. application is opened |
      | Test Management   | login        | 2. login                    | 2. user is logged in     |
      | Test Management   | register     | 1. open app                 | 1. application is opened |
      | Test Management   | register     | 2. enter user name          | 2. user name is entered  |
      | Test Management   | register     | 3. enter password           | 3. password is entered   |
      | Test Management   | register     | 4. click register button    | 4. user is registered    |
    When tester collapses all test cases
    Then tester should not see "2" steps and expected results for all test cases