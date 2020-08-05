package livesteadfast.AppiumFramework;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_4 extends base{

	
		@Test(dataProvider="InputData",dataProviderClass=TestData.class)
		public void totalValidation(String input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
	//	service= startServer();
	//	System.out.println("hee neow");
		AndroidDriver<AndroidElement> driver = (AndroidDriver<AndroidElement>) Capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		FormPage formpage= new FormPage(driver);
		
	//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("hello");
	//	formpage.nameField.sendKeys("hello");
	//	formpage.getNameField().sendKeys("hello");
		
	//Eliminating data hard coding and implementing parameterization using data provider
		formpage.getNameField().sendKeys(input);
		
	//	driver.hideKeyboard();
		
	//	driver.findElement(By.xpath("//*[@text='Female']")).click();
		formpage.femaleOption.click();
		
	//	driver.findElement(By.id("android:id/text1")).click();
		formpage.countrySelection.click();
		
		Utilities u= new Utilities(driver);
	//	u.scrollToText("Argentina");
		driver.findElementByAndroidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Argentina\"))");
		
	//	driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		formpage.countryArgentina.click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(4000);
		
		
		CheckoutPage checkoutPage=new CheckoutPage(driver);
	//	String firstPrice= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		String firstPrice= checkoutPage.productPrice.get(0).getText();
		double firstPriceVal=getAmount(firstPrice);
		
		String secondPrice= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		double secondPriceVal=getAmount(secondPrice);
		
		double sum= firstPriceVal + secondPriceVal;
		
		System.out.println("Total amount is " +sum);
		
		String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		
		total=total.substring(1);
		double totalVal= Double.parseDouble(total);
		
		System.out.println("Total true amount is " +totalVal);
		
		// Match to che check is total is same
		//Assert.assertEquals(sum, totalVal);
		
		//Mobile Gestures
		WebElement checkbox= driver.findElement(By.className("android.widget.CheckBox"));
		
		TouchAction t= new TouchAction(driver);
		
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		
		WebElement tc=driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		
		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
		
		
		
		driver.findElement(By.id("android:id/button1")).click();
		
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	
	//	service.stop();
		}
	
	public static double getAmount(String value)
	{
		// remove $ sign then Convert into double data type - cos of decimal values
		
		value=value.substring(1);
		double secondPriceVal= Double.parseDouble(value);
		return secondPriceVal;
	}
	

}
