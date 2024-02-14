package com.kgisl.PageElements.Web;

import org.openqa.selenium.By;

public class CommonPageElements {

	
	public By GridColumnElements = By.id("");
	public By GridRowElements = By.id("");
	
//	public By UserName = By.xpath("//input[@id='mat-input-2']");
	public By UserName = By.cssSelector("input[formcontrolname='userName']");
	
	public By password = By.cssSelector("input[formcontrolname='password']");
	public By Login_btn = By.xpath("//span[contains(text(),'Login')]");
	
	public By animation = By.xpath("(//app-root//div//ng-http-loader//div)[1]");
	
	
	//public By Next_btn = By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Next')]");
	public By Next_btn = By.xpath("(//span[contains(text(),'Next')])[1]");
	public By Reset_btn = By.xpath("//button[contains(text(),'Reset')]");
	public By Back_btn = By.xpath("//button[contains(text(),'Back')]");
	public By addressNext = By.xpath("//mat-panel-title[contains(text(),'Address Details')]/ancestor::mat-expansion-panel//button//span[contains(text(),'Next')]");
	public By identityNext = By.xpath("(//span[contains(text(),'Next')])[3]");
	public By contactNext = By.xpath("(//span[contains(text(),'Next')])[4]");
	public By preview = By.xpath("(//span[contains(text(),'Preview')])[2]");
	public By proceed = By.xpath("//span[contains(text(),'Proceed')]");
	public By save = By.xpath("(//span[contains(text(),'Save')])[1]");
	
	
	
//	---------------------------------Validation-------------------------------------------
	
	public By ErrorSpot = By.xpath("//mat-error/parent::div/parent::div/parent::div//div//mat-label");
	public By errorMsg = By.xpath("//mat-error");
	
	
	
	
	
}
