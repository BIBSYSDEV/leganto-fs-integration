#Feature:
#  Campus participants
#
#
#  Background:
#    Given there is a valid response from /undervisningsaktiviteter/UA_ID
#    Given there is a valid response from /organizationsenheter/ORG_ID
#    And there is a valid response from /emne/emneId
#    And there is a possibly empty personroller list
#    And there is a valid user input
#
#    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.emne.href" with value "emne/emneId"
#    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.emne.kode" with value "emneKode"
#    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.emne.versjon" with value "emneVersjon"
#    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.semester.ar" with value "1980"
#    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.semester.termin" with value "HØST"
#
#    And there is a valid response from /undervisning/UE_ID
#    And the response from /undervisning/UE_ID has a field with name "emne.href" and value "/emne/emneId"
#    And the response from /undervisning/UE_ID has a field with name "emne.institusjon" and value "222"
#    And the response from /undervisning/UE_ID has a field with name "emne.kode" and value "emneKode"
#    And the response from /undervisning/UE_ID has a field with name "emne.versjon" and value "emneVersjon"
#    And the response from /undervisning/UE_ID has a field with name "semester.ar" and value "1980"
#    And the response from /undervisning/UE_ID has a field with name "semester.termin" and value "HØST"
#
#
#  Scenario: campus participants in UA entry
#    Given the user input has a field with name "include_campus_participants" with boolean value "true"
#    And  the user input has a field with name "campus_participants_file" with value "campus_participants_file.csv"
#    And the campus participants file is a semicolon separated file
#    And the campus participants file contains a row with the following value
#      | UA_emneKode-emneVersjon-1980-HØST;GLOS\|10,DRAG\|20 |
#
#    When a new UA Leganto entry has been generated
#    Then CampusParticipants is the string "GLOS|10,DRAG|20"
#
#
#  Scenario: campus participants in UA entry
#    Given the user input has a field with name "include_campus_participants" with boolean value "false"
#    When a new UA Leganto entry has been generated
#    Then CampusParticipants is empty
#
#
#
#  Scenario:  number of participants in UA entry
#    Given the user input has a field with name "include_number_of_participants" with boolean value "true"
#    And the user input has a field with name "number_of_participants_file" with value "number_of_participants_file.csv"
#    And the number_of_participants file is a semicolon separated file
#    And the number_of_participants file contains a row with the following value
#      | UA_emneKode-emneVersjon-1980-HØST;123 |
#    When a new UA Leganto entry has been generated
#    Then  NumberOfParticipants is the string "123"
#
#
#  Scenario: exclusion of number of participants in UA entry
#    Given the user input has a field with name "include_number_of_participants" with boolean value "false"
#    When a new UA Leganto entry has been generated
#    Then NumberOfParticipants is empty
#
#
#  Scenario: campus participants in UE entry
#    Given the user input has a field with name "include_campus_participants" with boolean value "true"
#    And the user input has a field with name "campus_participants_file" with value "campus_participants_file.csv"
#
#    And the campus participants file is a semicolon separated file
#    And the campus participants file contains a row with the following value
#      | UE_emneKode-emneVersjon-1980-HØST;GLOS\|10,DRAG\|20 |
#
#    When a new UE Leganto entry has been generated
#    Then the field CampusParticipants in the UE entry is the string "GLOS|10,DRAG|20"
#
#  Scenario: campus participants in UE entry
#    Given the user input has a field with name "include_campus_participants" with boolean value "false"
#    When a new UE Leganto entry has been generated
#    Then the field CampusParticipants in the UE entry is empty
#
#
#
#  Scenario:  number of participants in UE entry
#    Given the user input has a field with name "include_number_of_participants" with boolean value "true"
#    And the user input has a field with name "number_of_participants_file" with value "number_of_participants_file.csv"
#    And the number_of_participants file is a semicolon separated file
#    And the number_of_participants file contains a row with the following value
#      | UE_emneKode-emneVersjon-1980-HØST;123 |
#    When a new UE Leganto entry has been generated
#    Then the field NumberOfParticipants in the UE entry is the integer 123
#
#
#  Scenario: exclusion of number of participants in UE entry
#    Given the user input has a field with name "include_number_of_participants" with boolean value "false"
#    When a new UE Leganto entry has been generated
#    Then the field NumberOfParticipants in the UE entry is empty
