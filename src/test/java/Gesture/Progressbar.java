package Gesture;

import io.appium.java_client.AppiumBy;
import org.auto.App;
import org.auto.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Progressbar extends BaseClass {

    @Test
    public void progressbarTest() throws InterruptedException {

        a.findElement(AppiumBy.accessibilityId("Views")).click();     // Click on the views menu

        a.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Progress Bar\"));"));   // Scroll the element
        Thread.sleep(2000);

        a.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Progress Bar\")")).click();    // Click on the progressbar
        Thread.sleep(2000);

        a.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Incremental\"]\n")).click();   // Click on the incremental options
        Thread.sleep(2000);

        for(int i=0; i<4 ; i++)
        {
            a.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/increase\")")).click();   //  Click on the increment 1
            Thread.sleep(2000);
        }

        for(int i=0; i<4 ; i++)
        {
            a.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/decrease\")")).click();   //  Click on the increment 1
            Thread.sleep(2000);
        }

        for(int i=0; i<4 ; i++)
        {
            a.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/increase_secondary\")")).click();   //  Click on the increment 1
            Thread.sleep(2000);
        }

        for(int i=0; i<4 ; i++)
        {
            a.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/decrease_secondary\")")).click();   //  Click on the increment 1
            Thread.sleep(2000);
        }

        String value = a.findElement(By.id("io.appium.android.apis:id/progress_horizontal")).getAttribute("text");

        System.out.println("Progressbar is working successfully");

    }
}
