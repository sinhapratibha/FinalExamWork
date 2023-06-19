package variousConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task2 {

	WebDriver driver;
	
	//Storing WebElement
	
		By addEntry = By.cssSelector("name=data");
		By addButton = By.cssSelector("input[name=submit][value=Add]");
		By addCategoryEntry = By.cssSelector("[name=categorydata]");
		By addCategoryButton = By.cssSelector("input[name='submit'][value='Add category']");
		
	//Data for testing
		
		String firstCategory = "TestNG913";
		
	@BeforeMethod
	
	public void init()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Pratibha\\PS-Selenium-eclipse-workspace\\session5_testNG\\driver\\chromedriver5.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/test/101/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test
	
	public void addCategoryTest() throws InterruptedException
	{
		//validate that a user should be able to add a new category and it should be displayed
		
		//driver.findElement(addEntry).sendKeys(firstCategory);
		//Thread.sleep(2000);
		//driver.findElement(addButton).click();
		
		//validate that a user has not added a duplicate category and an error message is displayed if it has happend
		
		driver.findElement(addCategoryEntry).sendKeys(firstCategory);
		Thread.sleep(2000);
		driver.findElement(addCategoryButton).click();
		
		//validate the month dropdown has all the months
		
		WebElement monthDropdown = driver.findElement(By.cssSelector("[name=due_month]"));
		Select month_dd = new Select(monthDropdown);
		List<WebElement>month_list=month_dd.getOptions();
		for(WebElement ele:month_list)
		{
			String month_name=ele.getText();
			System.out.println("Months are ="+month_name);
		}
	}
}
