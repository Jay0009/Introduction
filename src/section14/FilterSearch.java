package section14;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterSearch
{
	public static void main(String[] args)
	{
		// 1. Configure driver
		System.setProperty("webdriver.chome.driver",
				"/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();

		// 2. url
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//3.click on Search for Rice
		driver.findElement(By.id("search-field")).click();
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> filteredItems = items.stream().filter(s -> s.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(items.size(), filteredItems.size());
		
		try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
}
