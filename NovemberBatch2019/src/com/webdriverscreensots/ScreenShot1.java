package com.webdriverscreensots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot1 
{

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\jars\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\DELL\\Desktop\\gmail.jpeg"));
		
		//File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileHandler.copy(src, new File("C:\\Users\\DELL\\Desktop\\gmail.jpeg"));
			
	}
}
