package section11;

import org.openqa.selenium.By;
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
		
		Thread.sleep(3000);
		driver.close();

	}

}
