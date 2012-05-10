Feature: Simple-Minded Poker Player

  Scenario: Joining the Server
    Given my nick is "John"
    When I join the poker house
    Then I am known as "John"
    
  Scenario: Sit at a table
    Given I have registered as "John"
    When I sit down at a table
    Then I am sitting at that table
    