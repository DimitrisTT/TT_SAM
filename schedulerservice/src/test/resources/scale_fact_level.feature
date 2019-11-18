Feature: Scale Fact Level

  Background:
    Given A Scale Fact is set to type 'LEVEL'
    And its Id is set to '1'
    And its Tag is set to 'RISK'
    And its rating is set to '3'
    And its post_id is set to '1337'
    And its impact has square 'true' and impact of '50'

  Scenario: testing rule firing for those all with the scale Fact set to a rating of 1
    Given a site with id '12' name 'bank' longitude '14.14' and latitude '15.15'
    And with payType 'EMPLOYEE_RATE'
    And the following scales
      | id | scaleTag | rating |
      | 11 | RISK     | 1      |
      | 13 | RISK     | 3      |
      | 15 | RISK     | 5      |
    And the following employees with a scale
      | id   | name      | preferred_hours  | geo_lat  | geo_long  | pay_rate  | seniority  | minimum_rest_period  | scaleId |
      | 1111 | Andre     | 20               | 15       | 14        | 13        | 0          | 8                    | 11      |
      | 1112 | Babara    | 20               | 15       | 14        | 13        | 0          | 8                    | 11      |
      | 1113 | Caspar    | 20               | 15       | 14        | 13        | 0          | 8                    | 11      |
      | 1114 | Danielle  | 20               | 15       | 14        | 13        | 0          | 8                    | 11      |
      | 1115 | Eduardo   | 20               | 15       | 14        | 13        | 0          | 8                    | 11      |
      | 1116 | Franciska | 20               | 15       | 14        | 13        | 0          | 8                    | 11      |
      | 1117 | Gregory   | 20               | 15       | 14        | 13        | 0          | 8                    | 11      |
      | 1118 | Helga     | 20               | 15       | 14        | 13        | 0          | 8                    | 11      |
      | 1119 | Ivan      | 20               | 15       | 14        | 13        | 0          | 8                    | 11      |
      | 1120 | Julie     | 20               | 15       | 14        | 13        | 0          | 8                    | 11      |
    And the following tags
      | tag      |
      | sometag  |
      | othertag |
    And the following post with id '1337' name 'guard' bill rate '12' and pay rate '20' and a scale fact
    And the following scaled shift from '2018-01-18 09:00:00' to '2018-01-18 17:00:00' timestamp '1516284000' and end '1516312800' with duration '8.00' id '55' and plan 'true' available
    And we apply each scaled employee into the shift for the calculation
    When Scale Fact rules are calculated
    Then softscore is 0

