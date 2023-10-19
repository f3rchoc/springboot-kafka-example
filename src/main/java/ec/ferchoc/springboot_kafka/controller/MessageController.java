package ec.ferchoc.springboot_kafka.controller;

import ec.ferchoc.springboot_kafka.kafka.KafkaProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
@AllArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;

    // http://localhost:8080/api/v1/kafka
    @GetMapping
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message) {
        this.kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }

}
