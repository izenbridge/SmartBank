Feature: Login Success
	AS an ATM user
	I WANT to be able to login successfully
	SO THAT I can initiate a transaction at the ATM.

Scenario: Open login success page 
	Given I am in the login page 
	When I try to login with ATM PIN and card number
	Then login success page must be displayed				