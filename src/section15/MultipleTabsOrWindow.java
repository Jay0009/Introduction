package section15;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabsOrWindow
{

	public static void main(String[] args) throws InterruptedException
	{
		// 1. Configure driver
		System.setProperty("webdriver.chome.driver",
				"/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();
		
		// 1. go to https://rahulshettyacademy.com/angularpractice/
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//2.new tab
		driver.switchTo().newWindow(WindowType.TAB);
		
		//Get the name of the first course - generic and paste in the name field of previous tab
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		String firstCourseName = driver.findElements(By.cssSelector("a[href *= 'courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.name("name")).sendKeys(firstCourseName);
		Thread.sleep(2000);
		driver.quit();
		

	}

}
