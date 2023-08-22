package Session_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2FormFillingByXPath {
	
public static void main(String args[]) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://demo.automationtesting.in/Register.html");
		
		WebElement firstNameEle = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstNameEle.sendKeys("Pooja");
		
		WebElement lastNameEle = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		lastNameEle.sendKeys("Nirmal");
		
		WebElement addressEle = driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
		addressEle.sendKeys("vidyanagar colony,Loni");
		
		WebElement emailEle = driver.findElement(By.xpath("//input[@type='email']"));
		emailEle.sendKeys("nirmalpooja0597@gmail.com");
		
		WebElement phoneNumberEle = driver.findElement(By.xpath("//input[@type='tel']"));
		phoneNumberEle.sendKeys("9518763476");
		
		WebElement genderEle = driver.findElement(By.xpath("//input[@value='FeMale']"));
		genderEle.click();
		
		WebElement cricketHobbyRadioEle = driver.findElement(By.xpath("//input[@value='Cricket']"));
		
		if(cricketHobbyRadioEle.isEnabled())
		{
			cricketHobbyRadioEle.click();
			if(cricketHobbyRadioEle.isSelected())
			{
				System.out.println("The hobby radio button is selected");
			}
			else
			{
				System.out.println("The hobby radio button is not selected");
			}
		}
		else
		{
			System.out.println("The hobby radio button is unabled");
		}
		
		
		WebElement passwordEle = driver.findElement(By.xpath("//input[@id='firstpassword']"));
		passwordEle.sendKeys("Raja@0597");
		
		WebElement confirmPasswordEle = driver.findElement(By.xpath("//input[@id='secondpassword']"));
		confirmPasswordEle.sendKeys("Raja@0597");
		
		WebElement submitbtnEle = driver.findElement(By.xpath("//button[@id='submitbtn']"));
		submitbtnEle.click();
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		

}
}