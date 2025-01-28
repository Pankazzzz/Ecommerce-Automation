@tag
Feature: Error Validation
  I want to use this template for my feature file

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I Landed on Ecommerce page
    When Logged in with username <name> and <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name  								|  password		     |	
      | rahulshetty@gmail.com |  Iamking@0       | 
