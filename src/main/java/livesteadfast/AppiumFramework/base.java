package livesteadfast.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {

	static AppiumDriver driver;
	public static AppiumDriverLocalService service;
	
	public AppiumDriverLocalService startServer() {
		
		boolean flag= checkIfServerIsRunnning(4723);
		
		if(!flag) {
			System.out.println("in start server");
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		return service;
	}
	
	
	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
		serverSocket = new ServerSocket(port);

		serverSocket.close();
		} catch (IOException e) {
		//If control comes here, then it means that the port is in use
		isServerRunning = true;
		} finally {
		serverSocket = null;
		}
		return isServerRunning;
		}

	public static void getScreenshot(String shot) throws IOException {
		
		System.out.println("name passed in method is "+ shot);
		
		File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//	FileUtils.copyFile(srcfile, new File("/Users/chintanshah/screenshots/defectscreen.png"));
		
		FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"\\"+shot+".png"));
	}

	
	public static AppiumDriver Capabilities(String app) throws IOException {
		// TODO Auto-generated method stub

	//	System.getProperty("user.dir"); This get the file path on any platform
	//	FileInputStream fis= new FileInputStream("/Users/chintanshah/eclipse-workspace/AppiumFramework/src/main/java/global.properties");
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/global.properties");
		Properties prop= new Properties();
		prop.load(fis);

		
		File f= new File("src");
		File fs = new File(f, (String) prop.get(app));  //"General-Store.apk"
	//	File fs = new File(f, "ApiDemos-debug.apk");
	//	File fs = new File(f, "original.apk");	
		//Appium certification
		//Desired capabilities : Open emulator
		
		DesiredCapabilities cap=new DesiredCapabilities();
		
		//Passing emulator/device name from properties file
		String device=prop.getProperty("device");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		
		//Connection to appium server
		//Create and invoke android driver class
		AndroidDriver<AndroidElement> driver= new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
		
		
/*		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
//		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.VERSION, "10.0");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
//		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
//		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
		return driver;
	
		*/
	}
	


}
