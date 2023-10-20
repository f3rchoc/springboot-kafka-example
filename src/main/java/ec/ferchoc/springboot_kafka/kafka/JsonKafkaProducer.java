package ec.ferchoc.springboot_kafka.kafka;

import ec.ferchoc.springboot_kafka.payload.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class JsonKafkaProducer {


    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendPayload(User user) {

        log.info("User sent: {}", user.toString());

        var message = MessageBuilder.withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "myTopic")
                .build();

        this.kafkaTemplate.send(message);

    }

}
