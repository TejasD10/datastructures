package net.ahm.careengine;

import java.util.Properties;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CEStreams {
	private static final Logger log = LogManager.getLogger(CEKafkaProducer.class.getName());
	
	public static void main(String[] args) {
		String topicName = "CEMarkers";
		Properties props = new Properties();
		
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "CEStreamConsumer");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "nycuvqa1kafka01.ahmcert.com:9092");
		props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
		props.put("sasl.kerberos.service.name", "kafka");
		
		KStreamBuilder builder = new KStreamBuilder();
		builder.stream(topicName);
		KafkaStreams streams = new KafkaStreams(builder, props);
		streams.start();
		
	}
}
