Feature:
  Trasnformation of Undervisningsaktiviteter (UA: Teaching Activities )
  UA records are transformed to Leganto Records in form of comma separated fields.
  FS: Felles Studentsystem

  Background:
    Given there is a valid user input
    And the user input has a field with name "operation" with value "NORMAL"
    And the user input has a field with name "course_title_format" with value 1
    And the user input has a field with name "language_order" that is an array with string values
      | nn |
      | nb |
      | en |

    And the user input has a field with name "include_ua" with boolean value "true"
    And the user input has a field with name "include_institute_in_acad_department" with boolean value "true"

    And there is a valid response from /undervisningsaktiviteter/UA_ID
    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.emne.href" with value "emne/emneId"
    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.emne.kode" with value "emneKode"
    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.emne.versjon" with value "emneVersjon"
    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.semester.ar" with value "1980"
    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.semester.termin" with value "HØST"

    And the response from /undervisningsaktiviteter/UA_ID has a field "aktivitet" with value "MEAKB00000"
    And the response from /undervisningsaktiviteter/UA_ID from FS has a field "navn" that is an array with the key-value pairs
      | lang | nb | value | BokmalUANavn  |
      | lang | nn | value | NynorskUANavn |
      | lang | en | value | EngelskUANavn |
    And the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.terminnummer" with value 12

    And there is a valid response from /emne/emneId

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

    And there is a possibly empty personroller list


  Scenario: Update Leganto with new course information
    And the user input has field with name "include_institute_in_acad_department" with value true
    And the response from /undervisningsaktiviteter/UA_ID from FS has no field "perioder"

    When a new UA Leganto entry has been generated

    Then the field CourseCode in the UA entry is the string "UA_emneKode-emneVersjon-1980-HØST"
    And the field CourseTitle in the UA entry is the string "NynorskEmneNavn - NynorskUANavn - emneKode HØST 1980"
    And the field SectionId in the UA entry is the string "emneVersjon"
    And the field AcademicDepartment in the UA entry is the string "222_39_7"
    And the field ProcessingDepartment in the UA entry is set to the invariant value LEGANTO
    And the field Term1 in the UA entry is the string "AUTUMN"
    And the field Term2 in the UA entry is empty
    And the field Term3 in the UA entry is empty
    And the field Term4 in the UA entry is empty
    And the field StartDate in the UA entry is the string "1980-08-01"
    And the field EndDate in the UA entry is the string "1981-01-31"
    And the field WeeklyHours in the UA entry is empty
    And the field Year in the UA entry has the value 1980
    And the field SearchableId1 in the UA entry is empty
    And the field SearchableId2 in the UA entry is empty
    And the field AllSearchableIds in the UA entry is the string "UA_222_emneKode_emneVersjon_1980_HØST_12,MEAKB00000"
    And the field Instructor1 in the UA entry is empty
    And the field Instructor2 in the UA entry is empty
    And the field Instructor3 in the UA entry is empty
    And the field Instructor4 in the UA entry is empty
    And the field Instructor5 in the UA entry is empty
    And the field Instructor6 in the UA entry is empty
    And the field Instructor7 in the UA entry is empty
    And the field Instructor8 in the UA entry is empty
    And the field Instructor9 in the UA entry is empty
    And the field Instructor10 in the UA entry is empty
    #And AllInstructors is empty
    And the field Operation in the UA entry is empty
    And the field SubmitByDate in the UA entry is empty
    And the field OldCourseCode in the UA entry is empty
    And the field OldCourseSectionId in the UA entry is empty
    And the field Reading List Name in the UA entry is empty

  Scenario: Start date for the Spring semester
    Given the response from /undervisningsaktiviteter/UA_ID has a field "undervisning.semester.termin" with value "VÅR"
    When a new UA Leganto entry has been generated
    Then the field StartDate in the UA entry is the string "1980-01-01"
    And the field EndDate in the UA entry is the string "1980-07-31"
    And the field Term1 in the UA entry is the string "SPRING"
    And the field CourseCode in the UA entry is the string "UA_emneKode-emneVersjon-1980-VÅR"
    And the field CourseTitle in the UA entry is the string "NynorskEmneNavn - NynorskUANavn - emneKode VÅR 1980"
    And the field AllSearchableIds in the UA entry is the string "UA_222_emneKode_emneVersjon_1980_VÅR_12,MEAKB00000"


  Scenario: UserInput field operation has value ROLLOVER
    Given the user input field "operation" has the value "ROLLOVER"
    When a new UA Leganto entry has been generated
    Then the field Old Course Code in the UA entry is the string "UA_emneKode-emneVersjon-1979-HØST"
    And the field Old Course Section ID in the UA entry is the string "emneVersjon"
    And the field Operation in the UA entry is the string "ROLLOVER"

  Scenario: UserInput field operation has value DELETE
    Given the user input field "operation" has the value "DELETE"
    When a new UA Leganto entry has been generated
    Then the field Operation in the UA entry is the string "DELETE"
    And the field OldCourseCode in the UA entry is empty
    And the field OldCourseSectionId in the UA entry is empty


  Scenario: User does include institute in AcademicDepartment
    Given the user input field "include_institute_in_acad_department" has the boolean value "false"
    When a new UA Leganto entry has been generated
    Then the field AcademicDepartment in the UA entry is the string "222_39"


  Scenario: CourseTitle first alternative format
    Given the user input has a field with name "course_title_format" with value 2
    When a new UA Leganto entry has been generated
    Then the field CourseTitle in the UA entry is the string "emneKode - NynorskEmneNavn - NynorskUANavn (HØST 1980)"
