import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;

public class LongPress extends BaseTest {

    @Test
    public void longPress() {
        //id, Xpath, Accessibility id, classname, androidUIAutomator
        //Xpath:
        //configureAppium();
        //int duration =2;
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));

//        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));


        Point location = ele.getLocation();
        Dimension size = ele.getSize();

        Point centerOfElement = getCenterOfElement(location, size);

        PointerInput f1 = new PointerInput(PointerInput.Kind.TOUCH, "f1");
        Sequence sequence = new Sequence(f1, 1)
                .addAction(f1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(f1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(f1, Duration.ofSeconds(2)))
                .addAction(f1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));

        String menuText = driver.findElement(AppiumBy.id("android:id/title")).getText();
        Assert.assertEquals(menuText, "Sample menu");
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
    }
}