package com.kgisl.PageElements.Web;

import org.openqa.selenium.By;

public class RegistrationPage {
	
	
	
	public By enquiry = By.xpath("//ul[@id='sidebar-nav']//*[text()=' Enquiry ']");
	public By generalEnquiry = By.xpath("(//ul[@id='sidebar-nav']//*[contains(text(),'General Enquiry')])[1]");
	public By policyEnquiry = By.xpath("(//*[contains(text(),'Policy Enquiry')])[2]");
	public By refNo = By.xpath("//*[contains(text(),'Reference No')]/ancestor::span/parent::div//input");
	public By Search = By.xpath("//button//*[contains(text(),'Search')]");
	public By customerEdit = By.xpath("//*[contains(text(),'Customer Master')]/parent::div//table/tbody//mat-icon[text()='edit']");
	
	
	public By clientInfoExist = By.xpath("//span[contains(text(),'Client Info Exist')]");
	public By existingDetails = By.xpath("(((//*[text()=' Existing Customer Details ']/parent::div)//div)[5])//tr//td");
	public By clientInfoCancel = By.xpath("//div[@id='existingCustomerDetailsModal']//div[@class='modal-header']//button");
	public By menuOptions = By.cssSelector("button[id='sidebarCollapse']");
	public By newBusiness = By.xpath("//ul[@id='sidebar-nav']//span[contains(text(),'New Bu')]");
	public By registration = By.xpath("(//span[contains(text(),'Registration')])[2]");
	public By customerRegistration = By.xpath("(//span[contains(text(),'Customer Regis')])[2]");
	public By companyRegistration = By.xpath("(//span[contains(text(),'Company Regis')])[2]");
	public By createCustomer = By.xpath("//span[contains(text(),' Create Customer')]");
	public By options = By.xpath("//mat-option[2]");
	public By identity = By.xpath("((//*[text()='Identity']/parent::label)/parent::span)/parent::div//input");
	public By identityNumber = By.xpath("((//*[contains(text(),'Identity No')]/parent::label)/parent::span)/parent::div//input");
	public By title = By.xpath("((//*[contains(text(),'Title')]/parent::label)/parent::span)/parent::div//input");
	public By titleMR = By.xpath("(//mat-option)[1]");
	public By titleMISS = By.xpath("(//mat-option)[2]");
	public By titleMRS = By.xpath("(//mat-option)[3]");
	public By firstName = By.xpath("((//*[contains(text(),'First Name')]/parent::label)/parent::span)/parent::div//input");
	public By middleName = By.xpath("((//*[contains(text(),'Middle Name')]/parent::label)/parent::span)/parent::div//input");
	public By lastName = By.xpath("((//*[contains(text(),'Last Name')]/parent::label)/parent::span)/parent::div//input");
	public By gender = By.xpath("(((//*[contains(text(),'Gender')])/ancestor::span)/parent::div)//mat-select//span");
	public By genderMale = By.xpath("//mat-option[1]");
	public By genderFeMale = By.xpath("//mat-option[2]");
	public By genderOthers = By.xpath("//mat-option[3]");
	//public By maritialStatus = By.cssSelector("div[id='mat-select-value-17']");
	public By dateOfBirth = By.xpath("((//*[contains(text(),'Date Of Birth')]/parent::label)/parent::span)/parent::div//input");
	public By Occupation = By.xpath("((//*[contains(text(),'Occupation')]/parent::label)/parent::span)/parent::div//input");
	public By nationality = By.xpath("((//*[contains(text(),'Nationality')]/parent::label)/parent::span)/parent::div//input");
	public By race = By.xpath("((//*[contains(text(),'Race')]/parent::label)/parent::span)/parent::div//input");
	public By height = By.xpath("((//*[contains(text(),'Height(cm)')]/parent::label)/parent::span)/parent::div//input");
	public By weight = By.xpath("((//*[contains(text(),'Weight(kg)')]/parent::label)/parent::span)/parent::div//input");
	public By addressType = By.xpath("//*[contains(text(),'AddressType')]/ancestor::span/parent::div//mat-select");
	public By address1 = By.xpath("((//*[contains(text(),'Address 1')]/parent::label)/parent::span)/parent::div//input");
	public By addressScroll = By.xpath("(((//*[contains(text(),'Status')]/parent::label)/parent::span)/parent::div)[2]");
	public By postCode = By.xpath("((//*[contains(text(),'Post Code')]/parent::label)/parent::span)/parent::div//input");
	public By addContact = By.xpath("//span[contains(text(),'Add Contact')]");
	public By contactType = By.xpath("(//tr[contains(@class,'ng-star-inserted')]//div//input)[1]");
	public By contactDesc = By.xpath("(//tr[contains(@class,'ng-star-inserted')]//div//input)[2]");
	public By tick = By.xpath("//*[contains(text(),'Address-wise Contacts')]/parent::div//table//*[contains(text(),'check_circle')]");
	public By identityIssuedate = By.xpath("(//tr[contains(@class,'ng-star-inserted')]//div//input)[4]");
	public By identityExpirydate = By.xpath("(//tr[contains(@class,'ng-star-inserted')]//div//input)[5]");
	public By detailsTick = By.xpath("//*[contains(text(),'Identification Details')]/ancestor::mat-expansion-panel//table//*[contains(text(),'check_circle')]");
	public By ContactDetails = By.xpath("(//span[contains(text(),'Add Contact')])[2]");
	public By panelTitle = By.xpath("((//span[contains(text(),'Add Contact')])[2])/parent::button/ancestor::app-customer-registration-contact-details/parent::div/parent::div/parent::mat-expansion-panel//mat-panel-title");
	public By IdentificationPanel = By.xpath("//mat-panel-title[contains(text(),'Identification Details')]");
	public By createIdentity = By.xpath("//*[contains(text(),'Create Identity')]");
	public By newIdentity = By.xpath("(//mat-panel-title[contains(text(),'Identification Details')]/ancestor::mat-expansion-panel//table//thead//input)[1]");
	public By newIdentityNumber = By.xpath("(//mat-panel-title[contains(text(),'Identification Details')]/ancestor::mat-expansion-panel//table//thead//input)[2]");
	public By newIssueDate = By.xpath("(//mat-panel-title[contains(text(),'Identification Details')]/ancestor::mat-expansion-panel//table//thead//input)[3]");
	public By newExpDate = By.xpath("(//mat-panel-title[contains(text(),'Identification Details')]/ancestor::mat-expansion-panel//table//thead//input)[4]");
	public By newIdTick = By.xpath("(//mat-panel-title[contains(text(),'Identification Details')]/ancestor::mat-expansion-panel//table//thead//mat-icon)[2]");
	public By cdType = By.xpath("(//tr[contains(@class,'ng-star-inserted')]//div//input)[7]");
	public By cdDesc = By.xpath("(//tr[contains(@class,'ng-star-inserted')]//div//input)[8]");
	public By CdTick = By.xpath("//*[contains(text(),'Contact Details')]/ancestor::mat-expansion-panel//table//*[contains(text(),'check_circle')]");
	public By dialogboxDetails = By.xpath("//app-common-dialog-box//h4");
	public By dialogboxOK = By.xpath("//app-common-dialog-box//span[contains(text(),'OK')]/parent::button");
	public By bankName = By.xpath("(//tr[contains(@class,'ng-star-inserted')]//div//input)[9]");
	public By AccountNumber = By.xpath("(//tr[contains(@class,'ng-star-inserted')]//div//input)[10]");
	public By BankTick = By.xpath("//*[contains(text(),'Bank Details')]/ancestor::mat-expansion-panel//table//*[contains(text(),'check_circle')]");
	public By AddBank = By.xpath("//button//span[contains(text(),'Add Bank')]");
	public By BankNext = By.xpath("(//button//span[contains(text(),'Next')])[5]");
	public By createEmployer = By.xpath("//button//span[contains(text(),'Create Employer')]");
	public By EmployerName = By.xpath("(//tr[contains(@class,'ng-star-inserted')]//div//input)[11]");
	public By natureOfBusiness = By.xpath("(//tr[contains(@class,'ng-star-inserted')]//div//input)[12]");
	public By Empaddress1 = By.xpath("(//tr[contains(@class,'ng-star-inserted')]//div//input)[13]");
	public By Empaddress2 = By.xpath("(//tr[contains(@class,'ng-star-inserted')]//div//input)[14]");
	public By EmpRegistration = By.xpath("(//tr[contains(@class,'ng-star-inserted')]//div//input)[15]");
	public By EmpContactNo = By.xpath("(//tr[contains(@class,'ng-star-inserted')]//div//input)[16]");
	public By EmpTick = By.xpath("//*[contains(text(),'Employer Details')]/ancestor::mat-expansion-panel//table//*[contains(text(),'check_circle')]");
	
	
	
	public By UILog = By.xpath("(//*[contains(text(),'krishna')])[1]");
	public By UITheme = By.xpath("(//*[contains(text(),'Theme Settings')]/ancestor::li)[2]");
	public By UIHome = By.xpath("((//mat-card-subtitle[contains(text(),'Side Navigation')])[1]/parent::mat-card//mat-card-content//mat-radio-button)[2]//span[contains(text(),'Drawer')]");
//	public By UIcolor = By.xpath("((//*[contains(text(),'Color Theme')]/parent::mat-card)[1]//mat-chip)[2]");
	public By UIfont = By.xpath("(//*[contains(text(),'Font')]/parent::mat-card)[1]//*[contains(text(),'Poppins')]");
	public By UIfontWeight = By.xpath("(//*[contains(text(),'Font Weight')]/parent::mat-card)[1]//*[contains(text(),'Bold')]");
	public By BtnApperance = By.xpath("(//*[contains(text(),'Button Appearance')]/parent::mat-card)[1]//span[contains(text(),'Outline')]/parent::button");
	public By BtnOutline = By.xpath("(//*[contains(text(),'Button Outline')]/parent::mat-card)[1]//span[contains(text(),'Oval')]/parent::button");
	public By UITabStyle = By.xpath("(//*[contains(text(),'Tab Style')]/parent::mat-card)[1]//span[contains(text(),'Oval')]/parent::button");
	
}
