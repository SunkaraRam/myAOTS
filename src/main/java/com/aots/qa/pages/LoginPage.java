package com.aots.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aots.qa.testbase.TestBase;

public class LoginPage extends TestBase{
	
	

	@FindBy(xpath = "//input[@id='txtuId']") WebElement uidtxt;
	
	@FindBy(xpath="//input[@id='txtPword']") WebElement pwdtxt;
	
	@FindBy(xpath="//input[@id='login']") WebElement loginbutton;
	
	@FindBy(xpath="//select[@id='drlist']") WebElement dropdownbox;
	
	@FindBy(xpath="//a[@href='home.aspx']") WebElement HomeLink;
	
	@FindBy(xpath="//a[@href='personal_banking.html']") WebElement personalbanklink;
	
	@FindBy(xpath="//a[contains(@href,'Corporate')]") WebElement CorporateBanking;
	
	@FindBy(xpath = "//a[contains(@href,'International')]") WebElement InternationBank;
	
	@FindBy(xpath = "//a[@href='aboutus.html']") WebElement abouts;
	
	@FindBy(xpath = "//img[@src='images/TopFrame_01.jpg']") WebElement logo;
	
	@FindBy(xpath = "//a[@href='savings_account.html']") WebElement savingAccount;
	
	@FindBy(xpath = "//img[@src='images/admin_but_03.jpg']") WebElement logout;
	
	
	
	
	public LoginPage() {
		
		super();
	
		PageFactory.initElements(driver, this);
	}
	
	public boolean login(String uid,String pwd) {
	
		//Select sel = new Select(dropdownbox);
		
		uidtxt.sendKeys(uid);
		
		pwdtxt.sendKeys(pwd);
		
		loginbutton.click();
		
		return logout.isDisplayed();
		
	
	}
	
	public boolean login1(String invaliduid,String validpwd) {
		
		try {
			
			uidtxt.sendKeys(invaliduid);
			
			pwdtxt.sendKeys(validpwd);
			
			loginbutton.click();
			
			return logout.isDisplayed();
			
			
		} catch (Exception e) {
			
			return false;
			
		}
		
	
		
	}
	
	public void checkAllLinks() {
		
		List<WebElement> ar = driver.findElements(By.tagName("a"));
		
		ArrayList<WebElement> activelinks = new ArrayList<WebElement>();
		
		for (int i = 0; i < ar.size(); i++) {
			
			if (ar.get(i).getAttribute("href")!=null) {
				
				activelinks.add(ar.get(i));
			}
			
		}
		
		System.out.println("All links : " +ar.size());
		System.out.println("activelinks : "+activelinks.size());
	}
	
	
	
}
