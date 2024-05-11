import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction
{

	public static void main(String[] args)
	{
		
		
//		Set properties without using Selenium manager on chrome and invoke chrome browser
//		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		
		//Invoking chrome browser
		WebDriver driver = new ChromeDriver();
		
		//close window
		driver.close();
	
	}

}
