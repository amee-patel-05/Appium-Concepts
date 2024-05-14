package org.auto;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseClass2 {

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

        // create capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 8 Pro");

        options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\General-Store.apk");
        System.out.println(System.getProperty("user.dir"));

        options.setAutomationName("UIAutomator2");
        options.setPlatformName("ANDROID");
        options.setCapability("platformVersion","10.0");

        // create object for AndroidDriver/IOSDriver
        URL url = new URL("http://127.0.0.1:4723");

        a = new AndroidDriver(url,options);
        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

    }

    // Use this method in Scroll.java file to scroll at the element of the page

//    public void scrollToElement(String element) throws InterruptedException {
//
//        a.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"element\"));"));
//        Thread.sleep(2000);
//    }

    @AfterTest
    public void tearDown(){

        a.quit();
        service.stop();

    }
}
