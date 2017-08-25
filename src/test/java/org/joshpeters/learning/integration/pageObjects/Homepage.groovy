package org.joshpeters.learning.integration.pageObjects
import com.codeborne.selenide.Condition
import groovy.util.logging.Slf4j

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.page

@Slf4j
class Homepage implements NavigatablePageObject {
  Homepage ajaxCall() {
    $('#clickMe').click()
    page(Homepage)
  }

  void checkResultHeading(final String expectedText) {
    $('.panel-info .panel-heading').shouldHave(Condition.text(expectedText))
  }

  void checkResultBody(final String expectedText) {
    $('.panel-info .panel-body').shouldHave(Condition.text(expectedText))
  }
}
