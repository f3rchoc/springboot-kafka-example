package ec.ferchoc.springboot_kafka.kafka;

import ec.ferchoc.springboot_kafka.payload.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JsonKafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user) {
        log.info("User received: {}", user.toString());
    }

}
