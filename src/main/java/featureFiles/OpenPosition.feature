@tag
Feature:  Initialize browser instance and go to Citrix

  Background:
    Given go to Citrix page

  @tag2
  Scenario Outline:
    Given "Acceder" welcome text is displayed on Citrix page
    When I add "username" and "password"
    Then Show password on the screen
    And Click on Google Next button

    Examples:
      | username | password |
      | gustavo.gp@globant.com | Tae2024* |


