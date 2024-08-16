package com.eurotechstudy.tests.tag_02;

import com.eurotechstudy.tests.utilities.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.eurotechstudy.tests.utilities.Utils.*;

public class _03_OpenApp implements Locators {

    AppiumDriver<MobileElement> driver;

    @Before
    public void setUp() throws Exception {
        driver = Utils.openApp(Device.PIXEL_2, App.CALCULATOR);
    }

    @After
    public void tearDown() throws Exception {
        driver.closeApp();
        Driver.stopAppium();
    }

    @Test
    public void test1() {
        getDigit(3).click();
        operator("plus").click();
        getDigit(7).click();
        operator("equals").click();
        String resultText = result.getText();
        System.out.println("resultText = " + resultText);
        assert resultText.equals("10");
    }
}
