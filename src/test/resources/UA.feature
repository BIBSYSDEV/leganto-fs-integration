Feature:
  Trasnformation of Undervisningsaktiviteter (UA: Teaching Activities )
  UA records are transformed to Leganto Records in form of comma separated fields.
  FS: Felles Studentsystem


  Background:
    Given that it is time for an update
    And there is a scheduling system setup to request course updates in Leganto
    And there is a user input
    And the user input has a field with name "operation" with a non-empty value
    And the user input has a field with name "number_of_participants"
    And the user input has a filed with name "campus_participants"
    And the value of the field  "campus_participants" is an array


  Scenario: Update Leganto with new course information
    When the scheduling system requests an update
    Then the courses in FS are populated in Leganto with the following data:
      | Course Code (mandatory)               |
      | Course Title (mandatory)              |
      | Section ID                            |
      | Academic Department                   |
      | Processing Department (mandatory)     |
      | Term1                                 |
      | Term2                                 |
      | Term3                                 |
      | Term4                                 |
      | Start Date                            |
      | End Date                              |
      | Number of Participants                |
      | Weekly Hours                          |
      | Year                                  |
      | Searchable ID 1                       |
      | Searchable ID 2                       |
      | ALL_SEARCHABLE_IDS                    |
      | Instructor 1                          |
      | Instructor 2                          |
      | Instructor 3                          |
      | Instructor 4                          |
      | Instructor 5                          |
      | Instructor 6                          |
      | Instructor 7                          |
      | Instructor 8                          |
      | Instructor 9                          |
      | Instructor 10                         |
      | ALL_INSTRUCTORS                       |
      | Operation (mandatory)                 |
      | Old Course Code (rollover only)       |
      | Old Course Section ID (rollover only) |
      | Submit By Date                        |
      | Campuses and Campus Participants      |
      | Reading List Name                     |
    And CourseCode is the snake-case  concatenation of the literal "UA" and of the values emne.kode, emne.versjon, semester.ar, semester.termin from FS-API: /undervisngsaktiviteter/{id}
    And CouseTitle is the value of emne.navn from FS-API: /emner/{id}
    And Section ID is the concatenation of the values emne.versjon, undervisningsaktivitetet.navn from FS-API: /undervisingsaktiviteter/{id}
    And Academic Department is the snake-case concatenation of values of organisasjonsenheter.institusjon, organisasjonsenheter.fakultet, organisasjonsenheter.institutt from the FS-API: /organisasjonsenheter/{id}
    And Processing Department is set to invariant value LEGANTO
    And Term1 is the value of semester.termin from FS-API:  /undervisingsaktiviteter/{id}
    And Term1 has either the value HØST or VÅR
    And Term2 is the value of semester.termin from FS-API:  /undervisingsaktiviteter/{id}
    And Term2 has either the value HØST or VÅR
    And Term2 does not have the same value as Term1
    And Term3 is empty
    And Term3 is empty
    And StartDate is  min_i(periods[i].fraDato) from FS-API: /undervisngsaktiviteter/{id}
    And EndDate is the max_i(periods[i]).tilDato from FS-API: /undervisningsaktiviteter/{id}
    And Number of Participants is the value specified by the user input
    And Weekly Hours is empty
    And Year is the value of semester.ar from FS-API: /undervisngsaktiviteter/{id}
    And Searchable ID1 is empty
    And Searchable ID2 is empty
    And ALL_SEARCHABLE_IDS is a comma separated list
    And ALL_SEARCHABLE_IDS contains a value UA_${emne.institusjon}_${emne.kode}_${emne.versjon}_${semester.ar}_${semester.kode}_Terminnr_${aktivitet} from FS-API: /undervisngsaktiviteter/{id}
    And ALL_SEARCHABLE_IDS contains emne.kode from FS-API: /undervisngsaktiviteter/{id}
    And Instructor1 is empty
    And Instructor2 is empty
    And Instructor3 is empty
    And Instructor4 is empty
    And Instructor5 is empty
    And Instructor6 is empty
    And Instructor7 is empty
    And Instructor8 is empty
    And Instructor9 is empty
    And Instructor10 is empty
    And ALL_INSTRUCTORS is not empty
    And Operation is value of the field "operation" of the input
    And Submit By Date is empty
    And Campuses and Campus Participants has the value of the user input field "campus_participants"
    And Reading List Name is empty


  Scenario: Update Leganto with new course information
   Given the user input field "operation" has the value "rollover"
    When the scheduling system requests an update
    Then all the fields are populated correctly
    And Old Course Code is the snake-case concatentation of the literal "UA" and of the values emne.kode, emne.versjon, semester.ar-1, semester.termin from FS-API: /undervisngsaktiviteter/{id}
    And Old Course Section ID has the value of Section ID

  Scenario: Update Leganto with new course information
    Given the user input field "operation" has not the value "rollover"
    When the scheduling system requests an update
    Then all the fields are populated correctly
    And Old Course Code is empty
    And Old Course Section empty
