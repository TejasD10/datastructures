package net.ahm.careengine;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CEKafkaConsumer {

	private static final Logger log = LogManager.getLogger(CEKafkaConsumer.class.getName());

	public static void main(String[] args) throws UnknownHostException {
		String topicName = "MemberDataNewEvents";
		log.info("Topic name is: {}", topicName);

		Properties props = new Properties();
		props.put("bootstrap.servers", "azbuvuatkafka01.activehealth.loc:9092,azbuvuatkafka02.activehealth.loc:9092");
		props.put("group.id", InetAddress.getLocalHost().getHostName().toString() + "TD");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("security.protocol", "SASL_PLAINTEXT");
		props.put("sasl.kerberos.service.name", "kafka");
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		consumer.subscribe(Arrays.asList(topicName));
		
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(100);

			for (ConsumerRecord<String, String> record : records) {
				System.out.println(
						"Offset = " + record.offset() + ", Value = " + record.value());
			}

		}

	}
}
