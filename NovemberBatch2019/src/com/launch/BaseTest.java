package com.launch;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest 
{
	public static WebDriver driver;
	public static Properties p;
	public static Properties or;
	public static String projectPath=System.getProperty("user.dir");
	public static ExtentReports report = ExtentManager.getInstance();
	public static ExtentTest test;
	
	public static void init() throws Exception 
	{
		//FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\NovemberBatch2019\\data.properties");
		FileInputStream fis=new FileInputStream(projectPath+"//data.properties");
		p=new Properties();
		p.load(fis);
		
		FileInputStream fis1=new FileInputStream(projectPath+"//or.properties");
		or=new Properties();
		or.load(fis1);
		
		PropertyConfigurator.configure(projectPath+"//log4j.properties");
	
	}
	
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equals("chrome")){
			System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver.exe");
			
			ChromeOptions option=new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 11");
			
			
			option.addArguments("--disable-notifications");
			option.addArguments("--disable-infobars");
			option.addArguments("--start-maximized");
			
			
			//Proxy IP Configuration
			//option.addArguments("--proxy-server=http://192.168.90.84:1234");
			
			driver=new ChromeDriver(option);
		}else if(p.getProperty(browser).equals("firefox")) {
			
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "e://firefoxlogs.txt");
			System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\geckodriver.exe");
			
			ProfilesIni p=new ProfilesIni();
			FirefoxProfile profile = p.getProfile("novemberprofile");
			
			//notifications
			profile.setPreference("dom.webnotifications.enabled", false);
			
			//proxy servers
			profile.setPreference("network.proxy.type", 1);
			profile.setPreference("network.proxy.socks", "192.168.90.54");
			profile.setPreference("network.proxy.socks_port", 1744);
			
			FirefoxOptions option=new FirefoxOptions();
			option.setProfile(profile);
			
			driver=new FirefoxDriver(option);
		}
	}
	
	
	public static void navigateUrl(String url) 
	{
		//driver.get(p.getProperty(url));
		
		driver.navigate().to(p.getProperty(url));
	}
	
	
	public static void clickElement(String locatorKey) 
	{
		getElement(locatorKey).click();
		//driver.findElement(By.xpath(or.getProperty(locatorKey))).click();
	}

	public static void typeValue(String locatorKey, String value) 
	{
		getElement(locatorKey).sendKeys(or.getProperty(value));
		//driver.findElement(By.id(or.getProperty(locatorKey))).sendKeys(or.getProperty(value));
	}

	

	public static void selectOption(String locatorKey, String option) 
	{
		getElement(locatorKey).sendKeys(or.getProperty(option));
		//driver.findElement(By.id(or.getProperty(locatorKey))).sendKeys(or.getProperty(option));	
	}
	
	
	public static WebElement getElement(String locatorKey) 
	{
		WebElement element=null;
		
		if(locatorKey.endsWith("_id")) {
			element=driver.findElement(By.id(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element=driver.findElement(By.name(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element=driver.findElement(By.className(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element=driver.findElement(By.xpath(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_css")) {
			element=driver.findElement(By.cssSelector(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element=driver.findElement(By.linkText(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partilalinktext")) {
			element=driver.findElement(By.partialLinkText(or.getProperty(locatorKey)));
		}
		
		return element;
	
	}

}
