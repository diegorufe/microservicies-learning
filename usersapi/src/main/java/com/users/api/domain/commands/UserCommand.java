package com.users.api.domain.commands;

import com.users.api.core.commands.BaseCommand;
import com.users.api.domain.dto.UserDTO;

import java.io.Serial;

/**
 * Clase de usuarios para enviar eventos producidos
 *
 * @author diego
 */
public class UserCommand extends BaseCommand<EnumUserCommandType, UserDTO> {

    @Serial
    private static final long serialVersionUID = 2368888138991100436L;

    public UserCommand() {
        this(null, null);
    }


    public UserCommand(EnumUserCommandType commandType, UserDTO userDTO) {
        super(commandType, userDTO);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
