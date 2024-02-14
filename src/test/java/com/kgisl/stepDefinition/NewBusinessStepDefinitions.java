package com.kgisl.stepDefinition;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Map;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.kgisl.PageElements.Web.CommonPageElements;
import com.kgisl.PageElements.Web.CompanyRegistration;
import com.kgisl.PageElements.Web.EnquiryPage;
import com.kgisl.PageElements.Web.ProposalPage;
import com.kgisl.PageElements.Web.QualityCheck;
import com.kgisl.PageElements.Web.RegistrationPage;
import com.kgisl.PageElements.Web.UnderwritingPage;
import com.kgisl.base.Data_Set;
import com.kgisl.base.ExcelUtility;
import com.kgisl.base.FrameworkConfig;
import com.kgisl.base.Hooks;
import com.kgisl.controls.WebControl;
import com.kgisl.library.LibraryClass;
import com.kgisl.library.ReportUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import java.util.HashMap;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;

public class NewBusinessStepDefinitions {

	public WebControl Wcontrol;
	public LibraryClass library;
	public CommonPageElements commonPage;
	public RegistrationPage registrationPage;
	public Hooks base;
	private ExtentReports extent;
	private ExtentTest test;
	public QualityCheck qualityCheck;
	public ProposalPage proposalPage;
	public UnderwritingPage underWritingPage;
	public BaseDefins defins;
	public EnquiryPage enquiryPage;
	public ReportUtility reportutil;
	public List<String> referenceNumbers = new ArrayList<String>();
	static Map maps = new HashMap();
	private String TestId = null;
	public String returnedPolicyNumber;
	public EverGreenStepDefinitions mainStep;
	public CompanyRegistration companyRegistration;

	private String sheetName = null;
	private Data_Set Data;

	private Map<String, String> InputData;
	private ExcelUtility Exceldata;
	FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);

	public NewBusinessStepDefinitions(WebControl wcontrol, LibraryClass library, CommonPageElements commonPage,
			RegistrationPage registrationPage, UnderwritingPage underWritingPage, ProposalPage proposalPage, Hooks base,
			Data_Set Data, ExcelUtility Exceldata, QualityCheck qualityCheck, BaseDefins defins,
			EverGreenStepDefinitions mainStep,CompanyRegistration companyRegistration,EnquiryPage enquiryPage) {

		this.Wcontrol = wcontrol;
		this.library = library;
		this.commonPage = commonPage;
		this.registrationPage = registrationPage;
		this.base = base;
		this.Data = Data;
		this.Exceldata = Exceldata;
		this.proposalPage = proposalPage;
		this.underWritingPage = underWritingPage;
		this.qualityCheck = qualityCheck;
		this.defins = defins;
		this.mainStep = mainStep;
		this.companyRegistration=companyRegistration;
		this.enquiryPage=enquiryPage;
	}



	@Given("Enter the UserName and Password")
	public void enter_the_username_and_password() throws Throwable {
		// library.waitForVisibilityOfElement(commonPage.UserName);

		Wcontrol.EnterValueon(commonPage.UserName, base.getUserName());
		Wcontrol.EnterValueon(commonPage.password, base.getPassword());
	}

	@Then("Navigate to Main Menu and Select {string}")
	public void navigate_to_main_menu_and_select_something(String button) throws Throwable {
		library.waitForClickableElement(registrationPage.menuOptions);
		By home = By.xpath("((//div//app-breadcrumb//nav//ol//li)[1]//a//i)[1]");
		Wcontrol.clickJSEon(home);
		Wcontrol.clickJSEon(registrationPage.menuOptions);
		By clickbtn = null;
		switch (button) {
		case "New Business":
			clickbtn = registrationPage.newBusiness;
			break;

		case "Enquiry":
			clickbtn = registrationPage.enquiry;
			break;
		
		case "Acknowledge Policy":
			clickbtn = qualityCheck.acknowledgePolicy;
			break;

		default:
			break;
		}
		library.waitForClickableElement(clickbtn);
		Wcontrol.Clickon(clickbtn);
	}
	
	@Then("Change the UI Settings")
	public void Change_the_UI_Settings() throws Throwable {
		library.waitForVisibilityOfElement(registrationPage.UILog,50);
		Wcontrol.ActionMoveToElement(registrationPage.UILog);
		library.waitForPresenceOfElement(registrationPage.UITheme,50);
		library.waitForVisibilityOfElement(registrationPage.UILog,50);
		Wcontrol.ActionMoveToElement(registrationPage.UITheme);
		WebElement element = base.getDriver().findElement(registrationPage.UITheme);
//		Wcontrol.clickJSEon(registrationPage.UITheme);
		JavascriptExecutor executor = (JavascriptExecutor) base.getDriver();
		executor.executeScript("arguments[0].scrollIntoView(true);", element);    
		element.click();
		Wcontrol.scrollDownLong();
		
		int randomNumber = (int) (Math.random() * 5) + 1;
		
	
				
		String Colour = "((//*[contains(text(),'Color Theme')]/parent::mat-card)[1]//mat-chip)["+randomNumber+"]";
		
//		Wcontrol.Clickon(registrationPage.UIcolor);
		Wcontrol.Clickon(By.xpath(Colour));
		Wcontrol.Clickon(registrationPage.UIfont);
		Wcontrol.Clickon(registrationPage.UIfontWeight);
		Wcontrol.Clickon(registrationPage.UITabStyle);
		Wcontrol.Clickon(registrationPage.BtnApperance);
		Wcontrol.Clickon(registrationPage.BtnOutline);
		Wcontrol.Clickon(registrationPage.UIHome);
		
//		Thread.sleep(1000);
//		Wcontrol.ActionMoveToElementClcik(By.xpath("((//header//div)[7]//nav//ul//li)[5]//a"));
//		Wcontrol.ActionMoveToElement(By.xpath("//mat-card-subtitle[contains(text(),'Color Theme')]"));
//		Wcontrol.scrollDownLong();
//		Wcontrol.Clickon(registrationPage.UIHome);
////		Wcontrol.Clickon(registrationPage.menuOptions);
//		Wcontrol.doubleClickon(By.cssSelector("input[data-placeholder*='Search']"));
	}

	@Then("click on {string} and Select {string}")
	public void click_on_something_and_select_something(String button1, String button2) throws Throwable {

		By clickbtn1 = null;
		By clickbtn2 = null;
		switch (button1) {
		case "Registration":
			clickbtn1 = registrationPage.registration;
			break;
		case "Individual":
			clickbtn1 = proposalPage.Individual;
			break;
		case "General Enquiry":
			clickbtn1 = registrationPage.generalEnquiry;
			break;
		case "Underwriting":
			clickbtn1 = underWritingPage.underWriting;
			break;

		default:
			break;
		}
		library.waitForClickableElement(clickbtn1,2);
		Wcontrol.Clickon(clickbtn1);

		switch (button2) {
		case "Customer Registration":
			clickbtn2 = registrationPage.customerRegistration;
			break;
		case "Company Registration":
			clickbtn2 = registrationPage.companyRegistration;
			break;
		case "Proposal":
			clickbtn2 = proposalPage.proposal;
			break;
		case "Underwriting":
			clickbtn2 = underWritingPage.underWriting;
			break;

		case "Quality Check":
			clickbtn2 = qualityCheck.QualityCheck;
			break;

		case "Policy Issue":
			clickbtn2 = qualityCheck.policyIssue;
			break;

		case "Policy Enquiry":
			clickbtn2 = registrationPage.policyEnquiry;
			break;
			
		case "Group Enquiry":
			clickbtn2 = enquiryPage.GroupEnquiry;
			break;
			
		case "Agency Enquiry":
			clickbtn2 = enquiryPage.agencyEnquiry;
			break;
			
		case "Claim Enquiry":
			clickbtn2 = enquiryPage.claimEnquiry;
			break;
		
		case "Customer Enquiry":
			clickbtn2 = enquiryPage.customerEnquiry;
			break;
			
		case "Other Enquiry":
			Wcontrol.Clickon(enquiryPage.customerEnquiry);
			clickbtn2 = enquiryPage.otherEnquiry;
			break;
			
		case "Dispatch Policy":
			clickbtn2 = qualityCheck.dispatchPolicy;
			break;
			
		case "Acknowledge Policy":
			clickbtn2 = qualityCheck.acknowledgePolicy;
			break;
		
		case "Policy to Proposal":
			clickbtn2 = qualityCheck.policyToproposal;
			break;
			
		case "Proposal Deposit Refund":
			clickbtn2 = qualityCheck.proposalDepositRefund;
			break;

		default:
			break;
		}
		library.waitForClickableElement(clickbtn2,2);
		Wcontrol.Clickon(clickbtn2);
	}

	
	
	@Then("Select Identity as {string} and Select Identity number as {string}")
	public void select_identity_as_something_and_select_identity_number_as_something(String identity,
			String NewICnumber) throws Throwable {
		// library.waitForVisibilityOfElement(registrationPage.identity);
		Thread.sleep(4000);
		String IdentityType = Exceldata.TestDataInMap.get("Identity");
		Wcontrol.Clickon(registrationPage.identity);
		Wcontrol.sendkeysByAction(registrationPage.identity, IdentityType);
		if (IdentityType.equalsIgnoreCase("passport")) {
			Wcontrol.Clickon(registrationPage.identityNumber);
			Wcontrol.EnterValueon(registrationPage.identityNumber, Exceldata.TestDataInMap.get("Identity number"));
			Wcontrol.ActionMoveToElementClcik(registrationPage.options);
		} else {

			// library.waitForVisibilityOfElement(registrationPage.identityNumber);
			Wcontrol.Clickon(registrationPage.identityNumber);
			Wcontrol.EnterValueon(registrationPage.identityNumber, Exceldata.TestDataInMap.get("Identity number"));
		}
	}

	@Then("Select the Title as {string} and Enter the name as {string}")
	public void select_the_title_as_something_and_enter_the_name_as_something(String title, String strArg2)
			throws Throwable {
		Wcontrol.Clickon(registrationPage.title);
		Wcontrol.sendkeysByAction(registrationPage.title, Exceldata.TestDataInMap.get("Title"));
		Wcontrol.EnterKeyon(registrationPage.title, Keys.ENTER);
		// Wcontrol.EnterValueon(registrationPage.Name,
		// Exceldata.TestDataInMap.get("Name"));
	}

	@Then("Enter the Date of Birth as {string} and Select the Occupation as {string}")
	public void enter_the_date_of_birth_as_something_and_select_the_occupation_as_something(String dob,
			String occupation) throws Throwable {
		Wcontrol.EnterValueon(registrationPage.dateOfBirth, Exceldata.TestDataInMap.get("DateOfBirth"));
		Wcontrol.sendkeysByAction(registrationPage.Occupation, Exceldata.TestDataInMap.get("Occupation"));
	}

	@Then("Select the Nationality as {string} and the Select the Race as {string}")
	public void select_the_nationality_as_something_and_the_select_the_race_as_something(String nationality,
			String race) throws Throwable {
		Wcontrol.sendkeysByAction(registrationPage.nationality, Exceldata.TestDataInMap.get("Nationality"));
		Wcontrol.sendkeysByAction(registrationPage.race, Exceldata.TestDataInMap.get("Race"));
	}
	
	@Then("Add Extent")
	public void add_Extent() throws Throwable {
		Thread.sleep(5000);
			defins.takeScreenShot("fdgshajkl");
	}

	@And("click on {string} button")
	public void click_on_something_button(String button) throws Throwable {

		By clickbtn = null;
		switch (button) {
		case "Login":
			clickbtn = commonPage.Login_btn;
			break;
		case "Next":

			clickbtn = commonPage.Next_btn;
			Wcontrol.scrollToView(clickbtn);
			break;
			
		case "Search Policy":
			Thread.sleep(1500);
			clickbtn = qualityCheck.Search;
			break;
			
		case "Institution Next":
			clickbtn = companyRegistration.institutionNext;
			break;
			
		case "Revert Policy":
			clickbtn = proposalPage.revertPolicy;
			break;
			
		case "Issue Receipt":
			clickbtn= proposalPage.issueReceiptBtn;
			break;
			
		case "Check All":
			Thread.sleep(500);
			clickbtn= proposalPage.checkAll;
			break;
			
		case "Issue Policy":
			Thread.sleep(1000);
			clickbtn= proposalPage.IssuePolicy;
			break;
			
		case "Dispatch":
			clickbtn = qualityCheck.dispatchButton;
			break;
		
		case "Acknowledge":
			clickbtn = qualityCheck.acknowledgeButton;
			break;
			
		case "YES":
			defins.takeScreenShot("Screen shot of the Test...");
			clickbtn = proposalPage.conformationYes;
			break;
			
		case "NO":
			clickbtn=proposalPage.conformationNO;
			break;

		case "Green":
			Thread.sleep(1000);
			Wcontrol.Clickon(registrationPage.tick);
			defins.takeScreenShot("Screen Shot for the test");
			break;
			
		case "ContactDetails Next":
			clickbtn = companyRegistration.contactNext;
			break;
			
		case "AddressDetails Next":
			clickbtn = companyRegistration.addressNext;
			break;
		
		case "Generate Voucher":
			clickbtn = qualityCheck.generateVoucher;
			break;

		case "Identity Next":
			clickbtn = commonPage.identityNext;
			Wcontrol.scrollToView(clickbtn);
			break;

		case "Address_Next":
			clickbtn = commonPage.addressNext;
			break;

		case "Contact_Next":
			clickbtn = commonPage.contactNext;
			break;

		case "Preview":
			clickbtn = commonPage.preview;
			break;

		case "Proceed":
			Thread.sleep(2000);
			clickbtn = commonPage.proceed;
			break;

		case "Save":
			clickbtn = commonPage.save;
			break;
		case "Add Bank":
			clickbtn = registrationPage.AddBank;
			break;
		case "Bank Next":
			clickbtn = registrationPage.BankNext;
			break;
		case "Create Employer":
			clickbtn = registrationPage.createEmployer;
			break;

		case "Quality Approve":
			clickbtn = qualityCheck.QualityApprove;
			break;
			
		case "OK":
			clickbtn = qualityCheck.OK;
			break;

		case "Issue":
			clickbtn = qualityCheck.Issue;
			break;
			
		case "Preview Next":
			clickbtn = companyRegistration.preview;
			break;

		default:
			break;
		}
		// library.waitForClickableElement(clickbtn);
		if (clickbtn != null) {
			Thread.sleep(1000);
			Wcontrol.clickJSEon(clickbtn);
		}

	}

	@And("Select the Gender as {string}")
	public void select_the_gender_as_something_and_select_the_maritial_status_as_something(String strArg1)
			throws Throwable {

		Wcontrol.clickJSEon(registrationPage.gender);
		String gender = Exceldata.TestDataInMap.get("Gender");
		if (gender.equalsIgnoreCase("Male")) {
			Wcontrol.ActionMoveToElementClcik(registrationPage.genderMale);

		} else if (gender.equalsIgnoreCase("Female")) {
			Wcontrol.ActionMoveToElementClcik(registrationPage.genderFeMale);
		} else {
			Wcontrol.ActionMoveToElementClcik(registrationPage.genderOthers);
		}
	}

	@And("Enter the Height as {string} and Enter the Weight as {string}")
	public void enter_the_height_as_something_and_enter_the_weight_as_something(String height, String weight)
			throws Throwable {
		Wcontrol.EnterValueon(registrationPage.height, Exceldata.TestDataInMap.get("Height"));
		Wcontrol.EnterValueon(registrationPage.weight, Exceldata.TestDataInMap.get("Weight"));
	}

	@And("Click on Create Customer button")
	public void Click_on_Create_Customer_button() throws Throwable {
		
		
		if(base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(4000);
		} else {
			library.elementstable(registrationPage.createCustomer);
			library.waitForClickableElement(registrationPage.createCustomer,20);
		}
		// library.waitForClickableElement(registrationPage.createCustomer);
		Wcontrol.clickJSEon(registrationPage.createCustomer);
		
	}

	@And("Click on Create Company button")
	public void Click_on_Create_Company_button() throws Throwable {
		Thread.sleep(4000);
		// library.waitForClickableElement(registrationPage.createCustomer);
		Wcontrol.clickJSEon(companyRegistration.createCompany);
		
	}

	@Then("Enter {string} in address1 and Enter the Post code as {string}")
	public void enter_something_in_address1_and_enter_the_post_code_as_50000(String strArg1, String postCode)
			throws Throwable {
		Thread.sleep(2000);
		Wcontrol.EnterValueon(registrationPage.address1, Exceldata.TestDataInMap.get("Address"));
		Wcontrol.sendkeysByAction(registrationPage.postCode, Exceldata.TestDataInMap.get("PostCode"));
	}

	@Then("^Enter the Contact Type as \"([^\"]*)\" and Enter the Description as \"([^\"]*)\"$")
	public void enter_the_contact_type_as_something_and_enter_the_description_as_something(String strArg1,
			String strArg2) throws Throwable {
		Thread.sleep(1000);
		Wcontrol.scrollToView(registrationPage.contactType);
		Wcontrol.sendkeysByAction(registrationPage.contactType, Exceldata.TestDataInMap.get("ContactType"));
		Wcontrol.EnterKeyon(registrationPage.contactType, Keys.ENTER);
		Wcontrol.EnterValueon(registrationPage.contactDesc, Exceldata.TestDataInMap.get("ContactDescription"));
	}

	@And("click on {string} buttons")
	public void click_on_something_buttons(String button) throws Throwable {
		
		
		
		By clickbtn = null;
		switch (button) {
		case "Create Contact":
			clickbtn = companyRegistration.createContact;			
			break;
			
		case "Add Contact":
			clickbtn = registrationPage.addContact;
			break;

		case "Add Address":
			clickbtn = companyRegistration.addAddress;
			break;
			
		case "Add BankDetails":
			clickbtn = companyRegistration.addBankDetails;
			break;
			
		default:
			break;
		}
		Wcontrol.scrollToView(clickbtn);
		Thread.sleep(1000);
		Wcontrol.clickJSEon(clickbtn);

	}

	@Then("^Enter the Identity Issue date as \"([^\"]*)\" and Expiry date as \"([^\"]*)\"$")
	public void enter_the_identity_issue_date_as_something_and_expiry_date_as_something(String issueDate,
			String ExpDate) throws Throwable {
		Thread.sleep(1000);
		Wcontrol.EnterValueon(registrationPage.identityIssuedate, Exceldata.TestDataInMap.get("IdentityIssueDate"));
		Wcontrol.EnterValueon(registrationPage.identityExpirydate, Exceldata.TestDataInMap.get("IdentityExpiryDate"));
		Wcontrol.clickJSEon(registrationPage.detailsTick);
	}

	@And("^Select the Contact Type as \"([^\"]*)\" and Enter the Description as \"([^\"]*)\"$")
	public void Select_the_contact_type_as_something_and_enter_the_description_as_something(String strArg1,
			String strArg2) throws Throwable {
		Thread.sleep(1000);
		Wcontrol.clickJSEon(registrationPage.ContactDetails);
		Thread.sleep(1000);
		Wcontrol.scrollToView(registrationPage.cdType);
		Wcontrol.sendkeysByAction(registrationPage.cdType, Exceldata.TestDataInMap.get("ContactType"));
		Wcontrol.EnterKeyon(registrationPage.cdType, Keys.ENTER);
		Wcontrol.EnterValueon(registrationPage.cdDesc, Exceldata.TestDataInMap.get("ContactDescription"));
		Wcontrol.clickJSEon(registrationPage.CdTick);
	}

	@Then("^Bank name as \"([^\"]*)\" and Enter the Account number as \"([^\"]*)\"$")
	public void bank_name_as_something_and_enter_the_account_number_as_something(String bankName, String Accountnumber)
			throws Throwable {
		Wcontrol.sendkeysByAction(registrationPage.bankName, Exceldata.TestDataInMap.get("BankName"));
		Wcontrol.EnterKeyon(registrationPage.bankName, Keys.ENTER);
		Wcontrol.EnterValueon(registrationPage.AccountNumber, Exceldata.TestDataInMap.get("AccountNumber"));
		Wcontrol.clickJSEon(registrationPage.BankTick);
	}

	@Then("^Enter the Employe Name as \"([^\"]*)\" and Nature of Business as \"([^\"]*)\"$")
	public void enter_the_employe_name_as_something_and_nature_of_business_as_something(String EmployerName,
			String nature) throws Throwable {
		Wcontrol.EnterValueon(registrationPage.EmployerName, Exceldata.TestDataInMap.get("Employer Name"));
		Wcontrol.EnterValueon(registrationPage.natureOfBusiness, Exceldata.TestDataInMap.get("Nature of Business"));
	}

	@Then("^Enter the Address as \"([^\"]*)\"  and Address2 as \"([^\"]*)\"$")
	public void enter_the_address_as_something_and_address2_as_something(String address1, String address2)
			throws Throwable {
		Wcontrol.EnterValueon(registrationPage.Empaddress1, Exceldata.TestDataInMap.get("Address1"));
		Wcontrol.EnterValueon(registrationPage.Empaddress2, Exceldata.TestDataInMap.get("Address2"));
	}

	@Then("^Enter the Registration no as \"([^\"]*)\" and Enter the Contact number as \"([^\"]*)\"$")
	public void enter_the_registration_no_as_something_and_enter_the_contact_number_as_something(String reg,
			String contact) throws Throwable {
		Wcontrol.EnterValueon(registrationPage.EmpRegistration, Exceldata.TestDataInMap.get("Registration"));
		Wcontrol.EnterValueon(registrationPage.EmpContactNo, Exceldata.TestDataInMap.get("Contact No"));
		Wcontrol.clickJSEon(registrationPage.EmpTick);
	}

}
