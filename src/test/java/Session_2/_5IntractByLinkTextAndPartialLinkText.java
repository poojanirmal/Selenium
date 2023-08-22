package Session_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class _5IntractByLinkTextAndPartialLinkText {
	
	public static void main(String args[]) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://dzone.com/articles/find-elements-with-link-text-amp-partial-link-text");
		
		WebElement idLocatorLinkEle = driver.findElement(By.linkText("ID locator in Selenium"));
		System.out.println("the text of this page is -> "+idLocatorLinkEle.getText());
		idLocatorLinkEle.click();
		Thread.sleep(2000);
		
		WebElement classNameLocatorLinkEle = driver.findElement(By.partialLinkText("Class Name locator in"));
		System.out.println("The text for the link over the page is -> "+classNameLocatorLinkEle.getText());
		classNameLocatorLinkEle.click();
		Thread.sleep(2000);
		
		driver.quit();
	}

}
