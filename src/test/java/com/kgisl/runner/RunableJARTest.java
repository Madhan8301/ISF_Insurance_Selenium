package com.kgisl.runner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import com.kgisl.base.DB_Connection;
import com.kgisl.base.Data_Set;
import com.kgisl.base.ExcelUtility;
import com.kgisl.library.ReportUtility;

import io.cucumber.core.cli.Main;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

/*import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;*/

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class RunableJARTest extends AbstractTestNGCucumberTests {
	public static String tags;
	private ReportUtility reportUtility;

	public RunableJARTest(ReportUtility reportUtility) {
		this.reportUtility = reportUtility;
	}

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	public static String tagArg() {
		tags = System.getProperty("tags");
		return tags;
	}

	private static String[] defaultOptions1 = { "--glue", "com.kgisl.stepDefinition", ".", "--plugin", "pretty",
			"--plugin", "rerun:rerun.txt", "--plugin",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:rerun.txt", "--plugin",
			"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "--plugin", "html:target/html", "--plugin",
			"json:target/cucumber/cucumber.json", "--tags", tagArg() };
	private static String[] defaultOptions2 = { "--glue", "com.kgisl.stepDefinition", "@rerun.txt", "--plugin",
			"pretty", "--plugin", "rerun:rerun.txt", "--plugin",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:rerun.txt", "--plugin",
			"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "--plugin", "html:target/html", "--plugin",
			"json:target/cucumber/cucumber.json" };

	public static void main(String[] args) throws Exception {

		Stream<String> cucumberOptions;
		if (!tagArg().contains("rerun")) {
			cucumberOptions = Stream.concat(Stream.of(defaultOptions1), Stream.of(args));
		} else {
			cucumberOptions = Stream.concat(Stream.of(defaultOptions2), Stream.of(args));
		}
		Main.main(cucumberOptions.toArray(String[]::new));
	}
}