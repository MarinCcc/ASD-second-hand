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
  Scenario: User login to secondhand system
    Given I enter into login page
    When I Type account name and password
    Then I login successful and enter main page 

