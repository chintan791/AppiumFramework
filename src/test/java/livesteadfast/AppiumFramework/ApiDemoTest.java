package livesteadfast.AppiumFramework;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;

public class ApiDemoTest extends base {
	
	@Test
	public void apiDemo() throws IOException{
		
	//	service= startServer();
		AndroidDriver<AndroidElement> driver = (AndroidDriver<AndroidElement>) Capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		HomePage h= new HomePage(driver);

		
		driver.findElementByXPath("//android.widget.Button[@text='Continue']").click();
		
		driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
		
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		
	//	h.Preferences.click();
		
	//	service.stop();
	}

}


