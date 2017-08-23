package org.joshpeters.learning.integration

import net.serenitybdd.core.webdriver.driverproviders.PhantomJSDriverProvider
import net.thucydides.core.fixtureservices.ClasspathFixtureProviderService
import net.thucydides.core.fixtureservices.FixtureProviderService
import net.thucydides.core.util.EnvironmentVariables
import net.thucydides.core.util.SystemEnvironmentVariables
import net.thucydides.core.webdriver.CapabilityEnhancer
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BddContextConfig {
  @Bean
  WebDriver webDriver() {
    final WebDriver result = getPhantomJSDriverProvider().newInstance();
    result.manage().window().setSize(size());
    result;
  }

  @Bean
  Dimension size() {
    new Dimension(1024, 768);
  }

  @Bean
  PhantomJSDriverProvider getPhantomJSDriverProvider() {
    new PhantomJSDriverProvider(getEnvironmentVariables(), getEnhancer());
  }

  @Bean
  CapabilityEnhancer getEnhancer() {
    new CapabilityEnhancer(getEnvironmentVariables(), getFixtureProviderService());
  }

  @Bean
  FixtureProviderService getFixtureProviderService() {
    new ClasspathFixtureProviderService();
  }

  @Bean
  EnvironmentVariables getEnvironmentVariables() {
    new SystemEnvironmentVariables();
  }
}
