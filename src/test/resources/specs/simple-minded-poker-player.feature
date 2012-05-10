Feature: Simple-Minded Poker Player

  Scenario: Joining the Server
    Given my name is "John"
    When I join the poker house
    Then I am known as "John"