@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file

 	Background:
 	Given I Landed on Ecommerce page

  @Regression
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and <password>
    When I add product <productName> in the cart
    And Checkout the <productName> and submit order
    Then "THANKYOU FOR THE ORDER." is displayed on confirmation page

    Examples: 
      | name  								|  password		    |	productName   |
      | rahulshetty@gmail.com |  Iamking@000    | Banarsi Saree | 
