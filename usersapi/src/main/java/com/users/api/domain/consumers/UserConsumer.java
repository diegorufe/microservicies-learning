package com.users.api.domain.consumers;

import com.users.api.domain.commands.UserCommand;
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
    public void listener(UserCommand userCommand) {
        log.info("UserCommand received {} ", userCommand.toString());
        //Do something
    }
}
