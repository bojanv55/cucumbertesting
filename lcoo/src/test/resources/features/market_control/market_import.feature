Feature: Market import from external source

  In order to work with market, we need to import it from external DTOs into this bounded context

  Scenario: Import single-line market with probabilities
    Given market description that we receive from external source with following details:
      | marketId |
      | 1        |
    And following probabilities
      | marketId | outcomeId | probability |
      | 1        | 1         | 0.33        |
      | 1        | 2         | 0.33        |
      | 1        | 3         | 0.33        |
    When we import that market description into this bounded context
    Then imported market should have all properties set correctly
