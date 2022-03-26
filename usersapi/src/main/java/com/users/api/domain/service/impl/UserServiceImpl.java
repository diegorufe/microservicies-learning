package com.users.api.domain.service.impl;

import com.users.api.domain.commands.EnumUserCommandType;
import com.users.api.domain.commands.UserCommand;
import com.users.api.domain.producers.UserProducer;
import com.users.api.domain.dto.UserDTO;
import com.users.api.domain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serial;

/**
 * Implementación del servicio de usuarios
 *
 * @author diego
 */
@Service
public class UserServiceImpl implements IUserService {
    @Serial
    private static final long serialVersionUID = -7953997590860275848L;

    @Autowired
    private UserProducer userProducer;

    @Override
    public UserDTO create(UserDTO userDTO) {
        this.userProducer.sendEventFromCommand(new UserCommand(EnumUserCommandType.CREATE, userDTO));
        return userDTO;
    }
}
