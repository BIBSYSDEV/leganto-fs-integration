Feature:
  Trasnformation of Undervisningsaktiviteter (UA: Teaching Activities )
  UA records are transformed to Leganto Records in form of comma separated fields.
  FS: Felles Studentsystem

  Scenario: Update Leganto with new course information
    Given that it is 00:00 on 23rd of November
    And there is a scheduling system setup to request course updates in Leganto
    When the scheduling system requests an update
    Then the courses in FS are populated in Leganto with the following data:
      | Course Code (mandatory) |
      |Course Title (mandatory) |
      |Section ID               |
      |Academic Department      |
      |Processing Department (mandatory)|
      |Term1|
      |Term2|
      |Term3|
      |Term4|
      |Start Date|
      |End Date|
      |Number of Participants|
      |Weekly Hours|
      |Year|
      |Searchable ID 1|
      |Searchable ID 2|
      |ALL_SEARCHABLE_IDS|
      |Instructor 1|
      |Instructor 2|
      |Instructor 3|
      |Instructor 4|
      |Instructor 5|
      |Instructor 6|
      |Instructor 7|
      |Instructor 8|
      |Instructor 9|
      |Instructor 10|
      |ALL_INSTRUCTORS|
      |Operation (mandatory)|
      |Old Course Code (rollover only)|
      |Old Course Section ID (rollover only)|
      |Submit By Date|
      |Campuses and Campus Participants|
      |Reading List Name|
    And  CourseCode is a concatenation of the values emne.kode, emne.versjon, semester.ar, semester.termin from FS-API: /undervisingsaktiviteter/{id}
    And  CouseTitle is the value of emne.navn from FS-API: /emner/{id}
    And  Section ID is the concatenation of the values emne.versjon, undervisningsaktivitetet.navn from FS-API: /undervisingsaktiviteter/{id}
    And  Academic Department is the snake-case concatenation of values of organisasjonsenheter.institusjon, organisasjonsenheter.fakultet, organisasjonsenheter.institutt from the FS-API: /organisasjonsenheter/{id}
    And  Processing Department is set to invariant value LEGANTO
    And  Term1 is the value of semester.termin from FS-API:  /undervisingsaktiviteter/{id}
    And  Term1 has either the value HØST or VÅR
    And  Term2 is the value of semester.termin from FS-API:  /undervisingsaktiviteter/{id}
    And  Term2 has either the value HØST or VÅR
    And  Term2 does not have the same value as Term1
    And  Term3 is empty
    And  Term3 is empty
    And  StartDate is min value of

