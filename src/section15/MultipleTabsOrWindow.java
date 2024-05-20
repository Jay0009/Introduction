package section15;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabsOrWindow
{

	public static void main(String[] args) throws InterruptedException, IOException
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
		WebElement nameEditbox = driver.findElement(By.name("name"));
		nameEditbox.sendKeys(firstCourseName);
		
		//Lecture 126. - 1.take the screenshot of the webElement namEditBox 
		//in which the first course name was pasted earlier
		File file = nameEditbox.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("nameEditbox.png"));
		
		//S.15.127- find length and width of nameEditBox
		int height = nameEditbox.getRect().getDimension().getHeight();
		int width = nameEditbox.getRect().getDimension().getWidth();
		System.out.println("Height of the nameEditBox is: " + height +" & width is: " + width);
		
		Thread.sleep(2000);
		driver.quit();
		

	}

}
