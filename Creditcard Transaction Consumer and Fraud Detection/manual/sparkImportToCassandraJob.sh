#!/usr/bin/env bash
# Import intial data to Cassandra..
spark-submit  --class com.demo.spark.jobs.IntialImportToCassandra --name "Import Data to Cassandra" --master spark://demo:7077 $HOME/frauddetection/spark/fruaddetection-spark.jar $HOME/frauddetection/spark/application-local.conf

