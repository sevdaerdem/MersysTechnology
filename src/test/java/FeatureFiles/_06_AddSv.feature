Feature: Human Resources Test

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login succesfully

  Scenario: Human Resources  Attestations Functionality
    When Click on the element in LeftNav
      | humanResources |
      | humanSetup     |
      | attestations   |

    Scenario: Admin User should be able to Add Subject Categories
    When Edit Subject Categories and Delete Subject Categories for setting different education details for schools.

    Then Subject Categories tab should be under Education > Setup tab
      Then option to  activate and deactivite Subject Categories

    And we should have search function for this page.



