package ecommerce;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
		
		//9. implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		//1. Declare itemsNeeded
		String[] itemsNeeded  = {"Cucumber", "Brocolli", "Beetroot"};

		//2. URL
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		//3. add items
		addItems(driver, itemsNeeded);
		
		//4. click on cart
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		
		//5. Proceed to checkout
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		//6. input promo code
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		//7. click on promo button
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//8. check if promo aplied message is visible - please note that promo info visible after 
		// few seconds.
		String promoMessage = driver.findElement(By.cssSelector("span.promoInfo")).getText();
		System.out.println(promoMessage);
		
		
		
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
