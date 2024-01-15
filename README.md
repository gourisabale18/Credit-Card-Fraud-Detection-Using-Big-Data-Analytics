
## Credit Card Fraud Detection Using Real Time Big Data Analytics

### Overview 

This project aims to develop a real-time big data analytics application that is used for Credit Card Fraud Detection. As a part of this project, we will perform real-time data processing of Credit Card Transactions using Apache Kafka Streaming. We will detect fraudulent transactions using Apache Spark and Machine Learning Algorithms and make predictions by learning from historical data. The results of fraudulent transactions and normal transactions would be displayed in the form of alerts on intelligent Dashboards.

### Functionalities

#### Real Time Data Streaming:
Credit card transactions are generated in real time using Kafka Producer where we are simulating the real world behavior by capturing the transactions for every 5 seconds.

#### ML model for fraud detection:        
Machine Learning is a type of AI(Artificial Intelligence) that allows applications to become more accurate at predicting the results without being explicitly programmed.
For fraud detection, preprocessing random forest algorithms are used to build ML models for historical credit card transactions.This model is combined with Spark to classify if a real time credit card transaction is fraud. 

#### Develop Real Time Fraud Alert Dashboards:
The results of prediction models are displayed on the Fraud Alert dashboard. Our analysis using the ML model will classify fraudulent and non fraudulent transactions.


The high level design of our system is as follows:
#### The File System 
It stores customer specific data related to credit card transactions.
There are two files in this system.One is used to store customer’s data and the other is used to store data related to credit card transactions.

#### Spark SQL job: 
This job performs the following operations.
Read data related to customers including credit card transactions from the file system.
Write the data to Cassandra database tables.

#### Spark ML job: 
Read the customer and transactions specific data from Cassandra
Pre-process the data using techniques like String indexer ,One hot encoder and vector assembler
Use K means algorithm to balance the data related to fraud and non fraud transactions
Use Random Forest to train the data and build ML models.
Save the models back to the file system.

#### Credit Card producer:
Generate real time credit card transactions using Apache Kafka framework and Avro Schemas
Store these transactions on Kafka topics.

#### Spark Streaming job: 
 Load ML models from file system.
Consume credit card transactions from Kafka topics. 
Predict whether credit card transactions are fraud or not by referring to ML models.
Save the results of predictions into the Cassandra database.

#### Fraud Alert Dashboard:
Read the analysis results from Cassandra. 
Display fraudulent and non fraudulent credit card transactions on a real time fraud alert dashboard.

### Architecture and Design


  
 ![kafka](https://github.com/gourisabale18/Credit-Card-Fraud-Detection-Using-Big-Data-Analytics/assets/24734082/cc40c6c5-1e92-4275-8c23-dd4d669ec821)

 The above diagram depicts high-level design of the system. It comprises three spark jobs.

#### The File System 
It stores customer specific data related to credit card transactions.
There are two files in this system.One is used to store customer’s data and the other is used to store data related to credit card transactions.

#### Spark SQL job: 
This job performs the following operations.
Read data related to customers including credit card transactions from the file system.
Write the data to Cassandra database tables.

#### Spark ML job: 
Read the customer and transactions specific data from Cassandra
Pre-process the data using techniques like String indexer ,One hot encoder and vector assembler
Use K means algorithm to balance the data related to fraud and non fraud transactions
Use Random Forest to train the data and build ML models.
Save the models back to the file system.

#### Credit Card producer:
Generate real time credit card transactions using Apache Kafka framework and Avro Schemas
Store these transactions on Kafka topics.

#### Spark Streaming job: 
 Load ML models from file system.
Consume credit card transactions from Kafka topics. 
Predict whether credit card transactions are fraud or not by referring to ML models.
Save the results of predictions into the Cassandra database.

#### Fraud Alert Dashboard:
Read the analysis results from Cassandra. 
Display fraudulent and non fraudulent credit card transactions on a real time fraud alert dashboard.


### Deployment Instructions


1)Install Cassandra db on your file system.
2)Start the cassandra server from the cmd prompt using the following command.
cassandra -f
3)Connect to Cassandra db using cqlsh
Open cmd line and type cqlsh
4)Create keyspace 
 CREATE KEYSPACE creditcard WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
5)Create db table on cassandra
use creditcard; //use creditcard keyspace
6)Execute following scripts to create tables
CREATE TABLE fraud_transaction (
  cc_num text,
  trans_time timestamp,
  trans_num text,
  category text,
  merchant text,
  amt double,
  merch_lat double,
  merch_long double,
  distance double,
  age int,
  is_fraud double,
  PRIMARY KEY(cc_num, trans_time)
)WITH CLUSTERING ORDER BY (trans_time DESC);

CREATE TABLE non_fraud_transaction (
  cc_num text,
  trans_time timestamp,
  trans_num text,
  category text,
  merchant text,
  amt double,
  merch_lat double,
  merch_long double,
  distance double,
  age int,
  is_fraud double,
  PRIMARY KEY(cc_num, trans_time)
)WITH CLUSTERING ORDER BY (trans_time DESC);
CREATE TABLE IF NOT EXISTS kafka_offset (
  partition int,
  offset bigint,
  PRIMARY KEY(partition)
);

CREATE TABLE IF NOT EXISTS customer (
  cc_num text,
  first text,
  last text,
  gender text,
  street text,
  city text,
  state text,
  zip text,
  lat double,
  long double,
  job text,
  dob timestamp,
  PRIMARY KEY(cc_num)
);
7)Install Apache Kafka
8)Go to Kafka Config folder (E:\kafka\config) and open server.properties file
Update the attribute log.dirs to following value
log.dirs=E:/kafka/kafka-logs
Open zookeeper.properties file and update the property dataDir to the following value.
dataDir=E:/zookeeper
Change zookeeper.properties data dir to kafka location
9)Create Topic: Go to the Kafka root directory and start kafka server and zookeeper server from two different cmd windows
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
.\bin\windows\kafka-server-start.bat .\config\server.properties
Cmd for Topic creation:
.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic TestTopic


### Execution Steps for Project are as follows:
1. Start cassandra server
Cassandra   -f

![scala7](https://github.com/gourisabale18/Credit-Card-Fraud-Detection-Using-Big-Data-Analytics/assets/24734082/ff9522a4-4643-4c71-8ef1-9bfad3373cbc)

2. Start zookeeper server
Go to the kafka root directory and open cmd from that explorer and run command:
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

![scala6](https://github.com/gourisabale18/Credit-Card-Fraud-Detection-Using-Big-Data-Analytics/assets/24734082/e07765a6-a4ac-42db-82a4-489048c0a952)


3. Start Kafka Server
Run following command from kafka root directory
.\bin\windows\kafka-server-start.bat .\config\server.properties

![scala4](https://github.com/gourisabale18/Credit-Card-Fraud-Detection-Using-Big-Data-Analytics/assets/24734082/86a18643-46b4-42ef-9a65-b78de8796349)

4. Choose Credit Card Transaction Consumer and Fraud Detection module into a new project window
Run the scala file
IntialImportToCassandra.scala

5. Run the scala file 
FraudDetectionTraining.scala


6. Run the scala file

 DstreamFraudDetection.scala
OR
 StructuredStreamingFraudDetection.scala
 
![scala3](https://github.com/gourisabale18/Credit-Card-Fraud-Detection-Using-Big-Data-Analytics/assets/24734082/d42df3fa-49e8-4feb-ab49-c1ea456fdfdc)


7. Choose Credit Card Transaction Producer module into a new project window
 Run the scala file 
TransactionProducer.scala

![scala2](https://github.com/gourisabale18/Credit-Card-Fraud-Detection-Using-Big-Data-Analytics/assets/24734082/a9525e7a-ac51-4a0e-8cb3-3b91dde47afd)

8. Choose Real time Fraud Alert Dashboard module into a new project window
 Run the scala file TransactionProducer.scala
 
![scala](https://github.com/gourisabale18/Credit-Card-Fraud-Detection-Using-Big-Data-Analytics/assets/24734082/aba7c4fa-be6c-4500-aff9-d04f025b259c)

### Test Results



![result1](https://github.com/gourisabale18/Credit-Card-Fraud-Detection-Using-Big-Data-Analytics/assets/24734082/c9af35b9-cdae-4cf8-b43e-1eb83450f572)


![result2](https://github.com/gourisabale18/Credit-Card-Fraud-Detection-Using-Big-Data-Analytics/assets/24734082/9d0c5422-c8e0-4f68-a547-3b2bf1b09309)




