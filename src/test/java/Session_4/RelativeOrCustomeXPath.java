package Session_4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class RelativeOrCustomeXPath {
	
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
	public void prodSearch_1() throws InterruptedException
	{
		WebElement searchBoxEle = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));//this is relative xpath
		
//		WebElement searchBoxEle = driver.findElement(By.xpath("//html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input")); by coping
//		full xpath its called absolute xpath but its not used

		 searchBoxEle.sendKeys("iphone"+Keys.ENTER);
		 
		 String expectedTitle = "Amazon.in : iphone";
		 Assert.assertEquals("The title is not matched", expectedTitle, driver.getTitle());
		 Thread.sleep(2000);
	}
	
	@Test
	public void prodSearch_2() throws InterruptedException
	{
		WebElement searchBoxEle = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		 searchBoxEle.sendKeys("pixel"+Keys.ENTER);
		 
		 String expectedTitle = "Amazon.in : pixel";
		 Assert.assertEquals("The title is not matched", expectedTitle, driver.getTitle());
		 Thread.sleep(2000);
	}
	
	
	
	
	
	
	

}
