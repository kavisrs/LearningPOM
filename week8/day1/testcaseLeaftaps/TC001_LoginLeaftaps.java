package week8.day1.testcaseLeaftaps;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week8.day1.baseLeaftaps.BaseClass;
import week8.day1.pagesLeaftaps.LoginPage;

public class TC001_LoginLeaftaps extends BaseClass{
	
	@BeforeTest
	public void setValues() {
		excelFileName = "LoginExcel";
		testName = "Login";
		testDescription = "Login postitive case";
		testCategory = "smoke";
		testAuthor = "Kavitha";
	}
	
	
	@Test(dataProvider = "sendData")
	public void runLogin(String uName, String pwd) throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(uName)
		.enterPassword(pwd)
		.clickLoginButton()
		.verifyLogonSuccessful();

	}
	
}
