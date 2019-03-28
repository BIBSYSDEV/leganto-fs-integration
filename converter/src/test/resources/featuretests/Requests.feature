Feature: Requests


  Background:
    Given there is access to FS-API
    And a new leganto file has been requested

  Scenario: Exclusion of UndervisningAktivitet entries
    Given there is a valid user input
    And the user input has a field with name "include_ua" with boolean value false
    When the leganto file has beegn generated
    Then the leganto file will contain no UndervisingAktivitet entries


  Scenario: Inclusion of UndervisningAktivitet entries
    Given there is a valid user input
    And the user input has a field with name "include_ua" with boolean value true
    When the leganto file has been generated
    Then the leganto file will contain all relevant UndervisningsAktivitet entries


  Scenario: Inclusion of UndervisningEnhet entries
    When the leganto file has been generated
    Then the leganto file will contain all relevenat UndervisningEnhet entries


