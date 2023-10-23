package ec.ferchoc.springboot_kafka.kafka;

import ec.ferchoc.springboot_kafka.payload.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JsonKafkaProducer {

    @Value("${spring.kafka.topic-json.name}")
    private String jsonTopic;

    private final KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPayload(User user) {

        log.info("User sent: {}", user.toString());

        var message = MessageBuilder.withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, jsonTopic)
                .build();

        this.kafkaTemplate.send(message);

    }

}
