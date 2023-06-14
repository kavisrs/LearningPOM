package week8.day1.baseLeaftaps;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utlis.ReadExcel;

public class BaseClass {

	public ChromeDriver driver;
	public String excelFileName;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName, testDescription, testCategory, testAuthor;
	
	
	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);	
	}
	
	@BeforeMethod	 
	public void preContition() {

		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public int takeSnap() throws IOException {
		int randomNumber = (int) (Math.random()*999999 + 10000000);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snaps/img"+randomNumber+".png");
		FileUtils.copyFile(source, destination);
		return randomNumber;
	}
	
	
	public void reportStep(String StepInfo, String Status) throws IOException {
		int ranNum = takeSnap();
		if (Status.equalsIgnoreCase("pass")) {
			test.pass(StepInfo,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+ranNum+".png").build()); //test step1
		}
		else {
			test.fail(StepInfo,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+ranNum+".png").build()); //test step1
			throw new RuntimeException("Please refer log for more details");
		}
	}
	
	
	@AfterMethod
	public void aftercondtion() {
		driver.close();
	}
	
	@AfterSuite
	public void stopReport() {
		extent.flush();
	}

		
	@DataProvider()
	public String[][] sendData() throws IOException {
		return ReadExcel.readExcel(excelFileName);
	}
}
