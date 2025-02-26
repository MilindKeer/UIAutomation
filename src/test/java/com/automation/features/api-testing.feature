Feature: API Testing for public API

  Scenario: Fetching list of posts from JSONPlaceholder API
    Given User sends a GET request to "https://jsonplaceholder.typicode.com/posts"
    Then Response status should be 200
    And Response body should contain "userId"

