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
import org.openqa.selenium.support.ui.Select;


public class DropDownBySelectMethod {
	
	WebDriver driver;
	
		@Before
		public void setUp()
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.facebook.com/");
		}
		
		@After
		public void tearDown()
		{
			driver.quit();
		}
		
		
		@Test
	    public void dragNDrop_1() throws InterruptedException
		{
		
			WebElement createaccEle = driver.findElement(By.xpath("//a[text()='Create new account']"));
			
			createaccEle.click();
			
			WebElement dayEle = driver.findElement(By.xpath("//select[@id='day']"));
			
			Select day = new Select(dayEle);
			
			day.selectByValue("4");
			

	       WebElement monthEle = driver.findElement(By.xpath("//select[@id='month']"));
			
			Select month = new Select(monthEle);
			
			month.selectByVisibleText("Mar");
			
		
		
		    WebElement yearEle = driver.findElement(By.xpath("//select[@id='year']"));
			
			Select year = new Select(yearEle);
			
			year.selectByIndex(10);
			
			Thread.sleep(2000);
		
		 
		
		
		
		}
		
		
		
		
		
		
		

}
