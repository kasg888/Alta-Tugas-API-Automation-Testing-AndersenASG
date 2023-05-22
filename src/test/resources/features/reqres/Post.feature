Feature: Post create new user

  @Tugas
  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send post create user
    Then Status code should be 201 Created
    And Response body name was "Andersen Sebastian Gunawan" and job was "QA Engineer"
    And Validate post create user JSON Schema