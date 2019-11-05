Feature: No Experience at Post

  Background:
    Given No Experience At Post being active is 'true'
    And its No Experience At Post score impact is '-50'
    And it No Experience At Post has is Hard Impact set to 'false'

  Scenario: testing rule firing for those all with post experience
    Given the following site with id '12' name 'bank' longitude '14.14' and latitude '15.15'
    And with payType 'EMPLOYEE_RATE'
    And the following soft skills
      | id | description |
      | 11 | charming    |
      | 42 | francophone |
    And the following hard skills
      | id | description     |
      | 33 | firearm license |
    And the following employees with post experience
      | id   | name      | preferred_hours  | geo_lat  | geo_long  | pay_rate  | seniority  | minimum_rest_period  | skillId |
      | 1111 | Andre     | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1112 | Babara    | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1113 | Caspar    | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1114 | Danielle  | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1115 | Eduardo   | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1116 | Franciska | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1117 | Gregory   | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1118 | Helga     | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1119 | Ivan      | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1120 | Julie     | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
    And the following tags
      | tag      |
      | sometag  |
      | othertag |
    And the following post with id '1337' name 'armed guard' bill rate '12' and pay rate '20'
    And the following shift from '2018-01-18 09:00:00' to '2018-01-18 17:00:00' timestamp '1516284000' and end '1516312800' with duration '8.00' id '55' and plan 'true' available
    And the following employee constraint multipliers
      | id   | name          | multiplier |
      | 1111 | HAS_POST_EXPERIENCE | 1          |
      | 1112 | HAS_POST_EXPERIENCE | 1          |
      | 1113 | HAS_POST_EXPERIENCE | 1          |
      | 1114 | HAS_POST_EXPERIENCE | 1          |
      | 1115 | HAS_POST_EXPERIENCE | 1          |
      | 1116 | HAS_POST_EXPERIENCE | 1          |
      | 1117 | HAS_POST_EXPERIENCE | 1          |
      | 1118 | HAS_POST_EXPERIENCE | 1          |
      | 1119 | HAS_POST_EXPERIENCE | 1          |
      | 1120 | HAS_POST_EXPERIENCE | 1          |
    And the following employee availabilities
      | id   | availability_type | day_of_week | seconds_start | seconds_end |
      | 1111 | NO                | 4           | 30400         | 31400       |
      | 1112 | NO                | 4           | 30400         | 31400       |
      | 1113 | NO                | 4           | 30400         | 31400       |
      | 1114 | NO                | 4           | 30400         | 31400       |
      | 1115 | NO                | 4           | 30400         | 31400       |
      | 1116 | NO                | 4           | 30400         | 31400       |
      | 1117 | NO                | 4           | 30400         | 31400       |
      | 1118 | NO                | 4           | 30400         | 31400       |
      | 1119 | NO                | 4           | 30400         | 31400       |
      | 1120 | NO                | 4           | 30400         | 31400       |
    And we apply each employee into the shift for the calculation
    When No Experience At Post rules are calculated
    Then softscore is 0

  Scenario: testing rule firing for half of those with post experience
    Given the following site with id '12' name 'bank' longitude '14.14' and latitude '15.15'
    And with payType 'EMPLOYEE_RATE'
    And the following soft skills
      | id | description |
      | 11 | charming    |
      | 42 | francophone |
    And the following hard skills
      | id | description     |
      | 33 | firearm license |
    And the following employees
      | id   | name      | preferred_hours  | geo_lat  | geo_long  | pay_rate  | seniority  | minimum_rest_period  | skillId |
      | 1111 | Andre     | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1112 | Babara    | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1113 | Caspar    | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1114 | Danielle  | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1115 | Eduardo   | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
    And the following employees with post experience
      | id   | name      | preferred_hours  | geo_lat  | geo_long  | pay_rate  | seniority  | minimum_rest_period  | skillId |
      | 1116 | Franciska | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1117 | Gregory   | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1118 | Helga     | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1119 | Ivan      | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1120 | Julie     | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
    And the following tags
      | tag      |
      | sometag  |
      | othertag |
    And the following post with id '1337' name 'armed guard' bill rate '12' and pay rate '20'
    And the following shift from '2018-01-18 09:00:00' to '2018-01-18 17:00:00' timestamp '1516284000' and end '1516312800' with duration '8.00' id '55' and plan 'true' available
    And the following employee constraint multipliers
      | id   | name          | multiplier |
      | 1111 | HAS_POST_EXPERIENCE | 1          |
      | 1112 | HAS_POST_EXPERIENCE | 1          |
      | 1113 | HAS_POST_EXPERIENCE | 1          |
      | 1114 | HAS_POST_EXPERIENCE | 1          |
      | 1115 | HAS_POST_EXPERIENCE | 1          |
      | 1116 | HAS_POST_EXPERIENCE | 1          |
      | 1117 | HAS_POST_EXPERIENCE | 1          |
      | 1118 | HAS_POST_EXPERIENCE | 1          |
      | 1119 | HAS_POST_EXPERIENCE | 1          |
      | 1120 | HAS_POST_EXPERIENCE | 1          |
    And the following employee availabilities
      | id   | availability_type | day_of_week | seconds_start | seconds_end |
      | 1111 | NO                | 4           | 30400         | 31400       |
      | 1112 | NO                | 4           | 30400         | 31400       |
      | 1113 | NO                | 4           | 30400         | 31400       |
      | 1114 | NO                | 4           | 30400         | 31400       |
      | 1115 | NO                | 4           | 30400         | 31400       |
      | 1116 | NO                | 4           | 30400         | 31400       |
      | 1117 | NO                | 4           | 30400         | 31400       |
      | 1118 | NO                | 4           | 30400         | 31400       |
      | 1119 | NO                | 4           | 30400         | 31400       |
      | 1120 | NO                | 4           | 30400         | 31400       |
    And we apply each employee into the shift for the calculation
    When No Experience At Post rules are calculated
    Then softscore is -250

  Scenario: testing rule firing for those with no post experience
    Given the following site with id '12' name 'bank' longitude '14.14' and latitude '15.15'
    And with payType 'EMPLOYEE_RATE'
    And the following soft skills
      | id | description |
      | 11 | charming    |
      | 42 | francophone |
    And the following hard skills
      | id | description     |
      | 33 | firearm license |
    And the following employees
      | id   | name      | preferred_hours  | geo_lat  | geo_long  | pay_rate  | seniority  | minimum_rest_period  | skillId |
      | 1111 | Andre     | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1112 | Babara    | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1113 | Caspar    | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1114 | Danielle  | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1115 | Eduardo   | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1116 | Franciska | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1117 | Gregory   | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1118 | Helga     | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1119 | Ivan      | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
      | 1120 | Julie     | 20               | 15       | 14        | 13        | 0          | 8                    | 33      |
    And the following tags
      | tag      |
      | sometag  |
      | othertag |
    And the following post with id '1337' name 'armed guard' bill rate '12' and pay rate '20'
    And the following shift from '2018-01-18 09:00:00' to '2018-01-18 17:00:00' timestamp '1516284000' and end '1516312800' with duration '8.00' id '55' and plan 'true' available
    And the following employee constraint multipliers
      | id   | name          | multiplier |
      | 1111 | HAS_POST_EXPERIENCE | 1          |
      | 1112 | HAS_POST_EXPERIENCE | 1          |
      | 1113 | HAS_POST_EXPERIENCE | 1          |
      | 1114 | HAS_POST_EXPERIENCE | 1          |
      | 1115 | HAS_POST_EXPERIENCE | 1          |
      | 1116 | HAS_POST_EXPERIENCE | 1          |
      | 1117 | HAS_POST_EXPERIENCE | 1          |
      | 1118 | HAS_POST_EXPERIENCE | 1          |
      | 1119 | HAS_POST_EXPERIENCE | 1          |
      | 1120 | HAS_POST_EXPERIENCE | 1          |
    And the following employee availabilities
      | id   | availability_type | day_of_week | seconds_start | seconds_end |
      | 1111 | NO                | 4           | 30400         | 31400       |
      | 1112 | NO                | 4           | 30400         | 31400       |
      | 1113 | NO                | 4           | 30400         | 31400       |
      | 1114 | NO                | 4           | 30400         | 31400       |
      | 1115 | NO                | 4           | 30400         | 31400       |
      | 1116 | NO                | 4           | 30400         | 31400       |
      | 1117 | NO                | 4           | 30400         | 31400       |
      | 1118 | NO                | 4           | 30400         | 31400       |
      | 1119 | NO                | 4           | 30400         | 31400       |
      | 1120 | NO                | 4           | 30400         | 31400       |
    And we apply each employee into the shift for the calculation
    When No Experience At Post rules are calculated
    Then softscore is -500
