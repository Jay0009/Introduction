package section14;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaStreamTutorial
{
	public static void main(String[] args) throws InterruptedException
	{
		//1. Configure driver
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();
		
		//2. url
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//3. Click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//4. Capture all elements into list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		
		//5. Capture text of all elements into new(original) list
		List<String> originaList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
		
		//6. Sort on the original list
		List<String> sortedList = originaList.stream().sorted().collect(Collectors.toList());
		
		//7. Compare original list and sorted list
		Assert.assertTrue(originaList.equals(sortedList));
		
		Thread.sleep(2000);
		driver.close();

	}
}
