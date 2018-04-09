Feature: Market suspension

  This line describes market suspension

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
