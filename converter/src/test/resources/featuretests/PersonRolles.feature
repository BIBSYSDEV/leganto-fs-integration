Feature: Instructors for each Leganto entry


  Scenario: AllInstructorIds string formation for UA Leganto Entries
    Given there is a valid user input
    And there is a valid response from /organizationsenheter/ORG_ID
    And there is a valid response from /emne/emneId

    And there is a valid response from /undervisningsaktiviteter/UA_ID
    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.href" with value "UE_HREF"

    And there is a list of personrolle entries for this undervisningsaktivitet with the following key-value pairs
      | undervisning.href | UE_HREF | person.href | /personer/PERSONID1 | person.personlopenummer | PERSONID1 |
      | undervisning.href | UE_HREF | person.href | /personer/PERSONID2 | person.personlopenummer | PERSONID2 |
      | undervisning.href | UE_HREF | person.href | /personer/PERSONID3 | person.personlopenummer | PERSONID3 |

    When a new UA Leganto entry has been generated
    Then AllInstructors is the string "PERSONID1,PERSONID2,PERSONID3"





