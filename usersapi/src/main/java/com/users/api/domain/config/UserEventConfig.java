package com.users.api.domain.config;

import com.users.api.domain.commands.UserCommand;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuración de eventos para usuarios
 *
 * @author diego
 */
@Component
public class UserEventConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    private ConsumerFactory<String, UserCommand> userConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        // Indicamos cual debe ser su serializador para convertir los mensajes a enviar
        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                new JsonDeserializer<>(UserCommand.class));
    }

    /**
     * Configuración de consumidor para poder tratar de forma adecuada los eventos producidos por usuarios
     * Esto no tiene mucho sentido ser productor y consumidor de si mismo pero para poder reazliar pruebas de forma rápida es la mejor opción
     */
    @Bean("userKafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, UserCommand> userKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, UserCommand> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(userConsumerFactory());
        return factory;
    }

    /**
     * Configuración de la factoria para poder enviar eventos utilizando serializadores adecuados para los objetos que enviemos
     *
     * @return
     */
    @Bean
    public ProducerFactory<String, UserCommand> userProducerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    /**
     * Template de kafka con la configuración para que en el mensaje enviado podamos enviar un bean y este lo transforme en json
     *
     * @return
     */
    @Bean
    public KafkaTemplate<String, UserCommand> userKafkaTemplate() {
        return new KafkaTemplate<>(userProducerFactory());
    }
}
