package helpers;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class GenericHelpers 
{
	public static WebDriver driver;
	static WebDriverWait wait;
	static WebElement element;
	static Actions action;
	public static Logger log=LoggerHelper.getLogger(GenericHelpers.class);
	
	public GenericHelpers(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public static WebElement web_getObject(String xpath)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
		
	}
	
	public static void web_click(String xpath)
	{
		element=web_getObject(xpath);
		if(element!=null)
		{			
			if(element.isDisplayed())
			{
				element.click();
			}
		}
		else
		{
			log.error("Element is null " +xpath);
		}
	}
	public static void web_SendKeys(String xpath,String value)
	{
		if(value==null)
		{
			System.out.println("Value is "+null);
		}
		element=web_getObject(xpath);
		if(element!=null)
		{			
			if(element.isDisplayed())
			{
				element.sendKeys(value);
				System.out.println("Entered text successfully and text is: "+value);
			}
	    }
		else
		{
			log.error("Element is null " +xpath);
		}
	}
	
	public static WebElement wait_FluentWait(String xpath)
	{
		Wait<WebDriver> wait =
		        new FluentWait<>(driver)
		            .withTimeout(Duration.ofSeconds(2))
		            .pollingEvery(Duration.ofMillis(300))
		            .ignoring(ElementNotInteractableException.class);

		   return  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
	}
	
	public static void web_MouseOver_click(String xpath)
	{
		 element=web_getObject(xpath);
		 if(element!=null)
		 {
		  action=new Actions(driver);
		  action.moveToElement(element).build().perform();
		 }
		 else
		 {
			 log.error("Element is null " +xpath);
		 }
		
	}
	public static boolean Web_isElementDisplayed(String xpath)
	{
		boolean flag=false;
		try
		{
			element=web_getObject(xpath);			
			if(element.isDisplayed())
			{
				Assert.assertTrue(true);
				flag=true;
			}
			else
			{
				log.error("element is not visible");
				Assert.fail("element is not visible");
				flag=false;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	public void switch_ToWindow()
	{
		String parent=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		
		for(String s: windows)
		{
		 driver.switchTo().window(s);
		
		 break;
		}
	
	}
}
