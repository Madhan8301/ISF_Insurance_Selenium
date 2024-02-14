package com.kgisl.stepDefinition;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.kgisl.base.BaseUtilTest;
import com.kgisl.base.CompanyExcelUtility;
import com.kgisl.base.CustomerExcelUtility;
import com.kgisl.base.DB_Connection;
import com.kgisl.base.Data_Set;
import com.kgisl.base.ExcelUtility;
import com.kgisl.base.FrameworkConfig;
import com.kgisl.base.Hooks;
import com.kgisl.base.ProposalExcelUtility;
import com.kgisl.base.RiderExcelUtility;
import com.kgisl.library.LibraryClass;
import com.kgisl.library.ReportOut;
import com.kgisl.library.ReportUtility;

import groovyjarjarantlr4.v4.runtime.misc.InterpreterDataReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;



public class BaseDefins extends BaseUtilTest {

	private ExcelUtility excelData;
	
	private RiderExcelUtility RiderExceldata;
	private CustomerExcelUtility CustomerExceldata;
	private CompanyExcelUtility companyExceldata;
	
	private DB_Connection db;
	private Data_Set report;
	private Hooks base;
	private ReadTestData dataRead;
	public String DBpath = System.getProperty("user.dir") + "\\TestData" + "\\sqlite\\";
	
	private Scenario myScenario;
	public static String StartTime;
	public LibraryClass library;
	public int rownumber;
	public String scenarioName;
	private Connection con = null;
	public static FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);
	public String fileName = config.DBName();
//	public static String Tomail=config.Tomail();
//	public static String Subject=config.MailSubject();
//	public static String Text=config.MailText();
	public static String Browsername;
	public static String Browserversion;
	private static List<Object[]> testData;
	private static List<Map<String, Object>> testDataList;
	
	public BaseDefins(Hooks base, DB_Connection db, Data_Set report, ExcelUtility excel,LibraryClass library,
			ReadTestData dataRead,RiderExcelUtility RiderExceldata,CompanyExcelUtility companyExceldata,
			CustomerExcelUtility CustomerExceldata) {
		this.base = base;
		this.db = db;
		this.report = report;
		this.excelData = excel;
		this.library=library;
		this.dataRead=dataRead;
		this.RiderExceldata=RiderExceldata;
		this.CustomerExceldata=CustomerExceldata;
		this.companyExceldata=companyExceldata;
		
	}
	
	@BeforeAll
	public static void connectDB() throws Exception {

		System.out.println("Beforeall");
		DB_Connection db = new DB_Connection();
		StartTime = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new java.util.Date());		
		db.createDB();
		db.createTable();
//		Heap_Increase();
		
		String dir = System.getProperty("user.dir");
		String path = dir + "\\allure-results";
//		String path2 = dir +"\\Report\\HtmlReport\\Screenshots";
		
		FileUtils.cleanDirectory(new File(path));
//		FileUtils.cleanDirectory(new File(path2));
		
	}
	


	@Before
	public void launchApp(Scenario scenario) throws Throwable {
		myScenario = scenario;
		myScenario.getId();	
		scenarioName = myScenario.getName();
		System.out.println("This is before Scenario: " + scenario.getName().toString());
		if(config.Mode().equalsIgnoreCase("Web")) {
		base.launchBrowser();
		String UdateDateQuery = "alter system set fixed_date = " + "'" + library.todaysDate() + "'";
//		library.query(UdateDateQuery);
		System.out.println(UdateDateQuery);
//		Connection connection = library.getDBConnection();
//		
//		try {
//			
//			System.out.println("Creating statement…");
//			Statement statement = connection.createStatement();
////			connection.setAutoCommit(false); 
//			statement.executeQuery(UdateDateQuery);
//			
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
				
		base.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		Browsername=base.browser;
//		Browserversion=base.Browserversion;
		}
	else{
			base.LaunchMobileApp();
		}
		
	}


	@After
	public void tearDown(Scenario scenario) throws Exception {
		System.out.println("TestAfter");

		if (scenario.isFailed()) {
			try {
				System.out.println(scenario + " test is failed");
				takeScreenShot(" test is failed");
			} catch (Exception e) {
				try {
					System.out.println(scenario + " test is failed");
					System.out.println(">>>>>>>>>>>>>>>>>UnException Alert opened.<<<<<<<<<<<<<<<<<");
				} catch (Exception ee) {
				}
			}
		}

		System.out.println(scenario.getId());

		try {
			String url = "jdbc:sqlite:" + DBpath + fileName + ".db";
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(url);
			con.setAutoCommit(false);

			String Insert_Query = "INSERT INTO Summary (TestCaseID, ScenarioName, Status,TIMESTAMP, TestData) VALUES(?,?,?,?,?)";
			PreparedStatement SummaryStatement = con.prepareStatement(Insert_Query);
			String Startdate = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new java.util.Date());
			// statement.setString(0,myScenario.getId());
			SummaryStatement.setString(1, report.getTestcaseID());
			SummaryStatement.setString(2, scenario.getName());
			SummaryStatement.setString(3, String.valueOf(scenario.getStatus()));
			SummaryStatement.setString(4, Startdate);
//			SummaryStatement.setString(5, "ExcelData");
			SummaryStatement.setString(5, "ExcelData");
			SummaryStatement.addBatch();

			SummaryStatement.executeBatch();
			con.setAutoCommit(true);

		} catch (SQLException ex2) {
			System.out.println("Database error");
			ex2.printStackTrace();
		}

		try {
			String url = "jdbc:sqlite:" + DBpath + fileName + ".db";
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(url);

			con.setAutoCommit(false);
			String Insert_Query = "INSERT INTO Master (TestCaseID, ScenarioName, Status, TIMESTAMP, TestData) VALUES(?,?,?,?,?)";
			PreparedStatement MasterStatement = con.prepareStatement(Insert_Query);
			String Startdate = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new java.util.Date());
			// statement.setString(0,myScenario.getId());
			MasterStatement.setString(1, report.getTestcaseID());
			MasterStatement.setString(2, scenario.getName());
			MasterStatement.setString(3, String.valueOf(scenario.getStatus()));
			MasterStatement.setString(4, Startdate);
//			MasterStatement.setString(5, CustomerExceldata.TestDataInMap.toString().replace("null", "N/A"));
			MasterStatement.setString(5, "ExcelData");
			MasterStatement.addBatch();

			MasterStatement.executeBatch();
			con.setAutoCommit(true);
			// con.commit();
			Thread.sleep(1000);

		} catch (SQLException ex2) {
			System.out.println("Database error");
			ex2.printStackTrace();
		}

		base.getDriver().close();
		base.getDriver().quit();		
		
	
	}
	
	public static void Heap_Increase() {
		long initialHeapSize = Runtime.getRuntime().totalMemory();
        System.out.println("Initial Heap Size: " + initialHeapSize);

        // Increase heap size (this is not guaranteed to work)
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "java",
                    "-Xmx512m",  // New heap size
                    "-cp",
                    System.getProperty("java.class.path"),BaseDefins.class.getName()
            );
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Updated heap size
//        long maxHeapSize = 8942967296; // 512 megabytes
//        String updatedHeapSize = Long.toString(maxHeapSize);
        String updatedHeapSize = "8942967296";
        System.setProperty("java.vm.max_heap_size", updatedHeapSize);
        System.out.println("Updated Heap Size: " + updatedHeapSize);
	}

	
	public void takeScreenShot(String ssName) throws Exception {
		try {
			byte[] screenshot = ((TakesScreenshot) base.getDriver()).getScreenshotAs(OutputType.BYTES);
			myScenario.attach(screenshot, "image/png", ssName); // Stick it in the report
		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
		} catch (ClassCastException cce) {
			cce.printStackTrace();
		}
	}

	public void takeScreenShotOfMobile(String ssName) throws Exception {
		try {
			byte[] screenshot = ((TakesScreenshot) base.mGetDriver()).getScreenshotAs(OutputType.BYTES);
			myScenario.attach(screenshot, "image/png", ssName); // Stick it in the report
		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
		} catch (ClassCastException cce) {
			cce.printStackTrace();
		}
	}

	public Integer aRandomOpenPortOnAllLocalInterfaces() {
		try (ServerSocket socket = new ServerSocket(0);) {
			return socket.getLocalPort();

		} catch (IOException e) {
			throw new RuntimeException("no open ports found for bootstrap");
		}
	}
	
	public void InsertQuery(String policyNo) throws InterruptedException {		
		
		try {
			String url = "jdbc:sqlite:" + DBpath + fileName + ".db";
			con = DriverManager.getConnection(url);

			con.setAutoCommit(false);
			String Insert_Query = "INSERT INTO policyNo (TestCaseID,scenarioName,policyNo) VALUES(?,?,?);";
			PreparedStatement PolicyStatement = con.prepareStatement(Insert_Query);
			PolicyStatement.setString(1, report.getTestcaseID());
			PolicyStatement.setString(2, scenarioName);
			PolicyStatement.setString(3, policyNo);			
			PolicyStatement.addBatch();
			PolicyStatement.executeBatch();
			con.setAutoCommit(true);
			// con.commit();
			Thread.sleep(1000);

		} catch (SQLException ex2) {
			System.out.println("Database error");
			ex2.printStackTrace();
		}
	}
	


	
     

	
	 @AfterAll
		public static void generateReport() throws Throwable {
		 System.out.println("---------AfterAll----------------");			
		 ExcelUtility excel = new ExcelUtility();
			Hooks base = new Hooks();
			ReportUtility report = new ReportUtility();
			LibraryClass library =new LibraryClass(base);
//			report.generateJVMReport();
			excel.generatePolicyNoReports();
			excel.generateReports(StartTime,Browsername);
//			SendEmail();
			
		}
	 
	 
	 public static void SendEmail() {
		 final String username = "kumar.madhan8301@gmail.com";
	       final String password = "Madhan@6765";

	        // Set the properties for the email server
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");

	        // Get the Session object
	        Session session = Session.getInstance(props, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	        });

	        try {
	            // Create a MimeMessage object
	            Message message = new MimeMessage(session);

	            // Set the sender's email address
	            message.setFrom(new InternetAddress("madhan.kumar@kgisl.com"));

	            // Set the recipient's email address
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("madhan.kumar@kgisl.com"));

	            // Set the email subject
	            message.setSubject("Test Automation Report");

	            // Set the email body
	            message.setText("Please find attached the test automation report.");

	            // Attach the test report file
	            String reportFilePath = "D:\\Nsure_Evergreen\\Git\\Evergreen\\Report\\test output\\PdfReport\\ExtentPdf.pdf";
	            Multipart multipart = new MimeMultipart();
	            MimeBodyPart messageBodyPart = new MimeBodyPart();
	            DataSource source = new FileDataSource(reportFilePath);
	            messageBodyPart.setDataHandler(new DataHandler(source));
	            messageBodyPart.setFileName("TestReport.html");
	            multipart.addBodyPart(messageBodyPart);
	            message.setContent(multipart);

	            // Send the email
	            Transport.send(message);

	            System.out.println("Email sent successfully!");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }
	   


}
