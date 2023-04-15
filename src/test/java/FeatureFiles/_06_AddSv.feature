//Admin User should be able to Add Subject Categories, Edit Subject Categories and
Delete Subject Categories for setting different education details for schools.

//Subject Categories tab should be under Education > Setup tab.
We should have an option to activate and deactivate Subject Categories.
And we should have search function for this page.

//Please see the attachment for design of the page:
 Feature: Add Subject Categories

  Background:
    Given Navigate to Campus
    When Add Subject Categories, Edit Subject Categories
    Then Delete Subject Categories for setting different education

  Scenario: Admin User should be able to Add Subject Categories
    When Edit Subject Categories and Delete Subject Categories for setting different education details for schools.

    Then Subject Categories tab should be under Education > Setup tab

    And we should have search function for this page.


