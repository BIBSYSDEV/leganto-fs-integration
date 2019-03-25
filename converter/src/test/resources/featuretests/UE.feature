#Feature:
#  Trasnformation of Undervisningsenheter (UE: Teaching entities)
#  UE records are transformed to Leganto Records in form of comma separated fields.
#  FS: Felles Studentsystem
#
#
#  Background:
#    Given  there is a valid user input
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
#    And the user input has a field with name "include_institute_in_acad_department" with value "true"
#
#
#
#    And there is a request to /undervisning/UE_ID
#    And the response from /undervisning/UE_ID has a field with name "emne.href" and value "/emne/emneId"
#    And the response from /undervisning/UE_ID has a field with name "emne.institusjon" and value "222"
#    And the response from /undervisning/UE_ID has a field with name "emne.kode" and value "emneKode"
#    And the response from /undervisning/UE_ID has a field with name "emne.versjon" and value "emneVersjon"
#    And the response from /undervisning/UE_ID has a field with name "semester.ar" and value "1980"
#    And the response from /undervisning/UE_ID has a field with name "semester.termin" and value "HØST"
#    And the response from /undervisning/UE_ID has a field with name "terminnummer" and value "12"
#
#    And there is a request to /emne/emneId
#    And the response from /emne/emneId from FS has a field "navn" that is an array with the key-element pairs
#      | lang | nb | value | BokmalEmneNavn  |
#      | lang | nn | value | NynorskEmneNavn |
#      | lang | en | value | EnglishEmneNavn |
#
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
##
##
#  Scenario: Update Leganto with new undervisning information
#    When a new UE Leganto entry has been generated
#    Then the new UE Leganto entry has the following fields
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
#    And the field CourseCode in the UE entry is the string "UE_emneKode-emneVersjon-1980-HØST"
#    And the field CourseTitle in the UE entry is the string "NynorskEmneNavn - emneKode HØST 1980"
#    And the field SectionId  in the UE entry is the string "emneVersjon"
#    And the field AcademicDepartment in the UE entry is the  string "222_39_7"
#    And the field ProcessingDepartment in the UE entry is the invariant string LEGANTO
#    And the field Term1 in the UE entry is the string "AUTUMN"
#    And the field Term2 in the UE entry is empty
#    And the field Term3 in the UE entry is empty
#    And the field Term4 in the UE entry is empty
#    And the field StartDate in the UE entry is the string "1980-08-01"
#    And the field EndDate in the UE entry is the string "1981-01-31"
#    And the field WeeklyHours in the UE entry is empty
#    And the field Year in the UE entry has the value 1980
#    And the field SearchableId1 in the UE entry is empty
#    And the field SearchableId2 in the UE entry is empty
#    And the field AllSearchableIds in the UE entry is the string "UE_222_emneKode_emneVersjon_1980_HØST_12,UA_222_emneKode_emneVersjon_1980_HØST_12,emneKode"
#    And the field Instructor1 in the UE entry is empty
#    And the field Instructor2 in the UE entry is empty
#    And the field Instructor3 in the UE entry is empty
#    And the field Instructor4 in the UE entry is empty
#    And the field Instructor5 in the UE entry is empty
#    And the field Instructor6 in the UE entry is empty
#    And the field Instructor7 in the UE entry is empty
#    And the field Instructor8 in the UE entry is empty
#    And the field Instructor9 in the UE entry is empty
#    And the field Instructor10 in the UE entry is empty
###    And AllInstructors is not empty
#    And the field OldCourseCode in the UE entry is empty
#    And the field OldCourseSectionId in the UE entry is empty
#    And the field Operation in the UE entry is empty
#    And the field SubmitByDate in the UE entry is empty
#    And the field ReadingListName in the is empty
#
#
#  Scenario: Start date for the Spring semester for UE entries
#    And the response from /undervisning/UE_ID has a field with name "semester.termin" and value "VÅR"
#    When a new UE Leganto entry has been generated
#    Then the field StartDate in the UE entry is the string "1980-01-01"
#    And the field EndDate in the UE entry is the string "1980-07-31"
#    And the field Term1 in the UE entry is the string "SPRING"
#    And the field CourseCode in the UE entry is the string "UE_emneKode-emneVersjon-1980-VÅR"
#    And the field CourseTitle in the UE entry is the string "NynorskEmneNavn - emneKode VÅR 1980"
#    And the field AllSearchableIds in the UE entry is the string "UE_222_emneKode_emneVersjon_1980_VÅR_12,UA_222_emneKode_emneVersjon_1980_VÅR_12,emneKode"
#
#
#  Scenario: UserInput filed operation has value ROLLOVER for UE entries
#    Given the user input field "operation" has the value "ROLLOVER"
#    When a new UE Leganto entry has been generated
#    Then the field OldCourseCode in the UE entry is the string "UE_emneKode-emneVersjon-1979-HØST"
#    And the field OldCourseSectionId is the string "emneVersjon"
#    And the field Operation in the UE entry  is the string "ROLLOVER"
#
#
#  Scenario: UserInput filed operation has value DELETE for UE entries
#    Given the user input field "operation" has the value "DELETE"
#    When a new UE Leganto entry has been generated
#    Then the field OldCourseCode in the UE entry is empty
#    Then the field OldCourseCode in the UE entry is empty
#    And the field Operation in the UE entry  is the string "DELETE"
#
#
#  Scenario: User does include institute in AcademicDepartment
#    Given the user input has a field with name "include_institute_in_acad_department" with value "false"
#    When a new UE Leganto entry has been generated
#    Then the field AcademicDepartment in the UE entry is the  string "222_39"
#
#
#  Scenario: CourseTitle first alternative format
#    Given the user input has a field with name "course_title_format" with value 2
#    When a new UE Leganto entry has been generated
#    Then the field CourseTitle in the UE entry is the string "emneKode - NynorskEmneNavn (HØST 1980)"
#
#
#
##  Scenario: Start date for the Spring semester
##    Given the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.semester.termin" with value "VÅR"
##    When a new UA Leganto entry has been generated
##    Then StartDate is the string "1980-01-01"
##    And EndDate is the string "1980-07-31"
##    And Term1 is the string  "SPRING"
##    And CourseCode is the string "UA_emneKode-emneVersjon-1980-VÅR"
##    And CourseTitle is the string "NynorskEmneNavn - NynorskUANavn - emneKode VÅR 1980"
##    And AllSearchableIds is the string "UA_222_emneKode_emneVersjon_1980_VÅR_12,MEAKB00000"
##
##
##  Scenario: UserInput field operation has value ROLLOVER
##    Given the user input field "operation" has the value "ROLLOVER"
##    When a new UA Leganto entry has been generated
##    Then Old Course Code is the string "UA_emneKode-emneVersjon-1979-HØST"
##    And Old Course Section ID is the string "emneVersjon"
##    And Operation is the string "ROLLOVER"
##
##  Scenario: UserInput field operation has value DELETE
##    Given the user input field "operation" has the value "DELETE"
##    When a new UA Leganto entry has been generated
##    Then Operation is the string "DELETE"
##
##
##  Scenario: User does include institute in AcademicDepartment
##    Given the user input field "include_institute_in_acad_department" has value false
##    When a new UA Leganto entry has been generated
##    Then AcademicDepartment is the  string "222_39"
##
##
##
##
##  Scenario: CourseTitle first alternative format
##    Given the user input field "course_title_format" has value 2
##    When a new UA Leganto entry has been generated
##    Then CourseTitle is the string "emneKode - NynorskEmneNavn - NynorskUANavn (HØST 1980)"
##
#
