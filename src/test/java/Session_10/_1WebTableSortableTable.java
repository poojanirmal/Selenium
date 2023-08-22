package Session_10;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _1WebTableSortableTable {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Before
	public void setUp() 
	{
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,15);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://letcode.in/table");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void printAllValue()
	{
		
	}

}
