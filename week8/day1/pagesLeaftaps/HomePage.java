package week8.day1.pagesLeaftaps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import week8.day1.baseLeaftaps.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	public MyLeadsPage clickOnLeads() {
		driver.findElement(By.linkText("Leads")).click();
		return new MyLeadsPage(driver);

	}

}
