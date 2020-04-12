Feature: Query JsonPlaceholder API

  Scenario: Sequential Execution, Check JsonPlaceholder API
    Given the headers:
      | content-type     | accept           |
      | application/json | application/json |
    When the client gets the post: 1
    Then the server returns the response code: 200
    Then the server returns the response:
      |