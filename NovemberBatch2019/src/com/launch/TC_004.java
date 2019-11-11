package com.launch;

import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.LogStatus;

public class TC_004 extends BaseTest
{
	
	
	public static void main(String[] args) throws Exception 
	{
		test=report.startTest("TC_004");
		
		init();
		test.log(LogStatus.INFO, "Initializing the properties files....");
		
		launch("chromebrowser");
		test.log(LogStatus.INFO, "Launched the browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url : " + p.getProperty("amazonurl"));
		
		selectOption("amazonsearchdrop_id","amazondropvalue");
		test.log(LogStatus.INFO, "Selected the option : " + or.getProperty("amazondropvalue") + " by using the locator : "+ or.getProperty("amazonsearchdrop_id"));		
		
		typeValue("amazonsearchtext_id","amazontestvalue");
		test.log(LogStatus.INFO, "Entered the value : " + or.getProperty("amazontestvalue") + " by using the locator : " + or.getProperty("amazonsearchtext_id"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(LogStatus.INFO, "Clicked on button by Using the locator : " + or.getProperty("amazonsearchbutton_xpath"));
		
		report.endTest(test);
		report.flush();
		
		/*driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
		
		driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();*/

	}

	

}
