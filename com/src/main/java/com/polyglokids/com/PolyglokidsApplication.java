package com.polyglokids.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PolyglokidsApplication {

  public static void main(String[] args) {
    SpringApplication.run(PolyglokidsApplication.class, args);
    System.out.println("1");
  }
}
