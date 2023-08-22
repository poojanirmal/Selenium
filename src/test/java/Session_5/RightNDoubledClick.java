package Session_5;

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

public class RightNDoubledClick {

WebDriver driver;

String menuText = "Edit";
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Ignore
	@Test
	public void dragNDrop() throws InterruptedException
	{
		
		WebElement rightClickEle = driver.findElement(By.xpath("//span[text()='right click me']"));
		
		Actions act = new Actions(driver);
		
		act.contextClick(rightClickEle).build().perform();
		
		Thread.sleep(2000);
		
//		                                                                      parameterized xpath
		WebElement menuTextEle = driver.findElement(By.xpath("//span[text()='"+menuText+"']"));
		
		menuTextEle.click();
		
		Thread.sleep(2000);
		
	 }
	
	@Test
	public void doubledClick() throws InterruptedException
	{
		
        WebElement doubledClickEle = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		
		Actions act = new Actions(driver);
		
		act.doubleClick(doubledClickEle).build().perform();
		
		Thread.sleep(2000);
		
		
		
	}
	

	
}
