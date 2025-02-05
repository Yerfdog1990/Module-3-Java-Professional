package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JDependency {
  public Logger logger = LogManager.getLogger(this.getClass());

  void doSomething() {
    System.out.println("Log4JDependency.doSomething()");
  }
}
