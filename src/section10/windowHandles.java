package section10;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class windowHandles
{
	public static void main(String[] args) throws InterruptedException
	{
		//1. Configure driver
		System.setProperty("webdriver.gecko.driver", "//Users/jay/Desktop/VdemiCourse/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		
		//2. URL
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		//3. click on blinking text
		driver.findElement(By.className("blinkingText")).click();
		
		//4. get ID if all the window opened by automation
		Set<String> windows = driver.getWindowHandles(); //[parent id, child id]
		
		//6. get the id of windows using iterator
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childID = it.next();
		
		//5. switch to child id to get the email to sign up
		driver.switchTo().window(childID);
		
		//7. Explicit wait until element appears as it is taking time
		WebDriverWait w = new  WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.im-para.red")));
		
		//8. paste email for validation
		String email = driver.findElement(By.cssSelector("p.im-para.red")).getText().split(" ")[4];
		System.out.println(email);
		
		//9. switch back to parent id
		driver.switchTo().window(parentWindow);
		
		//10. paste email in username in parent window
		driver.findElement(By.id("username")).sendKeys(email);
		
		//
		
		Thread.sleep(3000);
		driver.quit();
	}
}
