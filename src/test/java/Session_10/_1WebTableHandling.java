package Session_10;


import java.util.List;
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



public class _1WebTableHandling {
	
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
	public void shoplist()
	{
		WebElement shoppingTable = driver.findElement(By.xpath("//table[@id='shopping']"));
		wait.until(ExpectedConditions.visibilityOf(shoppingTable));
		
		List<WebElement> AdiitionOfprice = driver.findElements(By.xpath("//table[@id='shopping']//tbody//tr/td[2]"));
		
		WebElement totalPrice = driver.findElement(By.xpath("//table[@id='shopping']//tfoot/td[2]"));
		
		int sum = 0;
		
		for (int i = 0; i < AdiitionOfprice.size(); i++) 
		{
			
			System.out.println((i+1)+"."+AdiitionOfprice.get(i).getText());
			
			sum += Integer.parseInt(AdiitionOfprice.get(i).getText());
		}
		
        int finalPrice = Integer.parseInt(totalPrice.getText());
        
      	Assert.assertEquals(finalPrice, sum);
        
//		Assertion in other way
//        
//        if(sum == finalPrice)
//        {
//        	Assert.assertTrue(true);
//        	System.out.println("The test case get passed");
//        }
//        else
//        {
//        	Assert.assertTrue(false);
//        }
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
