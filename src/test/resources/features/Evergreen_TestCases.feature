@All_Scenarios
Feature: Nsure - New Business > Registration,Proposal,UnderWriting & Enquiry

  @MultipleTask @Bulk2 @NewBulk1
  Scenario Outline: Proposal with Multiple LA,Agent,Nominee by changing the financial terms of Base Plan(SA/TERM) at underwriting
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
    Then Change the Payment Method as "AUTODEBIT (04)"
    And click on the "Payment Next" button
    Then Select the Details for "AUTODEBIT"
    Then Select the short Payment method
    And click on the "Life" button
    Then Validate the Fields in Life Tab
    And click on the "Life view" button
    And click on the "save" button
    Then Click on the Fund button
    Then Add the Funds for Unit Linked Product with AFB Option
    And click on the "Agent" button
    Then Add the New Agent
    And click on the "Nomination" button
    Then Select the Nominee details
    And click on the "Add Nominiee" button
    Then add the Nominee Details
    And click on the "Nominee Next" button
    And click on the "Previous" button
    And click on the "Servicing options" button
    And click on the "Process" button
    And click on the Life Detail and add the multiple Optional Rider details for "Plan27"
    #And click on the "Process" button
    And click on the Save buttons
    Then Get the DialogBox Details and click on OK button
    Then Go to "Underwriting" Page By Search
    And Enter the Policy number and click on Search button
    Then click on the Eye Icon and click on To Proposal button
    Then Validate Proposer Particular
    And click on the "Proposer Next" button
    And Change the SumAssured Value
    And click on the "Policy Next" button
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
      | TestData |
      | TD010    |

  #----------------------------------------------------------------------------------------------------------------------------
  @UW_Stage @Bulk2 @NewBulk1
  Scenario Outline: To validate whether the user able to <Scenario>
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
    #Then Go to "Policy Enquiry" Page By Search
    Then Navigate to Main Menu and Select "Enquiry"
    Then click on "General Enquiry" and Select "Policy Enquiry"
    Then Enter the Policy Number and Click on Search buttons
    And Take ScreenShot in the Enquiry Page

    Examples: 
      | TestData | Scenario                          |
      | TD012    | Decline during Underwriting       |
      | TD013    | Keep the proposal in review stage |

  #----------------------------------------------------------------------------------------------------------------------------
  @CompanyRegistrations @Bulk2 @NewBulk2
  Scenario Outline: Company Registration - <Company Type>
    Given Read all the input detail from the Excel for Company Registration
      | TestData | <TestData> |
    Given Enter the UserName and Password
    And click on "Login" button
    Then Go to "Company Registration" Page By Search
    And Click on Create Company button
    Then Enter the Institution code and Institution Branch
    Then Enter the Institution Name and Institution Type
    Then Select the Bank role
    Then Select the Branch Weekend Days
    Then Enter the Registration Number and Account Code
    And click on "Institution Next" button
    And click on "Create Contact" buttons
    Then Enter the Contact Details
    And click on "ContactDetails Next" button
    Then Enter the Address Details
    And click on "Add Address" buttons
    Then Enter the Contact Details for Address
    And click on "AddressDetails Next" button
    And click on "Add BankDetails" buttons
    Then Enter the Bank Details
    And click on "Preview Next" button
    And click on "Save" button
    Then Get the DialogBox Detail and click on OK button

    Examples: 
      | TestData | Company Type      |
      | CR001    | Bank              |
      | CR002    | Private Companies |
      | CR003    | Panel Clinic      |
      | CR004    | Insurance Company |
      | CR005    | Branches          |

  #----------------------------------------------------------------------------------------------------------------------------
  @Multiople_IC @Bulk2 @NewBulk2
  Scenario Outline: To Create new customer registeration with multiple IC and Modify that customer without policy issue
    Given Read all the input detail from the Excel
      | TestData | <TestData> |
    Given Enter the UserName and Password
    And click on "Login" button
    Then Go to "Customer Registration" Page By Search
    And Click on Create Customer button
    Then Select Identity and Select Identity number one
    Then Select the Title and Enter the name
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
    Then Add Another Identification Details
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
    Then Get The Reference number
    Then Get the DialogBox Detail and click on OK button
    Then Go to "Customer Registration" Page By Search
    Then Enter the Reference number
    Then Click on the edit icon of the customer
    And click on "Preview" button
    And click on "Save" button
    Then Get the DialogBox Detail and click on OK button

    Examples: 
      | TestData |
      | TD014    |

  #------------------------------------------------------------------------------------------------------------------------------------------
  @No_IC1 @Bulk2 @NewBulk2
  Scenario Outline: To Create a Policy with new customer registeration with NO IC then Modify the Same Customer after Policy Issuance
    Given Read all the input detail from the Excel
      | TestData | <TestData> |
    Given Enter the UserName and Password
    And click on "Login" button
    Then Go to "Customer Registration" Page By Search
    And Click on Create Customer button
    Then Select Identity as "System Generated Identification" and Select Identity number
    Then Select the Title and Enter the name
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
    Then Get The Reference number
    Then Get the DialogBox Detail and click on OK button
    Then Go to "Proposal" Page By Search
    And click on the "Create Proposal" button
    Then Select the Plan description
    And click on the "Basic Next" button
    Then Select the Individual Id as "System Generated Identification" and Enter the Identity number
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
    Then Go to "Policy Enquiry" Page By Search
    Then Enter the Policy Number and Click on Search buttons
    And Take ScreenShot in the Enquiry Page
    Then Go to "Customer Registration" Page By Search
    Then Enter the Reference number
    Then Click on the edit icon of the customer and get the details and click on ok button

    Examples: 
      | TestData |
      | TD015    |

  #------------------------------------------------------------------------------------------------------------------------------
  @StaffPolicy_With_Trustee @Bulk2 @NewBulk2
  Scenario Outline: To validate whether the user is able to create staff proposal with Trustee Entred
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
    Then Enter the Staff Policy Details
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
    Then Add the Trustee Detaills
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
    Then Go to "Policy Enquiry" Page By Search
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

    Examples: 
      | TestData |
      | TD016    |

  #---------------------------------------------------------------------------------------------------------------------------
  @MDTA_Proposal_with_Multiple_Nominee @Bulk2 @NewBulk2
  Scenario Outline: To validate whether the user is able to create MDTA Proposal with Multiple Nominee
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
    Then Select the Commencement Date as "MDTA"
    And click on the "Policy Next" button
    And click on the "Staff Next" button
    Then goto the Loan Tab
    And goto the Payer Page
    And click on the "Payer Next" button
    And click on the "Payment Next" button
    Then Select the short Payment method
    And click on the "Life" button
    Then Validate the Fields in Life Tab
    And click on the "Agent" button
    And click on the "Nomination" button
    Then Select the Nominee details
    And click on the "Add Nominiee" button
    Then Add Multiple Nominee Details
    And click on the "Servicing options" button
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
    Then Go to "Policy Enquiry" Page By Search
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

    Examples: 
      | TestData |
      | TD017    |

  #---------------------------------------------------------------------------------------------------------------------------------
  @StrategyFunds1 @Bulk2 @NewBulk2
  Scenario Outline: To validate whether the user is able to create proposal with Unit Link - Fund/Strategy Data Entry with Various Commencement Date(Backdated) and Payment Method as Credit Card
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
    And Take ScreenShot
    Then Change to BackDated Option
    And click on the "Policy Next" button
    And click on the "Staff Next" button
    Then goto the Loan Tab
    And goto the Payer Page
    And click on the "Payer Next" button
    Then Change the Payment Method as "CCSI (05)"
    And click on the "Payment Next" button
    Then Select the Details for "CCSI"
    Then Select the short Payment method
    And click on the "Life" button
    Then Validate the Fields in Life Tab
    And click on the "Life view" button
    And click on the "save" button
    Then Click on the Fund button
    Then Add the Funds for Unit Linked Product with AFB Option
    Then Add the Strategy Fund
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
    Then Go to "Policy Enquiry" Page By Search
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

    Examples: 
      | TestData |
      | TD018    |

  #------------------------------------------------------------------------------------------------------------------------------
  @Payment_Method_With_Payer_Other_than_Self_With_Angaska @Bulk2 @NewBulk3
  Scenario Outline: To validate whether the user is able to create proposal with payer other than self with Payment Method as Angaska Detuction
    Given Read all the input detail from the Excel
      | TestData | <TestData> |
    Given Enter the UserName and Password
    And click on "Login" button
    Then Go to "Proposal" Page By Search
    And click on the "Create Proposal" button
    Then Select the Plan description
    And click on the "Basic Next" button
    Then Select the Individual Id and Enter the Identity number
    And Select the Agent Name
    And click on the "Proposer Next" button
    Then Select the Currency and Enter the Sum Assured
    Then Enter the policy Terms and change the Frequency
    And Enter the Premium pattern and Enter the Sum Assuren Pattern
    And Take ScreenShot
    And click on the "Policy Next" button
    And click on the "staff next" button
    Then Select the Payer Options
    And click on the "Payer Next" button
    Then Change the Payment Method as "ANGKASA DEDUCTION (01)"
    And click on the "Payment Next" button
    Then Select the Details for "ANGKASA DEDUCTION"
    Then Select the short Payment method
    And click on the "Life" button
    Then Validate the Fields in Life Tab
    And click on the "Life view" button
    And click on the "save" button
    And click on the "Nomination" button
    Then Select the Nominee details
    And click on the "Nominee Next" button
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
    Then Go to "Policy Enquiry" Page By Search
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

    Examples: 
      | TestData |
      | TD019    |

  #~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  @Add_and_Delete_LA_in_underwriting @Bulk2 @NewBulk3
  Scenario Outline: To validate whether the user able to add LA and Delete the Existing LA in UW with Payment Method as Salary Detuction
    Given Read all the input detail from the Excel
      | TestData | <TestData> |
    Given Enter the UserName and Password
    And click on "Login" button
    #Then Change the UI Settings
    #Then Navigate to Main Menu and Select "New Business"
    Then Go to "Proposal" Page By Search
    And click on the "Create Proposal" button
    Then Select the Plan description
    And click on the "Basic Next" button
    Then Select the Individual Id and Enter the Identity number
    And Select the Agent Name
    And click on the "Proposer Next" button
    Then Select the Currency and Enter the Sum Assured
    And Enter the User Premium
    Then Enter the policy Terms and change the Frequency
    And Enter the Premium pattern and Enter the Sum Assuren Pattern
    And Take ScreenShot
    And click on the "Policy Next" button
    And click on the "staff next" button
    And click on the "Payer Next" button
    Then Change the Payment Method as "SALARY DEDUCTION (02)"
    And click on the "Payment Next" button
    Then Select the Details for "SALARY DEDUCTION"
    Then Select the short Payment method
    And click on the "Life" button
    Then Add one LA
    And click on the "Life view" button
    And click on the "save" button
    And click on the "Life view2" button
    And click on the "save" button
    And click on the "Agent" button
    And click on the "Nomination" button
    Then Select the Nominee details
    And click on the "Servicing options" button
    And click on the "Process" button
    And click on the Life Detail and add the Optional Rider
    And click on the "Process" button
    And click on the Save buttons
    Then Get the DialogBox Details and click on OK button
    #Then Navigate to Main Menu icon
    Then Go to "Underwriting" Page By Search
    And Enter the Policy number and click on Search button
    Then click on the Eye Icon and click on To Proposal button One
    And click on the "Life" button
    Then Delete one LA
    And click on the "Life view" button
    Then Receive all the Documents from Document Section
    And click on the "save" button
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
    #Then Navigate to Main Menu and Select "New Business"
    #Then click on "Individual" and Select "Policy Issue"
    Then Go to "Policy Issue" Page By Search
    Then Enter the Policy Number and Click on Search button
    And Tick the Check box
    And click on "Issue" button
    Then click ok on the final popup
    #Then Navigate to Main Menu and Select "Enquiry"
    #Then click on "General Enquiry" and Select "Policy Enquiry"
    Then Go to "Policy Enquiry" Page By Search
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
      | TestData |
      | TD020    |

  #~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  @RTRUW @Bulk2 @NewBulk3
  Scenario Outline: To validate whether proposal with all AUW rules passes and do  manual UW by accepting the case with revised terms for Riders
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
    Then Select UW flag as "Yes"
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
    Then Change the Sum Assured value for rider and Receive all the documents
    And click on the "save" button
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
    Then Go to "Policy Enquiry" Page By Search
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

    Examples: 
      | TestData |
      | TD021    |

  #~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  @BL_Cancel @Bulk2 @NewBulk3 @ats
  Scenario Outline: To validate whether user is able to Blaclist a person during Underwriting
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
    Then Go to "Proposal" Page By Search
    And click on the "Create Proposal" button
    Then Select the Plan description
    And click on the "Basic Next" button
    Then Select the Individual Id and Enter the Identity number Smoke
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
    Then Go to "Issue Receipt" Page By Search
    Then Enter the Policy Number and Click on Search button
    And Tick the Check box
    And click on "Issue Receipt" button
    Then Get the Payable Amount
    Then Select the Instrument Details
    And click on "Check All" button
    And click on "Issue" button
    Then Get the DialogBox Detail and click on OK button
    #Then Navigate to Main Menu icon
    Then Go to "Underwriting" Page By Search
    And Enter the Policy number and click on Search button
    Then click on the Eye Icon and click on To Proposal button
    And click on the "Life" button
    And click on the "Life view" button
    Then Receive all the Documents from Document Section
    Then Blacklist the Person in Underwriting
    And click on the "save" button
    Then Click on the Fund button
    Then Select the Decision and Enter the reason
    And click on the "Process" button
    Then Get the Voucher Details
    And click on the Save buttons
    Then Get the DialogBox Detail and click on OK button
    And click on the "Search Policy" button
    Then click on the Eye Icon and Capture "BlackList"
    Then Go to "Voucher Enquiry" Page By Search
    Then Enter the Voucher Number and Click on Search button
    #Then Navigate to Main Menu and Select "Enquiry"
    #Then click on "General Enquiry" and Select "Policy Enquiry"
    Then Go to "Policy Enquiry" Page By Search
    Then Enter the Policy Number and Click on Search buttons
    And Take ScreenShot in the Enquiry Page

    Examples: 
      | TestData |
      | TD022    |

  #---------------------------------- -----------------------------------------------------------------------------------------
  @Dispatch_and_Acknowledge @Bulk2 @NewBulk3 @ats
  Scenario Outline: To Validate whether user is able to Dispatch and Acknowledge Policy
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
    Then Go to "Proposal" Page By Search
    And click on the "Create Proposal" button
    Then Select the Plan description
    And click on the "Basic Next" button
    Then Select the Individual Id and Enter the Identity number Smoke
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
    Then Go to "Dispatch Policy" Page By Search
    #Then Enter the Policy Number and Click on Search button
    Then click on "Search Policy" button
    Then Get Policy to Dispatch
    And Tick the Check box
    And click on "Dispatch" button
    Then click ok on the final popup
    Then Go to "Acknowledge Policy" Page By Search
    #Then click on "Search Policy" button
    Then Get the Policy to Acknowledge
    Then click on the CheckBox and Acknowledge as "Accepted"
    And click on "Acknowledge" button
    Then click ok on the final popup
    Then click ok on the Dispatch popup

    Examples: 
      | TestData |
      | TD023    |

  #---------------------------------------------------------------------------------------------------------------------------
  @Proposal_deposit_Refund @ST @Bulk2 @NewBulk3
  Scenario Outline: Smoke TestCase Execution for New Business
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
    Then Go to "Proposal" Page By Search
    And click on the "Create Proposal" button
    Then Select the Plan description
    And click on the "Basic Next" button
    Then Select the Individual Id and Enter the Identity number Smoke
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
    Then Go to "Policy to Proposal" Page By Search
    Then Enter the Policy Number in Policy to Proposal Page
    And click on "Revert Policy" button
    And click on "YES" button
    Then Get the DialogBox Detail and click on OK button
    Then Go to "Proposal Deposit Refund" Page By Search
    Then Enter the Policy Number and Click on Search button on Proposal Deposit Refung Page
    And Tick the Check box
    And click on "Generate Voucher" button
    Then Get the DialogBox Detail and click on OK button

    #Then Go to "Policy Enquiry" Page By Search
    #Then Enter the Policy Number and Click on Search buttons
    #And Take ScreenShot in the Enquiry Page
    #Then Verify the "Additional Details" tab in Enquiry Page
    #Then Validate the "Voucher"
    Examples: 
      | TestData |
      | TD024    |

  #----------------------------------------------------------------------------------------------------------------------------
  @AFB_NTU @Bulk2 @NewBulk3
  Scenario Outline: To validate whether the user is able to create proposal with Unit Link - AFB Option with UW Decision as NTU.
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
    #Then Navigate to Main Menu icon
    Then Go to "Underwriting" Page By Search
    And Enter the Policy number and click on Search button
    Then click on the Eye Icon and click on To Proposal button
    And click on the "Life" button
    And click on the "Life view" button
    Then Receive all the Documents from Document Section
    And click on the "save" button
    Then Click on the Fund button
    And click on the "Agent" button
    And click on the "Nomination" button
    And click on the "Servicing options" button
    Then Select the Decision and Enter the reason
    And click on the "Process" button
    And click on the Save buttons
    Then Get the DialogBox Detail and click on OK button
    Then Go to "Policy Enquiry" Page By Search
    Then Enter the Policy Number and Click on Search buttons
    And Take ScreenShot in the Enquiry Page

    Examples: 
      | TestData |
      | TD025    |

  #--------------------------------------------------------------------------------------------------------------------------
  @Multiple_Address_Full2 @Bulk2 @NewBulk3
  Scenario Outline: To validate new customer registeration with Multiple Address and Contacts
    Given Read all the input detail from the Excel
      | TestData | <TestData> |
    Given Enter the UserName and Password
    And click on "Login" button
    Then Go to "Customer Registration" Page By Search
    And Click on Create Customer button
    Then Select Identity and Select Identity number one
    Then Select the Title and Enter the name
    And Select the Gender
    Then Enter the Date of Birth and Select the Occupation
    Then Select the Nationality and the Select the Race
    And Enter the Height and Enter the Weight
    Then check the Existing Customer Details
    Then Enter address1 and Enter the Post code
    And click on "Add Contact" buttons
    Then Enter the Contact Type and Enter the Description
    And click on "Green" button
    Then Add the Alternate Address
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
    Then Go to "Proposal" Page By Search
    And click on the "Create Proposal" button
    Then Select the Plan description
    And click on the "Basic Next" button
    Then Select the Individual Id and Enter the Identity number Smoke
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
    And click on the "Divident Next" button
    Then Change the AddressType
    And click on the "Previous" button
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
    Then Go to "Policy Enquiry" Page By Search
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

    Examples: 
      | TestData |
      | TD026    |

  #--------------------------------------------------------------------------------------------------------------------------
  @Per_Life_Policies_UW_History @Bulk2 @NewBulk3
  Scenario Outline: To validate whether the user able to check Per Life Policies
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
    Then Go to "Proposal" Page By Search
    And click on the "Create Proposal" button
    Then Select the Plan description
    And click on the "Basic Next" button
    Then Select the Individual Id and Enter the Identity number Smoke
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
    And click on the "Nomination" button
    Then Select the Nominee details as "NO"
    And click on the "Servicing options" button
    And click on the "Process" button
    And click on the Life Detail and add the Optional Rider
    And click on the "Process" button
    And click on the Save buttons
    Then Get the DialogBox Details and click on OK button
    Then Go to "Underwriting" Page By Search
    And Enter the Policy number and click on Search button
    Then click on the Eye Icon and Capture "UW Enquiry"
    And click on the "Own Policies" button
    Then Validate Proposer Particular
    And click on the "Proposer Next" button
    And Change the SumAssured Value
    And click on the "Policy Next" button
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
    And click on the "Search Policy" button
    Then click on the Eye Icon and Capture "UW History"

    Examples: 
      | TestData |
      | TD027    |

  #-------------------------------------------------------------------------------------------------------------------------
  @Change_agent_Postpone_and_repoen @Bulk2 @NewBulk3
  Scenario Outline: To validate whether the user able to change agents during underwriting then postpone the case and reopen the case during underwriting
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
    Then Click on the Fund button
    And click on the "Agent" button
    Then Change the "Agent" details
    And click on the "Nomination" button
    And click on the "Servicing options" button
    Then Select the Decision and Enter the reason
    And click on the "Process" button
    And click on the Save buttons
    Then Get the DialogBox Detail and click on OK button
    And click on the "Search Policy" button
    Then click on the Eye Icon and click on To Proposal button One
    And click on the "Life" button
    And click on the "Life view" button
    And click on the "save" button
    Then Click on the Fund button
    And click on the "Agent" button
    And click on the "Nomination" button
    And click on the "Servicing options" button
    Then Select the Decision as "Accepted" and Enter the reason
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
    Then Go to "Policy Enquiry" Page By Search
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

    Examples: 
      | TestData |
      | TD028    |

  #----------------------------------------------------------------------------------------------------------------------------
  @exclusion_and_Linen @Bulk2 @NewBulk3
  Scenario Outline: To validate whether the user able to do the manual underwriting by accepting plan/rider with exclusions and Linen
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
    Then Select the Base Plan "Without Loading"
    Then Click the "Exclusion" >> "Add Exclusion"
    Then Add the "Exclusion" Details for criteria "Medical Exclusions"
    Then Click the "Lien" >> "Add Lien"
    Then Add the "Lien" Details for criteria "UNDERWRITING LIEN"
    Then Receive the Documents
    And click on the "save" button
    Then Select the Decision and Enter the reason
    And click on the "Process" button
    Then Verify the Fields in validation Tab
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
    Then Go to "Policy Enquiry" Page By Search
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

    Examples: 
      | TestData |
      | TD029    |

  #----------------------------------------------------------------------------------------------------------------------------
  @Plan_without_Loading_Rider_with_loading_one @Bulk2 @NewBulk3
  Scenario Outline: To validate whether the user able to do the manual underwriting by accepting the plan without loading and rider with loading
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
    Then Select the Base Plan "Without Loading"
    And click on the "BasePlanNextUW" button
    Then Select optional rider "With Loading" and Receive Documents
    And click on the "save" button
    Then Select the Decision and Enter the reason
    And click on the "Process" button
    Then Verify the Fields in validation Tab
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
    Then Go to "Policy Enquiry" Page By Search
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

    Examples: 
      | TestData |
      | TD030    |

  #---------------------------------------------------------------------------------------------------------------------------
  @Plan_with_Loading_Rider_without_loading_one @Bulk2 @NewBulk2
  Scenario Outline: To validate whether the user able to do the manual underwriting by accepting the plan with loading and rider without loading
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
    Then Select the Base Plan "With Loading"
    Then Click the "Charges" >> "Loading"
    Then Add the "Loading" Details for criteria "PERCENTAGE"
    And click on the "BasePlanNextUW" button
    Then Select optional rider "Without Loading" and Receive Documents
    And click on the "save" button
    Then Select the Decision and Enter the reason
    And click on the "Process" button
    Then Verify the Fields in validation Tab
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
    Then Go to "Policy Enquiry" Page By Search
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

    Examples: 
      | TestData |
      | TD031    |

  #----------------------------------------------------------------------------------------------------------------------------
  @QC_for_multiple_Policies @Bulk2 @NewBulk2
  Scenario Outline: To validate whether user is able to do Quality check and Policy Issuance for multiple policies at a time
    Given Read all the input detail from the Excel
      | TestData | <TestData> |
    Given Enter the UserName and Password
    And click on "Login" button
    Then Go to "Quality Check" Page By Search
    Then Select the date and Click on Search the buttonsss
    And Tick the multiple Check box and select the QC options for the same
    And click on "Quality Approve" button
    Then Get the DialogBox Detail and click on OK button
    Then Go to "Policy Issue" Page By Search
    Then Select the date and Click on Search the buttonsss
    And Select the Check box for bulk policies
    And click on "Issue" button
    Then click ok on the final popup

    Examples: 
      | TestData |
      | TD013    |
