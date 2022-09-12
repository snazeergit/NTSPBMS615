package com.nt.receiver;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaReceiverApp {
	public static void main(String[] args) {
		//Prepare Kafka Connection Properties using java.util.Properties class object
		Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "grp1-consumers");

		//Create KafkaConsumer object
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

		//subscribe to topic Destination through MessageBroker
		consumer.subscribe(Arrays.asList("nit-tp1"));

		//Performing polling to check and read the messages
		while (true) {
			//Poll and get consumer records(messages)
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(2));

			//read and display messages
			for (ConsumerRecord<String, String> record : records) {
				System.out.println("Message received : " + record.value());
			}
		}
	}
}
