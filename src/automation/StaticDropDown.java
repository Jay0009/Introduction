package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown
{

	public static void main(String[] args) throws InterruptedException
	{
		//Invoke chrome browser
		System.setProperty("webdriver.chome.driver", "/Users/jay/Desktop/VdemiCourse/driver/chrome-mac-arm64/Google Chrome for Testing.app");
		WebDriver driver = new ChromeDriver();
		
		//get URL
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		//Drop down with select tag
		Select dropdown = new Select(staticDropdown);
		
		//Select by index
		dropdown.selectByIndex(3);
		String indexCurrency = dropdown.getFirstSelectedOption().getText();
		System.out.println(indexCurrency);
		
		//Select by visible-text
		dropdown.selectByVisibleText("AED");
		String visibleCurrency = dropdown.getFirstSelectedOption().getText();
		System.out.println(visibleCurrency);
		
		//Select by value
		dropdown.selectByValue("INR");
		String valueCurrency = dropdown.getFirstSelectedOption().getText();
		System.out.println(valueCurrency);
		
		Thread.sleep(2000);
		
		driver.close();
		
		

	}

}
