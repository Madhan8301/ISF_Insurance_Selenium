package com.kgisl.stepDefinition;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.kgisl.PageElements.Web.CommonPageElements;
import com.kgisl.PageElements.Web.ProposalPage;
import com.kgisl.PageElements.Web.QualityCheck;
import com.kgisl.PageElements.Web.RegistrationPage;
import com.kgisl.PageElements.Web.UnderwritingPage;
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
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.netty.handler.codec.LineBasedFrameDecoder;
import junit.framework.Assert;

public class AutoMationScenarios {

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
	public BaseDefins defins;
	public EverGreenStepDefinitions mainStep;
	private RiderExcelUtility RiderExceldata;
	private CustomerExcelUtility CustomerExceldata;

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

	public AutoMationScenarios(WebControl wcontrol, LibraryClass library, CommonPageElements commonPage,
			RegistrationPage registrationPage, Hooks base, ProposalPage proposalPage, UnderwritingPage underWritingPage,
			ExcelUtility exceldata, QualityCheck qualityCheck, Data_Set data, ReportOut report,
			ProposePageStepDefinitions proposalStep, BaseDefins defins, EverGreenStepDefinitions mainStep,
			RiderExcelUtility RiderExceldata, CustomerExcelUtility CustomerExceldata) {
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
		this.mainStep = mainStep;
		this.RiderExceldata = RiderExceldata;
		this.CustomerExceldata = CustomerExceldata;
	}

//	---------------------------------------------------------------------------------------------------------------------------------

	@Then("Select the Plan description as {string}")
	public void select_plan_description_as(String planDesc) throws Throwable {

		library.elementstable(proposalPage.planDescription);
		if (planDesc.equalsIgnoreCase("Future Invest")) {
			Wcontrol.sendkeysByAction(proposalPage.planDescription, planDesc);
		} else if (planDesc.equalsIgnoreCase("Plan11")) {
			if (base.environemt.equalsIgnoreCase("ILIVE")) {
				Wcontrol.sendkeysByAction(proposalPage.planDescription,
						CustomerExceldata.TestDataInMap.get("Plan Descriptipn"));
				library.elementstable(proposalPage.planDescOption);
				library.waitForClickableElement(proposalPage.planDescOption);
				Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);
			} else {
				Wcontrol.sendkeysByAction(proposalPage.planDescription, planDesc);
				library.elementstable(proposalPage.planDescOption);
				library.waitForClickableElement(proposalPage.planDescOption);
				Wcontrol.ActionMoveToElementClcik(proposalPage.opt);
			}
		} else {
			Wcontrol.sendkeysByAction(proposalPage.planDescription, planDesc);
			Thread.sleep(1500);
			Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);
		}

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(proposalPage.autoUnderWritingYes);
			library.waitForClickableElement(proposalPage.autoUnderWritingYes);
		}
//		Wcontrol.clickJSEon(proposalPage.autoUnderWritingYes);
//		Thread.sleep(2000);
		defins.takeScreenShot("Screen Shot for the test");
		report.setPlanDesc(planDesc);
	}

	@Then("Validate the Fields in Life Tab for {string}")
	public void Validate_Life_Tab_Fields_for_Selected_Plan(String planDesc) throws Throwable {

		if (planDesc.equalsIgnoreCase("D-TRS")) {
			Wcontrol.clickJSEon(proposalPage.editIcon);
			Thread.sleep(1000);
			Wcontrol.clickJSEon(proposalPage.LifeRelation);
			Wcontrol.clearText(proposalPage.LifeRelation);
			Wcontrol.sendkeysByAction(proposalPage.LifeRelation, "DEBITOR");

			Wcontrol.clickJSEon(proposalPage.LifeIdentity);
			Wcontrol.sendkeysByAction(proposalPage.LifeIdentity, CustomerExceldata.TestDataInMap.get("Identity"));
			Thread.sleep(3000);
			Wcontrol.clickJSEon(proposalPage.LifeIdentityNumber);
			Wcontrol.sendkeysByAction(proposalPage.LifeIdentityNumber,
					CustomerExceldata.TestDataInMap.get("Identity number"));
			Thread.sleep(4000);
			Wcontrol.clickJSEon(proposalPage.tick1);

		} else if (planDesc.equalsIgnoreCase("Plan27")) {
			Add_Life_Assured();

		}
		defins.takeScreenShot("Screen Shot for the test");

	}

	@Then("Validate Proposer Particular")
	public void validate_Proposer_Particular() throws Throwable {
//		Thread.sleep(1000);
//		boolean val2 = base.getDriver().findElement(proposalPage.proposerNext).isDisplayed();
//		if (val2 == false) {
//			Wcontrol.clickJSEon(proposalPage.proposerParticularPanel);
//			Thread.sleep(700);
////			Wcontrol.clickJSEon(proposalPage.BasicNext);
//		}
		defins.takeScreenShot("Screen shot of the Test");
		Wcontrol.scrollDownLong();
		library.elementstable(proposalPage.proposerParticularPanel);
		library.waitForClickableElement(proposalPage.proposerParticularPanel);
		Wcontrol.clickJSEon(proposalPage.proposerParticularPanel);
	}

	@And("Change the SumAssured Value")
	public void Change_the_SumAssured_Value() throws Throwable {
		defins.takeScreenShot("Screen Shot for the test");
		Wcontrol.Click_and_ClearTextOn(proposalPage.initialSA);
		Wcontrol.sendkeysByAction(proposalPage.initialSA, "100002");
		defins.takeScreenShot("Screen Shot for the test");
	}

	@Then("Reject the Optional Rider and receive the Documents")
	public void Reject_the_Rider() throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(proposalPage.Save);
			library.waitForClickableElement(proposalPage.Save);
		}
		Wcontrol.scrollToView(proposalPage.BasePlan);
		library.waitForClickableElement(proposalPage.optionalRiders);
		Wcontrol.clickJSEon(proposalPage.optionalRiders);
		Wcontrol.scrollToView(proposalPage.optionalRiders);
		Wcontrol.ActionMoveToElementClcik(proposalPage.riderCheckBox);
		Wcontrol.clickJSEon(proposalPage.riderNext);

		Wcontrol.scrollToView(underWritingPage.documents);
		Wcontrol.clickJSEon(underWritingPage.documents);
		Wcontrol.scrollToView(underWritingPage.receiveDocuments);
		Wcontrol.clickJSEon(underWritingPage.receiveDocuments);

//		int temp = 0;
//		for (int i = 0; i < 10; i++) {
//			if (Wcontrol.GetTexton(underWritingPage.docsStatus).equalsIgnoreCase("Not Received")) {
//				Wcontrol.clickJSEon(underWritingPage.receiveDocuments);
//				Thread.sleep(500);
//			} else {
//				temp = 1;
//			}
//
//			if (temp > 0) {
//				break;
//			}
//		}
		defins.takeScreenShot("Screen Shot for the test");
		Wcontrol.clickJSEon(underWritingPage.documentNext);

	}

	@Then("Add the Optional Rider and receive the Documents")
	public void Add_the_Rider() throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(proposalPage.Save);
			library.waitForClickableElement(proposalPage.Save);
		}
		Wcontrol.scrollToView(proposalPage.optionalRiders);
		Wcontrol.clickJSEon(proposalPage.optionalRiders);
//		Wcontrol.scrollToView(proposalPage.optionalRiders);
		Wcontrol.scrollToView(proposalPage.BasePlan);

		Wcontrol.clickJSEon(proposalPage.addRider);
		Wcontrol.clickJSEon(proposalPage.newRiderName);
		Wcontrol.sendkeysByAction(proposalPage.newRiderName, "TERM RIDER");
		Wcontrol.sendkeysByAction(proposalPage.newRiderTerm, "20");
		Wcontrol.sendkeysByAction(proposalPage.newRiderPremium, "20");
		Wcontrol.sendkeysByAction(proposalPage.newRiderSA, "30000");
		Wcontrol.clickJSEon(proposalPage.newRiderTick);
		Wcontrol.ActionMoveToElementClcik(proposalPage.addRiderCheckBox);
		Wcontrol.clickJSEon(proposalPage.riderNext);

		Wcontrol.scrollToView(underWritingPage.documents);
		Wcontrol.clickJSEon(underWritingPage.documents);
		Wcontrol.scrollToView(underWritingPage.receiveDocuments);
		Wcontrol.clickJSEon(underWritingPage.receiveDocuments);
//		int temp = 0;
//		for (int i = 0; i < 10; i++) {
//			if (Wcontrol.GetTexton(underWritingPage.docsStatus).equalsIgnoreCase("Not Received")) {
//				Wcontrol.clickJSEon(underWritingPage.receiveDocuments);
//				Thread.sleep(500);
//			} else {
//				temp = 1;
//			}
//
//			if (temp > 0) {
//				break;
//			}
//		}
		defins.takeScreenShot("Screen Shot for the test");
		Wcontrol.clickJSEon(underWritingPage.documentNext);

	}

	@Then("Change the Sum Assured value for rider and Receive all the documents")
	public void change_SA_for_Rider() throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			Thread.sleep(4000);
		} else {
			library.elementstable(proposalPage.Save);
			library.waitForClickableElement(proposalPage.Save, 20);
		}

		Wcontrol.scrollDownMin();

//		Wcontrol.scrollToView(proposalPage.BasePlan);
		Wcontrol.scrollDownLittle();
		library.waitForClickableElement(proposalPage.optionalRiders, 30);
		Wcontrol.clickJSEon(proposalPage.optionalRiders);
//		Wcontrol.scrollToView(proposalPage.optionalRiders);
//		Wcontrol.scrollUpMin();
		Wcontrol.clickJSEon(proposalPage.optionalRiderEdit);
		Thread.sleep(1000);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int RoundedWidth = (int) Math.round(screenSize.getWidth());
		int RoundedHeight = (int) Math.round(screenSize.getHeight());

		String Width = Integer.toString(RoundedWidth);
		String Height = Integer.toString(RoundedHeight);

		if (Width.equalsIgnoreCase("1366") && Height.equalsIgnoreCase("768")) {

			String sumAssured = "(//*[contains(text(),'Optional Rider')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Sum Assured')]/parent::label/parent::span/parent::div//input)[1]";
			String Save = "//*[contains(text(),'Optional Rider')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Save')]";

			Wcontrol.Click_and_ClearTextOn(By.xpath(sumAssured));
			Wcontrol.EnterValueon(By.xpath(sumAssured), "40000");
			Wcontrol.clickJSEon(By.xpath(Save));
		} else {
			Wcontrol.Click_and_ClearTextOn(proposalPage.optionalRiderSA);
			Wcontrol.EnterValueon(proposalPage.optionalRiderSA, "40000");
			Wcontrol.clickJSEon(proposalPage.optionalRiderTick);
		}

		Wcontrol.clickJSEon(proposalPage.riderNext);

		Wcontrol.scrollDownLong();
		Wcontrol.clickJSEon(underWritingPage.documents);
//		Wcontrol.scrollDownLong();
		Wcontrol.scrollUpMin();
		Wcontrol.clickJSEon(underWritingPage.receiveDocuments);
		defins.takeScreenShot("Screen Shot for the test");
//		Wcontrol.clickJSEon(underWritingPage.documentNext);

	}

	@Then("Receive all the Documents from Document Section")
	public void Receive_the_Documents() throws Throwable {
//		mainStep.InvisibilityCondition(commonPage.animation);
//		library.elementstable(proposalPage.Save);
		library.waitForClickableElement(proposalPage.Save, 6);

		Wcontrol.scrollDownLong();
		Wcontrol.clickJSEon(proposalPage.UnderwritingQuestions);
		Wcontrol.clickJSEon(proposalPage.UWQuestionsNext);

		Wcontrol.clickJSEon(underWritingPage.documents);
//		Wcontrol.clickJSEon(underWritingPage.documents);
		Wcontrol.scrollUpLittle();
//		Wcontrol.ScrollToElement(underWritingPage.receiveDocuments);
		Wcontrol.clickJSEon(underWritingPage.receiveDocuments);
		Wcontrol.scrollDownLong();
		defins.takeScreenShot("Screen Shot for the test");
//		Wcontrol.clickJSEon(underWritingPage.documentNext);
	}

	@Then("Blacklist the Person in Underwriting")
	public void Blacklist_Person() throws Throwable {
//		Wcontrol.scrollToView(underWritingPage.underwritingHistory);
		Wcontrol.scrollDownLong();
		Wcontrol.clickJSEon(underWritingPage.blackList);
		Wcontrol.clickJSEon(underWritingPage.addBlackList);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int RoundedWidth = (int) Math.round(screenSize.getWidth());
		int RoundedHeight = (int) Math.round(screenSize.getHeight());

		String Width = Integer.toString(RoundedWidth);
		String Height = Integer.toString(RoundedHeight);
		if (Width.equalsIgnoreCase("1366") && Height.equalsIgnoreCase("768")) {
			
			By riskType = By.xpath("//*[contains(text(),'BlackList')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Risk Type')]/parent::label/parent::span/parent::div//mat-select");
			By actionCode = By.xpath("//*[contains(text(),'BlackList')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Action Code')]/parent::label/parent::span/parent::div//mat-select");
			By hospitalPeriod = By.xpath("//*[contains(text(),'BlackList')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Hospital Period')]/parent::label/parent::span/parent::div//input");
			By medicalCode = By.xpath("//*[contains(text(),'BlackList')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Medical Code 1')]/parent::label/parent::span/parent::div//input");
			By Save = By.xpath("//*[contains(text(),'BlackList')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Save')]");
			
			Wcontrol.click_and_Select(riskType, proposalPage.planDescOption);
			Wcontrol.click_and_Select(actionCode, proposalPage.planDescOption);
			Wcontrol.sendkeysByAction(hospitalPeriod, "3");
			Wcontrol.click_and_Select(medicalCode, proposalPage.planDescOption);
			Wcontrol.clickJSEon(Save);
			

		} else {
			Wcontrol.click_and_Select(underWritingPage.riskType, proposalPage.planDescOption);
			Wcontrol.click_and_Select(underWritingPage.actionCode, proposalPage.planDescOption);
			Wcontrol.sendkeysByAction(underWritingPage.hospitalPeriod, "3");
			Wcontrol.click_and_Select(underWritingPage.medicalCode1, proposalPage.planDescOption);
			Wcontrol.clickJSEon(underWritingPage.blackListTick);
		}

		

	}

//	@Then("Select the Individual Id and Enter the Identity numbersv")
//	public void Individual_id_and_identity_numberss() throws Throwable {
//
//		library.waitForClickableElement(proposalPage.proposerParticularPanel);
//		if (!base.getDriver().findElement(proposalPage.Identity).isDisplayed()) {
//			Wcontrol.clickJSEon(proposalPage.proposerParticularPanel);
//		}
//		Wcontrol.clearText(proposalPage.Identity);
//		Wcontrol.sendkeysByAction(proposalPage.Identity, Exceldata.TestDataInMap.get("Identity"));
//		report.setIdentity(Exceldata.TestDataInMap.get("Identity"));
//
//		
//		if(base.environemt.equalsIgnoreCase("ILIVE")){
//			Thread.sleep(3000);
//		} else {
//			Thread.sleep(1500);
//		}
//		
//		Wcontrol.clickJSEon(proposalPage.IDNumber);
//		Wcontrol.sendkeysByAction(proposalPage.IDNumber, Exceldata.TestDataInMap.get("FirstName"));
//		Thread.sleep(1500);
//
//		String err = Wcontrol.GetTexton(proposalPage.planDescOption).trim();
//		if (err.equalsIgnoreCase("No Data Found")) {
//			Wcontrol.Click_and_ClearTextOn(proposalPage.Identity);
//			Wcontrol.sendkeysByAction(proposalPage.Identity, Exceldata.TestDataInMap.get("Identity"));
//			Thread.sleep(1000);
//			Wcontrol.clickJSEon(proposalPage.IDNumber);
//			Wcontrol.EnterValueon(proposalPage.IDNumber, Exceldata.TestDataInMap.get("Identity number"));
//		}
//		List<WebElement> identityOptions = Wcontrol.GetAllElements(proposalPage.IdentityOPtions);
//		for (int i = 0; i < identityOptions.size(); i++) {
//			WebElement target = Wcontrol.GetElments(proposalPage.IdentityOPtions, i);
//			String NRIC = Wcontrol.GetTexton(target);
//			String pattern = "\\(";
//			String str2 = NRIC.replaceAll(pattern, "#").split("#")[0].trim();
//			if (str2.equalsIgnoreCase(Exceldata.TestDataInMap.get("Identity number"))) {
//				WebElement finalTarget = Wcontrol.GetElments(proposalPage.IdentityOPtions, i);
//				Wcontrol.ActionMoveToElementClcik(finalTarget);
//				break;
//			}
//		}
//
//		report.setIdentityNumber(Exceldata.TestDataInMap.get("Identity number"));
//
//	}

	@Then("Select the Currency and Enter the Sum Assured for {string}")
	public void Currency_and_Sum_assured_Selection_for_Plan(String planDesc) throws Throwable {
		Wcontrol.clearText(proposalPage.currency);
		if (!planDesc.equalsIgnoreCase("D-TRS")) {

			library.elementstable(proposalPage.currency);
			library.waitForClickableElement(proposalPage.currency, 30);
			Wcontrol.sendkeysByAction(proposalPage.currency, CustomerExceldata.TestDataInMap.get("Currency"));
			Thread.sleep(1200);
			report.setCurrency(CustomerExceldata.TestDataInMap.get("Currency"));
			library.elementstable(proposalPage.initialSA);
			library.waitForClickableElement(proposalPage.initialSA, 50);
			Wcontrol.sendkeysByAction(proposalPage.initialSA, CustomerExceldata.TestDataInMap.get("InitalSumAssured"));
			report.setInitialSumAssured(CustomerExceldata.TestDataInMap.get("InitalSumAssured"));
		} else if (planDesc.equalsIgnoreCase("D-TRS")) {
			Thread.sleep(2000);
			Wcontrol.sendkeysByAction(proposalPage.currency, CustomerExceldata.TestDataInMap.get("Currency"));
			report.setCurrency(CustomerExceldata.TestDataInMap.get("Currency"));
		}

	}

	@Then("Enter the policy Terms and change the Frequency for {string}")
	public void Premium_terms_and_change_the_frequency_for_Selected_Plan(String planDesc) throws Throwable {

//		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		String freq = CustomerExceldata.TestDataInMap.get("Frequency");
		if (planDesc.equalsIgnoreCase("Future Invest") || planDesc.equalsIgnoreCase("RSP")) {
			Wcontrol.sendkeysByAction(proposalPage.policyTerms, CustomerExceldata.TestDataInMap.get("PolicyTerms"));
			mainStep.Frequency_Select(freq);

		} else if (planDesc.equalsIgnoreCase("Plan11") || planDesc.equalsIgnoreCase("Plan27")) {
			Wcontrol.sendkeysByAction(proposalPage.policyTerms, CustomerExceldata.TestDataInMap.get("PolicyTerms"));
			mainStep.Frequency_Select(freq);
		} else if (planDesc.equalsIgnoreCase("D-TRS") || planDesc.equalsIgnoreCase("Plan19")) {
			Wcontrol.sendkeysByAction(proposalPage.policyTerms, CustomerExceldata.TestDataInMap.get("PolicyTerms"));
		} else if (planDesc.equalsIgnoreCase("Plan3")) {
			mainStep.Frequency_Select(freq);
		}

		report.setPolicyTerms(CustomerExceldata.TestDataInMap.get("PolicyTerms"));
		report.setFrequency(CustomerExceldata.TestDataInMap.get("Frequency"));
	}

	@And("Take ScreenShot")
	public void Take_Screenshot() throws Throwable {
		defins.takeScreenShot("Screen shot for the TestCase");
	}

	@Then("Select the short Payment method for {string}")
	public void Short_Payment_method_Selection_for_Selected_Plan(String planDesc) throws Throwable {

//		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
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
					loc = "(//mat-option)" + "[" + (i + 1) + "]";
					break;
				}
			}
		}
		Wcontrol.ActionMoveToElementClcik(By.xpath(loc));
		defins.takeScreenShot("Screen Shot for the test");
	}

	@And("click on the Life Detail and add the multiple Optional Rider details for {string}")
	public void LifeAssuredDetails_Add_MultipleLife_and_optionalRider_for_Selected_Plan(String planDesc)
			throws Throwable {

		mainStep.Add_Optional_Rider(0);
		mainStep.Last_Process();
		mainStep.Add_Multiple_Optional_Rider(planDesc);
		defins.takeScreenShot("Screen Shot for the test");
		mainStep.Last_Process();

	}

	@And("click on the Life Detail and add the Optional Rider details for {string}")
	public void LifeAssuredDetails_Add_OneLife_and_optionalRider_for_Selected_Plan(String planDesc) throws Throwable {

		if (!planDesc.equalsIgnoreCase("D-TRS") && !planDesc.equalsIgnoreCase("Plan19")) {
			int i = 0;
			mainStep.Add_Optional_Rider(i);
		}

	}

	@Then("add the Nominee Details")
	public void Add_the_Nominee_Details() throws Throwable {

		library.waitForVisibilityOfElement(proposalPage.nomineeIdentity, 60);
		library.elementstable(proposalPage.nomineeIdentity);
		Wcontrol.Click_and_ClearTextOn(proposalPage.nomineeIdentity);
		Wcontrol.sendkeysByAction(proposalPage.nomineeIdentity, CustomerExceldata.TestDataInMap.get("NomineeID"));

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation, 30);
		} else {
			library.waitForVisibilityOfElement(proposalPage.nomineeIdentityNumber, 60);
			library.elementstable(proposalPage.nomineeIdentityNumber);
			library.waitForClickableElement(proposalPage.nomineeIdentityNumber, 30);
		}

		Wcontrol.Click_and_ClearTextOn(proposalPage.nomineeIdentityNumber);
		Wcontrol.sendkeysByAction(proposalPage.nomineeIdentityNumber,
				CustomerExceldata.TestDataInMap.get("NomineeIDnumber"));

		library.waitForVisibilityOfElement(proposalPage.nomineeRelation, 60);
		library.elementstable(proposalPage.nomineeRelation);
		library.waitForClickableElement(proposalPage.nomineeRelation, 30);
		Wcontrol.Click_and_ClearTextOn(proposalPage.nomineeRelation);
		Wcontrol.sendkeysByAction(proposalPage.nomineeRelation, CustomerExceldata.TestDataInMap.get("NomineeRelation"));
		library.waitForVisibilityOfElement(By.xpath("//mat-option"), 60);
		Thread.sleep(500);
		Wcontrol.clickJSEon(By.xpath("//mat-option[1]"));
//		base.getDriver().findElement(proposalPage.nomineeRelation).sendKeys(Keys.ENTER);
//		List<WebElement> relationOptions = Wcontrol.GetAllElements(By.xpath("//mat-option"));
//		for (int i = 0; i < relationOptions.size(); i++) {
//			String relation = Wcontrol.GetTexton(relationOptions.get(i));
//			if (relation.equalsIgnoreCase("DAUGHTER") || relation.equalsIgnoreCase("DAUGHTER(DA)")) {
//				Wcontrol.ActionMoveToElementClcik(relationOptions.get(i));
//				break;
//			}
//		}

		library.waitForVisibilityOfElement(proposalPage.benefitShare, 60);
		library.elementstable(proposalPage.benefitShare);
		library.waitForClickableElement(proposalPage.benefitShare, 30);
		Wcontrol.EnterValueon(proposalPage.benefitShare, CustomerExceldata.TestDataInMap.get("BenifitShare"));
		Wcontrol.clickJSEon(proposalPage.nomineeTick);
		defins.takeScreenShot("Screen Shot for the test");

	}

	@Then("Select the Payer Options")
	public void Select_Payer_Options() throws Throwable {
		Wcontrol.click_and_Select(proposalPage.payerType, proposalPage.opt);
		Wcontrol.clickJSEon(proposalPage.payerRelation);
		Wcontrol.sendkeysByAction(proposalPage.payerRelation, "FRIEND");

		Wcontrol.Click_and_ClearTextOn(proposalPage.payerIDType);
		Wcontrol.sendkeysByAction(proposalPage.payerIDType, "NEW IDENTIFICATION NO");
		Thread.sleep(1000);
		Wcontrol.clickJSEon(proposalPage.payerIDNumber);
		Wcontrol.EnterValueon(proposalPage.payerIDNumber, "951006676531");

		Wcontrol.clickJSEon(proposalPage.payerIDNumber);
		Wcontrol.clickJSEon(proposalPage.payerIDNumber);
		Wcontrol.EnterKeyon(proposalPage.payerIDNumber, Keys.ENTER);
//		try {
//			Wcontrol.clickJSEon(proposalPage.payerIDNumber);
//			Wcontrol.clickJSEon(proposalPage.planDescOption);
//		} catch(Exception e) {
//			Wcontrol.clickJSEon(proposalPage.payerIDNumber);
//			Wcontrol.EnterKeyon(proposalPage.payerIDNumber, Keys.ENTER);
//		}

	}

	@Then("Change the Payment Method as {string}")
	public void Change_the_payment_Method(String paymentMethod) throws Throwable {
//		Wcontrol.Click_and_ClearTextOn(proposalPage.paymentMethod);
//		Wcontrol.sendkeysByAction(proposalPage.paymentMethod, paymentMethod);

		// AUTODEBIT(04) ,
//		DR (03)

		library.elementstable(proposalPage.paymentMethod);
		Wcontrol.clickJSEon(proposalPage.paymentMethod);
		library.elementstable(By.xpath("//mat-option"));
		List<WebElement> paymentMethodList = Wcontrol.GetAllElements(By.xpath("//mat-option"));
		for (int i = 0; i < paymentMethodList.size(); i++) {
			String opts = Wcontrol.GetTexton(paymentMethodList.get(i));
//			System.out.println(opts);
			if (opts.equalsIgnoreCase(paymentMethod)) {
				Wcontrol.ActionMoveToElementClcik(paymentMethodList.get(i));
				break;
			}
		}

	}

	@Then("Select the Details for {string}")
	public void Add_the_Various_Payment_Details(String paymentMethod) throws Throwable {
		if (paymentMethod.equalsIgnoreCase("AUTODEBIT")) {
			Thread.sleep(1000);
			library.elementstable(proposalPage.payerbankName);
			Wcontrol.clickJSEon(proposalPage.BankParticularNext);
			Wcontrol.clickJSEon(proposalPage.payerbankName);
			Wcontrol.Click_and_ClearTextOn(proposalPage.payerbankName);
			Wcontrol.sendkeysByAction(proposalPage.payerbankName, "CIMB");
			Thread.sleep(1500);
			Wcontrol.clickJSEon(proposalPage.payerBankAccountNumber);
			Wcontrol.sendkeysByAction(proposalPage.payerBankAccountNumber, mainStep.Generate_Random_Numbers());
			defins.takeScreenShot("Screen Shot for the test");
			Wcontrol.clickJSEon(proposalPage.BankParticularNext);
		} else if (paymentMethod.equalsIgnoreCase("SALARY DEDUCTION")) {
//			Wcontrol.doubleclickJSEon(proposalPage.payerCompanyName);
//			Wcontrol.ActionMoveToElement(proposalPage.payerCompanyName);
//			Wcontrol.clickJSEon(proposalPage.payerCompanyName);
//			Wcontrol.doubleclickJSEon(proposalPage.payerCompanyName);
//			Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);
//			Wcontrol.scrollToView(proposalPage.salaryDetuctionNext);
			Wcontrol.scrollDownLong();
			Wcontrol.scrollDownLittle();
			By icon = By.xpath(
					"//*[contains(text(),'Employer Name')]/ancestor::span/parent::div/following-sibling::div//mat-icon");
			Wcontrol.doubleClickon(icon);
			Wcontrol.clickJSEon(proposalPage.planDescOption);
			Wcontrol.clickJSEon(proposalPage.salaryDetuctionNext);
//			Wcontrol.clickJSEon(proposalPage.salaryDetuctionNext);

		} else if (paymentMethod.equalsIgnoreCase("ANGKASA DEDUCTION")) {
			Wcontrol.scrollDownLong();
			Wcontrol.scrollDownLittle();
			By icon = By.xpath(
					"//*[contains(text(),'Employer Name')]/ancestor::span/parent::div/following-sibling::div//mat-icon");
			Wcontrol.doubleClickon(icon);
			Wcontrol.clickJSEon(proposalPage.planDescOption);
			Wcontrol.clickJSEon(proposalPage.salaryDetuctionNext);
//			Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);
			Wcontrol.EnterValueon(proposalPage.memberShipNo, "201");
			Wcontrol.EnterValueon(proposalPage.membershipAccountNo, mainStep.Generate_Random_Numbers());
			Wcontrol.EnterValueon(proposalPage.detuctionCode, mainStep.Generate_Random_Numbers());
			Wcontrol.scrollToView(proposalPage.salaryDetuctionNext);
			Wcontrol.clickJSEon(proposalPage.salaryDetuctionNext);
		} else if (paymentMethod.equalsIgnoreCase("CCSI")) {
			Wcontrol.clickJSEon(proposalPage.cardType);
			Wcontrol.sendkeysByAction(proposalPage.cardType, "VISA CARD");
			Thread.sleep(500);
			Wcontrol.sendkeysByAction(proposalPage.cardNumber, mainStep.Get_Credit_Card_Number());
			Wcontrol.clickJSEon(proposalPage.cardBankName);
			Wcontrol.sendkeysByAction(proposalPage.cardBankName, "CIMB");
			Wcontrol.clickJSEon(proposalPage.collectingBankName);
			Wcontrol.sendkeysByAction(proposalPage.collectingBankName, "RHB  BANK HEAD OFFICE");
			Wcontrol.sendkeysByAction(proposalPage.validFromDate, mainStep.get_from_date());
			Wcontrol.sendkeysByAction(proposalPage.validToDate, mainStep.get_To_date());
			Wcontrol.scrollToView(proposalPage.creditCardNext);
			Wcontrol.clickJSEon(proposalPage.creditCardNext);

		}

	}

	@Then("Add the New Agent")
	public void Add_new_Agent() throws Throwable {
		Wcontrol.clickJSEon(proposalPage.agentEdit);
		Wcontrol.Click_and_ClearTextOn(proposalPage.tableinput);
		Wcontrol.sendkeysByAction(proposalPage.tableinput, "50");
		Wcontrol.clickJSEon(proposalPage.tick1);
		Wcontrol.clickJSEon(proposalPage.addAgent);
		Wcontrol.clickJSEon(proposalPage.agentCode);
		String ac = CustomerExceldata.TestDataInMap.get("AgentCode2");
		Wcontrol.sendkeysByAction(proposalPage.agentCode, ac);
		Thread.sleep(1000);
		String aa = CustomerExceldata.TestDataInMap.get("AgentPercentage2");
		Wcontrol.sendkeysByAction(proposalPage.agentPercent, aa);
		Wcontrol.clickJSEon(proposalPage.agentTick);
		defins.takeScreenShot("Screen Shot for the test");
	}

	@Then("Add the Family Details")
	public void Add_the_Family_Details() throws Throwable {
//		Wcontrol.scrollToView(proposalPage.otherPolicies);
		Wcontrol.scrollDownLong();
//		Wcontrol.scrollDownLong();
//		Wcontrol.scrollToView(underWritingPage.documents);
//		Wcontrol.clickJSEon(By.xpath("//div[contains(text(),'Life Assured Information')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Next')]"));
//		Wcontrol.scrollDownLong();
		Wcontrol.scrollDownLong();
		library.waitForClickableElement(proposalPage.FamilyTab);
		Wcontrol.clickJSEon(proposalPage.FamilyTab);
		Wcontrol.clickJSEon(proposalPage.addFamily);

		Wcontrol.sendkeysByAction(proposalPage.familyTabRelation, "FATHER");
		Thread.sleep(1000);
		List<WebElement> relationOptions = Wcontrol.GetAllElements(By.xpath("//mat-option"));
		for (int i = 0; i < relationOptions.size(); i++) {
			String relation = Wcontrol.GetTexton(relationOptions.get(i));
			if (relation.equalsIgnoreCase("FATHER")) {
				Wcontrol.ActionMoveToElementClcik(relationOptions.get(i));
				break;
			}
		}

		Wcontrol.sendkeysByAction(proposalPage.familyAge, "48");
		Wcontrol.sendkeysByAction(proposalPage.familyHealth, "ALCOHOLIC HEPATITIS");
		Wcontrol.clickJSEon(proposalPage.familyTick);
		defins.takeScreenShot("Screen Shot for the test");
		Wcontrol.clickJSEon(proposalPage.familyTabNext);

	}

	@Then("Add the Other Company Policies")
	public void Add_the_other_Policy() throws Throwable {
		library.waitForClickableElement(proposalPage.addPolicy);
		Wcontrol.clickJSEon(proposalPage.addPolicy);
		Wcontrol.sendkeysByAction(proposalPage.policyCompanyName, "MISSION 100");
		Wcontrol.sendkeysByAction(proposalPage.otherPolicyNumber, CustomerExceldata.TestDataInMap.get("PolicyNumber"));
		Wcontrol.sendkeysByAction(proposalPage.coverageSum, CustomerExceldata.TestDataInMap.get("InitalSumAssured"));
		Wcontrol.sendkeysByAction(proposalPage.basePlanOtherPolicy,
				CustomerExceldata.TestDataInMap.get("Plan Descriptipn"));
		Wcontrol.sendkeysByAction(proposalPage.statusOfpolicy, "In-Force");
		Wcontrol.clickJSEon(proposalPage.otherPolicyTick);
		defins.takeScreenShot("Screen Shot for the test");
		Wcontrol.clickJSEon(proposalPage.otherPolicyNext);
	}

	@Then("add the Non Forfeiture & Dividend Options")
	public void Non_Forfeiture_Option() throws Throwable {
		library.waitForClickableElement(proposalPage.nonForfeitureOption);
		Wcontrol.clickJSEon(proposalPage.nonForfeitureOption);
		Wcontrol.ActionMoveToElementClcik(proposalPage.opt);
		defins.takeScreenShot("Screen Shot for the test");
	}

	@Then("Add the Alternate Address")
	public void Add_Address() throws Throwable {

//		Wcontrol.scrollToView(By.xpath("//mat-panel-title[contains(text(),'Address Details')]"));
		Wcontrol.scrollUPLong();
		library.waitForClickableElement(registrationPage.addressType);
		Wcontrol.clickJSEon(registrationPage.addressType);
		Wcontrol.ActionMoveToElementClcik(proposalPage.opt);
		Thread.sleep(2000);

		Wcontrol.EnterValueon(registrationPage.address1, "Kedah");
		Wcontrol.sendkeysByAction(registrationPage.postCode, "7000");
		Thread.sleep(1500);
		defins.takeScreenShot("Screen Shot for the test");

		Wcontrol.scrollDownLong();
		Wcontrol.clickJSEon(registrationPage.addContact);
		Thread.sleep(1000);
		Wcontrol.sendkeysByAction(registrationPage.contactType, "MOBILE PHONE");
		Thread.sleep(500);
		library.elementstable(proposalPage.planDescOption);
		library.waitForClickableElement(proposalPage.planDescOption, 5);
		Wcontrol.EnterKeyon(registrationPage.contactType, Keys.ENTER);
		Thread.sleep(500);
		Wcontrol.EnterValueon(registrationPage.contactDesc, "8110966658");
		Wcontrol.clickJSEon(registrationPage.tick);
		defins.takeScreenShot("Screen Shot for the test");

	}

	@Then("Change the AddressType")
	public void Change_the_Address_Type() throws Throwable {
		library.waitForClickableElement(proposalPage.addressType);
		Wcontrol.clickJSEon(proposalPage.addressType);
		Wcontrol.ActionMoveToElementClcik(proposalPage.opt);
		defins.takeScreenShot("Screen Shot for the test");
	}

	@Then("Select the Quality Check Value as {string}")
	public void QualityCheck_Value_as_Something(String QCValue) throws Throwable {
		Wcontrol.clickJSEon(qualityCheck.qualityOptions);
		Thread.sleep(500);
		By clickBtn = null;
		switch (QCValue) {
		case "Yes":
			clickBtn = qualityCheck.qualityYes;
			break;
		case "No":
			clickBtn = qualityCheck.qualityNo;
			break;

		default:
			break;
		}
		Wcontrol.ActionMoveToElementClcik(clickBtn);
	}

	@And("then Fetch the Error msg")
	public void Fetch_the_error_msg() throws Throwable {
		String err = Wcontrol.GetTexton(By.xpath("//mat-error")).trim();
		Assert.assertEquals("POLICY NUMBER DOES NOT EXISTS", err);
		System.err.println(err);
	}

	@And("Tick the multiple Check box and select the QC options for the same")
	public void multipleQC() throws Throwable {
//		Wcontrol.scrollToView(qualityCheck.QualityCheckItems);
//		Wcontrol.clickJSEon(qualityCheck.QualityCheckItems);
//		Wcontrol.ActionMoveToElementClcik(qualityCheck.ItemsfullList);
		Wcontrol.scrollDownLong();
		Wcontrol.scrollDownLong();
		Wcontrol.scrollDownLittle();
		Wcontrol.clickJSEon(qualityCheck.QualityCheckItems);
		Wcontrol.clickJSEon(proposalPage.opt);

		List<WebElement> checkbox = Wcontrol.GetAllElements(qualityCheck.checkBox);
		List<WebElement> QualityCheckOptions = Wcontrol.GetAllElements(qualityCheck.qualityOptions2);
		Wcontrol.scrollUPLong();
		Wcontrol.clickJSEon(checkbox.get(2));
		Wcontrol.clickJSEon(QualityCheckOptions.get(2));
		Wcontrol.clickJSEon(qualityCheck.qualityYes);
		Thread.sleep(500);

		Wcontrol.clickJSEon(checkbox.get(4));
		Wcontrol.clickJSEon(QualityCheckOptions.get(4));
		Wcontrol.clickJSEon(qualityCheck.qualityYes);
		Thread.sleep(500);

		Wcontrol.scrollDownLittle();
		Wcontrol.clickJSEon(checkbox.get(6));
		Wcontrol.clickJSEon(QualityCheckOptions.get(6));
		Wcontrol.clickJSEon(qualityCheck.qualityYes);
		Thread.sleep(500);
		Wcontrol.scrollDownLong();

	}

	@Then("click on the CheckBox for dispatch")
	public void click_on_checkBox_for_dispatch() throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(qualityCheck.checkBox1);
			library.waitForClickableElement(qualityCheck.checkBox1, 20);
		}

//		Wcontrol.scrollToView(qualityCheck.recordsPerPage);
//		Wcontrol.scrollDownLong();
//		Wcontrol.clickJSEon(qualityCheck.recordsPerPage);
//		Wcontrol.ActionMoveToElementClcik(proposalPage.riderOpt);
		Wcontrol.scrollDownLong();
		Wcontrol.clickJSEon(qualityCheck.checkBox1);
		Wcontrol.scrollToView(qualityCheck.dispatchButton);
	}

	@Then("click on the CheckBox and Acknowledge as {string}")
	public void Acknowledge_as_something(String acknowledgeType) throws Throwable {
		Thread.sleep(1500);
		defins.takeScreenShot("Screen of the Test");
		Wcontrol.clickJSEon(qualityCheck.checkBox);
		Wcontrol.MovejsClick(qualityCheck.acknowledgeTableEdit);
		By saveBtn = By.xpath("//*[contains(text(),'Acknowledge Policy')]/parent::*//*[contains(text(),'Save')]");
		boolean value = base.getDriver().findElement(saveBtn).isDisplayed();
//		System.out.println(value);
		if (value == true) {
			By AcknowledgeType = By.xpath(
					"//*[contains(text(),'Acknowledge Policy')]/parent::*//*[contains(text(),'Acknowledge Type')]//parent::*/parent::*/parent::div//mat-select");
			Wcontrol.click_and_Select(AcknowledgeType, proposalPage.planDescOption);
			Wcontrol.clickJSEon(saveBtn);

		} else {
			Wcontrol.clickJSEon(qualityCheck.acknowledgeTypeBtn);
			if (acknowledgeType.equalsIgnoreCase("Accepted")) {
				Wcontrol.ActionMoveToElementClcik(qualityCheck.accept);
			} else {
				Wcontrol.ActionMoveToElementClcik(qualityCheck.reject);
			}
			defins.takeScreenShot("Screen of the Test");
			Wcontrol.MovejsClick(qualityCheck.acknowledgeTick);

		}

	}

	@Then("Enter the Policy Number as {string}")
	public void Enter_The_policy_Number_in_policy_to_proposal_Page(String policyNumber) throws Throwable {

		if (base.environemt.equalsIgnoreCase("ILIVE")) {
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(qualityCheck.policyNumber);
			library.waitForClickableElement(qualityCheck.policyNumber, 20);
		}
		Wcontrol.sendkeysByAction(qualityCheck.policyNumber, policyNumber);
		Thread.sleep(500);
	}

	@Then("Change to BackDated Option")
	public void BackDated_policy() throws Throwable {
		Wcontrol.scrollToView(proposalPage.commencementDateOption);
		Wcontrol.click_and_Select(proposalPage.commencementDateOption, proposalPage.options);
		Thread.sleep(500);
		Wcontrol.clickJSEon(proposalPage.commencementDateicon);
		Wcontrol.clickJSEon(proposalPage.yearButton);
		Wcontrol.clickJSEon(proposalPage.yearSelect);
		Wcontrol.clickJSEon(proposalPage.monthSelect);
		Wcontrol.clickJSEon(proposalPage.dateSelect);
		Wcontrol.click_and_Select(proposalPage.backDate, proposalPage.planDescOption);

	}

	@Then("click Yes on Validation Tab")
	public void click_yes_on_Validation_Tab() throws Throwable {
		if (base.getDriver().findElements(proposalPage.tableFields).size() > 0) {
			Wcontrol.clickJSEon(proposalPage.WarningYes);
		}
	}

	public void Receive_Docs() throws Throwable {
		Wcontrol.scrollToView(underWritingPage.documents);
//		Wcontrol.ScrollToElement(underWritingPage.documents);
		Wcontrol.clickJSEon(underWritingPage.documents);
//		Wcontrol.scrollToView(underWritingPage.receiveDocuments);
		Wcontrol.scrollUpMin();
		Wcontrol.clickJSEon(underWritingPage.receiveDocuments);
		Wcontrol.scrollDownMin();
		defins.takeScreenShot("Screen Shot for the test");
		Wcontrol.clickJSEon(underWritingPage.documentNext);
	}

	@Then("Add one LA")
	public void Add_Life_Assured() throws Throwable {
		Wcontrol.clickJSEon(proposalPage.AddLA);
		Thread.sleep(1000);
		By saveBtn = By.xpath(
				"//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//*[contains(text(),'Save')]");
		boolean value = base.getDriver().findElement(saveBtn).isDisplayed();
//		System.out.println(value);
		if (value == true) {
			By LaRelation = By.xpath(
					"//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//*[contains(text(),'Relationship with Proposer')]/parent::label/parent::span/parent::div//input");
			By LaIdentityType = By.xpath(
					"//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//*[contains(text(),'Identity Type')]/parent::label/parent::span/parent::div//input");
			By LaIdentityNo = By.xpath(
					"//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//*[contains(text(),'Identity No')]/parent::label/parent::span/parent::div//input");

			Wcontrol.clearText(LaRelation);
			Wcontrol.sendkeysByAction(LaRelation, CustomerExceldata.TestDataInMap.get("LARelation"));
			library.elementstable(proposalPage.planDescOption);
			Wcontrol.clickJSEon(proposalPage.planDescOption);
			Wcontrol.EnterValueon(LaIdentityType, CustomerExceldata.TestDataInMap.get("AnotherLAIdentity"));
			if (base.environemt.equalsIgnoreCase("ILIVE")) {
				Thread.sleep(4000);
			} else {
				library.elementstable(LaIdentityNo);
				library.waitForClickableElement(LaIdentityNo);
				Thread.sleep(500);
			}
			Wcontrol.EnterValueon(LaIdentityNo, CustomerExceldata.TestDataInMap.get("AnotherLAIdentityNumber"));

			if (base.environemt.equalsIgnoreCase("ILIVE")) {
				Thread.sleep(4000);
			} else {
				Thread.sleep(500);
			}
			Wcontrol.clickJSEon(saveBtn);
		}

	}

	@Then("Delete one LA")
	public void Delete_the_Life_Assured() throws Throwable {
		Wcontrol.clickJSEon(proposalPage.DeleteLA);
		library.waitForClickableElement(proposalPage.deleteConformation);
		Wcontrol.clickJSEon(proposalPage.deleteConformation);
		Thread.sleep(1000);
	}

}
