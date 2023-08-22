package Session_5;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragNDropIn_Iframe {
	
	WebDriver driver;
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void dragNDrop() throws InterruptedException
	{
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		WebElement dropMeMyTargetEle = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		WebElement dropHereEle = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions act = new Actions(driver);
	
		act.dragAndDrop(dropMeMyTargetEle, dropHereEle).build().perform();
		
        Thread.sleep(2000);
		
		WebElement droppedTextEle = driver.findElement(By.xpath("//p[text()='Dropped!']"));
		
		String expectedText = "Dropped!";
		
		Assert.assertEquals("The text is mathched to actual text", expectedText, droppedTextEle.getText());
		
		Thread.sleep(2000);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			

}
