package com.eurotechstudy.tests.tag_03;

import com.eurotechstudy.tests.pages.BasePage;
import com.eurotechstudy.tests.utilities.App;
import com.eurotechstudy.tests.utilities.Device;
import com.eurotechstudy.tests.utilities.Driver;
import com.eurotechstudy.tests.utilities.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class _01_FloTest {

    AppiumDriver<MobileElement> driver;
    Device device = Device.PIXEL_2;
    App app = App.FLO;
    BasePage basePage;

    @Before
    public void setUp() {
        driver = Utils.openApp(device,app);
        basePage = new BasePage(driver);
    }

    @After
    public void tearDown() {
        driver.closeApp();
        Driver.stopAppium();
    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(6000);
        basePage.searchButton.click();
        Thread.sleep(2000);
        basePage.searchInput.sendKeys("nike");
        Thread.sleep(2000);
        basePage.showAllButton.click();
        basePage.shoe.click();
        Assert.assertTrue(basePage.shoe.isDisplayed());
        Thread.sleep(5000);
    }
}
