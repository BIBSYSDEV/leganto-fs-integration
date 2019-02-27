Feature:
  Trasnformation of Undervisningsaktiviteter (UA)
  UA records are transformed to Leganto Records in form of comma separated fields.


  Scenario: A collection of UA entries is retrieved from FS  # GET /undervisningsaktiviteter
    Given an accessible FS-API
    And an institution username and password for that API
    And a year
    And one of the following semester codes:
      | VÅR  |
      | HØST |
    Then a list of all UA ids for the specified semester, year and insitution is generated


  Scenario: Information about a UA entry is retrieved from FS # GET /undervisningsaktivitet/{id}
    Given an accessible FS-API
    And an institution username and password for that API
    And a UA id
    Then the following fields are collected for the respective UA record
      | emne.kode               |
      | emne.version            |
      | emne.institusjon        |
      | semester.ar             |
      | semester.termin         |
      | undervisning.navn.value |


  Scenario: Optional information about a course code is present
    Given an accessible FS-API
    And an institution username and password for that API
    And a UA id
    And the retrieved records have a field "perioder"
    And the value of the field is an array
    And the field "perioder" has at least one entry of the form {fraDato:<date>, tilDato:<date>}
    Then the following information are collected for the UA record:
      | min(fraDato values) |
      | max(tilDato value)  |


  Scenario: Optional information about a course code not present
    Given an accessible FS-api
    And an institution username and password for that API
    And a UA id
    And the retrieved records do not have a field "perioder"
    Then no information is set for this field


  Scenario: Tranformation of UA to Emne-Id
    Given a UA entry containing the following information
      | emne.institusjon |
      | emne.kode        |
      | emne.version     |
    Then the Emne Id is of the form emne.institusjon,emne.kode,emne.version


  Scenario: Information about Emne from FS #GET /emne/{id}
    Given an accessible FS-API
    And an Emne id
    Then an emne entry is retrieved


  Scenario: Retriving Emne nanv from an Emne entry
    Given an Emne entry containing the field "navn"
    And the field "navn" contains a subset of the languages "no","nn","en"
    Then one preferred name is retrieved following the order "no","nn","en"


  Scenario:
    Given an Emne entry containing the field



