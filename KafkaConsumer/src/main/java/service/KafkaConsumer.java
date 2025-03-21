package service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import service.model.Models;

@Component
public class KafkaConsumer {

	@KafkaListener(topics = "test-topic", groupId = "my-group")
	public void consume(String message) {
		// Print statement
		System.out.println("message = " + message);
	}

	@KafkaListener(topics = "models-topic", groupId = "json-group", containerFactory = "modelKafkaListenerContainerFactory")
	public void consumeJsonMessage(Models model) {
		System.out.println("Received JSON Message: " + model);
	}
}
