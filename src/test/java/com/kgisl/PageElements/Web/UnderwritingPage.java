package com.kgisl.PageElements.Web;

import org.openqa.selenium.By;

public class UnderwritingPage {
	
	
	public By decision = By.xpath("((//*[contains(text(),'Decision')]/ancestor::span)/parent::div)//mat-select//div//span");
	public By descisionresults = By.xpath("//mat-option");
	
	public By perMile = By.xpath("//mat-option[3]");
	public By fixedAmount = By.xpath("//mat-option[2]");
	public By loadingPercentage = By.xpath("//mat-option[4]");
//	public By decisionNotTaken
	
	public By reason = By.xpath("(//*[contains(text(),'Reason')]/ancestor::span)/parent::div//textarea");
	public By Tablerecords = By.xpath("((//*[contains(text(),'Life Underwriting Details')]/parent::div//div)[1]//table)//tr//td");
	
	public By UWdecision = By.xpath("//*[contains(text(),'UW Decision')]/ancestor::span/parent::div//mat-select//span");
	public By BasePlan = By.xpath("(//div[contains(text(),'Base Plan')])[1]");
	
	public By chargesTableName = By.xpath("(//div[contains(text(),'Base Plan')])[1]/ancestor::mat-step-header/parent::div//table//tbody//td[1]");
	
	public By chargesButton = By.xpath("(//div[contains(text(),'Base Plan')])[1]/ancestor::mat-step-header/parent::div//table//tbody//td//*[contains(text(),'Charges')]");
	public By loadingButton = By.xpath("(//div[contains(text(),'Base Plan')])[1]/ancestor::mat-step-header/parent::div//button//span[text()=' Loading ']");
	public By discountButton = By.xpath("(//div[contains(text(),'Base Plan')])[1]/ancestor::mat-step-header/parent::div//button//span[text()=' Discount ']");
	public By addLoading = By.xpath("(//div[contains(text(),'Base Plan')])[1]/ancestor::mat-step-header/parent::div//button//span[text()=' Add Loading ']");
	public By loadingEdit = By.xpath("((//div[contains(text(),'Base Plan')])[1]/ancestor::mat-step-header/parent::div//button//span[text()=' Add Loading ']/ancestor::app-common-table-v2//table//tbody//mat-icon)[1]");
	public By loadingSource = By.xpath("(//*[contains(text(),'Loading Source')]/ancestor::table//thead//input)[1]");
	public By loadingCriteria = By.xpath("(//*[contains(text(),'Loading Source')]/ancestor::table//thead//input)[2]");
	public By loadingValue = By.xpath("(//*[contains(text(),'Loading Source')]/ancestor::table//thead//input)[3]");
	public By loadingMonths = By.xpath("(//*[contains(text(),'Loading Source')]/ancestor::table//thead//input)[4]");
	public By Temp_perm = By.xpath("(//*[contains(text(),'Loading Source')]/ancestor::table//thead//mat-select)[1]");
	public By loadingTick = By.xpath("(//*[contains(text(),'Loading Source')]/ancestor::table//thead//mat-icon[text()='check_circle'])[1]");
	public By basePlanNext = By.xpath("(//div[contains(text(),'Base Plan')])[1]/ancestor::mat-step-header/parent::div//*[contains(text(),'Next')]");
	public By basePlanTable = By.xpath("(((//div[contains(text(),'Base Plan')])[1]/ancestor::mat-step-header/parent::div//app-common-table-v2)[2]//div)[62]");
	
	public By exclusionButton = By.xpath("(//*[text()=' Exclusion '])[1]");
	public By addExclusion = By.xpath("//*[text()=' Add Exclusion ']");
	public By exclusionSource = By.xpath("(//*[contains(text(),'Exclusion Type')]/ancestor::table//tr//input)[1]");
	public By exclusionDescription = By.xpath("(//*[contains(text(),'Exclusion Type')]/ancestor::table//tr//input)[2]");
	public By exclusionType = By.xpath("(//*[contains(text(),'Exclusion Type')]/ancestor::table//tr//mat-select)[1]");
	public By exclusionTick = By.xpath("//*[contains(text(),'Exclusion Type')]/ancestor::table//tr//mat-icon[text()='check_circle']");
	public By medicalExclusion = By.xpath("//mat-option[1]");
	public By causeExclusion = By.xpath("//mat-option[2]");
	public By endrosementExclusion = By.xpath("//mat-option[3]");
	
	public By lienButton = By.xpath("(//*[text()=' Lien '])[1]");
	public By addLien = By.xpath("(//*[text()=' Add Lien '])[1]");
	public By lienSource = By.xpath("(//*[contains(text(),'Lien Type')]/ancestor::table//tr//input)[1]");
	public By lienType = By.xpath("(//*[contains(text(),'Lien Type')]/ancestor::table//tr//input)[2]");
	public By lienFactor = By.xpath("(//*[contains(text(),'Lien Type')]/ancestor::table//tr//input)[3]");
	public By lienValue = By.xpath("(//*[contains(text(),'Lien Type')]/ancestor::table//tr//input)[4]");
	public By lienTick = By.xpath("//*[contains(text(),'Lien Type')]/ancestor::table//tr//mat-icon[text()='check_circle']");
	public By JuvLien = By.xpath("//mat-option[1]");
	public By UWLien = By.xpath("//mat-option[2]");
	public By oldLien = By.xpath("//mat-option[3]");
	
	public By addDiscount = By.xpath("(//div[contains(text(),'Base Plan')])[1]/ancestor::mat-step-header/parent::div//button//span[contains(text(),'Add Discount')]");
	public By discountCriteria = By.xpath("(//*[contains(text(),'Discount Criteria')]/ancestor::table//tr//input)[2]");
	public By discountValue = By.xpath("(//*[contains(text(),'Discount Criteria')]/ancestor::table//tr//input)[3]");
	public By discountTick = By.xpath("((//div[contains(text(),'Base Plan')])[1]/ancestor::mat-step-header/parent::div//button//span[text()=' Add Discount ']/ancestor::app-common-table-v2//table//mat-icon)[3]");
			
	public By underWriting = By.xpath("(//span[contains(text(),'Underwriting')])[2]");
	public By policyNumber = By.xpath("//*[contains(text(),'Policy Number')]/ancestor::span/parent::div//input");
	public By statusDesc = By.xpath("(//*[contains(text(),'Status')]/ancestor::span/parent::div//mat-select//span)[1]");
	public By Search = By.xpath("(//span[contains(text(),'Search')])[2]");
	public By viewIcon = By.xpath("((//*[contains(text(),'Life Underwriting Details')]/parent::div//table)[1]//tbody//td)[6]//button//*[contains(text(),'remove_red_eye')]");
	public By toProposal = By.xpath("//button//span[contains(text(),'Underwriting')]");
	public By underwritingEvents = By.xpath("(//*[contains(text(),'Close')])[2]/parent::button/parent::div/parent::div//*[contains(text(),'Underwriting Events')]");
	public By otherPolicies = By.xpath("//*[text()=' Other Policies ']");
	public By underwritingHistory = By.xpath("//*[text()=' Underwriting History ']");
	
	public By UWEvents= By.xpath("(//*[contains(text(),'Close')])[2]/ancestor::div//*[contains(text(),'Underwriting Events')]");
	public By UWEnquiry = By.xpath("(//*[contains(text(),'Close')])[2]/ancestor::div//*[contains(text(),'Underwriting Events')]/parent::div/parent::div//*[contains(text(),'Enquiry')]");
	public By ownPolicies = By.xpath("((//*[contains(text(),'Close')])[2]/ancestor::div//*[contains(text(),'Underwriting Events')]/ancestor::mat-tab-group//*[contains(text(),'Own Policies')])[1]");
	public By lifeAUWrules = By.xpath("((//*[contains(text(),'Close')])[2]/parent::button/parent::div/parent::div//*[contains(text(),'Life AUW Rules')])[1]");
	public By lifeAWUrulesRecords = By.xpath("//*[contains(text(),'Life AUW Rules')]/parent::div//*[contains(text(),'Records per page')]/ancestor::mat-paginator//mat-select");
	
//	public By underwritingHistory = By.xpath("//div[contains(text(),'Underwriting History')]");
	public By blackList = By.xpath("//*[contains(text(),'BlackList')]");
	public By addBlackList = By.xpath("//*[contains(text(),'Add BlackList')]");
	public By balckListDate = By.xpath("((//div[contains(text(),'BlackList')]/ancestor::mat-step-header/parent::div//table//tr)[2]//input)[1]");
	public By hospitalPeriod = By.xpath("((//div[contains(text(),'BlackList')]/ancestor::mat-step-header/parent::div//table//tr)[2]//input)[2]");
	public By medicalCode1 = By.xpath("((//div[contains(text(),'BlackList')]/ancestor::mat-step-header/parent::div//table//tr)[2]//input)[3]");
	public By riskType = By.xpath("((//div[contains(text(),'BlackList')]/ancestor::mat-step-header/parent::div//table//tr)[2]//mat-select)[1]");
	public By actionCode = By.xpath("((//div[contains(text(),'BlackList')]/ancestor::mat-step-header/parent::div//table//tr)[2]//mat-select)[2]");
	public By blackListTick = By.xpath("(//div[contains(text(),'BlackList')]/ancestor::mat-step-header/parent::div//table//tr)[2]//mat-icon[contains(text(),'check_circle')]");
	
	public By documents = By.xpath("//div[contains(text(),'Documents')]");
	public By receiveDocuments = By.xpath("//*[contains(text(),'Receive All')]");
	public By documentNext = By.xpath("//div[contains(text(),'Documents')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Next')]");
	public By docsStatus = By.xpath("(//div[contains(text(),'Documents')]/ancestor::mat-step-header/parent::div//table//tbody//tr//td)[3]//span//span");
	
	public By planDescription = By.xpath("(//div//div[1])[90]//div[1]//div[1]//div[1]//input");
	public By basicPolicyNumber = By.xpath("((//div//div[1])[96])[1]//input");
	public By policyStatus = By.xpath("((//div//div[1])[106])//input");
	public By identity = By.xpath("((//div//div[1])[186])//input");
	public By idNumber = By.xpath("((//div//div[1])[191])//input");
	public By agentName = By.xpath("((//div//div[1])[241])//input");
	
	public By currency = By.xpath("(((//div//div[1])[251])//input)[1]");
	public By initialSA = By.xpath("((//div//div[1])[261])//input");
	public By userPremium = By.xpath("((//div//div[1])[267])//input");
	public By policyTerms = By.xpath("((//div//div[1])[271])//input");
	public By frequency = By.xpath("((//div//div[1])[290])//input");
	public By premiumPattern = By.xpath("((//div//div[1])[293])//input");
	public By SAPattern = By.xpath("((//div//div[1])[298])//input");
}
