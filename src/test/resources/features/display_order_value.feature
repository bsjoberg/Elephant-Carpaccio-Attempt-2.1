Feature: Display order value
	As a retail online shopper
	I want to have my final order value displayed
	So that I can see my total purchase amount
	
	Scenario Outline: Display total value
		Given I am buying an item
		When I have <number> items at <price>
		Then my final order value is <total>
		
		Examples:
		| number | price  | total  |
		|    1   | $10    |  $10   |
		|    1   | $20    |  $20   |
		|    1   | $19.99 | $19.99 |

	Scenario: Display total value with tax rate
		Given I am buying an item
		When I have 1 item at $20
		And the tax is 5%
		Then my final order value is $21

	Scenario Outline: Display total value when using different state codes
		Given I am buying an item
		When I have <number> items at <price>
		And the state code is "<state code>"
		Then my final order value is <order value>

		Examples:
		| number | price | state code | order value |
		|  1     | $30   |  UT        |  $32.06     |
		|  2     | $30   |  NV        |  $64.80     |
		|  2     | $40   |  TX        |  $85.00     |
		|  3     | $30   |  AL        |  $93.60     |
		|  3     | $30   |  CA        |  $97.43     |

	Scenario: Display total when a 3% discount is applied
		Given I am buying items
		When I have 10 items at $100
		And the state code is "UT"
		Then my final order value is $1036.45
		And I am notified of my "3%" discount

	Scenario: Display total when a 5% discount is applied
		Given I am buying items
		When I have 10 items at $500
		And the state code is "AL"
		Then my final order value is $4940.00
		And I am notified of my "5%" discount