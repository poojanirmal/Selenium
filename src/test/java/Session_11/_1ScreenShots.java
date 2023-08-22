package Session_11;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _1ScreenShots {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Before
	public void setUp() 
	{
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,15);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void scnCapture()
	{
		WebElement searchBoxEle = driver.findElement(By.xpath("//textarea[@name='q']"));
		searchBoxEle.sendKeys("Selenium WebDriver");
	
		WebElement SearchBtnEle = driver.findElement(By.name("btnK"));
		SearchBtnEle.click();
		
		wait.until(ExpectedConditions.titleContains("Selenium WebDriver"));
		
		String searchFileName = "GoogleSearch";
		
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try 
		{
			FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"\\src\\test\\java\\Session_11\\ScreenShots\\"+searchFileName+".jpg"));
					
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
