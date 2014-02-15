package net.animetick.chronod.service

import java.io.File
import com.typesafe.scalalogging.slf4j.Logging

/**
 * ChronodDaemon
 */
class ChronodDaemon extends Logging {
  protected def setup() {
    val javaVersion = System.getProperty("java.version")
    val javaVmName = System.getProperty("java.vm.name")
    logger.info("JVM vendor/version: {}/{}", javaVmName, javaVersion)
    logger.info("Heap size: {}/{}",
      Runtime.getRuntime.totalMemory().toString,
      Runtime.getRuntime.maxMemory().toString)
    logger.info("Classpath: {}", System.getProperty("java.class.path"))
  }

  def start() {

  }

  def stop() {

  }

  def activate() {
    val pidFile = System.getProperty("chronod-pidfile")
    setup()
    if (pidFile != null) {
      new File(pidFile).deleteOnExit()
    }
    if (System.getProperty("chronod-foreground") == null) {
      System.out.close()
      System.err.close()
    }
    start()
  }

  trait Server {
    def start()
    def stop()
    def isRunning(): Boolean
  }
}


object ChronodDaemon {
  def main(args: Array[String]) {
    val daemon = new ChronodDaemon
    daemon.activate()
  }
}
