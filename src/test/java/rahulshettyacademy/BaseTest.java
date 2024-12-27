package rahulshettyacademy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;


public class BaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void configureAppium() {

        //code to start Appium server - Instead of running it from the terminal, and manually typing "appium".
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\shibe\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("ShibelPhone");
            options.setApp("C:\\Users\\shibe\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");

        try {
            driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void tearDownAppium() {
        driver.quit();
        service.stop();
    }
}
