package com.joust.site.pom;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.joust.site.model.Result;

public class FindJobsPom {
	@FindBy(id = "text-input-what")
	private WebElement keyword;

	@FindBy(id = "text-input-where")
	private WebElement where;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitFindJobs;

	@FindBy(xpath = "//div[@class='row result clickcard']")
//	@FindBy(id = "resultsCol")
	private List<WebElement> rowResult;

	@FindBy(xpath = "//div[@class='lastRow row result clickcard']")
	private List<WebElement> lastRowResult;

	public FindJobsPom(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}

	public void clearKeyword() {
		keyword.clear();
	}

	public void setKeyword(String strKeyword) {
		keyword.sendKeys(strKeyword);
	}

	public void clearWhere() {
		where.sendKeys(Keys.CONTROL + "a");
		where.sendKeys(Keys.DELETE);
		where.clear();
	}

	public void setWhere(String strWhere) {
		where.sendKeys(strWhere);
	}

	public void clickFindJobs() {
		submitFindJobs.click();
	}

	public List<Result> getResults() {
		List<Result> jobresultlist = new ArrayList<Result>();

		for (WebElement result : rowResult) {
			jobresultlist.add(new Result(result.findElement(By.className("company")).getText(),
					result.findElement(By.className("jobtitle")).getText()));
		}

		if (lastRowResult.size() > 0) {
			jobresultlist.add(new Result(lastRowResult.get(0).findElement(By.className("company")).getText(),
					lastRowResult.get(0).findElement(By.className("jobtitle")).getText()));
		}
		assertTrue(jobresultlist.size() + " Results are listed", jobresultlist.size() > 0);
		return jobresultlist;
	}

}
