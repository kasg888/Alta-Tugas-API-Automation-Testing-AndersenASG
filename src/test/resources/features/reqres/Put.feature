Feature: Put update user

  @Tugas
  Scenario Outline: Put update user with valid json and id
    Given Put update user with valid json and id <id>
    When Send put update user
    Then Status code should be 200 OK
    And Response put body name was "Andersen Sebastian Gunawan" and job was "QA Engineer"
    And Validate put update user JSON Schema
  Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |