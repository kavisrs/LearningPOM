package week8.day1.pagesLeaftaps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import week8.day1.baseLeaftaps.BaseClass;

public class CreateLeadPage extends BaseClass{
	
	public CreateLeadPage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	public CreateLeadPage enterCompanyName(String cName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		return this;
	}

	public CreateLeadPage enterFirstName(String fName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		return this;
	}

	public CreateLeadPage enterLastName(String lName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		return this;
	}

	public CreateLeadPage enterPhoneNumber(String pNo) {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(pNo);
		return this;
	}

	public ViewLeadPage clickSubmitButton() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);
	}
	


	
	
	

}
