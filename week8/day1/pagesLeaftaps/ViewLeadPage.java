package week8.day1.pagesLeaftaps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import week8.day1.baseLeaftaps.BaseClass;

public class ViewLeadPage extends BaseClass {
	
	public ViewLeadPage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	public ViewLeadPage verifyViewLeadPage() {
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains("Testleaf")) {
			System.out.println("Lead created successfully");
		}
		else {
			System.out.println("Lead is not created");
		}
		return this;
	}
	

}
