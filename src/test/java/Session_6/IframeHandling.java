package Session_6;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IframeHandling {
	
	
  WebDriver driver;
	
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.automationtesting.in/Frames.html");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Ignore
	@Test
    public void iframeHandling_1() throws InterruptedException
	{
		
		WebElement iframeEle = driver.findElement(By.xpath("//iframe[@id='singleframe']"));
		driver.switchTo().frame(iframeEle);
		
		Thread.sleep(2000);
		
		WebElement iframeTextEle = driver.findElement(By.xpath("//input[@type='text']"));
		iframeTextEle.sendKeys("text text text");
		
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		
		WebElement switchToEle = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
		
	    Actions act = new Actions(driver);
		
		act.moveToElement(switchToEle).build().perform();
		Thread.sleep(2000);
	}

	
	@Test
    public void iframeHandling_2() throws InterruptedException
	{
		
		WebElement iframeWithInAnIframeEle = driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']"));
		iframeWithInAnIframeEle.click();
		
		Thread.sleep(2000);
		
		WebElement nestediframeEle = driver.findElement(By.xpath("//div[@id='Multiple']//iframe"));
		driver.switchTo().frame(nestediframeEle);
		
		WebElement iframeDemoEle = driver.findElement(By.xpath("//div[@class='iframe-container']//iframe"));
		driver.switchTo().frame(iframeDemoEle);
		
		WebElement iframeTextEle = driver.findElement(By.xpath("//input[@type='text']"));
		iframeTextEle.sendKeys("text text text");
		
		Thread.sleep(2000);
		
//		driver.switchTo().parentFrame(); when we need to write something over first frame
//		driver.switchTo().parentFrame(); when we need to switch to original page from first parent frame 
		
		driver.switchTo().defaultContent();// also used when we need to switch to original page from first parent frame 
		
		WebElement switchToEle = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
		
	    Actions act = new Actions(driver);
		
		act.moveToElement(switchToEle).build().perform();
		Thread.sleep(2000);
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
