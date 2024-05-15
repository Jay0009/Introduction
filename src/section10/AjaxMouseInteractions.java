package section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AjaxMouseInteractions
{

	public static void main(String[] args) throws InterruptedException
	{
		//1. Configure driver
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();
		
		//2. URL
		driver.get("https://www.amazon.com/");
		
		Thread.sleep(7000);
		
		//3. Move mouse to section for the menu to pop  up
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build()
		.perform();
		
		Thread.sleep(3000);
		driver.close();
	}

}
