package com.kgisl.PageElements.Web;

import org.openqa.selenium.By;

public class QualityCheck {
	
	public By QualityCheck = By.xpath("(//span[contains(text(),'Quality Check')])[2]");
	public By policyNumber = By.xpath("((//*[contains(text(),'Policy No')]/ancestor::span)/parent::div)//input");
	public By policyNumberFrom = By.xpath("((//*[contains(text(),'Policy No From')]/ancestor::span)/parent::div)//input");
	public By dispatchFrom = By.xpath("((//*[contains(text(),'Dispatch From')]/ancestor::span)/parent::div)//input");
	public By policyNumberTo = By.xpath("((//*[contains(text(),'Policy No To')]/ancestor::span)/parent::div)//input");
	public By agentName = By.xpath("((//*[contains(text(),'Agent Name')]/ancestor::span)/parent::div)//input");
	public By UnitNo = By.xpath("((//*[contains(text(),'Unit No')]/ancestor::span)/parent::div)//input");
	public By voucherNumber = By.xpath("((//*[contains(text(),'Voucher No')]/ancestor::span)/parent::div)//input");
	public By Search = By.xpath("//span[contains(text(),'Search')]");
	public By resetButton = By.xpath("(//*[contains(text(),'Reset')])[1]");
	public By checkBox = By.xpath("(//tbody//mat-checkbox[1]/label[1]/span[1])");
	public By checkBox1 = By.xpath("((//*[contains(text(),'Filter')])[2]/ancestor::mat-form-field/ancestor::app-common-table-v2//table//tbody//tr//td[1]//mat-checkbox[1]/label[1]/span[1])[2]");
	public By name = By.xpath("//tbody//tr//td[3]");
	public By policyNumbers = By.xpath("//tbody//tr//td[2]");
	public By fromDate = By.xpath("//*[contains(text(),'From Date')]/ancestor::span/parent::div//input");
	public By toDate = By.xpath("//*[contains(text(),'To Date')]/ancestor::span/parent::div//input");
	public By qualityOptions = By.xpath("(//td//mat-form-field//div//div)[10]//mat-select");
	public By qualityOptions2 = By.xpath("(//*[text()='Quality Check']/parent::div)[2]//table//tbody//tr//mat-select");
	public By QualityCheckItems = By.xpath("(((//*[text()='Quality Check']/parent::div)[2]//div[@class='table-footer']//mat-select)[1]//span)[1]");
	public By ItemsfullList = By.xpath("//mat-option[4]");
	public By qualityYes = By.xpath("//mat-option[1]");
	public By qualityNo = By.xpath("//mat-option[2]");
	public By QualityApprove = By.xpath("//span[contains(text(),'Quality Approve')]");
	public By generateVoucher = By.xpath("//span[contains(text(),'Generate Voucher')]");
	public By voucherDialogbox = By.xpath("//mat-dialog-container/parent::div");
	
	public By OK = By.xpath("(//*[contains(text(),'OK')])[3]");
	
	
	public By policyIssueRecords = By.xpath("((//div[contains(@class,'table-footer')]//mat-select)[1]//span)[1]");
	public By policyIssue = By.xpath("//*[contains(text(),'Policy Issue')]");
	public By Issue = By.xpath("(//*[contains(text(),'Issue')]/parent::button)[1]");
	public By ok = By.xpath("(//span[contains(text(),'OK')])");
	
	
	public By dispatchPolicy = By.xpath("(//span[contains(text(),'Dispatch Policy')])[2]");
	public By dispatchButton = By.xpath("//button//span[contains(text(),'Dispatch')]");
	public By recordsPerPage = By.xpath("((//div[contains(text(),' Records per page: ')])[1]/following-sibling::mat-form-field//mat-select//span)[1]");
	
	public By acknowledgePolicy = By.xpath("(//span[contains(text(),'Acknowledge Policy')])[2]");
	public By acknowledgePoliNumberTable = By.xpath("(//*[contains(text(),'Acknowledge Policy')])/parent::div//table//tbody//tr//td[3]");
	public By acknowledgeTableCheckbox = By.xpath("((//*[contains(text(),'Acknowledge Policy')])/parent::div//table//tbody//tr//td[1]//mat-checkbox[1]/label[1]/span[1])");
	public By acknowledgeTableEdit = By.xpath("((//*[contains(text(),'Acknowledge Policy')])/parent::div//table//tbody//tr//*[contains(text(),'edit')])");
	public By filterSearch = By.xpath("//*[contains(text(),'Filter')]/ancestor::span/parent::div//input");
	public By acknowledgeType = By.xpath("((((//*[contains(text(),'Acknowledge Policy')])/parent::div//table//tbody//tr))[2]//mat-select)[1]");
	public By acknowledgeTypeBtn = By.xpath("((((//*[contains(text(),'Acknowledge Policy')])/parent::div//table//tbody//tr))//mat-select)[1]");
	public By acknowledgeEdit = By.xpath("((//*[contains(text(),'Acknowledge Policy')])/parent::div//table//tbody//*[contains(text(),'edit')])[2]");
	public By acknowledgeEditBtn = By.xpath("((//*[contains(text(),'Acknowledge Policy')])/parent::div//table//tbody//*[contains(text(),'edit')])");
	public By accept = By.xpath("//mat-option[1]");
	public By reject = By.xpath("//mat-option[2]");
	public By acknowledgeTick = By.xpath("((//*[contains(text(),'Acknowledge Policy')])/parent::div//table//tbody//*[contains(text(),'check_circle')])");
	public By acknowledgeButton = By.xpath("//button//span[contains(text(),'Acknowledge')]");
	public By policyToproposal = By.xpath("(//span[contains(text(),'Policy to Proposal')])[2]");
	public By proposalDepositRefund = By.xpath("(//span[contains(text(),'Proposal Deposit Refund')])[2]");
	public By policyStatusLog = By.xpath("//span[contains(text(),'Policy Status Log')]");
	public By autoCancellation = By.xpath("//span[contains(text(),'Auto Cancellation')]");
	public By ReducingSCschedule = By.xpath("//span[contains(text(),'Reducing SC Schedule')]");
	

}
