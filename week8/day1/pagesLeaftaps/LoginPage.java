package week8.day1.pagesLeaftaps;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import week8.day1.baseLeaftaps.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	public LoginPage enterUserName(String uName) throws IOException {
		try {
			driver.findElement(By.id("username")).sendKeys(uName);
			reportStep("Username is entered successfully", "pass");
		} catch (Exception e) {
			reportStep("username is not entered..." +e, "fail");
		}
		return this;
		
	}

	public LoginPage enterPassword(String pwd) throws IOException {
		try {
			driver.findElement(By.id("password")).sendKeys(pwd);
			reportStep("Password is entered successfully", "pass");
		} catch (Exception e) {
			reportStep("password is not entered..." +e, "fail");
		}
		return this;

	}

	public WelcomePage clickLoginButton() throws IOException {
		try {
			driver.findElement(By.className("decorativeSubmit")).click();
			reportStep("Login button is clicked successfully", "pass");
		} catch (Exception e) {
			reportStep("login button is not clicked..." +e, "fail");
		}
		//WelcomePage wp = new WelcomePage();		
		//return wp;
		return new WelcomePage(driver);
	}
}
