package Session_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class _6IntractByCssSelector {
	
	public static void main(String args[]) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
//		                                                            tab.class value
	   WebElement searchBoxEle = driver.findElement(By.cssSelector("textarea.gLFyf"));
	   searchBoxEle.sendKeys("Automatio Testing"+Keys.ENTER);// we can also used it without finding  search btn web element
	   Thread.sleep(2000);
	   
//	                                                                tab[name=its value]
//	   WebElement searchBtnEle = driver.findElement(By.cssSelector("input[name=btnK]"));
//	   searchBtnEle.click();
	   Thread.sleep(2000);
	   
		System.out.println("The page title after clicking the searh button is -> "+driver.getTitle());
		driver.quit();
		
	}

}
