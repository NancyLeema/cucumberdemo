Feature: Bookcart application demo

  Scenario: Login should be success
    Given User should navigate the application login
    And User clicks on the login link
    And User enters the username as "Nancyleema"
    And User enters the password as "Tharun0911"
    When User click on the login button
    Then login should be success
