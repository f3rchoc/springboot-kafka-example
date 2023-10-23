package ec.ferchoc.springboot_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfigTopic {

    @Value("${spring.kafka.topic.name}")
    private String topic;

    @Value("${spring.kafka.topic-json.name}")
    private String jsonTopic;

    @Bean
    public NewTopic myTopic() {
        return TopicBuilder.name(topic).build();
    }

    @Bean
    public NewTopic myTopicJson() {
        return TopicBuilder.name(jsonTopic).build();
    }

}
