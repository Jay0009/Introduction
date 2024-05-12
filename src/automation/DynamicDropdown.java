package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicDropdown
{

	public static void main(String[] args) throws InterruptedException
	{
		//Invoke chrome browser
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();
		
		//get URL
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Check if 1 way is selected
		boolean oneWaySelected = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected();
		System.out.println(oneWaySelected);
		
		//Check if return day section is highlighted in one way
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			System.out.println("One way is selected and return date is not enabled");
			Assert.assertFalse(false);
		}
		else 
		{
			Assert.assertFalse(true);
		}
		
		Thread.sleep(5000);
		
		//Click on round trip
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		Thread.sleep(2000);
		
		//Check if round trip is selected
		boolean roundTripSelected = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected();
		System.out.println(roundTripSelected);
		
		//Check if return day section is highlighted in round trip way
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("Round trip is selected and return date is enabled");
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.assertTrue(false);
		}
		
		//Click on From (city
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		//Select from/departure city
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		
		Thread.sleep(2000);
		
		//Select to/destination city - with index
//		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		//Select to/destination city - without index with parent child relationship xpath
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		Thread.sleep(2000); // to let window appear
		
		// Select current date by css .class, remember to remove any space if class name is combination of 2 class, 
		//class of current date will be unique
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		Thread.sleep(2000);
		driver.close();

	}

}
