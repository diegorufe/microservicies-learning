package com.users.api.domain.event;

import com.users.api.core.event.Event;
import com.users.api.domain.dto.UserDTO;
import com.users.api.domain.eventsTypes.EnumUserEventType;

import java.io.Serial;

/**
 * Clase evento para usuario
 *
 * @author diego
 */
public class UserEvent extends Event<EnumUserEventType, UserDTO> {

    @Serial
    private static final long serialVersionUID = 7606279435837318329L;

    public UserEvent() {
    }

    public UserEvent(EnumUserEventType eventType, UserDTO userDTO) {
        super(eventType, userDTO);
    }

    public UserEvent(UserDTO userDTO) {
        super(userDTO);
    }

    public UserEvent(UserDTO userDTO, String processId) {
        super(userDTO, processId);
    }

    public UserEvent(UserDTO userDTO, String processId, int order) {
        super(userDTO, processId, order);
    }

    public static UserEvent createdUserEvent(UserDTO userDTO) {
        return new UserEvent(EnumUserEventType.CREATED, userDTO);
    }

    public static UserEvent deletedUserEvent(UserDTO userDTO) {
        return new UserEvent(EnumUserEventType.DELETED, userDTO);
    }

    public static UserEvent editedUserEvent(UserDTO userDTO) {
        return new UserEvent(EnumUserEventType.EDITED, userDTO);
    }
}
