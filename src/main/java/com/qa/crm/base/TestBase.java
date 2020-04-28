/**
 * 
 */
package com.qa.crm.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Ankur
 *
 */
public class TestBase {
	
	
	public static WebDriver driver ;
	public static Properties prop;
	public static int waits_Value =200;
	public DesiredCapabilities cap;
	//static DesiredCapabilities caps;
	
	public TestBase() throws IOException
	{
		
		FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\crm\\config\\config.properties");
		prop = new Properties();
		prop.load(fin);
		
	}
	
	
	public void initialize() throws AWTException
	{
		if(prop.getProperty("browser").equals("chrome")) 
		{			
			cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			
			System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.driver","F:\\Downloads Softwares\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox")) 
		{			
			System.setProperty("webdriver.gecko.driver","F:\\Downloads Softwares\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
    	else if(prop.getProperty("browser").equals("ie")) 
		{			
			System.setProperty("webdriver.ie.driver","F:\\Downloads Softwares\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else if(prop.getProperty("browser").equals("opera")) 
		{			
			System.setProperty("webdriver.opera.driver","F:\\Downloads Softwares\\operadriver.exe");
			driver = new OperaDriver();
		} 
		
//	    Robot robot = new Robot();
//	    robot.keyPress(KeyEvent.VK_CONTROL);
//	    robot.keyPress(KeyEvent.VK_T);
//
//	    Set<String> handles = driver.getWindowHandles();
//	    List<String> handlesList = new ArrayList<String>(handles);
//	    String newTab = handlesList.get(handlesList.size() - 1);
//
//	    // switch to new tab
//	    driver.switchTo().window(newTab); 
//	   // driver.get("http://www.yahoo.com");
		
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(waits_Value, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(waits_Value, TimeUnit.SECONDS);
			

		}	

}
