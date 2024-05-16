package section13;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class Miscelleneous
{

	public static void main(String[] args) throws InterruptedException, IOException
	{
		//1. Configure driver
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();
		
		//1. maximize
		driver.manage().window().maximize();
		
		//2. delete all cookies before loading
		driver.manage().deleteAllCookies();
		
		//3. delete single cookie
//		driver.manage().deleteCookieNamed("sessionCookie"); - so that secure log in is log out
		
		
		//4. URL
		driver.get("https://www.google.com/");
		
		//5. screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/jay/Desktop/EclipseProject/Udemy/Automation/Introduction/screenshot.png"));
		
		Thread.sleep(2000);
		driver.close();
		
		

	}

}
