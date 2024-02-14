package com.kgisl.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.kgisl.PageElements.Web.UnderwritingPage;
import com.kgisl.base.BaseUtilTest;
import com.kgisl.base.Hooks;
import com.mysql.jdbc.PreparedStatement;

/*import com.testautomationguru.utility.CompareMode;
import com.testautomationguru.utility.PDFUtil;
*/
public class LibraryClass extends BaseUtilTest {
	private Hooks base;
	// PDFUtil pdfUtil = new PDFUtil();
	public Statement st;
	public WebDriverWait wait;
	public UnderwritingPage underWritingPage;
	public WebDriverWait wait1;
	private static final String CHAR_LIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String sourcePath = System.getProperty("user.dir");
	public String downloadPath = System.getProperty("user.home");

	public LibraryClass(Hooks base) {
		this.base = base;
//		this.underWritingPage = underWritingPage;
	}

	public void waitForInVisibilityOfElement(By invisbleElement) throws Throwable {
		try {
			wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(base.globalWait));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(invisbleElement));
		} catch (Exception ignored) {

		}
	}

	public void waitForPresenceOfElement(By invisbleElement) throws Throwable {
		try {
			wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(base.globalWait));
			wait.until(ExpectedConditions.presenceOfElementLocated(invisbleElement));
		} catch (Exception ignored) {

		}
	}
	
	public void waitForPresenceOfElement(By invisbleElement,int secoonds) throws Throwable {
		try {
			wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(secoonds));
			wait.until(ExpectedConditions.presenceOfElementLocated(invisbleElement));
		} catch (Exception ignored) {

		}
	}
	
	

//	public void waitForvisibilityofWebOfElement11(By invisbleElement) throws Throwable {
//		try {
//			wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(base.globalWait));
//			wait.until(ExpectedConditions.visibilityOf(invisbleElement));
//		} catch (Exception ignored) {
//
//		}
//	}

	public void elementstable(By stableElement) throws Throwable {
		waitForVisibilityOfElement(stableElement,90);
		waitForPresenceOfElement(stableElement,50);
		waitForVisibilityOfElement(stableElement,90);
	}
//	public void elementstable(WebElement stableElement) throws Throwable {
//		waitForPresenceOfElement(stableElement,30);
//		waitForVisibilityOfElement(stableElement,30);
//	}

	public void waitForAllInvisibilityOfElements(By invisbleElement) {
		try {
			List<WebElement> finaltarget = base.getDriver().findElements(invisbleElement);
			wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(base.globalWait));
			wait.until(ExpectedConditions.invisibilityOfAllElements(finaltarget));
		} catch (Exception ignored) {

		}
	}

	public void waitForInVisibilityOfElement(By invisbleElement, int secondsToWait) throws Throwable {
		wait1 = new WebDriverWait(base.getDriver(), Duration.ofSeconds(secondsToWait));
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(invisbleElement));
	}

	public void waitForClickableElement(By clickableElement) throws Throwable {
		wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(base.globalWait));
		wait.until(ExpectedConditions.elementToBeClickable(clickableElement));
	}

	public void waitForClickableElement(By clickableElement, int secondsToWait) throws Throwable {
		wait1 = new WebDriverWait(base.getDriver(), Duration.ofSeconds(secondsToWait));
		wait1.until(ExpectedConditions.elementToBeClickable(clickableElement));
	}

	public void waitForClickableElement(WebElement element) {
		wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(base.globalWait));
		wait.until(ExpectedConditions.elementToBeClickable(element));
//		wait.until(ExpectedConditions.);
	}

	public void waitForVisibilityOfElement(By visbleElement)  {
		wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(base.globalWait));
		wait.until(ExpectedConditions.visibilityOfElementLocated(visbleElement));
	}

	public void waitForVisibilityOfElement(WebElement Element) {
		wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(base.globalWait));
		wait.until(ExpectedConditions.visibilityOf(Element));
	}

	public void waitForVisibilityOfElement(By visbleElement, int secondsToWait) {
		wait1 = new WebDriverWait(base.getDriver(), Duration.ofSeconds(secondsToWait));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(visbleElement));
	}

	// Mobile Methods

	public void mobileWaitForVisibilityOfElement(By visbleElement) throws Exception {
		wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(base.globalWait));
		wait.until(ExpectedConditions.visibilityOfElementLocated(visbleElement));
	}

	public void mobileWaitForClickableElement(By clickableElement) throws Throwable {
		wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(base.globalWait));
		wait.until(ExpectedConditions.elementToBeClickable(clickableElement));
	}

	public void mobileWaitForInVisibilityOfElement(By invisbleElement) throws Throwable {
		/*
		 * Thread.sleep(2000); String getTextofPopup =
		 * base.mGetDriver().findElement(invisbleElement).getText();
		 * System.out.println("Popup Message:********"+getTextofPopup);
		 */
		wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(base.globalWait));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(invisbleElement));
	}
	// ----------------------------------------------------------------------------------
	// Common Methods
	// ----------------------------------------------------------------------------------

	public void deleteAllFiles(String deletedFolderName) {
		String home = downloadPath;
		String projectPath = sourcePath;
		File sourceFile = new File(sourcePath + "/" + deletedFolderName + "/");
		String name = sourceFile.getName();
		boolean fileExists = sourceFile.exists();
		if (fileExists == true) {
			File[] listFiles = sourceFile.listFiles();
			for (File file : listFiles) {
				file.delete();
			}
		}
	}

	public void deleteFileFromDownlaods(String searchDoc) {
		String home = downloadPath;
		String fileName = searchDoc;
		// name of source file
		File sourceFile = new File(home + "/Downloads/" + fileName);
		String name = sourceFile.getName();
		boolean fileExists = sourceFile.exists();
		if (fileExists == true) {
			sourceFile.delete();
		}
	}

	public void copyFile(String searchDoc, String targetFolder) throws IOException {
		String home = downloadPath;
		String projectPath = sourcePath;
		String fileName = searchDoc;
		// directory where file will be copied
		String target = projectPath + "/" + targetFolder + "/";
		// name of source file
		File sourceFile = new File(home + "/Downloads/" + fileName);
		String name = sourceFile.getName();
		boolean fileExists = sourceFile.exists();
		if (fileExists == true) {
			File targetFile = new File(target + name);
			System.out.println("Copying file : " + sourceFile.getName() + " from Java Program");
			targetFile.delete();
			// copy file from one location to other
			FileUtils.copyFile(sourceFile, targetFile);

			System.out.println("copying of file from Java program is completed");
		} else {
			System.out.println("File does not exists");
		}

	}

	public void compardPDFDoc(String expecteResultFolder, String expectedFileName, String acutualResultFolder,
			String actualFileName, String comparisionFolderName) throws IOException {
		deleteAllFiles(comparisionFolderName);
		String file1 = sourcePath + "/" + expecteResultFolder + "/" + expectedFileName;
		String file2 = sourcePath + "/" + acutualResultFolder + "/" + actualFileName;

		/*
		 * String file1=
		 * "D:/Selenium_Automation/RHBI/Automation/AutoItScripts/Expected/printpdf.pdf";
		 * String file2=
		 * "D:/Selenium_Automation/RHBI/Automation/AutoItScripts/printpdf.pdf";
		 */

		// compares the pdf documents and returns a boolean
		// true if both files have same content. false otherwise.
		// Default is CompareMode.TEXT_MODE

		PDDocument expPDF = PDDocument.load(new File(file1));
		int expectedPDFPageCount = expPDF.getNumberOfPages();

		PDDocument actualPDF = PDDocument.load(new File(file1));
		int actualPDFPageCount = actualPDF.getNumberOfPages();

		if (expectedPDFPageCount != actualPDFPageCount) {
			Assert.fail("PDF Page Count Is Not Same");
		}

		// pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
		/*
		 * pdfUtil.compare(file1, file2);
		 */
		/*
		 * // compare the 3rd page alone pdfUtil.compare(file1, file2, 3, 3);
		 */

		/*
		 * // compare the pages from 1 to 5 pdfUtil.compare(file1, file2, 1, 1);
		 */

		// if you need to store the result
		/*
		 * pdfUtil.highlightPdfDifference(true);
		 * pdfUtil.setImageDestinationPath(sourcePath + "/" + comparisionFolderName +
		 * "/");
		 * 
		 * for (int i = 1; i <= expectedPDFPageCount; i++) { pdfUtil.compare(file1,
		 * file2, i, i); }
		 */

	}

	public boolean verifyTextfromSavedPDFFile(String[] pdfSearchString, String filePath) {
		String[] reqTextInPDF = pdfSearchString;
		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		String parsedText = null;
		boolean flag = false;
		int i;
		try {
			flag = false;
			File file = new File(filePath);
			PDFParser parser = new PDFParser((RandomAccessRead) new FileInputStream(file));
			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdfStripper.setStartPage(1);
			pdfStripper.setEndPage(1);

			pdDoc = new PDDocument(cosDoc);
			parsedText = pdfStripper.getText(pdDoc);
		} catch (MalformedURLException e2) {
			System.err.println("URL string could not be parsed " + e2.getMessage());
		} catch (IOException e) {
			System.err.println("Unable to open PDF Parser. " + e.getMessage());
			try {
				if (cosDoc != null)
					cosDoc.close();
				if (pdDoc != null)
					pdDoc.close();
			} catch (Exception e1) {
				e.printStackTrace();
			}
		}

		for (i = 0; i < reqTextInPDF.length; i++) {
			if (parsedText.contains(reqTextInPDF[i])) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		if (flag == false) {
			Assert.fail("Unable to find text in PDF document" + reqTextInPDF[i]);
		}
		return flag;

	}

	public static double convertToDoubleAndRoundOff(String toConvert) throws ParseException {
		if (toConvert == null) {
			toConvert = "0.00";
		}
		NumberFormat nf1 = NumberFormat.getInstance();
		DecimalFormat df = new DecimalFormat("0.00");
		Number numberValue = nf1.parse(toConvert);
		Double doubleValue = numberValue.doubleValue();
		double roundOff = (double) Math.round(doubleValue * 100.00) / 100.00;

		String formate = df.format(roundOff);
		// double finalValue = (Double)df.parse(formate) ;
		double finalValue = Double.parseDouble(formate);

		return finalValue;
	}

	public double convertToDoubleAndRoundOffTwoDecimal(String toConvert) throws ParseException {
		if (toConvert == null) {
			toConvert = "0.00";
		}
		NumberFormat nf1 = NumberFormat.getInstance();
		DecimalFormat df = new DecimalFormat("0.00");
		Number numberValue = nf1.parse(toConvert);
		Double doubleValue = numberValue.doubleValue();
		double roundOff = (double) Math.round(doubleValue * 100.00) / 100.00;

		String formate = df.format(roundOff);
		// double finalValue = (Double)df.parse(formate) ;
		double finalValue = Double.parseDouble(formate);

		return finalValue;
	}

	public static BigDecimal convertToDoubleAndRoundOff1(String toConvert) throws ParseException {

		NumberFormat nf1 = NumberFormat.getInstance();
		DecimalFormat df = new DecimalFormat("0.00");
		Number numberValue = nf1.parse(toConvert);
		Double doubleValue = numberValue.doubleValue();
		double roundOff = (double) Math.round(doubleValue * 100.00) / 100.00;
		String formate = df.format(roundOff);
		BigDecimal bd = new BigDecimal(formate);
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		// double finalValue = Double.parseDouble(formate);
		return bd;
	}

	public int covertStringToInteger(String convertionString) {
		int convertIntValue = Integer.parseInt(convertionString);
		return convertIntValue;
	}

	public String convertIntegerToString(int convertionValue) {
		String convertStringtValue = String.valueOf(convertionValue);
		return convertStringtValue;
	}

	public String convertdoubleToString(double convertionValue) {
		String convertStringtValue = String.valueOf(convertionValue);
		return convertStringtValue;
	}

	public double setRoundingMode(double digit, String Type) {
		double d = 0;
		DecimalFormat df = new DecimalFormat("#.##");
		switch (Type) {
		case "UP":
			df.setRoundingMode(RoundingMode.CEILING);
		case "DOWN":
			df.setRoundingMode(RoundingMode.DOWN);
		case "MIED":
			df.setRoundingMode(RoundingMode.CEILING);
		default:
			Assert.fail("Given Option not avialble.");
		}
//	df.setRoundingMode(RoundingMode.CEILING);
		for (Number n : Arrays.asList(digit)) {
			d = Double.parseDouble(df.format(n.doubleValue()));
		}
		return d;
	}

	// DB Activity
	public String DBVerification(String sqlQuery, String ColumnToGet, String expectedValue) throws SQLException {
		expectedValue = null;
		ResultSet resultSet = null;
		resultSet = st.executeQuery(sqlQuery);

		while (resultSet.next()) {
			expectedValue = resultSet.getString(ColumnToGet);
		}
		return expectedValue;
	}

	public void SqlQuery(String sql) {

		String connectionUrl = "jdbc:sqlserver://172.16.24.74:1521;encrypt=true;databaseName=Nsure New DB;user=ISFEVGQA;password=ISFEVGQA899768";
		try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
//            String SQL = "SELECT TOP 10 * FROM Person.Contact";
			ResultSet rs = stmt.executeQuery(sql);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
			}
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public WebElement fluient_Wait(By element) {
		WebDriver driver = base.getDriver();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(Duration.ofSeconds(30)) 			
				.pollingEvery(Duration.ofSeconds(5)) 			
				.ignoring(Exception.class);
		WebElement actualElement = wait.until(new Function<WebDriver, WebElement>(){
			
//			WebDriver driver1 = base.getDriver();
			public WebElement apply(WebDriver driver ) {
				return base.getDriver().findElement(element);
			}
		});
		return actualElement;
		
	}
	
	
	public Connection getDBConnection() throws Throwable, IllegalAccessException, ClassNotFoundException {
		String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
		String DB_URL = "jdbc:oracle:thin:@172.16.24.72:1521";
		String dbname = "PDBISFEVGN";
		String USER = "ISFEVGN";
		String PASS = "ORACLE438";
		Connection conn = null;
		ResultSet rs = null;

		Class.forName(JDBC_DRIVER).newInstance();

		System.out.println("Connecting to database…");
		conn = DriverManager.getConnection(DB_URL + "/" + dbname, USER, PASS);
		return conn;

		
	}
	
	
	

	public String query(String sql) throws Throwable {


		Connection connection = getDBConnection();
		String column1Value = null;
		if(connection != null) {
			try {
				
				System.out.println("Creating statement…");
				Statement statement = connection.createStatement();
//				connection.setAutoCommit(false); 
				ResultSet resultSet = statement.executeQuery(sql);
//				connection.commit();
				
				while (resultSet.next()) {
                    // Process data here, e.g., retrieve values from columns
//                    String column1Value = resultSet.getString("column1");
					column1Value = resultSet.getString(1);
//                    System.out.println(column1Value);
                    
                }
				resultSet.close();
                statement.close();
                connection.close();
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return column1Value;
		
	}

	public void executeUpdateQuery(String sqlquery) {
		try {
			int ret = st.executeUpdate(sqlquery);
			if (ret > 0)
				System.out.println("Rows impacted :" + ret);
			else
				System.out.println("Not Updated");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String generateRandomNumbers(int count) {
		SecureRandom random = new SecureRandom();
		int num = random.nextInt(count);
		String number = String.format("%06d", num);
		return number;
	}

	// ----------------------------------------------------------------------------------
	// ----Date Functions

	public String todaysDate() {
		Date todays = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		String date = formatter.format(todays);
		String todaysDate = date;
		System.out.println(todaysDate);
		return todaysDate;
	}

	public boolean calculateleapyear() {
		boolean chkleapyear;
		Calendar cal = Calendar.getInstance();
		// Date today = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		cal.add(Calendar.YEAR, 1);
		String nextyear = sdf.format(cal.getTime());
		if ((Integer.parseInt(nextyear) % 4 == 0 ? true : false)) {
			chkleapyear = true;
		} else {
			chkleapyear = false;
		}
		return chkleapyear;
	}

	public static long daysBetween(Date one, Date two) {
		long difference = (one.getTime() - two.getTime()) / 86400000;
		return Math.abs(difference + 1);
	}

	public String incrementADateByOneday(int daysIncreaseCount) throws ParseException {
		String sourceDate = todaysDate(); // Start date
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(sourceDate)); // parsed date and setting to // calendar
		calendar.add(Calendar.DATE, daysIncreaseCount); // number of days to add
		String destDate = sdf.format(calendar.getTime());
		return destDate;
	}

	public String incrementADateByOneday(int daysIncreaseCount, String givenDate) throws ParseException {
		String sourceDate = givenDate; // Start date
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(sourceDate)); // parsed date and setting to // calendar
		calendar.add(Calendar.DATE, daysIncreaseCount); // number of days to add
		String destDate = sdf.format(calendar.getTime());
		return destDate;
	}

	public static String changedateFormate(String data, String actualformate, String expectedformate)
			throws ParseException {
		DateFormat outputFormat = new SimpleDateFormat(expectedformate, Locale.US);
		DateFormat inputFormat = new SimpleDateFormat(actualformate, Locale.US);
		Date date = inputFormat.parse(data);
		String outputText = outputFormat.format(date);
		return outputText;
	}

	public String todaysDateWithTime() {
		Date todays = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = formatter.format(todays);
		String todaysDate = date;
		return todaysDate;

	}

	public String oldyear(int decreaseCount) {
		DateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, decreaseCount);
		String oldDate = dateFormat.format(cal.getTime());
		return oldDate;
	}

	public String upcomingmonths(int increaseCount) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, increaseCount);
		String nextmonth = dateFormat.format(cal.getTime());
		return nextmonth;
	}

	// ----------------------------------------------------------------------------------

	private int getRandomNumber() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}

	public String generateRandomString(int RANDOM_STRING_LENGTH) {
		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}

	public int RandomNumber(int start, int max) {
		if (max < start) {
			Assert.fail("Given value start value is greater than end value");
		}
		int b = (int) (Math.random() * (max - start + 1) + start);
		return b;
	}

	public void removeattribute(By element) throws Exception {
		((JavascriptExecutor) base.getDriver()).executeScript("arguments[0].removeAttribute('readonly','readonly')",
				base.getDriver().findElement(element));
	}

	public void waitForAlert(int secondsToWait) {
		wait1 = new WebDriverWait(base.getDriver(), Duration.ofSeconds(secondsToWait));
		wait1.until(ExpectedConditions.alertIsPresent());
	}

}
