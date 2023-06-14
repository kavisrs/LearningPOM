package week8.day1.pagesLeaftaps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import week8.day1.baseLeaftaps.BaseClass;

public class MyLeadsPage extends BaseClass {
	
	public MyLeadsPage(ChromeDriver driver)
	{
		this.driver=driver;
	}

	public CreateLeadPage clickCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLeadPage(driver);
	}

}
