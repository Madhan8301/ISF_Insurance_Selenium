package com.kgisl.controls;

import static org.testng.Assert.assertTrue;

import java.awt.Window;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.kgisl.PageElements.Web.CommonPageElements;

import com.kgisl.base.BaseUtilTest;
import com.kgisl.base.Hooks;
import com.kgisl.library.LibraryClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WebControl extends BaseUtilTest {
	private Hooks base;
	private LibraryClass library;
	private CommonPageElements commonPage;
	private Actions action;
	private WebElement WebEle;
	private Select select;
	private Alert alert;
	private JavascriptExecutor js;
	

	public WebControl(Hooks base, LibraryClass library, CommonPageElements commonPage) {
		this.base = base;
		this.library = library;
		this.commonPage = commonPage;
		
	}

	// Enter Text methods
	public void EnterValueon(By element, String Value)  {
		//clearText(element);
		base.getDriver().findElement(element).sendKeys(Value);
	}

	public void EnterValueon(WebElement element, String Value) {
		//clearText(element);
		element.sendKeys(Value);
	}

	// clear the value from Text Box
	public void clearText(By Element)  {
		library.waitForVisibilityOfElement(Element);
		base.getDriver().findElement(Element).clear();
	}

	public void clearText(WebElement Element)  {
		library.waitForVisibilityOfElement(Element);
		Element.clear();
	}

	public void SelectDateofBirth(By element,String DOB) throws Throwable {
		 String actualDate = DOB.split("/")[0];
		 String actualMonth = DOB.split("/")[1];
		 String actualYear = DOB.split("/")[2];
		 clickJSEon(element);
		 
		 By previous = By.xpath("(//mat-calendar//mat-calendar-header//button)[2]");
		 By yearSelect = By.xpath("(//mat-calendar//mat-calendar-header//button)[1]");
		 By listOfYears = By.xpath("//mat-calendar-header/following-sibling::div//table//tbody//td");
		 
		 Thread.sleep(500);
		 clickJSEon(yearSelect);
		 
		 for(int i=0;i<Integer.MAX_VALUE;i++) {
			int count =0;
			List<WebElement> yearList = null;
		 	yearList = GetAllElements(listOfYears);
		 	for(int j=0;j<yearList.size();j++) {
		 		String value1 = GetTexton(yearList.get(j)).trim();
		 		if(value1.equalsIgnoreCase(actualYear)) {
//		 			WebElement clicknew= yearList.get(j);
//		 			clickJSEon(clicknew);
		 			String button = "(//mat-calendar-header/following-sibling::div//table//tbody//td)["+(j+1)+"]//button";
		 			clickJSEon(By.xpath(button));
		 			Thread.sleep(1000);
		 			int IntMonth = Integer.parseInt(actualMonth);
		 			By ListofMonths = By.xpath("//mat-calendar-header/following-sibling::div//table//tbody//tr/following-sibling::tr//td");
		 			List<WebElement> MonthList = GetAllElements(ListofMonths);
		 			for(int k=1;k<=MonthList.size();k++) {
		 				if(k==IntMonth) {
		 					String clickMonth = "(//mat-calendar-header/following-sibling::div//table//tbody//tr/following-sibling::tr//td)["+k+"]//button";
		 					clickJSEon(By.xpath(clickMonth));
		 					break;
		 				}
		 			}
		 			Thread.sleep(1000);
		 			By ListofDates = By.xpath("//mat-calendar-header/following-sibling::div//table//tbody//td//button");
		 			List<WebElement> DateList = GetAllElements(ListofDates);
		 			for(int x=0;x<DateList.size();x++) {
		 				int value2 = Integer.parseInt(GetTexton(DateList.get(x+1)).trim());
		 				int value3 = Integer.parseInt(actualDate);
		 				if(value2==value3) {
		 					String clickDate = "(//mat-calendar-header/following-sibling::div//table//tbody//td//button)["+(x+2)+"]";
		 					clickJSEon(By.xpath(clickDate));
		 					break;
		 				}
		 			}
		 			
		 			count =0;
		 			break;
		 		} else {
		 			count++;
		 		}
		 	}
		 	if(count>0) {
		 		clickJSEon(previous);
		 		continue;
		 	} else {
		 		break;
		 	}
		 } 
	 }
	
	
	// Click keys Events methods
	public void EnterKeyon(By element, Keys keyValue) throws Exception {
		base.getDriver().findElement(element).sendKeys(keyValue);
	}

	public void EnterKeyon(WebElement element, Keys keyValue) throws Throwable {
		element.sendKeys(keyValue);
	}

	// Get Text from Elements
	public String GetTexton(By Element) throws Exception {
		String Txtval = base.getDriver().findElement(Element).getText().trim();
		return Txtval;
	}

	public String GetTexton(WebElement element) {
		library.waitForVisibilityOfElement(element);
		String Txtval = element.getText();
		return Txtval;
	}
	
	public void MovejsClick(By element) throws Throwable {
		library.elementstable(element);
		library.waitForClickableElement(element, 30);
		ActionMoveToElement(element);
		WebElement ele = base.getDriver().findElement(element);
		JavascriptExecutor executor = (JavascriptExecutor) base.getDriver();
		executor.executeScript("arguments[0].scrollIntoView(true);", ele);    
		ele.click();
	}
	
	public void MovejsClick(WebElement element) throws Throwable {
//		library.waitForPresenceOfElement(null, 0);
		library.waitForClickableElement(element);
		ActionMoveToElement(element);
//		WebElement ele = base.getDriver().findElement(element);
		JavascriptExecutor executor = (JavascriptExecutor) base.getDriver();
		executor.executeScript("arguments[0].scrollIntoView(true);", element);    
		element.click();
	}
	
	
	public List<WebElement>  GetAllElements(By element) throws Throwable {
//		library.waitForVisibilityOfElement(element);
		//Thread.sleep(2000);
//		List<WebElement> allele = base.getDriver().findElements(element);
		return base.getDriver().findElements(element);
	}


	public WebElement GetWebElement(By Element) throws Throwable {
		library.waitForVisibilityOfElement(Element);
		WebEle = base.getDriver().findElement(Element);
		return WebEle;
	}
	
	public WebElement GetElments(By Element, int Indx) throws Throwable {
		library.waitForVisibilityOfElement(Element);
		//Thread.sleep(2000);
		WebEle = base.getDriver().findElements(Element).get(Indx);
		return WebEle;
	}
	
	public void zoomIn(String size) {
        JavascriptExecutor js = (JavascriptExecutor) base.getDriver();
        js.executeScript("document.body.style.zoom='"+size+"'");
    }

	public void zoomOut(String size) {
        JavascriptExecutor js = (JavascriptExecutor) base.getDriver();
        js.executeScript("document.body.style.zoom='"+size+"'");
    }

	// Get the Attribute Value from Elements
	public String GetAttributeValueon(By Element, String Attribute) {
		String AtrVal = null;
		try {
			AtrVal = base.getDriver().findElement(Element).getAttribute(Attribute);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AtrVal;
	}

	public void DropdownSelectByText(By element, String text) throws Throwable {
		try {
			library.waitForVisibilityOfElement(element);
			select = new Select(base.getDriver().findElement(element));
			select.selectByVisibleText(text);
		} catch (Exception ex) {
			System.err.println("Error :" + ex);
		}
	}


	public void DropdownSelectByIndx(By element, int text) throws Throwable {
		select = new Select(base.getDriver().findElement(element));
		select.selectByIndex(text);
	}

	public void DropdownSelectByvalue(By element, String text) {
		try {
			select = new Select(base.getDriver().findElement(element));
			select.selectByValue(text);
		} catch (Exception ex) {
			System.err.println("Error :" + ex);
		}
	}

	// Click Elements
	public void Clickon(By element) {
		try {
			base.getDriver().findElement(element).click();
		} catch (Exception e) {
			System.out.println("Exception Message: " + e.getMessage());
		}
	}
	
	public void click_and_Select(By clickElement,By SelectElement) throws Throwable {

//		base.getDriver().findElement(clickElement).click();
//		MovejsClick(clickElement);
		clickJSEon(clickElement);
		Thread.sleep(500);
//		action = new Actions(base.getDriver());
//		library.waitForVisibilityOfElement(SelectElement);
//		WebEle = base.getDriver().findElement(SelectElement);
//		action.moveToElement(WebEle).click().build().perform();
		clickJSEon(SelectElement);
	}
	
	public void Click_and_ClearTextOn(By element) {
		try {
			base.getDriver().findElement(element).click();
			Thread.sleep(500);
			base.getDriver().findElement(element).clear();
		} catch (Exception e) {
			System.out.println("Exception Message: " + e.getMessage());
		}
	}

	public void Clickon(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("Exception Message: " + e.getMessage());
		}
	}

	// Click Elements using JavascriptExecutor
	public void clickJSEon(By element) throws Exception {
		js = (JavascriptExecutor) base.getDriver();
		js.executeScript("arguments[0].click();", base.getDriver().findElement(element));
	}
	
	public void clickJSEon(WebElement element) throws Exception {
		js = (JavascriptExecutor) base.getDriver();
		js.executeScript("arguments[0].click();", element);
	}

	// Scroll down the page
	public void scrollDown() throws Exception {
		js = (JavascriptExecutor) base.getDriver();
		js.executeScript("window.scrollBy(0,250)", "");
	}

	public void scrollDownLong() throws Exception {
		js = (JavascriptExecutor) base.getDriver();
		js.executeScript("window.scrollBy(0,5000000)", "");
	}

	// Scroll up the page
	public void scrollUpMin() throws Exception {
		js = (JavascriptExecutor) base.getDriver();
		js.executeScript("window.scrollBy(0,-250)", "");
	}
	
	public void scrollUpLittle() throws Exception {
		js = (JavascriptExecutor) base.getDriver();
		js.executeScript("window.scrollBy(0,-350)", "");
	}

	// Move the control to particular Elements
	public void MoveToElement(By Element) throws Throwable {
		action = new Actions(base.getDriver());
		library.waitForClickableElement(Element);
		WebEle = base.getDriver().findElement(Element);
		action.moveToElement(WebEle).build().perform();
	}

	public void MoveToElement(WebElement element) throws Throwable {
		action = new Actions(base.getDriver());
		library.waitForClickableElement(element);
		action.moveToElement(element).build().perform();
	}

	// To verify the visibility of Element status
	public boolean DisplayStatus(By Element) {
		boolean Stat = false;
		try {
			Stat = base.getDriver().findElement(Element).isDisplayed();
		} catch (Exception ex) {
			System.out.println("Given Element is not displayed : " + Element);
		}
		return Stat;
	}

	public boolean DisplayStatus(WebElement element) {
		boolean Stat = false;
		try {
			Stat = element.isDisplayed();
		} catch (Exception ex) {
			System.err.println("Given Element is not displayed : " + element);
		}
		return Stat;
	}
	
	public void doubleClickon(By Element) throws Throwable {
		action = new Actions(base.getDriver());
		//library.waitForVisibilityOfElement(Element);
		//action.moveToElement().build().perform();
		WebEle = base.getDriver().findElement(Element);
		library.waitForClickableElement(Element);
		action.moveToElement(WebEle).doubleClick().build().perform();
	}
	
	public void doubleClickon(WebElement Element) throws Throwable {
		action = new Actions(base.getDriver());
		//library.waitForVisibilityOfElement(Element);
		library.waitForVisibilityOfElement(Element);
		//action.moveToElement().build().perform();
		//WebElement target = base.getDriver().findElement(Element);
		action.moveToElement(Element).doubleClick().build().perform();
	}

	public void ActionMoveToElement(By Element) throws Throwable {
		action = new Actions(base.getDriver());
		library.waitForVisibilityOfElement(Element);
		WebEle = base.getDriver().findElement(Element);
		action.moveToElement(WebEle).build().perform();
		Thread.sleep(500);
	}
	
	public void ActionMoveToElement(WebElement Element) throws Throwable {
		action = new Actions(base.getDriver());
		library.waitForVisibilityOfElement(Element);
		action.moveToElement(Element).build().perform();
		Thread.sleep(500);
	}
	

	public void ActionMoveToElementClcik(By Element) throws Throwable {
		action = new Actions(base.getDriver());
//		library.waitForVisibilityOfElement(Element);
		WebEle = base.getDriver().findElement(Element);
		action.moveToElement(WebEle).click().build().perform();
	}
	
	public int VisibleElementCount(By Element) throws Throwable {
		return base.getDriver().findElements(Element).size();
	}
	
	public void ActionMoveToElementClcik(WebElement Element) throws Throwable {
		action = new Actions(base.getDriver());
		library.waitForVisibilityOfElement(Element);;
		action.moveToElement(Element).click().build().perform();
	}

	public void SelectFirstCheckboxinGrid(By GrdElement, int st) throws Throwable {
		library.waitForVisibilityOfElement(GrdElement);
		List<WebElement> GridRow = base.getDriver().findElement(GrdElement).findElements(By.tagName("tr"));
		List<WebElement> GridColum = GridRow.get(1).findElements(By.tagName("td"));
		WebElement Chkbox = GridColum.get(st).findElement(By.tagName("input"));
		Clickon(Chkbox);

	}

	public String GetValueXpathLabel(String XpathTxt) {
		String ValTxt = base.getDriver()
				.findElement(By.xpath("//div[contains(text(),'" + XpathTxt + "')]/following-sibling:: div")).getText();
		return ValTxt;
	}

	// Splits comman seperated text to list
	public ArrayList<Object> ConvertstringTolist(String text) {
		ArrayList<Object> list = new ArrayList<>();
		list = Lists.newArrayList(Splitter.on(",").split(text));
		return list;
	}
	
	public void AcceptAlert() throws Exception {
		String Content = "";
		 WebDriverWait wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(base.globalWait));
		  wait.until(ExpectedConditions.alertIsPresent());
		alert = base.getDriver().switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
	}
	
	public void CancelAlert() throws Exception {
		String Content = "";
		alert = base.getDriver().switchTo().alert();
		Thread.sleep(3000);
		alert.dismiss();
	}

	public void VerfiyAlertMsgTextAccept(String alertMessage) throws Exception {
		String Content = "";
		alert = base.getDriver().switchTo().alert();
		Content = alert.getText();
		Content = Content.replaceAll("(\\r|\\n)", "");
		System.out.println(Content);
		assertTrue(Content.contains(alertMessage));
		Thread.sleep(3000);
		alert.accept();
	}
	// Grid Activity

	public void gridDoubleClick(WebElement rownumber) {
		action = new Actions(base.getDriver());
		library.waitForClickableElement(rownumber);
		action.moveToElement(rownumber).click();
		action.doubleClick(rownumber).build().perform();
		try {
			action.moveToElement(rownumber).click();
			rownumber.click();
			rownumber.click();
		} catch (Exception e) {

		}
	}

	public void verifyValueingrid(int mintblcolum, WebElement gridID, HashMap<Integer, String> givenTableValue) {
		boolean matchFound = false;
		String givenValueInGrid = null;
		// waitForInVisibilityOfElement(GirdloadingImg);
		WebElement table = gridID;
		List<WebElement> tblRows = table.findElements(By.tagName("tr"));
		int tblRowscount = tblRows.size();
		for (int row = 0; row < tblRowscount; row++) {
			List<WebElement> actualTblData = tblRows.get(row).findElements(By.tagName("td"));
			int tblDataCount = actualTblData.size();

			if (tblDataCount <= mintblcolum) {
				continue;
			}
			matchFound = true;
			Set<Integer> keys = givenTableValue.keySet();
			for (Integer key : keys) {
				givenValueInGrid = givenTableValue.get(key);

				// System.out.println("Given of " + key + " is: " +
				// givenValueInGrid);

				if (actualTblData.get(key) != null
						&& !givenTableValue.get(key).equals(actualTblData.get(key).getText())) {
					matchFound = false;
					break;
				}
			} // For Key Loop End

			if (matchFound == true) {
				Assert.assertTrue("The records have shown properly", matchFound);
				break;
			}

		} // Main For End
		if (matchFound == false) {
			givenTableValue.clear();
			Assert.fail("The records not shown properly");
			table.click();
		}
		givenTableValue.clear();

	}


	public void GridSelectRowAndClick(int mintblcolum, WebElement gridID, HashMap<Integer, String> givenTableValue) {
		boolean matchFound = false;
		String givenValueInGrid = null;
		// waitForInVisibilityOfElement(GirdloadingImg);
		WebElement table = gridID;
		List<WebElement> tblRows = table.findElements(commonPage.GridRowElements);
		int tblRowscount = tblRows.size();
		for (int row = 0; row < tblRowscount; row++) {
			List<WebElement> actualTblData = tblRows.get(row).findElements(commonPage.GridColumnElements);
			int tblDataCount = actualTblData.size();

			if (tblDataCount <= mintblcolum) {
				continue;
			}
			matchFound = true;
			Set<Integer> keys = givenTableValue.keySet();
			for (Integer key : keys) {
				givenValueInGrid = givenTableValue.get(key);
				if (actualTblData.get(key) != null
						&& !givenTableValue.get(key).equals(actualTblData.get(key).getText())) {
					matchFound = false;
					break;
				}
			} // For Key Loop End
			if (matchFound == true) {
				Assert.assertTrue("The records have shown properly", matchFound);
				tblRows.get(row).click();
				break;
			}
		} // Main For End
		if (matchFound == false) {
			givenTableValue.clear();
			Assert.fail("The records not shown properly");
			table.click();
		}
		givenTableValue.clear();

	}

	public void GridSelectRowAndDoubleClick(int mintblcolum, WebElement gridID,
			HashMap<Integer, String> givenTableValue) throws Throwable {
		boolean matchFound = false;
		String givenValueInGrid = null;
		// waitForInVisibilityOfElement(GirdloadingImg);
		WebElement table = gridID;
		List<WebElement> tblRows = table.findElements(commonPage.GridRowElements);
		int tblRowscount = tblRows.size();
		for (int row = 0; row < tblRowscount; row++) {
			List<WebElement> actualTblData = tblRows.get(row).findElements(commonPage.GridColumnElements);
			int tblDataCount = actualTblData.size();

			if (tblDataCount <= mintblcolum) {
				continue;
			}
			matchFound = true;
			Set<Integer> keys = givenTableValue.keySet();
			for (Integer key : keys) {
				givenValueInGrid = givenTableValue.get(key);
				if (actualTblData.get(key) != null
						&& !givenTableValue.get(key).equals(actualTblData.get(key).getText())) {
					matchFound = false;
					break;
				}
			} // For Key Loop End
			if (matchFound == true) {
				Assert.assertTrue("The records have shown properly", matchFound);
				WebElement rownumber = tblRows.get(row);
				action = new Actions(base.getDriver());
				library.waitForClickableElement(rownumber);
				action.moveToElement(rownumber).click();
				action.doubleClick(rownumber).build().perform();
				break;
			}
		} // Main For End
		if (matchFound == false) {
			givenTableValue.clear();
			Assert.fail("The records not shown properly");
			table.click();
		}
		givenTableValue.clear();

	}

	public void checkPageIsReady() {
		js = (JavascriptExecutor) base.getDriver();
		// Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			return;
		}
		// This loop will rotate for 25 times to check If page Is ready after every 1
		// second.
		// You can replace your value with 25 If you wants to Increase or
		// decrease wait time.
		for (int i = 0; i < 15; i++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

	public void acceptPopUp(By popUpOk_Button) throws Throwable {
		try {
			library.waitForClickableElement(popUpOk_Button);
			base.getDriver().findElement(popUpOk_Button).click();
		} catch (Exception e) {
			((JavascriptExecutor) base.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					base.getDriver().findElement(popUpOk_Button));
		}
	}

	public void handleMultipleWindows(WebDriver driver, String currentURL) {
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains(currentURL)) {
				return;
			}
		}
	}
	
	public void ScrollToElement(By element) {
		action = new Actions(base.getDriver());
		WebEle = base.getDriver().findElement(element);
		action.scrollToElement(WebEle).build().perform();
	}
	public void ScrollToElement(WebElement element) {
		action = new Actions(base.getDriver());
		action.scrollToElement(element).build().perform();
	}
	
	public void scrollToView(By element) throws Exception{
		//Find element by link text and store in variable "Element"
		boolean stat=base.getDriver().findElements(element).size()>0; 
		if(stat==true){
			WebElement Element = base.getDriver().findElement(element);
			js = (JavascriptExecutor) base.getDriver();
			//This will scroll the page till the element is found
			js.executeScript("arguments[0].scrollIntoView(true);", Element);
		}
	}
	
	public void scrollDownMin() throws Throwable {
		js = (JavascriptExecutor) base.getDriver();
	       js.executeScript("window.scrollBy(0,350)", "");
	       Thread.sleep(500);
	}
	
	public void scrollDownLittle() throws Throwable {
		js = (JavascriptExecutor) base.getDriver();
	       js.executeScript("window.scrollBy(0,150)", "");
	       Thread.sleep(500);
	}
	public void scrollUPLong() throws Throwable {
		
		js = (JavascriptExecutor) base.getDriver();
	    js.executeScript("window.scrollBy(0,-3500)", "");
	    Thread.sleep(500);
		
	}
	
	public void scrollToView(WebElement Element) throws Exception{
		//Find element by link text and store in variable "Element"
		
			js = (JavascriptExecutor) base.getDriver();
			//This will scroll the page till the element is found
			js.executeScript("arguments[0].scrollIntoView(true);", Element);
			Thread.sleep(500);
			
			
		
	}
	
//	public void validate_the_message(WebElement element,Msg) throws Throwable {
//		Thread.sleep(2000);
//	   String Invalid_ICnum= element.getText();
//	   System.out.println("Error Msg is"+Invalid_ICnum);
//	   
//
//	}
/*	@Given("Switch to required Window")
	public void switchToNewWindow() throws Throwable {
		String currentWindow = base.getDriver().getWindowHandle();
		Iterator<String> windows = base.getDriver().getWindowHandles().iterator();
		while (windows.hasNext()) {
			String window = windows.next();
			if (!currentWindow.equalsIgnoreCase(window)) {
				
				base.getDriver().switchTo().window(window);
				base.getDriver().manage().window().maximize();
				break;
			}
		}
	}
	
	*/
	public void sendkeysByAction(By Element,String value) throws Exception {
		 action = new Actions(base.getDriver());
		    action.moveToElement(base.getDriver().findElement(Element)).click()
		    .sendKeys(value).build().perform();
//		    base.getDriver().findElement(Element).sendKeys(Keys.ENTER);
		}
	
	public void SendKeysNew(By Element,String value) {
		
		for (char c : value.toCharArray()) {
			base.getDriver().findElement(Element).sendKeys(Character.toString(c));
            // Adjust the sleep time as needed
            try {
                Thread.sleep(100); // Adjust the delay as per your requirement (100 milliseconds in this example)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		
	}
	
	
	public void sendkeysByAction(WebElement Element,String value) throws Exception {
		 action = new Actions(base.getDriver());
		    action.moveToElement(Element).click()
		    .sendKeys(value).build().perform();
//		    base.getDriver().findElement(Element).sendKeys(Keys.ENTER);
		}
	public Boolean checkBoxSelected(By Element) throws Throwable {
		
		Boolean chckbox = base.getDriver().findElement(Element).isSelected();
		return chckbox;
		
	}

	
	
   
}
