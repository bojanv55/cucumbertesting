@market #feature inherited by all scenarios
Feature: Lines Market suspension

  #Background: description (common functionality for all Scenarios in feature)
  #  Given we have lines market that is in non-suspended state

  @suspend
  Scenario: Suspend market with all lines active
    Given we have lines market that is in non-suspended state
    And all market lines are in non-suspended state
    When we suspend the market
    Then market should be suspended
    And all market lines inside this market should be suspended

  @suspend
  Scenario: Suspend market with all lines already suspended

  In case that market lines are already suspended, when suspending the market,
  market lines should save previous state and restore that state on market re-activation

    Given we have lines market that is in non-suspended state
    But all market lines are suspended
    When we suspend the market
    Then market should be suspended
    And all market lines inside that market should remain suspended

  @mail @login
  Scenario: Mail processing
    When I login to the system
    Then I should receive mail containing:
      """
      Dear Sirs,
      Thanks.
      """
    And I should be logged out automatically

  Scenario: Suspend market on market suspension
    Given we have market that is in non-suspended state
    When we suspend the market
    Then market should be suspended

  Scenario: Suspend different markets
    Given these Markets
      | Market.Name |
      | THREE_WAY   |
      | PLAYERS     |
      | HANDICAP    |
    When we suspend the market
    Then market should be suspended

  Scenario: Using a table
    Given table like this
      |   | 1 | 2 | 3 |
      | 1 |   |   |   |
      | 2 |   |   |   |
      | 3 |   |   |   |
    When player x plays in row 2 column 2
    Then the board should look like
      |   | 1 | 2 | 3 |
      | 1 |   |   |   |
      | 2 |   | x |   |
      | 3 |   |   |   |
