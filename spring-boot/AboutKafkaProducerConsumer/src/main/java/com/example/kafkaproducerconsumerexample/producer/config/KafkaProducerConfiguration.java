package com.example.kafkaproducerconsumerexample.producer.config;

import com.example.kafkaproducerconsumerexample.model.Message;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfiguration implements InitializingBean {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaProducerConfiguration.class);
	
	@Bean
	public ProducerFactory<String, Message> producerFactory() {
		
		Map<String, Object> configs = new HashMap<>();
		
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.27.0.71:9092");
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,  JsonSerializer.class);

		return new DefaultKafkaProducerFactory<>(configs);
	}
	
	@Bean
	public KafkaTemplate<String, Message> kafkaMessageTemplate() {
		return new KafkaTemplate<String, Message>(producerFactory());
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		LOG.info("KafkaProducerConfiguration has initialized...");
	}
}
