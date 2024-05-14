package Gesture;

import io.appium.java_client.AppiumBy;
import org.auto.App;
import org.auto.BaseClass2;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DropDown extends BaseClass2 {

        @Test
        public void dropdownTest() throws InterruptedException {

            a.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();  // Click on the country drop-down menu
            Thread.sleep(1000);

            // Scroll until Canada option is visible
           // scrollToElement("Canada");    // For common purpose

            a.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Canada\"));"));
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
            Thread.sleep(3000);




        }

}
