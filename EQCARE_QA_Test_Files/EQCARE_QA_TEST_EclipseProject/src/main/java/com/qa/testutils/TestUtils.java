package com.qa.testutils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.qa.testbaseclass.TestBaseClass;

public class TestUtils extends TestBaseClass{
	
	
	public TestUtils() throws IOException {
		super();
		
	}



	public static long PAGE_LOAD_TIME=20;
	
	public static long Implicitl_Wait=30;
	
	public static long Implicitl_Wait_JavaClass=10;
	
	public static String First_Name = "VaraPrasad";
	
	public static String Last_Name  = "Kurra";
	
	public static String Phone_Number = "5147142020";
	
	public static String Email       = "Varatest@gmail.com";
	
	public static String City        = "Montreal";
	
	public static String Province_X_Path ="//select/option[2]";
	
	public static String Description     = "This is EQ_Care Test";
	
	
	
	/* Error Messages */
	
    public static String First_Name_Error_Message="The first name field is required";
    
    public static String Last_Name_Error_Message="The last name field is required";
    
    public static String Email_Error_Message="The work email field is required";
    
    public static String Province_Error_Message="Please select a province";
    
    public static String City_Error_Message="The city field is required";
    
    public static String Description_Error_Message="Please tell us a bit about your inquiry";
    
    public static String PhoneNumber_Error_Message="The Phone Number field is required";
	
	
	
	public static void TakeScreenShot() throws IOException {
		
		File screenshotofcontactpage= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotofcontactpage, new File("./src/test/resources/ScreenShotofContactPage/contact.jpg"));
		System.out.println("The Contact Us Page Image Captured");
		
	}
	
	
    public static void TakeScreenShotofPhoneError() throws IOException {
		
    	
    	WebElement pagesection= driver.findElement(By.xpath("//*[@class=\"phone:px-8 tablet:flex tablet:flex-wrap tablet:justify-between\"]"));
    	
    	driver.manage().timeouts().implicitlyWait(TestUtils.Implicitl_Wait_JavaClass, TimeUnit.SECONDS);
    	
    	File src= pagesection.getScreenshotAs(OutputType.FILE);
    	
    	File target= new File("./src/test/resources/ScreenShotofContactPage/phoneerrormessagenotdisplayed.png");
    	
    	FileUtils.copyFile(src, target);
		
		
		System.out.println("The Error Message for Phone Number field is not displayed Image Captured for the same");
		
	}
	

}
