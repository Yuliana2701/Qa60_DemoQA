package com.demoqa.pages.bookstore;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProfilePage extends BasePage {


    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#userName-value")
    WebElement userName;
    public ProfilePage verifyUserName(String text) {
        Assert.assertTrue(userName.getText().contains(text));

        return this;
    }
    @FindBy(id = "searchBox")
    WebElement  searchBox;
    public ProfilePage  typeKeyInSearchInput(String text) {
        type(searchBox, text);
        return this;
    }
    @FindBy(css = ".mr-2 a")
    WebElement nameBook;
    public ProfilePage verifyNameOfBook(String text) {
       Assert.assertTrue(shouldHaveText(nameBook, text, 5));
        return this;
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}
