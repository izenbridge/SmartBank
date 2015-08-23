Feature: Login Home Page
	AS an ATM user
	I WANT to see a meaningful Login Home screen 
	SO THAT I can enter my details to make a transaction.

Scenario: Open application home page 
	Given I am on the welcome page
	When I click on BEGIN button
	Then Login Home page must be displayed
		And there must be text field to enter Debit Card Number
		And there must be password field to enter the password
		And there must be a button to Submit the details
