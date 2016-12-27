# SpringBoot-Kafka-Template

## About

A Spring Boot-based project that has an API application and a Client application that use Kafka for messaging between them.  The idea is that this can be used as a template for new projects having similar needs

## Setup

### Install and Setup Kafka (which includes Zookeeper)

Download the binary:    **http://kafka.apache.org/downloads.html**

Explode the downloaded file and put it in a common dir of your choice, like:    **/usr/local**

Create a symlink for it:   **ln -s /usr/local/kafka_2.11-0.10.1.0 /usr/local/kafka**

Create KAFKA_HOME environment variable (maybe in .bash_profile): **export KAFKA_HOME=/usr/local/kafka**

## Run

### Zookeeper and Kafka

Start Zookeeper first, specifying where the configuration properties file it requires is:

	$KAFKA_HOME/bin/zookeeper-server-start.sh  $KAFKA_HOME/config/zookeeper.properties

Start Kafka (on a different tab?), which too requires a configuration file

	$KAFKA_HOME/bin/kafka-server-start.sh  $KAFKA_HOME/config/server.properties

### Spring Boot-based API and Kafka Client applications

Start up the API application (aka Kafka Producer) from the root of the project:

    cd api
    gradle clean build
    java -jar build/libs/springboot-kafka-template-api-0.0.1-SNAPSHOT.jar

Then start up the Kafka-Consumer application from the root of the project:
     
    cd kafka-consumer
    gradle clean build
    java -jar build/libs/springboot-kafka-template-consumer-0.0.1-SNAPSHOT.jar

### Test that it is all working

At this point some sample messages can be generated using this endpoint:

    http://localhost:8080/generateWork?id=1&definition=test

The producer should print a message on the console that the Work unit has been dispatched and the consumer should receive and process the Work unit
