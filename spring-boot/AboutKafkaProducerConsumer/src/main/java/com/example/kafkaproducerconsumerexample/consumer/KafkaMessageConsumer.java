package com.example.kafkaproducerconsumerexample.consumer;

import com.example.kafkaproducerconsumerexample.database.DataHolder;
import com.example.kafkaproducerconsumerexample.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageConsumer implements ConsumerSeekAware {
	
	private static final Logger LOG = LoggerFactory.getLogger(KafkaMessageConsumer.class);

	private static final String TOPIC = "test_topic";

	@Autowired
	private DataHolder dataHolder;

	private final ThreadLocal<ConsumerSeekCallback> seekCallBack = new ThreadLocal<>();

	@Override
	public void registerSeekCallback(ConsumerSeekCallback callback) {
		this.seekCallBack.set(callback);
	}

	@KafkaListener(topics = "test_topic", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
	public void consume(@Headers MessageHeaders headers,
						@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
						@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partitionId,
						@Header(KafkaHeaders.OFFSET) Long offset,
						@Payload Message message,
						Acknowledgment acknowledgment) {

		LOG.info("Consumed => [topic:{}|partision:{}|offset:{}|message:{}]", topic, partitionId, offset, message.getMessage());

		if(dataHolder.getData() == 1000) {
			acknowledgment.acknowledge();
			LOG.info("Done[{}]... => [topic:{}|partision:{}|offset:{}|message:{}]", dataHolder.getData(), topic, partitionId, offset, message.getMessage());
			return;
		}

		dataHolder.plusData();
		LOG.info("Retry[{}]... => [topic:{}|partision:{}|offset:{}|message:{}]", dataHolder.getData(), topic, partitionId, offset, message.getMessage());
		this.seekCallBack.get().seek(TOPIC, partitionId, offset);
	}
}
