package Session_4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Index_Xpath {
	
	
	
WebDriver driver;

	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void prodSearch_1() throws InterruptedException
	{
		WebElement SearchBoxEle = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
		SearchBoxEle.sendKeys("pepe jeans");
		
//		                                                           index xpath
		WebElement pepeJeansMenEle = driver.findElement(By.xpath("(//li[@class='desktop-suggestion null'])[2]"));
		pepeJeansMenEle.click();
	
		
		
		
		
		Thread.sleep(2000);

	}

}
