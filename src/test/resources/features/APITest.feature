@Test1
Feature: Query JsonPlaceholder API

  Scenario: Sequential Execution, Check JsonPlaceholder API
    Given the headers:
      | content-type     | accept           |
      | application/json | application/json |
    When the client gets the post: 1
    Then the server returns the response code: 200
    Then the server returns the response:
      | userId | id | title                                                                      | body                                                                                                                                                              |
      | 1      | 1  | sunt aut facere repellat provident occaecati excepturi optio reprehenderit | quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto |

