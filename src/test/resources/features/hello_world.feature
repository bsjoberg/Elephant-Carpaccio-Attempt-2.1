Feature: Hello World

Scenario: Make sure hello world is working
	Given I have a hello world app
	When I run hello world
	Then hello world is displayed