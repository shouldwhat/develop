package com.example.kafkaproducerconsumerexample.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.kafkaproducerconsumerexample.model.Message;
import com.example.kafkaproducerconsumerexample.producer.config.KafkaProducerConfiguration;

@Configuration
@EnableKafka
public class KafkaConsumerConfiguration implements InitializingBean {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaProducerConfiguration.class);
	
	@Bean
	public ConsumerFactory<String, Message> consumerFactory() {
		
		Map<String, Object> configs = new HashMap<>();
		
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,  JsonSerializer.class);
		
		return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new JsonDeserializer<>(Message.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Message> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Message> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		LOG.info("KafkaConsumerConfiguration has initialized...");
	}
}
