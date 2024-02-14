package com.kgisl.library;

import java.util.List;

public class ReportOut {
	private String planDesc;
	private String policyNumber;
	private String Identity;
	private String IdentityNumber;
	private String agentName;
	private String currency;
	private String initialSumAssured;
	private String userPremium;
	private String policyTerms;
	private String frequency;
	private String premiumPattern;
	private String sumAssuredPattern;
	
	
	public String getIdentity() {
		return Identity;
	}

	public void setIdentity(String identity) {
		Identity = identity;
	}

	public String getIdentityNumber() {
		return IdentityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		IdentityNumber = identityNumber;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getInitialSumAssured() {
		return initialSumAssured;
	}

	public void setInitialSumAssured(String initialSumAssured) {
		this.initialSumAssured = initialSumAssured;
	}

	public String getUserPremium() {
		return userPremium;
	}

	public void setUserPremium(String userPremium) {
		this.userPremium = userPremium;
	}

	public String getPolicyTerms() {
		return policyTerms;
	}

	public void setPolicyTerms(String policyTerms) {
		this.policyTerms = policyTerms;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getPremiumPattern() {
		return premiumPattern;
	}

	public void setPremiumPattern(String premiumPattern) {
		this.premiumPattern = premiumPattern;
	}

	public String getSumAssuredPattern() {
		return sumAssuredPattern;
	}

	public void setSumAssuredPattern(String sumAssuredPattern) {
		this.sumAssuredPattern = sumAssuredPattern;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public void ResetData() {
			}

	public String getPlanDesc() {
		return planDesc;
	}

	public void setPlanDesc(String planDesc) {
		this.planDesc = planDesc;
	}


}
