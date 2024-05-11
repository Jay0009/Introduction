import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction
{

	public static void main(String[] args)
	{
		
		
//		Set properties without using Selenium manager on chrome and invoke chrome browser
//		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		
//		Set properties for gecko driver
		System.setProperty("webdriver.gecko.driver", "/Users/jay/Desktop/VdemiCourse/driver/geckodriver");
		
		//Invoking chrome browser
//		WebDriver driver = new ChromeDriver();
		
		//Invoking Firefox Driver
		WebDriver driver = new FirefoxDriver();
		
		//get title of the Web page
		driver.get("https://rahulshettyacademy.com");
		String title = driver.getTitle();
		System.out.println(title);
		
		//get current URL
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		//close window
//		driver.close();
		
		//driver quit - this will quit the driver, it will close all browser.
		driver.quit();
		
	
	}

}
