Feature: Instructors for each Leganto entry


  Background:
    Given there is a valid user input
    And the user input has a field with name "role_codes" that is an array with string values
      | ROLE_CODE  |
      | ROLE_CODE2 |
      | ROLE_CODE3 |

    Given there is a valid response from /undervisningsaktiviteter/UA_ID
    And the response from /undervisningsaktiviteter/UA_ID has a field "href" with value "UA_HREF"

    And there is a valid response from /personroller/PR_ID
    And the response from /personroller/PR_ID has a field "undervisning.href" with value "UA_HREF"
    And the response from /personroller/PR_ID has a field "person.href" with value "/roller/ROLLE_ID"
    And the response from /personroller/PR_ID has a field "person.personlopenummer" with value "PERSONID"

    And there is a valid response from /rolle/ROLLE_ID
    And the response from /rolle/ROLLE_ID has a field with name "kode" and value "ROLE_CODE"
    And there is a valid response from /organizationsenheter/ORG_ID
    And there is a valid response from /emne/emneId


  Scenario: UaLeganto entry
    Given there is a valid response from /personroller/PR_ID
    And the response from /personroller/PR_ID has a field "undervisning.href" with value "UA_HREF"
    And the response from /personroller/PR_ID has a field "person.href" with value "/roller/ROLLE_ID"
    And the response from /personroller/PR_ID has a field "person.personlopenummer" with value "PERSONID"
    When a new UA Leganto entry has been generated
    Then AllInstructors is the string "PERSONID"





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
