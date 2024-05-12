package org.auto;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Setwifi extends BaseClass {

    @Test
    public void setwifiTest()  {

        // Locators: id, xpath, accessibilityId, classname, androidUIAutomator
        a.findElement(AppiumBy.accessibilityId("Preference")).click();  // Click on the Preference tab

        // xpath : //TagName[@attribute='value'] ; //tagName
        a.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();  // Click on the Preference dependencies options

        a.findElement(By.id("android:id/checkbox")).click();   // Click on the wi-fi checkbox

        // xpath : // TagName
        // xpath : //android.widget.ListView[@resource-id="android:id/list"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout
        a.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click(); //Uses the 2nd tagName of xpath // Click on the wi-di settings

//		String wifiTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
//		Assert.assertEquals(wifiTitle, "WiFi settings"); //using assertion
//
        a.findElement(By.id("android:id/edit")).sendKeys("no1234");   // Enter the wi-fi name

        a.findElements(AppiumBy.className("android.widget.Button")).get(1).click();  // Click on the ok button  // when more than one name className use with the list elements such as findelements

    }

}
