package org.joshpeters.learning.integration

import org.jbehave.core.annotations.BeforeStories
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When
import org.joshpeters.learning.integration.pageObjects.Homepage
import org.joshpeters.learning.integration.pageObjects.MainHeadingPage
import org.joshpeters.learning.integration.pageObjects.NavigatesToPage1
import org.joshpeters.learning.integration.pageObjects.NavigatesToPage2
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import static org.hamcrest.Matchers.*
import static org.junit.Assert.assertThat

@Component
class SomeSteps {
  @Autowired
  Homepage homepage;

  MainHeadingPage currentPage;

  @BeforeStories
  void reset() {
    currentPage = null;
  }

  @Given("one starts at the homepage")
  void givenOneStartsAtTheHomepage() {
    homepage.open();
    currentPage = homepage;
  }

  @When("want to visit page 1")
  void whenWantToVisitPage1() {
    assertThat("current page can navigate to page 1", currentPage, instanceOf(NavigatesToPage1.class));
    assertThat("current page is not null", currentPage, notNullValue());
    currentPage = NavigatesToPage1.class.cast(currentPage).visitPage1();
  }

  @Then("I find myself on page 1")
  void thenIFindMyselfOnPage1() {
    assertThat(
      currentPage.mainHeadingText(),
      equalTo("Page 1")
    );
  }

  @When("want to visit page 2")
  void whenWantToVisitPage2() {
    assertThat(currentPage, instanceOf(NavigatesToPage2.class));
    currentPage = NavigatesToPage2.class.cast(currentPage).visitPage2();
  }

  @Then("I find myself on page 2")
  void thenIFindMyselfOnPage2() {
    assertThat(
      currentPage.mainHeadingText(),
      equalTo("Page 2")
    );
  }

  @Then("I find myself on homepage")
  void thenIFindMyselfOnHomepage() {
    assertThat(
      currentPage.mainHeadingText(),
      equalTo("Homepage")
    );
  }
}
