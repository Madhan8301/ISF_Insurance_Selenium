package com.kgisl.stepDefinition;

import org.apache.poi.ss.usermodel.*;

import java.util.*;

import junit.framework.Assert;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.kgisl.PageElements.Web.CommonPageElements;
import com.kgisl.PageElements.Web.CompanyRegistration;
import com.kgisl.PageElements.Web.EnquiryPage;
import com.kgisl.PageElements.Web.ProposalPage;
import com.kgisl.PageElements.Web.QualityCheck;
import com.kgisl.PageElements.Web.RegistrationPage;
import com.kgisl.PageElements.Web.UnderwritingPage;
import com.kgisl.base.CompanyExcelUtility;
import com.kgisl.base.CustomerExcelUtility;
import com.kgisl.base.Data_Set;
import com.kgisl.base.ExcelUtility;
import com.kgisl.base.FrameworkConfig;
import com.kgisl.base.Hooks;
import com.kgisl.base.ProposalExcelUtility;
import com.kgisl.base.RiderExcelUtility;
import com.kgisl.controls.WebControl;
import com.kgisl.library.LibraryClass;
import com.kgisl.library.ReportOut;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class EverGreenStepDefinitions {

	public WebControl Wcontrol;
	public LibraryClass library;
	public CommonPageElements commonPage;
	public RegistrationPage registrationPage;
	public Hooks base;
	public EnquiryPage enquiryPage;
	public ProposalPage proposalPage;
	public UnderwritingPage underWritingPage;
	private ExcelUtility Exceldata;
	private RiderExcelUtility RiderExceldata;
	private CustomerExcelUtility CustomerExceldata;
//	private ProposalExcelUtility CustomerExceldata;
	private CompanyExcelUtility companyExceldata;
	public ProposePageStepDefinitions proposalStep;
	public QualityCheck qualityCheck;
	public BaseDefins defins;
	public CompanyRegistration companyRegistration;
	static Map maps = new HashMap();
	private String TestId = null;
	public String Name1, Name2, UWStatus, NoICValue, customerAge, DtrsAge, amountPayable, ContactDESC, CustomerName, Width, Height;
	public double PremiumAmount;
	private String sheetName = null;
	private Data_Set Data;
	private ReportOut report;
	public String txtIdentityNumber;
	public List<Map<String, String>> testDataNew;
	public List<Map<String, String>> dataList;
	public Map<String, String> data;
	// public String [] riderName= {};
	// public List<String> optionalRiderNames = new;
	// public List <String> optionalRiderNames= new ArrayList<String>();
	public List<String> optionalRiderNames = new ArrayList<String>();

	private Map<String, String> InputData;

	FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);

	public EverGreenStepDefinitions(WebControl wcontrol, LibraryClass library, CommonPageElements commonPage,
			RegistrationPage registrationPage, Hooks base, ProposalPage proposalPage, UnderwritingPage underWritingPage,
			ExcelUtility exceldata, QualityCheck qualityCheck, Data_Set data, ReportOut report,
			ProposePageStepDefinitions proposalStep, BaseDefins defins, CompanyRegistration companyRegistration,
			EnquiryPage enquiryPage, RiderExcelUtility RiderExceldata, CustomerExcelUtility CustomerExceldata, CompanyExcelUtility companyExceldata) {
		super();
		this.Wcontrol = wcontrol;
		this.library = library;
		this.commonPage = commonPage;
		this.registrationPage = registrationPage;
		this.base = base;
		this.proposalPage = proposalPage;
		this.underWritingPage = underWritingPage;
		this.Exceldata = exceldata;
		this.Data = data;
		this.report = report;
		this.proposalStep = proposalStep;
		this.qualityCheck = qualityCheck;
		this.defins = defins;
		this.companyRegistration = companyRegistration;
		this.enquiryPage = enquiryPage;
		this.RiderExceldata = RiderExceldata;
		this.CustomerExceldata = CustomerExceldata;
		this.companyExceldata = companyExceldata;
//		this.CustomerExceldata = CustomerExceldata;
	}

	@Then("Navigate to Main Menu icon")
	public void navigate_to_main_menu() throws Throwable {

		Thread.sleep(2000);
		library.waitForClickableElement(registrationPage.menuOptions);
		Wcontrol.clickJSEon(registrationPage.menuOptions);

	}

	@Then("Select the Underwriting Questions")
	public void Underwriting_Questions() throws Throwable {
//		Wcontrol.clickJSEon(proposalPage.LifeAssuredView);
//		Thread.sleep(3000);
		Wcontrol.clickJSEon(proposalPage.LifeAssuredView);

		library.elementstable(proposalPage.Save);
		library.waitForClickableElement(proposalPage.Save, 30);

		Wcontrol.scrollDownLong();

//		Wcontrol.scrollToView(proposalPage.UnderwritingQuestions);
		library.waitForClickableElement(proposalPage.UnderwritingQuestions, 30);
		Wcontrol.clickJSEon(proposalPage.UnderwritingQuestions);
		Underwriting_Questions_Response();
		Wcontrol.clickJSEon(proposalPage.UWQuestionsNext);
		Wcontrol.clickJSEon(proposalPage.Save);
		Last_Process();

	}

	@Then("Navigate to MainMenu and Select UnderWriting")
	public void Go_to_UnderWriting_Screen() throws Throwable {

		library.waitForClickableElement(registrationPage.menuOptions);
		Wcontrol.clickJSEon(registrationPage.menuOptions);
		library.waitForVisibilityOfElement(underWritingPage.underWriting, 60);
		Wcontrol.clickJSEon(underWritingPage.underWriting);

	}

	@Then("Select {string}")
	public void click_on_something_and_select_something(String button1) throws Throwable {
		By clickbtn = null;
		switch (button1) {
		case "Underwriting":
			clickbtn = underWritingPage.underWriting;
			break;
		case "Acknowledge Policy":
			clickbtn = qualityCheck.acknowledgePolicy;
			break;

		default:
			break;
		}
		library.waitForClickableElement(clickbtn);
		Wcontrol.clickJSEon(clickbtn);
	}

	// ------------------------------------------------------------------------------------------------
	@Then("Select Identity and Select Identity number")
	public void Identity_and_Identity_Number() throws Throwable {

		library.waitForVisibilityOfElement(registrationPage.identity, 70);
		Thread.sleep(1000);
		String IdentityType = CustomerExceldata.TestDataInMap.get("Identity");

		txtIdentityNumber = CustomerExceldata.TestDataInMap.get("Identity number");

		Wcontrol.clickJSEon(registrationPage.identity);

		if (IdentityType.equalsIgnoreCase("passport")) {
			Wcontrol.sendkeysByAction(registrationPage.identity, IdentityType);

			if (base.environemt.equalsIgnoreCase("ILIVE")) {
				Thread.sleep(2000);
				Wcontrol.ActionMoveToElement(registrationPage.options);
				Wcontrol.clickJSEon(registrationPage.options);
			}

			Wcontrol.clickJSEon(registrationPage.identityNumber);
			Wcontrol.EnterValueon(registrationPage.identityNumber, txtIdentityNumber);

		} else if (IdentityType.equalsIgnoreCase("System Generated Identification")) {
			library.waitForVisibilityOfElement(registrationPage.identity, 70);
			Wcontrol.sendkeysByAction(registrationPage.identity, IdentityType);

//			String noicNo = Wcontrol.GetAttributeValueon(registrationPage.identityNumber, "identityNo");
//			System.err.println(noicNo);
		} else {

			Wcontrol.sendkeysByAction(registrationPage.identity, IdentityType);
			Thread.sleep(1000);
			Wcontrol.clickJSEon(registrationPage.identityNumber);
			Wcontrol.EnterValueon(registrationPage.identityNumber, txtIdentityNumber);
		}

	}

	@Then("Select Identity and Select Identity number one")
	public void Identity_and_Identity_Number_For_Reg() throws Throwable {

		library.waitForVisibilityOfElement(registrationPage.identity, 70);
		Thread.sleep(1000);
		String IdentityType = CustomerExceldata.TestDataInMap.get("Identity");
		String genCode = null;
		if (CustomerExceldata.TestDataInMap.get("Gender").equalsIgnoreCase("Male")) {
			genCode = "1";
		} else {
			genCode = "2";
		}

		txtIdentityNumber = CustomerExceldata.TestDataInMap.get("Identity number") + GetFiveDigRandomNumber() + genCode;

		Wcontrol.clickJSEon(registrationPage.identity);

		if (IdentityType.equalsIgnoreCase("passport")) {
			

			if (base.environemt.equalsIgnoreCase("ILIVE")) {
				Wcontrol.sendkeysByAction(registrationPage.identity, IdentityType);
				Thread.sleep(2000);
				Wcontrol.ActionMoveToElement(registrationPage.options);
				Wcontrol.clickJSEon(registrationPage.options);
			} else if (base.environemt.equalsIgnoreCase("HNB")) {
				Wcontrol.sendkeysByAction(registrationPage.identity, "PASSP");
				Thread.sleep(500);
				Wcontrol.clickJSEon(proposalPage.planDescOption);
			} else {
				Wcontrol.sendkeysByAction(registrationPage.identity, IdentityType);
			}

			Wcontrol.clickJSEon(registrationPage.identityNumber);
			Wcontrol.EnterValueon(registrationPage.identityNumber, txtIdentityNumber);

		} else if (IdentityType.equalsIgnoreCase("System Generated Identification")) {
			library.waitForVisibilityOfElement(registrationPage.identity, 70);
			Wcontrol.sendkeysByAction(registrationPage.identity, IdentityType);
			Thread.sleep(1000);

//			String noicNo = Wcontrol.GetAttributeValueon(registrationPage.identityNumber, "identityNo");
//			System.err.println(noicNo);
		} else {

			Wcontrol.sendkeysByAction(registrationPage.identity, IdentityType);
			Thread.sleep(1000);
			Wcontrol.clickJSEon(registrationPage.identityNumber);
			Wcontrol.EnterValueon(registrationPage.identityNumber, txtIdentityNumber);
		}

	}

	public int GetFiveDigRandomNumber() {
		Random random = new Random();

		// Generate a random 5-digit number
		int min = 10000; // The minimum 5-digit number
		int max = 99999; // The maximum 5-digit number
		int random5DigitNumber = random.nextInt(max - min + 1) + min;
		return random5DigitNumber;
	}

	@Then("Select Identity as {string} and Select Identity number")
	public void No_IC(String noIC) throws Throwable {
		library.waitForVisibilityOfElement(registrationPage.identity, 70);
		Wcontrol.sendkeysByAction(registrationPage.identity, noIC);
		Thread.sleep(2000);
		NoICValue = Wcontrol.GetAttributeValueon(registrationPage.identityNumber, "value");
		System.out.println(NoICValue);

	}

	@Then("Select the Title and Enter the name")
	public void Tile_and_Name_Selection() throws Throwable {

		String title = CustomerExceldata.TestDataInMap.get("Title");
		library.elementstable(registrationPage.title);
		library.waitForClickableElement(registrationPage.title, 10);
//		Wcontrol.clickJSEon(registrationPage.title);

//		Wcontrol.sendkeysByAction(registrationPage.title, "M");
		By opt = null;
		switch (title) {
		case "MR":
			opt = registrationPage.titleMR;
			break;
		case "MISS":
			opt = registrationPage.titleMISS;
			break;
		case "MRS":
			opt = registrationPage.titleMRS;
			break;

		default:
			break;
		}

		Thread.sleep(500);

		Wcontrol.click_and_Select(registrationPage.title, opt);
//		Wcontrol.ActionMoveToElementClcik(opt);

		Wcontrol.EnterValueon(registrationPage.firstName, CustomerExceldata.TestDataInMap.get("FirstName"));
		if (CustomerExceldata.TestDataInMap.get("MiddleName") != null) {
			Wcontrol.EnterValueon(registrationPage.middleName, CustomerExceldata.TestDataInMap.get("MiddleName"));
		}
		Wcontrol.EnterValueon(registrationPage.lastName,
				CustomerExceldata.TestDataInMap.get("LastName") + " " + GenerateRandomLetters());

		By nameLoc = By.xpath("((//*[text()='Name']/parent::label)/parent::span)/parent::div//input");
		CustomerName = Wcontrol.GetAttributeValueon(nameLoc, "value");

	}

	public String getRandomText() {
		Random random = new Random();

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		StringBuilder randomSequence = new StringBuilder();
		for (int i = 0; i < 7; i++) {
			int index = random.nextInt(alphabet.length());

			randomSequence.append(alphabet.charAt(index));
		}
		String randomText = randomSequence.toString();
		return randomText;
	}

	@Then("check the Existing Customer Details")
	public void Existing_Customer() throws Throwable {
		String IdentityType = CustomerExceldata.TestDataInMap.get("Identity");

		if (IdentityType.equalsIgnoreCase("System Generated Identification")) {
//			Wcontrol.scrollToView(commonPage.Next_btn);
			Wcontrol.scrollDownLong();
			Wcontrol.scrollDownMin();
			Wcontrol.scrollDownLong();
//			Wcontrol.scrollDownMin();
//			Wcontrol.clickJSEon(commonPage.Next_btn);
			Wcontrol.clickJSEon(By.xpath("//*[contains(text(),'Address Details')]"));
		} else {

			Wcontrol.scrollDownLong();
			Wcontrol.clickJSEon(registrationPage.clientInfoExist);
			Thread.sleep(1500);
			defins.takeScreenShot("SCreen shot of the Test............");
			String IsnewCustomer = "Existing Customer Details Not Available !";
			String ExistingDetails = Wcontrol.GetTexton(registrationPage.existingDetails).trim();
			System.out.println(ExistingDetails);
			if (ExistingDetails.equalsIgnoreCase(IsnewCustomer)) {

				Wcontrol.clickJSEon(registrationPage.clientInfoCancel);
				Thread.sleep(2000);
				Wcontrol.clickJSEon(commonPage.Next_btn);
			} else {
				System.err.println("Customer Alredy Exist !!!!!!!");
				Assert.assertEquals(0, 1);

			}
		}

	}
	
    

	@Then("Enter the Date of Birth and Select the Occupation")
	public void Date_of_birth_and_Occupation_Selection() throws Throwable {
//		Wcontrol.EnterValueon(registrationPage.dateOfBirth, CustomerExceldata.TestDataInMap.get("DateOfBirth"));
		By calenderBtn = By.xpath("((//*[contains(text(),'Date Of Birth')]/parent::label)/parent::span)/parent::div/parent::div//div//button");

		Wcontrol.SelectDateofBirth(calenderBtn,CustomerExceldata.TestDataInMap.get("DateOfBirth"));
		Wcontrol.scrollDownLittle();
		Wcontrol.sendkeysByAction(registrationPage.Occupation, CustomerExceldata.TestDataInMap.get("Occupation"));
	}

	@Then("Select the Nationality and the Select the Race")
	public void Nationality_and_th_Race_Selection() throws Throwable {
		Wcontrol.sendkeysByAction(registrationPage.nationality, CustomerExceldata.TestDataInMap.get("Nationality"));
		Thread.sleep(1000);
		Wcontrol.sendkeysByAction(registrationPage.race, CustomerExceldata.TestDataInMap.get("Race"));
		Thread.sleep(1000);
	}

	@And("Enter the Height and Enter the Weight")
	public void Height_and_Weight_Selection() throws Throwable {

		Wcontrol.scrollDownMin();
		Thread.sleep(500);
		Wcontrol.EnterValueon(registrationPage.height, CustomerExceldata.TestDataInMap.get("Height"));
		Wcontrol.EnterValueon(registrationPage.weight, CustomerExceldata.TestDataInMap.get("Weight"));
		defins.takeScreenShot("Screen Shot for the test");
		Wcontrol.scrollDownLong();
		Wcontrol.scrollDownMin();
		Wcontrol.scrollDownLong();

	}

	@And("Select the Gender")
	public void Gender_Selection() throws Throwable {

		Wcontrol.clickJSEon(registrationPage.gender);
		String gender = CustomerExceldata.TestDataInMap.get("Gender");
		if (gender.equalsIgnoreCase("Male")) {
			Wcontrol.ActionMoveToElementClcik(registrationPage.genderMale);

		} else if (gender.equalsIgnoreCase("Female")) {
			Wcontrol.ActionMoveToElementClcik(registrationPage.genderFeMale);
		} else {
			Wcontrol.ActionMoveToElementClcik(registrationPage.genderOthers);
		}
	}

	@Then("Enter address1 and Enter the Post code")
	public void Address1_and_Post_code_Selection() throws Throwable {
		Thread.sleep(2000);
		Wcontrol.scrollUpMin();
		Wcontrol.EnterValueon(registrationPage.address1, CustomerExceldata.TestDataInMap.get("Address"));
		Wcontrol.sendkeysByAction(registrationPage.postCode, CustomerExceldata.TestDataInMap.get("PostCode"));
		defins.takeScreenShot("Screen Shot for the test");
//		Wcontrol.scrollToView(registrationPage.addressScroll);

	}

	@Then("Enter the Contact Type and Enter the Description")
	public void Contact_type_and_Contact_description_Selection() throws Throwable {
		Thread.sleep(1000);
		Wcontrol.scrollToView(registrationPage.contactType);
//		Wcontrol.sendkeysByAction(registrationPage.contactType, Exceldata.TestDataInMap.get("ContactType"));
//		Wcontrol.EnterKeyon(registrationPage.contactType, Keys.ENTER);
		String CDType = CustomerExceldata.TestDataInMap.get("ContactType");
		if (CDType.equalsIgnoreCase("E-MAIL ADDRESS")) {
			Wcontrol.click_and_Select(registrationPage.contactType, By.xpath("(//mat-option)[3]"));
		} else {
			Wcontrol.sendkeysByAction(registrationPage.contactType, CustomerExceldata.TestDataInMap.get("ContactType"));
			Wcontrol.EnterKeyon(registrationPage.contactType, Keys.ENTER);
		}
		ContactDESC = CustomerExceldata.TestDataInMap.get("ContactDescription") + GetFiveDigRandomNumber()
				+ "@gmail.com";
		Wcontrol.EnterValueon(registrationPage.contactDesc, ContactDESC);

	}

	@Then("Enter the Identity Issue date and Expiry date")
	public void Identity_issue_date_and_expiry_date_as_Selection() throws Throwable {
		Thread.sleep(1000);
		Wcontrol.EnterValueon(registrationPage.identityIssuedate,
				CustomerExceldata.TestDataInMap.get("IdentityIssueDate"));
		Wcontrol.EnterValueon(registrationPage.identityExpirydate,
				CustomerExceldata.TestDataInMap.get("IdentityExpiryDate"));
		Wcontrol.clickJSEon(registrationPage.detailsTick);
		defins.takeScreenShot("Screen Shot for the test");
	}

	@Then("Add Another Identification Details")
	public void Add_another_Identification_details() throws Throwable {
		Wcontrol.clickJSEon(registrationPage.createIdentity);
		Wcontrol.clickJSEon(registrationPage.newIdentity);
		String IdentityType = CustomerExceldata.TestDataInMap.get("newIdentity");
		String newIdentityNumber = CustomerExceldata.TestDataInMap.get("New Identity number");

		if (IdentityType.equalsIgnoreCase("passport")) {
			if (base.environemt.equalsIgnoreCase("ILIVE")) {
				Wcontrol.sendkeysByAction(registrationPage.newIdentity, IdentityType);
				Thread.sleep(2000);
				Wcontrol.ActionMoveToElementClcik(proposalPage.opt);

			} else {
				Wcontrol.sendkeysByAction(registrationPage.newIdentity, IdentityType);
				Thread.sleep(1000);
			}
			Wcontrol.clickJSEon(registrationPage.newIdentityNumber);
			Wcontrol.EnterValueon(registrationPage.newIdentityNumber, newIdentityNumber);

		} else {

			Wcontrol.sendkeysByAction(registrationPage.newIdentity, IdentityType);
			Thread.sleep(1000);
			Wcontrol.clickJSEon(registrationPage.newIdentityNumber);
			Wcontrol.EnterValueon(registrationPage.newIdentityNumber, newIdentityNumber);
		}
		Wcontrol.EnterValueon(registrationPage.newIssueDate, "04/08/2019");
		Wcontrol.EnterValueon(registrationPage.newExpDate, "04/07/2043");
		Wcontrol.clickJSEon(registrationPage.newIdTick);
	}

	@And("Select the Contact Type and Enter the Description")
	public void Contact_type_and_enter_the_description() throws Throwable {
		Thread.sleep(1000);
		Wcontrol.clickJSEon(registrationPage.ContactDetails);
		Thread.sleep(1000);
		Wcontrol.scrollToView(registrationPage.cdType);

		String CDType = CustomerExceldata.TestDataInMap.get("ContactType");
		if (CDType.equalsIgnoreCase("E-MAIL ADDRESS")) {
			Wcontrol.click_and_Select(registrationPage.cdType, By.xpath("(//mat-option)[3]"));
		} else {
			Wcontrol.sendkeysByAction(registrationPage.cdType, CustomerExceldata.TestDataInMap.get("ContactType"));
			Wcontrol.EnterKeyon(registrationPage.cdType, Keys.ENTER);
		}

//		Wcontrol.sendkeysByAction(registrationPage.cdType, Exceldata.TestDataInMap.get("ContactType"));
//		Wcontrol.EnterKeyon(registrationPage.cdType, Keys.ENTER);
		Wcontrol.EnterValueon(registrationPage.cdDesc, ContactDESC);
		Wcontrol.clickJSEon(registrationPage.CdTick);
		defins.takeScreenShot("Screen Shot for the test");
	}

	@Then("Bank name and Enter the Account number")
	public void Bank_name_and_account_number_Selection() throws Throwable {
//		Wcontrol.sendkeysByAction(registrationPage.bankName, CustomerExceldata.TestDataInMap.get("BankName"));
		Wcontrol.clickJSEon(registrationPage.bankName);
		Wcontrol.EnterKeyon(registrationPage.bankName, Keys.ENTER);
		Wcontrol.EnterValueon(registrationPage.AccountNumber, CustomerExceldata.TestDataInMap.get("AccountNumber"));
		Wcontrol.clickJSEon(registrationPage.BankTick);
		defins.takeScreenShot("Screen Shot for the test");
	}

	@Then("Enter the Employe Name and Nature of Business")
	public void Employe_name_and_nature_of_business() throws Throwable {
		Wcontrol.EnterValueon(registrationPage.EmployerName, CustomerExceldata.TestDataInMap.get("Employer Name"));
		Wcontrol.EnterValueon(registrationPage.natureOfBusiness,
				CustomerExceldata.TestDataInMap.get("Nature of Business"));
	}

	@Then("Enter the Address1 and Address2")
	public void Address_and_address2_Selection() throws Throwable {
		Wcontrol.EnterValueon(registrationPage.Empaddress1, CustomerExceldata.TestDataInMap.get("Address1"));
		Wcontrol.EnterValueon(registrationPage.Empaddress2, CustomerExceldata.TestDataInMap.get("Address2"));
	}

	@Then("Enter the Registration no and Enter the Contact number")
	public void Registration_no_and_enter_the_contact_number() throws Throwable {
		Wcontrol.EnterValueon(registrationPage.EmpRegistration, CustomerExceldata.TestDataInMap.get("Registration"));
		Wcontrol.EnterValueon(registrationPage.EmpContactNo, CustomerExceldata.TestDataInMap.get("Contact No"));
		Wcontrol.clickJSEon(registrationPage.EmpTick);
		defins.takeScreenShot("Screen Shot for the test");
	}

	// --------------------------------------Proposal-----------------------------------------------------

//	@Then("Select the Plan description")
//	public void select_plan_descriptionssss() throws Throwable {
//
////		if (Wcontrol.VisibleElementCount(commonPage.animation) > 0) {
////			library.waitForInVisibilityOfElement(commonPage.animation);
////		}
////		proposalStep.invisiblelements();
//		library.elementstable(proposalPage.planDescription);
//		library.waitForVisibilityOfElement(proposalPage.planDescription, 70);
//		library.waitForClickableElement(proposalPage.planDescription);
//		library.waitForPresenceOfElement(proposalPage.planDescription);
//		String planDesc = Exceldata.TestDataInMap.get("Plan Descriptipn");
//		if (planDesc.equalsIgnoreCase("Future Invest")) {
//			Wcontrol.sendkeysByAction(proposalPage.planDescription, Exceldata.TestDataInMap.get("PlanCode"));
//			
//			if (base.environemt.equalsIgnoreCase("ILIVE")) {
//				library.elementstable(proposalPage.planDescOption);
//				Thread.sleep(4000);
//			} else {
//				library.elementstable(proposalPage.planDescOption);
//			}
//			base.getDriver().findElement(proposalPage.planDescription).sendKeys(Keys.ENTER);
////			Thread.sleep(3000);
////			List<WebElement> futOpts = Wcontrol.GetAllElements(proposalPage.planDescOption);
////			for(int i=0;i<futOpts.size();i++) {
////				String ele = Wcontrol.GetTexton(futOpts.get(i));
////				System.out.println(ele);
////			}
//			
//		} else if (planDesc.equalsIgnoreCase("Plan19")) {
//			Wcontrol.sendkeysByAction(proposalPage.planDescription, "Plan19");
//			library.elementstable(proposalPage.planDescOption);
//			library.waitForClickableElement(proposalPage.planDescOption);
//			Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);
//		} else if (planDesc.equalsIgnoreCase("Plan11")) {
//			if (base.environemt.equalsIgnoreCase("ILIVE")) {
//				Wcontrol.sendkeysByAction(proposalPage.planDescription,
//						Exceldata.TestDataInMap.get("Plan Descriptipn"));
//				library.elementstable(proposalPage.planDescOption);
//				library.waitForClickableElement(proposalPage.planDescOption);
//				Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);
//			} else {
//				Wcontrol.sendkeysByAction(proposalPage.planDescription,
//						Exceldata.TestDataInMap.get("Plan Descriptipn"));
//				library.elementstable(proposalPage.planDescOption);
//				library.waitForClickableElement(proposalPage.planDescOption);
//				Wcontrol.ActionMoveToElementClcik(proposalPage.opt);
//			}
//		}
//
//		else {
//			Wcontrol.sendkeysByAction(proposalPage.planDescription, Exceldata.TestDataInMap.get("Plan Descriptipn"));
//			library.elementstable(proposalPage.planDescOption);
//			library.waitForClickableElement(proposalPage.planDescOption);
//			Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);
//		}
////		proposalStep.invisiblelements();
//
//		if (base.environemt.equalsIgnoreCase("ILIVE")) {
////			library.waitForInVisibilityOfElement(commonPage.animation);
//			Thread.sleep(13000);
//			library.elementstable(proposalPage.autoUnderWritingYes);
//			library.waitForClickableElement(proposalPage.autoUnderWritingYes);
//		} else {
//			library.elementstable(proposalPage.autoUnderWritingYes);
//			library.waitForClickableElement(proposalPage.autoUnderWritingYes);
//		}
////		Wcontrol.clickJSEon(proposalPage.autoUnderWritingYes);
////		Thread.sleep(2000);
//		// ---cloud---
////		Thread.sleep(1000);
//		UWStatus = "NO";
//		defins.takeScreenShot("Screen Shot for the test");
//		report.setPlanDesc(Exceldata.TestDataInMap.get("Plan Descriptipn"));
//		Wcontrol.scrollDownLong();
//		library.elementstable(proposalPage.BasicNext);
//		library.waitForClickableElement(proposalPage.BasicNext, 20);
//		Thread.sleep(1000);
//	}

	@Then("Select the Plan description")
	public void select_plan_descriptionssss() throws Throwable {

//		if (Wcontrol.VisibleElementCount(commonPage.animation) > 0) {
//			library.waitForInVisibilityOfElement(commonPage.animation);
//		}
//		proposalStep.invisiblelements();
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		}

		library.elementstable(proposalPage.planDescription);
		library.waitForVisibilityOfElement(proposalPage.planDescription, 70);
		library.waitForClickableElement(proposalPage.planDescription);
		library.waitForPresenceOfElement(proposalPage.planDescription);

		Wcontrol.sendkeysByAction(proposalPage.planDescription, CustomerExceldata.TestDataInMap.get("PlanCode"));

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.elementstable(proposalPage.planDescOption);
			library.waitForVisibilityOfElement(proposalPage.planDescOption, 70);
			library.waitForClickableElement(proposalPage.planDescOption);
			library.waitForPresenceOfElement(proposalPage.planDescOption);
			Thread.sleep(15000);
			base.getDriver().findElement(proposalPage.planDescription).sendKeys(Keys.ENTER);
		} else {
			library.elementstable(proposalPage.planDescOption);
			if (CustomerExceldata.TestDataInMap.get("PlanCode").equalsIgnoreCase("Plan11")) {
//				Wcontrol.clickJSEon(proposalPage.opt);
				List<WebElement> value = Wcontrol.GetAllElements(By.xpath("//mat-option"));
				int clickLoc=0;
				for(int i=0;i<value.size();i++) {
					String checkLoc = "//mat-option["+(i+1)+"]";
					
					Thread.sleep(1000);
					String name = Wcontrol.GetTexton(By.xpath(checkLoc)).trim();
					if(name.equalsIgnoreCase("Platinum Endowment Plan (PLAN11)")) {
//						clickLoc = i;
						Wcontrol.EnterKeyon(proposalPage.planDescription, Keys.ENTER);
						Thread.sleep(1000);
					} else {
//						continue;
						Wcontrol.EnterKeyon(proposalPage.planDescription, Keys.DOWN);
					}
					
//					Wcontrol.clickJSEon(By.xpath(clickLoc));
				}
				Thread.sleep(2500);
				String newPlan = Wcontrol.GetAttributeValueon(proposalPage.planDescription, "value");
//				System.out.println(newPlan);
				if(!newPlan.equalsIgnoreCase("Platinum Endowment Plan")) {
					
					Wcontrol.clearText(proposalPage.planDescription);
					Wcontrol.sendkeysByAction(proposalPage.planDescription, CustomerExceldata.TestDataInMap.get("PlanCode"));
					library.elementstable(proposalPage.planDescOption);
					library.waitForClickableElement(proposalPage.planDescOption);
					List<WebElement> value1 = Wcontrol.GetAllElements(By.xpath("//mat-option"));
					int clickLoc1=0;
					for(int k=0;k<value1.size();k++) {
						String checkLoc1 = "//mat-option["+(k+1)+"]";
						
						Thread.sleep(1000);
						String name = Wcontrol.GetTexton(By.xpath(checkLoc1)).trim();
						if(name.equalsIgnoreCase("Platinum Endowment Plan (PLAN11)")) {
//							clickLoc = i;
							Wcontrol.EnterKeyon(proposalPage.planDescription, Keys.ENTER);
						} else {
//							continue;
							Wcontrol.EnterKeyon(proposalPage.planDescription, Keys.DOWN);
						}
						
//						Wcontrol.clickJSEon(By.xpath(clickLoc));
					}
					Thread.sleep(2000);
					
				}
				
//				for(int j=0;j<clickLoc;j++) {
//					Wcontrol.EnterKeyon(proposalPage.planDescription, Keys.DOWN);
//				}
//				Wcontrol.EnterKeyon(proposalPage.planDescription, Keys.ENTER);
				
			} else {
				base.getDriver().findElement(proposalPage.planDescription).sendKeys(Keys.ENTER);
			}

		}

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
//			Thread.sleep(13000);
			library.elementstable(proposalPage.autoUnderWritingYes);
			library.waitForClickableElement(proposalPage.autoUnderWritingYes);
		} else {
			library.elementstable(proposalPage.autoUnderWritingYes);
			library.waitForClickableElement(proposalPage.autoUnderWritingYes);
		}
//		Wcontrol.clickJSEon(proposalPage.autoUnderWritingYes);
//		Thread.sleep(2000);
		// ---cloud---
//		Thread.sleep(1000);
		UWStatus = "NO";
		defins.takeScreenShot("Screen Shot for the test");
		report.setPlanDesc(CustomerExceldata.TestDataInMap.get("Plan Descriptipn"));
		Wcontrol.scrollDownLong();
		library.elementstable(proposalPage.BasicNext);
		library.waitForClickableElement(proposalPage.BasicNext, 20);
		Thread.sleep(1000);
	}

	@Then("Select the Plan descriptionsss")
	public void select_plan_description() throws Throwable {

//		if (Wcontrol.VisibleElementCount(commonPage.animation) > 0) {
//			library.waitForInVisibilityOfElement(commonPage.animation);
//		}
//		proposalStep.invisiblelements();
		library.elementstable(proposalPage.planDescription);
		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("Future Invest")) {
			Wcontrol.sendkeysByAction(proposalPage.planDescription, "Future Invest");
		} else if (planDesc.equalsIgnoreCase("Plan19")) {
			Wcontrol.sendkeysByAction(proposalPage.planDescription, "Single Premium Deferred Annuity");
		} else if (planDesc.equalsIgnoreCase("Plan3")) {
			Wcontrol.sendkeysByAction(proposalPage.planDescription, "Whole Life Plan(Par)");
		} else if (planDesc.equalsIgnoreCase("D-TRS")) {
			Wcontrol.sendkeysByAction(proposalPage.planDescription, "Decreasing Term Assurance");
		} else if (planDesc.equalsIgnoreCase("Plan27")) {
			Wcontrol.sendkeysByAction(proposalPage.planDescription, "Joint Life Endowment Plan");
		} else if (planDesc.equalsIgnoreCase("Plan21")) {
			Wcontrol.sendkeysByAction(proposalPage.planDescription, "Single Premium Investmet Linked Product");
		}
//		proposalStep.invisiblelements();

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(proposalPage.autoUnderWritingYes);
			library.waitForClickableElement(proposalPage.autoUnderWritingYes);
		}
//		Wcontrol.clickJSEon(proposalPage.autoUnderWritingYes);
//		Thread.sleep(2000);
		// ---cloud---

		UWStatus = "NO";
		defins.takeScreenShot("Screen Shot for the test");
		report.setPlanDesc(CustomerExceldata.TestDataInMap.get("Plan Descriptipn"));

	}

	@Then("Select UW flag as {string}")
	public void Underwriting_Flag(String UWflag) throws Throwable {
		if (UWflag.equalsIgnoreCase("Yes")) {
			Wcontrol.scrollUPLong();
			Wcontrol.clickJSEon(proposalPage.autoUnderWritingYes);
		} else {
			Wcontrol.scrollUPLong();
			Wcontrol.clickJSEon(proposalPage.autoUnderWritingNo);
		}
		Wcontrol.scrollDownLong();
		report.setPlanDesc(CustomerExceldata.TestDataInMap.get("Plan Descriptipn"));
	}

	@Then("Select the Individual Id as {string} and Enter the Identity number")
	public void Proposal_for_No_IC(String noIC) throws Throwable {

		Thread.sleep(500);
		boolean val2 = base.getDriver().findElement(proposalPage.proposerNext).isDisplayed();
		if (val2 == false) {
			Wcontrol.clickJSEon(proposalPage.proposerParticularPanel);
			Thread.sleep(300);
		}

		Wcontrol.clearText(proposalPage.Identity);
		Wcontrol.sendkeysByAction(proposalPage.Identity, noIC);
		Wcontrol.clickJSEon(proposalPage.IDNumber);
		Wcontrol.sendkeysByAction(proposalPage.IDNumber, NoICValue);

	}

	@Then("Select the Individual Id and Enter the Identity number")
	public void Individual_id_and_identity_number() throws Throwable {
		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		WebElement IDNumber = null;

		Wcontrol.scrollUpMin();
		if (!planDesc.equalsIgnoreCase("D-TRS")) {

			Thread.sleep(500);
			boolean val2 = base.getDriver().findElement(proposalPage.proposerNext).isDisplayed();
			if (val2 == false) {
				Wcontrol.clickJSEon(proposalPage.proposerParticularPanel);
				Thread.sleep(300);
			}

			library.elementstable(proposalPage.Identity);
			library.waitForClickableElement(proposalPage.Identity, 30);
			library.waitForPresenceOfElement(proposalPage.Identity, 30);
			Thread.sleep(4000);
			Wcontrol.clearText(proposalPage.Identity);

			String IdentityType = CustomerExceldata.TestDataInMap.get("Identity");
			if (IdentityType.equalsIgnoreCase("passport")) {

				if (base.environemt.equalsIgnoreCase("ILIVE")) {
					library.elementstable(proposalPage.Identity);
					library.waitForClickableElement(proposalPage.Identity, 20);
					Thread.sleep(1500);
					Wcontrol.sendkeysByAction(proposalPage.Identity, IdentityType);
					Thread.sleep(1500);
					Wcontrol.ActionMoveToElement(registrationPage.options);
					Wcontrol.clickJSEon(registrationPage.options);
					library.waitForInVisibilityOfElement(commonPage.animation, 30);
				} else {
					library.elementstable(proposalPage.Identity);
					library.waitForClickableElement(proposalPage.Identity, 20);
					Wcontrol.sendkeysByAction(proposalPage.Identity, IdentityType);
					Thread.sleep(1500);
				}

			} else {

				if (base.environemt.equalsIgnoreCase("ILIVE")) {
					Thread.sleep(4000);
				}

				library.elementstable(proposalPage.Identity);
				library.waitForClickableElement(proposalPage.Identity, 20);
				Wcontrol.sendkeysByAction(proposalPage.Identity, CustomerExceldata.TestDataInMap.get("Identity"));
				report.setIdentity(CustomerExceldata.TestDataInMap.get("Identity"));

				if (base.environemt.equalsIgnoreCase("ILIVE")) {
					Thread.sleep(5000);
				} else {
					Thread.sleep(1500);
					library.elementstable(proposalPage.IDNumber);
					library.waitForClickableElement(proposalPage.IDNumber, 30);
					library.waitForVisibilityOfElement(proposalPage.IDNumber, 90);
					library.waitForPresenceOfElement(proposalPage.IDNumber, 60);
				}
			}

			String Identity = CustomerExceldata.TestDataInMap.get("Identity");
			library.waitForVisibilityOfElement(proposalPage.IDNumber, 90);
			library.waitForClickableElement(proposalPage.IDNumber, 50);
			if (planDesc.equalsIgnoreCase("Plan27") || Identity.equalsIgnoreCase("Passport")) {
				Wcontrol.clickJSEon(proposalPage.IDNumber);
//				IDNumber.sendKeys(Exceldata.TestDataInMap.get("Identity number"));
				Wcontrol.sendkeysByAction(proposalPage.IDNumber,
						CustomerExceldata.TestDataInMap.get("Identity number"));
				Thread.sleep(1000);
			} else if (planDesc.equalsIgnoreCase("System Generated Identification")) {
				Wcontrol.clickJSEon(proposalPage.IDNumber);
//				IDNumber.sendKeys(Exceldata.TestDataInMap.get("Identity number"));
				Wcontrol.sendkeysByAction(proposalPage.IDNumber, NoICValue);
				Thread.sleep(1000);
			}

			else {
				library.elementstable(proposalPage.IDNumber);
				library.waitForClickableElement(proposalPage.IDNumber, 20);

				Wcontrol.clickJSEon(proposalPage.IDNumber);
//			IDNumber.sendKeys(Exceldata.TestDataInMap.get("Identity number"));
				Wcontrol.sendkeysByAction(proposalPage.IDNumber, CustomerExceldata.TestDataInMap.get("FirstName"));

//			Wcontrol.clickJSEon(proposalPage.IDNumber);
//			Wcontrol.sendkeysByAction(proposalPage.IDNumber, Exceldata.TestDataInMap.get("FirstName"));
				library.elementstable(proposalPage.planDescOption);
				library.waitForClickableElement(proposalPage.planDescOption, 30);

//			String namesss = Wcontrol.GetAttributeValueon(
//					By.xpath("//*[contains(text(),'Name as per')]/ancestor::span/parent::div//input"), "value");
//			System.out.println(namesss);

				String err = Wcontrol.GetTexton(proposalPage.planDescOption).trim();
//				String srr = Wcontrol.GetAttributeValueon(proposalPage.IDNumber, "value");
				if (err.equalsIgnoreCase("No Data Found")) {
					Wcontrol.Click_and_ClearTextOn(proposalPage.Identity);
					Wcontrol.sendkeysByAction(proposalPage.Identity, CustomerExceldata.TestDataInMap.get("Identity"));
					Thread.sleep(1000);
					Wcontrol.clickJSEon(proposalPage.IDNumber);
					Wcontrol.sendkeysByAction(proposalPage.IDNumber,
							CustomerExceldata.TestDataInMap.get("Identity number"));
				} else {

					library.elementstable(proposalPage.IdentityOPtions);
					library.waitForClickableElement(proposalPage.IdentityOPtions, 50);
					Thread.sleep(1500);
					int identityOptions = Wcontrol.GetAllElements(proposalPage.IdentityOPtions).size();
//					System.out.println(identityOptions.size());
//					for (int k = 0; k < identityOptions.size(); k++) {
//						String n222 = identityOptions.get(k).getText().trim();
//						System.out.println(n222);
//					}

					String looc = null;
					for (int i = 0; i < identityOptions; i++) {
//						String NRIC = Wcontrol.GetTexton(identityOptions.get(i));

						String looc1 = "(//mat-option)[" + (i + 1) + "]";
						String NRIC = base.getDriver().findElement(By.xpath(looc1)).getText();
						String pattern = "\\(";
						String str2 = NRIC.replaceAll(pattern, "#").split("#")[0].trim();

						if (str2.equalsIgnoreCase(CustomerExceldata.TestDataInMap.get("Identity number"))) {
//							Wcontrol.ActionMoveToElementClcik(identityOptions.get(i));

							looc = "(//mat-option)[" + (i + 1) + "]";
							break;
						}
					}

					Wcontrol.ActionMoveToElementClcik(By.xpath(looc));

				}

			}
			String srr = Wcontrol.GetAttributeValueon(proposalPage.IDNumber, "value");
			if (srr.equalsIgnoreCase("")) {
				Wcontrol.Click_and_ClearTextOn(proposalPage.Identity);
				Wcontrol.sendkeysByAction(proposalPage.Identity, CustomerExceldata.TestDataInMap.get("Identity"));
				Thread.sleep(1000);
				Wcontrol.clickJSEon(proposalPage.IDNumber);
				Wcontrol.sendkeysByAction(proposalPage.IDNumber,
						CustomerExceldata.TestDataInMap.get("Identity number"));
			}
		}
	}
	@Then("Select the Proposer Relation")
	public void Select_the_Proposer_Relation() throws Throwable {
		Wcontrol.clickJSEon(proposalPage.La_Relation);
		Wcontrol.clearText(proposalPage.La_Relation);
		Wcontrol.sendkeysByAction(proposalPage.La_Relation, "GRAND DAUGHTER");
//		Wcontrol.EnterKeyon(proposalPage.La_Relation, Keys.ENTER);
	}

	@Then("Select the Individual Id and Enter the Identity number Smoke")
	public void Individual_id_and_identity_number_For_Smoke() throws Throwable {
		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		WebElement IDNumber = null;

		Wcontrol.scrollUpMin();
		if (!planDesc.equalsIgnoreCase("D-TRS")) {

			Thread.sleep(500);
			boolean val2 = base.getDriver().findElement(proposalPage.proposerNext).isDisplayed();
			if (val2 == false) {
				Wcontrol.clickJSEon(proposalPage.proposerParticularPanel);
				Thread.sleep(300);
			}

			library.elementstable(proposalPage.Identity);
			library.waitForClickableElement(proposalPage.Identity, 30);
			library.waitForPresenceOfElement(proposalPage.Identity, 30);
			Thread.sleep(4000);
			Wcontrol.clearText(proposalPage.Identity);

			String IdentityType = CustomerExceldata.TestDataInMap.get("Identity");
			if (IdentityType.equalsIgnoreCase("passport")) {

				if (base.environemt.equalsIgnoreCase("ILIVE")) {
					library.elementstable(proposalPage.Identity);
					library.waitForClickableElement(proposalPage.Identity, 20);
					Thread.sleep(1500);
					Wcontrol.sendkeysByAction(proposalPage.Identity, IdentityType);
					Thread.sleep(1500);
					Wcontrol.ActionMoveToElement(registrationPage.options);
					Wcontrol.clickJSEon(registrationPage.options);
					library.waitForInVisibilityOfElement(commonPage.animation, 30);
				} else {
					library.elementstable(proposalPage.Identity);
					library.waitForClickableElement(proposalPage.Identity, 20);
					Wcontrol.sendkeysByAction(proposalPage.Identity, IdentityType);
					Thread.sleep(1500);
				}

			} else {

				if (base.environemt.equalsIgnoreCase("ILIVE")) {
					Thread.sleep(4000);
				}

				library.elementstable(proposalPage.Identity);
				library.waitForClickableElement(proposalPage.Identity, 20);
				Wcontrol.sendkeysByAction(proposalPage.Identity, CustomerExceldata.TestDataInMap.get("Identity"));
				report.setIdentity(CustomerExceldata.TestDataInMap.get("Identity"));

				if (base.environemt.equalsIgnoreCase("ILIVE")) {
					Thread.sleep(5000);
				} else {
					Thread.sleep(1500);
					library.elementstable(proposalPage.IDNumber);
					library.waitForClickableElement(proposalPage.IDNumber, 30);
					library.waitForVisibilityOfElement(proposalPage.IDNumber, 90);
					library.waitForPresenceOfElement(proposalPage.IDNumber, 60);
				}
			}

			String Identity = CustomerExceldata.TestDataInMap.get("Identity");
			library.waitForVisibilityOfElement(proposalPage.IDNumber, 90);
			library.waitForClickableElement(proposalPage.IDNumber, 50);
			if (planDesc.equalsIgnoreCase("Plan27") || Identity.equalsIgnoreCase("Passport")) {
				Wcontrol.clickJSEon(proposalPage.IDNumber);
//				IDNumber.sendKeys(Exceldata.TestDataInMap.get("Identity number"));
				Wcontrol.sendkeysByAction(proposalPage.IDNumber, txtIdentityNumber);
				Thread.sleep(1000);
			} else if (planDesc.equalsIgnoreCase("System Generated Identification")) {
				Wcontrol.clickJSEon(proposalPage.IDNumber);
//				IDNumber.sendKeys(Exceldata.TestDataInMap.get("Identity number"));
				Wcontrol.sendkeysByAction(proposalPage.IDNumber, NoICValue);
				Thread.sleep(1000);
			}

			else {
				library.elementstable(proposalPage.IDNumber);
				library.waitForClickableElement(proposalPage.IDNumber, 20);

				Wcontrol.clickJSEon(proposalPage.IDNumber);
//			IDNumber.sendKeys(Exceldata.TestDataInMap.get("Identity number"));
				Wcontrol.sendkeysByAction(proposalPage.IDNumber, CustomerName);

//			Wcontrol.clickJSEon(proposalPage.IDNumber);
//			Wcontrol.sendkeysByAction(proposalPage.IDNumber, Exceldata.TestDataInMap.get("FirstName"));
				library.elementstable(proposalPage.planDescOption);
				library.waitForClickableElement(proposalPage.planDescOption, 30);

//			String namesss = Wcontrol.GetAttributeValueon(
//					By.xpath("//*[contains(text(),'Name as per')]/ancestor::span/parent::div//input"), "value");
//			System.out.println(namesss);

				String err = Wcontrol.GetTexton(proposalPage.planDescOption).trim();
//				String srr = Wcontrol.GetAttributeValueon(proposalPage.IDNumber, "value");
				if (err.equalsIgnoreCase("No Data Found")) {
					Wcontrol.Click_and_ClearTextOn(proposalPage.Identity);
					Wcontrol.sendkeysByAction(proposalPage.Identity, CustomerExceldata.TestDataInMap.get("Identity"));
					Thread.sleep(1000);
					Wcontrol.clickJSEon(proposalPage.IDNumber);
					Wcontrol.sendkeysByAction(proposalPage.IDNumber, txtIdentityNumber);
				} else {

					library.elementstable(proposalPage.IdentityOPtions);
					library.waitForClickableElement(proposalPage.IdentityOPtions, 50);
					Thread.sleep(1500);
					int identityOptions = Wcontrol.GetAllElements(proposalPage.IdentityOPtions).size();
//					System.out.println(identityOptions.size());
//					for (int k = 0; k < identityOptions.size(); k++) {
//						String n222 = identityOptions.get(k).getText().trim();
//						System.out.println(n222);
//					}

					String looc = null;
					for (int i = 0; i < identityOptions; i++) {
//						String NRIC = Wcontrol.GetTexton(identityOptions.get(i));

						String looc1 = "(//mat-option)[" + (i + 1) + "]";
						String NRIC = base.getDriver().findElement(By.xpath(looc1)).getText();
						String pattern = "\\(";
						String str2 = NRIC.replaceAll(pattern, "#").split("#")[0].trim();

						if (str2.equalsIgnoreCase(txtIdentityNumber)) {
//							Wcontrol.ActionMoveToElementClcik(identityOptions.get(i));

							looc = "(//mat-option)[" + (i + 1) + "]";
							break;
						}
					}

					Wcontrol.ActionMoveToElementClcik(By.xpath(looc));

				}

			}
			String srr = Wcontrol.GetAttributeValueon(proposalPage.IDNumber, "value");
			if (srr.equalsIgnoreCase("")) {
				Wcontrol.Click_and_ClearTextOn(proposalPage.Identity);
				Wcontrol.sendkeysByAction(proposalPage.Identity, CustomerExceldata.TestDataInMap.get("Identity"));
				Thread.sleep(1000);
				Wcontrol.clickJSEon(proposalPage.IDNumber);
				Wcontrol.sendkeysByAction(proposalPage.IDNumber, txtIdentityNumber);
			}
		}
	}

	@Then("Select the Company Id and Enter the Payer ReletionShip")
	public void Company_id_and_Payer_ReletionShip() throws Throwable {

		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("D-TRS")) {

			Thread.sleep(1000);
			boolean val2 = base.getDriver().findElement(proposalPage.proposerNext).isDisplayed();
			if (val2 == false) {
				Wcontrol.clickJSEon(proposalPage.proposerParticularPanel);
				Thread.sleep(700);
			}

			Thread.sleep(1000);
//			Wcontrol.click_and_Select(proposalPage.proposerType, proposalPage.proposerTypeCompany);
			Wcontrol.clickJSEon(proposalPage.proposerType);
			Wcontrol.clickJSEon(proposalPage.proposerType);

			if (base.environemt.equalsIgnoreCase("ILIVE")) {
				Thread.sleep(4000);
			} else {
				library.elementstable(proposalPage.planDescOption);
				library.waitForClickableElement(proposalPage.planDescOption);
				library.elementstable(proposalPage.proposerTypeCompany);
				library.waitForClickableElement(proposalPage.proposerTypeCompany);
			}

			Wcontrol.ActionMoveToElementClcik(proposalPage.proposerTypeCompany);

			if (base.environemt.equalsIgnoreCase("ILIVE")) {
				Thread.sleep(2000);
			} else {
				library.elementstable(proposalPage.proposerCompanyName);
				library.waitForClickableElement(proposalPage.proposerCompanyName, 50);
				Thread.sleep(500);
			}
			Wcontrol.clickJSEon(proposalPage.proposerCompanyName);
			Wcontrol.clickJSEon(proposalPage.proposerCompanyName);

			if (base.environemt.equalsIgnoreCase("ILIVE")) {
				Thread.sleep(6000);
			} else {
//				library.elementstable(proposalPage.planDescOption);
//				library.waitForClickableElement(proposalPage.planDescOption);
			}

			Wcontrol.sendkeysByAction(proposalPage.proposerCompanyName, "PEGASUS");
			if (base.environemt.equalsIgnoreCase("ILIVE")) {
				Thread.sleep(4000);
			} else {
				library.elementstable(proposalPage.planDescOption);
				library.waitForClickableElement(proposalPage.planDescOption);
			}
			Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);
			if (base.environemt.equalsIgnoreCase("ILIVE")) {
				Thread.sleep(4000);
			} else {
				library.elementstable(proposalPage.proposerRelation);
				library.waitForClickableElement(proposalPage.proposerRelation);
			}
			Wcontrol.clearText(proposalPage.proposerRelation);
			Wcontrol.sendkeysByAction(proposalPage.proposerRelation, "CREDITOR");

		}
	}

	@And("Select the Agent Name")
	public void Agent_Name_Selection() throws Throwable {

		Thread.sleep(1000);
		Wcontrol.scrollDownLong();

		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		if (!planDesc.equalsIgnoreCase("D-TRS")) {
//			Thread.sleep(800);
			library.elementstable(proposalPage.annualIncome);
			library.waitForClickableElement(proposalPage.annualIncome, 30);
			Wcontrol.clickJSEon(proposalPage.annualIncome);
			Wcontrol.sendkeysByAction(proposalPage.annualIncome, CustomerExceldata.TestDataInMap.get("AnnualIncome"));
			report.setIdentityNumber(CustomerExceldata.TestDataInMap.get("Identity number"));
		}

		customerAge = Wcontrol.GetAttributeValueon(proposalPage.customerAge, "value");
		System.out.println("Age is : " + customerAge);
//		Wcontrol.clickJSEon(proposalPage.La_Relation);
//		base.getDriver().findElement(proposalPage.La_Relation).sendKeys(Keys.TAB);
		library.elementstable(proposalPage.AgentName);
		Wcontrol.scrollToView(proposalPage.AgentName);
		Wcontrol.clickJSEon(proposalPage.AgentName);
		Thread.sleep(500);
		Wcontrol.sendkeysByAction(proposalPage.AgentName, CustomerExceldata.TestDataInMap.get("Agent Name"));
//		base.getDriver().findElement(proposalPage.AgentName).sendKeys(Keys.ENTER);
		Wcontrol.clickJSEon(proposalPage.AgentName);
		Wcontrol.EnterKeyon(proposalPage.AgentName, Keys.ENTER);
		Wcontrol.EnterKeyon(proposalPage.AgentName, Keys.ENTER);
		Wcontrol.EnterKeyon(proposalPage.AgentName, Keys.ENTER);
		Wcontrol.EnterKeyon(proposalPage.AgentName, Keys.ENTER);
		Wcontrol.EnterKeyon(proposalPage.AgentName, Keys.ENTER);

		report.setAgentName(CustomerExceldata.TestDataInMap.get("Agent Name"));
		Thread.sleep(1500);
		defins.takeScreenShot("Screen Shot for the test");
		Wcontrol.scrollDownLong();

	}

	@Then("Select the Currency and Enter the Sum Assured")
	public void Currency_and_Sum_assured_Selection() throws Throwable {

		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		Wcontrol.clearText(proposalPage.currency);
		if (!planDesc.equalsIgnoreCase("D-TRS") && !planDesc.equalsIgnoreCase("Plan21")) {
			library.elementstable(proposalPage.currency);
			library.waitForClickableElement(proposalPage.currency, 30);
			Wcontrol.sendkeysByAction(proposalPage.currency, CustomerExceldata.TestDataInMap.get("Currency"));
			Thread.sleep(1200);
			report.setCurrency(CustomerExceldata.TestDataInMap.get("Currency"));
			library.elementstable(proposalPage.initialSA);
			library.waitForClickableElement(proposalPage.initialSA, 50);
			Wcontrol.sendkeysByAction(proposalPage.initialSA, CustomerExceldata.TestDataInMap.get("InitalSumAssured"));
			report.setInitialSumAssured(CustomerExceldata.TestDataInMap.get("InitalSumAssured"));
		} else if (planDesc.equalsIgnoreCase("D-TRS") || planDesc.equalsIgnoreCase("Plan21")) {
			library.elementstable(proposalPage.currency);
			library.waitForClickableElement(proposalPage.currency, 30);
			Wcontrol.sendkeysByAction(proposalPage.currency, CustomerExceldata.TestDataInMap.get("Currency"));
			Thread.sleep(1200);
			report.setCurrency(CustomerExceldata.TestDataInMap.get("Currency"));
		}

	}

	@Then("Enter the policy Terms and change the Frequency")
	public void Premium_terms_and_change_the_frequency() throws Throwable {

		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		String freq = CustomerExceldata.TestDataInMap.get("Frequency");
		library.elementstable(proposalPage.policyTerms);
		library.waitForClickableElement(proposalPage.policyTerms, 60);
		if (planDesc.equalsIgnoreCase("Future Invest") || planDesc.equalsIgnoreCase("RSP")) {
			Wcontrol.sendkeysByAction(proposalPage.policyTerms, CustomerExceldata.TestDataInMap.get("PolicyTerms"));
			Frequency_Select(freq);

		} else if (planDesc.equalsIgnoreCase("Plan11") || planDesc.equalsIgnoreCase("Plan27")) {
			Wcontrol.sendkeysByAction(proposalPage.policyTerms, CustomerExceldata.TestDataInMap.get("PolicyTerms"));
			Frequency_Select(freq);
		} else if (planDesc.equalsIgnoreCase("D-TRS") || planDesc.equalsIgnoreCase("Plan19")) {
			Thread.sleep(1000);
			Wcontrol.sendkeysByAction(proposalPage.policyTerms, CustomerExceldata.TestDataInMap.get("PolicyTerms"));
			Frequency_Select(freq);
		} else if (planDesc.equalsIgnoreCase("Plan3") || planDesc.equalsIgnoreCase("PLAN21")) {
			Frequency_Select(freq);
		}

		report.setPolicyTerms(CustomerExceldata.TestDataInMap.get("PolicyTerms"));
		report.setFrequency(CustomerExceldata.TestDataInMap.get("Frequency"));
	}

	public void Frequency_Select(String expectedfrequency) throws Throwable {
		Thread.sleep(500);
		Wcontrol.clickJSEon(proposalPage.frequency);
		Wcontrol.clickJSEon(proposalPage.frequency);
		Thread.sleep(1000);
//		Wcontrol.clickJSEon(proposalPage.frequency);
		List<WebElement> freqOptions = Wcontrol.GetAllElements(By.xpath("//mat-option"));
		String loc = null;
		for (int i = 0; i < freqOptions.size(); i++) {

			String nameLoc = "(//mat-option)" + "[" + (i + 1) + "]";
			String actualValue = Wcontrol.GetTexton(By.xpath(nameLoc)).trim();
			if (actualValue.equalsIgnoreCase(expectedfrequency)) {
//				Wcontrol.click(freqOptions.get(i));
//				Wcontrol.clickJSEon(freqOptions.get(i));
				loc = "(//mat-option)" + "[" + (i + 1) + "]";
				break;
			}
		}

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(1000);
		} else {
			library.waitForVisibilityOfElement(By.xpath(loc), 20);
			library.elementstable(By.xpath(loc));
			library.waitForClickableElement(By.xpath(loc), 20);
		}
		Wcontrol.clickJSEon(By.xpath(loc));
	}

	@And("Enter the User Premium")
	public void user_premium_Selection() throws Throwable {
		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("Future Invest") || planDesc.equalsIgnoreCase("Plan19")
				|| planDesc.equalsIgnoreCase("Plan21") || planDesc.equalsIgnoreCase("RSP")) {
			Wcontrol.EnterValueon(proposalPage.userPremium, CustomerExceldata.TestDataInMap.get("UserPremium"));
			report.setUserPremium(CustomerExceldata.TestDataInMap.get("UserPremium"));
		}
	}

	@And("Enter the Premium pattern and Enter the Sum Assuren Pattern")
	public void Premium_pattern_and_Sum_assuren_pattern_Selection() throws Throwable {

		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("Future Invest")) {
			Wcontrol.sendkeysByAction(proposalPage.premiumPattern,
					CustomerExceldata.TestDataInMap.get("PremiumPattern"));
			Wcontrol.sendkeysByAction(proposalPage.SAPattern, CustomerExceldata.TestDataInMap.get("SAPattern"));
			report.setPremiumPattern(CustomerExceldata.TestDataInMap.get("PremiumPattern"));
			report.setSumAssuredPattern(CustomerExceldata.TestDataInMap.get("SAPattern"));
		} else if (planDesc.equalsIgnoreCase("RSP")) {
			Wcontrol.sendkeysByAction(proposalPage.SAPattern, CustomerExceldata.TestDataInMap.get("SAPattern"));
			report.setSumAssuredPattern(CustomerExceldata.TestDataInMap.get("SAPattern"));
		} 
//		else if (planDesc.equalsIgnoreCase("plan3")) {
//			Thread.sleep(1000);
////			Wcontrol.click_and_Select(proposalPage.premiumPattern, proposalPage.opt);
////			Wcontrol.click_and_Select(proposalPage.SAPattern, proposalPage.opt);
//			Wcontrol.clickJSEon(proposalPage.SAPattern);
//			String click_loc = null;
//			List<WebElement> opts = base.getDriver().findElements(By.xpath("//mat-option"));
//			for (int i = 0; i < opts.size(); i++) {
//				String name_loc = "(//mat-option)[" + (i + 1) + "]";
//
//				String name = base.getDriver().findElement(By.xpath(name_loc)).getText();
//				if (name.equalsIgnoreCase("Exclusive")) {
//					click_loc = "(//mat-option)[" + (i + 1) + "]";
//					break;
//				}
//
//			}
//			Wcontrol.clickJSEon(By.xpath(click_loc));
//
//		}
		Wcontrol.clickJSEon(proposalPage.SAPattern);
		Thread.sleep(1000);
//		Wcontrol.clickJSEon(proposalPage.planDescOption);
//		Wcontrol.clickJSEon(proposalPage.SAPattern);
		Wcontrol.EnterKeyon(proposalPage.SAPattern, Keys.ENTER);
		defins.takeScreenShot("Screen Shot for the test");
		Wcontrol.scrollDownLong();

	}

	@Then("Select the Commencement Date as {string}")
	public void CommencementDateOption(String commencementOption) throws Throwable {
		Wcontrol.scrollToView(proposalPage.commencementDateOption);
		Wcontrol.click_and_Select(proposalPage.commencementDateOption, proposalPage.MDTAoption);
	}

	@Then("Change the Commencement date")
	public void Change_Commencement_date() throws Throwable {
		Wcontrol.click_and_Select(proposalPage.commencementDateOption, proposalPage.opt);
		Wcontrol.clickJSEon(proposalPage.commencementDate);
		for (int i = 0; i < 10; i++) {
			Wcontrol.EnterKeyon(proposalPage.commencementDate, Keys.BACK_SPACE);
		}
		Wcontrol.sendkeysByAction(proposalPage.commencementDate, get_from_date());
	}

	@Then("Enter the Staff Policy Details")
	public void Staff_Policy_Details() throws Throwable {
		Thread.sleep(1000);
		library.waitForClickableElement(proposalPage.staffPolicyOption);
		Wcontrol.click_and_Select(proposalPage.staffPolicyOption, proposalPage.planDescOption);
		Wcontrol.click_and_Select(proposalPage.staffGroup, proposalPage.planDescOption);
		Wcontrol.sendkeysByAction(proposalPage.staffCompany, "Balakrishnan Agency");
		Wcontrol.sendkeysByAction(proposalPage.employeeID, Generate_Random_Numbers());
	}

	@Then("goto the Loan Tab")
	public void goto_the_Loan_Tab() throws Throwable {
		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("D-TRS")) {

			Wcontrol.scrollToView(proposalPage.BankAccnumber);

			if (base.environemt.equalsIgnoreCase("ILIVE")) {
				Thread.sleep(1500);
			}
			Wcontrol.scrollUpMin();
			Wcontrol.clickJSEon(proposalPage.comapanyName);
			Wcontrol.sendkeysByAction(proposalPage.comapanyName, "PEGASUS");
			Thread.sleep(500);
			Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);

			Random random = new Random();

			int x = random.nextInt(900000000) + 100000000;
			int y = random.nextInt(9000) + 1000;

			String accountNumber = Integer.toString(x) + Integer.toString(y);

			int ref = random.nextInt(900) + 100;
			String referenceNumber = Integer.toString(ref);

			Wcontrol.sendkeysByAction(proposalPage.BankAccnumber, accountNumber);
			Wcontrol.sendkeysByAction(proposalPage.loanRefNumber, referenceNumber);
			Wcontrol.scrollDownMin();
			Wcontrol.sendkeysByAction(proposalPage.loanAmount, "100000");
			Wcontrol.sendkeysByAction(proposalPage.repayTerm, "19");
			Wcontrol.sendkeysByAction(proposalPage.defermentPeriod, "1");
			defins.takeScreenShot("Screen Shot for the test");
			Wcontrol.scrollDownLong();
//			Wcontrol.scrollToView(proposalPage.serviceCommission);
			Wcontrol.ActionMoveToElement(proposalPage.serviceCommission);
			Wcontrol.clickJSEon(proposalPage.serviceCommission);
			Wcontrol.ActionMoveToElementClcik(proposalPage.serviceCommisionOptions);
			Wcontrol.clickJSEon(proposalPage.finance);
			Thread.sleep(500);
			Wcontrol.ActionMoveToElementClcik(By.xpath("(//mat-option)[2]"));

			defins.takeScreenShot("Screen Shot for the test");
			Wcontrol.scrollToView(proposalPage.loanNext);
			Wcontrol.clickJSEon(proposalPage.loanNext);
		}
	}

	@And("goto the Payer Page")
	public void goto_the_Payer_Tab() throws Throwable {
		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("D-TRS")) {
			Thread.sleep(1500);
			Wcontrol.clickJSEon(proposalPage.payerType);
			Wcontrol.ActionMoveToElementClcik(proposalPage.payerOptions);
			Thread.sleep(500);
			defins.takeScreenShot("Screen Shot for the test");

		}
	}

	@Then("Enter the Reference number")
	public void Enter_Reference_number_and_click_on_Search_Button() throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(registrationPage.createCustomer);
			library.waitForClickableElement(registrationPage.createCustomer);
		}
		Wcontrol.EnterValueon(registrationPage.refNo, proposalStep.referenceNumber);
		Wcontrol.clickJSEon(registrationPage.Search);

	}

	@Then("Click on the edit icon of the customer")
	public void Edit_the_Customer_Details() throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(4000);
		} else {
			library.elementstable(registrationPage.customerEdit);
			library.waitForClickableElement(registrationPage.customerEdit);
		}
		Wcontrol.clickJSEon(registrationPage.customerEdit);
		library.elementstable(registrationPage.middleName);
		library.waitForVisibilityOfElement(registrationPage.middleName);
		Wcontrol.Click_and_ClearTextOn(registrationPage.middleName);
		Wcontrol.sendkeysByAction(registrationPage.middleName, "kumar");
	}

	@Then("Click on the edit icon of the customer and get the details and click on ok button")
	public void Edit_for_issued_Policy() throws Throwable {
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(registrationPage.customerEdit);
			library.waitForClickableElement(registrationPage.customerEdit);
		}
		String expectedWarning = "Modifications are restricted for this customer. Please go through Policy Servicing.";
		Wcontrol.clickJSEon(registrationPage.customerEdit);
		String actualWarning = Wcontrol.GetTexton(registrationPage.dialogboxDetails).trim();
		System.err.println(actualWarning);
		Assert.assertEquals(expectedWarning, actualWarning);
		library.waitForClickableElement(By.xpath("//*[contains(text(),'Ok')]"));
		Wcontrol.clickJSEon(By.xpath("//*[contains(text(),'Ok')]"));
	}

	@Then("Select the short Payment method")
	public void Short_Payment_method_Selection() throws Throwable {
		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		String loc = null;
		library.elementstable(proposalPage.shortPayment);
		library.waitForClickableElement(proposalPage.shortPayment);
		Wcontrol.scrollDownLong();
		if (!planDesc.equalsIgnoreCase("D-TRS") && !planDesc.equalsIgnoreCase("Plan19")) {

			Wcontrol.clickJSEon(proposalPage.shortPayment);
			library.waitForPresenceOfElement(proposalPage.planDescOption, 30);
			List<WebElement> SPoptions = Wcontrol.GetAllElements(By.xpath("//mat-option"));
//			Thread.sleep(1000);
			for (int i = 0; i < SPoptions.size(); i++) {
				String n1 = Wcontrol.GetTexton(SPoptions.get(i)).trim();
				if (n1.equalsIgnoreCase("Premium (PD)") || n1.equalsIgnoreCase("Premium(PD)")) {
//					Wcontrol.ActionMoveToElementClcik(SPoptions.get(i));
//					Wcontrol.clickJSEon(SPoptions.get(i));
//					loc = "(//mat-option)" + "[" + (i + 1) + "]";
					Wcontrol.EnterKeyon(proposalPage.shortPayment, Keys.ENTER);
					break;
				} else {
					Wcontrol.EnterKeyon(proposalPage.shortPayment, Keys.DOWN);
				}
			}
//			Wcontrol.ActionMoveToElementClcik(By.xpath(loc));
			defins.takeScreenShot("Screen Shot for the test");
		}

	}

	public void Annuity_Details_for_Plan19() throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(By.xpath("//*[contains(text(),'Pop Out')]"));
			library.waitForClickableElement(By.xpath("//*[contains(text(),'Pop Out')]"));
		}
		Wcontrol.clickJSEon(proposalPage.LifeTab);
		library.elementstable(proposalPage.LifeAssuredView);
		library.waitForClickableElement(proposalPage.LifeAssuredView);
		Wcontrol.clickJSEon(proposalPage.LifeAssuredView);
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			Thread.sleep(1000);
			library.elementstable(proposalPage.Save);
			library.waitForClickableElement(proposalPage.Save);
		}
//		Wcontrol.scrollToView(proposalPage.annuityDetails);
		Wcontrol.scrollDownMin();
		Wcontrol.scrollDownMin();
		Wcontrol.clickJSEon(proposalPage.annuityDetails);
		Wcontrol.scrollUpMin();
		Wcontrol.click_and_Select(proposalPage.annuityType, proposalPage.opt);
		Wcontrol.sendkeysByAction(proposalPage.guaranteePeriod, CustomerExceldata.TestDataInMap.get("Guarantee Period"));
		Wcontrol.click_and_Select(proposalPage.pensionFrequency, proposalPage.planDescOption);
		Wcontrol.clickJSEon(proposalPage.annuityNext);

	}

	public void Validate_Premium_in_Underwriting_Dashboard() throws Throwable {

		ExtentReports extent = new ExtentReports();
		ExtentTest test = extent.createTest("Evergreen");

		library.elementstable(underWritingPage.UWEnquiry);
		library.waitForClickableElement(underWritingPage.UWEnquiry, 30);
		Wcontrol.clickJSEon(underWritingPage.UWEnquiry);
		Wcontrol.scrollDownMin();
		By premiumPath = By.xpath(
				"(//*[contains(text(),'Policy Premium')]/parent::div//*[contains(text(),'Gross Premium')]/ancestor::table//tbody//tr)[1]//td[7]");
		String Premium = Wcontrol.GetTexton(premiumPath).trim();
		String actualPremium = Get_The_Premium_Value();
		String expectedPre = Premium.replaceAll(",", "");
		double doubleValue = Double.parseDouble(expectedPre);
		int RoundValue = (int) Math.round(doubleValue);
		int RoundedAmount = (int) Math.round(RoundValue);
		String expectedPremium = Integer.toString(RoundedAmount);

		Assert.assertEquals(actualPremium, expectedPremium);
		if (actualPremium.equals(expectedPremium)) {
			System.out.println("Premium is Equal...............");
			Allure.addAttachment("Premium Status", "Premium is Equal.........");
		} else {
			System.out.println("Premium is not Equal............");
			Allure.addAttachment("Premium Status", "Premium is not Equal.........");
		}
		Wcontrol.scrollUPLong();
	}

//	@Then("Validate Premium in Underwriting Dashboard")
//	public void Validate_Premium_in_Underwriting_Dashboard() throws Throwable {
//
//		By Proposer_Policy = By.xpath("//*[contains(text(),'Proposer / Policy')]");
//		Wcontrol.clickJSEon(Proposer_Policy);
//		if (base.environemt.equalsIgnoreCase("ILIVE")) {
//			library.waitForInVisibilityOfElement(commonPage.animation);
//		} else {
//			Thread.sleep(1000);
//		}
//		Wcontrol.clickJSEon(By.xpath("//*[contains(text(),'Policy Particulars')]"));
//		Wcontrol.scrollDownLong();
//		By modalPremium = By.xpath("//*[contains(text(),'Modal Premium')]/ancestor::span/parent::div//input");
//		String ModalPremium = Wcontrol.GetAttributeValueon(modalPremium, "value").trim();
//		String BasePlanPremium = Get_The_Premium_Value();
//		String RiderPremium = Get_The_Rider_Premium_Value();
//
//		int TotalPremium = Integer.parseInt(BasePlanPremium) + Integer.parseInt(RiderPremium);
//
//		String expectedPre = ModalPremium.replaceAll(",", "");
//
//		double doubleValue = Double.parseDouble(expectedPre);
//		int expectedPremium = (int) Math.round(doubleValue);
////		String expectedPremium = Integer.toString(RoundedAmount_One);
//
//		if (TotalPremium == expectedPremium) {
//
//		} else {
//			Wcontrol.scrollUPLong();
//			Wcontrol.clickJSEon(proposalPage.LifeTab);
//			if (base.environemt.equalsIgnoreCase("ILIVE")) {
//				library.waitForInVisibilityOfElement(commonPage.animation);
//			} else {
//				Thread.sleep(1000);
//			}
//			Wcontrol.clickJSEon(proposalPage.LifeAssuredView);
//			Wcontrol.scrollDownMin();
//			Wcontrol.clickJSEon(proposalPage.BasePlan);
//			
//		}
//	}


	@Then("Validate the Fields in Life Tab")
	public void Validate_Life_Tab_Fields() throws Throwable {

		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("D-TRS")) {
//			Wcontrol.clickJSEon(proposalPage.LAEdit);
			Wcontrol.clickJSEon(proposalPage.LAEdit);
			if(base.environemt.equalsIgnoreCase("ILIVE")) {
				Thread.sleep(4000);
			} else {
				Thread.sleep(2500);
			}

			By saveBtn = By.xpath(
					"//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//*[contains(text(),'Save')]/parent::button");
//			By saveBtn = By.xpath("//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//mat-icon[text()='check_circle'])[1]");
			boolean value = base.getDriver().findElement(saveBtn).isDisplayed();

			System.out.println(value);
			if (value == true) {

				By LaRelation = By.xpath(
						"//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//*[contains(text(),'Relationship with Proposer')]/parent::label/parent::span/parent::div//input");
				By LaIdentityType = By.xpath(
						"//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//*[contains(text(),'Identity Type')]/parent::label/parent::span/parent::div//input");
				By LaIdentityNo = By.xpath(
						"//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//*[contains(text(),'Identity No')]/parent::label/parent::span/parent::div//input");

				Wcontrol.clearText(LaRelation);
				Wcontrol.sendkeysByAction(LaRelation, "DEBIT");
				library.elementstable(proposalPage.planDescOption);
				Wcontrol.clickJSEon(proposalPage.planDescOption);
				Wcontrol.EnterValueon(LaIdentityType, CustomerExceldata.TestDataInMap.get("Identity"));
				if (base.environemt.equalsIgnoreCase("ILIVE")) {
					Thread.sleep(4000);
				} else {
					library.elementstable(LaIdentityNo);
					library.waitForClickableElement(LaIdentityNo);
					Thread.sleep(500);
				}
				
				String valType = CustomerExceldata.TestDataInMap.get("ValidationType");
				if(valType.equalsIgnoreCase("Term-Age")) {
					Wcontrol.EnterValueon(LaIdentityNo, CustomerName);
					Wcontrol.clickJSEon(proposalPage.planDescOption);
				} else {
					Wcontrol.EnterValueon(LaIdentityNo, CustomerExceldata.TestDataInMap.get("Identity number"));
					Thread.sleep(1000);
				}
				

				if (base.environemt.equalsIgnoreCase("ILIVE")) {
					Thread.sleep(4000);
				} else {
					Thread.sleep(500);
				}
				Wcontrol.clickJSEon(saveBtn);

			} else {
				library.elementstable(proposalPage.LifeRelation);
				library.waitForClickableElement(proposalPage.LifeRelation, 30);
				Wcontrol.clickJSEon(proposalPage.LifeRelation);
				Wcontrol.clearText(proposalPage.LifeRelation);
				Wcontrol.sendkeysByAction(proposalPage.LifeRelation, "DEBITOR");
//				Wcontrol.clearText(proposalPage.LifeRelation);
//				Wcontrol.sendkeysByAction(proposalPage.LifeRelation, "DEBITOR");
				for (int i = 0; i < Integer.MAX_VALUE; i++) {
					String a = Wcontrol.GetAttributeValueon(proposalPage.LifeRelation, "value");
					if (a != null) {
						break;
					} else {
						Wcontrol.clearText(proposalPage.LifeRelation);
						Wcontrol.EnterValueon(proposalPage.LifeRelation, "DEBITOR");
					}
				}

				Wcontrol.clickJSEon(proposalPage.LifeIdentity);
				Wcontrol.sendkeysByAction(proposalPage.LifeIdentity, CustomerExceldata.TestDataInMap.get("Identity"));

				if (base.environemt.equalsIgnoreCase("ILIVE")) {
					Thread.sleep(3000);
				} else {
					library.elementstable(proposalPage.LifeIdentityNumber);
					library.waitForClickableElement(proposalPage.LifeIdentityNumber, 30);
					Thread.sleep(1000);
				}

				Wcontrol.clickJSEon(proposalPage.LifeIdentityNumber);
				Wcontrol.sendkeysByAction(proposalPage.LifeIdentityNumber,
						CustomerExceldata.TestDataInMap.get("Identity number"));

				if (base.environemt.equalsIgnoreCase("ILIVE")) {
					Thread.sleep(4000);
				} else {
					library.elementstable(proposalPage.tick1);
					library.waitForClickableElement(proposalPage.tick1, 30);
				}

				Wcontrol.clickJSEon(proposalPage.tick1);
			}

			Wcontrol.clickJSEon(proposalPage.LifeAssuredView);

			if (base.environemt.equalsIgnoreCase("ILIVE")) {
				Thread.sleep(3000);
			} else {
				library.elementstable(proposalPage.Save);
				library.waitForClickableElement(proposalPage.Save);
			}
			Wcontrol.clickJSEon(proposalPage.Save);
			DtrsAge = Wcontrol.GetTexton(proposalPage.DTRSAGE);

		} else if (planDesc.equalsIgnoreCase("Plan27")) {
			Thread.sleep(1500);
			Wcontrol.clickJSEon(proposalPage.AddLA);
			Thread.sleep(1000);

			By saveBtn = By.xpath(
					"//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//*[contains(text(),'Save')]");
			boolean value = base.getDriver().findElement(saveBtn).isDisplayed();
//			System.out.println(value);
			if (value == true) {

				By LaRelation = By.xpath(
						"//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//*[contains(text(),'Relationship with Proposer')]/parent::label/parent::span/parent::div//input");
				By LaIdentityType = By.xpath(
						"//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//*[contains(text(),'Identity Type')]/parent::label/parent::span/parent::div//input");
				By LaIdentityNo = By.xpath(
						"//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//*[contains(text(),'Identity No')]/parent::label/parent::span/parent::div//input");

				Wcontrol.clearText(LaRelation);
				Wcontrol.sendkeysByAction(LaRelation, CustomerExceldata.TestDataInMap.get("LARelation"));
//				List<WebElement> opts = Wcontrol.GetAllElements(proposalPage.IdentityOPtions);
//				String loc = null;
//				for(int i=0;i<opts.size();i++) {
//					String loc1 = "//mat-option["+(i+1)+"]";
//					String name = Wcontrol.GetTexton(By.xpath(loc1)).trim();
//					if(name.equalsIgnoreCase(CustomerExceldata.TestDataInMap.get("LARelation"))) {
//						loc = "//mat-option["+(i+1)+"]";
//					}
//				}
//				Wcontrol.clickJSEon(By.xpath(loc));
				Thread.sleep(1000);
				Wcontrol.clickJSEon(By.xpath("//mat-option[2]"));

				Wcontrol.sendkeysByAction(LaIdentityType, CustomerExceldata.TestDataInMap.get("AnotherLAIdentity"));
				library.elementstable(LaIdentityNo);
				library.waitForClickableElement(LaIdentityNo);
				Thread.sleep(1000);
				Wcontrol.sendkeysByAction(LaIdentityNo, CustomerExceldata.TestDataInMap.get("AnotherLAIdentityNumber"));
				Thread.sleep(1000);
				Wcontrol.clickJSEon(saveBtn);
			} else {

				Wcontrol.clickJSEon(proposalPage.LifeRelation);
				Wcontrol.clearText(proposalPage.LifeRelation);
				Wcontrol.sendkeysByAction(proposalPage.LifeRelation, CustomerExceldata.TestDataInMap.get("LARelation"));
				Thread.sleep(1000);
//				List<WebElement> opts = Wcontrol.GetAllElements(proposalPage.IdentityOPtions);
//				String loc = null;
//				for(int i=0;i<opts.size();i++) {
//					String loc1 = "//mat-option["+(i+1)+"]";
//					String name = Wcontrol.GetTexton(By.xpath(loc1)).trim();
//					if(name.equalsIgnoreCase(CustomerExceldata.TestDataInMap.get("LARelation"))) {
//						loc = "//mat-option["+(i+1)+"]";
//					}
//				}
//				Wcontrol.clickJSEon(By.xpath(loc));
				Wcontrol.clickJSEon(By.xpath("//mat-option[2]"));
				Wcontrol.clickJSEon(proposalPage.LifeIdentity);
				Wcontrol.sendkeysByAction(proposalPage.LifeIdentity,
						CustomerExceldata.TestDataInMap.get("AnotherLAIdentity"));
//				Wcontrol.ActionMoveToElementClcik(proposalPage.freqOptionYearly);

				if (base.environemt.equalsIgnoreCase("ILIVE")) {
					Thread.sleep(3000);
				} else {
					library.elementstable(proposalPage.LifeIdentityNumber);
					library.waitForClickableElement(proposalPage.LifeIdentityNumber, 30);
				}

				Wcontrol.clickJSEon(proposalPage.LifeIdentityNumber);
				Wcontrol.sendkeysByAction(proposalPage.LifeIdentityNumber,
						CustomerExceldata.TestDataInMap.get("AnotherLAIdentityNumber"));

				if (base.environemt.equalsIgnoreCase("ILIVE")) {
					Thread.sleep(4000);
				} else {
					library.elementstable(proposalPage.tick2);
					library.waitForClickableElement(proposalPage.tick2, 30);
				}

				Wcontrol.clickJSEon(proposalPage.tick2);
			}

			library.elementstable(proposalPage.LifeAssuredView1);
			library.waitForClickableElement(proposalPage.LifeAssuredView1, 20);
			Thread.sleep(500);
			Wcontrol.clickJSEon(proposalPage.LifeAssuredView1);
			library.elementstable(proposalPage.Save);
			library.waitForClickableElement(proposalPage.Save, 30);
////			Wcontrol.scrollToView(proposalPage.Save);
			Wcontrol.clickJSEon(proposalPage.Save);

		}
		defins.takeScreenShot("Screen Shot for the test");

	}

	@And("click on the Life Details and Verify the details")
	public void LifeAssuredDetails() throws Throwable {
		Thread.sleep(1500);
		Wcontrol.clickJSEon(proposalPage.LifeAssuredView);
		Thread.sleep(2500);
		Wcontrol.scrollToView(proposalPage.Save);
		Wcontrol.clickJSEon(proposalPage.Save);
	}

	@SuppressWarnings("deprecation")
	@Then("Validate the Final Tab")
	public void Validate_the_Final_Tab() throws Throwable {
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(5000);
		} else {
			library.elementstable(By.xpath("//*[contains(text(),'Pop Out')]"));
			library.waitForClickableElement(By.xpath("//*[contains(text(),'Pop Out')]"));

		}

		String planCode = CustomerExceldata.TestDataInMap.get("PlanCode");

//		String err1 = Wcontrol.GetTexton(By.xpath("((//*[contains(text(),'Severity')]/ancestor::table)[1]//tr)[2]//td[2]"));
//		String err2 = Wcontrol.GetTexton(By.xpath("((//*[contains(text(),'Severity')]/ancestor::table)[1]//tr)[4]//td[2]"));

		List<WebElement> errList = Wcontrol
				.GetAllElements(By.xpath("((//*[contains(text(),'Severity')]/ancestor::table)[1]//tr)//td[2]"));
		List<String> ErrorList = new ArrayList<>();

		for (int i = 0; i < errList.size(); i++) {
			String loc = "(((//*[contains(text(),'Severity')]/ancestor::table)[1]//tr)//td[2])[" + (i + 1) + "]";
			String newItem = Wcontrol.GetTexton(By.xpath(loc)).trim();
			ErrorList.add(newItem);
		}

		List<String> uniqueErrorList = new ArrayList<>(new LinkedHashSet<>(ErrorList));

		String expectedTermError = "NB114 - AGE AT ENTRY + TERM SHOULD NOT EXCEED THE MATURITY AGE Action : PLS REDUCE THE TERM";
		String expectedAgeError = "NB253 - INVALID AGE FOR THE PLAN/RIDER AND TERM Action : Enter valid Age";
		String expectedSumassuredError = "NB328 - Plan Sum Assured Should Be Between Min SA And Max SA Action : Enter A Valid Code";
		String expectedCustomerAgeError = "NB014 - AGE AT ENTRY IS NOT VALID FOR THE PLAN/RIDER Action : Please Change Your Decision";
		String expectedPremiumError = "NB205 - PREMIUM IS NOT VALID FOR THIS PLAN AND FREQUENCY Action : ENTER THE CORRECT VALUE";
		String expectedLAError = "NB060 - INVALID VALUE FOR PROPOSER RELATIONSHIP Action : PLEASE SELECT ONE FROM LIST OF VALUES";
		String expectedLoadingErrorWOA = "NB402 - LOADING/DISCOUNT HAS GIVEN BUT THE DECISION WAS NOT TAKEN Action : PLEASE TAKE A DECISION AS ACCEPTED WITH LOADING";
		String expectedLoadingErrorWA = "NB112 - LOADING MUST BE GIVEN FOR THIS DECISION Action : PLEASE GIVE LOADING";
		String expectedGuaranteePeriod = "NB167 - GURANTEE PERIOD SHOULD LIE BETWEEN PRODUCT LEVEL FROM PERIOD AND TO PERIOD Action : PLEASE ENTER THE CORRECT VALUE";
		
		String actualTermError = null;
		String actualSumassuredError = null;
		String actualAgeError = null;
		String actualCustomerAgeError = null;
		String actualPremiumError = null;
		String actualLAError = null;
		String actualLoadingErrorWOA = null;
		String actualLoadingErrorWA = null;
		String actualGuaranteePeriod = null;

		for (int j = 0; j < uniqueErrorList.size(); j++) {
			String newItem = uniqueErrorList.get(j).split("-")[0].trim();
			if (newItem.equalsIgnoreCase("NB114")) {
				actualTermError = uniqueErrorList.get(j);
			} else if (newItem.equalsIgnoreCase("NB253")) {
				actualAgeError = uniqueErrorList.get(j);
			} else if (newItem.equalsIgnoreCase("NB328")) {
				actualSumassuredError = uniqueErrorList.get(j);
			} else if (newItem.equalsIgnoreCase("NB014")) {
				actualCustomerAgeError = uniqueErrorList.get(j);
			} else if (newItem.equalsIgnoreCase("NB205")) {
				actualPremiumError = uniqueErrorList.get(j);
			} else if (newItem.equalsIgnoreCase("NB060")) {
				actualLAError = uniqueErrorList.get(j);
			} else if (newItem.equalsIgnoreCase("NB402")) {
				actualLoadingErrorWOA = uniqueErrorList.get(j);
			} else if (newItem.equalsIgnoreCase("NB112")) {
				actualLoadingErrorWA = uniqueErrorList.get(j);
			} else if (newItem.equalsIgnoreCase("NB167")) {
				actualGuaranteePeriod = uniqueErrorList.get(j);
			}
		}

		String validationType = CustomerExceldata.TestDataInMap.get("ValidationType");

		if (validationType.equalsIgnoreCase("Term-SA")) {

			Assert.assertEquals(expectedTermError, actualTermError);
			Assert.assertEquals(expectedAgeError, actualAgeError);
			Assert.assertEquals(expectedSumassuredError, actualSumassuredError);

		} else if (validationType.equalsIgnoreCase("Age-Premium")) {
			Assert.assertEquals(expectedTermError, actualTermError);
			Assert.assertEquals(expectedAgeError, actualAgeError);
			Assert.assertEquals(expectedCustomerAgeError, actualCustomerAgeError);
			Assert.assertEquals(expectedPremiumError, actualPremiumError);
		} else if (validationType.equalsIgnoreCase("LA")) {
			
			Assert.assertEquals(expectedAgeError, actualAgeError);
			Assert.assertEquals(expectedCustomerAgeError, actualCustomerAgeError);
			Assert.assertEquals(expectedLAError, actualLAError);
		} else if (validationType.equalsIgnoreCase("LOADINGWOA")) {
			Assert.assertEquals(expectedLoadingErrorWOA, actualLoadingErrorWOA);
		} else if (validationType.equalsIgnoreCase("LOADINGWA")) {
			Assert.assertEquals(expectedLoadingErrorWA, actualLoadingErrorWA);
		} else if (validationType.equalsIgnoreCase("Guarantee Period")) {
			Assert.assertEquals(expectedGuaranteePeriod, actualGuaranteePeriod);
		} else if (validationType.equalsIgnoreCase("Term-Age")) {
			Assert.assertEquals(expectedTermError, actualTermError);
			Assert.assertEquals(expectedAgeError, actualAgeError);
		}

		defins.takeScreenShot("Validation Screen shot...................");

	}

	@And("click on the Life Detail and add the Optional Rider")
	public void LifeAssuredDetails_Add_optionalRider() throws Throwable {

		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");

		if (!planDesc.equalsIgnoreCase("D-TRS") && !planDesc.equalsIgnoreCase("Plan19")) {
			int i = 0;
			Add_Optional_Rider(i);
//			new_RiderSelect();
		}

		if (planDesc.equalsIgnoreCase("Plan19")) {
			Annuity_Details_for_Plan19();
			Wcontrol.clickJSEon(proposalPage.Save);
		}

	}

	@And("click on the Life Detail and add the Optional Rider details for UWQ")
	public void LifeAssuredDetails_Add_optionalRider_for_UWQ() throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.waitForVisibilityOfElement(proposalPage.LifeTab, 70);
		}
		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		if (!planDesc.equalsIgnoreCase("D-TRS") && !planDesc.equalsIgnoreCase("Plan19")) {
			int i = 1;
			Add_Optional_Rider(i);

		}

	}

	@Then("click on the LoanNext button")
	public void click_on_the_LoanNext_Button() throws Throwable {
		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("D-TRS")) {
			Wcontrol.scrollToView(proposalPage.loanNext);
			Wcontrol.clickJSEon(proposalPage.loanNext);
		}
	}

	@Then("Click on the Fund button")
	public void click_on_the_Fund_Button() throws Throwable {

		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");

		if (planDesc.equalsIgnoreCase("Future Invest") || planDesc.equalsIgnoreCase("Plan21")
				|| planDesc.equalsIgnoreCase("RSP")) {
			Thread.sleep(500);
			Wcontrol.clickJSEon(proposalPage.fundTab);
			defins.takeScreenShot("Screenshot of the Test........");
		}

	}

	@Then("Receive Documents for Second Life Assured")
	public void multiple_LA_at_UW() throws Throwable {

		String planDesc = CustomerExceldata.TestDataInMap.get("PlanCode");

		if (planDesc.equalsIgnoreCase("Plan27")) {
			library.elementstable(proposalPage.LifeAssuredView1);
			library.waitForClickableElement(proposalPage.LifeAssuredView1, 20);
			Thread.sleep(500);
			Wcontrol.clickJSEon(proposalPage.LifeAssuredView1);
			library.elementstable(proposalPage.Save);
			library.waitForClickableElement(proposalPage.Save, 30);

			Wcontrol.scrollDownLong();
			Wcontrol.clickJSEon(proposalPage.UnderwritingQuestions);
			Wcontrol.clickJSEon(proposalPage.UWQuestionsNext);

			Wcontrol.clickJSEon(underWritingPage.documents);
//			Wcontrol.clickJSEon(underWritingPage.documents);
//			Wcontrol.scrollUpMin();
			Wcontrol.clickJSEon(underWritingPage.receiveDocuments);
			Wcontrol.scrollDownLong();
			defins.takeScreenShot("Screen Shot for the test");
//			Wcontrol.clickJSEon(underWritingPage.documentNext);

			Wcontrol.clickJSEon(proposalPage.Save);
		}
	}

	@Then("Change the {string} details")
	public void Modify_the_Desired_Details(String content) throws Throwable {
		if (content.equalsIgnoreCase("Agent")) {
			Wcontrol.clickJSEon(proposalPage.agentEdit1);
//			Wcontrol.click_and_Select(proposalPage.agentCode1, proposalPage.planDescOption);
			Wcontrol.clearText(proposalPage.agentCode1);
			Wcontrol.sendkeysByAction(proposalPage.agentCode1, "A0037437");
			Wcontrol.clickJSEon(proposalPage.agentTick1);
		}
	}

	@And("click on the Process button")
	public void process_Button_Page() throws Throwable {
		Wcontrol.clickJSEon(proposalPage.process);
		library.waitForInVisibilityOfElement(commonPage.animation);

		String result = Wcontrol.GetTexton(proposalPage.processTable).trim();
		if (!(result.equalsIgnoreCase("No Data Found"))) {
			Wcontrol.clickJSEon(proposalPage.process);
			Thread.sleep(4000);
			Wcontrol.clickJSEon(proposalPage.process);
			library.waitForInVisibilityOfElement(commonPage.animation);
		}

	}

//-----------------------------------------UnderWriting----------------------------------------------------

	@And("Enter the Policy number and click on Search button")
	public void Enter_Policy_Number_and_click_on_search_button() throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(13000);
		} else {
			Thread.sleep(1000);
		}

		library.elementstable(underWritingPage.policyNumber);
		library.waitForClickableElement(underWritingPage.policyNumber);
		Wcontrol.sendkeysByAction(underWritingPage.policyNumber, proposalStep.returnedPolicyNumber.trim());
		library.waitForVisibilityOfElement(underWritingPage.statusDesc, 70);
		Wcontrol.clickJSEon(underWritingPage.statusDesc);
		Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);
		Wcontrol.doubleClickon(underWritingPage.policyNumber);
		Wcontrol.clickJSEon(underWritingPage.Search);
		defins.takeScreenShot("Screen shot of the Test");

	}

	@Then("Enter the Policy number and click on Search buttonss")
	public void cancel_proposalDetails() throws Throwable {
		library.elementstable(underWritingPage.policyNumber);
		library.waitForClickableElement(underWritingPage.policyNumber);
//		Wcontrol.sendkeysByAction(underWritingPage.policyNumber, Exceldata.TestDataInMap.get("PolicyNumber"));
		Wcontrol.sendkeysByAction(underWritingPage.policyNumber, "TL202307325146");
		Wcontrol.clickJSEon(underWritingPage.statusDesc);
		Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);

//		List<WebElement> status = Wcontrol.GetAllElements(By.xpath("//mat-option"));
//		for (int i = 0; i < status.size(); i++) {
//			String val = Wcontrol.GetTexton(status.get(i));
//			String docStat = "AWAITING FOR DOCUMENTS ( NB053 )";
//			String PremiumStat = "AWAITING PREMIUM ( NB058 )";
//			int count = 0;
//			if (val.equalsIgnoreCase(docStat) || val.equalsIgnoreCase(PremiumStat)) {
//				Wcontrol.scrollToView(status.get(i));
//				Wcontrol.clickJSEon(status.get(i));
//				count++;
//			}
//			if (count > 2) {
//				break;
//			}
//		}
		Wcontrol.doubleClickon(underWritingPage.policyNumber);
		Wcontrol.clickJSEon(underWritingPage.Search);

	}

	@Then("Select the Base Plan {string}")
	public void BasePlan_selection(String decision) throws Throwable {
//		Wcontrol.scrollDownLong();
		Wcontrol.scrollDownLittle();
		Wcontrol.clickJSEon(underWritingPage.BasePlan);
//		Wcontrol.scrollToView(underWritingPage.BasePlan);
//		Wcontrol.scrollUpMin();
//		Wcontrol.scrollUpMin();
		Thread.sleep(500);
		if (decision.equalsIgnoreCase("Without Loading")) {
//			Wcontrol.click_and_Select(underWritingPage.UWdecision, proposalPage.opt);

			Wcontrol.clickJSEon(underWritingPage.UWdecision);
//			Wcontrol.MovejsClick(underWritingPage.UWdecision);
			Wcontrol.clickJSEon(proposalPage.opt);

		} else if (decision.equalsIgnoreCase("With Loading")) {
//			Wcontrol.click_and_Select(underWritingPage.UWdecision, proposalPage.planDescOption);
			Wcontrol.clickJSEon(underWritingPage.UWdecision);
//			Wcontrol.MovejsClick(underWritingPage.UWdecision);
			Wcontrol.clickJSEon(proposalPage.planDescOption);

		} else {
//			Wcontrol.click_and_Select(underWritingPage.UWdecision, underWritingPage.perMile);

			Wcontrol.clickJSEon(underWritingPage.UWdecision);
//			Wcontrol.MovejsClick(underWritingPage.UWdecision);
			Wcontrol.clickJSEon(underWritingPage.perMile);
		}
		defins.takeScreenShot("Screen Shot for the test");
	}

	@Then("Click the {string} >> {string}")
	public void Select_basePlan_option_then_Select_loading_discount(String button1, String button2) throws Throwable {

		List<WebElement> charges = Wcontrol.GetAllElements(underWritingPage.chargesButton);
		if (button1.equalsIgnoreCase("Charges")) {
//			for (int i = 0; i < charges.size(); i++) {
//				Wcontrol.clickJSEon(charges.get(i));
//
////				base.getDriver().findElements(underWritingPage.basePlanTable);
//				if (base.getDriver().findElements(underWritingPage.basePlanTable).size() == 0) {
//					if (button2.equalsIgnoreCase("Loading")) {
//						library.elementstable(underWritingPage.loadingButton);
//						library.waitForClickableElement(underWritingPage.loadingButton);
//						Wcontrol.clickJSEon(underWritingPage.loadingButton);
//					} else if (button2.equalsIgnoreCase("Discount")) {
//						library.elementstable(underWritingPage.discountButton);
//						library.waitForClickableElement(underWritingPage.discountButton);
//						Wcontrol.clickJSEon(underWritingPage.discountButton);
//					}
//					break;
//				}
//			}

			List<WebElement> tableNames = base.getDriver().findElements(underWritingPage.chargesTableName);
			int count = tableNames.size();
			for (int i = 0; i < count; i++) {
				String name_loc = "((//div[contains(text(),'Base Plan')])[1]/ancestor::mat-step-header/parent::div//table//tbody//td[1])["
						+ (i + 1) + "]";
				String name = base.getDriver().findElement(By.xpath(name_loc)).getText();
				if (name.equalsIgnoreCase("DEATH") || name.equalsIgnoreCase("NATURAL DEATH")) {
					String charges_loc = "((//div[contains(text(),'Base Plan')])[1]/ancestor::mat-step-header/parent::div//table//tbody//td//*[contains(text(),'Charges')])["
							+ (i + 1) + "]";
					Wcontrol.clickJSEon(By.xpath(charges_loc));

					if (button2.equalsIgnoreCase("Loading")) {
						if (CustomerExceldata.TestDataInMap.get("PlanCode").equalsIgnoreCase("FUTINVEST")) {
							String lod = "((//div[contains(text(),'Base Plan')])[1]/ancestor::mat-step-header/parent::div//button//span[text()=' Loading '])[2]";
							Wcontrol.scrollDownLittle();
							Wcontrol.clickJSEon(By.xpath(lod));
						} else {
							library.elementstable(underWritingPage.loadingButton);
							library.waitForClickableElement(underWritingPage.loadingButton, 20);
							Wcontrol.scrollDownLittle();
							Wcontrol.clickJSEon(underWritingPage.loadingButton);
						}
					} else if (button2.equalsIgnoreCase("Discount")) {

						if (CustomerExceldata.TestDataInMap.get("PlanCode").equalsIgnoreCase("FUTINVEST")) {
							String dis = "((//div[contains(text(),'Base Plan')])[1]/ancestor::mat-step-header/parent::div//button//span[text()=' Discount '])[2]";
							Wcontrol.scrollDownLittle();
							Wcontrol.clickJSEon(By.xpath(dis));
						} else {
							library.elementstable(underWritingPage.discountButton);
							library.waitForClickableElement(underWritingPage.discountButton, 20);
							Wcontrol.scrollDownLittle();
							Wcontrol.clickJSEon(underWritingPage.discountButton);
						}
					}
					break;
				}
			}

		} else if (button1.equalsIgnoreCase("Exclusion")) {
			Wcontrol.clickJSEon(underWritingPage.exclusionButton);
			Thread.sleep(1000);
			Wcontrol.scrollDownMin();
			Wcontrol.clickJSEon(underWritingPage.addExclusion);

		} else if (button1.equalsIgnoreCase("Lien")) {
			Wcontrol.clickJSEon(underWritingPage.lienButton);
			Thread.sleep(1000);
//			Wcontrol.scrollToView(underWritingPage);
			Wcontrol.scrollDownLittle();
//			Wcontrol.scrollUpLittle();
			Wcontrol.clickJSEon(underWritingPage.addLien);

		}
		defins.takeScreenShot("Screen Shot for the test");
	}

	@Then("Add the {string} Details for criteria {string}")
	public void Content_Details(String content, String Criteria) throws Throwable {
		if (content.equalsIgnoreCase("Loading")) {
			Add_Loading(Criteria);
		} else if (content.equalsIgnoreCase("Exclusion")) {
			Wcontrol.scrollToView(underWritingPage.addExclusion);
			Add_Exclusion(Criteria);
		} else if (content.equalsIgnoreCase("Lien")) {
			Wcontrol.scrollToView(underWritingPage.addLien);
			Add_Lien(Criteria);
		}

//		Wcontrol.scrollToView(underWritingPage.basePlanNext);
//		Wcontrol.clickJSEon(underWritingPage.basePlanNext);
//		Wcontrol.scrollUpMin();

	}

	@Then("Receive the Documents")
	public void Docs_Verification() throws Throwable {
		Wcontrol.scrollToView(proposalPage.otherPolicies);
		Wcontrol.clickJSEon(underWritingPage.documents);
		Wcontrol.scrollToView(underWritingPage.receiveDocuments);
		Wcontrol.clickJSEon(underWritingPage.receiveDocuments);
		defins.takeScreenShot("Screen Shot for the test");
		Wcontrol.clickJSEon(underWritingPage.documentNext);
	}

	@Then("Verify the Fields in validation Tab")
	public void Verify_the_Validation_tab_fields() throws Throwable {
		Thread.sleep(1500);
		if (base.getDriver().findElements(proposalPage.tableFields).size() != 0) {
			String err = Wcontrol.GetTexton(proposalPage.tableFields).trim();
			String err1 = "NB402 - LOADING/DISCOUNT HAS GIVEN BUT THE DECISION WAS NOT TAKEN Action : PLEASE TAKE A DECISION AS ACCEPTED WITH LOADING";
			String err2 = "NB112 - LOADING MUST BE GIVEN FOR THIS DECISION Action : PLEASE GIVE LOADING";
			if (err.equalsIgnoreCase(err1)) {
				Change_The_UW_Decision();
			}
			if (err.equalsIgnoreCase(err2)) {
				Wcontrol.clickJSEon(proposalPage.LifeTab);
				Wcontrol.clickJSEon(proposalPage.LifeAssuredView);
				library.elementstable(proposalPage.Save);
				BasePlan_selection("With Loading");
				Select_basePlan_option_then_Select_loading_discount("Charges", "Loading");
				Content_Details("Loading", "FIXED AMOUNT");
				Wcontrol.clickJSEon(proposalPage.Save);
			}
			Wcontrol.scrollToView(proposalPage.process);
			Last_Process();
		}
	}

	@Then("Add the Discount Details")
	public void Add_Discount_Details() throws Throwable {
		Thread.sleep(1000);
		library.elementstable(underWritingPage.addDiscount);
		library.waitForClickableElement(underWritingPage.addDiscount);
		Wcontrol.scrollToView(underWritingPage.loadingButton);
		Wcontrol.ActionMoveToElement(underWritingPage.addDiscount);
		Wcontrol.clickJSEon(underWritingPage.addDiscount);

		Wcontrol.click_and_Select(underWritingPage.discountCriteria, proposalPage.planDescOption);
		Wcontrol.sendkeysByAction(underWritingPage.discountValue, "25");
		Wcontrol.clickJSEon(underWritingPage.discountTick);
		defins.takeScreenShot("Screen Shot for the test");

		Wcontrol.scrollToView(underWritingPage.basePlanNext);
		Wcontrol.clickJSEon(underWritingPage.basePlanNext);
	}
	
	@Then("Select Rider Loading as {string}")
	public void Select_Rider_Loading_as_Without_Loading(String riderLoading) throws Throwable {
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(4000);
		} else {
			Thread.sleep(300);
		}
		Wcontrol.scrollDownLong();
		if (riderLoading.equalsIgnoreCase("With Loading")) {
			Wcontrol.clickJSEon(proposalPage.optionalRiderEdit);
			Wcontrol.click_and_Select(proposalPage.riderDecision, proposalPage.planDescOption);
			Wcontrol.clickJSEon(proposalPage.optionalRiderTick);
		}
	} 
	
	@Then("Select the Loading Details and Receive Doccument")
	public void Select_the_Loading_Details_and_Receive_Doccument() throws Throwable {
		Rider_Loading_Details();
		Wcontrol.scrollDownLong();
		Wcontrol.clickJSEon(underWritingPage.documents);
//		Wcontrol.scrollToView(underWritingPage.receiveDocuments);
		Wcontrol.scrollUpMin();
		Wcontrol.clickJSEon(underWritingPage.receiveDocuments);
		defins.takeScreenShot("Screen Shot for the test");
		Wcontrol.clickJSEon(underWritingPage.documentNext);
	}

	@Then("Select optional rider {string} and Receive Documents")
	public void Select_Rider_as_something(String riderLoading) throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(4000);
		} else {
			Thread.sleep(300);
		}
//		Wcontrol.scrollDownLong();
		Wcontrol.scrollDownLittle();
		if (riderLoading.equalsIgnoreCase("With Loading")) {
			Wcontrol.clickJSEon(proposalPage.optionalRiderEdit);
//			Wcontrol.scrollDownLittle();
			
			if(Width.equalsIgnoreCase("1366") && Height.equalsIgnoreCase("768")) {
				By Decision = By.xpath("//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//*[contains(text(),'Decision')]/parent::label/parent::span/parent::div//mat-select");
				By Save = By.xpath("//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//*[contains(text(),'Save')]");
				
				Wcontrol.click_and_Select(Decision, proposalPage.planDescOption);
				Wcontrol.clickJSEon(Save);
				
			} else {
				Wcontrol.click_and_Select(proposalPage.riderDecision, proposalPage.planDescOption);
				Wcontrol.clickJSEon(proposalPage.optionalRiderTick);
			}
			
			
			Rider_Loading_Details();
		}

		Wcontrol.scrollDownLong();
		Wcontrol.clickJSEon(underWritingPage.documents);
//		Wcontrol.scrollToView(underWritingPage.receiveDocuments);
		Wcontrol.scrollUpLittle();
		Wcontrol.clickJSEon(underWritingPage.receiveDocuments);
		defins.takeScreenShot("Screen Shot for the test");
		Wcontrol.clickJSEon(underWritingPage.documentNext);

	}

	@Then("click on the Eye Icon and Capture {string}")
	public void capturing_Details_in_Underwriting_Dashboard(String UWoptions) throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(underWritingPage.viewIcon);
			library.waitForClickableElement(underWritingPage.viewIcon, 30);
		}
		Wcontrol.clickJSEon(underWritingPage.viewIcon);
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
//			library.elementstable(underWritingPage.UWEvents);
//			library.waitForClickableElement(underWritingPage.UWEvents, 30);
			Thread.sleep(2000);
		}
		if (UWoptions.equalsIgnoreCase("UW History")) {
			Wcontrol.clickJSEon(underWritingPage.UWEvents);
//			Wcontrol.scrollToView(underWritingPage.otherPolicies);
			Wcontrol.scrollDownLong();
			Wcontrol.clickJSEon(underWritingPage.underwritingHistory);
			Thread.sleep(2000);
			defins.takeScreenShot("Screenshot of the Test");
		} else if (UWoptions.equalsIgnoreCase("UW Enquiry")) {
			Thread.sleep(1000);
			Wcontrol.clickJSEon(underWritingPage.UWEnquiry);
		} else if (UWoptions.equalsIgnoreCase("BlackList")) {
			Wcontrol.clickJSEon(underWritingPage.UWEvents);
//			Wcontrol.scrollToView(underWritingPage.underwritingHistory);
			Wcontrol.scrollDownLong();
			Wcontrol.clickJSEon(underWritingPage.blackList);
			Thread.sleep(1000);
			defins.takeScreenShot("Screenshot of the Test");
		}

	}

	@Then("click on To Proposal button")
	public void toProposal() throws Throwable {
		Wcontrol.scrollToView(underWritingPage.toProposal);
		Wcontrol.clickJSEon(underWritingPage.toProposal);
		library.waitForInVisibilityOfElement(commonPage.animation);
	}
	
	@Then("click on the Eye Icon and click on To Proposal button One")
	public void Clickon_Eye_icon_and_click_on_To_proposal_button_One() throws Throwable {
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(2500);
			Wcontrol.clickJSEon(underWritingPage.viewIcon);
//			library.waitForInVisibilityOfElement(commonPage.animation);
			Thread.sleep(5000);
			library.elementstable(proposalPage.LifeTab);
			library.waitForClickableElement(proposalPage.LifeTab, 30);
		} else {
			Thread.sleep(1000);
			library.elementstable(underWritingPage.viewIcon);
			library.waitForClickableElement(underWritingPage.viewIcon, 20);
//			WebElement eyeIcon = library.fluient_Wait(underWritingPage.viewIcon);
//			eyeIcon.click();
			Wcontrol.clickJSEon(underWritingPage.viewIcon);
			Thread.sleep(1000);
		}
		
		library.elementstable(underWritingPage.toProposal);
		library.waitForClickableElement(underWritingPage.toProposal, 30);
		defins.takeScreenShot("ScreenShot of the Test");
		Wcontrol.clickJSEon(underWritingPage.toProposal);

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
			library.elementstable(proposalPage.basicParticularPanel);
			library.waitForVisibilityOfElement(proposalPage.planDescription, 50);
			library.waitForVisibilityOfElement(proposalPage.LifeTab, 50);
			library.elementstable(proposalPage.LifeTab);
			library.waitForClickableElement(proposalPage.LifeTab, 50);
			library.waitForClickableElement(proposalPage.LifeTab, 50);
		} else {
			library.elementstable(proposalPage.basicParticularPanel);
			library.waitForVisibilityOfElement(proposalPage.planDescription, 50);
			library.waitForVisibilityOfElement(proposalPage.LifeTab, 50);
//			library.waitForClickableElement(proposalPage.planDescription);
//			library.waitForPresenceOfElement(proposalPage.planDescription, 30);
		}
	}

	@Then("click on the Eye Icon and click on To Proposal button")
	public void Clickon_Eye_icon_and_click_on_To_proposal_button() throws Throwable {

//		library.waitForInVisibilityOfElement(commonPage.animation);
//		library.elementstable(underWritingPage.viewIcon);
//		library.waitForClickableElement(underWritingPage.viewIcon);
		String Plancode = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(2500);
			Wcontrol.clickJSEon(underWritingPage.viewIcon);
//			library.waitForInVisibilityOfElement(commonPage.animation);
			Thread.sleep(5000);
			library.elementstable(proposalPage.LifeTab);
			library.waitForClickableElement(proposalPage.LifeTab, 30);
		} else {
			Thread.sleep(1000);
			library.elementstable(underWritingPage.viewIcon);
			library.waitForClickableElement(underWritingPage.viewIcon, 20);
//			WebElement eyeIcon = library.fluient_Wait(underWritingPage.viewIcon);
//			eyeIcon.click();
			Wcontrol.clickJSEon(underWritingPage.viewIcon);
			Thread.sleep(1000);
		}

		if(!Plancode.equalsIgnoreCase("Plan27") && !Plancode.equalsIgnoreCase("Plan19") && !Plancode.equalsIgnoreCase("Plan21") && !Plancode.equalsIgnoreCase("Future Invest") && !Plancode.equalsIgnoreCase("RSP")
				&& !Plancode.equalsIgnoreCase("D-TRS")) {
			Validate_Premium_in_Underwriting_Dashboard();
		}
		

		library.elementstable(underWritingPage.toProposal);
		library.waitForClickableElement(underWritingPage.toProposal, 30);
		defins.takeScreenShot("ScreenShot of the Test");
		Wcontrol.clickJSEon(underWritingPage.toProposal);

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
			library.elementstable(proposalPage.basicParticularPanel);
			library.waitForVisibilityOfElement(proposalPage.planDescription, 50);
			library.waitForVisibilityOfElement(proposalPage.LifeTab, 50);
			library.elementstable(proposalPage.LifeTab);
			library.waitForClickableElement(proposalPage.LifeTab, 50);
			library.waitForClickableElement(proposalPage.LifeTab, 50);
		} else {
			library.elementstable(proposalPage.basicParticularPanel);
			library.waitForVisibilityOfElement(proposalPage.planDescription, 50);
			library.waitForVisibilityOfElement(proposalPage.LifeTab, 50);
//			library.waitForClickableElement(proposalPage.planDescription);
//			library.waitForPresenceOfElement(proposalPage.planDescription, 30);
		}
	}

	@Then("Verify the IndividualID and Id number matches the data from excel")
	public void Individualid_and_Identity_number_Verifications() throws Throwable {

		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		if (!planDesc.equalsIgnoreCase("D-TRS")) {
			library.waitForVisibilityOfElement(proposalPage.Identity, 60);
			Assert.assertEquals(CustomerExceldata.TestDataInMap.get("Identity"), report.getIdentity());
			Assert.assertEquals(CustomerExceldata.TestDataInMap.get("Identity number"), report.getIdentityNumber());
		}

	}

//	@Then("Verify the CompanyID and Company Relation")
//	public void CompanyID_and_CompanyRelation_Verification() throws Throwable {
//		
//	}

	@Then("Verify the Agent Name")
	public void Agent_name_Verification() throws Throwable {

		Assert.assertEquals(CustomerExceldata.TestDataInMap.get("Agent Name"), report.getAgentName());

	}

	@Then("Verify the Premium Pattern and Sum Assured Pattern matches the data from excel")
	public void Premium_pattern_and_Sum_assured_pattern_Verification() throws Throwable {

		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("Future Invest")) {
			Assert.assertEquals(CustomerExceldata.TestDataInMap.get("PremiumPattern"), report.getPremiumPattern());
			Assert.assertEquals(CustomerExceldata.TestDataInMap.get("SAPattern").trim(), report.getSumAssuredPattern());
		}
	}

	@And("Verify the User Premium matches the data from excel")
	public void User_Premium_Verification() throws Throwable {

		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("Future Invest")) {
			Assert.assertEquals(CustomerExceldata.TestDataInMap.get("UserPremium"), report.getUserPremium());
		}

	}

	@And("Verify the plan Description and the policy number matches the data from excel")
	public void Plan_description_and_Policy_number_Verification() throws Throwable {

		library.waitForInVisibilityOfElement(commonPage.animation);
		String planDesc = report.getPlanDesc().trim();
		String expectedPlanDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn").trim();
		Assert.assertEquals(planDesc, expectedPlanDesc);

	}

	@And("Verify the Currency and Initial Sum Assured matches the data from excel")
	public void Currency_and_Initial_Sum_Assured_Verification() throws Throwable {

		library.waitForVisibilityOfElement(proposalPage.currency, 60);
		Assert.assertEquals(CustomerExceldata.TestDataInMap.get("Currency"), report.getCurrency());

		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		if (!planDesc.equalsIgnoreCase("D-TRS")) {
			Assert.assertEquals(CustomerExceldata.TestDataInMap.get("InitalSumAssured"), report.getInitialSumAssured());
			Thread.sleep(1000);

			if (planDesc.equalsIgnoreCase("Plan19")) {
				Wcontrol.clearText(proposalPage.initialSA);
				Wcontrol.sendkeysByAction(proposalPage.initialSA, "200011");
				defins.takeScreenShot("Screen Shot for the test");
			}
		}

	}

	@And("Verify the Policy Terms and Frequency matches the data from excel")
	public void Policy_terms_and_Frequency_Verification() throws Throwable {

		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("Future Invest")) {
			Assert.assertEquals(CustomerExceldata.TestDataInMap.get("PolicyTerms"), report.getPolicyTerms());
			Assert.assertEquals(CustomerExceldata.TestDataInMap.get("Frequency"), report.getFrequency());
		} else if (planDesc.equalsIgnoreCase("Plan11") || planDesc.equalsIgnoreCase("D-TRS")) {
			Assert.assertEquals(CustomerExceldata.TestDataInMap.get("PolicyTerms"), report.getPolicyTerms());
		}

	}

	@Then("Add Multiple Nominee Details")
	public void multiple_nominee() throws Throwable {
		String NomineeID = CustomerExceldata.TestDataInMap.get("NomineeID");

		add_nominee(NomineeID, CustomerExceldata.TestDataInMap.get("NomineeIDnumber"),
				CustomerExceldata.TestDataInMap.get("NomineeRelation"));
		Wcontrol.clickJSEon(proposalPage.addNominee);

		String rel = CustomerExceldata.TestDataInMap.get("Nominee2ndRelation");
		add_nominee(NomineeID, CustomerExceldata.TestDataInMap.get("NomineeIDnumber2"), rel);
	}

	@Then("Select the Decision as {string} and Enter the reason")
	public void Select_the_Decision_and_Result(String decision) throws Throwable {
		Wcontrol.clickJSEon(underWritingPage.decision);
		String loc = null;
		List<WebElement> options = Wcontrol.GetAllElements(underWritingPage.descisionresults);
		for (int i = 0; i < options.size(); i++) {
			String n1 = "(//mat-option)" + "[" + (i + 1) + "]";
			String target = Wcontrol.GetTexton(By.xpath(n1));

			if (target.equalsIgnoreCase(decision)) {
				Wcontrol.clickJSEon(options.get(i));
//				loc = "(//mat-option)" + "[" + (i + 1) + "]";
				break;
			}
		}
//		Wcontrol.MovejsClick(By.xpath(loc));
		Wcontrol.EnterValueon(underWritingPage.reason, decision);
		defins.takeScreenShot("Screen Shot for the test");

	}

	@Then("Select the Decision and Enter the reason")
	public void Select_the_Decision_and_Get_the_Result() throws Throwable {
		Wcontrol.clickJSEon(underWritingPage.decision);
		String loc = null;
		String decision = CustomerExceldata.TestDataInMap.get("UnderWritingDecision");
		List<WebElement> options = Wcontrol.GetAllElements(underWritingPage.descisionresults);
		for (int i = 0; i < options.size(); i++) {
			String n1 = "(//mat-option)" + "[" + (i + 1) + "]";
			String target = Wcontrol.GetTexton(By.xpath(n1));

			if (target.equalsIgnoreCase(decision)) {
				Wcontrol.clickJSEon(options.get(i));
//				loc = "(//mat-option)" + "[" + (i + 1) + "]";
				break;
			}
		}
//		Wcontrol.MovejsClick(By.xpath(loc));
		Wcontrol.EnterValueon(underWritingPage.reason, decision);
		defins.takeScreenShot("Screen Shot for the test");

	}

//----------------------------------Company Registration----------------------------------------------	

	@Then("Enter the Institution code and Institution Branch")
	public void enter_the_institution_code_and_institution_branch() throws Throwable {
//	        library.waitForInVisibilityOfElement(commonPage.animation);
		Thread.sleep(3000);
		Wcontrol.sendkeysByAction(companyRegistration.institutionCode, String.valueOf(GetFiveDigRandomNumber()));
		Wcontrol.sendkeysByAction(companyRegistration.institutionBranch,
				companyExceldata.TestDataInMap.get("InstitutionBranch"));
	}

	public String GenerateRandomLetters() {
		int n = 5;
		Random random = new Random();
		StringBuilder randomLetters = new StringBuilder();

		for (int i = 0; i < n; i++) {
			char randomLetter = (char) (random.nextInt(26) + 'A');
			randomLetters.append(randomLetter);
		}

		String result = randomLetters.toString();
		return result;
	}

	@Then("Enter the Institution Name and Institution Type")
	public void enter_the_institution_name_and_institution_type() throws Throwable {

		String InsType = companyExceldata.TestDataInMap.get("InstitutionType");
		String IntitutionName = companyExceldata.TestDataInMap.get("InstitutionName") + GenerateRandomLetters();
		Wcontrol.sendkeysByAction(companyRegistration.institutionName, IntitutionName);
		Wcontrol.sendkeysByAction(companyRegistration.institutionType, InsType);

		if (InsType.equalsIgnoreCase("HOSPITAL")) {
			Wcontrol.clickJSEon(companyRegistration.panelClinicType);
			Thread.sleep(500);
			Wcontrol.ActionMoveToElementClcik(companyRegistration.panelClinicOption);
		}
	}

	@Then("Select the Branch Weekend Days")
	public void Branch_weekend_Days() throws Throwable {

		String InstitutionType = companyExceldata.TestDataInMap.get("InstitutionType");
		if (InstitutionType.equalsIgnoreCase("BRANCHES")) {
			Wcontrol.clickJSEon(companyRegistration.branchWeekEndDays);
			List<WebElement> options = Wcontrol.GetAllElements(companyRegistration.options);
			for (int i = 0; i < options.size(); i++) {
				int c = 0;
				String actual = Wcontrol.GetTexton(options.get(i)).trim();
				if (!actual.equalsIgnoreCase("SUNDAY") && !actual.equalsIgnoreCase("SATURDAY")) {
					Wcontrol.ActionMoveToElementClcik(options.get(i));
				} else if (c > 2) {
					break;
				} else {
					c++;
				}

			}
			Wcontrol.doubleClickon(companyRegistration.institutionCode);
		}

	}

	@Then("Select the Bank role")
	public void select_the_bank_role_as_something() throws Throwable {

		String bankRole = companyExceldata.TestDataInMap.get("BankRole");
		String InstitutionType = companyExceldata.TestDataInMap.get("InstitutionType");
		if (!InstitutionType.equalsIgnoreCase("RE-INSURANCE COMPANIES")) {

			if (InstitutionType.equalsIgnoreCase("BANK(FIN DEPT ONLY)")) {
				Wcontrol.clickJSEon(companyRegistration.bankRole);
				List<WebElement> options = Wcontrol.GetAllElements(companyRegistration.options);
				for (int i = 0; i < options.size(); i++) {
					String actual = Wcontrol.GetTexton(options.get(i)).trim();
					if (actual.equalsIgnoreCase(bankRole)) {
						Wcontrol.ActionMoveToElementClcik(options.get(i));
						break;
					}
				}
				Wcontrol.doubleClickon(companyRegistration.institutionCode);
			}
		}
	}

	@Then("Enter the Registration Number and Account Code")
	public void enter_the_registration_number_and_account_code() throws Throwable {
		Thread.sleep(700);
		Wcontrol.clickJSEon(companyRegistration.regNo);
		Wcontrol.sendkeysByAction(companyRegistration.regNo, Generate_Random_Numbers());
		Wcontrol.sendkeysByAction(companyRegistration.accountCode, Generate_Random_Numbers());

	}

	@Then("Enter the Contact Details")
	public void Contat_Details() throws Throwable {
//	    	Wcontrol.sendkeysByAction(companyRegistration.contactType, Exceldata.TestDataInMap.get("ContactType"));
		Wcontrol.MovejsClick(companyRegistration.contactType);
		Wcontrol.MovejsClick(companyRegistration.contactType);
		Thread.sleep(1000);
//		List<WebElement> contactTypes = Wcontrol.GetAllElements(companyRegistration.allOptions);
		String expected = companyExceldata.TestDataInMap.get("ContactType").trim();

		if (expected.equalsIgnoreCase("E-MAIL ADDRESS")) {
			Wcontrol.sendkeysByAction(companyRegistration.contactType, "E-MAIL");
//			Wcontrol.click_and_Select(companyRegistration.contactType, By.xpath("(//mat-option)[3]"));
			Wcontrol.MovejsClick(proposalPage.planDescOption);
		} else if (expected.equalsIgnoreCase("MOBILE PHONE NUMBER") || expected.equalsIgnoreCase("MOBILE PHONE")) {
			Wcontrol.sendkeysByAction(companyRegistration.contactType, "MOBILE");
//			Wcontrol.click_and_Select(companyRegistration.contactType, By.xpath("(//mat-option)[8]"));
			Wcontrol.MovejsClick(proposalPage.planDescOption);
		}
//		for (int i = 0; i < contactTypes.size(); i++) {
//			String actual = Wcontrol.GetTexton(contactTypes.get(i)).trim();
//			if (actual.equalsIgnoreCase(expected)) {
//				Wcontrol.MovejsClick(contactTypes.get(i));
//				break;
//			}
//		}

		Wcontrol.sendkeysByAction(companyRegistration.contactPerson,
				companyExceldata.TestDataInMap.get("ContactPerson"));
		Wcontrol.EnterValueon(companyRegistration.contactDetails,
				companyExceldata.TestDataInMap.get("ContactDescription"));
		Wcontrol.clickJSEon(companyRegistration.contactTick);
	}

	@Then("Enter the Address Details")
	public void Address_details_for_Company_Registration() throws Throwable {
		Thread.sleep(2000);
		Wcontrol.EnterValueon(registrationPage.address1, companyExceldata.TestDataInMap.get("Address"));
		Wcontrol.sendkeysByAction(registrationPage.postCode, companyExceldata.TestDataInMap.get("PostCode"));

	}

	@Then("Enter the Contact Details for Address")
	public void Contact_Details_for_address_Tab() throws Throwable {
		Wcontrol.scrollToView(companyRegistration.addressContactType);
//    	Wcontrol.sendkeysByAction(companyRegistration.contactType, Exceldata.TestDataInMap.get("ContactType"));
		Wcontrol.MovejsClick(companyRegistration.addressContactType);
		Wcontrol.MovejsClick(companyRegistration.addressContactType);
		Thread.sleep(1000);
//	List<WebElement> contactTypes = Wcontrol.GetAllElements(companyRegistration.allOptions);
		String expected = companyExceldata.TestDataInMap.get("ContactType").trim();

		if (expected.equalsIgnoreCase("E-MAIL ADDRESS")) {
			Wcontrol.sendkeysByAction(companyRegistration.addressContactType, "E-MAIL");
//		Wcontrol.click_and_Select(companyRegistration.contactType, By.xpath("(//mat-option)[3]"));
			Wcontrol.MovejsClick(proposalPage.planDescOption);
		} else if (expected.equalsIgnoreCase("MOBILE PHONE NUMBER") || expected.equalsIgnoreCase("MOBILE PHONE")) {
			Wcontrol.sendkeysByAction(companyRegistration.addressContactType, "MOBILE");
//		Wcontrol.click_and_Select(companyRegistration.contactType, By.xpath("(//mat-option)[8]"));
			Wcontrol.MovejsClick(proposalPage.planDescOption);
		}
//	for (int i = 0; i < contactTypes.size(); i++) {
//		String actual = Wcontrol.GetTexton(contactTypes.get(i)).trim();
//		if (actual.equalsIgnoreCase(expected)) {
//			Wcontrol.MovejsClick(contactTypes.get(i));
//			break;
//		}
//	}

		Wcontrol.EnterValueon(companyRegistration.addressContactDetails,
				companyExceldata.TestDataInMap.get("ContactDescription"));
		Wcontrol.clickJSEon(companyRegistration.addressContactTick);
	}

	@Then("Enter the Bank Details")
	public void Bank_Details_for_Company() throws Throwable {
		Wcontrol.sendkeysByAction(companyRegistration.bankName, companyExceldata.TestDataInMap.get("BankName"));
		Wcontrol.EnterKeyon(companyRegistration.bankName, Keys.ENTER);
		Wcontrol.EnterValueon(companyRegistration.accountNumber, Generate_Random_Numbers());
		Wcontrol.clickJSEon(companyRegistration.bankTick);
	}

//--------------------------------------------Quality Check---------------------------------------------

	@Then("Enter the Policy Number and Click on Search button")
	public void Enter_the_PolicyNumber_in_QualityCheck_Page() throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
//			library.waitForInVisibilityOfElement(commonPage.animation);
			Thread.sleep(13000);
		} else {
			library.elementstable(qualityCheck.policyNumber);
			library.waitForClickableElement(qualityCheck.policyNumber);
		}
		Wcontrol.clickJSEon(qualityCheck.policyNumber);
		Wcontrol.sendkeysByAction(qualityCheck.policyNumber, proposalStep.returnedPolicyNumber);
		Wcontrol.clearText(qualityCheck.policyNumber);
		Wcontrol.sendkeysByAction(qualityCheck.policyNumber, proposalStep.returnedPolicyNumber);

//		boolean value = base.getDriver().findElement(By.xpath("//mat-option[1]")).isDisplayed();

//		Wcontrol.clickJSEon(proposalPage.planDescOption);
		Thread.sleep(300);
//		Wcontrol.sendkeysByAction(qualityCheck.policyNumber, Exceldata.TestDataInMap.get("PolicyNumber"));
		Wcontrol.clickJSEon(qualityCheck.Search);

	}

	@Then("Enter the Policy Number and Validate Proposal Deposit Refund Page")
	public void Validate_Proposal_Deposit_Refund_Page() throws Throwable {
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
//			library.waitForInVisibilityOfElement(commonPage.animation);
			Thread.sleep(13000);
		} else {
			library.elementstable(qualityCheck.policyNumber);
			library.waitForClickableElement(qualityCheck.policyNumber);
		}
		Wcontrol.clickJSEon(qualityCheck.policyNumber);
		Wcontrol.sendkeysByAction(qualityCheck.policyNumber, proposalStep.returnedPolicyNumber);
		Wcontrol.clearText(qualityCheck.policyNumber);
		Wcontrol.sendkeysByAction(qualityCheck.policyNumber, proposalStep.returnedPolicyNumber);
		Thread.sleep(1000);

		String err = Wcontrol.GetTexton(proposalPage.planDescOption).trim();

		Assert.assertEquals("No Data Found", err);
		defins.takeScreenShot("Validation  Screen Shot...........");
	}

	@Then("Enter the Policy Number and Click on Search button on Proposal Deposit Refung Page")
	public void Enter_the_PolicyNumber_in_PD_Refund_Page() throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
//			library.waitForInVisibilityOfElement(commonPage.animation);
			Thread.sleep(13000);
		} else {
			library.elementstable(qualityCheck.policyNumber);
			library.waitForClickableElement(qualityCheck.policyNumber);
		}
		Wcontrol.clickJSEon(qualityCheck.policyNumber);
		Wcontrol.sendkeysByAction(qualityCheck.policyNumber, proposalStep.returnedPolicyNumber);
		Wcontrol.clearText(qualityCheck.policyNumber);
		Wcontrol.sendkeysByAction(qualityCheck.policyNumber, proposalStep.returnedPolicyNumber);

//		boolean value = base.getDriver().findElement(By.xpath("//mat-option[1]")).isDisplayed();
		Thread.sleep(1000);
//		boolean value = base.getDriver().findElement(By.xpath("//mat-option")).isDisplayed();
//		if(value==true) {
//			Wcontrol.clickJSEon(proposalPage.planDescOption);
//		}
//		Wcontrol.sendkeysByAction(qualityCheck.policyNumber, Exceldata.TestDataInMap.get("PolicyNumber"));
		Wcontrol.clickJSEon(qualityCheck.Search);

	}

	public void Voucher_Details() throws Throwable {
		Wcontrol.scrollToView(proposalPage.voucherDetails);
		Wcontrol.clickJSEon(proposalPage.voucherDetails);
		defins.takeScreenShot("Screen shot of the Enquiry Page");
		Thread.sleep(500);
		Wcontrol.clickJSEon(proposalPage.voucherNumber);
		Wcontrol.scrollToView(proposalPage.voucherPanel);
	}

	@Then("Verify the {string} tab in Enquiry Page")
	public void Enquiry_Page_Details_Verificataion(String enquiryTab) throws Throwable {
//		if(enquiryTab.equalsIgnoreCase("Life Assured")) {
//			Wcontrol.scrollDownLong();
//		}else if(enquiryTab.equalsIgnoreCase("Policy Values")) {
//			Wcontrol.clickJSEon(proposalPage.policyValueTab);
//		}

		By clickTab = null;
		switch (enquiryTab) {
		case "Life Assured":
			Wcontrol.scrollDownLong();
			Wcontrol.scrollDownMin();
			Wcontrol.scrollDownLong();
			clickTab = proposalPage.EnqLifeAssuredTab;
			break;
		case "Policy Values":
			clickTab = proposalPage.policyValueTab;
			break;
		case "Premium Details":
			clickTab = proposalPage.premiumDetailsTab;
			break;
		case "Product Details":
			clickTab = proposalPage.productDetailsTab;
			break;
		case "Additional Details":
			clickTab = proposalPage.additionalEnqDetails;
			break;

		default:
			break;
		}
		Wcontrol.scrollDownLong();
//		Wcontrol.ActionMoveToElementClcik(clickTab);
		Wcontrol.clickJSEon(clickTab);
		Wcontrol.scrollDownLong();
		defins.takeScreenShot("Screen shot of the " + enquiryTab + " Screen");
	}

	@Then("Verify the {string} tab in Enquiry Pagesssss")
	public void Enquiry_Page_Details_Verificataiondfghsjkl(String enquiryTab) throws Throwable {
		if (enquiryTab.equalsIgnoreCase("Product Details")) {
			library.elementstable(proposalPage.productDetailsTab);
			Wcontrol.clickJSEon(proposalPage.productDetailsTab);
			Wcontrol.scrollToView(enquiryPage.exportTo);

			Wcontrol.ActionMoveToElementClcik(enquiryPage.exportTo);
			Wcontrol.clickJSEon(enquiryPage.exportTo);
			Wcontrol.scrollDownLong();
			Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);
			Thread.sleep(500);
			Wcontrol.scrollDownLong();
			Wcontrol.clickJSEon(proposalPage.downloadButton);
		} else if (enquiryTab.equalsIgnoreCase("Premium Details")) {
			library.elementstable(proposalPage.premiumDetailsTab);
			Wcontrol.clickJSEon(proposalPage.premiumDetailsTab);
		} else if (enquiryTab.equalsIgnoreCase("Policy Values")) {

			library.elementstable(proposalPage.policyValueTab);
			Wcontrol.clickJSEon(proposalPage.policyValueTab);
			String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
			if (planDesc.equalsIgnoreCase("Future Invest")) {
				String fundValue = Wcontrol.GetTexton(proposalPage.PolicyfundValue).split("Value")[1].trim();
				System.out.println(fundValue);
			}
		} else if (enquiryTab.equalsIgnoreCase("Additional Details")) {
			Wcontrol.scrollToView(proposalPage.additionalEnqDetails);
			Wcontrol.clickJSEon(proposalPage.additionalEnqDetails);
			LoadingCondition();
			Wcontrol.scrollDownLong();
		} else {
			Wcontrol.scrollDownLong();
			Wcontrol.scrollDownLong();
			Wcontrol.scrollDownLong();
			library.elementstable(proposalPage.EnqLifeAssuredTab);
			Wcontrol.clickJSEon(proposalPage.EnqLifeAssuredTab);
			Wcontrol.scrollToView(proposalPage.lifeAssuredTable);
		}

		defins.takeScreenShot("Screen shot of the Enquiry Page");
	}

	@Then("Click on the Additional Details tab in Enquiry Pageff and goto {string}")
	public void Additional_Det(String content) throws Throwable {

		List<WebElement> DetList = Wcontrol.GetAllElements(proposalPage.additionalENQList);
		for (int i = 0; i < DetList.size(); i++) {
			String actualContent = Wcontrol.GetTexton(DetList.get(i)).trim();
			if (actualContent.equalsIgnoreCase(content)) {
				Wcontrol.scrollToView(DetList.get(i));
				Wcontrol.ActionMoveToElementClcik(DetList.get(i));
				break;
			}
		}
		defins.takeScreenShot("Screenshot of the Test....");
	}

	@Then("Validate Field with Blank Values")
	public void Validation_with_Blank_Values() throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			Thread.sleep(1000);
		}
		Wcontrol.clickJSEon(qualityCheck.Search);

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(2500);
		} else {
			Thread.sleep(1000);
		}

		String actualErrmsg = Wcontrol.GetTexton(enquiryPage.GEerror).trim();
		String expectedErrmsg = "Please fill atleast any one of the search field!";

//		Assert.assertEquals(expectedErrmsg, actualErrmsg);
		defins.takeScreenShot("ScreenShot of the test");
		Wcontrol.clickJSEon(qualityCheck.resetButton);

	}

	@Then("Validate with Invalid Values for {string}")
	public void Validate_field_with_invalid_Vaalues(String Tab) throws Throwable {
		By element = null;
		By searchElement = null;
		String expectedErrmsg = null;
		if (Tab.equalsIgnoreCase("Group Enquiry")) {
			element = enquiryPage.policyNumber;
			expectedErrmsg = "No Data Found";
			searchElement = qualityCheck.Search;
		} else if (Tab.equalsIgnoreCase("Agency Enquiry")) {
			element = enquiryPage.agentCode;
			expectedErrmsg = "No data found";
			searchElement = qualityCheck.Search;
		} else if (Tab.equalsIgnoreCase("Claim Enquiry")) {
			element = enquiryPage.policyNumber;
			expectedErrmsg = "No data found";
			searchElement = qualityCheck.Search;
		} else if (Tab.equalsIgnoreCase("Customer Enquiry")) {
			Wcontrol.clickJSEon(enquiryPage.CustomerSearch);
			defins.takeScreenShot("Screen Shot of the Test");
			Wcontrol.clickJSEon(qualityCheck.resetButton);

			element = enquiryPage.identificationNo;
			expectedErrmsg = "No records found for the search criteria entered";
			searchElement = enquiryPage.CustomerSearch;

		}

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(element);
			library.waitForClickableElement(element);
		}
		Wcontrol.sendkeysByAction(element, Generate_Random_Numbers());
		Wcontrol.clickJSEon(searchElement);

//		Thread.sleep(1000);
//		String actErr1 = Wcontrol.GetTexton(By.xpath("//mat-error")).trim();
//		String expErr1 = "Invalid Policy Number";
		String actualErrmsg = Wcontrol.GetTexton(enquiryPage.GEerror).trim();

//		Assert.assertEquals(expErr1, actErr1);
		Assert.assertEquals(expectedErrmsg, actualErrmsg);

		defins.takeScreenShot("ScreenShot of the test");
		Wcontrol.clickJSEon(qualityCheck.resetButton);
	}

	@Then("Enter the Number as {string} in {string} screen and Click on Search")
	public void Enter_Aget_Code(String number, String Screen) throws Throwable {
		By element = null;
		By searchElement = null;
		if (Screen.equalsIgnoreCase("Agency Enquiry")) {
			element = enquiryPage.agentCode;
			searchElement = qualityCheck.Search;
		} else if (Screen.equalsIgnoreCase("Customer Enquiry")) {
			element = enquiryPage.identificationNo;
			searchElement = enquiryPage.CustomerSearch;
		}

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(element);
			library.waitForClickableElement(element);
		}
		Wcontrol.sendkeysByAction(element, number);
		Wcontrol.clickJSEon(searchElement);

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(2500);
		} else {
			Thread.sleep(1000);
		}
	}

	@Then("Select the Enquiry Type and Validate all details")
	public void Other_Enquiries() throws Throwable {
		Wcontrol.clickJSEon(enquiryPage.enquiryList);
		List<WebElement> enqList = Wcontrol.GetAllElements(By.xpath("//mat-option"));
	}

	@Then("Enter the Policy Number {string} and Click on Search buttons for EnquiryPage")
	public void fetch_policy_in_Enquiry_Page(String policyNumber) throws Throwable {
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(enquiryPage.policyNumber);
			library.waitForClickableElement(enquiryPage.policyNumber);
		}
		Wcontrol.sendkeysByAction(enquiryPage.policyNumber, policyNumber);
		Wcontrol.clickJSEon(qualityCheck.Search);

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(2500);
		} else {
			Thread.sleep(1000);
		}
	}

	@Then("Get all the Details of the Customer")
	public void Customer_details_vaidation() throws Throwable {
		Thread.sleep(1000);
		Wcontrol.clickJSEon(enquiryPage.customerName);
		Thread.sleep(1000);
		Wcontrol.clickJSEon(enquiryPage.ViewIcon);
		Thread.sleep(1000);
		defins.takeScreenShot("Screen Shot of the Test");
		Wcontrol.scrollDownMin();
		defins.takeScreenShot("Screen Shot of the Test");
		Wcontrol.scrollDownLong();
		defins.takeScreenShot("Screen Shot of the Test");

	}

	@Then("validate {string} in {string} Section")
	public void Group_Enquiry_Screen(String enqTab, String Screen) throws Throwable {
		if (Screen.equalsIgnoreCase("Group Policy Details")) {
			group_enq_section(enqTab);
		} else if (Screen.equalsIgnoreCase("Agent Enquiry Details")) {
			library.elementstable(enquiryPage.particularChangeHistory);
			library.waitForClickableElement(enquiryPage.particularChangeHistory, 30);
			Thread.sleep(3000);
			Agency_enq_section(enqTab);
		} else if (Screen.equalsIgnoreCase("Claim Enquiry Details")) {
			Claim_enq_Section(enqTab);
		}

	}

	public void Claim_enq_Section(String enqTab) throws Throwable {
		if (enqTab.equalsIgnoreCase("Recovery/Refund/Acct")) {
			Wcontrol.scrollUPLong();
			Wcontrol.clickJSEon(enquiryPage.recoveryRefundAct);
			Thread.sleep(1500);
			Wcontrol.scrollDownMin();
			defins.takeScreenShot("Screen Shot of the Test");

		} else if (enqTab.equalsIgnoreCase("Provision/Payee")) {
			Wcontrol.scrollUPLong();
			Wcontrol.clickJSEon(enquiryPage.provisionPayee);
			Thread.sleep(1500);
			defins.takeScreenShot("Screen Shot of the Test");
			Wcontrol.scrollDownLong();
			defins.takeScreenShot("Screen Shot of the Test");

		} else if (enqTab.equalsIgnoreCase("Document")) {
			Wcontrol.scrollUPLong();

			Wcontrol.clickJSEon(enquiryPage.claimDocument);
			Thread.sleep(1500);
			defins.takeScreenShot("Screen Shot of the Test");

		} else if (enqTab.equalsIgnoreCase("Events/SubClaim")) {
			Wcontrol.scrollUPLong();

			Wcontrol.clickJSEon(enquiryPage.eventsSubClaim);
			Thread.sleep(1500);
			defins.takeScreenShot("Screen Shot of the Test");
			Wcontrol.scrollDownLong();
			defins.takeScreenShot("Screen Shot of the Test");

		} else if (enqTab.equalsIgnoreCase("Claim")) {
			Wcontrol.scrollUPLong();
			Wcontrol.clickJSEon(enquiryPage.claimTab);
			defins.takeScreenShot("Screen Shot of the Test");
			Wcontrol.scrollDownLong();
			defins.takeScreenShot("Screen Shot of the Test");
		}
	}

	public void Agency_enq_section(String enqTab) throws Throwable {
		if (enqTab.equalsIgnoreCase("Other Details")) {
			Wcontrol.scrollUPLong();
			Wcontrol.clickJSEon(enquiryPage.agentOtherDetails);
			Thread.sleep(1500);
			defins.takeScreenShot("Screen shot of the Test");

		} else if (enqTab.equalsIgnoreCase("Policies")) {
			Wcontrol.scrollUPLong();
			Wcontrol.clickJSEon(enquiryPage.agentPolicies);
			Thread.sleep(1500);
			defins.takeScreenShot("Screen shot of the Test");
			get_Agent_additional_Details(enqTab);

		} else if (enqTab.equalsIgnoreCase("Commission/Benefit")) {
			Wcontrol.scrollUPLong();
			Wcontrol.clickJSEon(enquiryPage.agentCommisions);
			Thread.sleep(1500);

			get_Agent_additional_Details(enqTab);

		} else if (enqTab.equalsIgnoreCase("Requirements")) {
			Wcontrol.scrollUPLong();
			Wcontrol.clickJSEon(enquiryPage.agentRequirements);
			Thread.sleep(1500);
			get_Agent_additional_Details(enqTab);

		} else if (enqTab.equalsIgnoreCase("Particulars")) {
			Wcontrol.scrollUPLong();
			Wcontrol.clickJSEon(enquiryPage.agentParticular);
			Thread.sleep(1500);
			defins.takeScreenShot("Screen shot of the Test");
			Wcontrol.scrollDownLong();
			Thread.sleep(500);
			defins.takeScreenShot("Screen shot of the Test");

		}

	}

	public void group_enq_section(String enqTab) throws Throwable {
		if (enqTab.equalsIgnoreCase("Accounting")) {
			Wcontrol.scrollUPLong();
			Wcontrol.clickJSEon(enquiryPage.GEaccounting);
			Thread.sleep(1500);
			Wcontrol.scrollDownMin();
			defins.takeScreenShot("ScreenShot of the Test");

		} else if (enqTab.equalsIgnoreCase("Premium")) {
			Wcontrol.scrollUPLong();
			Wcontrol.clickJSEon(enquiryPage.GEpremium);
			Thread.sleep(1500);
			defins.takeScreenShot("ScreenShot of the Test");
			Export_and_download(enqTab);

		} else if (enqTab.equalsIgnoreCase("Unit Rate")) {
			Wcontrol.scrollUPLong();
			Wcontrol.clickJSEon(enquiryPage.GEunitRate);
			Thread.sleep(1500);
			defins.takeScreenShot("ScreenShot of the Test");
			Export_and_download(enqTab);

		} else if (enqTab.equalsIgnoreCase("Individuals")) {
			Wcontrol.scrollUPLong();
			Wcontrol.clickJSEon(enquiryPage.GEinviduals);
			Thread.sleep(1500);
			defins.takeScreenShot("ScreenShot of the Test");
			Export_and_download(enqTab);

		} else if (enqTab.equalsIgnoreCase("Policy")) {
			Wcontrol.scrollUPLong();
			Wcontrol.clickJSEon(enquiryPage.GEpolicy);
			Thread.sleep(1000);
			defins.takeScreenShot("ScreenShot of the Test");
			Wcontrol.scrollDownLong();
			Wcontrol.scrollDownMin();
			Wcontrol.scrollDownLong();
			Export_and_download(enqTab);
			GetAdditionalDetails();

		} else if (enqTab.equalsIgnoreCase("Company")) {
			Wcontrol.scrollUPLong();
			Wcontrol.clickJSEon(enquiryPage.GEcompany);
			Thread.sleep(1500);
			defins.takeScreenShot("ScreenShot of the Test");
			Export_and_download(enqTab);
		}
	}

	public void GetAdditionalDetails() throws Throwable {
		Wcontrol.scrollDownLong();
		List<WebElement> additionalList = Wcontrol.GetAllElements(enquiryPage.GEadditionalDetails);
		for (int i = 0; i < additionalList.size(); i++) {
			Wcontrol.scrollToView(additionalList.get(i));
			Wcontrol.clickJSEon(additionalList.get(i));
			Thread.sleep(1500);
			String name = Wcontrol.GetTexton(additionalList.get(i)).trim();
			List<String> list = new ArrayList<String>();
			list.add("Fund Details");
			list.add("Experience Refund");
			list.add("Experience Rating Surplus");
			if (!list.contains(name)) {
				defins.takeScreenShot("Screen shot of the " + name + " in Additional Details");
				Wcontrol.scrollToView(enquiryPage.additionalDetailExport);
				Select_Format_and_Download(enquiryPage.additionalDetailExport, enquiryPage.pdf,
						enquiryPage.additionalDetailDownload);
				Select_Format_and_Download(enquiryPage.additionalDetailExport, enquiryPage.excel,
						enquiryPage.additionalDetailDownload);
				Select_Format_and_Download(enquiryPage.additionalDetailExport, enquiryPage.csv,
						enquiryPage.additionalDetailDownload);
			} else {
				continue;
			}
		}
	}

	public void Export_and_download(String enqTab) throws Throwable {

		if (enqTab.equalsIgnoreCase("Policy")) {
			Wcontrol.scrollDownMin();
			defins.takeScreenShot("Screenshot of the Test");
			Select_Format_and_Download(enquiryPage.policySeldectTypeOne, enquiryPage.pdf,
					enquiryPage.policyDownloadone);
			Select_Format_and_Download(enquiryPage.policySeldectTypeOne, enquiryPage.excel,
					enquiryPage.policyDownloadone);
			Select_Format_and_Download(enquiryPage.policySeldectTypeOne, enquiryPage.csv,
					enquiryPage.policyDownloadone);

		} else if (enqTab.equalsIgnoreCase("Unit Rate")) {
			Wcontrol.scrollDownMin();
			defins.takeScreenShot("Screenshot of the Test");
			Select_Format_and_Download(enquiryPage.policySeldectTypeOne, enquiryPage.pdf,
					enquiryPage.policyDownloadone);
			Select_Format_and_Download(enquiryPage.policySeldectTypeOne, enquiryPage.excel,
					enquiryPage.policyDownloadone);
			Select_Format_and_Download(enquiryPage.policySeldectTypeOne, enquiryPage.csv,
					enquiryPage.policyDownloadone);

			Wcontrol.scrollToView(enquiryPage.policyDownloadtwo);
			defins.takeScreenShot("Screenshot of the Test");
			Select_Format_and_Download(enquiryPage.policySelectTypeTwo, enquiryPage.pdf, enquiryPage.policyDownloadtwo);
			Select_Format_and_Download(enquiryPage.policySelectTypeTwo, enquiryPage.excel,
					enquiryPage.policyDownloadtwo);
			Select_Format_and_Download(enquiryPage.policySelectTypeTwo, enquiryPage.csv, enquiryPage.policyDownloadtwo);

		} else {
			Wcontrol.scrollToView(enquiryPage.exportTo);
			defins.takeScreenShot("Screenshot of the Test");
			Select_Format_and_Download(enquiryPage.selectDownloadType, enquiryPage.pdf, proposalPage.downloadButton);
			Select_Format_and_Download(enquiryPage.selectDownloadType, enquiryPage.excel, proposalPage.downloadButton);
			Select_Format_and_Download(enquiryPage.selectDownloadType, enquiryPage.csv, proposalPage.downloadButton);

		}

	}

	public void Select_Format_and_Download(By exportBtn, By fileFormat, By downloadBtn) throws Throwable {
		Thread.sleep(500);
		Wcontrol.ActionMoveToElement(exportBtn);
		Wcontrol.clickJSEon(exportBtn);
		Thread.sleep(500);
		Wcontrol.ActionMoveToElementClcik(fileFormat);
		Wcontrol.clickJSEon(downloadBtn);
	}

	@Then("Click on the Additional Details tab")
	public void Additional_Details_Tab() throws Throwable {
		Wcontrol.scrollToView(proposalPage.additionalEnqDetails);
		Wcontrol.clickJSEon(proposalPage.additionalEnqDetails);
		Wcontrol.scrollDownLong();
//		LoadingCondition();
	}

	@Then("Validate the {string}")
	public void Additional_Details_Tab_in_Enquiry_Page(String content) throws Throwable {

		base.getDriver().findElement(proposalPage.additionalDetailsSearch).clear();
		base.getDriver().findElement(proposalPage.additionalDetailsSearch).sendKeys(content);
		LoadingCondition();
		if (content.equalsIgnoreCase("Receipt Types")) {
			Wcontrol.clickJSEon(proposalPage.typeOfReceipt);
			String loc = Select_from_dropdown("Proposal Deposit");
			Wcontrol.MovejsClick(By.xpath(loc));
			Wcontrol.clickJSEon(proposalPage.receiptSearch);
			Wcontrol.scrollDownLong();
			defins.takeScreenShot("Screen shot of the Enquiry Page");
//			Wcontrol.scrollToView(proposalPage.additionalDetailsSearch);
		} else if (content.equalsIgnoreCase("Voucher")) {
//			String btn = "(//*[contains(text(),'Voucher')]/ancestor::app-voucher-button//table//tbody//td)[2]//span";
//			Wcontrol.clickJSEon(By.xpath(btn));
//			Wcontrol.scrollDownLong();
		} else {
			defins.takeScreenShot("Screen shot of the Enquiry Page");
		}

//		if(content.equalsIgnoreCase("Underwriting Question/Answer")) {
//			Wcontrol.sendkeysByAction(proposalPage.additionalDetailsSearch, content);
//			LoadingCondition();
//			defins.takeScreenShot("Screen shot of the Enquiry Page");
//			Wcontrol.scrollDownMin();
//			defins.takeScreenShot("Screen shot of the Enquiry Page");
//			Wcontrol.scrollDownMin();
//			defins.takeScreenShot("Screen shot of the Enquiry Page");
//			Wcontrol.scrollToView(proposalPage.additionalDetailsSearch);
//			Wcontrol.scrollUpMin();
//			
//		} else {
//			Wcontrol.sendkeysByAction(proposalPage.additionalDetailsSearch, content);
//			LoadingCondition();
//			Wcontrol.scrollDownLong();
//			defins.takeScreenShot("Screen shot of the Enquiry Page");
//		}

	}

	public void LoadingCondition() throws Throwable {
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(4000);
		} else {
			Thread.sleep(1500);
		}
	}

	@Then("Go to {string} Page By Search")
	public void Traverse_to_Desired_Enquiry(String searchContent) throws Throwable {
		By home = By.xpath("((//div//app-breadcrumb//nav//ol//li)[1]//a//i)[1]");
		Wcontrol.clickJSEon(home);
		By searchBox = By.xpath(
				"((//*[contains(text(),'"+base.getUserName()+"')])[1]/ancestor::*/parent::*/parent::*//*)//input[contains(@placeholder,' Search')]");
//		Wcontrol.MovejsClick(searchBox);
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(9000);
		} else {
			Thread.sleep(500);
		}
		WebElement element = base.getDriver().findElement(searchBox);
		JavascriptExecutor js = (JavascriptExecutor) base.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", element);

		base.getDriver().findElement(searchBox).sendKeys(searchContent);
//		element.sendKeys(searchContent);

		if (searchContent.equalsIgnoreCase("Underwriting")) {

			library.elementstable(proposalPage.planDescOption);
			library.waitForClickableElement(proposalPage.planDescOption, 50);
			Thread.sleep(1000);
			String click_loc = Select_from_dropdown("New Business > Individual > Underwriting");
			library.elementstable(By.xpath(click_loc));
			library.waitForVisibilityOfElement(By.xpath(click_loc));
			library.waitForClickableElement(By.xpath(click_loc));
			Wcontrol.MovejsClick(By.xpath(click_loc));
		} else {
//			Wcontrol.MovejsClick(proposalPage.planDescOption);
			Thread.sleep(1000);
			library.elementstable(searchBox);
			library.waitForClickableElement(searchBox, 50);
			if (base.environemt.equalsIgnoreCase("ILIVE")) {
				Thread.sleep(5000);
			} else {
				Thread.sleep(1000);
			}
			base.getDriver().findElement(searchBox).sendKeys(Keys.ENTER);
		}
	}

	@Then("Enter the Voucher Number and Click on Search button")
	public void Enter_the_VoucherNumbers_in_Enquiry_Page() throws Throwable {
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(qualityCheck.voucherNumber);
			library.waitForClickableElement(qualityCheck.voucherNumber);
		}

		Wcontrol.sendkeysByAction(qualityCheck.voucherNumber, proposalStep.returnedVoucherNumber);
		Wcontrol.clickJSEon(qualityCheck.Search);
		Wcontrol.scrollDownLong();
		Wcontrol.scrollDownMin();
		Wcontrol.scrollDownLong();
		defins.takeScreenShot("Screen shot of Voucher Details");
		Wcontrol.clickJSEon(By.xpath("(//*[contains(text(),'Additional Voucher Details')])[1]"));
		Wcontrol.scrollDownLong();
		Wcontrol.scrollDownMin();
		Wcontrol.scrollDownLong();
		defins.takeScreenShot("Screen shot of Additional Voucher Details");
	}

	@Then("Validate Policy to Proposal Screen")
	public void Validate_Policy_to_Proposal_Screen() throws Throwable {
		library.elementstable(registrationPage.dialogboxOK);
		library.waitForPresenceOfElement(registrationPage.dialogboxDetails, 30);
		library.waitForClickableElement(registrationPage.dialogboxOK, 30);
		String expectedError = "NB227 - CANNOT REVERT THE POLICY. NO OF DAYS HAS EXCEEDED THE LIMIT !";

		String actualError = Wcontrol.GetTexton(By.xpath("//h4")).trim();

		Assert.assertEquals(expectedError, actualError);
		defins.takeScreenShot("Validation Screen shot>...........");
		Wcontrol.clickJSEon(registrationPage.dialogboxOK);
	}

	@Then("Change the Policy Commencement Date")
	public void Change_the_Policy_Commencement_Date() throws Throwable {
		String UdateDateQuery = library.todaysDate();
//		String date = UdateDateQuery.replaceAll(",", "");
		String newQuery = UdateDateQuery.split("-")[0] + "-" + UdateDateQuery.split("-")[1] + "-"
				+ Integer.toString(Integer.parseInt(UdateDateQuery.split("-")[2].trim().replaceAll("'", "")) + 5);
		String UpdatedQuery = "alter system set fixed_date = " + "'" + newQuery + "'";
		System.out.println(UpdatedQuery);
		library.query(UpdatedQuery);
		
//		String PremiumBatchQuery = "begin gen_outstanding_prem_test(user,user,sysdate,"+"'"+proposalStep.returnedPolicyNumber+"');end;";
//		library.query(PremiumBatchQuery);
//		library.query("Commit");
		
	}

	@Then("Enter the Policy Number in Policy to Proposal Page")
	public void PolicyToProposal() throws Throwable {
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(qualityCheck.policyNumber);
			library.waitForClickableElement(qualityCheck.policyNumber, 20);
		}
		Thread.sleep(1500);
		Wcontrol.clickJSEon(qualityCheck.policyNumber);
		Wcontrol.sendkeysByAction(qualityCheck.policyNumber, proposalStep.returnedPolicyNumber);
//		Wcontrol.clickJSEon(proposalPage.planDescOption);
		Thread.sleep(1000);
	}

	@Then("Enter the Policy Number and Click on Search buttons")
	public void Enter_the_PolicyNumberss_in_QualityCheck_Page() throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
//			library.waitForInVisibilityOfElement(commonPage.animation);
			Thread.sleep(10000);
		} else {
			library.elementstable(qualityCheck.policyNumber);
			library.waitForClickableElement(qualityCheck.policyNumber);
		}
		Wcontrol.EnterValueon(qualityCheck.policyNumber, proposalStep.returnedPolicyNumber);
//		Wcontrol.EnterValueon(qualityCheck.policyNumber, "TL202307309481");
		Wcontrol.clickJSEon(qualityCheck.Search);
	}

	@Then("Enter the Policy Number as {string} and Click on Search button")
	public void Enter_the_PolicyNumber_as_something_in_QualityCheck_Page(String policyNumber) throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(qualityCheck.policyNumber);
			library.waitForClickableElement(qualityCheck.policyNumber);
		}
		Wcontrol.sendkeysByAction(qualityCheck.policyNumber, policyNumber);
		Wcontrol.clickJSEon(qualityCheck.Search);

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(2500);
		} else {
			Thread.sleep(1000);
		}
	}

	@Then("Select the date and Click on Search the buttonsss")
	public void click_on_Search() throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(qualityCheck.fromDate);
		}
		Wcontrol.sendkeysByAction(qualityCheck.fromDate, "08/03/2022");
		Wcontrol.sendkeysByAction(qualityCheck.toDate, getSystemDate());
		Wcontrol.clickJSEon(qualityCheck.Search);

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(3000);
		} else {
			Thread.sleep(1000);
		}
	}

	@Then("Get Policy to Dispatch")
	public void policyFilterSearch() throws Throwable {
		Thread.sleep(500);
		Wcontrol.sendkeysByAction(qualityCheck.filterSearch, proposalStep.returnedPolicyNumber);
		Wcontrol.EnterKeyon(qualityCheck.filterSearch, Keys.ENTER);
	}

	@And("Tick the Check box")
	public void Approve_the_Quality() throws Throwable {

//		String name = Exceldata.TestDataInMap.get("FirstName") + " "+Exceldata.TestDataInMap.get("MiddleName")+" "+Exceldata.TestDataInMap.get("LastName");
//		String actualNAme = Wcontrol.GetTexton(qualityCheck.name);
//		if(name.equalsIgnoreCase(actualNAme)) {
//			Wcontrol.clickJSEon(qualityCheck.checkBox);
//		}
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(2000);
		} else {
			library.elementstable(qualityCheck.checkBox);
			library.waitForClickableElement(qualityCheck.checkBox);
		}
		Thread.sleep(1000);
		Wcontrol.clickJSEon(qualityCheck.checkBox);
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(1000);
		}
		defins.takeScreenShot("Screen shot of the Test");

	}

	@Then("Get the Policy to Acknowledge")
	public void PoilcyToAcknowledge() throws Throwable {
		library.elementstable(qualityCheck.policyNumberFrom);
		library.waitForClickableElement(qualityCheck.policyNumberFrom, 30);

		Wcontrol.sendkeysByAction(qualityCheck.policyNumberFrom, proposalStep.returnedPolicyNumber);
		Wcontrol.sendkeysByAction(qualityCheck.policyNumberTo, proposalStep.returnedPolicyNumber);
//		Wcontrol.clearText(qualityCheck.agentName);
//		Wcontrol.clearText(qualityCheck.UnitNo);

//		String sysdate = getSystemDate();
//		Wcontrol.sendkeysByAction(qualityCheck.dispatchFrom, sysdate);
		Wcontrol.MovejsClick(qualityCheck.Search);
//		
//		Wcontrol.sendkeysByAction(qualityCheck.filterSearch, proposalStep.returnedPolicyNumber);
//		Wcontrol.EnterKeyon(qualityCheck.filterSearch, Keys.ENTER);
	}

	@Then("Get the Payable Amount")
	public void get_the_Payable_Amount() throws Throwable {
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(3000);
		} else {
			Thread.sleep(2000);
			library.elementstable(proposalPage.amountPayable);
			
		}

		String amount = Wcontrol.GetTexton(proposalPage.amountPayable).trim();
		amountPayable = amount.replaceAll(",", "");

	}

	@Then("Select the Instrument Details")
	public void Instrument_Details() throws Throwable {
//		Wcontrol.clickJSEon(proposalPage.addInstrumentDetails);
		Wcontrol.clickJSEon(proposalPage.addInstrumentDetails);
		library.elementstable(proposalPage.instrumentType);
		library.waitForClickableElement(proposalPage.instrumentType);
//		Wcontrol.clickJSEon(proposalPage.instrumentType);
		Wcontrol.clickJSEon(proposalPage.instrumentType);
		String click_loc = Select_from_dropdown("CASH");
		Wcontrol.clickJSEon(By.xpath(click_loc));
//		base.getDriver().findElement(By.xpath(click_loc)).click();
//		Wcontrol.clickJSEon(proposalPage.instrumentCurrency);
		library.waitForClickableElement(proposalPage.instrumentCurrency);
		Wcontrol.clickJSEon(proposalPage.instrumentCurrency);
//		String click_loc1 = Select_from_dropdown("MALAYSIAN RINGITT");
//		base.getDriver().findElement(By.xpath(click_loc1)).click();
		String newCurrency = base.getDriver().findElement(By.xpath("(//*[contains(text(),'Policy Currency')]/ancestor::th/ancestor::table//tbody//td)[6]")).getText().trim();
		
		Wcontrol.clearText(proposalPage.instrumentCurrency);
		Wcontrol.sendkeysByAction(proposalPage.instrumentCurrency, newCurrency);
//		Wcontrol.EnterKeyon(proposalPage.instrumentCurrency, Keys.ENTER);
		library.waitForClickableElement(proposalPage.instrumentAmount);
		Wcontrol.sendkeysByAction(proposalPage.instrumentAmount, amountPayable);
//		Thread.sleep(1000);
//		Wcontrol.clickJSEon(proposalPage.instrumentTick);
		library.waitForClickableElement(proposalPage.instrumentTick);
		Wcontrol.clickJSEon(proposalPage.instrumentTick);
		defins.takeScreenShot("Screen shot of the Issue Receipt Screen.....");
	}

	public String Select_from_dropdown(String content) throws Throwable {
		String opts_loc = null;
		String click_loc = null;
		Thread.sleep(1000);
		List<WebElement> TypeOpts = base.getDriver().findElements(By.xpath("//mat-option"));
		for (int i = 0; i < TypeOpts.size(); i++) {
			opts_loc = "(//mat-option)[" + (i + 1) + "]";
			String name = Wcontrol.GetTexton(By.xpath(opts_loc));
			if (name.equalsIgnoreCase(content)) {
				click_loc = "(//mat-option)[" + (i + 1) + "]";
				break;
			}
		}
		return click_loc;
	}

	@And("Select the Check box for bulk policies")
	public void bulk_Policies() throws Throwable {
		Wcontrol.scrollDownLong();
		Wcontrol.clickJSEon(qualityCheck.policyIssueRecords);
		Wcontrol.ActionMoveToElementClcik(proposalPage.opt);

		List<WebElement> checkbox = Wcontrol.GetAllElements(qualityCheck.checkBox);

		Wcontrol.clickJSEon(checkbox.get(0));
		Wcontrol.clickJSEon(checkbox.get(1));
//		Wcontrol.clickJSEon(checkbox.get(6));
		Wcontrol.scrollDownLong();

//		List<WebElement> policies = Wcontrol.GetAllElements(qualityCheck.policyNumbers);

//		String[] policy_Num = { "TL202307257946", "TL202307257994", "TL202307258020" };
//		List<String> policy_Numbers = Arrays.asList(policy_Num);
//		int count = 0;
//		for (int i = 0; i < checkbox.size(); i++) {
//			String Pnum = Wcontrol.GetTexton(policies.get(i)).trim();
//			if (policy_Numbers.contains(Pnum)) {
//				Wcontrol.clickJSEon(checkbox.get(i));
//				count++;
//			}
//
//			if (count > policy_Numbers.size()) {
//				break;
//			}
//		}
	}

	@Then("Select the Quality Check Value")
	public void QualityCheck_Value() throws Throwable {
		String opt = CustomerExceldata.TestDataInMap.get("QualityCheckOption");
		Wcontrol.clickJSEon(qualityCheck.qualityOptions);
		Thread.sleep(500);
		if (opt.equalsIgnoreCase("Yes")) {
			Wcontrol.ActionMoveToElementClcik(qualityCheck.qualityYes);
		} else {
			Wcontrol.ActionMoveToElementClcik(qualityCheck.qualityNo);
		}

	}
	
	@Then("click ok on the Dispatch popup")
	public void Click_OK_on_Popup_Dispatch() throws Throwable {
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(3000);
		} else {
			Thread.sleep(1000);
		}
		
		Wcontrol.clickJSEon(By.xpath("//*[contains(text(),'Dispatch')]/ancestor::app-common-dialog-box//*[contains(text(),'OK')]"));
	}
	

	@Then("click ok on the final popup")
	public void Click_OK_on_Popup() throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(3000);
		} else {
			Thread.sleep(1000);
		}
		defins.takeScreenShot("Screen shot of the Policy Issue Page");
		library.waitForClickableElement(qualityCheck.ok);
//		Wcontrol.ActionMoveToElement(qualityCheck.ok);
//		Wcontrol.clickJSEon(qualityCheck.ok);
		Wcontrol.MovejsClick(qualityCheck.ok);
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
//			library.waitForInVisibilityOfElement(commonPage.animation);
			Thread.sleep(13000);
		} else {
			Thread.sleep(700);
		}
	}

	@Then("Take ScreenShot in the Additional Details Enquiry Page")
	public void TakeSSoftheAD() throws Throwable {
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(2500);
		} else {
			By path = By.xpath("(//*[contains(text(),'Life Assured Name')])[1]");
			library.elementstable(path);

		}

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			Thread.sleep(2000);
		}
		defins.takeScreenShot("Screen shot of the Enquiry Page");
	}

	@And("Take ScreenShot in the Enquiry Page")
	public void Screenshot_in_the_Enquiry_Page() throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			By path = By.xpath("(//*[contains(text(),'Agent Code')])[1]/parent::div//app-redirect-to-url//a");
			library.elementstable(path);
			library.waitForClickableElement(path, 30);
		}
		defins.takeScreenShot("Screen shot of the Enquiry Page");
		Wcontrol.scrollDownMin();
		Wcontrol.scrollDownMin();
		Wcontrol.scrollDownLong();
	}

	@And("Take ScreenShot in the Enquiry Page UI")
	public void Screenshot_in_the_Enquiry_Page_UI() throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			Thread.sleep(1000);
		}
		defins.takeScreenShot("Screen shot of the Enquiry Page");
	}

	// ------------------------------------------------Additional---------------------------------

	public int GetPremiumTerms(int age) {
		int payTerm = 5;
		for (int i = 55; i > 14; i--) {
			if (i == age) {
				break;
			} else {
				payTerm++;
				continue;
			}
		}
		return payTerm;
	}

	public int GetpolicyTerm(int age) {
		int Term = 84;
		for (int i = 16; i < 56; i++) {
			if (i == age) {
				break;
			} else {
				Term--;
				continue;
			}
		}
		return Term;
	}

//	public int Get_Age_of_the_customer() {
//		Date date = Calendar.getInstance().getTime();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//		String strDate = dateFormat.format(date);
//		String date1 = strDate.split("-")[0];
//		String date2 = Exceldata.TestDataInMap.get("DateOfBirth").split("/")[2];
//
//		int s1 = Integer.parseInt(date1);
//		int s2 = Integer.parseInt(date2);
//		int age = s1 - s2;
//		return age;
//	}

	public int Get_Age_of_the_customer() {
		LocalDate currentDate = LocalDate.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = currentDate.format(formatter);
		System.out.println(formattedDate);
		String date1 = formattedDate.split("-")[0];
		String date2 = CustomerExceldata.TestDataInMap.get("DateOfBirth").split("/")[2];

		int s1 = Integer.parseInt(date1);
		int s2 = Integer.parseInt(date2);
		int age = s1 - s2;
		return age;
	}

	public String getSystemDate() {
		LocalDate currentDate = LocalDate.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = currentDate.format(formatter);
		return formattedDate;
	}

	public void Last_Process() throws Throwable {
		Wcontrol.scrollToView(proposalPage.process);
		Wcontrol.clickJSEon(proposalPage.process);
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			Thread.sleep(500);
			library.elementstable(By.xpath("//*[contains(text(),'Pop Out')]"));
			library.waitForClickableElement(By.xpath("//*[contains(text(),'Pop Out')]"));
			library.waitForClickableElement(By.xpath("//*[text()=' Save ']"));
		}
	}

	public void Add_Optional_Rider(int temp) throws Throwable {
		move_to_LA_Tab();
		library.elementstable(proposalPage.LifeAssuredView);
		library.waitForClickableElement(proposalPage.LifeAssuredView, 30);
		Wcontrol.clickJSEon(proposalPage.LifeAssuredView);
		library.elementstable(proposalPage.Save);
		library.waitForClickableElement(proposalPage.Save, 30);
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(4000);
		} else {
			library.elementstable(proposalPage.BasePlan);
			library.waitForClickableElement(proposalPage.BasePlan);
		}

		Wcontrol.scrollDownLong();
		Wcontrol.scrollDownMin();
		
		JavascriptExecutor js = (JavascriptExecutor) base.getDriver();
	       js.executeScript("window.scrollBy(0,100)", "");
	       Thread.sleep(500);

		
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        System.out.println("Screen Width: " + screenSize.getWidth());
        System.out.println("Screen Height: " + screenSize.getHeight());
        
        int RoundedWidth = (int) Math.round(screenSize.getWidth());
        int RoundedHeight = (int) Math.round(screenSize.getHeight());
        
        Width = Integer.toString(RoundedWidth);
        Height = Integer.toString(RoundedHeight);
        
//		Wcontrol.scrollToView(proposalPage.BasePlan);
		library.waitForClickableElement(proposalPage.optionalRiders, 30);

		WebElement element = base.getDriver().findElement(proposalPage.optionalRiders);
//		Wcontrol.ActionMoveToElement(element);
		JavascriptExecutor executor = (JavascriptExecutor) base.getDriver();
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Wcontrol.scrollDownLittle();
//		RiderExceldata
		Name1 = RiderExceldata.TestDataInMap.get("RiderName1");
		Name2 = RiderExceldata.TestDataInMap.get("RiderName2");
		String Rider_Term = RiderExceldata.TestDataInMap.get("RiderTerm");
		String Rider_SA = RiderExceldata.TestDataInMap.get("RiderSumAssured");
		String check_loc = null;
		String edit_loc = null;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			int ch = 0;
			List<WebElement> riderNames = Wcontrol.GetAllElements(proposalPage.ridersDetailsName);

			for (int j = 0; j < riderNames.size(); j++) {
				String riderName_Loc = "((//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//table)[1]//tbody//tr//td[2])"
						+ "[" + (j + 1) + "]";
				String name = base.getDriver().findElement(By.xpath(riderName_Loc)).getText();
				if (name.equalsIgnoreCase(Name1) || name.equalsIgnoreCase(Name2)) {
					check_loc = "(//tbody//tr//td//mat-checkbox//input[@type='checkbox']/parent::span)" + "[" + (j + 1)
							+ "]";
					edit_loc = "(//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//mat-icon[contains(text(),'edit')])"
							+ "[" + (j + 1) + "]";
					ch++;
					break;
				}
			}

			if (ch > 0) {
				break;
			} else {
				Wcontrol.clickJSEon(proposalPage.nextPaginator);
			}

		}
		base.getDriver().findElement(By.xpath(check_loc)).click();
		base.getDriver().findElement(By.xpath(edit_loc)).click();

		String term = "(//*[contains(text(),'Optional Rider')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Term')]/parent::label/parent::span/parent::div//input)[1]";
		String PremiumTerm = "(//*[contains(text(),'Optional Rider')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Premium Term')]/parent::label/parent::span/parent::div//input)[1]";
		String sumAssured = "(//*[contains(text(),'Optional Rider')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Sum Assured')]/parent::label/parent::span/parent::div//input)[1]";
		String Save = "//*[contains(text(),'Optional Rider')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Save')]";
		
//		List<WebElement> values = Wcontrol.GetAllElements(By.xpath(Save));
		
		
		
		js.executeScript("window.scrollBy(0,-100)", "");
		
		if(Width.equalsIgnoreCase("1366") && Height.equalsIgnoreCase("768")) {
			Wcontrol.EnterValueon(By.xpath(term), Rider_Term);
			Wcontrol.EnterValueon(By.xpath(PremiumTerm), Rider_Term);
			Wcontrol.EnterValueon(By.xpath(sumAssured), Rider_SA);
			Wcontrol.clickJSEon(By.xpath(Save));
		} else {
			Wcontrol.EnterValueon(proposalPage.optionalRiderTermInput, Rider_Term);
			Wcontrol.EnterValueon(proposalPage.optionalRiderPremiumTerm, Rider_Term);
			Wcontrol.EnterValueon(proposalPage.optionalRiderSA, Rider_SA);
			Wcontrol.clickJSEon(proposalPage.optionalRiderTick);
		}
		
		defins.takeScreenShot("Screen Shot for the test");
		Wcontrol.clickJSEon(proposalPage.riderNext);

		Wcontrol.scrollToView(proposalPage.Save);
		Wcontrol.clickJSEon(proposalPage.Save);
	}

	public void move_to_LA_Tab() throws Throwable {
		library.elementstable(By.xpath("//*[contains(text(),'Pop Out')]"));
		library.waitForClickableElement(By.xpath("//*[contains(text(),'Pop Out')]"));
		Wcontrol.clickJSEon(proposalPage.LifeTab);

	}

	public void Add_Multiple_Optional_Rider(String planDesc) throws Throwable {
		move_to_LA_Tab();
		library.elementstable(proposalPage.LifeAssuredView1);
		library.waitForClickableElement(proposalPage.LifeAssuredView1, 30);
		Wcontrol.clickJSEon(proposalPage.LifeAssuredView1);
		library.elementstable(proposalPage.Save);
		library.waitForClickableElement(proposalPage.Save, 30);
		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(4000);
		} else {
			library.elementstable(proposalPage.BasePlan);
			library.waitForClickableElement(proposalPage.BasePlan);
		}

		Wcontrol.scrollDownLong();
		Wcontrol.scrollDownMin();
		
		JavascriptExecutor js = (JavascriptExecutor) base.getDriver();
	       js.executeScript("window.scrollBy(0,100)", "");
	       Thread.sleep(500);

		
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        System.out.println("Screen Width: " + screenSize.getWidth());
        System.out.println("Screen Height: " + screenSize.getHeight());
        
        int RoundedWidth = (int) Math.round(screenSize.getWidth());
        int RoundedHeight = (int) Math.round(screenSize.getHeight());
        
        Width = Integer.toString(RoundedWidth);
        Height = Integer.toString(RoundedHeight);
        
//		Wcontrol.scrollToView(proposalPage.BasePlan);
		library.waitForClickableElement(proposalPage.optionalRiders, 30);

		WebElement element = base.getDriver().findElement(proposalPage.optionalRiders);
//		Wcontrol.ActionMoveToElement(element);
		JavascriptExecutor executor = (JavascriptExecutor) base.getDriver();
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Wcontrol.scrollDownLittle();
//		RiderExceldata
		Name1 = RiderExceldata.TestDataInMap.get("RiderName3");
		Name2 = RiderExceldata.TestDataInMap.get("RiderName4");
		String Rider_Term = RiderExceldata.TestDataInMap.get("RiderTerm");
		String Rider_SA = RiderExceldata.TestDataInMap.get("RiderSumAssured");
		String check_loc = null;
		String edit_loc = null;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			int ch = 0;
			List<WebElement> riderNames = Wcontrol.GetAllElements(proposalPage.ridersDetailsName);

			for (int j = 0; j < riderNames.size(); j++) {
				String riderName_Loc = "((//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//table)[1]//tbody//tr//td[2])"
						+ "[" + (j + 1) + "]";
				String name = base.getDriver().findElement(By.xpath(riderName_Loc)).getText();
				if (name.equalsIgnoreCase(Name1) || name.equalsIgnoreCase(Name2)) {
					check_loc = "(//tbody//tr//td//mat-checkbox//input[@type='checkbox']/parent::span)" + "[" + (j + 1)
							+ "]";
					edit_loc = "(//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//mat-icon[contains(text(),'edit')])"
							+ "[" + (j + 1) + "]";
					ch++;
					break;
				}
			}

			if (ch > 0) {
				break;
			} else {
				Wcontrol.clickJSEon(proposalPage.nextPaginator);
			}

		}
		base.getDriver().findElement(By.xpath(check_loc)).click();
		base.getDriver().findElement(By.xpath(edit_loc)).click();

		String term = "(//*[contains(text(),'Optional Rider')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Term')]/parent::label/parent::span/parent::div//input)[1]";
		String PremiumTerm = "(//*[contains(text(),'Optional Rider')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Premium Term')]/parent::label/parent::span/parent::div//input)[1]";
		String sumAssured = "(//*[contains(text(),'Optional Rider')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Sum Assured')]/parent::label/parent::span/parent::div//input)[1]";
		String Save = "//*[contains(text(),'Optional Rider')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Save')]";
		
//		List<WebElement> values = Wcontrol.GetAllElements(By.xpath(Save));
		
		
		
		js.executeScript("window.scrollBy(0,-100)", "");
		
		if(Width.equalsIgnoreCase("1366") && Height.equalsIgnoreCase("768")) {
			Wcontrol.EnterValueon(By.xpath(term), Rider_Term);
			Wcontrol.EnterValueon(By.xpath(PremiumTerm), Rider_Term);
			Wcontrol.EnterValueon(By.xpath(sumAssured), Rider_SA);
			Wcontrol.clickJSEon(By.xpath(Save));
		} else {
			Wcontrol.EnterValueon(proposalPage.optionalRiderTermInput, Rider_Term);
			Wcontrol.EnterValueon(proposalPage.optionalRiderPremiumTerm, Rider_Term);
			Wcontrol.EnterValueon(proposalPage.optionalRiderSA, Rider_SA);
			Wcontrol.clickJSEon(proposalPage.optionalRiderTick);
		}
		
		defins.takeScreenShot("Screen Shot for the test");
		Wcontrol.clickJSEon(proposalPage.riderNext);

		Wcontrol.scrollToView(proposalPage.Save);
		Wcontrol.clickJSEon(proposalPage.Save);
	}
	

	public void Underwriting_Questions_Response() throws Throwable {
		Wcontrol.click_and_Select(proposalPage.UWQrecords, proposalPage.opt);

		List<WebElement> questions = Wcontrol.GetAllElements(proposalPage.questionsUW);
		List<WebElement> UWQedit = Wcontrol.GetAllElements(proposalPage.UWQedit);
		String actual = "Are you employed in the armed forces or intending to join the arm forces.";
		for (int i = 0; i < questions.size(); i++) {
			String Qus = Wcontrol.GetTexton(questions.get(i)).trim();
			if (Qus.equalsIgnoreCase(actual)) {
				Wcontrol.clickJSEon(UWQedit.get(i));
				Wcontrol.click_and_Select(proposalPage.UWQreplyChoice, proposalPage.planDescOption);
				Thread.sleep(500);
				Wcontrol.clickJSEon(proposalPage.UWQreplyDetails);
				Wcontrol.sendkeysByAction(proposalPage.UWQreplyDetails, "Intending to join the arm forces");
				Wcontrol.clickJSEon(proposalPage.UWQtick);
				break;
			}
		}
	}

	public String Generate_Random_Numbers() {
		Random random = new Random();

		int x = random.nextInt(900000000) + 100000000;
		int y = random.nextInt(9000) + 1000;

		String accountNumber = Integer.toString(x) + Integer.toString(y);
		return accountNumber;
	}

	public String Get_Credit_Card_Number() {
		Random random = new Random();
		String a = Generate_Random_Numbers();
		int Z = random.nextInt(900) + 100;
		String CardNo = a + Integer.toString(Z);
		return CardNo;
	}

	public String get_from_date() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = currentDate.format(formatter);
		return formattedDate;
	}

	public String get_To_date() {
		String formattedDate = get_from_date();

		int integerNumber = Integer.parseInt(formattedDate.split("/")[2]);
		System.out.println(integerNumber + 18);

		String toDate = formattedDate.split("/")[0] + "/" + formattedDate.split("/")[1] + "/"
				+ Integer.toString(integerNumber + 18);
		return toDate;
	}

	public void add_nominee(String NomineeID, String Idnumber, String Relation) throws Throwable {
		library.waitForVisibilityOfElement(proposalPage.nomineeIdentity, 50);
		Wcontrol.Click_and_ClearTextOn(proposalPage.nomineeIdentity);
		Wcontrol.sendkeysByAction(proposalPage.nomineeIdentity, NomineeID);

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(4000);
		} else {
			Thread.sleep(1500);
			library.elementstable(proposalPage.nomineeIdentityNumber);
			library.waitForClickableElement(proposalPage.nomineeIdentityNumber);
		}
		Wcontrol.Click_and_ClearTextOn(proposalPage.nomineeIdentityNumber);
		Wcontrol.sendkeysByAction(proposalPage.nomineeIdentityNumber, Idnumber);

		library.waitForVisibilityOfElement(proposalPage.nomineeRelation, 60);
		Wcontrol.Click_and_ClearTextOn(proposalPage.nomineeRelation);
		Wcontrol.sendkeysByAction(proposalPage.nomineeRelation, Relation);
		Thread.sleep(1000);
//		for(int i=0;i<Integer.MAX_VALUE;i++) {
//			base.getDriver().findElement(proposalPage.nomineeRelation).sendKeys(Keys.DOWN);
//			String loc = "(//mat-option)["+(i+1)+"]";
//			String value =base.getDriver().findElement(By.xpath(loc)).getAttribute("value");
//			if(value.equalsIgnoreCase(Relation)) {
//				base.getDriver().findElement(proposalPage.nomineeRelation).sendKeys(Keys.ENTER);
//				break;
//			}
//		}

		if (Relation.equalsIgnoreCase("Son")) {
//			for (int i = 0; i < 2; i++) {
//				base.getDriver().findElement(proposalPage.nomineeRelation).sendKeys(Keys.DOWN);
//			}
//			base.getDriver().findElement(proposalPage.nomineeRelation).sendKeys(Keys.ENTER);
			Wcontrol.clickJSEon(By.xpath("//mat-option[3]"));
		} else if (Relation.equalsIgnoreCase("Daughter")) {
//			base.getDriver().findElement(proposalPage.nomineeRelation).sendKeys(Keys.ENTER);
			Wcontrol.clickJSEon(By.xpath("//mat-option[1]"));
		} else if (Relation.equalsIgnoreCase("Friend")) {
			Wcontrol.clickJSEon(By.xpath("//mat-option[1]"));
		}

//		List<WebElement> relationOptions = Wcontrol.GetAllElements(By.xpath("//mat-option"));
//		for (int i = 0; i < relationOptions.size(); i++) {
//			String relation = Wcontrol.GetTexton(relationOptions.get(i));
//			if (relation.equalsIgnoreCase("DAUGHTER") || relation.equalsIgnoreCase("DAUGHTER(DA)")
//					|| relation.equalsIgnoreCase("SON(SO)") || relation.equalsIgnoreCase("SON")) {
//				Wcontrol.ActionMoveToElementClcik(relationOptions.get(i));
//				break;
//			}
//		}

		Thread.sleep(1500);
		Wcontrol.EnterValueon(proposalPage.benefitShare, CustomerExceldata.TestDataInMap.get("BenifitShare"));
		Wcontrol.clickJSEon(proposalPage.tick2);
		defins.takeScreenShot("Screen Shot for the test");
	}

	public void Rider_Loading_Details() throws Throwable {
//		Wcontrol.scrollDownLittle();
		Wcontrol.clickJSEon(proposalPage.riderLoadingScreen);
//		List<WebElement> charges = Wcontrol.GetAllElements(proposalPage.riderCharges);
//		for (int i = 0; i < charges.size(); i++) {
//			Wcontrol.clickJSEon(charges.get(i));
//			if (base.getDriver().findElements(proposalPage.riderLoadingTable).size() == 0) {
//				library.elementstable(proposalPage.riderLoadingButton);
//				library.waitForClickableElement(proposalPage.riderLoadingButton);
//				Wcontrol.clickJSEon(proposalPage.riderLoadingButton);
//				break;
//			}
//		}
		String charges_loc = "(//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//*[contains(text(),'Rider Events ')]/parent::div//table//tbody//tr//*[contains(text(),'Charges')])[1]";

		Wcontrol.clickJSEon(By.xpath(charges_loc));
		library.elementstable(proposalPage.riderLoadingButton);
		library.waitForClickableElement(proposalPage.riderLoadingButton, 20);
		Wcontrol.scrollDownMin();
		Wcontrol.clickJSEon(proposalPage.riderLoadingButton);

//		Wcontrol.scrollToView(proposalPage.riderLoadingClose);
		Wcontrol.clickJSEon(proposalPage.riderAddLoading);
		Wcontrol.scrollDownLittle();
		By Save = By.xpath(
				"//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Save')]");

//		boolean value = base.getDriver().findElement(Save).isDisplayed();

		if(Width.equalsIgnoreCase("1366") && Height.equalsIgnoreCase("768")) {

			By loadingSource = By.xpath(
					"//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Loading Source')]/parent::label/parent::span/parent::div//input");
			By loadingCriteria = By.xpath(
					"//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Loading Criteria')]/parent::label/parent::span/parent::div//input");
			By loadingValue = By.xpath(
					"//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Loading Value')]/parent::label/parent::span/parent::div//input");

			Wcontrol.sendkeysByAction(loadingSource, "HEALTH");
			Wcontrol.clickJSEon(proposalPage.opt);
//		Wcontrol.click_and_Select(proposalPage.riderLoadingCriteria, underWritingPage.fixedAmount);
			Wcontrol.clickJSEon(loadingCriteria);
			Wcontrol.clickJSEon(loadingCriteria);
			Wcontrol.clickJSEon(underWritingPage.fixedAmount);
			Wcontrol.sendkeysByAction(loadingValue, "100");
			Wcontrol.clickJSEon(Save);

		} else {

			Wcontrol.sendkeysByAction(proposalPage.riderLoadingSource, "HEALTH");
			Wcontrol.ActionMoveToElementClcik(proposalPage.opt);
//		Wcontrol.click_and_Select(proposalPage.riderLoadingCriteria, underWritingPage.fixedAmount);
			Wcontrol.clickJSEon(proposalPage.riderLoadingCriteria);
			Wcontrol.clickJSEon(proposalPage.riderLoadingCriteria);
			Wcontrol.ActionMoveToElementClcik(underWritingPage.fixedAmount);
			Wcontrol.sendkeysByAction(proposalPage.riderLoadingValue, "100");
			Wcontrol.clickJSEon(proposalPage.riderLoadingTick);
		}
	}

	public void Add_Exclusion(String exclusionType) throws Throwable {
		Wcontrol.scrollUpMin();
		JavascriptExecutor js = (JavascriptExecutor) base.getDriver();
		js.executeScript("window.scrollBy(0,100)", "");
		
		Wcontrol.sendkeysByAction(underWritingPage.exclusionSource, "HEALTH");
		Wcontrol.ActionMoveToElementClcik(proposalPage.opt);

		if (exclusionType.equalsIgnoreCase("Medical Exclusions")) {
//			Wcontrol.click_and_Select(underWritingPage.exclusionType, underWritingPage.medicalExclusion);
			Wcontrol.clickJSEon(underWritingPage.exclusionType);
			Wcontrol.ActionMoveToElementClcik(underWritingPage.medicalExclusion);
		} else if (exclusionType.equalsIgnoreCase("Cause Exclusions")) {
//			Wcontrol.click_and_Select(underWritingPage.exclusionType, underWritingPage.causeExclusion);
			Wcontrol.clickJSEon(underWritingPage.exclusionType);
			Wcontrol.ActionMoveToElementClcik(underWritingPage.causeExclusion);
		} else if (exclusionType.equalsIgnoreCase("Endorsement Exclusions")) {
//			Wcontrol.click_and_Select(underWritingPage.exclusionType, underWritingPage.endrosementExclusion);
			Wcontrol.clickJSEon(underWritingPage.exclusionType);
			Wcontrol.ActionMoveToElementClcik(underWritingPage.endrosementExclusion);
		}

//		Wcontrol.click_and_Select(underWritingPage.exclusionDescription, underWritingPage.medicalExclusion);
		Wcontrol.clickJSEon(underWritingPage.exclusionDescription);
		Wcontrol.ActionMoveToElementClcik(underWritingPage.medicalExclusion);
		Wcontrol.clickJSEon(underWritingPage.exclusionTick);
		defins.takeScreenShot("Screen Shot for the test");
	}

	public void Add_Lien(String LienType) throws Throwable {
		Wcontrol.scrollUpMin();
		JavascriptExecutor js = (JavascriptExecutor) base.getDriver();
		js.executeScript("window.scrollBy(0,100)", "");
		Wcontrol.sendkeysByAction(underWritingPage.lienSource, "HEALTH");
		Wcontrol.ActionMoveToElementClcik(proposalPage.opt);

		if (LienType.equalsIgnoreCase("OLD AGE LIEN")) {
			Wcontrol.click_and_Select(underWritingPage.lienType, underWritingPage.oldLien);
		} else if (LienType.equalsIgnoreCase("UNDERWRITING LIEN")) {
			Wcontrol.click_and_Select(underWritingPage.lienType, underWritingPage.UWLien);
		} else if (LienType.equalsIgnoreCase("JUVENILE LIEN")) {
			Wcontrol.click_and_Select(underWritingPage.lienType, underWritingPage.JuvLien);
		}

		Wcontrol.sendkeysByAction(underWritingPage.lienFactor, "10");
		Wcontrol.sendkeysByAction(underWritingPage.lienValue, "20000");
		Wcontrol.clickJSEon(underWritingPage.lienTick);
		defins.takeScreenShot("Screen Shot for the test");
	}

	public void Add_Loading(String Criteria) throws Throwable {
		Thread.sleep(1000);
		library.elementstable(underWritingPage.addLoading);
		library.waitForClickableElement(underWritingPage.addLoading);
//		Wcontrol.scrollToView(underWritingPage.loadingButton);
		Wcontrol.scrollDownMin();
		Wcontrol.ActionMoveToElement(underWritingPage.addLoading);
		Wcontrol.clickJSEon(underWritingPage.addLoading);
		By Save = By.xpath(
				"//*[contains(text(),'Base Plan')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Save')]");

//		boolean value = base.getDriver().findElement(Save).isDisplayed();

		if(Width.equalsIgnoreCase("1366") && Height.equalsIgnoreCase("768")) {
			By loadingSource = By.xpath(
					"//*[contains(text(),'Base Plan')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Loading Source')]/parent::label/parent::span/parent::div//input");
			By loadingCriteria = By.xpath(
					"//*[contains(text(),'Base Plan')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Loading Criteria')]/parent::label/parent::span/parent::div//input");
			By loadingValue = By.xpath(
					"//*[contains(text(),'Base Plan')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Loading Value')]/parent::label/parent::span/parent::div//input");

			By Temp_perm = By.xpath(
					"//*[contains(text(),'Base Plan')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Temporary / Permanent')]/parent::label/parent::span/parent::div//mat-select");

			By Months = By.xpath(
					"//*[contains(text(),'Base Plan')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Months')]/parent::label/parent::span/parent::div//textarea");

//			Wcontrol.scrollDownLittle();
			Wcontrol.sendkeysByAction(loadingSource, "HEALTH");
//			Wcontrol.ActionMoveToElementClcik(proposalPage.opt);
			Wcontrol.clickJSEon(proposalPage.opt);

			Thread.sleep(1000);
			Wcontrol.clickJSEon(loadingCriteria);
			Wcontrol.sendkeysByAction(loadingCriteria, Criteria);
			Thread.sleep(1000);
			base.getDriver().findElement(loadingCriteria).sendKeys(Keys.ENTER);

			String loadingValue1 = "";
			if (Criteria.equalsIgnoreCase("FIXED AMOUNT")) {
				loadingValue1 = "100";
			} else if (Criteria.equalsIgnoreCase("PERCENTAGE")) {
				loadingValue1 = "20";
			} else if (Criteria.equalsIgnoreCase("PER MILLE")) {
				loadingValue1 = "10";
			}

			Wcontrol.sendkeysByAction(loadingValue, loadingValue1);

			Wcontrol.clickJSEon(Temp_perm);
			Wcontrol.clickJSEon(Temp_perm);
			Wcontrol.clickJSEon(proposalPage.opt);
			Wcontrol.sendkeysByAction(Months, "12");
			Wcontrol.clickJSEon(Save);

		} else {

			Wcontrol.sendkeysByAction(underWritingPage.loadingSource, "HEALTH");
//		Wcontrol.ActionMoveToElementClcik(proposalPage.opt);
			Wcontrol.MovejsClick(proposalPage.opt);

			Thread.sleep(1000);
			Wcontrol.clickJSEon(underWritingPage.loadingCriteria);
			Thread.sleep(500);

			if (Criteria.equalsIgnoreCase("PER MILLE")) {
//			Wcontrol.click_and_Select(underWritingPage.loadingCriteria, underWritingPage.perMile);
//			Wcontrol.MovejsClick(underWritingPage.perMile);
				Wcontrol.sendkeysByAction(underWritingPage.loadingCriteria, "PER MILLE");
				Wcontrol.clearText(underWritingPage.loadingCriteria);
				Wcontrol.sendkeysByAction(underWritingPage.loadingCriteria, "PER MILLE");
				Thread.sleep(500);

			} else if (Criteria.equalsIgnoreCase("FIXED AMOUNT")) {
//			Wcontrol.click_and_Select(underWritingPage.loadingCriteria, underWritingPage.fixedAmount);
//			Wcontrol.MovejsClick(underWritingPage.loadingCriteria);

//			Wcontrol.MovejsClick(underWritingPage.fixedAmount);
				Wcontrol.sendkeysByAction(underWritingPage.loadingCriteria, "FIXED AMOUNT");
				Wcontrol.clearText(underWritingPage.loadingCriteria);
				Wcontrol.sendkeysByAction(underWritingPage.loadingCriteria, "FIXED AMOUNT");
				Thread.sleep(500);

			} else if (Criteria.equalsIgnoreCase("PERCENTAGE")) {
//			Wcontrol.click_and_Select(underWritingPage.loadingCriteria, underWritingPage.loadingPercentage);
//			Wcontrol.MovejsClick(underWritingPage.loadingPercentage);
				Wcontrol.sendkeysByAction(underWritingPage.loadingCriteria, "PERCENTAGE");
				Wcontrol.clearText(underWritingPage.loadingCriteria);
				Wcontrol.sendkeysByAction(underWritingPage.loadingCriteria, "PERCENTAGE");

				Thread.sleep(500);
			}

			String loadingValue = "";
			if (Criteria.equalsIgnoreCase("FIXED AMOUNT")) {
				loadingValue = "100";
			} else if (Criteria.equalsIgnoreCase("PERCENTAGE")) {
				loadingValue = "20";
			} else if (Criteria.equalsIgnoreCase("PER MILLE")) {
				loadingValue = "10";
			}

			Wcontrol.sendkeysByAction(underWritingPage.loadingValue, loadingValue);
//		Wcontrol.click_and_Select(underWritingPage.Temp_perm, proposalPage.opt);
			Wcontrol.clickJSEon(underWritingPage.Temp_perm);
			Wcontrol.clickJSEon(underWritingPage.Temp_perm);
			Wcontrol.clickJSEon(proposalPage.opt);
			Wcontrol.sendkeysByAction(underWritingPage.loadingMonths, "12");
//		String value = Wcontrol.GetAttributeValueon(underWritingPage.Temp_perm, "value");
//		if(value.equalsIgnoreCase("Temporary")) {
//			Wcontrol.sendkeysByAction(underWritingPage.loadingMonths, "12");
//		}

			Wcontrol.clickJSEon(underWritingPage.loadingTick);
			defins.takeScreenShot("Screen Shot for the test");
		}
	}

	public void Change_The_UW_Decision() throws Throwable {
		Wcontrol.clickJSEon(proposalPage.LifeTab);
		Wcontrol.clickJSEon(proposalPage.LifeAssuredView);
		library.elementstable(proposalPage.Save);

		Wcontrol.scrollToView(underWritingPage.BasePlan);
		Wcontrol.clickJSEon(underWritingPage.BasePlan);
		Wcontrol.scrollToView(underWritingPage.BasePlan);
		Wcontrol.scrollUpMin();
		Wcontrol.click_and_Select(underWritingPage.UWdecision, proposalPage.planDescOption);

		Wcontrol.clickJSEon(proposalPage.Save);
	}

	public void get_Agent_additional_Details(String enqTab) throws Throwable {
		List<String> list = new ArrayList<String>();
		List<WebElement> DetailsList = Wcontrol.GetAllElements(enquiryPage.agentDetailsList);

		if (enqTab.equalsIgnoreCase("Requirements")) {
			list.add("Documents");
			list.add("Training");
			list.add("LOB - Plans Excluded");

		} else if (enqTab.equalsIgnoreCase("Policies")) {
			list.add("Note");
		} else if (enqTab.equalsIgnoreCase("Commissions/Benefit")) {
			list.add("asdfghjkl");
		}
		Wcontrol.scrollDownLong();

		for (int i = 0; i < DetailsList.size(); i++) {
			String name = Wcontrol.GetTexton(DetailsList.get(i)).trim();
			Wcontrol.clickJSEon(DetailsList.get(i));
			Thread.sleep(1000);
			if (!list.contains(name)) {
				defins.takeScreenShot("Screen Shot of " + name + " in Agent Enquiry Screen..");
			}

		}

	}

	@Then("Caluculate the Premium from DB and Compare in Enquiry Page")
	public void Caluculate_the_Premium_from_DB_and_Compare_in_Enquiry_Page() throws Throwable {
		String planCode1 = CustomerExceldata.TestDataInMap.get("PlanCode");
		if (!planCode1.equalsIgnoreCase("FUTINVEST") && !planCode1.equalsIgnoreCase("PLAN21")
				&& !planCode1.equalsIgnoreCase("RSP") && !planCode1.equalsIgnoreCase("Plan27")
				&& !planCode1.equalsIgnoreCase("D-TRS")) {

			Wcontrol.clickJSEon(proposalPage.productDetailsTab);
			Wcontrol.scrollDownMin();

			String actualPremium = Get_The_Premium_Value();

			String expPremium = Wcontrol.GetTexton(By
					.xpath("((//*[contains(text(),'Product Details')]/parent::div/parent::div//table//tr)[2]//td)[6]"));
			String expectedPre = expPremium.replaceAll(",", "");

			double doubleValue = Double.parseDouble(expectedPre);
			int RoundedAmount_One = (int) Math.round(doubleValue);
			String expectedPremium = Integer.toString(RoundedAmount_One);

			System.out.println("Actual Premium Amount is : " + actualPremium);
			System.out.println("Expected Premium Amount is : " + expectedPremium);

			Allure.addAttachment("Actual Premium Amount is : ", actualPremium);
			Allure.addAttachment("Expected Premium Amount is : ", expectedPremium);
			Assert.assertEquals(expectedPremium, actualPremium);
			if (actualPremium.equalsIgnoreCase(expectedPremium)) {
				System.out.println("Premium is Equal.........");
				Allure.addAttachment("Premium Status", "Premium is Equal.........");
			}
		}
	}

	public String Get_The_Premium_Value() throws Throwable {
		String planCode = CustomerExceldata.TestDataInMap.get("PlanCode");
		String paymentMethod = CustomerExceldata.TestDataInMap.get("PaymentMethodCode");
		String gender = CustomerExceldata.TestDataInMap.get("GenderCode");

		String receivedMF = get_ModalFactor(planCode, paymentMethod);
		String receivedRate = get_Rate(planCode, gender);
		String receivedUnit = get_Unit(planCode, gender);

		System.out.println("Mf is : " + receivedMF);
		System.out.println("Rate is : " + receivedRate);
		System.out.println("Unit is : " + receivedUnit);
		String actualSA = CustomerExceldata.TestDataInMap.get("InitalSumAssured");

		double MF = Double.parseDouble(receivedMF);
		double Rate = Double.parseDouble(receivedRate);
		double Unit = Double.parseDouble(receivedUnit);
		double SA = Double.parseDouble(actualSA);

		PremiumAmount = (Rate / Unit) * SA * MF;
		int RoundedAmount = (int) Math.round(PremiumAmount);
		String actualPremium = Integer.toString(RoundedAmount);
		return actualPremium;
	}

	public String Get_The_Rider_Premium_Value() throws Throwable {
		String RiderCode = RiderExceldata.TestDataInMap.get("RiderName2");
		String paymentMethod = CustomerExceldata.TestDataInMap.get("PaymentMethodCode");
//		String gender = CustomerExceldata.TestDataInMap.get("GenderCode");

		String receivedMF = get_Rider_ModalFactor(RiderCode, paymentMethod);
		String receivedRate = get_Rider_Rate(RiderCode);
		String receivedUnit = get_Rider_Unit(RiderCode);

		System.out.println("Mf is : " + receivedMF);
		System.out.println("Rate is : " + receivedRate);
		System.out.println("Unit is : " + receivedUnit);
		String actualSA = RiderExceldata.TestDataInMap.get("RiderSumAssured");

		double MF = Double.parseDouble(receivedMF);
		double Rate = Double.parseDouble(receivedRate);
		double Unit = Double.parseDouble(receivedUnit);
		double SA = Double.parseDouble(actualSA);

		PremiumAmount = (Rate / Unit) * SA * MF;
		int RoundedAmount = (int) Math.round(PremiumAmount);
		String actualPremium = Integer.toString(RoundedAmount);
		return actualPremium;
	}

	public String get_ModalFactor(String planCode, String paymentMethod) throws Throwable {
		String freq = CustomerExceldata.TestDataInMap.get("FrequencyCode");
		String DB_MF = null;

		String SqlQuery = "SELECT N_MODAL_FACTOR from GNMM_PLAN_MODAL_FACTOR_LINK where V_PLAN_CODE = '" + planCode
				+ "' AND V_PYMT_FREQ = '" + freq + "' AND V_PMT_METHOD_CODE = '" + paymentMethod + "'";
		DB_MF = library.query(SqlQuery);
		return DB_MF;
	}

	public String get_Rider_ModalFactor(String RiderCode, String paymentMethod) throws Throwable {
		String freq = CustomerExceldata.TestDataInMap.get("FrequencyCode");
		String DB_MF = null;

		String SqlQuery = "SELECT N_MODAL_FACTOR from GNMM_PLAN_MODAL_FACTOR_LINK where V_PLAN_CODE = '" + RiderCode
				+ "' AND V_PYMT_FREQ = '" + freq + "' AND V_PMT_METHOD_CODE = '" + paymentMethod + "'";
		DB_MF = library.query(SqlQuery);
		return DB_MF;
	}

	public String get_Rate(String planCode, String gender) throws Throwable {
		String DB_Rate = null;
		String SqlQuery = null;
		String policyTerm = CustomerExceldata.TestDataInMap.get("PolicyTerms");
		String freq = CustomerExceldata.TestDataInMap.get("FrequencyCode");

		if (planCode.equalsIgnoreCase("Plan11")) {
			SqlQuery = "SELECT N_PREM_RATE from GNMM_PREMIUM where V_PLAN_CODE='" + planCode + "' AND N_START_AGE ='"
					+ customerAge + "' AND N_END_AGE ='" + customerAge + "' AND V_PYMT_FREQ = '" + freq
					+ "' AND N_START_TERM = '" + policyTerm + "' AND N_END_TERM = '" + policyTerm + "' AND V_SEX = '"
					+ gender + "'";
		} else if (planCode.equalsIgnoreCase("FUTINVEST") || planCode.equalsIgnoreCase("plan19")) {
			SqlQuery = "SELECT N_PREM_RATE from GNMM_PREMIUM where V_PLAN_CODE='" + planCode + "' AND N_START_AGE ='"
					+ customerAge + "' AND N_END_AGE ='" + customerAge + "' AND V_SEX = '" + gender + "'";
		} else if (planCode.equalsIgnoreCase("plan3") || planCode.equalsIgnoreCase("plan21")) {
			SqlQuery = "SELECT N_PREM_RATE from GNMM_PREMIUM where V_PLAN_CODE='" + planCode + "' AND N_START_AGE ='"
					+ customerAge + "' AND N_END_AGE ='" + customerAge + "' AND V_SEX = '" + gender
					+ "' AND V_PYMT_FREQ = '" + freq + "'";
		} else if (planCode.equalsIgnoreCase("plan27")) {
			SqlQuery = "SELECT N_PREM_RATE from GNMM_PREMIUM where V_PLAN_CODE='" + planCode + "' AND N_START_AGE ='"
					+ customerAge + "' AND N_END_AGE ='" + customerAge + "' AND V_PYMT_FREQ = '" + freq
					+ "' AND N_START_TERM = '" + policyTerm + "' AND N_END_TERM = '" + policyTerm + "'";
		}

//		System.err.println(SqlQuery);
		DB_Rate = library.query(SqlQuery);

		return DB_Rate;
	}

	public String get_Rider_Rate(String RiderCode) throws Throwable {
		String DB_Rate = null;
		String SqlQuery = null;

		SqlQuery = "SELECT N_PREM_RATE from GNMM_PREMIUM where V_PLAN_CODE='" + RiderCode + "'";

//		System.err.println(SqlQuery);
		DB_Rate = library.query(SqlQuery);

		return DB_Rate;
	}

	public String get_Unit(String planCode, String gender) throws Throwable {
		String DB_Unit = null;
		String SqlQuery = null;
		String policyTerm = CustomerExceldata.TestDataInMap.get("PolicyTerms");
		String freq = CustomerExceldata.TestDataInMap.get("FrequencyCode");

		if (planCode.equalsIgnoreCase("Plan11")) {
			SqlQuery = "SELECT N_BASE_SA from GNMM_PREMIUM where V_PLAN_CODE='" + planCode + "' AND N_START_AGE ='"
					+ customerAge + "' AND N_END_AGE ='" + customerAge + "' AND V_PYMT_FREQ = '" + freq
					+ "' AND N_START_TERM = '" + policyTerm + "' AND N_END_TERM = '" + policyTerm + "' AND V_SEX = '"
					+ gender + "'";
		} else if (planCode.equalsIgnoreCase("FUTINVEST") || planCode.equalsIgnoreCase("plan19")) {
			SqlQuery = "SELECT N_BASE_SA from GNMM_PREMIUM where V_PLAN_CODE='" + planCode + "' AND N_START_AGE ='"
					+ customerAge + "' AND N_END_AGE ='" + customerAge + "' AND V_SEX = '" + gender + "'";
		} else if (planCode.equalsIgnoreCase("plan3") || planCode.equalsIgnoreCase("plan21")) {
			SqlQuery = "SELECT N_BASE_SA from GNMM_PREMIUM where V_PLAN_CODE='" + planCode + "' AND N_START_AGE ='"
					+ customerAge + "' AND N_END_AGE ='" + customerAge + "' AND V_SEX = '" + gender
					+ "' AND V_PYMT_FREQ = '" + freq + "'";
		} else if (planCode.equalsIgnoreCase("plan27")) {
			SqlQuery = "SELECT N_BASE_SA from GNMM_PREMIUM where V_PLAN_CODE='" + planCode + "' AND N_START_AGE ='"
					+ customerAge + "' AND N_END_AGE ='" + customerAge + "' AND V_PYMT_FREQ = '" + freq
					+ "' AND N_START_TERM = '" + policyTerm + "' AND N_END_TERM = '" + policyTerm + "'";
		}

		DB_Unit = library.query(SqlQuery);

		return DB_Unit;
	}

	public String get_Rider_Unit(String RiderCode) throws Throwable {
		String DB_Unit = null;
		String SqlQuery = null;

		SqlQuery = "SELECT N_PREM_RATE from GNMM_PREMIUM where V_PLAN_CODE='" + RiderCode + "'";

		DB_Unit = library.query(SqlQuery);

		return DB_Unit;
	}
	
//	
//	@When("I execute the test with loaded Excel data")
//    public void iExecuteTheTestWithLoadedExcelData() {
//        // Access the loaded test data from the scenario context
////        List<Object[]> testData = (List<Object[]>) defins.getTestData();
//		List<Map<String, Object>> testDataList = defins.getTestDataList();
//        
//        // Your test logic using the loaded Excel test data
////        System.out.println("Executing test with loaded data: " + testData);
//        int targetRow = 0; // Replace with the index of the row you want to access
////        int targetColumn = 1;
////        System.out.println("Data for a test case:");
////        for (Object[] row : testData) {
////            
////            System.out.println(Arrays.toString(row));
////        }
////        Object specificValue = testData.get(targetRow)[targetColumn];
////        Object specificValue = testDataList.get(targetRow).get("Name");
//        System.out.println(testDataList.get(targetRow).get("Name"));
//        System.out.println(testDataList.get(targetRow).get("Age"));
//        System.out.println(testDataList.get(targetRow).get("Gender"));
//        System.out.println("-----------------------------------------------");
//        System.out.println(testDataList.get(1).get("Name"));
//        System.out.println(testDataList.get(1).get("Age"));
//        System.out.println(testDataList.get(1).get("Gender"));
//        System.out.println("-----------------------------------------------");
//        System.out.println(testDataList.get(2).get("Name"));
//        System.out.println(testDataList.get(2).get("Age"));
//        System.out.println(testDataList.get(2).get("Gender"));
//        
////        System.out.println(specificValue);
//    }
	


    @When("I enter credentials from Excel file")
    public void enterCredentialsFromExcelFile() {
        testDataNew = readTestDataFromExcel("C:\\Users\\madhan.kumar\\Pictures\\New.xlsx");
//        List<Map<String, String>> dataList = null;
//        Map<String, String> = data;
        System.out.println("------------------------------------------------");
        for (Map<String, String> data : testDataNew) {
        	
//            dataList.add(data);
            System.out.println(data.get("username"));
            System.out.println(data.get("password"));
            System.out.println(data.get("Gender"));
            System.out.println("------------------------------------------------");

        }
        
//        System.out.println(dataList.get(0).get("username"));
//        System.out.println(dataList.get(0).get("password"));
//        System.out.println(dataList.get(0).get("password"));
//        System.out.println("---------------------------------------------------------------------");
//        System.out.println(dataList.get(1).get("username"));
//        System.out.println(dataList.get(1).get("password"));
//        System.out.println(dataList.get(1).get("password"));
//        System.out.println("---------------------------------------------------------------------");
//        System.out.println(dataList.get(2).get("username"));
//        System.out.println(dataList.get(2).get("password"));
//        System.out.println(dataList.get(2).get("password"));
//        System.out.println("---------------------------------------------------------------------");

    }
    
    
    private List<Map<String, String>> readTestDataFromExcel(String filePath) {
        List<Map<String, String>> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row currentRow = sheet.getRow(rowIndex);
                Map<String, String> data = new HashMap<>();

                for (int cellIndex = 0; cellIndex < headerRow.getLastCellNum(); cellIndex++) {
                    Cell currentCell = currentRow.getCell(cellIndex);
                    String header = headerRow.getCell(cellIndex).getStringCellValue();
                    String value = currentCell.getStringCellValue();
                    data.put(header, value);
                }

                dataList.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }

}
