Feature: Get single user

  @Tugas
  Scenario Outline: Get single user with valid id
    Given Get single user with valid id <id>
    When Send get single user
    Then Status code should be 200 OK
    And Response body id should be id <id>
    And Validate get single user JSON Schema
  Examples:
    | id |
    | 1  |
    | 2  |
    | 3  |

  @Tugas
  Scenario Outline: Get single user with invalid ig
    Given Get single user with invalid id <id>
    When Send get single user
    Then Status code should be 400 Bad Request
  Examples:
    | id   |
    | satu |
    | dua  |
    | @@   |
    | !%   |

  @Tugas
  Scenario Outline: Get single user with invalid id
    Given Get single user with invalid number id <id>
    When Send get single user
    Then Status code should be 404 Not Found
  Examples:
    | id |
    | 23 |
    | 44 |

  @Tugas
  Scenario Outline: Get single user resource with valid id
    Given Get single user resource with valid id <id>
    When  Send get single user resource
    Then Status code should be 200 OK
    And Response body id should be id <id>
    And Validate get single user resource JSON Schema
  Examples:
    | id |
    | 1  |
    | 2  |
    | 3  |

  @Tugas
  Scenario Outline: Get single user resource with invalid id
    Given Get single user resource with invalid id <id>
    When Send get single user resource
    Then Status code should be 404 Not Found
  Examples:
      | id |
      | 23 |
      | 44 |