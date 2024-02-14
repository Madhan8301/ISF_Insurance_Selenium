package com.kgisl.PageElements.Web;

import org.openqa.selenium.By;

public class ProposalPage {
	
	public By basicParticularPanel = By.xpath("//mat-panel-title[contains(text(),'Basic Particulars')]");
	public By proposerParticularPanel = By.xpath("//mat-panel-title[contains(text(),'Proposer Particulars')]");
	public By staffPolicy = By.xpath("//mat-label[contains(text(),'Staff Policy')]");
	public By epfNo = By.xpath("//mat-label[contains(text(),'EPF No')]");
	
	public By addressType = By.xpath("(//*[contains(text(),'Address Type')]/ancestor::span/parent::div//mat-select//div//div)[1]");
	public By previous = By.xpath("//*[contains(text(),'Previous')]");
	public By Individual = By.xpath("(//span[contains(text(),'Individual')])[2]");
	public By proposal = By.xpath("(//span[contains(text(),'Proposal')])[4]");
	public By AddProposal = By.xpath("//span[contains(text(),'Add Proposal')]");
	public By annualIncome = By.xpath("//*[text()='Annual Income']/ancestor::span/parent::div//input");
	
	public By planDescription = By.xpath("((//*[contains(text(),'Product Name')]/parent::label)/parent::span)/parent::div//input");
	public By planDescOption = By.xpath("//mat-option");
	public By BasicNext = By.xpath("(//mat-panel-title[contains(text(),' Basic Particulars')])/ancestor::mat-expansion-panel//button//span[contains(text(),'Next')]");
	public By EPFNext = By.xpath("(//mat-panel-title[contains(text(),' EPF Details')])/ancestor::mat-expansion-panel//button//span[contains(text(),'Next')]"); 
	
	public By proposerType = By.xpath("//*[contains(text(),'Proposer Type')]/ancestor::span/parent::div//mat-select");
	public By proposerTypeCompany = By.xpath("//mat-option[2]");
	public By proposerCompanyName = By.xpath("(((//*[contains(text(),'Company Name')]/parent::label)/parent::span)/parent::div//input)[1]");
	public By proposerRelation = By.xpath("(((//*[contains(text(),'RelationShip')]/parent::label)/parent::span)/parent::div//input)[1]");
	
	
	public By Identity = By.xpath("((//*[contains(text(),'Proposer Identity Type')]/parent::label)/parent::span)/parent::div//input");
	public By IDNumber = By.xpath("((//*[contains(text(),'Proposer Identity Number')]/parent::label)/parent::span)/parent::div//input");
	
	public By IdentityOPtions = By.xpath("//mat-option");
	public By customerAge = By.xpath("(//*[contains(text(),'Age')]/ancestor::span/parent::div//input)[1]");
	public By La_Relation = By.xpath("((//*[contains(text(),'RelationShip with Life Assured')]/parent::label)/parent::span)/parent::div//input");
	public By AgentName = By.xpath("((//*[contains(text(),'Agent Name')]/parent::label)/parent::span)/parent::div//input");
	public By proposerNext = By.xpath("(//mat-panel-title[contains(text(),' Proposer Particulars')])/ancestor::mat-expansion-panel//button//span[contains(text(),'Next')]");
	//public By currency = By.cssSelector("input[id='mat-input-97']");
	public By currency = By.xpath("((//*[contains(text(),'Annual Income Currency')]/parent::label)/parent::span)/parent::div//input");
	public By initialSA = By.xpath("((//*[contains(text(),'Initial Sum Assured')]/parent::label)/parent::span)/parent::div//input");
	public By userPremium = By.xpath("((//*[contains(text(),'User Premium')]/parent::label)/parent::span)/parent::div//input");
	//public By policyTerms = By.cssSelector("input[id='mat-input-89']");
	public By policyTerms = By.xpath("((//*[contains(text(),'Policy Term (in years)')]/parent::label)/parent::span)/parent::div//input");
	public By premiumTerms = By.xpath("((//*[contains(text(),'Premium Pay Term (in years)')]/parent::label)/parent::span)/parent::div//input");
	public By frequency = By.xpath("((//*[contains(text(),'Frequency')]/parent::label)/parent::span)/parent::div//input");
	public By freqOptionYearly = By.xpath("//mat-option[2]");
	public By freqOptionHalfYearly = By.xpath("//mat-option[1]");
	public By premiumPattern = By.xpath("((//*[contains(text(),'Premium Pattern')]/parent::label)/parent::span)/parent::div//input");
	public By SAPattern = By.xpath("((//*[contains(text(),'Sum Assured Pattern')]/parent::label)/parent::span)/parent::div//input");
	public By policyNext = By.xpath("(//mat-panel-title[contains(text(),' Policy Particulars')])/ancestor::mat-expansion-panel//button//span[contains(text(),'Next')]");
	public By StaffNext = By.xpath("(//mat-panel-title[contains(text(),'Staff Policy')])/ancestor::mat-expansion-panel//button//span[contains(text(),'Next')]");
	public By loanNext = By.xpath("(//mat-panel-title[contains(text(),'Loan Particulars')])/ancestor::mat-expansion-panel//button//span[contains(text(),'Next')]");
	
	public By staffPolicyOption = By.xpath("//*[contains(text(),'Staff Policy')]/ancestor::span/parent::div//mat-select");
	public By staffGroup = By.xpath("//*[contains(text(),'Staff Group')]/ancestor::span/parent::div//input");
	public By staffCompany = By.xpath("//*[contains(text(),'Staff Company')]/ancestor::span/parent::div//input");
	public By employeeID = By.xpath("//*[contains(text(),'Employee Id')]/ancestor::span/parent::div//input");

	public By comapanyName = By.xpath("(((//*[contains(text(),'Company Name')])/ancestor::span)/parent::div)[3]//input");
	public By BankAccnumber = By.xpath("((//*[contains(text(),'Bank Account')])/ancestor::span)/parent::div//input");
	public By loanRefNumber = By.xpath("((//*[contains(text(),'Loan Re')])/ancestor::span)/parent::div//input");
	public By loanAmount = By.xpath("((//*[contains(text(),'Loan Amount')])/ancestor::span)/parent::div//input");
	public By repayTerm = By.xpath("((//*[contains(text(),'Repay')])/ancestor::span)/parent::div//input");
	public By defermentPeriod = By.xpath("((//*[contains(text(),'Deferment')])/ancestor::span)/parent::div//input");
	public By serviceCommission = By.xpath("(//mat-form-field[1]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[1])[11]");
	public By serviceCommisionOptions = By.xpath("//mat-option[1]");
	public By finance = By.xpath("((//*[contains(text(),'Finance')]/parent::label)/parent::span)/ancestor::app-dynamic-dropdown");
	
	public By payerType = By.xpath("(((//*[text()='Payer Type'])/ancestor::span)/parent::div//span)[1]");
	public By payerOptions = By.xpath("//mat-option[3]");
	public By payerRelation = By.xpath("//*[contains(text(),'Payer Relationship with Life Assured')]/ancestor::span/parent::div//input");
//	public By payingCompany = By.xpath("//*[contains(text(),'Paying Company Name')]/ancestor::span/parent::div//input");
	public By payerIDType = By.xpath("//*[contains(text(),'Payer ID Type')]/ancestor::span/parent::div//input");
	public By payerIDNumber = By.xpath("//*[contains(text(),'Payer Id No')]/ancestor::span/parent::div//input");
	public By paymentMethod = By.xpath("//*[contains(text(),'Payment Method')]/ancestor::span/parent::div//input");
	public By payerCompanyName = By.xpath("(((//*[contains(text(),'Company Name')])/ancestor::span)/parent::div)[2]//input");
	
	public By salaryDetuctionNext = By.xpath("(//mat-panel-title[contains(text(),'Salary / Angkasa Deduction')])/ancestor::mat-expansion-panel//button//span[contains(text(),'Next')]");
	
	public By memberShipNo = By.xpath("//*[contains(text(),'Membership No')]/ancestor::span/parent::div//input");
	public By membershipAccountNo = By.xpath("//*[contains(text(),'Membership Account No')]/ancestor::span/parent::div//input");
	public By detuctionCode = By.xpath("//*[contains(text(),'Deduction Code')]/ancestor::span/parent::div//input");
	
	public By cardType = By.xpath("//*[contains(text(),'Card Type')]/ancestor::span/parent::div//input");
	public By cardNumber = By.xpath("//*[contains(text(),'Card No')]/ancestor::span/parent::div//input");
	public By cardBankName = By.xpath("//*[contains(text(),'Card Bank Name')]/ancestor::span/parent::div//input");
	public By collectingBankName = By.xpath("(//*[contains(text(),'Collecting Bank Name')]/ancestor::span/parent::div)[2]//input");
	public By validFromDate = By.xpath("//*[contains(text(),'Valid From Date')]/ancestor::span/parent::div//input");
	public By validToDate = By.xpath("//*[contains(text(),'Valid To Date')]/ancestor::span/parent::div//input");
	public By creditCardNext = By.xpath("(//mat-panel-title[contains(text(),'Credit Card Details')])/ancestor::mat-expansion-panel//button//span[contains(text(),'Next')]");
	
	public By payerbankName = By.xpath("//*[text()='Bank Name']/ancestor::span/parent::div//input");
	public By payerBankAccountNumber = By.xpath("//*[contains(text(),'Bank Account No')]/ancestor::span/parent::div//input");
	public By optionsAll = By.xpath("//mat-option");
	public By BankParticularNext = By.xpath("(//mat-panel-title[contains(text(),'Bank / Auto Debit Particulars')])/ancestor::mat-expansion-panel//button//span[contains(text(),'Next')]");
	
	public By PayerNext = By.xpath("(//span[contains(text(),'Next')])[1]");
	public By PaymentNext = By.xpath("(//span[contains(text(),'Next')])[2]");
	public By fundEdit = By.xpath("(//*[contains(text(),'Fund Particular')])[1]/ancestor::mat-expansion-panel//table//*[contains(text(),'edit')]");
	public By editIcon = By.xpath("//td[@class='mat-cell cdk-cell cdk-column-__gridactions mat-column-__gridactions ng-star-inserted mat-table-sticky mat-table-sticky-border-elem-right']//button//mat-icon[@class='mat-icon notranslate icon-edit material-icons mat-icon-no-color']");
	public By fundName = By.xpath("(//*[contains(text(),'Fund Particular')])[1]/ancestor::mat-expansion-panel//table//tbody//tr//td[1]");
	public By LifeTab = By.xpath("(//*[contains(text(),'Life Assured')])[1]");
	public By unitLinkOption = By.xpath("//mat-panel-title[contains(text(),'Unit Link Options')]");
	public By autoFundBalance = By.xpath("(//*[contains(text(),'Automatic Fund Balancing')]/ancestor::span/parent::div//mat-select//div//div)[1]");
	public By unitLinkNext = By.xpath("//mat-panel-title[contains(text(),'Unit Link Options')]/ancestor::mat-expansion-panel//*[contains(text(),'Next')]");
	public By fundParticularNext = By.xpath("(//mat-panel-title[contains(text(),'Fund Particular')])/ancestor::mat-expansion-panel//button//*[contains(text(),'Next')]");
	public By strategyEdit = By.xpath("((//mat-panel-title[contains(text(),'Strategy Particular')])/ancestor::mat-expansion-panel//table)[1]//tbody//tr//button//mat-icon");
	public By strategyTick = By.xpath("//tbody//*[contains(text(),'check_circle')]/ancestor::button");
	public By strategyShare = By.xpath("(((//mat-panel-title[contains(text(),'Strategy Particular')])/ancestor::mat-expansion-panel//table)[1]//tbody//tr//input)[2]");
	public By strategyName = By.xpath("((//mat-panel-title[contains(text(),'Strategy Particular')])/ancestor::mat-expansion-panel//table)[1]//tbody//td//span//span");
	public By strategyParticularNext = By.xpath("(//mat-panel-title[contains(text(),'Strategy Particular')])/ancestor::mat-expansion-panel//button//*[contains(text(),'Next')]");
	
	public By LifeRelation = By.xpath("(//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//table//input)[1]");
	public By LifeIdentity = By.xpath("(//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//table//input)[2]");
	public By LifeIdentityNumber = By.xpath("(//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//table//input)[3]");
	public By LAEdit = By.xpath("//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//table//tbody//*[contains(text(),'edit')]");
	public By AddLA = By.xpath("//span[contains(text(),'Add LA')]");
	public By DeleteLA = By.xpath("(//*[contains(text(),'delete')])[2]");
	public By deleteConformation = By.xpath("//*[contains(text(),'Yes, Delete')]");
	
	public By DTRSAGE = By.xpath("((//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//table//tr)[3]//td)[6]//span//span");
	
	public By LifeAssuredView = By.xpath("(//*[contains(text(),' speaker_notes ')])[1]");
	public By LifeAssuredView1 = By.xpath("(//*[contains(text(),' speaker_notes ')])[2]");
	public By BasePlan = By.xpath("(//*[contains(text(),'Base Plan')])[3]");
	public By optionalRiders = By.xpath("//*[contains(text(),'Optional Riders')]/parent::div");
	public By optionalRiderEdit = By.xpath("//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//mat-icon[contains(text(),'edit')]");
	public By ridersDetailsName = By.xpath("//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/parent::div//*[contains(text(),' Riders ')]/ancestor::table//tbody//tr//td[2]");
	public By optionalRiderTick = By.xpath("//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//tbody//tr//button//mat-icon[contains(text(),'check_circle')]");
	public By optionalRiderTermInput = By.xpath("((//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//table)[1]//tbody//tr//td[5])//input");
	public By optionalRiderPremiumTerm = By.xpath("((//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//table)[1]//tbody//tr//td[6])//input");
	public By optionalRecords = By.xpath("(//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/parent::div//mat-step-header/following-sibling::div//app-common-table-v2)[1]//mat-select");
	public By riderOpt = By.xpath("//mat-option[3]");
	
	public By nextPaginator = By.xpath("((//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/parent::div//app-common-table-v3//*[contains(text(),'Records per page')])[1]/parent::div/parent::div//button)[3]");
	public By PrevPaginator = By.xpath("(((//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/parent::div//mat-step-header/following-sibling::div//app-common-table-v2)[1]//div//table)/parent::form/parent::div/following-sibling::div//button)[3]");
	
	
	public By riderDecision = By.xpath("	");
//	public By riderCheckBox = By.xpath("//tbody[@role='rowgroup']//td//label/span/input[@type='checkbox']");
			//"(//table[@class='mat-table cdk-table mat-sort table-bordered table-hover table-common custom-table-style'])[3]//tr[@class='mat-row cdk-row ng-star-inserted']//td[@class='mat-cell cdk-cell cdk-column-__gridselect mat-column-__gridselect ng-star-inserted']//input[@class='mat-checkbox-input cdk-visually-hidden']");
	public By riderCheckBox = By.xpath("//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/parent::div//*[contains(text(),' Riders ')]/ancestor::table//tbody//tr//td[1]//mat-checkbox//input[@type='checkbox']/parent::span");
	public By riderView = By.xpath("//*[text()=' Riders ']");
	public By riderNext = By.xpath("(//*[contains(text(),'Next')])[2]");
	public By optionalRiderSA = By.xpath("((//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//table)[1]//tbody//tr//td[7])//input");
	
	public By riderLoadingScreen = By.xpath("(//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//tbody//tr//button)[4]");
	public By riderCharges = By.xpath("//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//*[contains(text(),'Rider Events ')]/parent::div//table//tbody//tr//*[contains(text(),'Charges')]");
	public By riderLoadingButton = By.xpath("//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//*[contains(text(),'Rider Events ')]/parent::div//*[contains(text(),'Loading')]");
	public By riderAddLoading = By.xpath("//*[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//*[contains(text(),'Rider Events ')]/parent::div//*[contains(text(),'Add Loading')]");
	public By riderLoadingSource = By.xpath("(//*[contains(text(),'Loading Source')]/ancestor::table//thead//input)[1]");
	public By riderLoadingCriteria = By.xpath("(//*[contains(text(),'Loading Source')]/ancestor::table//thead//input)[2]");
	public By riderLoadingValue = By.xpath("(//*[contains(text(),'Loading Source')]/ancestor::table//thead//input)[3]");
	public By riderLoadingTick = By.xpath("(//*[contains(text(),'Loading for Event Charges')]/parent::div//mat-icon[text()='check_circle'])[1]");
	public By riderLoadingTable = By.xpath("((((//div[contains(text(),'Optional Rider')])[1]/ancestor::mat-step-header/parent::div//app-common-table-v2)[5])//div)[62]");
	public By riderLoadingClose = By.xpath("((//div[contains(text(),'Optional Rider')])[1]/ancestor::mat-step-header/parent::div//*[contains(text(),'Close')])[2]");
	
	
	public By Save = By.xpath("//span[contains(text(),'Save Additional Details')]");
	//public By edit1 = By.xpath("(//span//mat-icon[@class='mat-icon notranslate icon-edit material-icons mat-icon-no-color'])[1]");
	public By edit2 = By.xpath("(//span//mat-icon[@class='mat-icon notranslate icon-edit material-icons mat-icon-no-color'])[2]");
	public By share = By.xpath("(//td//span//input)[3]");
	public By share1=By.xpath("(//*[contains(text(),'Fund Particular')])[1]/ancestor::mat-expansion-panel//table//tbody//tr//td[3]//input");
	//public By share2 = By.cssSelector("div[class='mat-form-field-infix ng-tns-c68-334'] input");
	public By LATick1 = By.xpath("//*[contains(text(),'Life Assured')]/ancestor::mat-expansion-panel//table//tr//td//*[contains(text(),'check_circle')]/ancestor::button");
	public By tick1 = By.xpath("//tbody//*[contains(text(),'check_circle')]/ancestor::button");
	public By tick2 = By.xpath("(//*[contains(text(),'check_circle')])[1]");
	public By fundTab = By.xpath("//div[contains(text(),'Fund')]");
	public By afbFrequency = By.xpath("//*[contains(text(),'AFB Frequency')]/ancestor::span/parent::div//input");
	public By afbFundAmount = By.xpath("//*[contains(text(),'AFB Target Fund Amount')]/ancestor::span/parent::div//input");
	public By agentTab = By.xpath("//div[contains(text(),'Agent')]");
	public By nominationTab = By.xpath("//div[contains(text(),'Nomination')]");
	public By NominieeDetails = By.xpath("(//mat-select//div//div[1])[3]");
	
	public By addAgent = By.xpath("//*[contains(text(),'Add Agent')]");
	public By agentEdit = By.xpath("//*[contains(text(),'Servicing Agents')]/ancestor::mat-expansion-panel//table//*[contains(text(),'edit')]");
	public By tableinput = By.xpath("(//table//input[@type='text'])[2]");
	public By agentCode = By.xpath("(//table//input[@type='text'])[1]");
	public By agentPercent = By.xpath("(//table//input[@type='text'])[2]");
	public By agentTick = By.xpath("//*[contains(text(),'Servicing Agents')]/ancestor::mat-expansion-panel//table//*[contains(text(),'check_circle')]");
	
	public By annuityDetails = By.xpath("//div[text()='Annuity Details']");
	public By guaranteePeriod = By.xpath("//*[text()='Guarantee Period']/ancestor::span/parent::div//input");
	public By pensionFrequency = By.xpath("//*[text()='Pension Frequency']/ancestor::span/parent::div//input");
	public By annuityType = By.xpath("//*[text()='Annuity Input Type']/ancestor::span/parent::div//mat-select");
	public By annuityNext = By.xpath("//div[text()='Annuity Details']/ancestor::mat-step-header/parent::div//*[contains(text(),'Next')]");
	
	
	public By FamilyTab = By.xpath("//div[contains(text(),'Family')]/parent::div");
	public By addFamily = By.xpath("//*[contains(text(),'Add Family')]");
	public By familyTabRelation = By.xpath("(//*[text()='Family']/ancestor::mat-step-header/following-sibling::div//table//input)[1]");
	public By familyAge = By.xpath("(//*[text()='Family']/ancestor::mat-step-header/following-sibling::div//table//input)[2]");
	public By familyHealth = By.xpath("(//*[text()='Family']/ancestor::mat-step-header/following-sibling::div//table//input)[3]");
	public By familyTick = By.xpath("//*[text()='Family']/ancestor::mat-step-header/following-sibling::div//table//*[contains(text(),'check_circle')]");
	public By familyTabNext = By.xpath("//*[text()='Family']/ancestor::mat-step-header/following-sibling::div//*[contains(text(),'Next')]");
	
	public By otherPolicies = By.xpath("//*[text()='Other Policies']");
	public By addPolicy = By.xpath("//*[text()=' Add Policy ']");
	public By policyCompanyName = By.xpath("(//*[text()='Other Policies']/ancestor::mat-step-header/following-sibling::div//table//input)[1]");
	public By otherPolicyNumber = By.xpath("(//*[text()='Other Policies']/ancestor::mat-step-header/following-sibling::div//table//input)[2]");
	public By coverageSum = By.xpath("(//*[text()='Other Policies']/ancestor::mat-step-header/following-sibling::div//table//input)[3]");
	public By basePlanOtherPolicy = By.xpath("(//*[text()='Other Policies']/ancestor::mat-step-header/following-sibling::div//table//input)[4]");
	public By statusOfpolicy = By.xpath("(//*[text()='Other Policies']/ancestor::mat-step-header/following-sibling::div//table//input)[5]");
	public By otherPolicyTick = By.xpath("//*[text()='Other Policies']/ancestor::mat-step-header/following-sibling::div//table//*[contains(text(),'check_circle')]");
	public By otherPolicyNext = By.xpath("//*[text()='Other Policies']/ancestor::mat-step-header/following-sibling::div//*[contains(text(),'Next')]");
	
	public By GST = By.xpath("//*[contains(text(),'GST')]");
	public By gstRegNo = By.xpath("//*[contains(text(),'GST Registration No')]/ancestor::span/parent::div//input");
	public By gstRegDate = By.xpath("//*[contains(text(),'GST Registration Date')]/ancestor::span/parent::div//input");
	

	
	public By addNominee = By.xpath("//*[contains(text(),'Add Nominee')]");
	public By nomineeIdentity = By.xpath("(//*[contains(text(),'Nominee Details')]/parent::div//table//td//input)[1]");
	public By nomineeIdentityNumber = By.xpath("(//*[contains(text(),'Nominee Details')]/parent::div//table//td//input)[2]");
	public By nomineeRelation = By.xpath("(//*[contains(text(),'Nominee Details')]/parent::div//table//td//input)[3]");
	public By benefitShare = By.xpath("(//*[contains(text(),'Nominee Details')]/parent::div//table//td//input)[4]");
	public By nomineeNext = By.xpath("(//mat-panel-title[contains(text(),'Nominee Details')])/ancestor::mat-expansion-panel//button//span[contains(text(),'Next')]");
	public By nomineeTick = By.xpath("(//*[contains(text(),'Nominee Details')]/parent::div//table//td)[9]//mat-icon[text()='check_circle']");
	
	public By servicingOptions = By.xpath("//div[contains(text(),'Servicing')]");
	public By opt = By.xpath("//mat-option[2]");
	
	public By nonForfeitureOption = By.xpath("((//*[contains(text(),'Non Forfeiture Option?')]/parent::label)/parent::span)/parent::div//input");
	
	public By dividentNext = By.xpath("(//span[contains(text(),'Next')])[1]");
	public By shortPayment = By.xpath("(//*[contains(text(),'If amount is paid in excess of premium where to place the amount')]/ancestor::span)/parent::div//input");
	public By options = By.xpath("//mat-option[2]");
	public By shortPaymentNext = By.xpath("(//span[contains(text(),'Next')])[2]");
	public By process = By.xpath("//mat-tab-body//*[contains(text(),'Process')]");
	public By processTable = By.xpath("(//div[@class='table-responsive'])[1]//div");
	public By saveDraft = By.xpath("//span[contains(text(),'Save As')]");
	public By finalSave = By.xpath("(//button//i/parent::span[text()=' Save '])");
	public By autoUnderWritingYes = By.xpath("//span[text()=' Yes']");
	public By autoUnderWritingNo = By.xpath("//span[text()=' No']");
	
	public By commencementDateOption = By.xpath("((//*[contains(text(),'Commencement Date Option')]/ancestor::span)/parent::div)//mat-select//span");
	public By commencementDate = By.xpath("((//*[contains(text(),'Commencement Date')]/ancestor::span)/parent::div)//input");
	public By MDTAoption = By.xpath("//mat-option[3]");
	public By commencementDateicon = By.xpath("((//*[text()='Commencement Date ']/ancestor::span)/parent::div/following-sibling::div//button//span)[1]");
	public By yearButton = By.xpath("(//div[@class='mat-calendar-header']//button//span)[1]");
	public By yearSelect = By.xpath("//*[contains(text(),'2022')]/parent::button");
	public By monthSelect = By.xpath("//*[contains(text(),'MAY')]/parent::button");
	public By dateSelect = By.xpath("//*[contains(text(),'11')]/parent::button");
	public By backDate = By.xpath("((//*[contains(text(),'Back Date')]/ancestor::span)/parent::div)//mat-select//span");

	public By tableFields = By.xpath("(//*[contains(text(),'Proposal can be saved only when')])[1]/parent::div//table//tbody//tr//td[2]");
	public By WarningYes = By.xpath("(//*[contains(text(),'Proposal can be saved only when')])[1]/parent::div//table//tbody//tr//*[contains(text(),'Yes')]");
	public By checkbox=By.xpath("//*[@id=\"mat-checkbox-250\"]/label/span[1]");
	
	
	public By revertPolicy = By.xpath("//*[contains(text(),'Revert Policy')]");
	public By conformationYes = By.xpath("//*[contains(text(),'YES')]");
	public By conformationNO = By.xpath("//*[contains(text(),'NO')]");
	
	public By questionsUW = By.xpath("//div[contains(text(),'Underwriting Questions')]/ancestor::mat-step-header/parent::div//table//tbody//tr/td[1]");
	public By UnderwritingQuestions = By.xpath("(//div[contains(text(),'Underwriting Questions')])[1]");
	public By UWQuestionsNext = By.xpath("//div[contains(text(),'Underwriting Questions')]/ancestor::mat-step-header/parent::div//*[contains(text(),'Next')]");
	public By UWQedit = By.xpath("//*[contains(text(),'Underwriting Questions')]/ancestor::mat-step-header/following-sibling::div//tbody//tr//button//mat-icon[contains(text(),'edit')]");
	public By UWQtick = By.xpath("//*[contains(text(),'Underwriting Questions')]/ancestor::mat-step-header/following-sibling::div//tbody//tr//button//mat-icon[contains(text(),'check_circle')]");
	public By UWQreplyChoice = By.xpath("//*[contains(text(),'Underwriting Questions')]/ancestor::mat-step-header/following-sibling::div//tbody//tr//mat-select//span");
	public By UWQreplyDetails = By.xpath("(//*[contains(text(),'Underwriting Questions')]/ancestor::mat-step-header/following-sibling::div//tbody//tr//input[@type='text'])[2]");
	public By UWQrecords = By.xpath("(//*[contains(text(),'Underwriting Questions')]/ancestor::mat-step-header/following-sibling::div//div[contains(text(),' Records per page: ')]/parent::div//mat-select//span)[1]");
	
	public By addRider = By.xpath("//*[contains(text(),'Add Rider')]");
	public By newRiderName = By.xpath("(//div[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//table//thead//tr//td//input)[2]");
	public By newRiderTerm = By.xpath("(//div[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//table//thead//tr//td//input)[3]");
	public By newRiderPremium = By.xpath("(//div[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//table//thead//tr//td//input)[4]");
	public By newRiderSA = By.xpath("(//div[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//table//thead//tr//td//input)[5]");
	public By newRiderDecision = By.xpath("//div[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//table//thead//tr//td//mat-select");
	public By newRiderTick = By.xpath("(//div[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//table//thead//tr//td//mat-icon/ancestor::button)[1]");
	public By addRiderCheckBox = By.xpath("((//div[contains(text(),'Optional Riders')]/ancestor::mat-step-header/following-sibling::div//table//tbody//tr)[2]//td)[1]//mat-checkbox//input[@type='checkbox']/parent::span");
	
	public By enquiryPremiumDetails = By.xpath("//*[contains(text(),'Premium Details')]");
	public By enquiryPremiumAmt = By.xpath("(//*[contains(text(),'Premium Values')]/parent::div//*[contains(text(),'Next Premium')]/parent::div//span)[2]");
	
	public By trusteeDetails = By.xpath("//h2[contains(text(),'Trustee Details')]");
	public By trusteeIdentity =By.xpath("((//*[contains(text(),'Trustee Details')]/ancestor::mat-expansion-panel//table//thead//tr)[2]//input)[1]");
	public By trusteeIDnumber = By.xpath("((//*[contains(text(),'Trustee Details')]/ancestor::mat-expansion-panel//table//thead//tr)[2]//input)[2]");
	public By trusteeCompany = By.xpath("((//*[contains(text(),'Trustee Details')]/ancestor::mat-expansion-panel//table//thead//tr)[2]//input)[3]");
	public By trusteeTick = By.xpath("(//*[contains(text(),'Trustee Details')]/ancestor::mat-expansion-panel//table//thead//tr)[2]//mat-icon[contains(text(),'check_circle')]");
	public By addTrustee = By.xpath("//*[contains(text(),'Add Trustee')]");
	public By agentEdit1 = By.xpath("//*[contains(text(),'Servicing Agents')]/ancestor::mat-expansion-panel//table//tbody//mat-icon[contains(text(),'edit')]");
	public By agentCode1 = By.xpath("(//*[contains(text(),'Servicing Agents')]/ancestor::mat-expansion-panel//table//tbody//input)[1]");
	public By agentTick1 = By.xpath("//*[contains(text(),'Servicing Agents')]/ancestor::mat-expansion-panel//table//tbody//mat-icon[contains(text(),'check_circle')]");
	
	public By nomineeEdit = By.xpath("//*[contains(text(),'Nominee Details')]/ancestor::mat-expansion-panel//table//mat-icon[contains(text(),'edit')]");
	

	
	//----------------------------------------------Enquiry---------------------------------------------------
	
	public By additionalENQList = By.xpath("//*[contains(text(),'Additional Details')]/ancestor::mat-expansion-panel//mat-tab-body//mat-tab-header//*[@class='mat-tab-labels']//div//div");
	
	public By additionalEnqDetails = By.xpath("//*[contains(text(),'Additional Details')]");
	public By additionalDetailsSearch = By.xpath("//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group//*[contains(text(),'Search')]/ancestor::span/parent::div//input");
	public By policyValueTab = By.xpath("(//*[text()='Policy Values'])[1]");
	public By premiumDetailsTab = By.xpath("(//*[text()='Premium Details'])[1]");
	public By productDetailsTab = By.xpath("(//*[text()='Product Details'])[1]");
	public By EnqLifeAssuredTab = By.xpath("(//*[text()='Life Assured'])[1]");
	public By lifeAssuredTable = By.xpath("(//*[contains(text(),'Life Assured')]/ancestor::mat-tab-group)[2]//table");
	
	public By Export = By.xpath("(//*[contains(text(),'Export')])[1]");
	public By downloadButton = By.xpath("//*[contains(text(),'Export')]/ancestor::span/parent::div/ancestor::mat-form-field/parent::div//button");
	
	
	public By PolicyfundValue = By.xpath("((//*[text()='Policy Values'])[1]/ancestor::mat-tab-group)[2]//*[contains(text(),'Fund Value')]/parent::div");
	
	public By productDetailsTableHead = By.xpath("((//*[text()='Product Details'])[1]/ancestor::mat-tab-group)[2]//table//thead//th");
	public By productDetailsTableData = By.xpath("((//*[text()='Product Details'])[1]/ancestor::mat-tab-group)[2]//table//tbody//td");
	
	public By additionalPremium = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[text()='Premium'])[1]");
	public By premiumOutstanding = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[text()='Premium Outstanding'])[1]");
	public By billing = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[text()='Billing'])[1]");
	public By receipts = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[text()='Receipts'])[1]");
	public By agentDetails = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[text()='Agent Details'])[1]");
	public By agentHierarchy = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[text()='Agent Hierarchy'])[1]");
	public By receiptTypes = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[text()='Receipt Types'])[1]");
	public By typeOfReceipt = By.xpath("(//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[contains(text(),'Type Of Receipt')]/ancestor::span/parent::div//mat-select//span");
	public By receiptSearch = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[contains(text(),'Search')])[2]");
	public By statusLog = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[text()='Status Log'])[1]");
	public By UWQA = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[text()='Underwriting Question/Answer'])[1]");
	public By underwrite = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[text()='Underwrite'])[1]");
	public By EnqDocuments = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[text()='Documents'])[1]");
	public By EnqNomination = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[text()='Nomination'])[1]");
	public By EnqTrustee = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[text()='Trustee'])[1]");
	public By EnqPolicyExclusion = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[text()='Policy Exclusion'])[1]");
	public By EnqPolicyLien = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[text()='Policy Lien'])[1]");
	public By EnqFundDetail = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[text()='Fund Detail'])[1]");
	public By EnqAnnuityDetail = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[text()='Annuity Details'])[1]");
	public By AFBDetails = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group)[2]//*[text()='Automatic Fund Balancing Details'])[1]");
	
	public By voucherDetails = By.xpath("(//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group//*[contains(text(),'Voucher')])[1]");
	public By voucherNumber = By.xpath("((//*[contains(text(),'Additional Details')]/ancestor::mat-tab-group//*[contains(text(),'Voucher')])[2]/ancestor::app-voucher-button//table//tbody//tr//td)[2]//span");
	public By voucherPanel = By.xpath("//*[contains(text(),'Voucher Enquiry Details')]");
	
	//-------------------------------------------------------------------------------------------------------------------------------
	
	public By issueReceiptBtn = By.xpath("//*[contains(text(),'Issue Receipt')]/parent::button");
	public By issueCheck = By.xpath("//h2[contains(text(),'Policy')]/parent::div//table//tbody//tr//td[1]//input/parent::span");
	
	public By amountPayable = By.xpath("//*[contains(text(),'Policy Details')]/parent::div//table//tfoot//tr//td[7]");
	public By checkAll = By.xpath("//*[contains(text(),'Check All')]/parent::button");
	public By IssuePolicy = By.xpath("//*[contains(text(),'Issue')]/parent::button");
	
	public By addInstrumentDetails = By.xpath("//*[contains(text(),'Instrument Details')]/parent::div//*[contains(text(),'Add')]");
	public By instrumentType = By.xpath("(((//*[contains(text(),'Instrument Details')]/parent::div//table)[1]//tr)[2]//td//mat-select//span)[1]");
//	public By instrumentCurrency = By.xpath("(((//*[contains(text(),'Instrument Details')]/parent::div//table)[1]//tr)[2]//td//mat-select//span)[2]");
	public By instrumentCurrency = By.xpath("(((//*[contains(text(),'Instrument Details')]/parent::div//table)[1]//tr)[2]//td//input)[2]");
	public By instrumentAmount = By.xpath("(//*[contains(text(),'Instrument Details')]/parent::div//app-common-table-v3//*[contains(text(),'Instrument Amount')]/ancestor::table//input)[3]");
	public By instrumentTick = By.xpath("((//*[contains(text(),'Instrument Details')]/parent::div//table)[1]//tr)[2]//td//button//*[contains(text(),'check_circle')]");
	
	 
	
	
}
