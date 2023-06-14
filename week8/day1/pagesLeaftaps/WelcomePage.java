package week8.day1.pagesLeaftaps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import week8.day1.baseLeaftaps.BaseClass;

public class WelcomePage extends BaseClass{
	
	public WelcomePage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	public WelcomePage verifyLogonSuccessful() {
		String title = driver.getTitle();
		System.out.println(title);
		if (title.contains("Leaftaps - TestLeaf Automation Platform")) {
			System.out.println("Login Succesful");
		}
		else {
			System.out.println("Login unsuccessful");
		}
		return this;
	}
	
	public HomePage clickCRMSFA() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new HomePage(driver);
	}
	

}
