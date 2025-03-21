/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 package com.example.kafkaproducerapp;

 import org.springframework.kafka.core.KafkaTemplate;
 import org.springframework.stereotype.Service;

 import com.example.kafkaproducerapp.model.Models;
 
 @Service
 public class KafkaProducerService {
     private final KafkaTemplate<String, String> kafkaTemplate;
     private final KafkaTemplate<String, Models> kafkaJsonTemplate;
 
     public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate, 
                                KafkaTemplate<String, Models> kafkaJsonTemplate) {
         this.kafkaTemplate = kafkaTemplate;
         this.kafkaJsonTemplate = kafkaJsonTemplate;
     }
 
     public void sendMessage(String topic, String message) {
         kafkaTemplate.send(topic, message);
     }
     
     public void sendJSONMessage(String topic, Models model) {
         kafkaJsonTemplate.send(topic, model);
     }
 }
