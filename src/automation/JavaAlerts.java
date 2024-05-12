package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaAlerts
{

	public static void main(String[] args) throws InterruptedException
	{
		String text = "Jay";
		//Invoke chrome browser
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();
		
		//get URL
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Write your name in the box
		driver.findElement(By.id("name")).sendKeys(text);
		
		//Click on alert button
		driver.findElement(By.id("alertbtn")).click();
		
		//Grab the text
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		
		//Switch to alert
		driver.switchTo().alert().accept();
		
		//Click on confirm
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("confirmbtn")).click();
		
		//Get the text
		String confirmText = driver.switchTo().alert().getText();
		System.out.println(confirmText);
		
		//Switch to alert and cancel
		driver.switchTo().alert().dismiss();
		
		Thread.sleep(2000);
		driver.close();
		
		
	}

}
