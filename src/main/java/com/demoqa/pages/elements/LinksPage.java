package com.demoqa.pages.elements;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LinksPage extends BasePage {
    public LinksPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a")
    List<WebElement> allLinks;
    public LinksPage checkAllLinks() {
        System.out.println("Total links on tha page: " + allLinks.size());
//        Iterator<WebElement> iterator = allLinks.iterator();
        return this;
    }

    public LinksPage checkBrokenLinks() {
        for (int i = 0; i < allLinks.size(); i++) {
            WebElement element = allLinks.get(i);
            String url = element.getDomAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    public LinksPage verifyLinks(String url) {
        URL linkUrl = new URL(url);
        return this;
    }

}
