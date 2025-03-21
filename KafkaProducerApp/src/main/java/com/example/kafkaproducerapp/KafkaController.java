/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.kafkaproducerapp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaproducerapp.model.Models;

/**
 *
 * @author dlwlrma
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private final KafkaProducerService producerService;
    
    @Autowired
    private KafkaTemplate<String, Models> kafkaJsonTemplate;
    
    private static final String TOPIC_NAME = "models-topic";

    public KafkaController(KafkaProducerService producerService, KafkaTemplate<String, Models> kafkaJsonTemplate) {
        this.producerService = producerService;
        this.kafkaJsonTemplate = kafkaJsonTemplate;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        String topic = "test-topic";
        producerService.sendMessage(topic, message);
        return "Message: '" + message + "' was sent to Kafka topic: " + topic;
    }

    @PostMapping(value = "/postItem", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> postJsonMessage(@RequestBody Models model) {
        producerService.sendJSONMessage(TOPIC_NAME, model);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Message sent to Kafka topic: " + TOPIC_NAME + " successfully");
        
        response.put("id", String.valueOf(model.getId()));
        response.put("model_name", model.getModel_name());
        response.put("company", model.getCompany());
        
        return ResponseEntity.ok(response);
    }
    
}
