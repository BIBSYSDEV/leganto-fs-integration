Feature:
  Collection of Undervisningsaktiviteter records (UA: Teaching Activities)
  and Undervisningsenheter (UE: Course entity )

#
#  Background:
#    Given there is a user input
#    And the user input has a field with name "year" with value 1980
#    And the user input has a field with name "semester" with value "HØST"
#
#
#  Scenario: Acquire credentials
#    Given the user input has a field with name "institution" with value "hioa"
#    Then a request is send to FS-API: /token
#    And a token is received
#    And the user is logged in
#
#
#  Scenario: Donwload Undervisingaktiviteter records
#    Given a user is logged in
#    And the user input has a filed with name "include_UA" with value true
#    Then a request is send to FS
#    And the request has a parameter "undervisning.semester.ar" with value 1980
#    And the request has a parameter "undervisning.semester.termin" with value "HØST"
#    And a list of URIs of all UA entities is retrieved
#
#
#  Scenario: No entries for UndervisingsAktiviteter
#    Given a user is logged in
#    And   the user input has a field with name "include_UA" with value false
#    Then no Leganto Entry record is created for any UA record
