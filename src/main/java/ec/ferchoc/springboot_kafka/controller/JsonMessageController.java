package ec.ferchoc.springboot_kafka.controller;

import ec.ferchoc.springboot_kafka.kafka.JsonKafkaProducer;
import ec.ferchoc.springboot_kafka.payload.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/kafka")
@RestController
@AllArgsConstructor
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    @GetMapping("/{id}")
    public ResponseEntity<String> publishMessage(@PathVariable("id") Integer id,
                                                 @RequestParam("firstName") String firstName,
                                                 @RequestParam("lastName") String lastName) {
        this.jsonKafkaProducer.sendPayload(new User(id, firstName, lastName));
        return ResponseEntity.ok("Message sent to the topic");
    }

}
