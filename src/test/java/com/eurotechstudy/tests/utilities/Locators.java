package com.eurotechstudy.tests.utilities;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public interface Locators {

    MobileElement result = Driver.getDriver().findElement(By.className("android.widget.TextView"));


}
