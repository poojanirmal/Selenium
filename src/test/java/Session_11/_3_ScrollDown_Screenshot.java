package Session_11;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class _3_ScrollDown_Screenshot {
	

	WebDriver driver;
	WebDriverWait wait;
//	JavascriptExecutor JavasriptExecutor;
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,15);
		driver.get("https://www.google.com/");
	
		
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}

	@Test
	public void scnCApture()
	{
		
		WebElement searchBoxEle = driver.findElement(By.name("q"));
		searchBoxEle.sendKeys("Selenium WebDriver");
		
		WebElement searchBtnEle = driver.findElement(By.name("btnK"));
		searchBtnEle.click();
		
		wait.until(ExpectedConditions.titleContains("Selenium WebDriver"));
		
         JavascriptExecutor js =	((JavascriptExecutor)driver);
         js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		ssCapture(driver,"Selenium WebDriver");
		
	}
		
		
		public static void ssCapture(WebDriver driver,String searchFileName)
		{

		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		
		try {
			FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"\\src\\test\\java\\Session_11\\ScreenShots\\"+searchFileName+".jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		}
		
	
	
	
	
	
	
	
	

}
