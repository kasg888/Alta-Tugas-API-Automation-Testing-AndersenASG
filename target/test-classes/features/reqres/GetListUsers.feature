Feature: Get list users

  @Tugas
  Scenario Outline: Get list user with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send get lists users
    Then Status code should be 200 OK
    And Response body page should be page <page>
    And Validate get list user JSON Schema
  Examples:
      | page |
      | 1    |
      | 2    |

  @Tugas
  Scenario Outline: Get list user with invalid parameter page
    Given Get list users with invalid parameter page <page>
    When Send get lists users
    Then Status code should be 400 Bad Request
  Examples:
    | page |
    | satu |
    | dua  |
    | @@   |
    | !%   |

  @Tugas
  Scenario Outline: Get list user with invalid parameter number page
    Given Get list users with invalid parameter number page <page>
    When Send get lists users
    Then Status code should be 404 Not Found
  Examples:
    | page |
    | 23   |
    | 44   |

  @Tugas
  Scenario: Get list users resource
    Given Get list users resource
    Then Status code should be 200 OK
    And Validate get list users resource JSON Schema