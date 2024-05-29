package Gesture;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

//import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.AbstractOptionCombinedWithPosition;
import static io.appium.java_client.touch.offset.ElementOption.element;

import io.appium.java_client.touch.offset.ElementOption;
import org.auto.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

//import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragDrop extends BaseClass {

    @Test
    public void draganddropTest() throws InterruptedException {

        a.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();  // Click on the Views mwnu
        Thread.sleep(2000);

        a.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();   // Click on the Drag and Drop menu
        Thread.sleep(1000);

        WebElement drag = a.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/drag_dot_1\")"));

        WebElement drop = a.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/drag_dot_3\")"));

        TouchAction action = new TouchAction(a);

        // longpress(drag)/ moveto(drop)/release

      //  action.longPress((LongPressOptions) drag).moveTo((PointOption) drop).release().perform();
      //  LongPressOptions longPressOptions = new LongPressOptions();

        //action.longPress(longPressOptions().withElement(element(drag))).moveTo(element(drop)).release().perform();

        action.longPress(ElementOption.element(drag)).moveTo(ElementOption.element(drop)).release().perform();

        Thread.sleep(3000);

       // action.longPress((LongPressOptions) drag).moveTo((PointOption) drop).wait(500).release.perform;

        System.out.println("Element has been droped at destination successfully");






    }
}
