package org.auto;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.remote.options.SupportsDeviceNameOption;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Member;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseClass {
    public AndroidDriver a;
    public AppiumDriverLocalService service;

    @BeforeTest
    public void configureAppium() throws MalformedURLException {

        Map<String, String> env=new HashMap<String, String>(System.getenv());
        env.put("ANDROID_HOME","C:\\Users\\ameep\\AppData\\Local\\Android\\Sdk");
        env.put("JAVA_HOME","C:\\Program Files\\Java\\jdk-21");

        File file = new File("C:\\Users\\ameep\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");

        // Run appium server automatically
        service = new AppiumServiceBuilder().withAppiumJS(file).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(100)).build();

        service.start();

//        File f = new File("resources");
//        File fs = new File(f,"General-Store.apk");

        // create capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 8 Pro");

        // options.setApp(fs.getAbsolutePath());
        // options.setAdbPort(8210);

        options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\ApiDemos-debug.apk");
        System.out.println(System.getProperty("user.dir"));

        options.setAutomationName("UIAutomator2");
        options.setPlatformName("ANDROID");
        options.setCapability("platformVersion","10.0");

        // create object for AndroidDriver/IOSDriver
        URL url = new URL("http://127.0.0.1:4723");

        a = new AndroidDriver(url,options);
        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

        // Object Locators : xpath, id, className, accessibilityId, androidUIautomator
        // a.findElement(AppiumBy.accessibilityId(""));

    }

    // Use this method in Scroll.java file to scroll at the end of the page

    public void scrollToEnd() throws InterruptedException {
        boolean scroll;
        do {
            JavascriptExecutor js = (JavascriptExecutor) a;

            scroll = (Boolean) js.executeScript("mobile: scrollGesture" , ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 1.0
            ));
        }while (scroll);

        Thread.sleep(1000);
    }

    // Use this method in Scroll.java file to scroll at the element of the page

//    public void scrollToElement(String element) throws InterruptedException {
//
//        a.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"element\"));"));
//        Thread.sleep(2000);
//    }

    // Perform swipe action

    public void swipeAction(WebElement firstImage, String swipeDirection) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) a;

        js.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) firstImage).getId(),
                "direction", swipeDirection,
                "percent", 0.75));

        Thread.sleep(2000);

    }


    @AfterTest
    public void tearDown(){

        a.quit();
        service.stop();

    }
}

