Feature: Documentaries are available
As a user of ITV Hub
I want to see a list of Factual programmes
So that I can view the latest available documentaries

Background: User navigates to Factual category in ITV Hub site and sees a list of Factual programmes 
	
	Given I am on ITVHub website
	When I click on Categories section
	And I click on Factual category
	Then I see a list of Factual Programmes
	

Scenario: User can view the latest available documentaries(user with valid credentials)

	When I click on a particular Factual Programme
	Then I see the latest available documentary
	And I click on the latest available documentary
	And I click on play button
	And I see Sign in page
	And I enter valid Email "vidyar2006@gmail.com" and Password "123456"
	And I click on Sign in button
	And I can view the latest available documentary 
	
Scenario: User cannot view the latest available documentaries(user with invalid credentials)

	When I click on a particular Factual Programme
	And I see the latest available documentary
	And I click on the latest available documentary
	And I click on play button
	And I see Sign in page
	And I enter valid Email "vidyar2006@gmail.com" and invalid Password "12dfdfdf6"
	And I click on Sign in button
	And I see a error message
	
Scenario: Negative scenario to check the presence of factual programme for which there is no latest documentery available

	When I click on a Factual Programme
	Then I see there is no latest documentary available
	