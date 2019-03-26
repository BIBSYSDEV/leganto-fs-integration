Feature: Instructors for each Leganto entry


  Background:
    Given there is a valid user input
    And the user input has a field with name "instructor_rolles" that is an array with string values
      | rolle1 |
      | rolle2 |
      | rolle3 |

    And the user input has a field with name "ims_codes" that is an array with string values
      | ims1 |
      | ims2 |
      | ims3 |
##
  Scenario: UaLeganto entry

    Given there is a valid response from /undervisningsaktiviteter/UA_ID
    And there is a personrolle entry with id PR_ID connected to the undervisingsaktivitet with id "UA_ID"
    And the personrolle entry with id PR_ID has as role one of the roles mentioned in the user input field "role_codes"
#    And the personrolle entry has a "person" entry with id "PID"
#    And there is a FEIDE id "FID" for the person entry with id "PID"
#    When a new UA Leganto entry has been generated
#    Then the field AllInstructors should contain the value "FID"
#
#
#    Given there is an undervinsingsaktivitet with id "UA_ID"
#    And there is a personrolle entry with id "PR_ID" connected to the undervisingsaktivitet with id "UA_ID"
#    And there is a personrolle entry with id "PR_ID2" connected to the undervisingsaktivitet with id "UA_ID2"
#    And the personrolle entry with id "PR_ID" has as role one of the roles mentioned in the user input field "role_codes"
#    And the personrolle entry with id "PR_ID2" has as role one of the roles mentioned in the user input field "role_codes"
#    And the personrolle entry with id "PR_ID1" has a "person" entry with id "PID1"
#    And the personrolle entry with id "PR_ID2" has a "person" entry with id "PID2"
#    And there is a FEIDE id "FID1" for the person entry with id "PID1"
#    And there is a FEIDE id "FID2" for the person entry with id "PID2"
#    When a new UA Leganto entry has been generated
#    Then the field AllInstructors should contain the value "FID1,FID2"
#
#    Given there is an undervinsingsaktivitet with id "UA_ID"
#    And there is a personrolle entry with id PR_ID connected to the undervisingsaktivitet with id "UA_ID"
#    And the personrolle entry with id PR_ID has as role one of the roles mentioned in the user input field "role_codes"
#    And the personrolle entry has a "person" entry with id "PID"
#    And there is a FEIDE id "FID" for the person entry with id "PID"
#    When a new UA Leganto entry has been generated
#    Then the field AllInstructors should contain the value "FID"
#
#
#
#
