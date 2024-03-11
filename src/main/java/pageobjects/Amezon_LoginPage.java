package pageobjects;

import org.openqa.selenium.WebDriver;

import helpers.GenericHelpers;


public class Amezon_LoginPage 
{
	public WebDriver driver;
  String Xpath_signInAccoountbtn="//div[@class='nav-right']/div[@id='nav-tools']/a[2]";
  String Xpath_ordersBtn="//span[text()='Your Orders']";
  String Xpath_userName="//input[@name='email']";
  String Xpath_Password="//input[@name='password']";
  String Xpath_SignInBtn="//input[@id='signInSubmit']";
  String xpath_SignOutBtn="//span[text()='Sign Out']";
  String Xpath_ValidateOrderpage="//h1[text()='Your Orders']";
  
  public Amezon_LoginPage(WebDriver driver)
  {
	  this.driver=driver;
	  new GenericHelpers(driver);
  }
  
  
  public boolean amezon_Login(String userName,String password) throws InterruptedException
  {
	  boolean status=false;
	  Thread.sleep(3000);
	  GenericHelpers.web_MouseOver_click(Xpath_signInAccoountbtn);
	  GenericHelpers.web_click(Xpath_ordersBtn);
	  GenericHelpers.web_SendKeys(Xpath_userName, userName);
	  GenericHelpers.web_SendKeys(Xpath_Password, password);
	  GenericHelpers.web_click(Xpath_SignInBtn);
	  status=GenericHelpers.Web_isElementDisplayed(Xpath_ValidateOrderpage);
	  return status;
	  
  }
  
}
