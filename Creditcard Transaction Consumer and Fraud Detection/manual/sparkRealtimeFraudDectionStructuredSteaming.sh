#!/usr/bin/env bash
#Structured Streaming Spark Job
spark-submit --class com.demo.spark.jobs.RealTimeFraudDetection.StructuredStreamingFraudDetection --name "RealTime Creditcard FraudDetection Structured Streaming" --master spark://demo:7077 --deploy-mode cluster  $HOME/frauddetection/spark/fruaddetection-spark.jar $HOME/frauddetection/spark/application-local.conf
