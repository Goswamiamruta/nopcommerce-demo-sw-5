package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DesktopsPage extends Utility {
    @CacheLookup
    @FindBy(linkText = " Desktops ")
    WebElement Desktop;
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Desktop']")
    WebElement DesktopText;



    public void clickOnDesktop() {
        clickOnElement(Desktop);
    }
    public String getDesktopText() {
        String message = getTextFromElement(DesktopText);
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
        return message;
    }





}
