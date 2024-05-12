import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities
{

	public static void main(String[] args) throws InterruptedException
	{
		//Invoke chrome browser
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();
		
		//Maximize
		driver.manage().window().maximize();
		
		//Get URL - when we use this method, selenium will pause until google is fully loaded
		driver.get("https://www.google.com/");
		
		//Go to https://rahulshettyacademy.com/ - .
		//In navigate method, inbuilt mechanism is not there. Hence, as soon as any element is loaded in google, it will jump to another website.
		driver.navigate().to("https://rahulshettyacademy.com/");
		
		//Go back to google
		driver.navigate().back();
		
		//Go forward to rahulshetty academy
		driver.navigate().forward();
		
		Thread.sleep(2000);
		
		driver.close();
		
		
	}

}
