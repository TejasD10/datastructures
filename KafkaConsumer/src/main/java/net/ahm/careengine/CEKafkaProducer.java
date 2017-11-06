package net.ahm.careengine;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CEKafkaProducer {

	private static final Logger log = LogManager.getLogger(CEKafkaProducer.class.getName());
	private static KafkaProducer<Integer, String> producer;
	
	public static void main(String[] args) {
		String topicName = "CEmemberRun";
		log.info("Topic name is: {}", topicName);
		Properties props = new Properties();

		props.put("bootstrap.servers", "nycuvig1kafka01.ahmcert.com:9092");
		// props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("security.protocol", "SASL_PLAINTEXT");
		props.put("sasl.kerberos.service.name", "kafka");
		// props.put("max.block.ms", "2000");

		try {
			producer = new KafkaProducer<Integer, String>(props);
			System.out.println("Kafka Producer created");
			String jsonString = "{\"memberPlanId\" : 72860305,\"memberId\" : 64709727,\"eventTypes\" : [ \"LAB\", \"CLINICAL\" ],\"accountId\" : null,\"supplierId\" : null,\"eventSource\" : \"AA\"}";
			for (int i = 0; i < 1; i++) {
				producer.send(new ProducerRecord<Integer, String>(topicName, i, jsonString), new Callback() {

					public void onCompletion(RecordMetadata metaData, Exception exception) {
						if (exception != null) {
							System.out.println("Exception Occured" + exception.getMessage());
							return;
						}
						System.out.println("Message Sent on " + metaData.topic() + " ,partion " + metaData.partition()
								+ " ,offset " + metaData.offset());
					}
				});
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} finally {
			if (producer != null)
				producer.close();
		}
	}
}