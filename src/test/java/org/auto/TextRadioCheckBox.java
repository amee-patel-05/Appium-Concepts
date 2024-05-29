package org.auto;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TextRadioCheckBox extends BaseClass{

    @Test
    public void boxTest() throws InterruptedException {

        a.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();      // Click on the views menu
        Thread.sleep(1000);

        a.findElement(AppiumBy.accessibilityId("Controls")).click();    // Click on the Controls menu
        Thread.sleep(1000);

        a.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"4. Holo Dark Theme\")")).click();    //  Click on the HoloDarkTheme menu
        Thread.sleep(1000);

        a.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("This is Holo Dark Theme Textbox ");    // Enter text in textbox
        Thread.sleep(1000);

        a.findElement(By.xpath("//android.widget.CheckBox[@content-desc=\"Checkbox 2\"]")).click();  // Click on the checkbox
        Thread.sleep(1000);

        a.findElement(By.id("io.appium.android.apis:id/radio2")).click();   // Click on the radio button
        Thread.sleep(1000);




    }
}
