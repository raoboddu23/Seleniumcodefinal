package com.launch;

import org.apache.log4j.Logger;

public class TC_003 extends BaseTest
{
	private static final Logger log=Logger.getLogger(TC_003.class.getName());
	
	public static void main(String[] args) throws Exception 
	{
		init();
		log.info("Initializing the properties files....");
		
		launch("chromebrowser");
		log.info("Launched the browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to url : " + p.getProperty("amazonurl"));
		
		selectOption("amazonsearchdrop_id","amazondropvalue");
		log.info("Selected the option : " + or.getProperty("amazondropvalue") + " by using the locator : "+ or.getProperty("amazonsearchdrop_id"));
				
		typeValue("amazonsearchtext_id","amazontestvalue");
		log.info("Entered the value : " + or.getProperty("amazontestvalue") + " by using the locator : " + or.getProperty("amazonsearchtext_id"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked on button by Using the locator : " + or.getProperty("amazonsearchbutton_xpath"));
		
		/*driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
		
		driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();*/

	}

	

}
