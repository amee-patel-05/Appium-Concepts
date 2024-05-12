package Gesture;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.auto.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Scroll extends BaseClass {

    @Test
    public void scrollTest() throws InterruptedException {

        a.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();     // Click on the Views menu
        Thread.sleep(2000);

        // Scroll until view an element

        //scrollToElement("Popup Menu");
//        a.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Popup Menu\"));"));
//        Thread.sleep(3000);

        // Scroll as long as the app elements

       // scrollToEnd();
        boolean scroll;
        do {
            JavascriptExecutor js = (JavascriptExecutor) a;

           scroll = (Boolean) js.executeScript("mobile: scrollGesture" , ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                   "direction", "down",
                   "percent", 1.0
            ));
        }while (scroll);

        Thread.sleep(3000);

    }

}
