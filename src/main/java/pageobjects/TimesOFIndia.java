package pageobjects;

import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.GenericHelpers;

public class TimesOFIndia 
{
    private WebDriver driver;
    
    String btn_cricket="(//a[text()='Cricket'])[1]";
    String btn_IccRankins="//a[text()='ICC Rankings']";
	 public TimesOFIndia(WebDriver driver)
	 {
		 this.driver=driver;
		  new GenericHelpers(driver);
	 }
	 
	 
	 public void navigate_cricketPage()
	 {
		 GenericHelpers.web_click(btn_cricket);
		 
	 }
	 public void navigate_ICCRankingPage() throws InterruptedException
	 {		
		 Thread.sleep(3000);
		 GenericHelpers.web_click(btn_IccRankins);
	 }
	 
	 public void validateICCRanking()
	 {
		 int rows=driver.findElements(By.xpath("//div[contains(@class,'RKwXu pointsTableLhs')]/ul[1]/li")).size();
		 int columns=driver.findElements(By.xpath("//div[contains(@class,'RKwXu pointsTableLhs')]/ul[1]/li[2]/span")).size();
		 ArrayList<Integer> pointValue=new ArrayList<Integer>();
		 String value;
		 for(int i=2;i<rows;i++)
		 {
			 value =driver.findElement(By.xpath("//div[contains(@class,'RKwXu pointsTableLhs')]/ul[1]/li["+i+"]/span[4]")).getText().replace(",", "");;
			 int val=Integer.parseInt(value);
			 pointValue.add(val);
		 }
		 
		 Collections.sort(pointValue);
		 
		 int size=pointValue.size();
		 
		 int highValue=pointValue.get(size-1);
		 int text;
		 for(int i=2;i<rows;i++)
		 {
			 value =driver.findElement(By.xpath("//div[contains(@class,'RKwXu pointsTableLhs')]/ul[1]/li["+i+"]/span[4]")).getText().replace(",", "");
			 text=Integer.parseInt(value);
			 if(text==highValue)
			 {
				 String country=driver.findElement(By.xpath("//div[contains(@class,'RKwXu pointsTableLhs')]/ul[1]/li["+i+"]/span[2]")).getText();
				 System.out.println("Highest point having a country is: "+ country);
			 }
		 }
		 
	 }
}
