@login @done
Feature: Login functionality
	     As a Tester 
	     I want a login feature
	     So that I will get an access to jira in order to create and menage test cases

  Scenario: As a Tester I want to be able to login to the jira system
    Given tester wants to login
    When tester provides credentials - Tester and test1234
    Then tester should see Test Management plugin welcome page