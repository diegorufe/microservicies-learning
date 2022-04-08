package com.users.api.domain.eventsTypes;

import com.users.api.core.event.IEventType;

/**
 * Enumerado para definir los tipos de comandos de usuarios
 *
 * @author diego
 */
public enum EnumUserEventType implements IEventType {

    CREATED,

    EDITED,

    DELETED,

    ;

    @Override
    public String getName() {
        return this.name();
    }
}
