package org.auto;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class HybridApp extends BaseClass2{

    @Test
    public void hybridTest() throws InterruptedException {

        a.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();  // Click on the country drop-down menu
        Thread.sleep(1000);

        // Scroll until Canada option is visible
        //scrollToElement("Canada");    // For common purpose
        a.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Canada\"));"));
        Thread.sleep(2000);

        //a.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Canada\"));"));
        Thread.sleep(1000);

        a.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Canada\")")).click();   // Click on the Canada option
        Thread.sleep(1000);

        a.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]")).sendKeys("Amee");      // Enter name in the text field
        Thread.sleep(1000);

        a.hideKeyboard();
        Thread.sleep(1000);

        a.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")).click();  // Click on the Female radio button
        Thread.sleep(1000);

        a.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();   // Click on the Lets shop button
        Thread.sleep(2000);

        a.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"));"));
        Thread.sleep(2000);

        // Select the shoes (Jordan Lift Off)

        int count = a.findElements(By.id("com.androidsample.generalstore:id/productName")).size();  // count the total number od shoes
        for (int i =0; i<count ; i++){
            String productName = a.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();  // get the selected shoes name

            if (productName.equalsIgnoreCase("Jordan Lift Off")){     // find the selected shoes name

                a.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();   // Click on the Add to cart button of selected product

            }
        }
        Thread.sleep(2000);

        a.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/appbar_btn_cart\")")).click();  // Click on the Cart button
        Thread.sleep(1000);

        a.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnProceed\"]")).click();  // Click on the visit to website to complete purchase button
        Thread.sleep(4000);

        // Type appium tutorials in google search

        Set<String> contextNames = a.getContextHandles();  // Both context names

        for(String contextName : contextNames){
            System.out.println(contextName);    // print out somethings like NativeApp
        }

        // Moving from Mobile App to Web App
        a.context("WEBVIEW_com.androidsample.generalstore");   // NATIVE_APP   WEBVIEW_com.androidsample.generalstore
        Thread.sleep(5000);

        WebElement search = a.findElement(By.name("q"));     // Enter the details in search bar
        search.sendKeys("appium tutorials");
        Thread.sleep(3000);

        search.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        a.pressKey(new KeyEvent(AndroidKey.BACK));      // Click on the Back button on mobile device for navigating back to android app
        Thread.sleep(3000);

        a.context("NATIVE_APP");        // Pass the native context
        Thread.sleep(2000);







    }
}
