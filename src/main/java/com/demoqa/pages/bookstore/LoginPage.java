package com.demoqa.pages.bookstore;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='userName']")
     WebElement user;

    @FindBy(xpath = "//input[@id='password']")
     WebElement passwordField;
    public LoginPage enterUserData(String userName, String password) {
        type(user,userName);
        //typeWithJS(passwordField,password, 0, 300)
        type(passwordField,password);

        return this;
    }
@FindBy(xpath = "//button[@id='login']")
WebElement loginButton;
    public ProfilePage clickOnLoginButton() {
        click(loginButton);
        return new ProfilePage(driver);
    }
}
