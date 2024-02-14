package com.kgisl.controls;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.kgisl.base.Hooks;
import com.kgisl.library.LibraryClass;

public class MobileControl {
	
	private Hooks base;
	private LibraryClass library;
	
	
	public MobileControl(Hooks base,LibraryClass library){
		this.base = base;
		this.library=library;
	}
	
	public void EnterValueon(By elementName,String Value) throws Throwable{
		clearText(elementName);
		base.mGetDriver().findElement(elementName).sendKeys(Value);
	}
	
	// clear the value from Text Box
	public void clearText(By elementName) throws Throwable{	
		library.mobileWaitForVisibilityOfElement(elementName);		
		base.mGetDriver().findElement(elementName).clear();
	}

	
	public void ClickOn(By elementName) throws Throwable {
			library.mobileWaitForClickableElement(elementName);
			base.mGetDriver().findElement(elementName).click();
	}
	
	public void waitForTheVisibilityOf(By elementName) throws Throwable {
			library.mobileWaitForVisibilityOfElement(elementName);
		
		}
		
	public void selectTextFromCombobox(By elementName, String optionToBeSelected) throws Throwable {	
		library.mobileWaitForClickableElement(elementName);
		List<WebElement> options = base.mGetDriver().findElements(elementName);		
		 for(WebElement e:options)
	        {
	            String val=e.getText();	            
	           // System.out.println("Value of Combo:*****"+val);	           
	            if(val.equalsIgnoreCase(optionToBeSelected))
	            {
	                e.click();
	                break;
	            }
	        }
	}
	
}
