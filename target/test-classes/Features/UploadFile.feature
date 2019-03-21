@Regression
Feature: File Upload

  Scenario: Teacher upload a personal file
    Given Login into moodle site with username "teacher" and password "test"
    When User click on PrivateFiles tab
    Then Verify file upload

  Scenario: Teacher upload a personal file
    Given Login into moodle site with username "teacher" and password "test"
    When User click on PrivateFiles tab
    Then Verify file upload
