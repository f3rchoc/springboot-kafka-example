package ec.ferchoc.springboot_kafka.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "myTopic", groupId = "group01")
    public void consume(String message) {
        log.info("Message received: {}", message);
    }

}
