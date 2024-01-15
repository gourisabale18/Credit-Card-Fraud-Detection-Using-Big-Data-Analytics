
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






