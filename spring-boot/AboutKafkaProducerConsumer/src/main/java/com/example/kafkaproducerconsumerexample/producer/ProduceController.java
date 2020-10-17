package com.example.kafkaproducerconsumerexample.producer;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaproducerconsumerexample.model.Message;

@RestController
public class ProduceController {

	private static final Logger LOG = LoggerFactory.getLogger(ProduceController.class);
	
	private static final String TOPIC = "test_topic";
	
	@Autowired
	private KafkaTemplate<String, Message> kafkaMessageTemplate;
	
	@PostMapping(value = "/produces/{message}/model")
	public void produceModel(HttpServletRequest request,
			@PathVariable("message") String message) {
		kafkaMessageTemplate.send(TOPIC, new Message(message));
		LOG.info("send => {}", message);
	}
}
