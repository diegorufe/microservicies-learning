package com.users.api.domain.commands;

import com.users.api.core.commands.ICommandType;

/**
 * Enumerado para definir los tipos de comandos de usuarios
 *
 * @author diego
 */
public enum EnumUserCommandType implements ICommandType {
    CREATE,
    ;

    @Override
    public String getName() {
        return this.name();
    }
}
