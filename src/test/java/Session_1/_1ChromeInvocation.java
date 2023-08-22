package Session_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class _1ChromeInvocation {

	
	public static void main(String[] args)  {
		
		
		
		 WebDriver driver = new ChromeDriver();
			
			
			driver.manage().window().maximize();
			
			driver.manage().deleteAllCookies();
			
			driver.get("https://www.google.com/");
			
			
			String expectedTitle = "Google";
			
			String actualTitle = driver.getTitle();
			
			if(expectedTitle.equals(actualTitle))
			{
				System.out.println("Expected title is matched to actual title");
			}
			else
			{
				System.out.println("Expected title not matched to actual title");
			}
			
			
			
			driver.close();
			
			
}
}