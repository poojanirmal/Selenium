package Session_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class _1NavigationCommands {
	
	public static void main(String args[]) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		
		System.out.println("page title is : "+driver.getTitle());
		
		driver.navigate().to("https://www.facebook.com/");
		
		System.out.println("page title is after navigating to new URL : "+driver.getTitle());
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		
		System.out.println("page title is after navigating to previous page URL : "+driver.getTitle());
		Thread.sleep(2000);
		
		driver.navigate().forward();
		System.out.println("page title is after navigating forward to the URL : "+driver.getTitle());
		Thread.sleep(2000);
		
		driver.quit();
		
		
		
		
		
		
	}
	
	

}
