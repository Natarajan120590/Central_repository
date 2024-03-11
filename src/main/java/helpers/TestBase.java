package helpers;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;




public class TestBase 
{
	public static WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	Logger log=LoggerHelper.getLogger(TestBase.class);
	
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException
	{
		String reportPath="C:\\Users\\natar\\eclipse-workspace\\SCB_WorkBench\\target\\ExtentsReports.html";
		extent=new ExtentReports();	
		ExtentSparkReporter report=new ExtentSparkReporter(reportPath);
		extent.attachReporter(report);
		extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
		         extent.setSystemInfo("Environment", "Production");
		extent.setSystemInfo("User Name", "Rajkumar SM");
		report.config().setDocumentTitle("Flipkart Validation");
		                // Name of the report
		report.config().setReportName("Extents Report");
		                // Dark Theme
		report.config().setTheme(Theme.STANDARD);
		log.info("=======Before Suite========");
	}
	@BeforeTest
	public void beforeTest(ITestContext restults)
	{
		log.info("=======Before Test========");		
		log.info("Test Name is "+restults.getClass().getSimpleName());
	}
	@BeforeClass
	public void beforeClass(ITestContext restults)
	{
		log.info("=======Before Class========");		
		log.info("Class Name is "+restults.getClass().getSimpleName());
	
	}
	@BeforeMethod
	public void beforeMethod(ITestResult results)
	{
		log.info("=======Before Method========");
		test=extent.createTest(results.getMethod().getMethodName());
		log.info("Method Name is "+results.getMethod().getMethodName());
	}
	@AfterMethod
	public void afterMethod(ITestResult results) throws IOException
	{
		log.info("=======After Method========");
		if(results.getStatus()==results.SUCCESS)
		{
			String path=getScreenshots("C:\\Users\\natar\\eclipse-workspace\\SCB_WorkBench\\src\\test\\resources\\ScreenShots",results.getName());
			test.log(Status.PASS,"TestCase is pass "+test.addScreenCaptureFromPath(path));
			log.info(results.getClass().getName()+"===Test case is Pass");
		}
		else if(results.getStatus()==results.SKIP)
		{
			String path=getScreenshots("C:\\Users\\natar\\eclipse-workspace\\SCB_WorkBench\\src\\test\\resources\\ScreenShots",results.getName());
			test.log(Status.SKIP,""+test.addScreenCaptureFromPath(path));
			log.info(results.getClass().getName()+"===Test case is Skipped");
		}
		else if(results.getStatus()==results.FAILURE)
		{
			test.log(Status.FAIL, "Test case is Failed");
			log.info(results.getClass().getName()+"===Test case is Failed");
		}
	}
	@AfterClass
	public void afterClass()
	{
		log.info("=======After Class========");
	}
	
	@AfterTest
	public void afterTest()
	{
		
		extent.flush();
		log.info("=======After Test========");
	}
	@AfterSuite
	public void afterSuite()
	{
		log.info("=======After Suite========");
		//driver.quit();
	}
	
	
	public String getScreenshots(String path,String fileName) throws IOException
	{
		String destFilePath = null;
		try
		{
		Calendar cal=Calendar.getInstance();
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
		String date=format.format(cal.getTime());
		destFilePath=path+"\\"+fileName+"["+date+"].png";
		FileUtils.copyFile( srcFile,new File(destFilePath));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return destFilePath;
	}
	
	public WebDriver LaunchUrl(String url) throws IOException
	{
		driver=BrowserHelper.getBrowser("chrome");
		driver.get(url);
		log.info("Url Launched Successfully");
		getScreenshots("C:\\Users\\natar\\eclipse-workspace\\SCB_WorkBench\\src\\test\\resources\\ScreenShots","homepage");
		return driver;
		
	}
	
	
}
