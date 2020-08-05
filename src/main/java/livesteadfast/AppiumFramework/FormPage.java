package livesteadfast.AppiumFramework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {

	
	public FormPage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Should be uniform, but for practice purpose we keep separate ways here
	//private web element is the best approach
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement femaleOption;
	
	@AndroidFindBy(id="android:id/text1")
	public WebElement countrySelection;
	
	@AndroidFindBy(xpath="//*[@text='Argentina']")
	public WebElement countryArgentina;
	
	
	//Use this in place of nameField directly if you need to log some details
	//Best practice
	public WebElement getNameField()
	{
		System.out.println("in namefield");
		return nameField;
	}
	
}
