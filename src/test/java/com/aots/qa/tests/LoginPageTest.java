package com.aots.qa.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aots.qa.pages.LoginPage;
import com.aots.qa.testbase.TestBase;

public class LoginPageTest extends TestBase{
	
	LoginPage lp;
	
	
	public LoginPageTest() {
		
		super();
	}
	
	@BeforeTest
	public void setUp() {
		
	//	initialization();
		System.out.println("Starting Testing");

	}

	
	@BeforeMethod
	public void createN() {

		initialization();
		lp = new LoginPage();
		
	}
	@Test(enabled=false)
	public void LoginwithValidDetails() throws InterruptedException {
		
		boolean res=	lp.login("Admin", "Admin");
		
		Assert.assertTrue(res);
	
	}
	@Test
	public void LoginwithINValidDetails() throws InterruptedException {
		
		boolean res=	lp.login1("Admin", "Admin1");
		
		Assert.assertFalse(res);
	
	}
	@Test
	public void checkAllLinkS() {
		lp.checkAllLinks();
		
	}
	
	@AfterMethod
	public void endTest() {
		
		driver.close();
	}
	
	@AfterTest
	public void tearDown() {

		System.out.println("I am executing");
	}
}
