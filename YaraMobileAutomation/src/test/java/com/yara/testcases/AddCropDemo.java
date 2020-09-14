package com.yara.testcases;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.yara.pageObjects.CropPageObject;

import com.yara.utils.Utilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import com.yara.utils.*;

public class AddCropDemo {
	AndroidDriver<MobileElement> driver;
	private static Logger log=LogManager.getLogger(AddCropDemo.class.getName());
	@BeforeTest
	
	//Using apk file from Project
	/*public void launchApp() throws IOException
	{
		log.info(this.getClass());
		File f=new File("app-qa-universal-release.apk");
		DesiredCapabilities capability = new DesiredCapabilities();
		//OS Name
		String device=Utilities.getProperty("device");
		capability.setCapability(Constants.CAPS_DEVICE,device);
		//Mobile OS version.
		String version=Utilities.getProperty("version");
		capability.setCapability(MobileCapabilityType.VERSION, version);
		//set up device name
		String deviceName=Utilities.getProperty("deviceName");
		capability.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
		capability.setCapability(MobileCapabilityType.APP,f.getAbsolutePath());
		String url=Utilities.getProperty("URL");
		driver = new AndroidDriver<MobileElement>(new URL(url), capability);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}*/
	//using pre-installed app
	public void launchApp() throws IOException
	{
		log.info(this.getClass());
		DesiredCapabilities capability = new DesiredCapabilities();
		//OS Name
		String device=Utilities.getProperty("device");
		capability.setCapability(Constants.CAPS_DEVICE,device);
		//Mobile OS version.
		String version=Utilities.getProperty("version");
		capability.setCapability(MobileCapabilityType.VERSION, version);
		//set up device name
		String deviceName=Utilities.getProperty("deviceName");
		capability.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
		String platformName=Utilities.getProperty("platformName");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
		//set the package name of the app
		String appPackage=Utilities.getProperty("appPackage");
		capability.setCapability(Constants.CAPS_APP_PACKAGE, appPackage);
		//set the Launcher activity name of the app
		String appActivity=Utilities.getProperty("appActivity");
		capability.setCapability(Constants.CAPS_APP_ACTIVITY, appActivity);
		String url=Utilities.getProperty("URL");
		driver = new AndroidDriver<MobileElement>(new URL(url), capability);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void addCorpOperation() throws InterruptedException, IOException
	{
		CropPageObject cropPage=new CropPageObject(driver);
		log.info("Inside addCorpOperation");
		Utilities.staticWait(10000);
		cropPage.clickOnLanguage();
		cropPage.clickOnAgree();
		cropPage.clickOnAddCrops();
		/*List<String> list=Utilities.getData("tesData.xlsx", "yara", "TC_01");
		String farmName=list.get(1);*/
		cropPage.enterFarmName("Test");
		cropPage.clickOnSave();
		
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.closeApp();
		driver.quit();
	}

}
