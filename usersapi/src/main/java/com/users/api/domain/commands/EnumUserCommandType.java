package com.users.api.domain.commands;

import com.users.api.core.commands.ICommandType;

/**
 * Enumerado para definir los tipos de comandos de usuarios
 *
 * @author diego
 */
public enum EnumUserCommandType implements ICommandType {
    CREATED,
    ;

    @Override
    public String getName() {
        return this.name();
    }
}
