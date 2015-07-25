Feature: Welcome Page
	AS an ATM user
	I WANT to see a meaningful welcome message on the screen 
	SO THAT I understand how to initiate a transaction at the ATM.

Scenario: Open application home page 
	Given this is my first attempt to access the application
	When I request application base url
	Then welcome page must be displayed
		And there must be bank logo on the page
		And there must be basic instructions to use the application
		And there must be a button to BEGIN the transaction
