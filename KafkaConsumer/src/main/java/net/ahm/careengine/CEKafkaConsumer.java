package net.ahm.careengine;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CEKafkaConsumer {

    private static final Logger log = LogManager.getLogger(CEKafkaConsumer.class.getName());

    public static void main(String[] args) throws UnknownHostException, InterruptedException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS z");
        String topicName[] = {"CECommunications_PHR"};
        log.info("Topic name is: {}", topicName);

        Properties props = new Properties();
//        props.put("bootstrap.servers", "azauvprdkafka01.ahmcert.com:9092, azauvprdkafka02.ahmcert.com:9092");
//        props.put("bootstrap.servers", "azbuvqa1kafka01.ahmcert.com:9092, azbuvqa1kafka02.ahmcert.com:9092");
//        props.put("bootstrap.servers", "azbuvqa2kafka01.ahmcert.com:9092, azbuvqa2kafka02.ahmcert.com:9092");
        props.put("bootstrap.servers", "azbuvqa1kafka01.ahmcert.com:9092");
        props.put("group.id", "ALPTDESAI7136TD5");// InetAddress.getLocalHost().getHostName() + "TD");// + (int) (Math.random() * 10));
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("security.protocol", "SASL_PLAINTEXT");
        props.put("auto.offset.reset", "earliest");
        props.put("sasl.kerberos.service.name", "kafka");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList(topicName));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("Received Message");
                log.info(
                        record.timestampType() + " = " + dateFormat.format(new Date(record.timestamp())) + ", Offset = " + record.offset() + ", Value = " + record.value());
            }
        }
    }
}
