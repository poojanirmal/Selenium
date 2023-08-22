package Session_9;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class _2FontSizeOfCreateAccEle {
	
	WebDriver driver;
	
	WebDriverWait wait;
	
	String expectedFontSize = "17px";
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,15);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
	}
	
	@After
	public void teatDown()
	{
		driver.quit();
	}
	
	@Test
	public void fontSize()
	{
		WebElement fontSizeOfCreateAccEle = driver.findElement(By.xpath("//a[text()='Create new account']"));
		wait.until(ExpectedConditions.visibilityOf(fontSizeOfCreateAccEle));
		
		System.out.println("The font size of create account text is -> "+fontSizeOfCreateAccEle.getCssValue("font-size"));
		
		Assert.assertEquals("The font of text is not matched", expectedFontSize,fontSizeOfCreateAccEle.getCssValue("font-size"));
		
		System.out.println("Test for font size get passed");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
