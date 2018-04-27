Feature: Three aggregates communicate

  @high_risk
  @fast
  Scenario Outline: When one aggregate invoked communicate with others
    Given Configuration is empty
    When Configuration changed key for match <matchid> to <key>
    Then Match updated key to <key>

    Examples:
    | matchid | key |
    | 1       | 2   |
    | 2       | 7   |
    | 3       | 20  |
    | 4       | 55  |
