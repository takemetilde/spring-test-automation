@Test2
Feature: Query JsonPlaceholder API

  Scenario: Sequential Execution, Check JsonPlaceholder API
    Given the headers:
      | content-type     | accept           |
      | application/json | application/json |
    When the client gets the post: 2
    Then the server returns the response code: 200
#    Then the server returns the response:
#      | userId | id | title                            | body                                                                                                                                                              |
#      | 2      | 1  | et ea vero quia laudantium autem | delectus reiciendis molestiae occaecati non minima eveniet qui voluptatibus\naccusamus in eum beatae sit\nvel qui neque voluptates ut commodi qui incidunt\nut animi commodi |
