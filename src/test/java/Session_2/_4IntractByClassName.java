package Session_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _4IntractByClassName {
	
public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://zero.webappsecurity.com/");
	
	   WebElement searchBtnEle = driver.findElement(By.className("btn"));
	   searchBtnEle.click();
	Thread.sleep(2000);
	
	
	WebElement loginBoxEle = driver.findElement(By.id("user_login"));
	loginBoxEle.sendKeys("username");
	Thread.sleep(2000);
	
	
	WebElement passwordBoxEle = driver.findElement(By.id("user_password"));
	passwordBoxEle.sendKeys("password");
	Thread.sleep(2000);
	
	

	   WebElement signInBtnEle = driver.findElement(By.className("btn-primary"));
	   signInBtnEle.click();
	Thread.sleep(2000);
	

}
}