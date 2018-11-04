#Author: Semra Cengiz
#
#Keywords Summary : This feature file contains test Login in scenario for JOUST
#
@Search @allTests
Feature: Indeed website search the jobs with keyword 
Scenario: Validate the job searching with the specific keyword and list the result successfully 
	Given I click FindJobs link in main page 
	When I enter "Joust" keyword in the what input box
		And I enter "Istanbul" location to the where input box
		And I click Find Jobs button
	Then I should see the results which are including "Joust"
	