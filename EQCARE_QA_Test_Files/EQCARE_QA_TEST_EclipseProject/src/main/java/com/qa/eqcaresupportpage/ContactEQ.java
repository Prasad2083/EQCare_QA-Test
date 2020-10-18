package com.qa.eqcaresupportpage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.testbaseclass.TestBaseClass;
import com.qa.testutils.TestUtils;

public class ContactEQ extends TestBaseClass {
	
	
	// Storing all the locators at one place
	
	@FindBy(className = "css-793q7w e1oadyx42")
	WebElement chatboxtext;
	
	@FindBy(id="pd-chat-icon-path")
	WebElement chatboximage;
	
	@FindBy(className = "css-1g0znr8 e19uit3413")
	WebElement close;
	
	@FindBy(xpath = "//p[contains(text(),'Company')]")
	
	WebElement companyheader;
	
	@FindBy(linkText = "About Us")
	WebElement aboutlink;
	
	@FindBy(linkText = "Careers")
	WebElement careerlink;
	
	@FindBy(xpath = "//h1[contains(text(),'About Us')]")
	
	WebElement abouttext;
	
	@FindBy(xpath = "//h1[contains(text(),'Join EQ Care')]")
	
	WebElement careertext;
	
	//Error Validations with locators
	
	@FindBy(xpath = "//*[@class=\"tablet:half\"][1]//p[@class=\"form-error\"][1]")
	
	WebElement errorfirstname;
	
	@FindBy(xpath = "//*[@class=\"tablet:half\"][2]//p[@class=\"form-error\"][1]")
	
	WebElement errorlastname;
	
	@FindBy(xpath = "//*[@class=\"tablet:half\"][4]//p[@class=\"form-error\"][1]")
	
	WebElement erroremail;
	
	@FindBy(xpath = "//*[@class=\"tablet:half\"][5]//p[@class=\"form-error\"][1]")
	
	WebElement errorprovince;
	
	@FindBy(xpath = "//*[@class=\"tablet:half\"][6]//p[@class=\"form-error\"][1]")
	
	WebElement errorcity;
	
	@FindBy(xpath = "//*[@class=\"form-error mb-4\"]")
	
	WebElement errordescription;
	
	//Error Validations with locators
	
	//Proper Validations with locators
	
    @FindBy(xpath = "//input[@placeholder='First Name']")
	
	WebElement firstname;
	
    @FindBy(xpath = "//input[@placeholder='Last Name']")
	
	WebElement lasttname;
    
    @FindBy(xpath = "//input[@placeholder='Phone Number']")
	
	WebElement phone;
	
    @FindBy(xpath = "//input[@placeholder='Email address']")
	
	WebElement address;
    
    @FindBy(xpath = "//select/option[2]")
	
	WebElement province;
   
    @FindBy(xpath = "//input[@placeholder='Please enter your city']")
	
	WebElement city;
    
    @FindBy(xpath = "//textarea[@placeholder='Please describe the issue you are having here...']")
    
    WebElement description;
    
    @FindBy (xpath = "//*[contains(text(),'Your message was sent.')]")
    
    WebElement message;
    
    @FindBy(xpath = "//*[contains(text(),'Send us a message')]")
    
    WebElement mainmessage;
    
  //Proper Validations with locators
    
    @FindBy(xpath = "//*[contains(text(),'Contact Support')]")
    
    WebElement validatebtn;
    
    @FindBy(xpath = "//*[@class=\"phone:py-8 tablet:p-8 tablet:p-16 bg-white flex-1\"]")
    
    WebElement pagesection;

	public ContactEQ() throws IOException {
		super();
		
		PageFactory.initElements(driver, this);	 // Initializing the WEBELEMENTS using PageFactory
		
	}


	// Actions of the ContactPage are stored at one place
	
	
	public void Screenshotofcontactpage() throws IOException {
		
		TestUtils.TakeScreenShot();  // ScreenShot Action
		
	}
	
	public String gettitleofthepage() {
		
		System.out.println(driver.getTitle());
		return driver.getTitle();
		
	}
	
	public String validate_about_header_title() throws InterruptedException {
		
		Actions action= new Actions(driver);
		
		action.moveToElement(companyheader).perform();  // Using Action class to mouse hover and select the drop down value
		
		driver.manage().timeouts().implicitlyWait(TestUtils.Implicitl_Wait, TimeUnit.SECONDS);
		
		aboutlink.click();
		
		Thread.sleep(5000);
		
		return driver.getTitle();
		
		
	}
	
	public String validatecareerheadertitle() throws InterruptedException {
		
		Actions careeraction= new Actions(driver);
		
		careeraction.moveToElement(companyheader).perform();
		driver.manage().timeouts().implicitlyWait(TestUtils.Implicitl_Wait_JavaClass, TimeUnit.SECONDS);
	
		careerlink.click();
		
		Thread.sleep(3000);
		
		String CareerPageHeader= careertext.getText();
		
		System.out.println(CareerPageHeader);

		return driver.getTitle();
			
	}
	
	public String[] validateerrormessages() throws IOException {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", validatebtn);
		
		driver.manage().timeouts().implicitlyWait(TestUtils.Implicitl_Wait_JavaClass, TimeUnit.SECONDS);
		
		String firstnameerror= errorfirstname.getText();
		 
		String lastnameerror = errorlastname.getText();
		
		String emailerror = erroremail.getText();
		
		String provinceerror = errorprovince.getText();
		
		String cityerror= errorcity.getText();
		
		String descriptionerror = errordescription.getText();
		
		String phoneerror=" ";
		
		String[] errors= {firstnameerror,lastnameerror,emailerror,provinceerror,cityerror,descriptionerror,phoneerror};
		
		TestUtils.TakeScreenShotofPhoneError();
		
		return errors;
		
	}
	
	public String checkformwithvaliddata() throws InterruptedException {
		  
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  
		  driver.manage().timeouts().implicitlyWait(TestUtils.Implicitl_Wait, TimeUnit.SECONDS);
		  
		  firstname.sendKeys(TestUtils.First_Name);
		  
		  lasttname.sendKeys(TestUtils.Last_Name);
		  
		  phone.sendKeys(TestUtils.Phone_Number);
		  
		  address.sendKeys(TestUtils.Email);
		  
		  province.click();
		  
		  city.sendKeys(TestUtils.City);
		  
		  description.sendKeys(TestUtils.Description);
		  
		  driver.manage().timeouts().implicitlyWait(TestUtils.Implicitl_Wait_JavaClass, TimeUnit.SECONDS);
		  
		  js.executeScript("arguments[0].click();", validatebtn);
		  
		return message.getText();	
		 
	}
	
	
	
	
}
