package Session_6;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class AuthenticationPopUpHandling {
	
	WebDriver driver;
	
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.get("https://www.facebook.com/");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Test
    public void AuthPopUp() throws InterruptedException
	{
		String userName = "admin";
		String password = "admin";
		String url = "https://"+userName+":"+password+"@"+"the-internet.herokuapp.com/basic_auth";
        
		driver.get(url);
		
		WebElement afterSignInTextEle = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]"));
	     System.out.println(afterSignInTextEle.getText());
	     
	     Assert.assertEquals("After sign in the text is not matched", "", afterSignInTextEle.getText());
	     
	     
	     
	     
	     
	     
	     
	}
	
	

}
