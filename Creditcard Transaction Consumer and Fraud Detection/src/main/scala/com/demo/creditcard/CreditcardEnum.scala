package com.demo.creditcard

object  Enums {

  /**
  * Enum for Credit Card Transactions
  * Columns in our dataset are included in this enum
  * */

  object TransactionKafka extends Enumeration {

    val cc_num = "cc_num"
    val first = "first"
    val last = "last"
    val trans_num = "trans_num"
    val trans_date = "trans_date"
    val trans_time = "trans_time"
    val unix_time = "unix_time"
    val category = "category"
    val merchant = "merchant"
    val amt = "amt"
    val merch_lat = "merch_lat"
    val merch_long = "merch_long"
    val distance = "distance"
    val age = "age"
    val is_fraud = "is_fraud"
    val kafka_partition = "partition"
    val kafka_offset = "offset"

  }

  object Customer extends Enumeration {

    val cc_num = "cc_num"
    val first = "first"
    val last = "last"
    val gender = "gender"
    val street = "street"
    val city = "city"
    val state = "state"
    val zip = "zip"
    val lat = "lat"
    val long = "long"
    val job = "job"
    val dob = "dob"
  }

  val TransactionCassandra = TransactionKafka
}