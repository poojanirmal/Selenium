package Session_13;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1ResizeWindow {
	
	WebDriver driver;
	
	@Before
	public void setUp()
	{
//		To resize the browser window to particular dimension, we use 'Dimension' class to resize the browser window
//		create object of dimension class
		
		Dimension d = new Dimension(800,800);
        driver = new ChromeDriver();
//		resize the current window to the given dimension
        driver.manage().window().setSize(d);
//		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
	}

	@After
	public void teatDown()
	{
		driver.quit();
	}
	
	@Test
	public void resizeCode()
	{
		System.out.println(driver.getTitle());
	}
}
