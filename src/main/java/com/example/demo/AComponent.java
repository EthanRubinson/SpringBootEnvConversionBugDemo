package com.example.demo;

import java.net.URL;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AComponent {

  @Autowired
  Environment env;

  @PostConstruct
  public void init() {
    System.setProperty("aCustomProperty", "CUSTOM_STRING_VALUE_THAT_RESOLVES_TO_THE_SPRING.IO_URL");
    System.out.println(env.getProperty("aCustomProperty", URL.class));
  }

}
