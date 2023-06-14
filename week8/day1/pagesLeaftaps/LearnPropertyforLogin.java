package week8.day1.pagesLeaftaps;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnPropertyforLogin {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		ChromeDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("Username"));
	
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("Password"));
		
		driver.findElement(By.className("decorativeSubmit")).click();
		

	}

}
