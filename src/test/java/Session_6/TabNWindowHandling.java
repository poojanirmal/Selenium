package Session_6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabNWindowHandling {
	

	  WebDriver driver;
		
		
		@Before
		public void setUp()
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://demoqa.com/browser-windows");
		}
		
		@After
		public void tearDown()
		{
			driver.quit();//quit - it is used to closed the entire tab which open 
			          
//		    driver .close(); - it is used to close that perticular tab other tab is still remain open u have to close it manually
		}
		
		@Ignore
		@Test
	    public void tabHandling_1() throws InterruptedException
		{
			System.out.println("The page title is - "+driver.getTitle());
			WebElement newTabEle = driver.findElement(By.xpath("//button[@id='tabButton']"));
			newTabEle.click();
			
			Set<String> handles = driver.getWindowHandles();//it does not required index value,array arraylist having index value
			
			Iterator<String> it = handles.iterator();
			
			String parentWindowId = it.next();
			String childWindowId = it.next();
		    
			System.out.println("parent tab id is -"+parentWindowId);
			System.out.println("child tab id is - "+childWindowId);
			
			driver.switchTo().window(childWindowId);
			

			WebElement nextTabTextEle = driver.findElement(By.xpath("//h1[text()='This is a sample page']"));
			System.out.println(nextTabTextEle.getText());
			
			Thread.sleep(2000);
			
//			driver.close(); it will close the child tab but but parent tab still running and it will print the title 
//			driver.close(); it will close the all tab and not print title showing exception on junit
			
			driver.switchTo().window(parentWindowId);
			System.out.println("The page title is - "+driver.getTitle());
			
			
		}

		@Ignore
		@Test
		public void newTab_2() throws InterruptedException
		{
			
			
			
			System.out.println("The page title is - "+driver.getTitle());
			WebElement newTabEle = driver.findElement(By.xpath("//button[@id='tabButton']"));
			newTabEle.click();
			
			ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles());// can also used
			
			
			
			String parentWindowId = handles.get(0);
			String childWindowId = handles.get(1);
		    
			System.out.println("parent tab id is -"+parentWindowId);
			System.out.println("child tab id is - "+childWindowId);
			
			driver.switchTo().window(childWindowId);
			

			WebElement nextTabTextEle = driver.findElement(By.xpath("//h1[text()='This is a sample page']"));
			System.out.println(nextTabTextEle.getText());
			
			Thread.sleep(2000);
			

			
			driver.switchTo().window(parentWindowId);
			System.out.println("The page title is - "+driver.getTitle());
			
			
			
			
			
		}
		
		@Ignore
		@Test
		public void newWindow() throws InterruptedException
		{
			
		 WebElement newWindowEle = driver.findElement(By.xpath("//button[@id='windowButton']"));
		 newWindowEle.click();	
			
			Set<String> handles = driver.getWindowHandles();
			
			Iterator<String> it = handles.iterator();
			
			String parentWindow = it.next();
			String childWindow = it.next();
			
			driver.switchTo().window(childWindow);
			
			WebElement nextWindowTextEle = driver.findElement(By.xpath("//h1[text()='This is a sample page']"));
			System.out.println(nextWindowTextEle.getText());
			
			Thread.sleep(2000);
			
			driver.switchTo().window(parentWindow);
			System.out.println("The title of parent window is - "+driver.getTitle());
			Thread.sleep(2000);
		}
		
		
		@Test
		public void newWindowMessage() throws InterruptedException
		{
			
		 WebElement newWindowMessageEle = driver.findElement(By.xpath("//button[@id='messageWindowButton']"));
		 newWindowMessageEle.click();	
			
			Set<String> handles = driver.getWindowHandles();
			
			Iterator<String> it = handles.iterator();
			
			String parentWindow = it.next();
			String childWindow = it.next();
			
			driver.switchTo().window(childWindow);
			
			WebElement nextWindowTextEle = driver.findElement(By.xpath("//body[contains(text(),'Knowledge increases by sharing but not by saving.')]"));
			System.out.println(nextWindowTextEle.getText());
			
			Thread.sleep(2000);
			
			driver.switchTo().window(parentWindow);
			System.out.println("The title of parent window is - "+driver.getTitle());
			Thread.sleep(2000);
		}
		
		
		
		
		
		
		
		
		
		
		
		
}
