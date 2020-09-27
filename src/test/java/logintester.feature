#Author: Marin
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: User login to secondhand system
#Given: user enter into login page
#When: Type account name and password
#Then: login successful and enter main page 
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: User login
  I want to use this template for my feature file

  @tag1
  Scenario: Login Functionality
    Given user navigates to login.jsp page
    When user logs in using Username as “USER”
		And password as “password”
		Then login should be successful
		And Home page should be displayed

  @tag2
  Scenario Outline: Login Functionality
    Given user navigates to login.jsp page
    When user logs in using Username as <username> and Password <password>
    Then	login should be successful

    Examples: 
      |username         			 |password         |
			|Tom                     |password1        |
			|Harry                   |password2        |
			|Jerry                   |password3        |
