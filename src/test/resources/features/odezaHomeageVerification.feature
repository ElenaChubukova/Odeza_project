@wip
Feature: Odeza homepage verification

  Background:
    Given user is on Odeza homepage

  Scenario: Odeza Homepage URL verification
    Then user sees Odeza in the URL

  Scenario: Odeza Appointment Autofill functionality verification
    #Given user is on Odeza homepage
    When user navigates to the Solutions tab
    And user clicks Appointment Autofill from the drop-down menu
    Then user sees Appointment Autofill in the URL

  Scenario: Odeza address verification
    #Given user is on Odeza homepage
    When user navigates to Contact in the footer
    Then users should see address presented in the page