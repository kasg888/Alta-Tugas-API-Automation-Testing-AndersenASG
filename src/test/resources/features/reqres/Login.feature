Feature: Login

  @Tugas
  Scenario: Login with valid json
    Given Login user with valid json
    When Send login user
    Then Status code should be 200 OK
    And Validate login user JSON Schema

  @Tugas
  Scenario: Login with invalid json no password
    Given Login user with invalid json no password
    When Send login user
    Then Status code should be 400 Bad Request
    And Response body should be error "Missing password"
    And Validate error login user JSON Schema

  @Tugas
  Scenario: Login with invalid json no email
    Given Login user with invalid json no email
    When Send login user
    Then Status code should be 400 Bad Request
    And Response body should be error "Missing email or username"
    And Validate error login user JSON Schema