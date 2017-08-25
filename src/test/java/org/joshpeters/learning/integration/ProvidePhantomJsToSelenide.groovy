package org.joshpeters.learning.integration
import com.codeborne.selenide.WebDriverProvider
import net.serenitybdd.core.webdriver.driverproviders.PhantomJSDriverProvider
import net.thucydides.core.fixtureservices.ClasspathFixtureProviderService
import net.thucydides.core.fixtureservices.FixtureProviderService
import net.thucydides.core.util.EnvironmentVariables
import net.thucydides.core.util.SystemEnvironmentVariables
import net.thucydides.core.webdriver.CapabilityEnhancer
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities

class ProvidePhantomJsToSelenide implements WebDriverProvider {
  @Override
  WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
    def result = webDriver()
    ThucydidesWebDriverSupport.useDriver(result)
    result
  }

  WebDriver webDriver() {
    final WebDriver result = getPhantomJSDriverProvider().newInstance()
    result.manage().window().size = size()
    result
  }

  Dimension size() {
    new Dimension(1024, 768);
  }

  PhantomJSDriverProvider getPhantomJSDriverProvider() {
    new PhantomJSDriverProvider(environmentVariables, enhancer)
  }

  CapabilityEnhancer getEnhancer() {
    new CapabilityEnhancer(environmentVariables, fixtureProviderService);
  }

  FixtureProviderService getFixtureProviderService() {
    new ClasspathFixtureProviderService();
  }

  EnvironmentVariables getEnvironmentVariables() {
    new SystemEnvironmentVariables();
  }
}
