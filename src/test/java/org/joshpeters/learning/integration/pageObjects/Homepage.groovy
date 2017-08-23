package org.joshpeters.learning.integration.pageObjects

import groovy.util.logging.Slf4j
import net.serenitybdd.core.annotations.findby.FindBy
import net.serenitybdd.core.pages.PageObject
import net.thucydides.core.annotations.DefaultUrl
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

@Component
@DefaultUrl('http://localhost:8080/index.html')
@Slf4j
class Homepage extends PageObject implements MainHeadingPage, NavigatesToPage1, NavigatesToPage2 {
  @Autowired
  WebDriver springProvidedDriver;

  @PostConstruct
  void init() {
    setDriver(springProvidedDriver);
  }

  @Autowired
  Page1 page1
  @Autowired
  Page2 page2

  @FindBy(css = 'h1')
  WebElement mainHeading
  @FindBy(css = '.-btn-page-1')
  WebElement page1Link
  @FindBy(css = '.-btn-page-2')
  WebElement page2Link

  @Override
  String mainHeadingText() {
    mainHeading?.text
  }

  @Override
  Page1 visitPage1() {
    page1Link?.click()
    page1
  }

  @Override
  Page2 visitPage2() {
    page2Link?.click()
    page2
  }
}
