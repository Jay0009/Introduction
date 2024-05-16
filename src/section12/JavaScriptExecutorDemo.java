package section12;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo
{

	public static void main(String[] args) throws InterruptedException
	{
		//1. Configure driver
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();

		//2. URL
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//3.Create javascript executor object to have the view of the web-element
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//4.scroll to web element
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
		
		//5.scroll on web element to go to bottom
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		Thread.sleep(3000);
		driver.close();
	}

}
