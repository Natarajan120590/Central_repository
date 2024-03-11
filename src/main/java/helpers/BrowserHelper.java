package helpers;





import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BrowserHelper extends TestBase
{
    	
	public static WebDriver getBrowser(String browser)
	{
	   String osName=System.getProperty("os.name");
	   System.out.println("OS Name is: "+osName);
	   if("Windows 11".contains(osName))
	   {
		   System.out.println("OS name is===>"+osName);
		   if(browser.equalsIgnoreCase("chrome"))
		   {
			   WebDriverManager.chromedriver().setup();
			   DesiredCapabilities caps=new DesiredCapabilities();
			   caps.setAcceptInsecureCerts(true);  	
			   
			   ChromeOptions options = new ChromeOptions();
			   options.addArguments("--start-maximized");
			   options.addArguments("--incognito");
			   options.merge(caps);
			   driver = new ChromeDriver(options);			    
			   
//			   driver=new ChromeDriver();
//			   driver.manage().window().maximize();			  
			   System.out.println("Chrome browser launched successfully");
			   
		   }
		   else if(browser.equalsIgnoreCase("edge"))
		   {
			   WebDriverManager.edgedriver().setup();
			   driver=new EdgeDriver();
			   System.out.println("Edge browser launched successfully");
		   }
	   }
	   else if("Lin".contains(osName))
	   {
		   
	   }
	   return driver;
	}
	
	public void getChromeOptions()
	{
		//String userProfile= "C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data\\";
		ChromeOptions options = new ChromeOptions();
        //options.addArguments("--user-data-dir="+userProfile);
        options.addArguments("--profile-directory=Default");
        options.addArguments("--start-maximized");
	}
	
	public void ClearBrowserCache() throws InterruptedException
	{
	driver.manage().deleteAllCookies(); //delete all cookies
	Thread.sleep(7000); //wait 7 seconds to clear cookies.
	}
	
	public void closeAllChildwindowAndMoveParrentWindow()
	{
		String parentWindow=driver.getWindowHandle();
		Set<String> windowList=driver.getWindowHandles();
		for(String window:windowList)
		{
			if(!parentWindow.equals(window))
			{
			 driver.switchTo().window(window);
			 driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
	}
	public void swithToWindow(String window)
	{
		if(!(window==null))
		{
			driver.switchTo().window(window);
		}
	}

}
