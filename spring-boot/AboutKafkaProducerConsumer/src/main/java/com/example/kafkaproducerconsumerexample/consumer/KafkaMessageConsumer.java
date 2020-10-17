package com.example.kafkaproducerconsumerexample.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafkaproducerconsumerexample.model.Message;

@Service
public class KafkaMessageConsumer {
	
	private static final Logger LOG = LoggerFactory.getLogger(KafkaMessageConsumer.class);
			
	@KafkaListener(topics = "test_topic", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
	public void consume(Message message) {
		LOG.info("Consumed => {}", message);
	}

}
