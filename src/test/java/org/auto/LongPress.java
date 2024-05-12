package org.auto;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPress extends BaseClass {

    @Test
    public void longpressTest(){

        a.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();     // Click on the Views menu

        a.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Expandable Lists']\n")).click();  // Click on the Expandable Lists   // when more than one name className use with the list elements such as find-elements

        a.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();  // Click on the Custom Adapter menu

        WebElement logpress = a.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));     // Webelement of the people names

        JavascriptExecutor js = (JavascriptExecutor) a;    // Javascript Executor for js

        js.executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) logpress).getId()), "duration", 1000);    //  long press syntax

        WebElement samplemenu = a.findElement(By.id("android:id/title"));       // Webelement of sub menu

        String peopletext = samplemenu.getText();       // get the text of the sample menu

        Assert.assertEquals(peopletext, "Sample menu", "Text is matched");

        boolean display = samplemenu.isDisplayed();

        Assert.assertTrue(display);

        System.out.println("Display the text: "+display);


    }
}
