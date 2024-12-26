package rahulshettyacademy;
import java.io.File;
import java.net.URI;
import org.testng.annotations.Test;
import java.net.URISyntaxException;
import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class AppiumBasicTest {
	
	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException{
		
		//code to start Appium server - Instead of running it from the terminal, and manually typing "appium".
        try (AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\shibe\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build()) {

            service.start();

            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("ShibelPhone");
            options.setApp("C:\\Users\\shibe\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");

            AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);

            //Popular locators for android:
            //For selenium and appium: Xpath, id, className
            //Only for appium: androidUIAutomator, accessibilityId
            //By is for selenium+appium, AppiumBy is just for appium.
            driver.findElement(AppiumBy.accessibilityId("Preference")).click();

            driver.quit();
            service.stop(); //stop appium server
        }
    }
}
