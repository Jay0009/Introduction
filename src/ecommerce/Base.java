package ecommerce;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base
{

	public static void main(String[] args) throws InterruptedException
	{
		//Configure driver
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();
		
		//1. Declare itemsNeeded
		String[] itemsNeeded  = {"Cucumber", "Brocolli", "Beetroot"};

		//2. URL
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		addItems(driver, itemsNeeded);
		Thread.sleep(3000);
		driver.close();
		
	}
	
	
	public static void addItems(WebDriver driver, String[] itemsNeeded)
	{
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for (int i = 0; i < products.size(); i++)
		{
			
			String name =products.get(i).getText().split(" ")[0];

			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			
			
			if (itemsNeededList.contains(name))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length)
				{
					break;
				}
			}
		}
	}
	
}
