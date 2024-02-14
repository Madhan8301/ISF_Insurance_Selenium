@Negative_Scenarios
Feature: Nsure - New Business > Negative Scenarios

@NegModify
Scenario Outline: To validate Modify customer for a existing customer policy has been issued
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
    Then Get The Reference number
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
    
    Then Go to "Policy Enquiry" Page By Search
    Then Enter the Policy Number and Click on Search buttons
    And Take ScreenShot in the Enquiry Page
    
    Then Go to "Customer Registration" Page By Search
    Then Enter the Reference number
    Then Click on the edit icon of the customer and get the details and click on ok button

		  Examples: 
      | TestData |
      | TD001    |
 #----------------------------------------------------------------------------------------------------------------------------
 
 @NegTerm
Scenario Outline: To check whether the error message is shown when user enters SA,TERM not in the plan wizard  setup
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
    Then Validate the Final Tab

		  Examples: 
      | TestData |
      | TD032    |
#-------------------------------------------------------------------------------------------------------------------------------
 @NegPrem
Scenario Outline: To check whether the error message is shown when user enters User Pemium,AGE not in the plan wizard setup
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
    Then Validate the Final Tab

		  Examples: 
      | TestData |
      | TD033    |
      
  #--------------------------------------------------------------------------------------------------------------------------
  
  @NegRiderTerm
 Scenario Outline: To check whether the error message is shown when user enters Term and SumAssured not in the plan wizard  setup for Rider.
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
    Then Validate the Final Tab
    
    Examples: 
      | TestData |
      | TD034    |
#--------------------------------------------------------------------------------------------------------------------------
 @PDNotPaid
 Scenario Outline: To validate whether the Error message is shown when user select  policy (PD is notpaid) to generate voucher in Proposal Deposit Refund screen 
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
    And click on the Save buttons
    Then Get the DialogBox Details and click on OK button
    
    Then Go to "Proposal Deposit Refund" Page By Search
    Then Enter the Policy Number and Validate Proposal Deposit Refund Page
    
        Examples: 
      | TestData |
      | TD003    |
#------------------------------------------------------------------------------------------------------------------------------

 @Proposal_deposit_Refund_After_Days_Exeed 
Scenario Outline: To validate whether the error message is shown when user try to revert the policy when number of days exceeded in the plan setup ( plan wizard >> New Business )
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
    
		Then Go to "Policy to Proposal" Page By Search
		Then Change the Policy Commencement Date
    Then Enter the Policy Number in Policy to Proposal Page
    And click on "Revert Policy" button
    And click on "YES" button
    Then Validate Policy to Proposal Screen
    
  	Examples:
  	 | TestData |
     | TD003    |
     
#---------------------------------------------------------------------------------------------------------------------------------

     @PolicytoProposalWithoutIssue
Scenario Outline: To validate whether the error message is shown when user enter the policy which is not issued in the policy no field
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
    And click on the Save buttons
    Then Get the DialogBox Details and click on OK button
    
		Then Go to "Policy to Proposal" Page By Search
		Then Enter the Policy Number and Validate Proposal Deposit Refund Page
    
  	Examples:
  	 | TestData |
     | TD003    |
 #---------------------------------------------------------------------------------------------------------------------------
      @WrongLArelation
Scenario Outline: To check whether the error message is shown when user enters LA Relation which is not in the plan wizard  setup
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
    Then Select the Proposer Relation
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
    Then Validate the Final Tab
    
  	Examples:
  	 | TestData |
     | TD035    |
 #---------------------------------------------------------------------------------------------------------------------------
 
 @Plan_with_Loading_Error
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
    Then Select the Base Plan "Without Loading"
    Then Click the "Charges" >> "Loading"
    Then Add the "Loading" Details for criteria "PERCENTAGE"
    And click on the "BasePlanNextUW" button
    Then Select optional rider "Without Loading" and Receive Documents
    And click on the "save" button
    Then Select the Decision and Enter the reason
    And click on the "Process" button
		Then Validate the Final Tab


    Examples: 
      | TestData |
      | TD031    |
#----------------------------------------------------------------------------------------------------------------------------
 @Plan_without_Loading_Error
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
    And click on the "BasePlanNextUW" button
    Then Select optional rider "Without Loading" and Receive Documents
    #Then Select Rider Loading as "Without Loading"
    #Then Select the Loading Details and Receive Doccument
    And click on the "save" button
    Then Select the Decision and Enter the reason
    And click on the "Process" button
		Then Validate the Final Tab


    Examples: 
      | TestData |
      | TD036    |
#--------------------------------------------------------------------------------------------------------------------------
 @Plan_with_RiderLoading_Error @newOne
Scenario Outline: To Check whether error message is displayed when user giving the Loading value without accept loading for Rider.
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
    Then Select Rider Loading as "Without Loading"
    Then Select the Loading Details and Receive Doccument
    And click on the "save" button
    Then Select the Decision and Enter the reason
    And click on the "Process" button
		Then Validate the Final Tab


    Examples: 
      | TestData |
      | TD031    |
#-----------------------------------------------------------------------------------------------------------------------------
 @Plan_without_RiderLoading_Error @newOne
Scenario Outline: To Check whether error message is displayed when user Accept the Loading without Capturing Loading value for Rider.
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
    Then Select Rider Loading as "With Loading"
    #Then Select the Loading Details and Receive Doccument
    And click on the "save" button
    Then Select the Decision and Enter the reason
    And click on the "Process" button
		Then Validate the Final Tab


    Examples: 
      | TestData |
      | TD036    |
#------------------------------------------------------------------------------------------------------------------------------

@Guarantee_Error @Mad
 Scenario Outline: To check whether the error message is shown when user enters GURANTEE PERIOD not in the plan wizard  setup
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
    Then Validate the Final Tab
    
    Examples: 
      | TestData |
      | TD037    |
#-------------------------------------------------------------------------------------------------------------------------------

 @D_trs_Error @Mad
Scenario Outline: To check whether the error message is shown when user enters customers with AGE not in the plan wizard  setup for Loan Product.
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
    Then Validate the Final Tab
    
        Examples: 
      | TestData |
      | TD038    |
      