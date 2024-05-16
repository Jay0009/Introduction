package section11;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope
{

	public static void main(String[] args) throws InterruptedException
	{
		//1. Configure driver
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();
		
		//2. URL
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//3. count of links in page
		int totalLinks = driver.findElements(By.tagName("a")).size();
		System.out.println(totalLinks);
		
		//4.count of links in footer section
		//4.1 get the webelement of footer
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		int footerDriverCount = footerDriver.findElements(By.tagName("a")).size();
		System.out.println(footerDriverCount);
		
		//5. count of links of first column of the footer section
		WebElement firstColumnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int firstColumnDriverCount = firstColumnDriver.findElements(By.tagName("a")).size();
		System.out.println(firstColumnDriverCount);
		
		//6. click on each link in the firstColumnDriver and check if pages are opening.
		for (int i = 1; i < firstColumnDriverCount; i++)
		{
			List<WebElement> firstColumnLinks = firstColumnDriver.findElements(By.tagName("a"));
			String clickOnLinkTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
			firstColumnLinks.get(i).sendKeys(clickOnLinkTab); //this will move the mouse to next page.
		}
		
		//7. Get the title of each and every page
		Thread.sleep(5000); // wait to load all window handles.
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while (it.hasNext())
		{
			WebDriver currentTab = driver.switchTo().window(it.next());
			System.out.println(currentTab.getTitle());
		}
		
		
		Thread.sleep(3000);
		driver.quit();

	}

}
