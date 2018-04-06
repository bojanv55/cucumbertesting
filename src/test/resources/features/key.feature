Feature: Key

  This is key manipulation feature

  Scenario: Change market key
    Given the key of market is 120
    When I increase market key for 10
    Then new market key should be 130

  Scenario Outline: Change market keys
    Given I have market with key <currentKey>
    When it is increased to <increment>
    Then change should be made to <newKey>

    Examples:
    | currentKey | increment | newKey |
    | 120        | 10        | 130    |
    | 150        | 20        | 170    |
