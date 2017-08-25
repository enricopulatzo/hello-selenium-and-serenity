package org.joshpeters.learning.integration

import net.serenitybdd.jbehave.SerenityStories
import org.jbehave.core.steps.InjectableStepsFactory
import org.jbehave.core.steps.spring.SpringApplicationContextFactory
import org.jbehave.core.steps.spring.SpringStepsFactory
import org.junit.Rule
import org.springframework.test.context.junit4.rules.SpringClassRule

/**
 * Integration Test which uses Serenity + JBehave + Spring to execute
 */
class ApplicationIT extends SerenityStories {
  @Rule
  static SpringClassRule springClassRule = new SpringClassRule()

  @Override
  InjectableStepsFactory stepsFactory() {
    new SpringStepsFactory(
      configuration(),
      new SpringApplicationContextFactory(BddContextConfig.name).createApplicationContext()
    )
  }
}
