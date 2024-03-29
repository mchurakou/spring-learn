
package com.mikalai.mvc.test.ui;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.thoughtworks.selenium.SeleneseTestBase;


public class UIAddContactTest extends SeleneseTestBase {

	private static final String USERNAME = "user";
	private static final String PASSWORD = "user";
	
	@Before
	public void setUp() throws Exception {
		try {

		
		WebDriver driver = new ChromeDriver();

		
		String baseUrl = "http://localhost:8080/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
		
		
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddContact() {
		
		// Login
		try {
			loginAs(USERNAME, PASSWORD);
			
			// Enter add contact form
			selenium.open("/mvc/contacts?form");
			selenium.waitForPageToLoad("30000");
			
			// Fill in contact information
			selenium.type("firstName", "Andy");
			selenium.type("lastName", "Lau");
			selenium.click("name=submit");
			
			// Verification
			verifyTrue(selenium.isTextPresent("Andy"));
			verifyTrue(selenium.isTextPresent("Lau"));
			
			// Logout
			logout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddContactWithEmptyForm() {
		
		// Login
		loginAs(USERNAME, PASSWORD);
		
		// Enter add contact form
		selenium.open("/mvc/contacts?form");
		selenium.waitForPageToLoad("30000");
		
		// Submit form
		selenium.click("name=submit");
		
		// Verification
		verifyTrue(selenium.isTextPresent("Failed saving contact"));
		
		// Logout
		logout();
	}	
	
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}	
	
	private void loginAs(String userName, String password) {
		selenium.open("/mvc/contacts");
		selenium.type("j_username", userName);
		selenium.type("j_password", password);
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");		
	}
	
	private void logout() {
		selenium.click("link=Logout");
	}
	
}
