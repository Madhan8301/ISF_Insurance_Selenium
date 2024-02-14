package com.kgisl.stepDefinition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import com.kgisl.runner.RunParallelTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ProposePageStepDefinitions {

	public WebControl Wcontrol;
	public LibraryClass library;
	public CommonPageElements commonPage;
	public RegistrationPage registrationPage;
	public UnderwritingPage underWritingPage;
	public QualityCheck qualityCheck;
	public Hooks base;
	public ProposalPage proposalPage;
	public List<String> referenceNumbers = new ArrayList<String>();
	static Map maps = new HashMap();
	private String TestId = null;
	private ReportOut report;
	public BaseDefins defins;
	public String returnedPolicyNumber,policyStatus,returnedVoucherNumber,referenceNumber;
	
	private RiderExcelUtility RiderExceldata;
	private CustomerExcelUtility CustomerExceldata;

	private String sheetName = null;
	private Data_Set Data;

	private Map<String, String> InputData;
	private ExcelUtility Exceldata;
	FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);

	public ProposePageStepDefinitions(WebControl wcontrol, LibraryClass library, CommonPageElements commonPage,
			RegistrationPage registrationPage, ProposalPage proposalPage, Hooks base, Data_Set Data,
			ExcelUtility Exceldata, ReportOut report, UnderwritingPage underWritingPage, BaseDefins defins,
			RiderExcelUtility RiderExceldata,CustomerExcelUtility CustomerExceldata) {

		this.Wcontrol = wcontrol;
		this.library = library;
		this.commonPage = commonPage;
		this.registrationPage = registrationPage;
		this.base = base;
		this.Data = Data;
		this.Exceldata = Exceldata;
		this.proposalPage = proposalPage;
		this.report = report;
		this.underWritingPage = underWritingPage;
		this.defins = defins;
		this.RiderExceldata=RiderExceldata;
		this.CustomerExceldata=CustomerExceldata;
	}



	@Then("^Select \"([^\"]*)\" in the Plan description$")
	public void select_something_in_the_plan_description(String plan) throws Throwable {
		// library.waitForInVisibilityOfElement(commonPage.animation);
		Thread.sleep(2000);
		Wcontrol.sendkeysByAction(proposalPage.planDescription, plan);
		Thread.sleep(2000);
		report.setPlanDesc(CustomerExceldata.TestDataInMap.get("Plan Descriptipn"));
//		Wcontrol.EnterKeyon(proposalPage.planDescription, Keys.DOWN);
//		Wcontrol.EnterKeyon(proposalPage.planDescription, Keys.ENTER);
	}

	@And("Enter the Policy number {string} and click on Search button")
	public void enter_the_something_and_click_on_search_button(String policyNumber) throws Throwable {

		library.waitForInVisibilityOfElement(commonPage.animation);
		// library.waitForVisibilityOfElement(underWritingPage.policyNumber);
		// Thread.sleep(5000);
		Wcontrol.EnterValueon(underWritingPage.policyNumber, policyNumber);
		// report.setPolicyNumber(policyNumber);
		Wcontrol.clickJSEon(underWritingPage.Search);
	}

	@Then("^Get the DialogBox Details and click on OK button$")
	public void get_the_dialogbox_details_and_click_on_ok_button() throws Throwable {

		Thread.sleep(2000);
		By dig = By.xpath("//ancestor::mat-dialog-container//app-common-dialog-box//*[contains(text(),'OK')]/parent::button");
		library.elementstable(dig);
		
		
		String returnedPolicyNumber1 = Wcontrol.GetTexton(registrationPage.dialogboxDetails);
		returnedPolicyNumber = returnedPolicyNumber1.split("Is")[0].split("! Policy")[1].trim();
		System.out.println(returnedPolicyNumber1);
		System.out.println(returnedPolicyNumber + " - " + CustomerExceldata.TestDataInMap.get("FirstName"));
		defins.InsertQuery(returnedPolicyNumber);
//		Wcontrol.clickJSEon(registrationPage.dialogboxOK);
		defins.takeScreenShot("Screen Shot for the test");
		Wcontrol.clickJSEon(registrationPage.dialogboxOK);
//		dialogBoxOK.click();
		
		policyStatus = returnedPolicyNumber1.split("Is")[1].trim();
		
		
		

	}
	@Then("Get The Reference number")
	public void getReferenceNumber() throws Throwable {
	    referenceNumber = Wcontrol.GetTexton(By.xpath("//h4"));
	    referenceNumber = referenceNumber.split("Number:")[1].split("Data saved")[0].trim();
		System.out.println(referenceNumber);
		
//		defins.InsertQuery(ref);
//		WebElement dialogBoxOK = library.fluient_Wait(registrationPage.dialogboxOK);
	}

	@Then("^Get the DialogBox Detail and click on OK button$")
	public void get_the_dialogbox_detail_and_click_on_ok_button() throws Throwable {
		
		
		library.elementstable(registrationPage.dialogboxOK);
		library.waitForPresenceOfElement(registrationPage.dialogboxDetails,30);
		library.waitForClickableElement(registrationPage.dialogboxOK,30);
//		String ref = Wcontrol.GetTexton(By.xpath("(//h4)[2]"));
//		ref = ref.split("Number:")[1].split("Data saved")[0].trim();
//		System.out.println(ref);
//		defins.InsertQuery(ref);
//		WebElement dialogBoxOK = library.fluient_Wait(registrationPage.dialogboxOK);
		defins.takeScreenShot("Screen Shot for the test");
		Wcontrol.clickJSEon(registrationPage.dialogboxOK);
//		dialogBoxOK.click();

	}

	@Then("^Select the Individual Id as \"([^\"]*)\" and Enter the Identity number as \"([^\"]*)\"$")
	public void select_the_individual_id_as_something_and_enter_the_identity_number_as_something(String id,
			String idnumber) throws Throwable {
		Wcontrol.clearText(proposalPage.Identity);
		Wcontrol.sendkeysByAction(proposalPage.Identity, CustomerExceldata.TestDataInMap.get("Identity"));
		report.setIdentity(CustomerExceldata.TestDataInMap.get("Identity"));

		Thread.sleep(2000);
		Wcontrol.clickJSEon(proposalPage.IDNumber);

		Wcontrol.sendkeysByAction(proposalPage.IDNumber, CustomerExceldata.TestDataInMap.get("Identity number"));
		report.setIdentityNumber(CustomerExceldata.TestDataInMap.get("Identity number"));

	}
	
	public void UW_Wait() throws Throwable {
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

	@And("^click on the \"([^\"]*)\" button$")
	public void click_on_the_something_button(String button) throws Throwable {
		By clickbtn = null;
		switch (button) {
		case "Create Proposal":
			library.elementstable(proposalPage.AddProposal);
			library.waitForClickableElement(proposalPage.AddProposal, 50);
			clickbtn = proposalPage.AddProposal;
			break;
			
		case "Credit Card Next":
			clickbtn = proposalPage.creditCardNext;
			break;
		
		case "To Proposal":
			Wcontrol.scrollUPLong();
			clickbtn = underWritingPage.toProposal;
			break;
			
		case "Search Policy":
			library.elementstable(underWritingPage.Search);
			library.waitForClickableElement(underWritingPage.Search);
			clickbtn = underWritingPage.Search;
			break;
			
		case "BasePlanNextUW":
			clickbtn = underWritingPage.basePlanNext;
			Wcontrol.scrollDownMin();
			break;
			
		case "Own Policies":
			library.waitForClickableElement(underWritingPage.ownPolicies);
			clickbtn = underWritingPage.ownPolicies;
			break;
			
		case "Life AUW Rules":
			library.waitForClickableElement(underWritingPage.lifeAUWrules);
			clickbtn = underWritingPage.lifeAUWrules;
			break;
			
		case "Angaska Next":
			clickbtn = proposalPage.salaryDetuctionNext;
			break;
			
		case "Base Plan Next":
			clickbtn = underWritingPage.basePlanNext;
			Wcontrol.scrollToView(clickbtn);
			break;

		case "Previous":
			Wcontrol.scrollDownLong();
			clickbtn = proposalPage.previous;
			Thread.sleep(500);
			break;

		case "Basic Next":
//			Thread.sleep(1500);
			clickbtn = proposalPage.BasicNext;
			library.elementstable(proposalPage.planDescription);
			library.waitForVisibilityOfElement(proposalPage.planDescription);
			library.waitForClickableElement(proposalPage.planDescription);
			Wcontrol.scrollDownLong();
			library.elementstable(clickbtn);
			library.waitForPresenceOfElement(clickbtn);
			library.waitForVisibilityOfElement(clickbtn);
			library.waitForClickableElement(clickbtn);
			break;

		case "Bank Particular Next":
			clickbtn = proposalPage.BankParticularNext;
			break;
			
		case "Proposer Next":
			Wcontrol.scrollToView(proposalPage.proposerNext);
			Wcontrol.scrollDownLong();
			clickbtn = proposalPage.proposerNext;
			break;

		case "Nominee Next":
			
			clickbtn = proposalPage.nomineeNext;
			break;

		case "Staff Next":

			String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
			if (planDesc.equalsIgnoreCase("Plan19")) {
				Wcontrol.scrollDownLong();
				Wcontrol.clickJSEon(proposalPage.EPFNext);
				Thread.sleep(1000);
				clickbtn = proposalPage.StaffNext;
			} else {
				Wcontrol.scrollDownLong();
				clickbtn = proposalPage.StaffNext;
			}

			break;

		case "Add Nominiee":
			clickbtn = proposalPage.addNominee;
			break;
		case "Policy Next":
			Thread.sleep(500);
			Wcontrol.scrollToView(proposalPage.policyNext);
			Wcontrol.scrollDownMin();
			Wcontrol.scrollDownLong();
//			Wcontrol.scrollToView(proposalPage.policyNext);
			library.elementstable(proposalPage.policyNext);
			library.waitForClickableElement(proposalPage.policyNext, 30);
			clickbtn = proposalPage.policyNext;
			break;
		case "staff next":
			Wcontrol.scrollDownLong();
			clickbtn = proposalPage.StaffNext;
			break;
		case "Payment Next":
			clickbtn = proposalPage.PaymentNext;
			break;
		case "Payer Next":
			Wcontrol.scrollDownMin();
			clickbtn = proposalPage.PayerNext;
			break;
		case "Agent":
			clickbtn = proposalPage.agentTab;
			break;
		case "Fund":
			clickbtn = proposalPage.fundTab;
			break;
		case "Life view":
			clickbtn = proposalPage.LifeAssuredView;
			break;
			
		case "Life view2":
			clickbtn = proposalPage.LifeAssuredView1;
			break;

		case "Life":
			clickbtn = proposalPage.LifeTab;
			break;
		case "save":
			library.elementstable(proposalPage.Save);
			library.waitForClickableElement(proposalPage.Save);
			clickbtn = proposalPage.Save;
			break;
		case "Servicing options":
			clickbtn = proposalPage.servicingOptions;
			break;
		case "Nomination":
			clickbtn = proposalPage.nominationTab;
			break;
		case "Process":
			Wcontrol.scrollToView(proposalPage.process);
			Wcontrol.scrollUPLong();
//			Wcontrol.scrollToView(proposalPage.process);
			clickbtn = proposalPage.process;
			break;
		case "Short Payment Next":
			clickbtn = proposalPage.shortPaymentNext;
			break;
		case "Divident Next":
			clickbtn = proposalPage.dividentNext;
			break;
		case "Save Draft":
			clickbtn = proposalPage.saveDraft;
			break;
		case "final Save":
			Thread.sleep(500);
			clickbtn = proposalPage.finalSave;
			library.elementstable(clickbtn);
			library.waitForClickableElement(clickbtn);
			library.waitForPresenceOfElement(clickbtn);
			break;

		default:
			break;
		}
//		library.waitForInVisibilityOfElement(commonPage.animation);

		if (button.equalsIgnoreCase("Create Proposal")) {
//			library.waitForInVisibilityOfElement(commonPage.animation);
//			invisiblelements();
			library.waitForPresenceOfElement(clickbtn);
			library.waitForVisibilityOfElement(clickbtn);
			Wcontrol.ActionMoveToElement(clickbtn);
			Wcontrol.clickJSEon(clickbtn);
		}else if(button.equalsIgnoreCase("Life view") || button.equalsIgnoreCase("Life view2")) {
			Wcontrol.clickJSEon(clickbtn);
			library.elementstable(proposalPage.Save);
		} else if (button.equalsIgnoreCase("Life")) {
//			library.waitForVisibilityOfElement(clickbtn,30);
			library.waitForClickableElement(clickbtn,30);
			Wcontrol.clickJSEon(clickbtn);
			Wcontrol.clickJSEon(clickbtn);
			Wcontrol.clickJSEon(clickbtn);
		} else if(button.equalsIgnoreCase("Process")) {
			Wcontrol.ActionMoveToElementClcik(clickbtn);
			library.elementstable(By.xpath("//*[contains(text(),'Pop Out')]"));
			library.waitForClickableElement(By.xpath("//*[contains(text(),'Pop Out')]"));
			
		}else if(button.equalsIgnoreCase("save") || CustomerExceldata.TestDataInMap.get("Plan Descriptipn").equalsIgnoreCase("D-TRS")) {
			Thread.sleep(200);
			Wcontrol.clickJSEon(clickbtn);
		} else if(button.equalsIgnoreCase("Own Policies")) {
			library.waitForVisibilityOfElement(clickbtn,30);
			library.waitForClickableElement(clickbtn,30);
			Wcontrol.clickJSEon(clickbtn);
			Wcontrol.scrollDownLong();
			defins.takeScreenShot("Screen shot of the Test");
			Wcontrol.scrollUPLong();
			Wcontrol.scrollUPLong();
			Wcontrol.clickJSEon(underWritingPage.toProposal);
			UW_Wait();
		} else if(button.equalsIgnoreCase("Life AUW Rules")) {
			library.elementstable(clickbtn);
			library.waitForClickableElement(clickbtn, 30);
			Wcontrol.MovejsClick(clickbtn);
			Wcontrol.scrollDownLong();
//			Wcontrol.MovejsClick(underWritingPage.lifeAWUrulesRecords);
			Wcontrol.click_and_Select(underWritingPage.lifeAWUrulesRecords, proposalPage.opt);
			Wcontrol.scrollDownLong();
			defins.takeScreenShot("Screen shot of Auto Underwriting Rules......");
			
		}else {
			library.waitForVisibilityOfElement(clickbtn,30);
			library.waitForClickableElement(clickbtn,30);
			Wcontrol.clickJSEon(clickbtn);
		}

	}
	
public void invisiblelements() throws Throwable {
		
		library.waitForInVisibilityOfElement(By.xpath("(//app-root//div//ng-http-loader//div)[1]//sk-wave"));
	}



	@And("Select the Agent Name as {string}")
	public void Select_Agent_Name(String agentName) throws Throwable {
		Thread.sleep(2000);
		Wcontrol.scrollToView(proposalPage.AgentName);
		Wcontrol.sendkeysByAction(proposalPage.AgentName, CustomerExceldata.TestDataInMap.get("Agent Name"));
		report.setAgentName(CustomerExceldata.TestDataInMap.get("Agent Name"));
	}

	@Then("^Select the Currency as \"([^\"]*)\" and Enter the Sum Assured as \"([^\"]*)\"$")
	public void select_the_currency_as_something_and_enter_the_sum_assured_as_something(String currency,
			String sunAssured) throws Throwable {
		// library.waitForVisibilityOfElement(proposalPage.currency);
		Thread.sleep(2000);
		Wcontrol.sendkeysByAction(proposalPage.currency, CustomerExceldata.TestDataInMap.get("Currency"));
		report.setCurrency(CustomerExceldata.TestDataInMap.get("Currency"));
		Wcontrol.sendkeysByAction(proposalPage.initialSA, Exceldata.TestDataInMap.get("InitalSumAssured"));
		report.setInitialSumAssured(CustomerExceldata.TestDataInMap.get("InitalSumAssured"));
	}

	@Then("^Enter the policy Terms as \"([^\"]*)\" and change the Frequency as \"([^\"]*)\"$")
	public void enter_the_premium_terms_as_something_and_change_the_frequency_as_something(String policyTerms,
			String frequency) throws Throwable {

		Wcontrol.sendkeysByAction(proposalPage.policyTerms, CustomerExceldata.TestDataInMap.get("PolicyTerms"));
		// Wcontrol.scrollToView(proposalPage.frequency);
		Wcontrol.clearText(proposalPage.frequency);
		Wcontrol.sendkeysByAction(proposalPage.frequency, CustomerExceldata.TestDataInMap.get("Frequency"));
		report.setPolicyTerms(CustomerExceldata.TestDataInMap.get("PolicyTerms"));
		report.setFrequency(CustomerExceldata.TestDataInMap.get("Frequency"));
	}
	
	@Then("Get Voucher Number and Click on OK button")
	public void voucher_Details_and_Click_OK_Button() throws Throwable {
//		defins.takeScreenShot("Screen shot of the Test");
		library.elementstable(registrationPage.dialogboxOK);
//		String v_num = Wcontrol.GetAttributeValueon(qualityCheck.voucherDialogbox, "value");
		
//		Object s = base.getDriver().findElement(qualityCheck.voucherDialogbox).getAttribute("innerHTML");
//		String item =  item.strip();
//		data = [ for item in s.split("<br>")];
				
		String v_num=base.getDriver().findElement(qualityCheck.voucherDialogbox).getAttribute("innertext");
		System.out.println(v_num);
		returnedVoucherNumber = v_num.split("Generated")[1].trim();
//		System.out.println(returnedPolicyNumber);
	}
	

	@And("^Enter the User Premium as \"([^\"]*)\"$")
	public void enter_the_user_premium_as_something(String userPremium) throws Throwable {
		Wcontrol.EnterValueon(proposalPage.userPremium, CustomerExceldata.TestDataInMap.get("UserPremium"));
		report.setUserPremium(CustomerExceldata.TestDataInMap.get("UserPremium"));
	}

	@And("^Enter the Premium pattern as \"([^\"]*)\" and Enter the Sum Assuren Pattern as \"([^\"]*)\"$")
	public void enter_the_premium_pattern_as_something_and_enter_the_sum_assuren_pattern_as_something(
			String premiumPattern, String SApattern) throws Throwable {
		Wcontrol.sendkeysByAction(proposalPage.premiumPattern, CustomerExceldata.TestDataInMap.get("PremiumPattern"));
		Wcontrol.sendkeysByAction(proposalPage.SAPattern, CustomerExceldata.TestDataInMap.get("SAPattern"));
		report.setPremiumPattern(CustomerExceldata.TestDataInMap.get("PremiumPattern"));
		report.setSumAssuredPattern(CustomerExceldata.TestDataInMap.get("SAPattern"));

	}

//	@Then("Add the Funds the Share box as {string} only in the {string} , {string} Fund Names with AFB as {string}")
	@Then("Add the Funds for Unit Linked Product with AFB Option")
	public void Add_the_Funds() throws Throwable {
		
		String planDesc = CustomerExceldata.TestDataInMap.get("Plan Descriptipn");
		String fundPercentage1 = RiderExceldata.TestDataInMap.get("Fund Percentage1");
		String name1 = RiderExceldata.TestDataInMap.get("FundCode1");
		String name2 = RiderExceldata.TestDataInMap.get("FundCode2");
		String AFBOption = RiderExceldata.TestDataInMap.get("AFB_Option");
		
		if (planDesc.equalsIgnoreCase("Future Invest") || planDesc.equalsIgnoreCase("Plan21") || planDesc.equalsIgnoreCase("RSP")) {

			// Wcontrol.clickJSEon(proposalPage.fundTab);

			Thread.sleep(500);
			if(AFBOption.equalsIgnoreCase("Yes")) {
				Wcontrol.clickJSEon(proposalPage.unitLinkOption);
				Wcontrol.click_and_Select(proposalPage.autoFundBalance, proposalPage.planDescOption);
				Wcontrol.click_and_Select(proposalPage.afbFrequency, proposalPage.planDescOption);
				Wcontrol.sendkeysByAction(proposalPage.afbFundAmount, "100");
				Wcontrol.clickJSEon(proposalPage.unitLinkNext);
			}
			


			List<WebElement> fundNames = Wcontrol.GetAllElements(proposalPage.fundName);
//			List<WebElement> editIcons = Wcontrol.GetAllElements(proposalPage.fundEdit);
			int fundCount = fundNames.size();
			int Count = 0;
			String[] arr = { name1, name2 };
			List<String> arr1 = Arrays.asList(arr);
			for (int i = 0; i < fundCount; i++) {
//				WebElement target = Wcontrol.GetElments(proposalPage.fundName, i);
//				String name = Wcontrol.GetTexton(target).trim();
				String fundName_Loc = "((//*[contains(text(),'Fund Particular')])[1]/ancestor::mat-expansion-panel//table//tbody//tr//td[1])["+(i+1)+"]";						
				String name = base.getDriver().findElement(By.xpath(fundName_Loc)).getText();
				if (arr1.contains(name)) {
//					WebElement edit = Wcontrol.GetElments(proposalPage.fundEdit, i);
//					Wcontrol.clickJSEon(edit);
//					Wcontrol.clickJSEon(proposalPage.share1);
//					Wcontrol.EnterValueon(proposalPage.share1, funds);
////					Wcontrol.clickJSEon(proposalPage.share);
////					Wcontrol.EnterValueon(proposalPage.share, funds);
//					Wcontrol.clickJSEon(proposalPage.tick1);
//					Thread.sleep(300);
					String edit_Loc = "((//*[contains(text(),'Fund Particular')])[1]/ancestor::mat-expansion-panel//table//*[contains(text(),'edit')])["+(i+1)+"]";
					Wcontrol.clickJSEon(By.xpath(edit_Loc));
					if(AFBOption.equalsIgnoreCase("YES")) {
						Wcontrol.clickJSEon(proposalPage.share1);
						Wcontrol.EnterValueon(proposalPage.share1, fundPercentage1);
						Wcontrol.clickJSEon(proposalPage.share);
						Wcontrol.EnterValueon(proposalPage.share, fundPercentage1);
					} else {
						Wcontrol.clickJSEon(proposalPage.share1);
						Wcontrol.EnterValueon(proposalPage.share1, fundPercentage1);
					}
					Wcontrol.clickJSEon(proposalPage.tick1);
					Count++;
					if(Count==2) {
						break;
					}
				}
			}
			defins.takeScreenShot("Screen Shot for the test");
		}

	}
	
	@Then("Add the Strategy Fund")
	public void Strategy_fund_Section() throws Throwable {
		
		String StratName = RiderExceldata.TestDataInMap.get("StrategyFundName");
		String fundShare = RiderExceldata.TestDataInMap.get("StrategyFundPercentage");
		
//		Wcontrol.scrollToView(proposalPage.fundParticularNext);
		Wcontrol.scrollDownLong();
		
		Wcontrol.clickJSEon(proposalPage.fundParticularNext);
		List<WebElement> n1 = Wcontrol.GetAllElements(proposalPage.strategyName);
		List<String> strategyNamesList = new ArrayList<String>();
		for(int i=0;i<n1.size();i=i+2) {
			String names = Wcontrol.GetTexton(n1.get(i));
			strategyNamesList.add(names);
		}
		List<WebElement> edits = Wcontrol.GetAllElements(proposalPage.strategyEdit);
		for(int j=0;j<edits.size();j++) {
			if(strategyNamesList.get(j).equalsIgnoreCase(StratName)) {
				Wcontrol.clickJSEon(edits.get(j));
				Wcontrol.clickJSEon(proposalPage.strategyShare);
				Wcontrol.sendkeysByAction(proposalPage.strategyShare, fundShare);
				Wcontrol.clickJSEon(proposalPage.strategyTick);
				break;
			}
		}
		defins.takeScreenShot("TestCase ScreenShot");
//		Wcontrol.scrollToView(proposalPage.strategyParticularNext);
		Wcontrol.scrollDownLong();
		Wcontrol.scrollDownMin();
		Wcontrol.scrollDownLong();
		Wcontrol.clickJSEon(proposalPage.strategyParticularNext);
	}

	@Then("Select the Nominee details as {string}")
	public void select_the_nominee_details_as_Input(String options) throws Throwable {

		if (options.equalsIgnoreCase("No")) {
			Wcontrol.click_and_Select(proposalPage.NominieeDetails, proposalPage.opt);
		} else {
			Wcontrol.click_and_Select(proposalPage.NominieeDetails, proposalPage.planDescOption);
		}
		Thread.sleep(500);
		defins.takeScreenShot("Screen Shot for the test");
	}
	
	@Then("Select the Nominee details")
	public void select_the_nominee_details() throws Throwable {

		String options = CustomerExceldata.TestDataInMap.get("NomineeOption");
		if (options.equalsIgnoreCase("No")) {
			Wcontrol.click_and_Select(proposalPage.NominieeDetails, proposalPage.opt);
		} else {
			Wcontrol.click_and_Select(proposalPage.NominieeDetails, proposalPage.planDescOption);
		}
		Thread.sleep(500);
		defins.takeScreenShot("Screen Shot for the test");
	}
	
	@Then("Add the Trustee Detaills")
	public void Trustee_Details() throws Throwable {
		
		String TrusteeOption = CustomerExceldata.TestDataInMap.get("TrusteeOption");
		if(TrusteeOption.equalsIgnoreCase("Yes")) {
			Wcontrol.clickJSEon(proposalPage.nomineeNext);
			Wcontrol.clickJSEon(proposalPage.addTrustee);
			String TrusteeType = CustomerExceldata.TestDataInMap.get("TrusteeType");
			Wcontrol.clickJSEon(By.xpath("//*[contains(text(),'Trustee Details')]/parent::div//table//mat-select"));
			String TrusteeTypeOpt = null;
			if(TrusteeType.equalsIgnoreCase("Individual")) {
				TrusteeTypeOpt = "//mat-option[1]";
			} else if(TrusteeType.equalsIgnoreCase("Company")) {
				TrusteeTypeOpt = "//mat-option[2]";
			}
			
			Wcontrol.clickJSEon(By.xpath(TrusteeTypeOpt));
			
			if(TrusteeType.equalsIgnoreCase("Individual")) {
				Wcontrol.clickJSEon(proposalPage.trusteeIdentity);
				Wcontrol.sendkeysByAction(proposalPage.trusteeIdentity, CustomerExceldata.TestDataInMap.get("TrusteeIdentity"));
				Thread.sleep(1000);
				library.elementstable(proposalPage.trusteeIDnumber);
				library.waitForClickableElement(proposalPage.trusteeIDnumber, 30);
				Wcontrol.sendkeysByAction(proposalPage.trusteeIDnumber, CustomerExceldata.TestDataInMap.get("TrusteeID"));
				Thread.sleep(500);
			} else if(TrusteeType.equalsIgnoreCase("Company")) {
				Wcontrol.sendkeysByAction(proposalPage.trusteeCompany, CustomerExceldata.TestDataInMap.get("TrusteeCompany"));
				Thread.sleep(500);
				library.elementstable(proposalPage.planDescOption);
				Wcontrol.ActionMoveToElementClcik(proposalPage.planDescOption);
			}
			
			Wcontrol.clickJSEon(proposalPage.trusteeTick);
			defins.takeScreenShot("Screen shot of the Test........");
		}
		
		
	}

	@Then("Select the short Payment method as {string}")
	public void Select_the_short_Payment_method(String options) throws Throwable {
		Wcontrol.clickJSEon(proposalPage.shortPayment);
		Thread.sleep(1000);
		Wcontrol.ActionMoveToElementClcik(proposalPage.options);
	}
	
	@Then("Get the Voucher Details")
	public void Voucher_Details_and_Extract() throws Throwable {
		
		if(base.environemt.equalsIgnoreCase("ILIVE")){
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(By.xpath("//*[contains(text(),'Pop Out')]"));
			library.waitForClickableElement(By.xpath("//*[contains(text(),'Pop Out')]"));
//			library.waitForClickableElement(proposalPage.finalSave);
		}
		String V_Name = Wcontrol.GetTexton(By.xpath("//*[contains(text(),'Voucher')]")).trim().split("Has Been Created")[0];
		System.out.println(V_Name);
		returnedVoucherNumber = V_Name.split(" ")[1].trim();
		System.out.println(returnedVoucherNumber);
	}

	@And("click on the Save buttons")
	public void click_on_the_save_button() throws Throwable {
//		if (Wcontrol.VisibleElementCount(commonPage.animation) > 0) {
//			library.waitForInVisibilityOfElement(commonPage.animation);
//		}
		
		if(base.environemt.equalsIgnoreCase("ILIVE")){
//			library.waitForInVisibilityOfElement(commonPage.animation);
			Thread.sleep(5000);
		} else {
			library.elementstable(By.xpath("//*[contains(text(),'Pop Out')]"));
			library.waitForClickableElement(By.xpath("//*[contains(text(),'Pop Out')]"));
//			library.waitForClickableElement(proposalPage.finalSave);
		}
		
		
//		Wcontrol.ActionMoveToElementClcik(proposalPage.finalSave);
//		Wcontrol.MovejsClick(proposalPage.finalSave);
//		Wcontrol.MovejsClick(By.xpath("//*[text()=' Save ']"));
		Wcontrol.clickJSEon(By.xpath("//*[text()=' Save ']"));
	}
	
	@Then("Click on Save")
	public void Warning_In_Validatation() throws Throwable {
		if(base.environemt.equalsIgnoreCase("ILIVE")){
			library.waitForInVisibilityOfElement(commonPage.animation);
		} else {
			library.elementstable(By.xpath("//*[contains(text(),'Pop Out')]"));
			library.waitForClickableElement(By.xpath("//*[contains(text(),'Pop Out')]"));
			library.waitForClickableElement(proposalPage.finalSave);
		}
		int table_size = base.getDriver().findElements(proposalPage.tableFields).size();
		if(table_size>0) {
			String errMsg = Wcontrol.GetTexton(proposalPage.tableFields).trim();
			String err = "NB034 - Policy Comm Date Should Not Be Less Than Sysdate Action : Please Give Some Other Date";
			String err2 = "NB1036 - Persistency rate is less Action : Persistency Rate Should Be Greater or Equal to";
			if(errMsg.equalsIgnoreCase(err) || errMsg.equalsIgnoreCase(err2)) {
				Wcontrol.clickJSEon(proposalPage.WarningYes);				
			}
			
		}
		
		Wcontrol.ActionMoveToElementClcik(proposalPage.finalSave);
//		library.waitForInVisibilityOfElement(commonPage.animation);
		library.elementstable(registrationPage.dialogboxOK);
		library.waitForClickableElement(registrationPage.dialogboxOK);
	}

}
