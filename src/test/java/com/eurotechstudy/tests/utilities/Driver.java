package com.eurotechstudy.tests.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static AppiumDriver<MobileElement> driver;
    static AppiumDriverLocalService service;

    public static void runAppium() {
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .build();
        service.start();
    }

    public static void stopAppium() {
        service.stop();
    }

    public static AppiumDriver<MobileElement> getDriver(Device device, App app) {
        driver = new AppiumDriver<>(service.getUrl(), setCaps(device,app));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public static DesiredCapabilities setCaps(Device device, App app) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //Device capabilities
        capabilities.setCapability(MobileCapabilityType.UDID, device.udid);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device.deviceName);
        capabilities.setCapability(MobileCapabilityType.VERSION, device.version);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, device.platform);

        //appication capabilities
        capabilities.setCapability("appPackage", app.appPackage);
        capabilities.setCapability("appActivity", app.appActivity);
        return capabilities;
    }



}
