Feature: Delete user

  @Tugas
  Scenario Outline: Delete user with valid parameter id
    Given Delete user with valid id <id>
    When Send delete user
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |
      | 2  |