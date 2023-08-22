package Session_9;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class _1ValidateColourOfLogInElement {
	
	
	WebDriver driver;
	
	WebDriverWait wait;
	
	String logInBtnrgbColor = "rgba(24, 119, 242, 1)";
	String createAccrgbColor = "rgba(66, 183, 42, 1)";
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
	    wait = new WebDriverWait(driver,15);
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get("https://www.facebook.com/");
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Ignore
	@Test
	public void logInBtnColorValidation()
	{
		
		WebElement logInBtn = driver.findElement(By.xpath("//button[text()='Log in']"));
		
		wait.until(ExpectedConditions.visibilityOf(logInBtn));
		
		System.out.println("The \"Login\" Button color is -> "+logInBtn.getCssValue("background-color"));
		
		String ActualLogInBtnRgbColor = logInBtn.getCssValue("background-color");//this line for getting rgb value
		                                                     //this background-color from style after inspecting
		
		System.out.println("The conversion of RGB color to HEX color is -> "+rgbToHexValue(ActualLogInBtnRgbColor));
		                                                                     //this method we created
		
		Assert.assertEquals("The color is not matching",logInBtnrgbColor,rgbToHexValue(ActualLogInBtnRgbColor) );
		
		System.out.println("Test for colour of Login btn element get passed.");
		
	}
	
	/**
	 * This method is convert RGB value to  its Hex value
	 * @param rgbValue
	 * @return String Hex value
	 */
	
	public static String rgbToHexValue(String rgbValue)
	{
		Color.fromString(rgbValue).asHex();
		return rgbValue;//this is give the HEX value
	}
	
	@Test
	public void colorValidationForCreateAcc()
	{
		WebElement createAccEle = driver.findElement(By.xpath("//a[text()='Create new account']"));
		
		System.out.println("The color of create new account is -> "+createAccEle.getCssValue("background-color"));
		
		String rgbValue = createAccEle.getCssValue("background-color");
		
		String hexValue = Color.fromString(rgbValue).asHex();//this line used when not creating any seprate method for conversion of rgb to hex
		
		Assert.assertEquals(rgbValue, hexValue);
		
		
		
	}
	

}
