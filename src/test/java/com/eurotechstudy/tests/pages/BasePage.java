package com.eurotechstudy.tests.pages;

import com.eurotechstudy.tests.utilities.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @FindBy(id = "com.flo.ayakkabi:id/txtSearch")
    public MobileElement searchButton;

    @FindBy(className = "android.widget.EditText")
    public WebElement searchInput;

    @FindBy(xpath = "//*[@text='ARA']")
    public MobileElement showAllButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"COURT VISION LO NN Beyaz Erkek Sneaker\"]")
    public MobileElement shoe;

}
