package org.auto;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.remote.options.SupportsDeviceNameOption;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Member;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseClass {
    public AndroidDriver a;
    public AppiumDriverLocalService service;

    @Test
    public void configureAppium() throws MalformedURLException {

        File file = new File("C:\\Users\\ameep\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");

        // Run appium server automatically
        service = new AppiumServiceBuilder().withAppiumJS(file).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(100)).build();

        service.start();

//        File f = new File("resources");
//        File fs = new File(f,"General-Store.apk");

        // create capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 8 Pro");

//        options.setApp(fs.getAbsolutePath());
        //options.setAdbPort(8210);

        options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\ApiDemos-debug.apk");
        System.out.println(System.getProperty("user.dir"));

        options.setAutomationName("UIAutomator2");
        options.setPlatformName("ANDROID");

        // create object for AndroidDriver/IOSDriver
        URL url = new URL("http://127.0.0.1:4723");

        // Object Locators : xpath, id, className, accessibilityId, androidUIautomator
        a.findElement(AppiumBy.accessibilityId(""));


        a = new AndroidDriver(url,options);
        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
        a.quit();

        service.stop();
    }
}

