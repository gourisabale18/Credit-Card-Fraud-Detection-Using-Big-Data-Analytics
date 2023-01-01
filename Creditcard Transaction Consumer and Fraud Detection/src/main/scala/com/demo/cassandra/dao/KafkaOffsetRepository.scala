package com.demo.cassandra.dao

import java.sql.Timestamp
import com.demo.creditcard.Enums
import com.datastax.driver.core.PreparedStatement
import org.apache.log4j.Logger
import org.apache.spark.sql.Row

/**

Kafka Offset Repository to insert data into Kafka Offset table on Cassandra
This data contains Kafka Partitions and Offset which are part of Kafka Topics
 */
object KafkaOffsetRepository {

  val logger = Logger.getLogger(getClass.getName)

  def cqlOffsetPrepare(db:String, table:String) = {
    s"""
     insert into $db.$table (
       ${Enums.TransactionCassandra.kafka_partition},
       ${Enums.TransactionCassandra.kafka_offset}
     )
     values(
       ?, ?
        )"""
  }

  def cqlOffsetBind(prepared: PreparedStatement, record:(Int, Long)) ={
    val bound = prepared.bind()
    bound.setInt(Enums.TransactionCassandra.kafka_partition,record._1)
    bound.setLong(Enums.TransactionCassandra.kafka_offset, record._2)
    bound
  }


  def cqlOffset(db:String, table:String, record: Row): String = s"""
     insert into $db.$table (
       ${Enums.TransactionCassandra.kafka_partition},
       ${Enums.TransactionCassandra.kafka_offset}
     )
     values(
        ${record.getAs[Int](Enums.TransactionCassandra.kafka_partition)},
        ${record.getAs[Long](Enums.TransactionCassandra.kafka_offset)}
        )"""

}
