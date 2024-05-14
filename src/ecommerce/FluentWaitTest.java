package ecommerce;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitTest
{

	public static void main(String[] args)
	{
		//1. Configure driver
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();
		
		//2. URL
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		//3. start
		driver.findElement(By.cssSelector("[id='start'] button")).click();
		
		//4. Wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>()
		{

			@Override
			public WebElement apply(WebDriver driver)
			{
				if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed())
				{
					return driver.findElement(By.cssSelector("[id='finish'] h4"));
				} 
				else {
					return null;
				}
			}
			
		});
		boolean displayed = driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed();
		System.out.println(displayed);
	}

}
