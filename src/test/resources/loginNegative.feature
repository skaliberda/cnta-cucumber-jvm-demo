@login @done
Feature: Login negative cases functionality
	     As a Tester 
	     I want a login feature
	     So that I will get an access to jira in order to create and menage test cases

  Scenario Outline: As a Tester I forget the password and trying to login to the jira
    Given tester wants to login
    When tester provides credentials - <username> and <password>
    Then tester should see error message - Sorry, your username and password are incorrect - please try again.
 
    Examples:
    |username|password|
    |Tester  |test    |
    |Test    |test1234|
    |auto    |auto    |