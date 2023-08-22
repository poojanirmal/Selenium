package Session_6;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class AlertHandling {
	
	WebDriver driver;
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.automationtesting.in/Alerts.html");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Ignore
	@Test
    public void AlertHandling_1() throws InterruptedException
	{
	     WebElement displayAlertBoxEle = driver.findElement(By.xpath(" //button[contains(text(),'click the button to display an  alert box:')]"));
	     displayAlertBoxEle.click();
	     
	     Thread.sleep(2000);
	      
	     Alert alert = driver.switchTo().alert();
	     
	     
	     System.out.println("After clicking the alert display button the text is -> "+alert.getText());
	     
	     Assert.assertEquals("After clicking the alert display button the text is not matched","I am an alert box!",alert.getText());
	     
	     alert.accept();
	     
	}

	@Ignore
	@Test
    public void AlertHandling_2() throws InterruptedException
    {
    	WebElement alertWithOkNCancelEle = driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']"));
    	alertWithOkNCancelEle.click() ;
    	
    	WebElement displayConfirmBoxEle = driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box')]"));
    	displayConfirmBoxEle.click() ;
    	
    	Thread.sleep(2000);
    	
        Alert alert = driver.switchTo().alert();
    	
    	alert.accept();
    	
    	WebElement afterAlertAcceptEle = driver.findElement(By.xpath(" //p[text()='You pressed Ok']"));
    	
    	System.out.println(afterAlertAcceptEle.getText());
    	
    	Assert.assertEquals("After alert accept the text is not matched", "You pressed Ok", afterAlertAcceptEle.getText());
    	
    }
    
    @Ignore
    @Test
    public void AlertHandling_3() throws InterruptedException
    {
    	WebElement alertWithOkNCancelEle = driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']"));
    	alertWithOkNCancelEle.click() ;
    	
    	WebElement displayConfirmBoxEle = driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box')]"));
    	displayConfirmBoxEle.click() ;
    	
    	Thread.sleep(2000);
    	
        Alert alert = driver.switchTo().alert();
    	
    	alert.dismiss();
    	
    	WebElement afterAlertAcceptEle = driver.findElement(By.xpath(" //p[text()='You Pressed Cancel']"));
    	
    	System.out.println(afterAlertAcceptEle.getText());
    	
    	Assert.assertEquals("After alert accept the text is not matched", "You Pressed Cancel", afterAlertAcceptEle.getText());
    	
    }
  
	
    @Test
    public void AlertHandling_4() throws InterruptedException
    {
    	String userName = "Pooja";
    	WebElement alertWithTextBoxEle = driver.findElement(By.xpath("//a[text()='Alert with Textbox ']"));
    	alertWithTextBoxEle.click() ;
    	
    	WebElement promptBoxEle = driver.findElement(By.xpath(" //button[text()='click the button to demonstrate the prompt box ']"));
    	promptBoxEle.click() ;
    	
    	Thread.sleep(2000);
    	
        Alert alert = driver.switchTo().alert();
    	
    	alert.sendKeys(userName);
    	alert.accept();
    	
    	WebElement afterAlertAcceptEle = driver.findElement(By.xpath("  //p[text()='Hello "+userName+" How are you today']"));
    	
    	System.out.println(afterAlertAcceptEle.getText());
    	
    	Assert.assertEquals("After alert accept the text is not matched", "Hello "+userName+" How are you today", afterAlertAcceptEle.getText());
    	
    }
	
	
	
	
	
	
	
	
	
}
