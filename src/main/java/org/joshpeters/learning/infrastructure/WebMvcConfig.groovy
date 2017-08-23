package org.joshpeters.learning.infrastructure
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
class WebMvcConfig extends WebMvcConfigurerAdapter {
  @Override
  void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController('/index.html').viewName = 'index';
    registry.addRedirectViewController('/', '/index.html');

    registry.addViewController('/page1.html').viewName = 'page1';
    registry.addViewController('/page2.html').viewName = 'page2';
  }
}
