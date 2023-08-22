package Session_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1IntractByXPath {
	
public static void main(String args[]) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://demo.automationtesting.in/Register.html");
		
		
		WebElement firstNameEle = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		if(firstNameEle.isDisplayed())
		{
			firstNameEle.sendKeys("Pooja");
		}
		else
		{
			System.out.println("first name box is not displayed to send the keys");
		}
		Thread.sleep(2000);
	
		
		WebElement lastNameEle = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		if(lastNameEle.isDisplayed())
		{
			lastNameEle.sendKeys("Nirmal");
		}
		else
		{
			System.out.println("last name box is not displayed to send the keys");
		}
		Thread.sleep(2000);
	
		WebElement genderEle = driver.findElement(By.xpath("//input[@value='FeMale']"));
		if(genderEle.isEnabled())
		{
			genderEle.click();
		}
		else
		{
			System.out.println("The gender radion button is unabled");
		}
		Thread.sleep(2000);
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
}