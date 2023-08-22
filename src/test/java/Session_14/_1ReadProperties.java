package Session_14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _1ReadProperties {
	
	WebDriver driver;
	public Properties prop;
	
	@Test
	public void readProperties()
	{
		   
		prop = new Properties();
		
		try 
		{//                                                                          instead of \\ we use /
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Session_14\\configuration.properties");
			prop.load(ip);//loading the file
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("configuration.properties file not found please provide a correct path");
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			System.out.println("IOException occured while loading the configuration.properties file");
			
			e.printStackTrace();
		}
		
//		how to read the values 
//		System.out.println(prop.getProperty("url"));
//		System.out.println(prop.getProperty("browser"));
//		System.out.println(prop.getProperty("userFirstName"));
//		System.out.println(prop.getProperty("maximize"));

		
		if(prop.getProperty("headless").equals("yes"))
		{
			ChromeOptions opt = new ChromeOptions();
			driver = new ChromeDriver(opt);
		}
		else
		{
			driver = new ChromeDriver();
		}
		
		if(prop.getProperty("maximize").equals("yes"))
		{
			driver.manage().window().maximize();
		}
		else if(prop.getProperty("browser").equals("chrome"))
		{
			driver = new ChromeDriver();
		}
//		invoking the browser without downloading driver ..we dont need to download compatable driver browser exe
		if(prop.getProperty("browser").equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();//by using this line, we dont need to download browser  driver and add its extension file in workplace
			driver = new FirefoxDriver();
		}
		else if(prop.getProperty("browser").equals("opera"))
		{
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		System.out.println(driver.getTitle());
		driver.quit();
		
		
		
	}

}
