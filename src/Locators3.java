import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3
{

	public static void main(String[] args) throws InterruptedException
	{
		//Invoke chrome browser
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();
		
		//go to webpage
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Parent to child's sibling using xpath
		String logInButton = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
		System.out.println(logInButton);
		
		//Parent to child and traversing back to parent and then again to child's sibling - i.e., to log in button
		String logInButton1 = driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText();
		System.out.println(logInButton1);
		
		Thread.sleep(2000);
		
		//close
		driver.close();
		

	}

}
