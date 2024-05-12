package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class E2E
{

	public static void main(String[] args) throws InterruptedException
	{
		//Invoke chrome browser
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();
		
		//get URL
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Select one way
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
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
		
		
		
		//Click on senior citizen checkbox using css/regular expresssion using *
		driver.findElement(By.cssSelector("input[id *= 'SeniorCitizenDiscount']")).click();
		
		//Check if the checkbox is selected or not by using isSelected after clicking.
		boolean seniorCitizen = driver.findElement(By.cssSelector("input[id *= 'SeniorCitizenDiscount']")).isSelected();
		System.out.println(seniorCitizen);
		Assert.assertTrue(seniorCitizen);

		
		//Click on From (city
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		Thread.sleep(2000);
		
		//Select from/departure city
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		
		Thread.sleep(2000);
		
		
		//Select to/destination city - without index with parent child relationship xpath
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		Thread.sleep(2000); // to let window appear
		
		// Select current date by css .class, remember to remove any space if class name is combination of 2 class, 
		//class of current date will be unique
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		Thread.sleep(2000);
		
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
		Assert.assertEquals(totalPassenders, "5 Adult");
		
		Thread.sleep(2000);
		
		//Search flights
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		Thread.sleep(2000);
		driver.close();


	}

}
