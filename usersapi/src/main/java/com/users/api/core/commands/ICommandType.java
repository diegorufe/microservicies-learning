package com.users.api.core.commands;

/**
 * Interfaz para definir el tipo de comando a enviar en eventos
 *
 * @author diego
 */
public interface ICommandType {
    /**
     * Es el nombre del comando
     *
     * @return el nombre del comando a ejecutar o que se ejecuto
     */
    String getName();
}
