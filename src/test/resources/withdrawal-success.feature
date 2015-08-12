Feature: Successful Withdrawal
	AS an ATM user
	I WANT to withdraw amount from my bank account 
	SO THAT I have cash in hand.

Scenario: Withdraw Button is Visible
	Given I am logged in
	When I am on Withdrawal Options Page
	Then Withdrawal Button should be displayed	

Scenario: Withdraw Button is clickable 
	Given I am logged in
		And I am on Withdrawal Options Page
	When I click on Withdrawal Button
	Then Cash Withdrawal Page should be displayed
	
Scenario: Withdraw functionality is Successful 
	Given I am logged in
		And I am on Cash Withdrawal Page
		And I enter 5000 in Amount to Withdraw text box
	When I click on Withdraw Button
	Then ATM Options Page is displayed		