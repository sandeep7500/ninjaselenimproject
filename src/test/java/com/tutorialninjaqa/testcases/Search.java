package com.tutorialninjaqa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninjabase.Base;

public class Search extends Base {
	
	public Search() throws Exception {
		super();
		
		
	}
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
	driver=initializingBroweserAndApplicationURL(prop.getProperty("browser"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
	
	@Test(priority = 1)
	public void veryfySearchWithValidProduct() {
		driver.findElement(By.name("search")).sendKeys("hp");
		driver.findElement(By.xpath("//div[@id='search']//i[@class='fa fa-search']")).click();
		String Actualproduct=driver.findElement(By.linkText("HP LP3065")).getText();
		String Expectedresult="HP LP3065";
		Assert.assertEquals(Actualproduct, Expectedresult,"the product is not matching");
		
	}
	@Test(priority = 2)
	public void veryfySearchWithInValidProduct() {
		driver.findElement(By.name("search")).sendKeys("honda");
		driver.findElement(By.xpath("//div[@id='search']//i[@class='fa fa-search']")).click();
		String Actualproduct=driver.findElement(By.xpath("//h2[text()='Products meeting the search criteria']")).getText();
		String Expectedresult="Products meeting the search criteria";
		Assert.assertEquals(Actualproduct, Expectedresult,"the product is not matching");
		
	}

	@Test(priority = 3)
	public void verifyWithOutAnyProduct() {
		
		driver.findElement(By.name("search")).sendKeys("");
		driver.findElement(By.xpath("//div[@id='search']//i[@class='fa fa-search']")).click();
		String Actualproduct=driver.findElement(By.xpath("//h2[text()='Products meeting the search criteria']")).getText();
		String Expectedresult="Products meeting the search criteria";
		Assert.assertEquals(Actualproduct, Expectedresult,"the product is not matching");
		
		
		
	}
}
