Feature: Starting a Game

  (see also https://gist.github.com/2232599/b58ee0b7d0429cc042307338cd592a3e18b6e41b)
  
  In order to be able to play at the poker house,
  As a player, I want to be able to come in and start a game.
  
  I know this works when...

  Scenario: I can register as a player with the game
    Given my nick is "John"
    When I join the poker house
    Then I am known as "John"
    
  Scenario: I can sit down at a table
    Given I have registered as "John"
    When I sit down at a table
    Then I am sitting at that table
    
  Scenario: I can start a game
  
  
  Scenario: the security build load is correct
    Given that the security build runs
    When I compare CSM_SECURITY
    Then the data between baseline and new code are identical
    