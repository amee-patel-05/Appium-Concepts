package org.auto;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewText extends BaseClass{

    @Test
    public void testText(){

        a.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();  // Click on the Views menu

        a.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Buttons\"]\n")).click();   // Click on the buttons

        String normalbtn =a.findElements(AppiumBy.className("android.widget.Button")).get(0).getText();    // Click on the Normal button

        Assert.assertEquals(normalbtn, "Normal", "Text details are not matched");

        Assert.assertTrue(true);

    }
}
