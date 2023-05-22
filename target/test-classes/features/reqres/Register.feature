Feature: Register

  @Tugas
  Scenario: Register with valid json
    Given Register user with valid json
    When Send register user
    Then Status code should be 200 OK
    And Validate register user JSON Schema

  @Tugas
  Scenario: Register with invalid json no password
    Given Register user with invalid json no password
    When Send register user
    Then Status code should be 400 Bad Request
    And Response body should be error "Missing password"
    And Validate error register user JSON Schema

  @Tugas
  Scenario: Register with invalid json no email
    Given Register user with invalid json no email
    When Send register user
    Then Status code should be 400 Bad Request
    And Response body should be error "Missing email or username"
    And Validate error register user JSON Schema