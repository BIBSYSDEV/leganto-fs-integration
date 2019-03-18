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
      | emneKode-emneVersjon-1980-HØST | 123 |

    And there is a request to /undervisning/UE_ID
    And the response from /undervisning/UE_ID has a field with name "emne.href" and value "/emne/emneId"
    And the response from /undervisning/UE_ID has a field with name "emne.institusjon" and value "222"
    And the response from /undervisning/UE_ID has a field with name "emne.kode" and value "emneKode"
    And the response from /undervisning/UE_ID has a field with name "emne.versjon" and value "emneVersjon"
    And the response from /undervisning/UE_ID has a field with name "semester.ar" and value "1980"
    And the response from /undervisning/UE_ID has a field with name "semester.termin" and value "HØST"
    And the response from /undervisning/UE_ID has a field with name "terminnummer" and value "21"

    And there is a request to /emne/emneId
    And the response from /emne/emneId from FS has a field "navn" that is an array with the key-element pairs
      | lang | nb | value | BokmalEmneNavn  |
      | lang | nn | value | NynorskEmneNavn |
      | lang | en | value | EnglishEmneNavn |

    And the response from /emne/emneId from FS has a field "organisasjonsenheter" that is an array with the key-element pairs
      | href | organisasjonsEnhetStudieUrl | type | STUDIE         |
      | href | organizationEnhetAdminUrl   | type | ADMINISTRATIVT |

    And there is a request to organisasjonsEnhetStudieUrl
    And the response to organisasjonsEnhetUrl has a field "institusjon" with value 222
    And the response to organisasjonsEnhetUrl has a field "fakultet" with value 39
    And the response to organisasjonsEnhetUrl has a field "institutt" with value 7


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
    And the field AcademicDepartment in the UE entry is the  string "222_39_7"
    And the field ProcessingDepartment in the UE entry is the invariant string LEGANTO
    And the field Term1 in the UE entry is the string "HØST"
    And the field Term2 in the UE entry is empty
    And the field Term3 in the UE entry is empty
    And the field Term4 in the UE entry is empty
    And the field StartDate in the UE entry is the string "1980-08-01"
    And the field EndDate in the UE entry is the string "1980-01-31"
    And the field NumberOfParticipants in the UE entry is the integer 123
    And the field WeeklyHours in the UE entry is empty
    And the field Year in the UE entry has the value 1980
    And the field SearchableId1 in the UE entry is empty
    And the field SearchableId2 in the UE entry is empty
    And the field AllSearchableIds in the UE entry is the string "UE_222_emneKode_emneVersjon_1980_HØST_21,UA_222_emneKode_emneVersjon_1980_HØST_21"
    And the field Instructor1 in the UE entry is empty
    And the field Instructor2 in the UE entry is empty
    And the field Instructor3 in the UE entry is empty
    And the field Instructor4 in the UE entry is empty
    And the field Instructor5 in the UE entry is empty
    And the field Instructor6 in the UE entry is empty
    And the field Instructor7 in the UE entry is empty
    And the field Instructor8 in the UE entry is empty
    And the field Instructor9 in the UE entry is empty
    And the field Instructor10 in the UE entry is empty


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
