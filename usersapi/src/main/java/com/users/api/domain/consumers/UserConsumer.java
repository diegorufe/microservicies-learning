package com.users.api.domain.consumers;

import com.users.api.domain.event.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Consumidor de eventos de usuarios
 *
 * @author diego
 */
@Component
@Slf4j
public class UserConsumer {

    @KafkaListener(topics = "${kafka.topic.user.name}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "userKafkaListenerContainerFactory")
    public void listener(UserEvent event) {
        log.info("UserCommand received {} ", event);
        //Do something
    }
}
