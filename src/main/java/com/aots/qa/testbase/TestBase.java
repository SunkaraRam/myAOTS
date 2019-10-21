package com.aots.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	public static WebDriver driver;
	
	public static  Properties prop;
	
	
	public TestBase() {

		try {
			
			prop = new Properties();
		
			FileInputStream fi = new FileInputStream("D:\\SeleniumProjects\\myAOTS\\src\\main\\java\\com\\aots\\qa\\config\\credentials.properties");
		
			prop.load(fi);
			
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
	
		}
		
		catch (FileNotFoundException f) {
			f.printStackTrace();
		}
		catch (IOException i) {
			
			i.printStackTrace();
			
		}
	}
	
	public  static void initialization(){
		
		
		String mbrowser = prop.getProperty("browser");
		
		System.out.println(mbrowser);
		
		if (mbrowser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
			
			driver = new ChromeDriver();
			
		}
		
		else if (mbrowser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\SeleniumProjects\\myAOTS\\FFCHIE\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if (mbrowser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "D:\\SeleniumProjects\\myAOTS\\FFCHIE\\iedriver.exe");
			driver = new InternetExplorerDriver();
			
		}
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
		
	}
		

}
