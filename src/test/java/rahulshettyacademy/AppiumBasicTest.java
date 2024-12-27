package rahulshettyacademy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;


public class AppiumBasicTest extends BaseTest {

    @Test
    public void WifiSettingsName() {

            driver.findElement(AppiumBy.accessibilityId("Preference")).click();
            driver.findElement(By.xpath(
                    "//android.widget.TextView[@content-desc=" +
                            "'3. Preference dependencies']")).click();
            driver.findElement(AppiumBy.id("android:id/checkbox")).click();
            driver.findElement(AppiumBy.xpath(
                    "//android.widget.TextView[@resource-id=\"android:id/title\" and " +
                            "@text=\"WiFi settings\"]")).click();
            String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
            Assert.assertEquals(alertTitle, "WiFi settings");
    }
}
