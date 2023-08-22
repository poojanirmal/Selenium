package Session_7;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class FileUpload {
	
	
	WebDriver driver;
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void fileUpload() throws InterruptedException
	{
		
		WebElement chooseFileEle = driver.findElement(By.xpath("//input[@type='file']"));
		
		chooseFileEle.sendKeys("G:\\My Drive\\Emailing sodapdf-converted (1).pdf");//here we used the path because if click on that 
//		button other window get popup  and we lost our control over browser 
		
		Thread.sleep(2000);
		
		WebElement pressEle = driver.findElement(By.xpath("//input[@type='submit']"));
		pressEle.click();
		
		
		WebElement FileUploadTextEle = driver.findElement(By.xpath("//h1[contains(text(),'cgi-lib.pl: Request to receive too much data: 180904 bytes')]"));
		System.out.println("After file uploading the text over file is -> "+FileUploadTextEle.getText());
		
		Assert.assertEquals("The file is uploaded unsuccessfully", "cgi-lib.pl: Request to receive too much data: 180904 bytes", FileUploadTextEle.getText());
		Thread.sleep(2000);
		
		
		
		
		
	}

}
