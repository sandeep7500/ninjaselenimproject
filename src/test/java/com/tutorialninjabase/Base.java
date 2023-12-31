package com.tutorialninjabase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorialninja.qa.utilss.Utilities;

public class Base {
	
	
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	
	public Base() throws Exception{
		
	    prop= new Properties();
	    dataprop=new Properties();
	    FileInputStream datafis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/tutorialNinjatestdata/testdata.properties");
	    dataprop.load(datafis);
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/tutorialNinjaconfig/config.propertyfile");
		try {
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}
	public WebDriver initializingBroweserAndApplicationURL(String browsername) {
		
	if(browsername.equalsIgnoreCase("chrome")) {
		
		 driver = new ChromeDriver();	
	}
	else if(browsername.equalsIgnoreCase("edge")) {
		
		 driver = new EdgeDriver();
	}
	else if(browsername.equalsIgnoreCase("firefox")) {
		
		 driver = new FirefoxDriver();
	}
	else if(browsername.equalsIgnoreCase("safari")) {
		
		 driver = new SafariDriver();
	}
   
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
    driver.get(prop.getProperty("url"));
    return driver;
}
}
