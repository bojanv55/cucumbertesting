Feature: Key manipulation

  This is key manipulation feature

  Scenario: Change market key
    #120 can be escaped as (\\d+) or ([0-9]*) or ...
    Given the key of market is 120
    #markets? u captureu znaci da moze i market i markets
    When I increase market key for 10
    #koristimo (?:new|changed) da na 2 nacina kazemo istu stvar new market ili 2 step changed market
    Then new market key should be 130

  Scenario Outline: Change market keys
    #with <> we define where real values will be substituted
    Given I have market with <initial key>
    When it is increased using some <increment>
    Then market should have <new key>

    Examples: Basic examples
      New key is equal to initial+increment

      | initial key | increment | new key |
      | 1020        | 100       | 1120    |
      | 150         | 20        | 170     |

    Examples: More advanced ones
      | initial key | increment | new key |
      | 1           | 1         | 2       |
      | 2           | 1         | 3       |
