@podcast
Feature: Get Podcast


  Scenario Outline: Validate that the user can find the podcast id from list of podcasts
    Given the user searches for all podcasts
    When the user gets the show's details
    Then season "<season>" has "<episodes>" episodes
    And Season "6" episode "5" title is "Massacre at the Tree of Life Synagogue | JE"
    Examples:
      | season | episodes |
      |1       | 10       |

