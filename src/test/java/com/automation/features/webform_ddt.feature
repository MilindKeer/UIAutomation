Feature: Data-Driven Testing for Web Form

  Scenario Outline: Validate text input, password, and dropdown selection using CSV data
    Given User is on the web form page for DDT
    When User enters text "<text_input>" in the text input field
    And User enters password "<password>" in the password field
    And User selects dropdown "<dropdown_option>" from the dropdown
    Then The text input field should populate "<text_input>"
    And The password field should populate "<password>"
    And The dropdown should have populate "<dropdown_option>"

  Examples: 
    | text_input | password  | dropdown_option |
    | test_1 | password_1 | One |
    | test_2 | password_2 | Two |
    | test_3 | password_3 | Three |