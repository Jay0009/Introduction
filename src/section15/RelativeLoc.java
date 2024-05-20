package section15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//4 import this manually as static packages cannot be auto imported
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLoc
{

	public static void main(String[] args) throws InterruptedException
	{
		// 1. Configure driver
		System.setProperty("webdriver.chome.driver",
				"/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();
		
		//2. url
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//3.above
		//find element above nameEditBox
		WebElement nameEditbox = driver.findElement(By.name("name"));
		String tagNameAboveNameEditBox = driver.findElement(with(By.tagName("label")).above(nameEditbox)).getText();
		System.out.println(tagNameAboveNameEditBox);
		
		//4 below
		//find element below DOB. 
		//As it is a flex element, we will not be able to locate it by relative locators.
		//flex element cannot be located as yet in relative locators
		WebElement dobLabel = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dobLabel)).click();
		
		//5.toLeftOf
		//click on the checkbox on the left of label- "Check me out if you love icecream"
		WebElement checkBoxLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBoxLabel)).click();
		
		//6. toRightOf
		//find element toRightOf student checkbox and getText
		WebElement studentRadioButton = driver.findElement(By.id("inlineRadio1"));
		String radioButtonLabel = driver.findElement(with(By.tagName("label")).toRightOf(studentRadioButton)).getText();
		System.out.println(radioButtonLabel);
		
		Thread.sleep(2000);
		driver.close();
	}

}
