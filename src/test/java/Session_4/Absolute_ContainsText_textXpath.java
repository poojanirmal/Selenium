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



public class Absolute_ContainsText_textXpath {
	
	WebDriver driver;
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void prodSearch_1()
	{
//		                                                             Absolute xpath coping full xpath as it is and paste over here
		WebElement SearchBoxElement = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input"));
		SearchBoxElement.sendKeys("iphone");
		
		WebElement SearchBtnElement = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[3]/div/span/input"));
		SearchBtnElement.click();
		
//		                                                           parent having class attribute and its value                 contain text xpath
		WebElement iphonetextEle = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[contains(text(),'iphone')]"));
		String actualText = iphonetextEle.getText();
		String expextedText = "\"iphone\"";//"iphone"-iphone and "\"iphone\""-"iphone" actual text is "iphone"
		
		Assert.assertEquals("This text not matched to actual text",expextedText, actualText);
	}
	
	
	@Test
	public void prodSearch_2()
	{
//		                                                            Relative xpath programmer create it
		WebElement SearchBoxElement = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		SearchBoxElement.sendKeys("pixel");
		
		WebElement SearchBtnElement = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		SearchBtnElement.click();
		
//		                                                               text() xpath
		WebElement iphonetextEle = driver.findElement(By.xpath("//span[text()='\"pixel\"']"));
		String actualText = iphonetextEle.getText();
		String expextedText = "\"pixel\"";//"iphone"-iphone and "\"iphone\""-"iphone" actual text is "iphone"
		
		Assert.assertEquals("This text not matched to actual text",expextedText, actualText);
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
