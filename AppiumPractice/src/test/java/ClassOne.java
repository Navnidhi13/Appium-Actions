import io.appium.java_client.AppiumBy;
import org.development.App;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassOne extends BaseTest {

    @Test
    public void wifiSettings() {

        //id, Xpath, Accessibility id, classname, androidUIAutomator\
        //Xpath:
        //

        //configureAppium();
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String st1 = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(st1, "WiFi settings");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Navnidhi wifi");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
    }
}