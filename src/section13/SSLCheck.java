package section13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck
{

	public static void main(String[] args) throws InterruptedException
	{
		//3. Chrome options class to handle bad ssl automatically
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		//1. Configure driver
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver(options);
		
		//2.URL
		driver.get("https://expired.badssl.com/");
		
		//4. get title
		System.out.println(driver.getTitle());
		
		Thread.sleep(2000);
		driver.close();
	}

}
