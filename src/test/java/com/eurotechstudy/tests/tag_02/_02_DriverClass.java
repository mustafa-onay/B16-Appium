package com.eurotechstudy.tests.tag_02;

import com.eurotechstudy.tests.utilities.App;
import com.eurotechstudy.tests.utilities.Device;
import com.eurotechstudy.tests.utilities.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class _02_DriverClass {

    AppiumDriver<MobileElement> driver;

    Device device = Device.PIXEL_2;
    App app = App.CALCULATOR;


    @Before
    public void setUp() {
        Driver.runAppium();
        //driver = Driver.getDriver(Device.PIXEL_2, App.CALCULATOR);
        driver = Driver.getDriver(device,app);
    }
    @After
    public void tearDown() {
        driver.closeApp();
        Driver.stopAppium();
    }

    @Test
    public void test1() {
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
    }
}
