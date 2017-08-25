package org.joshpeters.learning.integration

import org.jbehave.core.annotations.BeforeScenario
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When
import org.jbehave.core.annotations.spring.UsingSpring
import org.joshpeters.learning.integration.pageObjects.Homepage
import org.joshpeters.learning.integration.pageObjects.NavigatablePageObject
import org.springframework.stereotype.Component

import static com.codeborne.selenide.Selenide.open
import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.Matchers.notNullValue
import static org.junit.Assert.assertThat

@Component
@UsingSpring
class SomeSteps {
  NavigatablePageObject currentPage

  @BeforeScenario
  void reset() {
    currentPage = null
  }

  @Given("one starts at the homepage")
  void givenOneStartsAtTheHomepage() {
    currentPage = open('http://localhost:8080/', Homepage)
  }

  @When('I try an ajax request')
  void tryAnAjaxRequest() {
    (currentPage as Homepage).ajaxCall()
  }

  @Then('magic happens')
  void magicHappens() {
    def homepage = currentPage as Homepage
    homepage.checkResultHeading('Result')
    homepage.checkResultBody('this,is,an,api,call')
  }

  @When("want to visit page 1")
  void whenWantToVisitPage1() {
    currentPage = currentPage?.visitPage1()
    assertThat("current page is not null", currentPage, notNullValue())
  }

  @Then("I find myself on page 1")
  void thenIFindMyselfOnPage1() {
    assertThat(
      currentPage?.mainHeadingText(),
      equalTo("Page 1")
    )
  }

  @When("want to visit page 2")
  void whenWantToVisitPage2() {
    currentPage = currentPage?.visitPage2()
    assertThat("current page is not null", currentPage, notNullValue())
  }

  @Then("I find myself on page 2")
  void thenIFindMyselfOnPage2() {
    assertThat(
      currentPage?.mainHeadingText(),
      equalTo("Page 2")
    )
  }

  @Then("I find myself on homepage")
  void thenIFindMyselfOnHomepage() {
    assertThat(
      currentPage?.mainHeadingText(),
      equalTo("Homepage")
    )
  }
}
