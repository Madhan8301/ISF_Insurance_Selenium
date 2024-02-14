package com.kgisl.base;

import org.aeonbits.owner.Config;

@Config.Sources(value="file:${user.dir}/FrameworkConfig.properties")
public interface FrameworkConfig extends Config {
	
	@DefaultValue("Local")
	String RunType();
	
	@DefaultValue("Chrome")
	String Browser();
	String NsureQA();
	String NsureQA_UserName();
	String NsureQA_Password();
	
	
	String Environment();
	
	@DefaultValue("false")
	boolean Headless();
	
	@DefaultValue("false")
	boolean AutoDownloadDriver();
	
	
	String SITAppUrl();
	String ILIVEAgentUrl();
	String ILIVEAdminUrl();
	String ILIVEBancaUrl();


	String UATAppUrl();
	String UAT_UserName();
	String UAT_Password();
	
	String ILIVEHNBUrl();
	String HNB_UserName();
	String HNB_Password();
	
	@DefaultValue("30")
	int SToWait1();
	
	@DefaultValue("30")
	int ImplictWait();
	
	
	String DbURL();
	String DbName();
	String DbUsername();
	String DbPassword();	
	String SchemaNameILive();
	String SchemaNameIUAT();
	String SchemaNameSQA();
	
	
    
	String Platform();
	String DeviceName();
	String PlatformVersion();
	String UDID();
	String AppiumURL();
	String MobileAppPackageName();
	String MobileAppActivityName();
	String DataSheetName();

	String Mode();

	String DBName();

}
