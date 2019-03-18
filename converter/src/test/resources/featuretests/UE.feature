Feature:
  Trasnformation of Undervisningsenheter (UE: Teaching entities)
  UE records are transformed to Leganto Records in form of comma separated fields.
  FS: Felles Studentsystem


  Background:
    Given there is a user input
    And the user input has no field with name "operation"
    And the user input has a field with name "participants_file" with value "participants.csv"
    And the user input has a field with name "campus_participants" that is an array with string values
      | GLØS |
      | DRAG |

    And the user input has a field with name "language_order" that is an array with string values
      | nn |
      | nb |
      | en |

    And the participants file is a semicolon separated file
    And the participants file contains a row with the following values
      | UA_emneKode-emneVersjon-1980-HØST | 123 |

    And there is a request to /undervisning/UE_ID
    And the response from /undervisning/UE_ID has a field with name "emne.href" and value "/emne/emneId"
    And the response from /undervisning/UE_ID has a field with name "emne.institusjon" and value "222"
    And the response from /undervisning/UE_ID has a field with name "emne.kode" and value "emneKode"
    And the response from /undervisning/UE_ID has a field with name "emne.versjon" and value "emneVersjon"
    And the response from /undervisning/UE_ID has a field with name "semester.ar" and value "1980"
    And the response from /undervisning/UE_ID has a field with name "semester.termin" and value "HØST"

    And there is a request to /emne/emneId
    And the response from /emne/emneId from FS has a field "navn" that is an array with the key-element pairs
      | lang | nb | value | BokmalEmneNavn  |
      | lang | nn | value | NynorskEmneNavn |
      | lang | en | value | EnglishEmneNavn |

#    And the response from /emne/emneId from FS has a field "organisasjonsenheter" that is an array with the key-element pairs
#      | href | organisasjonsEnhetStudieUrl | type | STUDIE         |
#      | href | organizationEnhetAdminUrl   | type | ADMINISTRATIVT |
#
#
#
  Scenario: Update Leganto with new undervisning information
    When a new UE Leganto entry has been generated
    Then the new UE Leganto entry has the following fields
      | CourseCode (mandatory)             |
      | CourseTitle (mandatory)            |
      | SectionId                          |
      | AcademicDepartment                 |
      | ProcessingDepartment (mandatory)   |
      | Term1                              |
      | Term2                              |
      | Term3                              |
      | Term4                              |
      | StartDate                          |
      | EndDate                            |
      | NumberOfParticipants               |
      | WeeklyHours                        |
      | Year                               |
      | SearchableId1                      |
      | SearchableId2                      |
      | AllSearchableIds                   |
      | Instructor1                        |
      | Instructor2                        |
      | Instructor3                        |
      | Instructor4                        |
      | Instructor5                        |
      | Instructor6                        |
      | Instructor7                        |
      | Instructor8                        |
      | Instructor9                        |
      | Instructor10                       |
      | AllInstructors                     |
      | Operation (mandatory)              |
      | OldCourseCode (rollover only)      |
      | OldCourseSectionId (rollover only) |
      | SubmitByDate                       |
      | CampusParticipants                 |
      | ReadingListName                    |
    And the field CourseCode in the UE entry is the string "emneKode-emneVersjon-1980-HØST"
    And the field CouseTitle in the UE entry is the string "NynorskEmneNavn"
    And the field SectionId  in the UE entry is the string "emneVersjon"
#    And AcademicDepartment is the  string "222_39_7"
#    And ProcessingDepartment is set to the invariant value LEGANTO
#    And Term1 is the string  "HØST"
#    And Term2 is empty
#    And Term3 is empty
#    And Term4 is empty
#    And StartDate is the string "1980-08-01"
#    And EndDate is the string "1980-01-31"
#    And NumberOfParticipants has the value 123
#    And WeeklyHours is empty
#    And Year has the value 1980
#    And SearchableId1 is empty
#    And SearchableId2 is empty
#    And AllSearchableIds is the string "UA_222_emneKode_emneVersjon_1980_HØST_12_MEAKB00000"
#    And Instructor1 is empty
#    And Instructor2 is empty
#    And Instructor3 is empty
#    And Instructor4 is empty
#    And Instructor5 is empty
#    And Instructor6 is empty
#    And Instructor7 is empty
#    And Instructor8 is empty
#    And Instructor9 is empty
#    And Instructor10 is empty
##    And AllInstructors is not empty
#    And Operation is empty
#    And SubmitByDate is empty
#    And CampusParticipants is the string "GLØS,DRAG"
#    And Reading List Name is empty
##
##
##  Scenario: Update Leganto with new course information
##   Given the user input field "operation" has the value "rollover"
##    When the scheduling system requests an update
##    Then all the fields are populated correctly
##    And Old Course Code is the snake-case concatentation of the literal "UA" and of the values emne.kode, emne.versjon, semester.ar-1, semester.termin from FS-API: /undervisngsaktiviteter/{id}
##    And Old Course Section ID has the value of Section ID
##
##  Scenario: Update Leganto with new course information
##    Given the user input field "operation" has not the value "rollover"
##    When the scheduling system requests an update
##    Then all the fields are populated correctly
##    And Old Course Code is empty
##    And Old Course Section empty
