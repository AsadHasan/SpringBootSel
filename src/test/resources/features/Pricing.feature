Feature: Pricing models

  Background:
    Given I am on the pricing page
  @chrome
  Scenario Outline: Verify correct prices are returned for the number of parallel tests per user
    Given I select "<package>"
    When I choose "<parallelTests>"
    Then correct "<price>" is returned

    Examples:
    |package|parallelTests|price|
    |live   |2 parallel tests (Up to 5 users)|99|
    |Automate|4parallel tests (Up to 10 users)|299|
    |Automate Pro|5 parallel tests (Up to 5 users)|499|
