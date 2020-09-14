package com.yara.pageObjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CropPageObject {
	   private AndroidDriver<MobileElement> driver;
	   //Constructor(default)
	    public CropPageObject() {
	    }
	    //Constructor(parameterized)
	    public CropPageObject(AndroidDriver<MobileElement> driver) {
	        this.driver = driver;
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
	    /*-----log-------*/
	    private static Logger log=LogManager.getLogger(CropPageObject.class.getName());
	    /*-----Locators-------*/
	    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"btnText_Select_select_language_en\"]")
	    private MobileElement buttonLanguage_Eng;
	    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"btnText_Select_select_language_hi\"]")
	    private MobileElement buttonLanguage_Hin;
	    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"btnText_Select_select_language_ta\"]")
	    private MobileElement buttonLanguage_Tam;
	    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"btnText_welcome_screen_continue\"]")
	    private MobileElement buttonAgree;
	    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"btnText_add_crop\"]")
	    private MobileElement buttonAddCrop;
	  
	    @AndroidFindBy(xpath ="//android.view.ViewGroup[@content-desc=\"textInput_txtFarmName\"]/android.view.ViewGroup[2]\r\n" + 
	    		"")
	    private MobileElement txtbxFarmName;
	    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"roundedButtonText_nbNavBar\"]")
	    private MobileElement buttonSaveDetails;
	  


	    //above  language buttons can be parameterized by changing the language as dynamic
	    
	    /***-------Page methods----------***/
	    /**
	     * this method will click on Language
	     */
	    public void clickOnLanguage()
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(buttonLanguage_Eng));
			buttonLanguage_Eng.click();
			log.info("Clicked on Language button");
	    }
	    /**
	     * this method will click on Agree and continue
	     */
	    public void clickOnAgree()
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(buttonAgree));
			buttonAgree.click();
			log.info("Clicked on Agree and Continue");
	    }
	    /**
	     * this method will click on AddCrops
	     */
	    public void clickOnAddCrops()
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(buttonAddCrop));
			buttonAddCrop.click();
			log.info("Clicked on buttonAddCrop");
	    }
	    /**
	     * this method will enter Farm name
	     */
	    public void enterFarmName(String farmName)
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(txtbxFarmName));
			txtbxFarmName.click();
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_T);
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_E);
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_S);
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_T);
			log.info("Farmname "+farmName+"  Entered");
	    }
	    /**
	     * this method will click on Save
	     */
	    public void clickOnSave()
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(buttonSaveDetails));
			buttonSaveDetails.click();
			log.info("Clicked on buttonSaveDetails");
	    }
	    
}
