package Session_10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class _2webTableCheckBoxHandling {
	
	WebDriver driver;
	WebDriverWait wait;
	
	String userName = "Koushik";
	
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
	public void userNameWithCheckBoxSelect()
	{
//		no  need to used try catch block used for handling exception
		try
		{
		WebElement letsHandleItTable = driver.findElement(By.xpath("//table[@id='simpletable']"));
		wait.until(ExpectedConditions.visibilityOf(letsHandleItTable));
		
		WebElement kaushikPresentEle = driver.findElement(By.xpath("//td[text()='"+userName+"']//parent::tr//td/input[@type='checkbox']"));
		
		//td[text()='"+userName+"']//parent::tr//td[4]unabled to select
		//td[text()='Koushik']//following-sibling::td[3] unable to select
     	
		kaushikPresentEle.click();
		Assert.assertTrue(kaushikPresentEle.isSelected());
		
//		we can also used assertion like this
//		if(kaushikPresentEle.isSelected())
//		{
//		
//			Assert.assertTrue(kaushikPresentEle.isSelected());
//			System.out.println("The test case get passed");
//		}
//		else
//		{
//			
//			System.out.println("The test case get failed");
//		}
		}
		catch(Exception e)
		{
			Assert.assertTrue(false);
		}
		
		
		
		
	}
			

}
