package com.example.autoconfigure;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

@Configuration
public class ConfigResourceListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
  @Override
  public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
    ConfigurableEnvironment env = event.getEnvironment();
    CustomConversionService conversionService = new CustomConversionService(env.getConversionService());
    env.setConversionService(conversionService);
  }
}