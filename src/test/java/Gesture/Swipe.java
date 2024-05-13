package Gesture;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.auto.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Swipe extends BaseClass {

    @Test
    public void swipeTest() throws InterruptedException {

        a.findElement(AppiumBy.accessibilityId("Views")).click();  // Click on the views menu

        a.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Gallery\")")).click();  // Click on the Gallary menu

        a.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/text1']")).click();  // Click on the Photos menu

        WebElement firstImage = a.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));  // locator of first image

        // Before perform swipe

        String firstImageValue = firstImage.getAttribute("focusable");

        Assert.assertEquals("true", firstImageValue, "Image is focusable");

        Thread.sleep(2000);

        // Perform swipe action

        swipeAction(firstImage,"LEFT");     // For general purpose

        Thread.sleep(2000);

        // After perform swipe

        String secondImageValue = firstImage.getAttribute("focusable");

        Assert.assertEquals("false", secondImageValue, "Image is focusable");

        Thread.sleep(2000);

    }
}
