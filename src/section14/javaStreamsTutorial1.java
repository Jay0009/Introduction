package section14;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javaStreamsTutorial1
{
	public static void main(String[] args) throws InterruptedException
	{
		// 1. Configure driver
		System.setProperty("webdriver.chome.driver",
				"/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();

		// 2. url
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.xpath("//tr/th[1]")).click();

		// scan the name column with getText ->Rice -> print the price of Rice
		// 3. click on the itemsList

		List<String> price;
		do
		{
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());

			price.forEach(s -> System.out.println(s));

			if (price.size() < 1)
			{
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}

		} while (price.size() < 1);
		Thread.sleep(3000);
		driver.close();

	}

	private static String getPriceVeggie(WebElement s)
	{
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}

}
