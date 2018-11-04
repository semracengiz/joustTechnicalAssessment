$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Test01_Search.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Semra Cengiz"
    },
    {
      "line": 2,
      "value": "#"
    },
    {
      "line": 3,
      "value": "#Keywords Summary : This feature file contains test Login in scenario for JOUST"
    },
    {
      "line": 4,
      "value": "#"
    }
  ],
  "line": 6,
  "name": "Indeed website search the jobs with keyword",
  "description": "",
  "id": "indeed-website-search-the-jobs-with-keyword",
  "keyword": "Feature",
  "tags": [
    {
      "line": 5,
      "name": "@Search"
    },
    {
      "line": 5,
      "name": "@allTests"
    }
  ]
});
formatter.before({
  "duration": 2518983624,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Validate the job searching with the specific keyword and list the result successfully",
  "description": "",
  "id": "indeed-website-search-the-jobs-with-keyword;validate-the-job-searching-with-the-specific-keyword-and-list-the-result-successfully",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "I click FindJobs link in main page",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I enter \"Joust\" keyword in the what input box",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I enter \"Istanbul\" location to the where input box",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I click Find Jobs button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I should see the results which are including \"Joust\"",
  "keyword": "Then "
});
formatter.match({
  "location": "TestStepsSearch.i_navigate()"
});
formatter.result({
  "duration": 393149385,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Joust",
      "offset": 9
    }
  ],
  "location": "TestStepsSearch.i_enter_keyword_in_the_what_input_box(String)"
});
formatter.result({
  "duration": 146591409,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Istanbul",
      "offset": 9
    }
  ],
  "location": "TestStepsSearch.i_enter_location_to_the_where_input_box(String)"
});
formatter.result({
  "duration": 205430562,
  "status": "passed"
});
formatter.match({
  "location": "TestStepsSearch.i_click_Find_Jobs_button()"
});
formatter.result({
  "duration": 707921525,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Joust",
      "offset": 46
    }
  ],
  "location": "TestStepsSearch.i_should_see_the_results_which_are_including(String)"
});
formatter.result({
  "duration": 35908218,
  "error_message": "java.lang.AssertionError: 0 Results are listed\n\tat org.junit.Assert.fail(Assert.java:88)\n\tat org.junit.Assert.assertTrue(Assert.java:41)\n\tat com.joust.site.pom.FindJobsPom.getResults(FindJobsPom.java:72)\n\tat com.joust.site.steps.TestStepsSearch.i_should_see_the_results_which_are_including(TestStepsSearch.java:61)\n\tat ✽.Then I should see the results which are including \"Joust\"(Test01_Search.feature:12)\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 5549286321,
  "status": "passed"
});
});