@All_Scenarios
Feature: Nsure - New Business > Full Flow

@NewTest @NewCustomerRegistration
Scenario Outline: To Create a New Customer in New Business Page
    Given Read all the input detail from the Excel
      | TestData | <TestData> |
    Given Enter the UserName and Password
    And click on "Login" button
		Then Go to "Customer Registration" Page By Search
    And Click on Create Customer button
    Then Select the Title and Enter the name
    Then Select Identity and Select Identity number one
    And Select the Gender
    Then Enter the Date of Birth and Select the Occupation
    Then Select the Nationality and the Select the Race
    And Enter the Height and Enter the Weight
    Then check the Existing Customer Details
    Then Enter address1 and Enter the Post code
    And click on "Add Contact" buttons
    Then Enter the Contact Type and Enter the Description
    And click on "Green" button
    And click on "Address_Next" button
    Then Enter the Identity Issue date and Expiry date
    And click on "Identity Next" button
    And Select the Contact Type and Enter the Description
    And click on "Contact_Next" button
    And click on "Add Bank" button
    Then Bank name and Enter the Account number
    And click on "Bank Next" button
    And click on "Create Employer" button
    Then Enter the Employe Name and Nature of Business
    Then Enter the Address1 and Address2
    Then Enter the Registration no and Enter the Contact number
    And click on "Preview" button
    And click on "Save" button
    Then Get the DialogBox Detail and click on OK button
    
  	Examples:
  	 | TestData |
     | TD002    |
 #----------------------------------------------------------------------------------------------------------------------------
 @Plancodes @Bulk2 @NewBulk1
 Scenario Outline: To Create a New Proposal for <PlanCode>
    Given Read all the input detail from the Excel
      | TestData | <TestData> |
    Given Enter the UserName and Password
    And click on "Login" button
    Then Go to "Proposal" Page By Search
    And click on the "Create Proposal" button
    Then Select the Plan description
    And click on the "Basic Next" button
    Then Select the Individual Id and Enter the Identity number
    Then Select the Company Id and Enter the Payer ReletionShip
    And Select the Agent Name
    And click on the "Proposer Next" button
    Then Select the Currency and Enter the Sum Assured
    And Enter the User Premium
    Then Enter the policy Terms and change the Frequency
    And Enter the Premium pattern and Enter the Sum Assuren Pattern
    And click on the "Policy Next" button
    And click on the "Staff Next" button
    Then goto the Loan Tab
    And goto the Payer Page
    And click on the "Payer Next" button
    And click on the "Payment Next" button
    Then Select the short Payment method
    And click on the "Life" button
    Then Validate the Fields in Life Tab
    And click on the "Life view" button
    And click on the "save" button
    Then Click on the Fund button
    Then Add the Funds for Unit Linked Product with AFB Option
    And click on the "Agent" button
    And click on the "Nomination" button
    Then Select the Nominee details
    And click on the "Servicing options" button
    And click on the "Process" button
    And click on the Life Detail and add the Optional Rider
    And click on the "Process" button
    And click on the Save buttons
    Then Get the DialogBox Details and click on OK button
   
    Then Go to "Underwriting" Page By Search
    And Enter the Policy number and click on Search button
    Then click on the Eye Icon and click on To Proposal button
    And click on the "Life" button
    And click on the "Life view" button
    Then Receive all the Documents from Document Section
    And click on the "save" button
    Then Receive Documents for Second Life Assured
    Then Click on the Fund button
    And click on the "Agent" button
    And click on the "Nomination" button
    And click on the "Servicing options" button
    Then Select the Decision and Enter the reason
    And click on the "Process" button
    And click on the Save buttons
    Then Get the DialogBox Detail and click on OK button
    
    Then Go to "Issue Receipt" Page By Search
    Then Enter the Policy Number and Click on Search button
    And Tick the Check box
    And click on "Issue Receipt" button
    Then Get the Payable Amount
    Then Select the Instrument Details
    And click on "Check All" button
    And click on "Issue" button
    Then Get the DialogBox Detail and click on OK button
    
    Then Go to "Quality Check" Page By Search
    Then Enter the Policy Number and Click on Search button
    And Tick the Check box
    Then Select the Quality Check Value
    And click on "Quality Approve" button
    Then Get the DialogBox Detail and click on OK button
    Then Go to "Policy Issue" Page By Search
    Then Enter the Policy Number and Click on Search button
    And Tick the Check box
    And click on "Issue" button
    Then click ok on the final popup
    

    #Then Go to "Policy Enquiry" Page By Search
    Then Navigate to Main Menu and Select "Enquiry"
    Then click on "General Enquiry" and Select "Policy Enquiry"
    Then Enter the Policy Number and Click on Search buttons
    And Take ScreenShot in the Enquiry Page
    Then Verify the "Life Assured" tab in Enquiry Page
    Then Verify the "Policy Values" tab in Enquiry Page
    Then Verify the "Premium Details" tab in Enquiry Page
    Then Verify the "Product Details" tab in Enquiry Page
    Then Verify the "Additional Details" tab in Enquiry Page
    
    Then Validate the "Premium"
    Then Validate the "Premium Outstanding"
    Then Validate the "Agent Details"
    Then Validate the "Agent Hierarchy"
    Then Validate the "Receipts"
    Then Validate the "Receipt Types"   
    Then Validate the "Status Log"
    Then Validate the "Underwriting Question/Answer"
    Then Validate the "Documents"
    Then Validate the "Underwrite"
    Then Caluculate the Premium from DB and Compare in Enquiry Page
    
        Examples: 
      | TestData |    PlanCode   |
      | TD002    | Future Invest |
      | TD003    |    Plan_11    |
      | TD004    |    Plan_3     |
      | TD005    |    DTRS       |
      | TD006    |    PLAN 19    |
      | TD007    |    PLAN_27    |
      | TD008    |    PLAN_21    |
      | TD009    |      RSP      |
      
 