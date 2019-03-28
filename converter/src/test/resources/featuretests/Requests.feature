Feature: Requests


  Scenario: Filtering RoleCodes from a user input field
    Given there is a valid user input
    And the user input has a field with name "role_codes" that is array with values
      | role_code1 |
      | role_code2 |
    And there is a valid response from /undervisningsaktiviteter/UA_ID
    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.href" with value "UE_HREF"
    When the personroller for the undervising entity are required
    Then the role of the each personrolle is either "role_code1" or "role_code2"
