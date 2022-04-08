package com.users.api.core.event;

/**
 * Interfaz para definir el tipo de comando a enviar en eventos
 *
 * @author diego
 */
public interface IEventType {
    /**
     * Es el nombre del comando
     *
     * @return el nombre del comando a ejecutar o que se ejecuto
     */
    String getName();
}
