Feature: Google search

  @google
  Scenario Outline: I want to search in google site
    Given I am on a google site
    When I enter "<keyword>" as a keyword
    Then I should see search result page
    Then I should see at least <count> results

    Examples:
    |keyword |count     |
    |selenium|2         |
    |java    |5         |
    |spring  |5         |
