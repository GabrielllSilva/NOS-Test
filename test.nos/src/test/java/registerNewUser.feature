Feature: Register a new user on NOS website
	Like a have first contact with NOS
	I want to register on NOS database
	For enjoy all the benefits that the clients have


Scenario: Register a new user
	Given I am acess the nos website
	When click on Registe-se
	And fill the form for register
	Then a new user must be register with success