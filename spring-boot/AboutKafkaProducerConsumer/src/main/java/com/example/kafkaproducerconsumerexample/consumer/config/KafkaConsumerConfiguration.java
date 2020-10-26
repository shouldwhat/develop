package com.example.kafkaproducerconsumerexample.consumer.config;

import com.example.kafkaproducerconsumerexample.model.Message;
import com.example.kafkaproducerconsumerexample.producer.config.KafkaProducerConfiguration;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfiguration implements InitializingBean {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaProducerConfiguration.class);
	
	@Bean
	public ConsumerFactory<String, Message> consumerFactory() {
		
		Map<String, Object> configs = new HashMap<>();

		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.27.0.71:9092");
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
//		configs.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "10000");
		configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		configs.put(ConsumerConfig.ALLOW_AUTO_CREATE_TOPICS_CONFIG, "true");
		configs.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, "10000");
		configs.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");
		configs.put(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG, "10000");

		return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new JsonDeserializer<>(Message.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Message> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Message> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
		return factory;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		LOG.info("KafkaConsumerConfiguration has initialized...");
	}
}
