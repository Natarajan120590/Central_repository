package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper 
{
	private WebDriver driver;
  public JavaScriptHelper(WebDriver driver)
  {
	  this.driver=driver;
	  
  }
  JavascriptExecutor exe=((JavascriptExecutor)this.driver);
  public void scrollToElement(WebElement element)
  {
	  
	  if(!(element==null))
	  {
		  exe.executeScript("arguments[0].scrollIntoView(true);", element);
	  }
  }
  public void scrollDownByPixel()
  {
	  exe.executeScript("window.scrollBy(0,1500)");
  }
  public void scrollUpByPixel()
  {
	  exe.executeScript("window.scrollBy(0,-1500)");
  }
}
