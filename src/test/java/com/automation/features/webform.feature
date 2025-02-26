Feature: Web Form UI Testing

  Scenario: Verify form elements are visible and interactable
    Given User is on the web form page

    # Text Input Validation
    When User enters "Test User" in the text input field
    Then The text input field should contain "Test User"

    # Password Input Validation
    When User enters "Secret@123" in the password field
    Then The password field should not be empty

    # Textarea Validation
    When User enters "This is a test message" in the textarea field
    Then The textarea field should contain "This is a test message"

    # Disabled Input Validation
    Then The disabled input field should not be editable

    # Read-Only Input Validation
    Then The read-only input field should contain "Readonly input"

    # Dropdown (Select) Validation
    When User selects "Two" from the dropdown menu
    Then The dropdown menu should have "Two" selected

    # Dropdown (Datalist) Validation
    When User enters "New York" in the datalist input field
    Then The datalist input field should contain "New York"

    # File Input Validation
    When User uploads a file "sample.txt"
    Then The file input field should display "sample.txt"

    # Checkbox Validation
    When User checks the checked checkbox
    Then The checked checkbox should be selected

    # Radio Button Validation
    When User selects the checked radio button
    Then The checked radio button should be selected

    # Color Picker Validation
    When User selects the color "#ff5733"
    Then The color picker should show "#ff5733"

    # Date Picker Validation
    When User selects "2025-03-10" in the date picker
    Then The date picker should display "2025-03-10"

    # Range Slider Validation
    When User moves the range slider to "7"
    Then The range slider should show "7"

    # Form Submission
    When User clicks the submit button
    Then User should see the message "Received!"
