package Session_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class _2IntractByID {
	
	public static void main(String args[]) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		
		if(expectedTitle.equals(driver.getTitle()))
		{
			System.out.println("page title is as expected");
		}
		else
		{
			System.out.println("page title is as expected");
		}
		
		Thread.sleep(2000);
		
		
		
	    WebElement searchBoxEle	 = driver.findElement(By.id("twotabsearchtextbox"));
	    searchBoxEle.sendKeys("Dress Material");
	    Thread.sleep(2000);
		
		
	    WebElement searchButnEle	 = driver.findElement(By.id("nav-search-submit-button"));
	    searchButnEle.click();
	    Thread.sleep(2000);
		
//		driver.getTitle();
		System.out.println(driver.getTitle());
		
		
		
		
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
