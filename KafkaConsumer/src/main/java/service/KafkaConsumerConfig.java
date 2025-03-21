package service;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import service.model.Models;


//@EnableKafka
@Configuration  
public class KafkaConsumerConfig {
    @Bean
    public ConsumerFactory<String, Models> modelConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        props.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        props.put(JsonDeserializer.TYPE_MAPPINGS, "com.example.kafkaproducerapp.model.Models:service.model.Models");
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, "service.model.Models");
        
        return new DefaultKafkaConsumerFactory<>(props);
    }
	
    //KafkaListenerContainerFactory for JSON
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Models> modelKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Models> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(modelConsumerFactory());
        return factory;
    }
    
    
}