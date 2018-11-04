package com.joust.site.model;

public class Result {

	private String Company;
	private String JobTitle;

	public Result(String pCompany, String pJobTitle) {
		Company = pCompany;
		JobTitle=pJobTitle;
	}

	public String getCompany() {
		return Company;
	}

	public String getJobTitle() {
		return JobTitle;
	}
	
	public void setCompany(String pCompany) {
		this.Company = pCompany;
	}

	public void setJobSubject(String pJobSubject) {
		this.JobTitle = pJobSubject;
	}
}
