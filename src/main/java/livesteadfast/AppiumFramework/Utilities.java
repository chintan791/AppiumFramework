package livesteadfast.AppiumFramework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities{
	AndroidDriver<AndroidElement> driver;

	public Utilities(AndroidDriver<AndroidElement> driver) {
		
	}
	
	public void scrollToText(String text) {
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}
}
