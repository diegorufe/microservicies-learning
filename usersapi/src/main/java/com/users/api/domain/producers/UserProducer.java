package com.users.api.domain.producers;

import com.users.api.domain.commands.UserCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Productor de eventos de usuarios
 *
 * @author diego
 */
@Component
@Slf4j
public class UserProducer {

    @Autowired
    private KafkaTemplate<String, UserCommand> userKafkaTemplate;

    @Value(value = "${kafka.topic.user.name}")
    private String topic;

    /**
     * Método para enviar un evento en base a un comando recibido
     *
     * @param userCommand es el comando de usuario que queremos enviar
     */
    public void sendEventFromCommand(UserCommand userCommand) {
        ListenableFuture<SendResult<String, UserCommand>> future = this.userKafkaTemplate.send(this.topic, userCommand);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, UserCommand> result) {
                log.info("UserCommand {} has been sent ", userCommand);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Something went wrong with the user command {} ", userCommand);
            }
        });
    }
}
