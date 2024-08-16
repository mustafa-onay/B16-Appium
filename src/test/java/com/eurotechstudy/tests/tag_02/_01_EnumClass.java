package com.eurotechstudy.tests.tag_02;
import com.eurotechstudy.tests.utilities.App;
import com.eurotechstudy.tests.utilities.Device;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
public class _01_EnumClass {

    AppiumDriver<MobileElement> driver;
    AppiumDriverLocalService service;

    Device device = Device.PIXEL_2;
    App app = App.CALCULATOR;


    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                //.usingPort(4723)
                .usingAnyFreePort()
                .build();

        service.start();
        //Device capabilities
        capabilities.setCapability(MobileCapabilityType.UDID, device.udid);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device.deviceName);
        capabilities.setCapability(MobileCapabilityType.VERSION, device.version);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, device.platform);

        //appication capabilities

        capabilities.setCapability("appPackage", app.appPackage);
        capabilities.setCapability("appActivity", app.appActivity);

        driver = new AppiumDriver<>(service.getUrl(), capabilities);

        MobileElement number4 = driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
        MobileElement plus = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"plus\"]"));
        MobileElement number2 = driver.findElement(MobileBy.AccessibilityId("2"));

        MobileElement equals = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.google.android.calculator:id/eq\")"));

        number4.click();
        plus.click();
        number2.click();
        equals.click();

        MobileElement result = driver.findElement(By.className("android.widget.TextView"));
        System.out.println("result.getText() = " + result.getText());
        Assert.assertEquals("6", result.getText());
        driver.closeApp();
        service.stop();

    }



}

