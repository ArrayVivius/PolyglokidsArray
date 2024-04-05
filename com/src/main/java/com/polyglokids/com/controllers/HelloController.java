package com.polyglokids.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polyglokids.com.usecases.SeyHello;

/**
 * hello
 */

@RestController
public class HelloController {

  @GetMapping("hello")
  public String hellat() {
    // String a = SeyHello.hello();
    String a = "hello";
    return a;
  }
}
