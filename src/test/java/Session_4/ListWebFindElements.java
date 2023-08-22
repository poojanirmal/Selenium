package Session_4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListWebFindElements {
	
	
WebDriver driver;
String searchProduct = "Pepe Jeans Sweater";

	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void prodSearch_1() throws InterruptedException
	{
		WebElement SearchBoxEle = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
		SearchBoxEle.sendKeys("pepe jeans");
		
		List<WebElement> pepeJeansAllProductEle = driver.findElements(By.xpath("//li[@class='desktop-suggestion null']"));
		
		System.out.println("The serach result count is -> "+pepeJeansAllProductEle.size());
		for(int i = 0;i<pepeJeansAllProductEle.size();i++)
		{
//			System.out.println(pepeJeansAllProductEle.get(i).getText());
			if(pepeJeansAllProductEle.get(i).getText().equals(searchProduct))
			{
				pepeJeansAllProductEle.get(i).click();
				break;
			}
			
		}

	
		Thread.sleep(2000);

	}

	
	
	
	
	
	
	
	
	
	
	

}
