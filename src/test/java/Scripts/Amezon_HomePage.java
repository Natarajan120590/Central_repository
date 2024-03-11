package Scripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import helpers.TestBase;
import pageobjects.Amezon_LoginPage;

public class Amezon_HomePage extends TestBase
{
	WebDriver driver;
	@Test
	public void loginPage() throws IOException, InterruptedException
	{
		boolean status=false;
		String url="https://www.amazon.in/";
		String userName="Natarajan@12";
		String password="Nataraj@12";
		driver=LaunchUrl(url);
		Amezon_LoginPage obj=new Amezon_LoginPage(driver);
		status=obj.amezon_Login(userName, password);
		if(status)
		{
			System.out.println("Loggin successfully");
		}
		else
		{
			System.out.println("Loggin failed");			
		}
	}

}
