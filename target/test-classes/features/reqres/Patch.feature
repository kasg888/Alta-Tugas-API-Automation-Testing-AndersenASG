Feature: Patch update user

  @Tugas
  Scenario Outline: Patch update user with valid json and id
    Given Patch update user with valid json and id <id>
    When Send patch update user
    Then Status code should be 200 OK
    And Response patch body name was "Andersen Sebastian Gunawan" and job was "QA Engineer"
    And Validate patch update user JSON Schema
  Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |