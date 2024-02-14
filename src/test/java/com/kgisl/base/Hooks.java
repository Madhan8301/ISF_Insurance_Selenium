package com.kgisl.base;

import java.io.File;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;



import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;



 

public class Hooks extends BaseUtilTest {
	
	
	public String platform,deviceName,platformVersion,App,UDID,appiumURL,packageName,activityName;
	public String  browser, environemt, jenkinsuserName, jenkinspassword,mode,model;
	public String ILIVEAgentUrl,ILIVEAdminUrl,ILIVEBancaUrl,ILIVEAuto;
//	public List<DeviceDetails> androidDevices = new Android().getDevices();
	public AppiumDriverLocalService service = null;
	public String service_url,AppUrl;
	
	protected Connection con;
	public Statement st;
	public String schemaName = "";
	
    FrameworkConfig config= ConfigFactory.create(FrameworkConfig.class);
	
	public Hooks() throws Throwable {

	}
	
        
	public int globalWait = config.SToWait1(); 


	public WebDriver getDriver(){			
		if (config.Browser().equalsIgnoreCase("chrome")) {
			return driver;
		} else {
			return driver2;
		}	
	}
	
	

	public void setmDirver(AppiumDriver mDirver) {
		this.mDirver = mDirver;
	}
	
	public AppiumDriver mGetDriver() throws MalformedURLException {
		return mDirver;
    }
	
	public String getUserName() {
		String UserName=null;
		if(environemt.equalsIgnoreCase("ILIVE")) {
			UserName =  config.NsureQA_UserName();
		} else if(environemt.equalsIgnoreCase("UAT")) {
			UserName =  config.UAT_UserName();
		} else if (environemt.equalsIgnoreCase("HNB")) {
			UserName =  config.HNB_UserName();
		}
		return UserName;
	}
	
	public String getPassword() {
		String Password=null;
		if(environemt.equalsIgnoreCase("ILIVE")) {
			Password =  config.NsureQA_Password();
		} else if(environemt.equalsIgnoreCase("UAT")) {
			Password =  config.UAT_Password();
		} else if (environemt.equalsIgnoreCase("HNB")) {
			Password =  config.HNB_Password();
		}
		return Password;
	}
	
	public void launchBrowser() throws Exception {				 
	     if(config.RunType().equalsIgnoreCase("LOCAL")){
			 browser=config.Browser();
			 environemt =config.Environment();		
	     }else{
			// Jenkin Setting		
	    	browser = System.getProperty("browser");
			environemt = System.getProperty("environemt");		
			
				
	     }
	     
	     System.out.println("browser      :" +browser);  
	     System.out.println("Environment  :" +environemt);

	    
	     
			 if(environemt.equalsIgnoreCase("ILIVE")){	
				 
				 ILIVEAuto = config.NsureQA();
				 AppUrl =ILIVEAuto;

				// schemaName =config.SchemaNameILive();
				}
			 
			 else if(environemt.equalsIgnoreCase("UAT"))
				{
				 AppUrl=config.UATAppUrl();
				// schemaName =config.SchemaNameIUAT();
				} 
			 else if(environemt.equalsIgnoreCase("HNB"))
				{
				 AppUrl = config.ILIVEHNBUrl();
				}
			 	
			if (browser.equalsIgnoreCase("Firefox") && getDriver() == null) {
				if(config.AutoDownloadDriver()==true){
					System.out.println(SeleniumManager.getInstance().getDriverPath("geckodriver"));
				}else{
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"/Drivers/geckodriver.exe");	
				}
				
				FirefoxOptions options = new FirefoxOptions();
	            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT_AND_NOTIFY);
	            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	            if(config.Headless()==true) {
	            	options.setHeadless(true);
	            	options.addArguments("window-size=1920,1080");
	            }
				driver2 = new FirefoxDriver(options);
				driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.ImplictWait()));
				getDriver().manage().window().maximize();
				if(environemt.equalsIgnoreCase("ILIVE") || environemt.equalsIgnoreCase("UAT")){
					getDriver().get(AppUrl);
				}

			} else if (browser.equalsIgnoreCase("Chrome") && getDriver() == null) {
				if(config.AutoDownloadDriver()==true){				
					System.out.println(SeleniumManager.getInstance().getDriverPath("chromedriver"));
				}else{
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/Drivers/chromedriver.exe");	
				}
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/Drivers/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();	
				if(config.Headless()==true) {
					System.out.println("Running in Headless Mode");
		            options.setHeadless(true);
		            options.addArguments("--ignore-ssl-errors");
		            options.addArguments("-ignore-certificate-errors");
		            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		            options.addArguments("--no-sandbox");	
		            options.addArguments("--remote-allow-origins=*");
		            options.addArguments("window-size=1920,1080");
		            }
				 options.addArguments("--ignore-ssl-errors");
		         options.addArguments("-ignore-certificate-errors");
		         options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		         options.addArguments("--no-sandbox");
		         options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.ImplictWait()));
				driver.manage().window().maximize();
				driver.get(AppUrl);

			} else if (browser.equalsIgnoreCase("Edge") && getDriver() == null) {
				EdgeOptions edgeOptions = new EdgeOptions();
				if(config.AutoDownloadDriver()==true){
					System.out.println(SeleniumManager.getInstance().getDriverPath("msedgedriver"));
				}else{
					System.setProperty("webdriver.edge.driver", "Drivers//msedgedriver.exe");
				}				
				if(config.Headless()==true) {
					edgeOptions.setHeadless(true);
					edgeOptions.addArguments("window-size=1920,1080");
		            }
				edgeOptions.setAcceptInsecureCerts(true);
				driver2 = new EdgeDriver(edgeOptions);
				driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.ImplictWait()));
				getDriver().manage().window().maximize();
				if(environemt.equalsIgnoreCase("ILIVE") || environemt.equalsIgnoreCase("UAT")){
					getDriver().get(AppUrl);
				}
			
			} 
			try {				

				if (con == null) {
					String DB_URL = config.DbURL();
					String dbname = config.DbName();
					String USER = config.DbUsername();
					String PASS = config.DbPassword();
					String schemaName = config.SchemaNameILive();

					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection(DB_URL + ":" + dbname, USER, PASS);
					st = con.createStatement();
				}
			} catch (SQLException e) {
				System.out.print(e);
			}
	}
	
	
	
	@SuppressWarnings("deprecation")
	public void LaunchMobileApp() throws Exception {
		 AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder() 
	                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
	                .withAppiumJS(new File("C:\\Users\\rajaselvan.d\\AppData\\Local\\Programs\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
	               .withIPAddress("127.0.0.1")
	                .usingAnyFreePort()
	                //.usingPort(4725)
	               . withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/")
	               .withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\log.txt"))
	               ;
	        
		 service = AppiumDriverLocalService  
	        		.buildService(appiumServiceBuilder);
	        		service.start();
	        		
	        		Thread.sleep(25000);
	        		
	        		 service_url = service.getUrl().toString();
		     	        System.out.println("Service URL: "+service_url);
	        		
		
		
        platform = config.Platform();
		deviceName=config.DeviceName();
		platformVersion = config.PlatformVersion();
		appiumURL = config.AppiumURL();
		UDID = config.UDID();
		packageName = config.MobileAppPackageName();
		activityName = config.MobileAppActivityName();
		
		
	  System.out.println("=============================================================");	
	  System.out.println("PlatForm Name    :"+platform);
	  System.out.println("Device Name      :"+deviceName);
	  System.out.println("PlatForm Version :"+platformVersion);
	  if(platform.equalsIgnoreCase("IOS")) {
	  System.out.println("UDID             :"+UDID);
	  }
	  System.out.println("============================================================");	
		
		
	
		if(platform.equalsIgnoreCase("IOS")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			cap.setCapability(MobileCapabilityType.UDID, UDID);
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "300000");			
			cap.setCapability("bundleId", "com.kgisl.Nsure");
			cap.setCapability("UpdatedWDAbundleId", "com.kgisl.WebDriverAgentLib");
			cap.setCapability("derivedDataPath", "/Users/kgisl/Library/Developer/Xcode/DerivedData/WebDriverAgent-alwvnomvwrdtzoaxbbkniqrpcdpp");
			

			
			URL url =new URL(appiumURL);
			mDirver = new AppiumDriver(url,cap);
			
			
			//driver =new IOSDriver<IOSElement>(url, cap);
			System.out.println("iOS App Launched suceessfully....");
	
		}else if (platform.equalsIgnoreCase("Android")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,packageName);
			cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,activityName);	
			
			URL url= new URL(service_url);		        	
	        		Thread.sleep(10000); 	        			        
			mDirver = new AppiumDriver(url,cap);
			//Thread.sleep(10000);
			Thread.sleep(5000);
			System.out.println("Android App Launched Suceessfully....");
			
			//mDirver.manage().timeouts().implicitlyWait(globalWait, TimeUnit.SECONDS);
			
			
		}	
	}
	
	
	public void LaunchMobileApp(String currentDeviceName,String currentPlatformVersion) throws Exception {
		//AppiumSever Appiumsever=new AppiumSever();
		/*AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();*/
		
		/*platform ="Android";
		deviceName="Android2";
		platformVersion="8.0";*/
		
		
		if (service==null) {
		
		 AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder() 
	                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
	                .withAppiumJS(new File("C:\\Users\\rajaselvan.d\\AppData\\Local\\Programs\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
	               .withIPAddress("127.0.0.1")
	                .usingAnyFreePort()
	                //.usingPort(4725)
	               . withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/")
	              // .withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\log.txt"))
	               ;
	        
		 service = AppiumDriverLocalService  
	        		.buildService(appiumServiceBuilder);
	        		service.start();
	        		
	        		Thread.sleep(25000);
	        		
	        		 service_url = service.getUrl().toString();
		     	        System.out.println("Service URL: "+service_url);
	        		
		}
		

		     	     /*  platform = platformName.toString();
		     			deviceName=currentDeviceName;
		     			platformVersion = currentPlatformVersion;
		appiumURL = getConfigData("appiumURL");
		UDID = getConfigData("UDID");
		packageName = getConfigData("MobileAppPackageName");
		activityName = getConfigData("MobileAppActivityName");*/
		
		
	  System.out.println("=============================================================");	
	  System.out.println("PlatForm Name    :"+platform);
	  System.out.println("Device Name      :"+config.DeviceName());
	  System.out.println("PlatForm Version :"+platformVersion);
	  if(platform.equalsIgnoreCase("IOS")) {
	  System.out.println("UDID             :"+UDID);
	  }
	  System.out.println("============================================================");	
		
		
	
		if(platform.equalsIgnoreCase("IOS")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, config.DeviceName());
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, config.Platform());
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.PlatformVersion());
			cap.setCapability(MobileCapabilityType.UDID, config.UDID());
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "300000");		
			cap.setCapability("bundleId", "com.kgisl.Nsure");
			cap.setCapability("UpdatedWDAbundleId", "com.kgisl.WebDriverAgentLib");
			cap.setCapability("derivedDataPath", "/Users/kgisl/Library/Developer/Xcode/DerivedData/WebDriverAgent-alwvnomvwrdtzoaxbbkniqrpcdpp");
			

			
			URL url =new URL(appiumURL);
			mDirver = new AppiumDriver(url,cap);
			
			
			//driver =new IOSDriver<IOSElement>(url, cap);
			System.out.println("iOS App Launched suceessfully....");
	
		}else if (platform.equalsIgnoreCase("Android")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);		
			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,packageName);
			cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,activityName);	
			
			URL url= new URL(service_url);
			
			//startAppiumService();

	        		
	        		Thread.sleep(10000); 
	        			        		
			mDirver = new AppiumDriver(url,cap);
			Thread.sleep(5000);
			System.out.println("Android App Launched Suceessfully....");
			
			
			
		}	
		
		
	}
	
	
	public void startAppiumService(String portNumber) {
		AppiumDriverLocalService service;
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(Integer.parseInt(portNumber));
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
		System.out.println("Appium service has been started with port number: "+portNumber);
	}
	
	
	public Integer aRandomOpenPortOnAllLocalInterfaces() {
        try (
                ServerSocket socket = new ServerSocket(0);
        ) {
            return socket.getLocalPort();

        } catch (IOException e) {
            throw new RuntimeException("no open ports found for bootstrap");
        }
}
	
	 public AppiumDriverLocalService startAppiumService() throws InterruptedException {
		 AppiumDriverLocalService appiumService;
	        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder() 
	                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
	                .withAppiumJS(new File("C:\\Users\\rajaselvan.d\\AppData\\Local\\Programs\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
	                .withIPAddress("127.0.0.1")
	              //  .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
	                .usingAnyFreePort();
	       /* if (isAndroid) {*/
	            appiumServiceBuilder
	             .withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, 
	                           String.valueOf(aRandomOpenPortOnAllLocalInterfaces()));
	      /*  } else {
	            appiumServiceBuilder
	             .withArgument(WDAServerFlag.WDA_PORT, 
	                           String.valueOf(aRandomOpenPortOnAllLocalInterfaces()));
	        }*/
	        appiumService = AppiumDriverLocalService
	                            .buildService(appiumServiceBuilder);
	        appiumService.start();
	        
	        Thread.sleep(25000);
	        
	        String service_url = appiumService.getUrl().toString();
	        System.out.println("Service URL: "+service_url);
	  
	   return appiumService;
	}
	 
	 
	 
	
	
}
