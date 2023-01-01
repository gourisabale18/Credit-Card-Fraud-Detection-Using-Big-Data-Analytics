package com.demo.config

import java.io.File
import com.demo.cassandra.CassandraConfig
import com.demo.kafka.KafkaConfig
import com.demo.spark.SparkConfig
import com.typesafe.config.{Config, ConfigFactory}
import org.apache.log4j.Logger

/**
Application Configuration for Fraud Detection Module
*/


object Config {
  val logger = Logger.getLogger(getClass.getName)

  var applicationConf: Config = _


  var runMode = "local"
  var localProjectDir = ""

  /**
   * Parse a config object from application.conf file in src/main/resources
   */
  def parseArgs(args: Array[String]) = {

    if(args.size == 0) {
      defaultSettiing
    } else {
      applicationConf = ConfigFactory.parseFile(new File(args(0)))
      val runMode = applicationConf.getString("config.mode")
      if(runMode == "local"){
        localProjectDir = s"file:///${System.getProperty("user.home")}/frauddetection/"
      }
      loadConfig()
    }

  }

  def loadConfig() = {

    CassandraConfig.load
    KafkaConfig.load
    SparkConfig.load
  }

  def defaultSettiing() = {

    CassandraConfig.defaultSettng()
    KafkaConfig.defaultSetting()
    SparkConfig.defaultSetting()
  }
}
