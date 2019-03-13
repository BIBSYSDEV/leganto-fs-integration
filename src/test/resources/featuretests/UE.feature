#Feature:
#  Trasnformation of Undervisningsenheter (UE: Teaching entities)
#  UE records are transformed to Leganto Records in form of comma separated fields.
#  FS: Felles Studentsystem


#  Background:
#    Given there is a user input
#    And the user input has a field with name "operation" with value "operation_value"
#    And the user input has a field with name "number_of_participants" with value 2
#    And the user input has a field with name "campus_participants" is an array  with values
#      | participant1 |
#      | particiapnt2 |
#
#    And there is a request to /undervisning/UE_ID
#    And the response from /undervising/UE_ID has a field with name "emne.href" with value "emneHref"
#    And the response from /undervising/UE_ID has a field with name "emne.institusjon" with value "emneInstitusjon"
#    And the response from /undervising/UE_ID has a field with name "emne.kode" with value "emneKode"
#    And the response from /undervising/UE_ID has a field with name "emne.versjon" with value "emneVersjon"
#    And there is a request to /emne/emneId
#    And there is a request to /emne/emneId
#    And the response from /emne/emneId from FS has a field "navn" that is an array with the key-element pairs
#      | lang | nb | value | BokmalText |
#      | lang | nn | value | NynorskText|
#      | lang | en | value | EnglishText|
#
#    And the response from /emne/emneId from FS has a field "organisasjonsenheter" that is an array with the key-element pairs
#      | href | organizationEnhetUrl | type| STUDIE|
#      | href | organizationEnhetUrl | type| ADMINISTRATIVT |
##
##
#  Scenario: Update Leganto with new undervisning information
#   When a new UE entry is generated
#    Then the courses in FS are populated in Leganto with the following data:
#      | Course Code (mandatory)               |
#      | Course Title (mandatory)              |
#      | Section ID                            |
#      | Academic Department                   |
#      | Processing Department (mandatory)     |
#      | Term1                                 |
#      | Term2                                 |
#      | Term3                                 |
#      | Term4                                 |
#      | Start Date                            |
#      | End Date                              |
#      | Number of Participants                |
#      | Weekly Hours                          |
#      | Year                                  |
#      | Searchable ID 1                       |
#      | Searchable ID 2                       |
#      | ALL_SEARCHABLE_IDS                    |
#      | Instructor 1                          |
#      | Instructor 2                          |
#      | Instructor 3                          |
#      | Instructor 4                          |
#      | Instructor 5                          |
#      | Instructor 6                          |
#      | Instructor 7                          |
#      | Instructor 8                          |
#      | Instructor 9                          |
#      | Instructor 10                         |
#      | ALL_INSTRUCTORS                       |
#      | Operation (mandatory)                 |
#      | Old Course Code (rollover only)       |
#      | Old Course Section ID (rollover only) |
#      | Submit By Date                        |
#      | Campuses and Campus Participants      |
#      | Reading List Name                     |
#    Then CourseCode is the string "emneKode-emneVersjon-1980-HØST"
#    And CouseTitle is the string "BokmalText"
#    And Section ID is the string
#    And Section ID is the concatenation of the values emne.versjon, undervisningsaktivitetet.navn from FS-API: /undervisingsaktiviteter/{id}
#    And Academic Department is the snake-case concatenation of values of organisasjonsenheter.institusjon, organisasjonsenheter.fakultet, organisasjonsenheter.institutt from the FS-API: /organisasjonsenheter/{id}
#    And Processing Department is set to invariant value LEGANTO
#    And Term1 is the value of semester.termin from FS-API:  /undervisingsaktiviteter/{id}
#    And Term1 has either the value HØST or VÅR
#    And Term2 is the value of semester.termin from FS-API:  /undervisingsaktiviteter/{id}
#    And Term2 has either the value HØST or VÅR
#    And Term2 does not have the same value as Term1
#    And Term3 is empty
#    And Term3 is empty
#    And StartDate is  min_i(periods[i].fraDato) from FS-API: /undervisngsaktiviteter/{id}
#    And EndDate is the max_i(periods[i]).tilDato from FS-API: /undervisningsaktiviteter/{id}
#    And Number of Participants is the value specified by the user input
#    And Weekly Hours is empty
#    And Year is the value of semester.ar from FS-API: /undervisngsaktiviteter/{id}
#    And Searchable ID1 is empty
#    And Searchable ID2 is empty
#    And ALL_SEARCHABLE_IDS is a comma separated list
#    And ALL_SEARCHABLE_IDS contains a value UA_${emne.institusjon}_${emne.kode}_${emne.versjon}_${semester.ar}_${semester.kode}_Terminnr_${aktivitet} from FS-API: /undervisngsaktiviteter/{id}
#    And ALL_SEARCHABLE_IDS contains emne.kode from FS-API: /undervisngsaktiviteter/{id}
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
#    And ALL_INSTRUCTORS is not empty
#    And Operation is value of the field "operation" of the input
#    And Submit By Date is empty
#    And Campuses and Campus Participants has the value of the user input field "campus_participants"
#    And Reading List Name is empty
#
#
#  Scenario: Update Leganto with new course information
#   Given the user input field "operation" has the value "rollover"
#    When the scheduling system requests an update
#    Then all the fields are populated correctly
#    And Old Course Code is the snake-case concatentation of the literal "UA" and of the values emne.kode, emne.versjon, semester.ar-1, semester.termin from FS-API: /undervisngsaktiviteter/{id}
#    And Old Course Section ID has the value of Section ID
#
#  Scenario: Update Leganto with new course information
#    Given the user input field "operation" has not the value "rollover"
#    When the scheduling system requests an update
#    Then all the fields are populated correctly
#    And Old Course Code is empty
#    And Old Course Section empty
