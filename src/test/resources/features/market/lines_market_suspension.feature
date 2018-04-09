Feature: Lines Market suspension

  #Background: description (common functionality for all Scenarios in feature)
  #  Given we have lines market that is in non-suspended state

  Scenario: Suspend market with all lines active
    Given we have lines market that is in non-suspended state
    And all market lines are in non-suspended state
    When we suspend the market
    Then market should be suspended
    And all market lines inside this market should be suspended

  Scenario: Suspend market with all lines already suspended

  In case that market lines are already suspended, when suspending the market,
  market lines should save previous state and restore that state on market re-activation

    Given we have lines market that is in non-suspended state
    But all market lines are suspended
    When we suspend the market
    Then market should be suspended
    And all market lines inside that market should remain suspended
