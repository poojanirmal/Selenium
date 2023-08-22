package Session_5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownByListWEbElement {
	
	WebDriver driver;
	String day = "19";
	String month = "Jul";
	String year = "1994";
	
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
		
//	    select method work when select tag is available when select tag not available list web element used
		
//		for day
		List<WebElement> dayEle = driver.findElements(By.xpath("//select[@id='day']/option"));
		
		for(int i=0; i<dayEle.size(); i++)
		{
			if(dayEle.get(i).getText().equals(day))
			{
				dayEle.get(i).click();
				break;
			}
		}
		
//		for month
       List<WebElement> monthEle = driver.findElements(By.xpath("//select[@id='month']/option"));
		
		for(int i=0; i<monthEle.size(); i++)
		{
			if(monthEle.get(i).getText().equals(month))
			{
				monthEle.get(i).click();
				break;
			}
		}
		
//		for year
		
       List<WebElement> yearEle = driver.findElements(By.xpath("//select[@id='year']/option"));
		
		for(int i=0; i<yearEle.size(); i++)
		{
			if(yearEle.get(i).getText().equals(year))
			{
				yearEle.get(i).click();
				break;
			}
		}
		
		
		Thread.sleep(2000);
		
		
			
		
	}

}
