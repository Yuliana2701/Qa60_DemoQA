package com.demoqa.pages.elements;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
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
        try {
            URL linkUrl = new URL(url);
            // create Url connection and get response code
            HttpURLConnection connection = (HttpsURLConnection) linkUrl.openConnection();
            connection.setConnectTimeout(10000);
            connection.connect();
            if (connection.getResponseCode() >= 400) {
                System.out.println(url + " - " + connection.getResponseMessage() + "Is brocken link");

            } else {
                System.out.println(url + " - " + connection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(url + " - " + e.getMessage() + "Error");
        }
        return this;
    }
@FindBy(css = "img")
List<WebElement> img;
    public LinksPage checkBrokenImg() {
        System.out.println(img.size() + " - " + "img");
        for (int i = 0; i < img.size(); i++) {
            WebElement element = img.get(i);
            String imgUrl = element.getAttribute("src");
            verifyLinks(imgUrl);
            try {
                Boolean imgDisplayed = (Boolean)
                        (js.executeScript("return (typeof arguments[0].naturalWidth!=undefined && arguments[0].naturalWidth>0);", element));
                if (imgDisplayed){
                    System.out.println("DISPLAYED - OK");
                }else {
                    System.out.println("DISPLAYED BROKEN");
                }
            }catch (Exception e){
                System.out.println("ERROR");
            }
        }
        return this;
    }
}