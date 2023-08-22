package Session_1;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.opera.OperaDriver;

public class _OperaInvocation {
	
	
	public static void main(String[] args) {
		
		
		
		 WebDriver driver = new OperaDriver();
			
			
			driver.manage().window().maximize();
			
			driver.manage().deleteAllCookies();
			
			driver.get("https://www.amazon.in/");
			
			driver.close();
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
