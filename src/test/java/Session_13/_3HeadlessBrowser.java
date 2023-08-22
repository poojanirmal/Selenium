package Session_13;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _3HeadlessBrowser {
	
	WebDriver driver;
	
	@Before
	public void setUp()
	{
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
//		options.addArguments("--incognito");//open browser in incognito mode
//		options.addArguments("window-size=800,600");//resized the window
		options.addArguments("start-maximized");//maximized the window
//		options.addArguments("ignore-certificate-errors");//bad ssl
//		options.addArguments("--disable-extensions");//some time when we open the browser through automation there is some extension automatically added so for disabling this extension
//     	options.addArguments(new File("file name"));//this used to block the add for this we have to add blocker extension file
//		options.setExperimentalOption("excludedSwitches",new String[]{"enable-automation"});//this is used to delete the line of 'chrome is being controlled by automation testing'.coming after open the url
		driver = new ChromeDriver(options);
		driver.manage().window().maximize(); // it get commented when used window size and also in start maximized
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");//for headless,incognito,window-size,start-maximized,setExperimentalOption
//		driver.get("https://self-signed.badssl.com/");//for ignore-certificate-errors
//		driver.get("https://demo.automationtesting.in/Alerts.html");//for disable-extensions,file extension
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void headless()
	{
		System.out.println(driver.getTitle());
	}
}
