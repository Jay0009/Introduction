package section10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveFrames
{

	public static void main(String[] args) throws InterruptedException
	{
		//1. Configure driver
		System.setProperty("webdriver.gecko.driver", "//Users/jay/Desktop/VdemiCourse/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		//2. URL
		driver.get("https://jqueryui.com/droppable/");
		
		//3.switch to frame - find by id
//		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		
		//3.1 find by index
		List<WebElement> iFrames = driver.findElements(By.tagName("iframe"));
		System.out.println(iFrames.size());
		driver.switchTo().frame(0);
		
		//4. drag and drop
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		driver.close();
		
		
		
	}

}
