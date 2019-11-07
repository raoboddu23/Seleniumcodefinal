package com.launch;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class BaseTest 
{
	public static WebDriver driver;
	public static Properties p;
	public static Properties or;
	public static String projectPath=System.getProperty("user.dir");
	
	
	public static void init() throws Exception 
	{
		//FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\NovemberBatch2019\\data.properties");
		FileInputStream fis=new FileInputStream(projectPath+"//data.properties");
		p=new Properties();
		p.load(fis);
		
		FileInputStream fis1=new FileInputStream(projectPath+"//or.properties");
		or=new Properties();
		or.load(fis1);
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
		driver.findElement(By.xpath(or.getProperty(locatorKey))).click();
	}

	public static void typeValue(String locatorKey, String value) 
	{
		driver.findElement(By.name(or.getProperty(locatorKey))).sendKeys(or.getProperty(value));
	}

	public static void selectOption(String locatorKey, String option) 
	{
		driver.findElement(By.id(or.getProperty(locatorKey))).sendKeys(or.getProperty(option));	
	}

}
