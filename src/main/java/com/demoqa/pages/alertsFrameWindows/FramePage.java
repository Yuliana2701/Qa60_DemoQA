package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramePage extends BasePage {
    public FramePage(WebDriver driver) {
        super(driver);
    }
@FindBy( tagName = "iframe")
    List<WebElement> iframe;
    public FramePage returnListOfFrames() {
       // iframe.size();// by finding all webelements
        System.out.println("The total number"+ iframe.size());

        return this;
    }
}
