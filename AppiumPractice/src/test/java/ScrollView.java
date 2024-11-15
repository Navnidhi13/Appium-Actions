import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollView extends BaseTest{

    @Test
    public void scroll() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
        Thread.sleep(2000);
    }
}
