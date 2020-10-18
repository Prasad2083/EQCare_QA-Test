package com.qa.testbaseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.qa.testutils.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {
	
	
   public static WebDriver driver;
   public static Properties properties;
	
	
	
	public TestBaseClass() throws IOException {
		
		properties= new Properties();
		
		FileInputStream fileInputStream= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa"
				+ "/config/config.properties");
		
		properties.load(fileInputStream);
		
	}
	
	public static void intialization_method() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(TestUtils.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtils.Implicitl_Wait, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
		
	}
	
	
}
