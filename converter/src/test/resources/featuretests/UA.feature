#Feature:
#  Trasnformation of Undervisningsaktiviteter (UA: Teaching Activities )
#  UA records are transformed to Leganto Records in form of comma separated fields.
#  FS: Felles Studentsystem
#
#  Background:
#    Given  there is a user input
#    And the user input has a field with name "operation" with value "NORMAL"
#    And the user input has a field with name "campus_participants_file" with value "campus_participants_file.csv"
#    And the user input has a field with name "include_campus_participants" with boolean value "true"
#    And the user input has a field with name "number_of_participants_file" with value "number_of_participants.csv"
#    And the user input has a field with name "include_number_of_participants" with boolean value "true"
#    And the user input has a field with name "course_title_format" with value 1
#    And the user input has a field with name "language_order" that is an array with string values
#      | nn |
#      | nb |
#      | en |
#
#    And the user input has a field with name "include_ua" with boolean value "true"
#
#    And the campus participants file is a semicolon separated file
#    And the campus participants file contains a row with the following value
#      | UA_emneKode-emneVersjon-1980-HØST;GLOS\|10,DRAG\|20 |
#
#
#    And the number_of_participants file is a semicolon separated file
#    And the number_of_participants file contains a row with the following value
#      | UA_emneKode-emneVersjon-1980-HØST;123 |
#
#
#    And there is a request to /undervisningsaktiviteter/UA_ID
#    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.emne.href" with value "emne/emneId"
#    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.emne.kode" with value "emneKode"
#    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.emne.versjon" with value "emneVersjon"
#    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.semester.ar" with value "1980"
#    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.semester.termin" with value "HØST"
#
#    And the response from /undervisningsaktiviteter/UA_ID has a field "aktivitet" with value "MEAKB00000"
#    And the response from /undervisningsaktiviteter/UA_ID from FS has a field "navn" that is an array with the key-value pairs
#      | lang | nb | value | BokmalUANavn  |
#      | lang | nn | value | NynorskUANavn |
#      | lang | en | value | EngelskUANavn |
#    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.terminnummer" with value 12
#
#    And there is a request to /emne/emneId
#    And the response from /emne/emneId from FS has a field "navn" that is an array with the key-element pairs
#      | lang | nb | value | BokmalEmneNavn  |
#      | lang | nn | value | NynorskEmneNavn |
#      | lang | en | value | EnglishEmneNavn |
#    And the response from /emne/emneId from FS has a field "organisasjonsenheter" that is an array with the key-element pairs
#      | href | organisasjonsEnhetStudieUrl | type | STUDIE         |
#      | href | organizationEnhetAdminUrl   | type | ADMINISTRATIVT |
#
#    And there is a request to organisasjonsEnhetStudieUrl
#    And the response to organisasjonsEnhetUrl has a field "institusjon" with value 222
#    And the response to organisasjonsEnhetUrl has a field "fakultet" with value 39
#    And the response to organisasjonsEnhetUrl has a field "institutt" with value 7
#
#
#  Scenario: Update Leganto with new course information
#    And the user input has field with name "include_institute_in_acad_department" with value true
#    And the response from /undervisningsaktiviteter/UA_ID from FS has no field "perioder"
#
#    When a new UA Leganto entry has been generated
#    Then the courses in FS are populated in Leganto with the following data:
#      | CourseCode (mandatory)             |
#      | CourseTitle (mandatory)            |
#      | SectionId                          |
#      | AcademicDepartment                 |
#      | ProcessingDepartment (mandatory)   |
#      | Term1                              |
#      | Term2                              |
#      | Term3                              |
#      | Term4                              |
#      | StartDate                          |
#      | EndDate                            |
#      | NumberOfParticipants               |
#      | WeeklyHours                        |
#      | Year                               |
#      | SearchableId1                      |
#      | SearchableId2                      |
#      | AllSearchableIds                   |
#      | Instructor1                        |
#      | Instructor2                        |
#      | Instructor3                        |
#      | Instructor4                        |
#      | Instructor5                        |
#      | Instructor6                        |
#      | Instructor7                        |
#      | Instructor8                        |
#      | Instructor9                        |
#      | Instructor10                       |
#      | AllInstructors                     |
#      | Operation (mandatory)              |
#      | OldCourseCode (rollover only)      |
#      | OldCourseSectionId (rollover only) |
#      | SubmitByDate                       |
#      | CampusParticipants                 |
#      | ReadingListName                    |
#
#    And CourseCode is the string "UA_emneKode-emneVersjon-1980-HØST"
#    And CourseTitle is the string "NynorskEmneNavn - NynorskUANavn - emneKode HØST 1980"
#    And SectionId is the string "emneVersjon"
#    And AcademicDepartment is the  string "222_39_7"
#    And ProcessingDepartment is set to the invariant value LEGANTO
#    And Term1 is the string  "AUTUMN"
#    And Term2 is empty
#    And Term3 is empty
#    And Term4 is empty
#    And StartDate is the string "1980-08-01"
#    And EndDate is the string "1981-01-31"
#    And NumberOfParticipants has the value "123"
#    And WeeklyHours is empty
#    And Year has the value 1980
#    And SearchableId1 is empty
#    And SearchableId2 is empty
#    And AllSearchableIds is the string "UA_222_emneKode_emneVersjon_1980_HØST_12,MEAKB00000"
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
#    And CampusParticipants is the string "GLOS|10,DRAG|20"
#    And OldCourse Code is empty
#    And OldCourseSectionId is empty
#    And Reading List Name is empty
#
#  Scenario: Start date for the Spring semester
#    Given the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.semester.termin" with value "VÅR"
#    When a new UA Leganto entry has been generated
#    Then StartDate is the string "1980-01-01"
#    And EndDate is the string "1980-07-31"
#    And Term1 is the string  "SPRING"
#    And CourseCode is the string "UA_emneKode-emneVersjon-1980-VÅR"
#    And CourseTitle is the string "NynorskEmneNavn - NynorskUANavn - emneKode VÅR 1980"
#    And AllSearchableIds is the string "UA_222_emneKode_emneVersjon_1980_VÅR_12,MEAKB00000"
#
#
#  Scenario: UserInput field operation has value ROLLOVER
#    Given the user input field "operation" has the value "ROLLOVER"
#    When a new UA Leganto entry has been generated
#    Then Old Course Code is the string "UA_emneKode-emneVersjon-1979-HØST"
#    And Old Course Section ID is the string "emneVersjon"
#    And Operation is the string "ROLLOVER"
#
#  Scenario: UserInput field operation has value DELETE
#    Given the user input field "operation" has the value "DELETE"
#    When a new UA Leganto entry has been generated
#    Then Operation is the string "DELETE"
#    And OldCourse Code is empty
#    And OldCourseSectionId is empty
#
#
#  Scenario: User does include institute in AcademicDepartment
#    Given the user input field "include_institute_in_acad_department" has the boolean value "false"
#    When a new UA Leganto entry has been generated
#    Then AcademicDepartment is the  string "222_39"
#
#
#   Scenario: CourseTitle first alternative format
#     Given the user input has a field with name "course_title_format" with value 2
#     When a new UA Leganto entry has been generated
#     Then CourseTitle is the string "emneKode - NynorskEmneNavn - NynorskUANavn (HØST 1980)"
#
#
