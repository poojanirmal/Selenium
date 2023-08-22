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
import org.openqa.selenium.interactions.Actions;


public class ToolTip_Hover {

WebDriver driver;
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/tool-tips");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void fileUpload() throws InterruptedException
	{
		
		WebElement hoverMeToSeeEle = driver.findElement(By.id("toolTipButton"));
		
		Actions act = new Actions(driver);
	
		act.moveToElement(hoverMeToSeeEle).release().build().perform();//if we create seprate test case for this two hover me then no need to use  release
		
		WebElement textEle= driver.findElement(By.xpath("//div[text()='You hovered over the Button']"));
		
		System.out.println("The text after hover me is -> "+textEle.getText());
		
		Assert.assertEquals("The text is not matched", "You hovered over the Button",textEle.getText());
		
		Thread.sleep(2000);
		
		WebElement textFieldBoxEle = driver.findElement(By.id("toolTipTextField"));
		
		act.moveToElement(textFieldBoxEle).release().build().perform();
		
		WebElement textFieldEle= driver.findElement(By.xpath("//div[text()='You hovered over the text field']"));
		
		System.out.println("The text after hover me is -> "+textFieldEle.getText());
		
		Assert.assertEquals("The text is not matched", "You hovered over the text field",textFieldEle.getText());
		
		Thread.sleep(2000);
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
