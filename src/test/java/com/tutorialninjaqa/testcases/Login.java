package com.tutorialninjaqa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialninja.qa.utilss.Utilities;
import com.tutorialninjabase.Base;

public class Login extends Base{
	
	public Login() throws Exception {
		
		super();
	}
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver=initializingBroweserAndApplicationURL(prop.getProperty("browser"));
	
	    driver.findElement(By.xpath("//span[text()='My Account']")).click();
	    driver.findElement(By.linkText("Login")).click();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();	 
	}
	
	
	@Test(priority = 1,dataProvider="vlidcredentialsSuplier")
	public void verifyLoginwithvalidcredentials(String email,String password) {
	   
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		
	}
	@DataProvider(name="vlidcredentialsSuplier")
	public Object[][] supplyTestData() {
		
		Object [][]data = Utilities.getTestDataFromExcel("Login");
		return data;
	}
	
	@Test(priority = 2)
	public void verifyLoginwithinvalidcredentials() {
	  
		driver.findElement(By.id("input-email")).sendKeys(Utilities.genrateemailtimestamp());
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String Expectedtext=dataprop.getProperty("emailpasswordwarning");
		String Actualtext=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(Actualtext.contains(Expectedtext),"Expected warning text");
		
		

}
	
	
}
