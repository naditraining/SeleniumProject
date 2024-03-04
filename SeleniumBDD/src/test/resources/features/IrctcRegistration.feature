Feature: Irctc registration

#Background:
#  Given As a end user registering to irctc portal
#  When I enter basic details

  @smoke @e2e
  Scenario: Irctc registration as a end user
    Given As a user launching the irctc portal
    When I enter basic details
    When I enter personal details
    When I enter address details
    Then registration is complete

  @smoke @e2e @exceltest
  Scenario Outline: Irctc registration as a end user
    Given I read test data for '<testcase>'
    And As a user launching the irctc portal
    When I enter basic details
    And I enter personal details
    When I enter address details
    And registration is complete

    Examples:
    |testcase|
    |TC1|
    |TC2|




