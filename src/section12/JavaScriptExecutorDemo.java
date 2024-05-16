package section12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo
{

	public static void main(String[] args) throws InterruptedException
	{
		//1. Configure driver
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();

		//2. URL
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//3.Create javascript executor object to have the view of the web-element
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//4.scroll to web element
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
		
		//5.scroll on web element to go to bottom
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		//6. sum all values
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		//7.sum all values
		int actualSum = 0;
		for (int i = 0; i < values.size(); i++)
		{
			actualSum += Integer.parseInt(values.get(i).getText());
		}
		System.out.println(actualSum);
		
		//8. get total amount mentioned/expectedTotal
		String[] totalAmountString = driver.findElement(By.cssSelector(".totalAmount")).getText().split(" ");
		String expectedTotalString = totalAmountString[totalAmountString.length-1];
		int expectedSum = Integer.parseInt(expectedTotalString);
		
		//9. compare actual and expected sum
		Assert.assertEquals(expectedSum, actualSum);
		
		Thread.sleep(3000);
		driver.close();
	}

}
