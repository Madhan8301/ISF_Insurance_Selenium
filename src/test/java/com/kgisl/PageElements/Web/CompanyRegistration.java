package com.kgisl.PageElements.Web;

import org.openqa.selenium.By;

public class CompanyRegistration {
	
	public By createCompany = By.xpath("//*[contains(text(),'Create Company')]");
	
	public By institutionCode = By.xpath("((//*[text()='Institution Code']/parent::label)/parent::span)/parent::div//input");
	public By institutionBranch = By.xpath("((//*[contains(text(),'Institution Branch')]/parent::label)/parent::span)/parent::div//input");
	public By institutionName = By.xpath("((//*[contains(text(),'Institution Name')]/parent::label)/parent::span)/parent::div//input");
	public By institutionType = By.xpath("((//*[contains(text(),'Institution Type')]/parent::label)/parent::span)/parent::div//input");
	public By regNo = By.xpath("(//*[contains(text(),'Registration No')]/ancestor::span)/parent::div//input");
	public By accountCode = By.xpath("(//*[contains(text(),'Account Code')]/ancestor::span)/parent::div//input");
	public By bankRole = By.xpath("(//*[contains(text(),'Bank Role')]/ancestor::span)/parent::div//mat-select//span");
	public By panelClinicType = By.xpath("(//*[contains(text(),'Panel Clinic Type')]/ancestor::span)/parent::div//input");
	public By panelClinicOption = By.xpath("//mat-option[2]");
	public By arrow = By.xpath("((//*[contains(text(),'Status')]/ancestor::span)/parent::div//mat-select)[1]");
	public By options = By.xpath("//mat-option//span");
	public By allOptions = By.xpath("//mat-option");
	public By institutionNext = By.xpath("//*[contains(text(),'Institution Details')]/ancestor::mat-expansion-panel//*[contains(text(),'Next')]");
	public By branchWeekEndDays = By.xpath("//*[contains(text(),'Branch WeekEnd Days')]/ancestor::span/parent::div//mat-select//span");
	
	public By contactType = By.xpath("((//*[contains(text(),'Contact Details')]/ancestor::mat-expansion-panel//table//thead//tr)[2]//td//input)[1]");
	public By contactPerson = By.xpath("((//*[contains(text(),'Contact Details')]/ancestor::mat-expansion-panel//table//thead//tr)[2]//td//input)[2]");
	public By contactDetails = By.xpath("((//*[contains(text(),'Contact Details')]/ancestor::mat-expansion-panel//table//thead//tr)[2]//td//input)[3]");
	public By contactTick = By.xpath("//*[contains(text(),'Contact Details')]/ancestor::mat-expansion-panel//table//*[contains(text(),'check_circle')]");
	public By contactNext = By.xpath("//*[contains(text(),'Contact Details')]/ancestor::mat-expansion-panel//*[contains(text(),'Next')]");
	public By createContact = By.xpath("//*[contains(text(),'Contact Details')]/ancestor::mat-expansion-panel//*[contains(text(),'Create Contact')]");
	
	public By addAddress = By.xpath("//span[contains(text(),'Add Address')]");
	public By addressContactType = By.xpath("(//*[contains(text(),'Address Details')]/ancestor::mat-expansion-panel//table//input)[1]");
	public By addressContactDetails = By.xpath("(//*[contains(text(),'Address Details')]/ancestor::mat-expansion-panel//table//input)[2]");
	public By addressContactTick = By.xpath("(//*[contains(text(),'Address Details')]/ancestor::mat-expansion-panel//table//mat-icon)[2]");
	public By addressNext = By.xpath("//*[contains(text(),'Address Details')]/ancestor::mat-expansion-panel//*[contains(text(),'Next')]");
	
	public By preview = By.xpath("//*[contains(text(),'Bank Details')]/ancestor::mat-expansion-panel//*[contains(text(),'Preview')]");
	public By bankName = By.xpath("(//*[contains(text(),'Bank Details')]/ancestor::mat-expansion-panel//table//input)[1]");
	public By accountNumber = By.xpath("(//*[contains(text(),'Bank Details')]/ancestor::mat-expansion-panel//table//input)[2]");
	public By bankTick = By.xpath("(//*[contains(text(),'Bank Details')]/ancestor::mat-expansion-panel//table//mat-icon)[2]");
	public By addBankDetails = By.xpath("//*[contains(text(),'Add Bank Details')]");
}
