package TestRunner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import helpers.TestBase;
import pageobjects.TimesOFIndia;

public class Scripts_timesofIndia extends TestBase
{
	WebDriver driver;
	String url="https://timesofindia.indiatimes.com/sports/cricket/icc-rankings";
	
	@Test
	public void timesOFIndia() throws IOException, InterruptedException
	{
		
		driver=LaunchUrl(url);
		Thread.sleep(5000);
		TimesOFIndia obj=new TimesOFIndia(driver);
		//obj.navigate_cricketPage();
		Thread.sleep(3000);
		//obj.navigate_ICCRankingPage();
		obj.validateICCRanking();
	}
	
	

}
