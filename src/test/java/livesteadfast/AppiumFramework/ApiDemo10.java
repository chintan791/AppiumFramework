package livesteadfast.AppiumFramework;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import pageObjects.HomePage;
import pageObjects.Preferences;

public class ApiDemo10 {
 
static AppiumDriver driver;
public static void main(String[] args) throws IOException, InterruptedException {
 
DesiredCapabilities cap = new DesiredCapabilities();
cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
cap.setCapability(CapabilityType.VERSION, "10.0");
cap.setCapability(CapabilityType.PLATFORM_NAME, "Android");
cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
 
driver.findElement(By.xpath("//android.widget.Button[@text='Continue']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
Thread.sleep(1000);
 
HomePage h= new HomePage(driver);
((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Preference\").instance(0))");
//driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
h.Preferences.click();
//driver.findElement(By.xpath("//android.widget.Button[@text='3. Preference dependencies']")).click();

Preferences p= new Preferences(driver);
((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"dependencies\").instance(0))");
//driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
p.PreferenceDependency.click();

//((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"dependencies\").instance(0))");
driver.findElementById("android:id/checkbox").click();

		
driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

driver.findElementByClassName("android.widget.EditText").sendKeys("informia");

//((RemoteWebElement) driver.findElementsByClassName("android.widget.Button").get(1)).click();

p.buttons.get(1).click();

}
}
