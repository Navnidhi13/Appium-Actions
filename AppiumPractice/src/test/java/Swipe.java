import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.development.App;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Swipe extends BaseTest{
    @Test
    public void swipe() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='1. Photos']")).click();
        WebElement firstImage = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));
        Assert.assertEquals(firstImage.getAttribute("focusable"), "true");
        // Swipe
        swipeAction(firstImage, "left");

        Assert.assertEquals(firstImage.getAttribute("focusable"), "false");
    }
}
