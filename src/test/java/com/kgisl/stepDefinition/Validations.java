package com.kgisl.stepDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.kgisl.PageElements.Web.CommonPageElements;
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
import com.kgisl.library.ReportOut;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class Validations {

	public WebControl Wcontrol;
	public LibraryClass library;
	public CommonPageElements commonPage;
	public RegistrationPage registrationPage;
	public Hooks base;
	public ProposalPage proposalPage;
	public UnderwritingPage underWritingPage;
	private ExcelUtility Exceldata;
	public ProposePageStepDefinitions proposalStep;
	public QualityCheck qualityCheck;
	private EverGreenStepDefinitions EVG;

	public String expectedResult = "Required";

	static Map maps = new HashMap();
	private String TestId = null;
	public String Name1, Name2;

	private String sheetName = null;
	private Data_Set Data;
	private ReportOut report;
	// public String [] riderName= {};
	// public List<String> optionalRiderNames = new;
	// public List <String> optionalRiderNames= new ArrayList<String>();
	public List<String> optionalRiderNames = new ArrayList<String>();

	private Map<String, String> InputData;

	FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);

	public Validations(WebControl wcontrol, LibraryClass library, CommonPageElements commonPage,
			RegistrationPage registrationPage, Hooks base, ProposalPage proposalPage, UnderwritingPage underWritingPage,
			ExcelUtility exceldata, QualityCheck qualityCheck, Data_Set data, ReportOut report,
			ProposePageStepDefinitions proposalStep, EverGreenStepDefinitions EVG) {
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
		this.EVG = EVG;
	}
	


	@Then("Validate the Customer Details Tab")
	public void Customer_Details_Tab_Validation() throws Throwable {
		Identity_and_Identity_Number_Validation();
		Title_and_Name_Validation();
		DOB_and_Occupation();
		Nationality_and_Race_Validation();
		Height_and_Weight_Validation();
		if (base.getDriver().findElements(registrationPage.dialogboxDetails).size() > 0) {
			Error_Validation();
		}

	}

	@Then("Validate the Address Details Tab")
	public void Address_Details_Tab_Validation() throws Throwable {

		Address_Details_Verification();
		if (base.getDriver().findElements(registrationPage.dialogboxDetails).size() > 0
				&& !base.getDriver().findElement(registrationPage.dialogboxDetails).getText().trim()
						.equalsIgnoreCase("Please add atleast one contact in \"RESIDENT ADDRESS\"")) {
			Wcontrol.clickJSEon(registrationPage.dialogboxOK);
			Error_Validation();
		} else {
			Thread.sleep(1500);
			Wcontrol.clickJSEon(registrationPage.dialogboxOK);
			Address_Contact();
		}
	}

	@Then("Validate the Identification Details Tab")
	public void Identification_Details_Tab_Validation() throws Throwable {
		Identification_details_verification();
		if (base.getDriver().findElements(registrationPage.dialogboxDetails).size() > 0) {
			Wcontrol.clickJSEon(registrationPage.dialogboxOK);
			Error_Validation();
		}

	}

	@Then("Validate the Contact Details Tab")
	public void Contact_Details_Tab_Validation() throws Throwable {
		Wcontrol.clickJSEon(registrationPage.ContactDetails);
		Contact_Details();
	}

	@Then("Validate the Bank Details Tab")
	public void Bank_Details_Tab_Validation() throws Throwable {

		Bank_Valid();
		if (base.getDriver().findElements(registrationPage.dialogboxDetails).size() > 0) {
			Wcontrol.clickJSEon(registrationPage.dialogboxOK);
			Error_Validation();
		}
	}

	@Then("Validate the Employer Details")
	public void Validate_the_Employer_Details() throws Throwable {
		Emp_Valid();
		if (base.getDriver().findElements(registrationPage.dialogboxDetails).size() > 0) {
			Wcontrol.clickJSEon(registrationPage.dialogboxOK);
			Error_Validation();
		}
	}

	@Then("Validate the Plan description")
	public void Validate_the_plan_Description_Validation() throws Throwable {
		PlanDesc_Validation();
		if (base.getDriver().findElements(commonPage.errorMsg).size() > 0) {
			Wcontrol.Clickon(proposalPage.basicParticularPanel);
			Error_Validation();
		}

	}

	@Then("Validate the Proposer Particulars Tab")
	public void Proposer_Particular_Validation() throws Throwable {
		Proposer_Particular_verification();
		if (base.getDriver().findElements(commonPage.errorMsg).size() > 0) {
			Error_Validation();
		}
	}

	@And("Validate the Policy Particulars Tab")
	public void Policy_Particulars_Validation() throws Throwable {
		Currency_and_Initial_Sum_Assured_Validation();
		Validation_for_the_User_Premium();
		Validation_for_the_PolicyTerms_and_Frequency();
		Validation_for_the_Premium_pattern_and_SA_Pattern();
		Wcontrol.scrollToView(proposalPage.policyNext);
		Thread.sleep(500);
		Wcontrol.clickJSEon(proposalPage.policyNext);
		if (base.getDriver().findElements(proposalPage.staffPolicy).size() == 0
				|| base.getDriver().findElements(proposalPage.epfNo).size() == 0) {
			Error_Validation();
		}
	}

	@Then("Validate the Loan Tab")
	public void Loan_Tab_Validation() throws Throwable {
		Loan_Tab_Fields_Validation();
		if (base.getDriver().findElements(proposalPage.payerType).size() == 0) {
			Error_Validation();
		}
	}

	@Then("Validate the Payer Tab")
	public void PayerTab_Validation() throws Throwable {
		String planDesc = Exceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("D-TRS")) {
			Thread.sleep(1500);
			Wcontrol.Clickon(proposalPage.payerType);
			Wcontrol.ActionMoveToElementClcik(proposalPage.payerOptions);
			Thread.sleep(500);

			if (base.getDriver().findElements(commonPage.errorMsg).size() > 0) {
				Error_Validation();
			}

		}
	}

	@Then("Validate the short Payment method")
	public void Validation_for_Short_Payment_Method() throws Throwable {
		String planDesc = Exceldata.TestDataInMap.get("Plan Descriptipn");

		if (!planDesc.equalsIgnoreCase("D-TRS") && !planDesc.equalsIgnoreCase("Plan19")) {

			Wcontrol.clickJSEon(proposalPage.shortPayment);
			Thread.sleep(1000);
			Wcontrol.ActionMoveToElementClcik(proposalPage.options);

			if (base.getDriver().findElements(commonPage.errorMsg).size() > 0) {
				Error_Validation();
			}
		}
	}

	@Then("Verify the Validation Tab")
	public void Verify_the_validation_tab() throws Throwable {

		String planDesc = Exceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("Future Invest")) {
			Future_Invest_Validation();
		} else if (planDesc.equalsIgnoreCase("Plan11")) {
			Plan11_Validation();
		} else if(planDesc.equalsIgnoreCase("Plan3")) {
			Plan3_Validation();
		}

	}

//------------------------------------------------Methods--------------------------------------------------

	

	public void Error_Validation() throws Throwable {
//		List<WebElement> errName = Wcontrol.GetAllElements(commonPage.ErrorSpot);

		List<WebElement> errormsg = Wcontrol.GetAllElements(commonPage.errorMsg);
		int c = errormsg.size();

		for (int i = 0; i < c; i++) {
			WebElement target = Wcontrol.GetElments(commonPage.ErrorSpot, i);
			String errName = Wcontrol.GetTexton(target);
			if (errName.equalsIgnoreCase("User Premium")) {
				User_Premium_Validation(errName);
			} else {
				WebElement target1 = Wcontrol.GetElments(commonPage.errorMsg, i);
				String actualResult = Wcontrol.GetTexton(target1);

				Assert.assertEquals(expectedResult, actualResult);
				System.err.println(Wcontrol.GetTexton(target) + " is Validated");
			}
		}

	}

	public void Contact_Number_Validation() throws Throwable {

		String actual = Wcontrol.GetTexton(commonPage.errorMsg);
		String expected = "Only Numbers allowed";
		Assert.assertEquals(expected, actual);
	}

	public void User_Premium_Validation(String actual) throws Throwable {

//		String actual = Wcontrol.GetTexton(commonPage.errorMsg);
		String expected = "Only numbers allowed !";
		Assert.assertEquals(expected, actual);
	}

	public int getContactFormat() {
		String s1 = Exceldata.TestDataInMap.get("ContactDescription");
		String s2 = "!@#$%^&*()_-+=";
		char[] ch = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		List<String> l1 = new ArrayList<String>();
		for (int i = 0; i < ch.length; i++) {
			String v = Character.toString(ch[i]);
			l1.add(v);
		}

		int c = ch2.length;
		int temp = 0;
		for (int i = 0; i < c; i++) {
			String a = Character.toString(ch2[i]);
			if (l1.contains(a)) {
				temp++;
			}
		}
//        if(temp!=0){
////        	System.out.println("Enter only Numbers");
//        }
		return temp;
	}

	public void Identity_and_Identity_Number_Validation() throws Throwable {
		Wcontrol.Clickon(registrationPage.identity);
		Wcontrol.sendkeysByAction(registrationPage.identity, Exceldata.TestDataInMap.get("Identity"));
		Wcontrol.sendkeysByAction(registrationPage.identityNumber, Exceldata.TestDataInMap.get("Identity number"));

	}

	public void Title_and_Name_Validation() throws Throwable {
		Wcontrol.Clickon(registrationPage.title);
		String title = Exceldata.TestDataInMap.get("Title");
		Wcontrol.sendkeysByAction(registrationPage.title, "M");
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
		Wcontrol.ActionMoveToElementClcik(opt);

		Wcontrol.sendkeysByAction(registrationPage.firstName, Exceldata.TestDataInMap.get("FirstName"));
		if (Exceldata.TestDataInMap.get("MiddleName") != null) {
			Wcontrol.EnterValueon(registrationPage.middleName, Exceldata.TestDataInMap.get("MiddleName"));
		}
		Wcontrol.EnterValueon(registrationPage.lastName, Exceldata.TestDataInMap.get("LastName"));
	}

	public void PlanDesc_Validation() throws Throwable {
		library.waitForInVisibilityOfElement(commonPage.animation);
		String planDesc = Exceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("Future Invest")) {
			Wcontrol.sendkeysByAction(proposalPage.planDescription, Exceldata.TestDataInMap.get("Plan Descriptipn"));
		} else {
			Wcontrol.sendkeysByAction(proposalPage.planDescription, Exceldata.TestDataInMap.get("Plan Descriptipn"));
			Thread.sleep(1500);
			Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);
		}
		library.waitForInVisibilityOfElement(commonPage.animation);
		Wcontrol.scrollToView(proposalPage.BasicNext);
		Wcontrol.Clickon(proposalPage.BasicNext);
	}

	public void Bank_Valid() throws Throwable {
		Wcontrol.sendkeysByAction(registrationPage.bankName, Exceldata.TestDataInMap.get("BankName"));
//		Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);
		Wcontrol.EnterValueon(registrationPage.AccountNumber, Exceldata.TestDataInMap.get("AccountNumber"));
		Wcontrol.clickJSEon(registrationPage.BankTick);
	}

	public void gender_Validation() throws Throwable {
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

	public void DOB_and_Occupation() throws Throwable {
		Wcontrol.EnterValueon(registrationPage.dateOfBirth, Exceldata.TestDataInMap.get("DateOfBirth"));
		Wcontrol.sendkeysByAction(registrationPage.Occupation, Exceldata.TestDataInMap.get("Occupation"));
	}

	public void Nationality_and_Race_Validation() throws Exception {
		Wcontrol.sendkeysByAction(registrationPage.nationality, Exceldata.TestDataInMap.get("Nationality"));
		Thread.sleep(1000);
		Wcontrol.sendkeysByAction(registrationPage.race, Exceldata.TestDataInMap.get("Race"));
		Thread.sleep(1000);
	}

	public void Height_and_Weight_Validation() throws Throwable {
		Wcontrol.EnterValueon(registrationPage.height, Exceldata.TestDataInMap.get("Height"));
		Wcontrol.EnterValueon(registrationPage.weight, Exceldata.TestDataInMap.get("Weight"));
	}

	public void Identification_details_verification() throws Throwable {
		Thread.sleep(1000);
		Wcontrol.sendkeysByAction(registrationPage.identityIssuedate, Exceldata.TestDataInMap.get("IdentityIssueDate"));
		Wcontrol.sendkeysByAction(registrationPage.identityExpirydate,
				Exceldata.TestDataInMap.get("IdentityExpiryDate"));
		Wcontrol.clickJSEon(registrationPage.detailsTick);
	}

	public void Contact_Details() throws Throwable {

		Thread.sleep(1000);
		Wcontrol.sendkeysByAction(registrationPage.cdType, Exceldata.TestDataInMap.get("ContactType"));
		Thread.sleep(1000);
		Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);
		Wcontrol.sendkeysByAction(registrationPage.cdDesc, Exceldata.TestDataInMap.get("ContactDescription"));

		Wcontrol.Clickon(registrationPage.CdTick);

		int temp = getContactFormat();
		if (temp > 0) {
			Wcontrol.clickJSEon(registrationPage.dialogboxOK);
			Contact_Number_Validation();
		}
	}

	public void Address_Details_Verification() throws Throwable {
		Thread.sleep(1500);
		Wcontrol.EnterValueon(registrationPage.address1, Exceldata.TestDataInMap.get("Address"));
		Wcontrol.sendkeysByAction(registrationPage.postCode, Exceldata.TestDataInMap.get("PostCode"));
		Thread.sleep(1000);
		Wcontrol.scrollToView(registrationPage.IdentificationPanel);
		Thread.sleep(1000);
		Wcontrol.Clickon(commonPage.addressNext);
	}

	public void Address_Contact() throws Throwable {
		Wcontrol.Clickon(registrationPage.addContact);
		Thread.sleep(1000);
		Wcontrol.sendkeysByAction(registrationPage.contactType, Exceldata.TestDataInMap.get("ContactType"));
		Thread.sleep(1000);
		Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);
		Wcontrol.sendkeysByAction(registrationPage.contactDesc, Exceldata.TestDataInMap.get("ContactDescription"));

		Wcontrol.Clickon(registrationPage.tick);

		int temp = getContactFormat();
		if (temp > 0) {
			Wcontrol.clickJSEon(registrationPage.dialogboxOK);
			Contact_Number_Validation();
		}
	}

	public void validate_IndividualID_and_Id_Number() throws Throwable {
		String planDesc = Exceldata.TestDataInMap.get("Plan Descriptipn");
		if (!planDesc.equalsIgnoreCase("D-TRS")) {

			Wcontrol.clearText(proposalPage.Identity);
			Wcontrol.sendkeysByAction(proposalPage.Identity, Exceldata.TestDataInMap.get("Identity"));
			report.setIdentity(Exceldata.TestDataInMap.get("Identity"));

			Thread.sleep(3000);
			Wcontrol.Clickon(proposalPage.IDNumber);

			Wcontrol.sendkeysByAction(proposalPage.IDNumber, Exceldata.TestDataInMap.get("FirstName"));
			Thread.sleep(1500);
			List<WebElement> identityOptions = Wcontrol.GetAllElements(proposalPage.IdentityOPtions);
			for (int i = 0; i < identityOptions.size(); i++) {
				WebElement target = Wcontrol.GetElments(proposalPage.IdentityOPtions, i);
				String NRIC = Wcontrol.GetTexton(target);
				String pattern = "\\(";
				String str2 = NRIC.replaceAll(pattern, "#").split("#")[0].trim();
				if (str2.equalsIgnoreCase(Exceldata.TestDataInMap.get("Identity number"))) {
					WebElement finalTarget = Wcontrol.GetElments(proposalPage.IdentityOPtions, i);
					Wcontrol.ActionMoveToElementClcik(finalTarget);
					break;
				}
			}

			report.setIdentityNumber(Exceldata.TestDataInMap.get("Identity number"));
		}
	}

	public void Validate_the_Company_id_and_Payer_RelationShip() throws Throwable {
		String planDesc = Exceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("D-TRS")) {
			Thread.sleep(1000);
			Wcontrol.scrollToView(proposalPage.proposerType);
			Wcontrol.Clickon(proposalPage.proposerType);
			Wcontrol.ActionMoveToElementClcik(proposalPage.proposerTypeCompany);
			Thread.sleep(1500);
			Wcontrol.Clickon(proposalPage.proposerCompanyName);
			Wcontrol.sendkeysByAction(proposalPage.proposerCompanyName, "insure company");
			Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);
			Wcontrol.clearText(proposalPage.proposerRelation);
			Wcontrol.sendkeysByAction(proposalPage.proposerRelation, "CREDITOR");

		}
	}

	public void Validate_the_Agent_Name_In_Validation_Feature() throws Exception {
		Thread.sleep(2000);
		Wcontrol.scrollToView(proposalPage.AgentName);
		Wcontrol.Clickon(proposalPage.AgentName);
		Thread.sleep(500);
		Wcontrol.sendkeysByAction(proposalPage.AgentName, Exceldata.TestDataInMap.get("Agent Name"));

		report.setAgentName(Exceldata.TestDataInMap.get("Agent Name"));
	}

	public void Currency_and_Initial_Sum_Assured_Validation() throws Exception {
		String planDesc = Exceldata.TestDataInMap.get("Plan Descriptipn");
		if (!planDesc.equalsIgnoreCase("D-TRS")) {
			Thread.sleep(2000);
			Wcontrol.sendkeysByAction(proposalPage.currency, Exceldata.TestDataInMap.get("Currency"));
			report.setCurrency(Exceldata.TestDataInMap.get("Currency"));
			Wcontrol.sendkeysByAction(proposalPage.initialSA, Exceldata.TestDataInMap.get("InitalSumAssured"));
			report.setInitialSumAssured(Exceldata.TestDataInMap.get("InitalSumAssured"));
		} else if (planDesc.equalsIgnoreCase("D-TRS")) {
			Thread.sleep(2000);
			Wcontrol.sendkeysByAction(proposalPage.currency, Exceldata.TestDataInMap.get("Currency"));
			report.setCurrency(Exceldata.TestDataInMap.get("Currency"));
		}
	}

	public void Validation_for_the_User_Premium() throws Throwable {
		String planDesc = Exceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("Future Invest") || planDesc.equalsIgnoreCase("Plan19")) {
			Wcontrol.EnterValueon(proposalPage.userPremium, Exceldata.TestDataInMap.get("UserPremium"));
			report.setUserPremium(Exceldata.TestDataInMap.get("UserPremium"));
		}
	}

	public void Validation_for_the_PolicyTerms_and_Frequency() throws Throwable {
		String planDesc = Exceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("Future Invest")) {
			Wcontrol.sendkeysByAction(proposalPage.policyTerms, Exceldata.TestDataInMap.get("PolicyTerms"));

			Wcontrol.clearText(proposalPage.frequency);
			String freq = Exceldata.TestDataInMap.get("Frequency");
			Wcontrol.sendkeysByAction(proposalPage.frequency, freq);
			if (freq.equalsIgnoreCase("yearly")) {
				Wcontrol.ActionMoveToElementClcik(proposalPage.freqOptionYearly);
			}
		} else if (planDesc.equalsIgnoreCase("Plan11") || planDesc.equalsIgnoreCase("Plan27")) {
			Wcontrol.sendkeysByAction(proposalPage.policyTerms, Exceldata.TestDataInMap.get("PolicyTerms"));
		} else if (planDesc.equalsIgnoreCase("Plan3")) {
//			int age = Get_Age_of_the_customer();
//        	String policyTerm =Integer.toString(GetpolicyTerm(age));
//        	Wcontrol.sendkeysByAction(proposalPage.policyTerms, policyTerm);
//        	String premiumTerm =Integer.toString(GetPremiumTerms(age));
//        	Wcontrol.clearText(proposalPage.premiumTerms);
//        	Wcontrol.sendkeysByAction(proposalPage.premiumTerms, premiumTerm);
		} else if (planDesc.equalsIgnoreCase("D-TRS") || planDesc.equalsIgnoreCase("Plan19")) {
			Wcontrol.sendkeysByAction(proposalPage.policyTerms, Exceldata.TestDataInMap.get("PolicyTerms"));
		}

		report.setPolicyTerms(Exceldata.TestDataInMap.get("PolicyTerms"));
		report.setFrequency(Exceldata.TestDataInMap.get("Frequency"));
	}

	public void Validation_for_the_Premium_pattern_and_SA_Pattern() throws Throwable {
		String planDesc = Exceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("Future Invest")) {
			Wcontrol.sendkeysByAction(proposalPage.premiumPattern, Exceldata.TestDataInMap.get("PremiumPattern"));
			Wcontrol.sendkeysByAction(proposalPage.SAPattern, Exceldata.TestDataInMap.get("SAPattern"));
			report.setPremiumPattern(Exceldata.TestDataInMap.get("PremiumPattern"));
			report.setSumAssuredPattern(Exceldata.TestDataInMap.get("SAPattern"));

		}
	}

	public void Proposer_Particular_verification() throws Throwable {
		String planDesc = Exceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("D-TRS")) {
			Validate_the_Company_id_and_Payer_RelationShip();
			Validate_the_Agent_Name_In_Validation_Feature();
		} else {
			validate_IndividualID_and_Id_Number();
			Validate_the_Agent_Name_In_Validation_Feature();
		}
		Wcontrol.scrollToView(proposalPage.BasicNext);
		Wcontrol.Clickon(proposalPage.proposerNext);
	}

	public void Emp_Valid() throws Throwable {
		Wcontrol.EnterValueon(registrationPage.EmployerName, Exceldata.TestDataInMap.get("Employer Name"));
		Wcontrol.EnterValueon(registrationPage.natureOfBusiness, Exceldata.TestDataInMap.get("Nature of Business"));
		Wcontrol.EnterValueon(registrationPage.Empaddress1, Exceldata.TestDataInMap.get("Address1"));
		Wcontrol.EnterValueon(registrationPage.Empaddress2, Exceldata.TestDataInMap.get("Address2"));
		Wcontrol.EnterValueon(registrationPage.EmpRegistration, Exceldata.TestDataInMap.get("Registration"));
		Wcontrol.EnterValueon(registrationPage.EmpContactNo, Exceldata.TestDataInMap.get("Contact No"));
		Wcontrol.clickJSEon(registrationPage.EmpTick);
	}

	public void Loan_Tab_Fields_Validation() throws Throwable {
		String planDesc = Exceldata.TestDataInMap.get("Plan Descriptipn");
		if (planDesc.equalsIgnoreCase("D-TRS")) {

			Wcontrol.scrollToView(proposalPage.BankAccnumber);
			Thread.sleep(1500);
			Wcontrol.Clickon(proposalPage.comapanyName);
			Wcontrol.sendkeysByAction(proposalPage.comapanyName, "insure company");
			Thread.sleep(1000);
			Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);

			Random random = new Random();

			int x = random.nextInt(900000000) + 100000000;
			int y = random.nextInt(9000) + 1000;

			String accountNumber = Integer.toString(x) + Integer.toString(y);

			int ref = random.nextInt(900) + 100;
			String referenceNumber = Integer.toString(ref);

			Wcontrol.sendkeysByAction(proposalPage.BankAccnumber, accountNumber);
			Wcontrol.sendkeysByAction(proposalPage.loanRefNumber, referenceNumber);
			Wcontrol.sendkeysByAction(proposalPage.loanAmount, "100000");
			Wcontrol.sendkeysByAction(proposalPage.repayTerm, "19");
			Wcontrol.sendkeysByAction(proposalPage.defermentPeriod, "1");
			Wcontrol.scrollToView(proposalPage.serviceCommission);
			Wcontrol.ActionMoveToElement(proposalPage.serviceCommission);
			Wcontrol.Clickon(proposalPage.serviceCommission);
			Wcontrol.ActionMoveToElementClcik(proposalPage.serviceCommisionOptions);
			Wcontrol.Clickon(proposalPage.finance);
			Wcontrol.ActionMoveToElementClcik(proposalPage.freqOptionYearly);

			Wcontrol.scrollToView(proposalPage.loanNext);
			Wcontrol.Clickon(proposalPage.loanNext);
		}
	}

	public void age_and_Term_range_validation() throws Throwable {

		String ageError = "NB253 - INVALID AGE FOR THE PLAN/RIDER AND TERM Action : Enter valid Age";
		List<String> actualFields = new ArrayList<String>();
		if (base.getDriver().findElements(proposalPage.tableFields).size() > 0) {
			List<WebElement> errors = Wcontrol.GetAllElements(proposalPage.tableFields);

			for (int i = 0; i < errors.size(); i++) {
				String val = Wcontrol.GetTexton(Wcontrol.GetElments(proposalPage.tableFields, i));
				actualFields.add(val);
			}

			for (int j = 0; j < actualFields.size(); j++) {
				String act = actualFields.get(j);
				if (act.equalsIgnoreCase(ageError)) {
					Assert.assertEquals(ageError, act);
					System.out.println("Age validation Completed");
					break;
				}
			}
		}
	}

	public void Future_Invest_Validation() throws Throwable {

		int age = EVG.Get_Age_of_the_customer();
		int Terms = Integer.parseInt(Exceldata.TestDataInMap.get("PolicyTerms"));
		int UserPremium = Integer.parseInt(Exceldata.TestDataInMap.get("UserPremium"));
		int initialSA = Integer.parseInt(Exceldata.TestDataInMap.get("InitalSumAssured"));
		String freq = Exceldata.TestDataInMap.get("PolicyTerms");

		if (age > 84) {
			age_and_Term_range_validation();
		} else if (Terms < 5 || Terms > 30) {
			age_and_Term_range_validation();
		} else if (initialSA < 18400 || initialSA > 736000) {
			InitialSumAssured_Validation();
			Wcontrol.clickJSEon(proposalPage.WarningYes);
		}

		switch (freq) {
		case "YEARLY":
			if (UserPremium < 2208 || UserPremium > 999999999) {
				User_Premium_Validation();
				Wcontrol.clickJSEon(proposalPage.WarningYes);
			}
			break;

		case "QUARTERLY":
			if (UserPremium < 960 || UserPremium > 999999999) {
				User_Premium_Validation();
				Wcontrol.clickJSEon(proposalPage.WarningYes);
			}
			break;

		case "HALF YEARLY":
			if (UserPremium < 1472 || UserPremium > 999999999) {
				User_Premium_Validation();
				Wcontrol.clickJSEon(proposalPage.WarningYes);
			}
			break;

		case "MONTHLY":
			if (UserPremium < 368 || UserPremium > 999999999) {
				User_Premium_Validation();
				Wcontrol.clickJSEon(proposalPage.WarningYes);
			}
			break;

		default:
			break;
		}
	}
	
	public void InitialSumAssured_Validation() throws Throwable {
		String initialSAError = "NB328 - Plan Sum Assured Should Be Between Min SA And Max SA Action : Enter A Valid Code";
		List<String> actualFields = new ArrayList<String>();
		if (base.getDriver().findElements(proposalPage.tableFields).size() > 0) {
			List<WebElement> errors = Wcontrol.GetAllElements(proposalPage.tableFields);

			for (int i = 0; i < errors.size(); i++) {
				String val = Wcontrol.GetTexton(Wcontrol.GetElments(proposalPage.tableFields, i));
				actualFields.add(val);
			}

			for (int j = 0; j < actualFields.size(); j++) {
				String act = actualFields.get(j);
				if (act.equalsIgnoreCase(initialSAError)) {
					Assert.assertEquals(initialSAError, act);
					System.out.println("Initial Sum Assured validation Completed");
					break;
				}
			}
		}
		
	}
	
	public void User_Premium_Validation() throws Throwable {
		String premiumError = "NB205 - PREMIUM IS NOT VALID FOR THIS PLAN AND FREQUENCY Action : ENTER THE CORRECT VALUE";
		List<String> actualFields = new ArrayList<String>();
		if (base.getDriver().findElements(proposalPage.tableFields).size() > 0) {
			List<WebElement> errors = Wcontrol.GetAllElements(proposalPage.tableFields);

			for (int i = 0; i < errors.size(); i++) {
				String val = Wcontrol.GetTexton(Wcontrol.GetElments(proposalPage.tableFields, i));
				actualFields.add(val);
			}

			for (int j = 0; j < actualFields.size(); j++) {
				String act = actualFields.get(j);
				if (act.equalsIgnoreCase(premiumError)) {
					Assert.assertEquals(premiumError, act);
					System.out.println("Initial Sum Assured validation Completed");
					break;
				}
			}
		}
		
	}
	
	public void InitialSA_Validation_For_Plan3() throws Throwable {
		String initialSAError = "NB383 - Plan Premium should Be Between The Minimum And Maximum Value(150)And (999999999)";
		List<String> actualFields = new ArrayList<String>();
		if (base.getDriver().findElements(proposalPage.tableFields).size() > 0) {
			List<WebElement> errors = Wcontrol.GetAllElements(proposalPage.tableFields);

			for (int i = 0; i < errors.size(); i++) {
				String val = Wcontrol.GetTexton(Wcontrol.GetElments(proposalPage.tableFields, i));
				actualFields.add(val);
			}

			for (int j = 0; j < actualFields.size(); j++) {
				String act = actualFields.get(j);
				if (act.equalsIgnoreCase(initialSAError)) {
					Assert.assertEquals(initialSAError, act);
					System.out.println("Initial Sum Assured validation Completed");
					break;
				}
			}
		}
		
	}
	
	public void Plan11_Validation() throws Throwable {
		int age = EVG.Get_Age_of_the_customer();
		int Terms = Integer.parseInt(Exceldata.TestDataInMap.get("PolicyTerms"));
		int initialSA = Integer.parseInt(Exceldata.TestDataInMap.get("InitalSumAssured"));
		
		if (age < 16 || age > 55) {
			age_and_Term_range_validation();
		} else if(Terms < 15 || Terms > 30) {
			age_and_Term_range_validation();
		} else if(initialSA < 50000 || initialSA > 999999999) {
			InitialSumAssured_Validation();
			Wcontrol.clickJSEon(proposalPage.WarningYes);
		}
	}
	
	public void Plan3_Validation() throws Throwable {
		int age = EVG.Get_Age_of_the_customer();
		int Terms = Integer.parseInt(Exceldata.TestDataInMap.get("PolicyTerms"));
		int initialSA = Integer.parseInt(Exceldata.TestDataInMap.get("InitalSumAssured"));
		
		if (age < 16 || age > 55) {
			age_and_Term_range_validation();
			
		} else if(initialSA < 50000 || initialSA > 999999999) {
			InitialSA_Validation_For_Plan3();	
		}
	}
	
	@Then("Update the Date in DB as {string}")
	public void update_DB(String Date) throws Throwable  {
		String UdateDateQuery = "alter system set fixed_date = " + "'"+Date+"'";
//		System.out.println(UdateDateQuery);
		library.query(UdateDateQuery);
		
//		String q1 = "select sysdate from dual";
//		library.query(q1);
	}
	
	@Then("Get the Basic_Rate from DB")
	public void Premium_Calculation_from_DB() throws Throwable {
		
		
		String rateQuery = "SELECT N_PREM_RATE from GNMM_PREMIUM where V_PLAN_CODE='PLAN11' AND N_START_AGE ='28'AND N_END_AGE ='28' AND V_PYMT_FREQ = '03' AND N_START_TERM = '20' AND N_END_TERM = '20' AND V_SEX = 'M'";
		System.out.println(rateQuery);	
		
		String rate = library.query(rateQuery);
		System.out.println(rate);
		
		
		String SAQuerry = "SELECT N_BASE_SA from GNMM_PREMIUM where V_PLAN_CODE='PLAN11' AND N_START_AGE ='28'AND N_END_AGE ='28' AND V_PYMT_FREQ = '03' AND N_START_TERM = '20' AND N_END_TERM = '20' AND V_SEX = 'M'";
		System.out.println(SAQuerry);	
		
		String SA = library.query(SAQuerry);
		System.out.println(SA);
		
		
//		library.executeUpdateQuery(q1);
	}
}
