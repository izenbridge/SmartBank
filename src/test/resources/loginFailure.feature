Feature: login Failure
As an User
I should not be login with incorrect credentials
so that unauthorised access can be restricted
			

Scenario: login failure with no credential inputs
	Given home page is available with card no and PIN input boxes
	When user clicks login button
	Then show error msg stating Invalid Debit Card number! Please enter a valid 16-digit Debit Card number
			

