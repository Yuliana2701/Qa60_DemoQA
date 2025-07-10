package com.demoqa.pages.interactions;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DroppablePage extends BasePage {
    public DroppablePage(WebDriver driver) {
        super(driver);
    }
@FindBy(id = "draggable")
    WebElement dragMe;

    @FindBy(id = "droppable")
    WebElement dropHere;
    public DroppablePage actionDragMe() {
        pause(1000);
        moveWithJS(0,200);
        new Actions(driver).dragAndDrop(dragMe,dropHere).perform();



        return this;
    }


    public DroppablePage verifyDropped(String text) {
        Assert.assertTrue(shouldHaveText(dropHere,text,10));
        return this;
    }
}

