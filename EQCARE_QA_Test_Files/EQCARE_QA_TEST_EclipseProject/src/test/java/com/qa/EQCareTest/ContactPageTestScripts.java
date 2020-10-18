package com.qa.EQCareTest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.eqcaresupportpage.ContactEQ;
import com.qa.testbaseclass.TestBaseClass;
import com.qa.testutils.TestUtils;

public class ContactPageTestScripts extends TestBaseClass {
	
	
	ContactEQ contactpage;
	
	

	public ContactPageTestScripts() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	
	public void setup() throws IOException {
		
		intialization_method(); 
		
		contactpage=new ContactEQ();
	}
	
	
	@Test(priority = 1)
	
	public void screenshotofcontact() throws IOException {
		
		contactpage.Screenshotofcontactpage();                    // Taking Screenshot of Contact Us Page to verify the page is displayed
		 
	}
	
	@Test(priority = 2)
	
	public void Validatetitle() {
		
		String contacttitle= contactpage.gettitleofthepage();   // As part of adding validations here validating page title
		
		Assert.assertEquals(contacttitle, "Contact our Support Team");    // Asserting the title(Actual vs Expected)
		
	}
	
	@Test(priority = 3)
	
	public void ValidateAbout() throws InterruptedException {
		
		String aboouttitle= contactpage.validate_about_header_title();
		
		System.out.println(aboouttitle);
		
		Assert.assertEquals(aboouttitle, "About Us");           // Asserting the About Us Page selected from Company(drop down)
		
	}
	
	
	@Test(priority = 4)
	
	public void ValidateCareer() throws InterruptedException {
		
		String careerpagetile= contactpage.validatecareerheadertitle();
		
		System.out.println("Page Landed on Career selected from dropdown ----"+ " "+careerpagetile);
		
		Assert.assertEquals(careerpagetile, "Work at Eq Care");     // Asserting the Career Page selected from Company(drop down)
	}
	
	
	@Test(priority = 5)
	
	public void ErrorformMessagesValidation() throws IOException {
		
		
		int i;
       String[] text=contactpage.validateerrormessages(); 
       
       String[] error=new String[10];              // Validating error messages after clicking on the Customer Support
                                                  //  button without filling the mandatory fields.
       
       error[0]=TestUtils.First_Name_Error_Message;
       error[1]=TestUtils.Last_Name_Error_Message;
       error[2]=TestUtils.Email_Error_Message;
       error[3]=TestUtils.Province_Error_Message;
       error[4]=TestUtils.City_Error_Message;
       error[5]=TestUtils.Description_Error_Message;
       error[6]=TestUtils.PhoneNumber_Error_Message; // Phone Number error validation message is not displayed
       
       for ( i = 0; i < text.length; i++) {
    	   
    	   System.out.println(text[i]);
    	    
    	   if(text[i].length()>0)
    		   Assert.assertEquals(text[i], error[i]); // Asserting the error messages 
    	                                                     
	  }
      		
	}	
	
	@Test(priority = 6)
	public void validform() throws InterruptedException {
		String taketext= contactpage.checkformwithvaliddata(); // Checking the form after filling the mandatory fields
		
		System.out.println(taketext);
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
