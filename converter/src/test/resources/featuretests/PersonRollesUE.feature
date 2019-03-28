Feature: Instructors for each UE Leganto entry



  Background:
    Given there is a valid user input
    And there is a valid response from /organizationsenheter/ORG_ID
    And there is a valid response from /emne/emneId

    And there is a valid response from /undervisnings/UE_ID
    And the response from /undervisning/UE_ID has a field "href" with value "UE_HREF"


    And there is a list of personrolle entries for this undervisningsaktivitet with the following key-value pairs
      | undervisning.href | UE_HREF | person.href | /personer/PERSONID1 | person.personlopenummer | PERSONID1 |
      | undervisning.href | UE_HREF | person.href | /personer/PERSONID2 | person.personlopenummer | PERSONID2 |
      | undervisning.href | UE_HREF | person.href | /personer/PERSONID3 | person.personlopenummer | PERSONID3 |

    And there is a valid response from /personner for the following ids
      |PERSONID1|
      |PERSONID2|
      |PERSONID3|

  Scenario: AllInstructorIds string formation for UE Leganto Entries

    Given each response from /personer has respectively the following field values
    |personnummer|feideId1@someDomain.com|
    |personnummer|feideId2@otherDomain.com|
    |personnummer|feideId3@thirdDomain.com|

    When a new UE Leganto entry has been generated
    Then the field AllInstructors in the UE entry is the string "feideId1@someDomain.com,feideId2@otherDomain.com,feideId3@thirdDomain.com"


  Scenario: AllInstructorIds string formation for UE Leganto Entries
    Given the user input has a field with name "feide_domain" and value "@userdomain.com"
    Given each response from /personer has respectively the following field values
      |personnummer|feideId1|
      |personnummer|feideId2|
      |personnummer|feideId3@thirdDomain.com|

    When a new UE Leganto entry has been generated
    Then the field AllInstructors in the UE entry is the string "feideId1@userdomain.com,feideId2@userdomain.com,feideId3@thirdDomain.com"



  Scenario: AllInstructorIds string formation for UE Leganto Entries
    Given the user input has no field with name "feide_domain"
    Given each response from /personer has respectively the following field values
      |personnummer|feideId1|
      |personnummer|feideId2|
      |personnummer|feideId3@thirdDomain.com|

    When a new UE Leganto entry has been generated
    Then the field AllInstructors in the UE entry is the string "feideId3@thirdDomain.com"



