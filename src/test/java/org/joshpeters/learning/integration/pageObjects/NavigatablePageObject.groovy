package org.joshpeters.learning.integration.pageObjects

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import static com.codeborne.selenide.Selenide.page

trait NavigatablePageObject {
  @FindBy(css = 'h1')
  WebElement mainHeading
  @FindBy(css = '.-btn-home')
  WebElement homepageLink
  @FindBy(css = '.-btn-page-1')
  WebElement page1Link
  @FindBy(css = '.-btn-page-2')
  WebElement page2Link

  String mainHeadingText() {
    mainHeading?.text
  }

  Homepage visitHome() {
    homepageLink.click()
    page(Homepage)
  }

  Page1 visitPage1() {
    page1Link.click()
    page(Page1)
  }

  Page2 visitPage2() {
    page2Link.click()
    page(Page2)
  }
}
