package com.joust.site.steps;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.joust.site.model.Result;
import com.joust.site.pom.FindJobsPom;
import com.joust.site.pom.MainPagePom;
import com.joust.site.util.TestManager;
import com.joust.site.util.TextFileWriter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestStepsSearch extends TestManager {

	@Before()
	public void OpenPage() throws Throwable {
		this.invokeUI();
	}

	@Given("I click FindJobs link in main page")
	public void i_navigate() throws Throwable {
		MainPagePom mainPage = new MainPagePom(webdriver);
		mainPage.goFindJobs();
	}

	@When("^I enter \"([^\"]*)\" keyword in the what input box$")
	public void i_enter_keyword_in_the_what_input_box(String strKeyword) throws Throwable {
		FindJobsPom findJobsPage = new FindJobsPom(webdriver);
		findJobsPage.clearKeyword();
		findJobsPage.setKeyword(strKeyword);
	}

	@When("^I enter \"([^\"]*)\" location to the where input box$")
	public void i_enter_location_to_the_where_input_box(String strWhere) throws Throwable {
		FindJobsPom findJobsPage = new FindJobsPom(webdriver);
		findJobsPage.clearWhere();
		findJobsPage.setWhere(strWhere);
	}

	@When("^I click Find Jobs button$")
	public void i_click_Find_Jobs_button() throws Throwable {
		FindJobsPom findJobsPage = new FindJobsPom(webdriver);
		findJobsPage.clickFindJobs();
	}

	@Then("^I should see the results which are including \"([^\"]*)\"$")
	public void i_should_see_the_results_which_are_including(String strCompany) throws Throwable {
		FindJobsPom findJobsPage = new FindJobsPom(webdriver);
		
		TextFileWriter filewriter= new TextFileWriter();
		filewriter.Delete();
		if (filewriter.Open()) {
			for (Result result : findJobsPage.getResults()) {
				if (strCompany.equals(result.getCompany())) {
					filewriter.Write(result.getJobTitle());
				}
			}
			filewriter.Close();
		}
	}


	@After()
	public void LogoutAndTakeScreenshotOnFailure(Scenario scenario) throws Throwable {
		if (webdriver != null && scenario.isFailed()) {
			scenario.embed(((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES), "image/png");
			Thread.sleep(3000);
			this.invokeLogout();
		}
		Thread.sleep(2000);
		this.closeWebDriver(); // it is for testers to see
		webdriver.quit();
	}
}
