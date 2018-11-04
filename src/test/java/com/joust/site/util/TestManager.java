package com.joust.site.util;


public class TestManager extends WebdriverFactory {

	public void invokeUI() {
		initializeDriver();
		invokeNavigateToPage("https://www.indeed.co.uk/");
	}

	public void invokeNavigateToPage(String url) {
		webdriver.get(url);
		
	}

	public void invokeLogout() {

	}

	public void closeWebDriver() {
		webdriver.quit();
	}

}
