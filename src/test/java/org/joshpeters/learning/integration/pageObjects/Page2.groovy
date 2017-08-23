package org.joshpeters.learning.integration.pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Page2 extends PageObject implements MainHeadingPage, NavigatesToHome, NavigatesToPage1 {
    @Autowired
    WebDriver springProvidedDriver;

    @PostConstruct
    void init() {
        setDriver(springProvidedDriver);
    }

    @Autowired
    Homepage homepage;
    @Autowired
    Page1 page1;
    @FindBy(css = "h1")
    WebElement mainHeading;
    @FindBy(css = ".-btn-home")
    WebElement homepageLink;
    @FindBy(css = ".-btn-page-1")
    WebElement page1Link;

    @Override
    public String mainHeadingText() {
        return mainHeading.getText();
    }

    @Override
    public Homepage visitHome() {
        homepageLink.click();
        return homepage;
    }

    @Override
    public Page1 visitPage1() {
        page1Link.click();
        return page1;
    }
}
