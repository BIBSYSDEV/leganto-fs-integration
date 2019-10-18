Feature: Instructors for each UE Leganto entry



  Background:
    Given there is a valid user input
    And the user input has a field with name "start_dato_modifier" with value 0
    And the user input has a field with name "slutt_dato_modifier" with value 0

    And there is a valid response from /organizationsenheter/ORG_ID
    And there is a valid response from /emne/emneId
    And there is a valid response from /undervisning/UE_ID
    And the response from /undervisning/UE_ID has a field with name "href" and value "UE_HREF"


    And there is a list of personrolle entries for this undervisningsaktivitet with the following key-value pairs
      | undervisning.href | UE_HREF | person.href | /personer/123 | person.personlopenummer | 123 |
      | undervisning.href | UE_HREF | person.href | /personer/234 | person.personlopenummer | 234 |
      | undervisning.href | UE_HREF | person.href | /personer/345 | person.personlopenummer | 345 |

    And there is a valid response from /personner for the following ids
      |personlopenummer|123|brukernavn|feideId1@someDomain.com|
      |personlopenummer|234|brukernavn|feideId2@otherDomain.com|
      |personlopenummer|345|brukernavn|feideId3|

  Scenario: AllInstructorIds string formation for UE Leganto Entries
    Given the user input has a field with name "feide_domain" with value "@userdomain.com"

    When a new UE Leganto entry has been generated with persons

    Then the field AllInstructors in the UE entry is the string "feideId1@someDomain.com,feideId2@otherDomain.com,feideId3@userdomain.com"


#  Scenario: AllInstructorIds string formation for UE Leganto Entries
#    Given the user input has a field with name "feide_domain" and value "@userdomain.com"
#    Given each response from /personer has respectively the following field values
#      |personnummer|feideId1|
#      |personnummer|feideId2|
#      |personnummer|feideId3@thirdDomain.com|
#
#    When a new UE Leganto entry has been generated
#    Then the field AllInstructors in the UE entry is the string "feideId1@userdomain.com,feideId2@userdomain.com,feideId3@thirdDomain.com"
#
#
#
#  Scenario: AllInstructorIds string formation for UE Leganto Entries
#    Given the user input has no field with name "feide_domain"
#    Given each response from /personer has respectively the following field values
#      |personnummer|feideId1|
#      |personnummer|feideId2|
#      |personnummer|feideId3@thirdDomain.com|
#
#    When a new UE Leganto entry has been generated
#    Then the field AllInstructors in the UE entry is the string "feideId3@thirdDomain.com"
#
#
#
