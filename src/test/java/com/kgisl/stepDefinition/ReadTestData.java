package com.kgisl.stepDefinition;

import java.util.HashMap;
import java.util.Map;

import org.aeonbits.owner.ConfigFactory;

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
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;

public class ReadTestData {
	
	private String TestId = null;
	private String sheetName = null;
	private Map<String, String> InputData;

	private Data_Set Data;
	private ExcelUtility readExcel;
	private RiderExcelUtility RiderExceldata;
	private CustomerExcelUtility CustomerExceldata;
//	private ProposalExcelUtility proposalExceldata;
	private CompanyExcelUtility companyExceldata;
	private ReportOut report;
	

	public String Homepage = null;

	private String workingDir = System.getProperty("user.dir");
	public String testfilepath ;
	FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);

	public ReadTestData(Data_Set DataSet, ExcelUtility ReadExcel,ReportOut report,RiderExcelUtility RiderExceldata,CustomerExcelUtility CustomerExceldata
			,CompanyExcelUtility companyExceldata){
		this.Data = DataSet;
		this.readExcel = ReadExcel;
		this.report=report;
		this.RiderExceldata=RiderExceldata;
		this.CustomerExceldata=CustomerExceldata;
		this.companyExceldata=companyExceldata;
//		this.proposalExceldata=proposalExceldata;
	}
	
	
	@Given("Read all the input detail from the Excel")
	public void ReadInputData(DataTable sheet) throws Exception {
//		report.setApplicationName(Application);
	
		
		InputData = new HashMap<String, String>();
		InputData = sheet.asMap(String.class, String.class);
						
		TestId = InputData.get("TestData");
		System.out.println("TestCase ID:" +TestId);
		
		Data.setTestcaseID(TestId);

		
		if (InputData.get("sheetName") != null && !InputData.get("sheetName").isEmpty()) {
			sheetName = InputData.get("sheetName");
		} else{
			sheetName = config.DataSheetName();
		}
		Data.setSheet(sheetName);
		System.out.println("sheetName :"+sheetName);
		
		
		testfilepath = workingDir + "\\TestData\\Nsure_TestData.xlsx";
//		testfilepath = workingDir + "\\TestData\\HNB_TestData.xlsx";
		
		System.out.println("testfilepath: "+testfilepath);
		
//		readExcel.getTestDataInmap(testfilepath,"TestData", TestId);
		
		CustomerExceldata.getTestDataInmap(testfilepath,"Main_Sheet", TestId);
//		proposalExceldata.getTestDataInmap(testfilepath,"Proposal_Details", TestId);
		RiderExceldata.getTestDataInmap(testfilepath,"RiderDetails", TestId);
//		agentExceldata.getTestDataInmap(testfilepath,"AgentDetails_Nominee_Trustee", TestId);
		

	}
	
	@Given("Read all the input detail from the Excel for Company Registration")
	public void ReadInputData_One(DataTable sheet) throws Exception {
//		report.setApplicationName(Application);
	
		
		InputData = new HashMap<String, String>();
		InputData = sheet.asMap(String.class, String.class);
						
		TestId = InputData.get("TestData");
		System.out.println("TestCase ID:" +TestId);
		
		Data.setTestcaseID(TestId);

		
		if (InputData.get("sheetName") != null && !InputData.get("sheetName").isEmpty()) {
			sheetName = InputData.get("sheetName");
		} else{
			sheetName = config.DataSheetName();
		}
		Data.setSheet(sheetName);
		System.out.println("sheetName :"+sheetName);
		
		
		testfilepath = workingDir + "\\TestData\\TestData.xlsx";
		
		System.out.println("testfilepath: "+testfilepath);
		
		companyExceldata.getTestDataInmap(testfilepath,"Company_Reg", TestId);	

	}


	public ReportOut getReport() {
		return report;
	}


	public void setReport(ReportOut report) {
		this.report = report;
	}
}
