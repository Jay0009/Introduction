package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropDown
{
	public static void main(String[] args) throws InterruptedException
	{
		//Invoke chrome browser
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();
		
		//get URL
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Click on passanger
		driver.findElement(By.id("divpaxinfo")).click();
		
		Thread.sleep(2000);
		
		//Click on adult until it shows 5 adult, current value by default is 1
		for (int i = 1; i < 5; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}	
		
		//Click on done
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//Click on passenger again to get the number of passengers selected.
		String totalPassenders = driver.findElement(By.id("divpaxinfo")).getText();
		System.out.println(totalPassenders);
		
		Thread.sleep(2000);
		
		driver.close();

	}
}
