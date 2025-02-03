package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JTrigger {
  public static final Logger logger = LogManager.getLogger(Log4JExample.class);

  public void triggerLogging() {
    logger.trace("This is a trace message from Log4J");
    logger.debug("This is a debug message from Log4J");
    logger.info("This is an info message from Log4J");
    logger.warn("This is a warn message from Log4J");
    logger.error("This is an error message from Log4J");
    logger.fatal("This is a fatal message from Log4J");
  }
}
