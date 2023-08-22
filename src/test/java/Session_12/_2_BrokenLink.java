package Session_12;

	
	
import java.awt.AWTException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class _2_BrokenLink {
		

		WebDriver driver;
		WebDriverWait wait;
		
		@Before
		public void setUp()
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver,15);
			driver.get("https://www.amazon.in/");
		}
		
		@After
		public void tearDown()
		{
			driver.quit();
		}
		
		@Test
		public void brokenImg()
		{
			
			List<WebElement> linkListEle = driver.findElements(By.tagName("a"));
			
			System.out.println("The total images present in the web page is -> "+linkListEle.size());
			
			for(int i = 0;i<linkListEle.size();i++)
			{
				String hyperSourceLink = linkListEle.get(i).getAttribute("href");
				
	 
			    try 
			    {
//					creating URL
				    URL url =  new URL(hyperSourceLink);
				    
//				    creating a connection with a URL
				   URLConnection urlConnection = url.openConnection();
				   
//				   setting up the connection protocol as HTTP/HTTPS
//				   ex- HttpsURLConnection httpURLConnection = (HttpsURLConnection)urlConnection;
				   
				   HttpURLConnection httpURLConnection = (HttpURLConnection)urlConnection;
				   
//				   stting up timeout connection
				   httpURLConnection.setConnectTimeout(4000);
				   
//				   connecting url with the HTTP protocol
				   httpURLConnection.connect();
				   
//				   validating the response from the URL in the form of HTTP response code
				   if(httpURLConnection.getResponseCode()== 200)
				   {
					   System.out.println("The image source link "+hyperSourceLink+"is -> "+httpURLConnection.getResponseCode());
				   }
				   else
				   {
					   System.out.println("The image source link "+hyperSourceLink+"is -> "+httpURLConnection.getResponseCode());
				   }
				   
//				   disconnect the connection with URL
				   httpURLConnection.disconnect();
				   
		      	} 
			    catch (MalformedURLException e)
			    {
				
				    e.printStackTrace();
				    
			    } 
			    catch (IOException e) 
			    {
			    	System.out.println("some issue with image source link ->"+hyperSourceLink);
			
					e.printStackTrace();
				}
				
			}
			
			
			
		}
	}


