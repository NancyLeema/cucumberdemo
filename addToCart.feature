Feature: Bookcart application demo

  Scenario Outline: Add a product to the cart
    Given User should navigate the application
    And user should login as "<username>" and "<password>"
    And user search a "<book>"
    When User add the book to the cart
    Then the cart badge should be updated

    Examples: 
      | username | password | book |
      |Nancyleema|Tharun0911|Birthday Girl|
