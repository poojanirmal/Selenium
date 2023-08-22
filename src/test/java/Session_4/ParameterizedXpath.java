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

public class ParameterizedXpath {

	
	
WebDriver driver;
String searchProduct = "Pepe Jeans Girls";
	
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
		
		
		WebElement pepeJeansGirlEle = driver.findElement(By.xpath("//li[text()='"+searchProduct+"']"));
		pepeJeansGirlEle.click();
		
		
		WebElement pepeJeansGirlsTextEle = driver.findElement(By.xpath("//h1[@class='title-title']"));
		Assert.assertEquals("The text is not matched to actual text", searchProduct, pepeJeansGirlsTextEle.getText());
		
		Thread.sleep(2000);

	}
	
	
	}
