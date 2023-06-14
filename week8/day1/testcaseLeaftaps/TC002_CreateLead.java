package week8.day1.testcaseLeaftaps;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week8.day1.baseLeaftaps.BaseClass;
import week8.day1.pagesLeaftaps.LoginPage;

public class TC002_CreateLead extends BaseClass{
	
	@BeforeTest
	public void setValues() {
		excelFileName = "CreateLeadExcel";
	}	
	
	@Test(dataProvider = "sendData")
	public void runCreateLead(String uName, String pwd, String cName, String fName, String lName, String pNo) throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(uName)
		.enterPassword(pwd)
		.clickLoginButton()
		.verifyLogonSuccessful()
		.clickCRMSFA()
		.clickOnLeads()
		.clickCreateLead()
		.enterCompanyName(cName)
		.enterFirstName(fName)
		.enterLastName(lName)
		.enterPhoneNumber(pNo)
		.clickSubmitButton()
		.verifyViewLeadPage();

	}

}
