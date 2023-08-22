package Session_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class _3IntractByName {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
	    WebElement serachBoxEle	 = driver.findElement(By.name("q"));
	    serachBoxEle.sendKeys("selenium");
		Thread.sleep(2000);
		
		
		WebElement serachBtnEle	 = driver.findElement(By.name("btnK"));
	    serachBtnEle.click();
	    Thread.sleep(2000);
	    
	    System.out.println(driver.getTitle());
		
		driver.quit();
		
	}

}
