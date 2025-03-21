package service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = KafkaConsumerApplication.class)
@EnableAutoConfiguration(exclude = KafkaAutoConfiguration.class)
class KafkaConsumerApplicationTests {

    @Test
    void contextLoads() {
    }
}
