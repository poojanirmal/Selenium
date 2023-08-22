package Session_5;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class DragNDrop {
	
	WebDriver driver;
	
	@Before
	public void setUp()
	{
//		This line is used to for new  chrome driver speacially used  for testing
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\eclipse-workspace\\Selenium\\chromedriver.exe");
//		ChromeOptions opt = new ChromeOptions();
//		opt.setBinary("C:\\Users\\User\\eclipse-workspace\\chrome-win64\\chrome-win64\\chrome.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/droppable/");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Ignore
	@Test
	public void dropDown_1() throws InterruptedException
	{
		
		WebElement dragMeEle = driver.findElement(By.xpath("//div[text()='Drag me']"));
		
		WebElement dropMeEle = driver.findElement(By.xpath("//div[@id='simpleDropContainer']/div[@id='droppable']"));
		
		
		Actions act = new Actions(driver);
		
        act.dragAndDrop(dragMeEle, dropMeEle).build().perform();//new method 
		
		Thread.sleep(2000);
		
		WebElement droppedTextEle = driver.findElement(By.xpath("//p[text()='Dropped!']"));
		
		String expectedText = "Dropped!";
		
		Assert.assertEquals("The text is mathched to actual text", expectedText, droppedTextEle.getText());
		
		Thread.sleep(2000);
		
		
		
	}
	
	
	@Test
	public void dropDown_2() throws InterruptedException
	{
		
        WebElement dragMeEle = driver.findElement(By.xpath("//div[text()='Drag me']"));
		
		WebElement dropMeEle = driver.findElement(By.xpath("//div[@id='simpleDropContainer']/div[@id='droppable']"));
		
		Actions act = new Actions(driver);
		
		act.clickAndHold(dragMeEle).moveToElement(dropMeEle).release(dragMeEle).build().perform();//old method
		
        Thread.sleep(2000);
		
		WebElement droppedTextEle = driver.findElement(By.xpath("//p[text()='Dropped!']"));
		
		String expectedText = "Dropped!";
		
		Assert.assertEquals("The text is mathched to actual text", expectedText, droppedTextEle.getText());
		
		Thread.sleep(2000);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
