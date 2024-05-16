package section11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class calenderTest
{

	public static void main(String[] args) throws InterruptedException
	{
		//1. Configure driver
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();
		
		//2. Define date
		String month = "6";
		String year = "2027";
		String day = "15";
		String[] expectedDate = {month, day, year};
		
		//3. URL
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//4. Click on date field
		driver.findElement(By.className("react-date-picker__inputGroup")).click();
		
		//5. click on month year
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		
		//6. click on year-displayed
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		
		//7. click on 2027
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		
		//8.click on June
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
		
		//9 click on day
		driver.findElement(By.cssSelector("abbr[aria-label*='"+day+"']")).click();
		
		//10. date selected - this will not work because, the date 6/15/2025 is individually placed in a subclass
//		String dateSelected = driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).getText();
//		System.out.println(dateSelected);
		
		//11. As above method in step 10 will not work, we'd have to select individual sub class
		List<WebElement> actualDate = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		for (int i = 0; i < actualDate.size(); i++)
		{
			System.out.println(actualDate.get(i).getAttribute("value"));
			Assert.assertEquals(actualDate.get(i).getAttribute("value"), expectedDate[i]);
		}
		
		
		
		Thread.sleep(3000);
		driver.close();

	}

}
