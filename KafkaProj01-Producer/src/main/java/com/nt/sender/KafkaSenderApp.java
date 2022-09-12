package com.nt.sender;

import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaSenderApp {
	public static void main(String[] args) {
		//Prepare Kafka Properties using java.util.Properties class object
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		//Create KafkaProducer object
		KafkaProducer<String, String> producer = new KafkaProducer<>(props);
		ProducerRecord<String, String> record = null;
		String msg = null;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the message : ");
			msg = scanner.nextLine();
			//Create ProducerRecord object having topic name and Message
			record = new ProducerRecord<String, String>("nit-tp1", msg);
			//send the message
			producer.send(record);
			//flush the message
			producer.flush();
		} while (!msg.equalsIgnoreCase("STOP"));
		//close the link with Bootstrap Server
		producer.close();
	}
}
