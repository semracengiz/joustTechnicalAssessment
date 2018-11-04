package com.joust.site.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPagePom {

	@FindBy(xpath = "//*[@id='desktopGlobalHeader']/nav/ul/li/a")
	private WebElement menuFindJobs;


	public MainPagePom(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}

	public void goFindJobs() {
		menuFindJobs.click();
	}
	
}