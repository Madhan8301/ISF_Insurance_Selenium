package com.kgisl.PageElements.Web;

import org.openqa.selenium.By;

public class EnquiryPage {
	
	public By policyNumber = By.xpath("((//*[contains(text(),'Policy Number')]/ancestor::span)/parent::div)//input");
	public By pdf = By.xpath("//mat-option[1]");
	public By excel = By.xpath("//mat-option[2]");
	public By csv = By.xpath("//mat-option[3]");
	public By exportTo = By.xpath("//*[contains(text(),'Export To')]");
	public By selectDownloadType = By.xpath("//*[contains(text(),'Export To')]/ancestor::span/parent::div//mat-select");
	
	//----------------------------------------------Group Enquiry------------------------------------------------------
	
	public By GroupEnquiry = By.xpath("//span[contains(text(),'Group Enquiry')]");	
	public By GEerror = By.xpath("//mat-icon[contains(text(),'cancel')]/parent::div//span");
	public By GEcompany = By.xpath("//*[contains(text(),'Group Policy Details ')]/ancestor::mat-expansion-panel//*[text()='Company']/parent::div");
	public By GEpolicy = By.xpath("//*[contains(text(),'Group Policy Details ')]/ancestor::mat-expansion-panel//*[text()='Policy']/parent::div");
	public By GEinviduals = By.xpath("//*[contains(text(),'Group Policy Details ')]/ancestor::mat-expansion-panel//*[text()='Individuals']/parent::div");
	public By GEunitRate = By.xpath("//*[contains(text(),'Group Policy Details ')]/ancestor::mat-expansion-panel//*[text()='Unit Rate']/parent::div");
	public By GEpremium = By.xpath("//*[contains(text(),'Group Policy Details ')]/ancestor::mat-expansion-panel//*[text()='Premium']/parent::div");
	public By GEaccounting = By.xpath("//*[contains(text(),'Group Policy Details ')]/ancestor::mat-expansion-panel//*[text()='Accounting']/parent::div");
	
	public By policySeldectTypeOne = By.xpath("(//*[contains(text(),'Export To')]/ancestor::span/parent::div//mat-select)[1]");
	public By policySelectTypeTwo = By.xpath("(//*[contains(text(),'Export To')]/ancestor::span/parent::div//mat-select)[2]");
	public By policyDownloadone = By.xpath("(//*[contains(text(),'Export To')]/ancestor::span/parent::div)[1]/ancestor::mat-form-field/parent::div//button");
	public By policyDownloadtwo = By.xpath("(//*[contains(text(),'Export To')]/ancestor::span/parent::div)[2]/ancestor::mat-form-field/parent::div//button");
	
	public By GEadditionalDetails = By.xpath("//*[contains(text(),'Additional Details')]/parent::div//mat-tab-group//mat-tab-header//div//div//div//div//div");
	public By GEnodata = By.xpath("//*[contains(text(),'Additional Details')]/parent::div//mat-tab-group//mat-tab-body//*[contains(text(),'No Data')]");
	
	public By additionalDetailExport = By.xpath("//*[contains(text(),'Additional Details')]/parent::div//mat-tab-group//mat-tab-body//*[contains(text(),'Export To')]/ancestor::span/parent::div//mat-select");
	public By additionalDetailDownload = By.xpath("//*[contains(text(),'Additional Details')]/parent::div//mat-tab-group//mat-tab-body//*[contains(text(),'Export To')]/ancestor::span/parent::div/ancestor::mat-form-field/parent::div//button");
	
	//-----------------------------------------------------Agency Enquiry---------------------------------------------------------
	
	public By agencyEnquiry = By.xpath("//span[contains(text(),'Agency General Enquiry')]");
	public By agentCode = By.xpath("//*[contains(text(),'Agent Code')]/ancestor::span/parent::div//input");
	
	public By agentParticular = By.xpath("//*[contains(text(),'Agency Enquiry Details')]/ancestor::mat-expansion-panel//*[text()='Particulars']");
	public By agentRequirements = By.xpath("//*[contains(text(),'Agency Enquiry Details')]/ancestor::mat-expansion-panel//*[text()='Requirements']");
	public By agentCommisions = By.xpath("//*[contains(text(),'Agency Enquiry Details')]/ancestor::mat-expansion-panel//*[text()='Commissions/Benefits']");
	public By agentPolicies = By.xpath("//*[contains(text(),'Agency Enquiry Details')]/ancestor::mat-expansion-panel//*[text()='Policies']");
	public By agentOtherDetails = By.xpath("//*[contains(text(),'Agency Enquiry Details')]/ancestor::mat-expansion-panel//*[text()='Other Details']");
	
	public By particularChangeHistory = By.xpath("//span[contains(text(),'Change History')]");
	public By particularServiceHistory = By.xpath("//span[contains(text(),'Service History')]");
	public By particularHierarchy = By.xpath("//span[contains(text(),'Hierarchy')]");
	public By particularLiamPiam = By.xpath("//span[contains(text(),'LIAM/PIAM')]");
	public By particularUnitDetails = By.xpath("//span[contains(text(),'Unit Details')]");
	
	public By agentDetailsList = By.xpath("(//*[contains(text(),'Agency Enquiry Details')]/ancestor::mat-expansion-panel//mat-tab-group//mat-tab-header)[2]//div//div//div//div//div");
	
	
	//---------------------------------------------------Claim Enquiry----------------------------------------------------------
	public By claimEnquiry = By.xpath("//span[contains(text(),'Claim Enquiry')]"); 
	
	public By claimTab = By.xpath("//*[contains(text(),'Claim Enquiry Details')]/ancestor::mat-expansion-panel//*[text()='Claim']");
	public By eventsSubClaim = By.xpath("//*[contains(text(),'Claim Enquiry Details')]/ancestor::mat-expansion-panel//*[text()='Events/SubClaim']");
	public By claimDocument = By.xpath("//*[contains(text(),'Claim Enquiry Details')]/ancestor::mat-expansion-panel//*[text()='Document']");
	public By provisionPayee = By.xpath("//*[contains(text(),'Claim Enquiry Details')]/ancestor::mat-expansion-panel//*[text()='Provision/Payee']");
	public By recoveryRefundAct = By.xpath("//*[contains(text(),'Claim Enquiry Details')]/ancestor::mat-expansion-panel//*[text()='Recovery/Refund/Acct']");
	
	
	//-----------------------------------------------------Customer Enquiry-----------------------------------------------------
	
	public By customerEnquiry = By.xpath("//span[contains(text(),'Customer Enquiry')]");
	
	public By identificationNo = By.xpath("//*[contains(text(),'Identification No.')]/ancestor::span/parent::div//input");
	public By customerName = By.xpath("((//*[contains(text(),'Search Results')]/ancestor::mat-expansion-panel//table)[1]//tbody//td)[2]//app-redirect-to-url");
	public By ViewIcon = By.xpath("//*[text()='remove_red_eye']");
	public By CustomerSearch = By.xpath("(//span[contains(text(),'Search')])[2]");
	
	//-----------------------------------------------------Other Enquiry--------------------------------------------------------
	
	public By otherEnquiry = By.xpath("//*[contains(text(),'Other Enquiries')]");
	public By enquiryList = By.xpath("//*[contains(text(),'Enquiry')]/ancestor::span/parent::div//mat-select");

}
