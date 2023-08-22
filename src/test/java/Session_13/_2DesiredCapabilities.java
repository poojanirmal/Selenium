package Session_13;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class _2DesiredCapabilities {
	
	WebDriver driver;
	
	@Before
	public void setUp()
	{
//		Bypass the bad ssl page or insecure certificate error ssl page
		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setAcceptInsecureCerts(true); used this line or below line meaning of the both line is same.
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		driver = new ChromeDriver(cap);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://self-signed.badssl.com/");
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void synchronisationToolTip()
	{
		System.out.println(driver.getTitle());
	}
}
