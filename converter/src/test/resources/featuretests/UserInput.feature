Feature:
  Inclusion of user files

#
#
  Background:
    Given there is a valid organization response
    Given there is a valid response from /undervisningsaktiviteter/UA_ID
    And there is a valid emne response
    And  there is a valid user input

    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.emne.href" with value "emne/emneId"
    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.emne.kode" with value "emneKode"
    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.emne.versjon" with value "emneVersjon"
    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.semester.ar" with value "1980"
    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.semester.termin" with value "HØST"


#    And the user input has a field with name "include_number_of_participants" with boolean value "false"
#    And the user input has a field with name "number_of_participants_file" with value "number_of_participants.csv"

  Scenario: campus participants in UA entry
    Given the user input has a field with name "include_campus_participants" with boolean value "true"
    And  the user input has a field with name "campus_participants_file" with value "campus_participants_file.csv"
    And the campus participants file is a semicolon separated file
    And the campus participants file contains a row with the following value
      | UA_emneKode-emneVersjon-1980-HØST;GLOS\|10,DRAG\|20 |

    When a new UA Leganto entry has been generated
    Then CampusParticipants is the string "GLOS|10,DRAG|20"

#
#  Scenario: campus participants in UE entry
#    And the campus participants file is a semicolon separated file
#    And the campus participants file contains a row with the following value
#      | UA_emneKode-emneVersjon-1980-HØST;GLOS\|10,DRAG\|20 |
#    When a new UE Leganto entry has been generated
#    Then CampusParticipants is the string "GLOS|10,DRAG|20"
#
#  Scenario:  number of participants in UA entry
#    And the number_of_participants file is a semicolon separated file
#    And the number_of_participants file contains a row with the following value
#      | UA_emneKode-emneVersjon-1980-HØST;123 |
#    When a new UA Leganto entry has been generated
#    Then NumberOfParticipants has the value 123
#
#
#  Scenario:  number of participants in UE entry
#    And the number_of_participants file is a semicolon separated file
#    And the number_of_participants file contains a row with the following value
#      | UA_emneKode-emneVersjon-1980-HØST;123 |
#    When a new UE Leganto entry has been generated
#    Then the field NumberOfParticipants in the UE entry is the integer 123
#



#    And the number_of_participants file is a semicolon separated file
#    And the number_of_participants file contains a row with the following value
#      | UA_emneKode-emneVersjon-1980-HØST;123 |


#    And the campus participants file is a semicolon separated file
#    And the campus participants file contains a row with the following value
#      | UE_emneKode-emneVersjon-1980-HØST;GLOS\|10,DRAG\|20 |
#
#    And the number_of_participants file is a semicolon separated file
#    And the number_of_participants file contains a row with the following value
#      | UE_emneKode-emneVersjon-1980-HØST;123 |
