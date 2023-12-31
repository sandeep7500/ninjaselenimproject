package com.tutorialninjaqa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.utilss.Utilities;
import com.tutorialninjabase.Base;

public class Register extends Base{
	
	public Register() throws Exception {
		super();
	}
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver=initializingBroweserAndApplicationURL(prop.getProperty("browser"));
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();	 
	}
	
	@Test(priority = 1)
	public void verifyregisteringanaccountwithmandatoryfields() {
		
		
		 driver.findElement(By.xpath("//span[text()='My Account']")).click();
		 driver.findElement(By.linkText("Register")).click();
		 driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("Fisrtname"));
		 driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
		 driver.findElement(By.id("input-email")).sendKeys(Utilities.genrateemailtimestamp());
		 driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephonenumber"));
		 driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
		 driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("password"));
		 driver.findElement(By.xpath("//input[@name='agree']")).click();
		 driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 String actualtext=driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
		 String Expectedtext=dataprop.getProperty("sucessfullyregisteredmessage");
		 Assert.assertEquals(actualtext,Expectedtext,"The succesfully registered text is displaying");
		 
		 
		
	}
	@Test(priority =2)
	public void verifyregisteringanaccountbyallfields() {
		
		
		 driver.findElement(By.xpath("//span[text()='My Account']")).click();
		 driver.findElement(By.linkText("Register")).click();
		 driver.findElement(By.id("input-firstname")).sendKeys("sandy");
		 driver.findElement(By.id("input-lastname")).sendKeys("sharma");
		 driver.findElement(By.id("input-email")).sendKeys(Utilities.genrateemailtimestamp());
		 driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("nvalidpassword"));
		 driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
		 driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("password"));
		 driver.findElement(By.xpath("//input[@name='newsletter'][@value=\"1\"]")).click();
		 driver.findElement(By.xpath("//input[@name='agree']")).click();
		 driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 String actualtext=driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
		 String Expectedtext="Your Account Has Been Created!";
		 Assert.assertEquals(actualtext,Expectedtext,"The succesfully registered text is displaying");
		
		 

}   @Test(priority = 3)
	public void verifyregisteringanaccountbyexistingemail() {
		
		
		 driver.findElement(By.xpath("//span[text()='My Account']")).click();
		 driver.findElement(By.linkText("Register")).click();
		 driver.findElement(By.id("input-firstname")).sendKeys("sandy");
		 driver.findElement(By.id("input-lastname")).sendKeys("sharma");
		 driver.findElement(By.id("input-email")).sendKeys("sandy11@gmail.com");
		 driver.findElement(By.id("input-telephone")).sendKeys("6574898767");
		 driver.findElement(By.id("input-password")).sendKeys("12345");
		 driver.findElement(By.id("input-confirm")).sendKeys("12345");
		 driver.findElement(By.xpath("//input[@name='newsletter'][@value=\"1\"]")).click();
		 driver.findElement(By.xpath("//input[@name='agree']")).click();
		 driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 String actualtext=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		 String Expectedtext="Warning: E-Mail Address is already registered!";
		 		
		 Assert.assertTrue(actualtext.contains(Expectedtext));
		
		 

	
}
}
