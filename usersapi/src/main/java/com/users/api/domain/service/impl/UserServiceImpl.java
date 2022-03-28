package com.users.api.domain.service.impl;

import com.users.api.domain.commands.EnumUserCommandType;
import com.users.api.domain.commands.UserCommand;
import com.users.api.domain.dto.UserDTO;
import com.users.api.domain.producers.UserProducer;
import com.users.api.domain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del servicio de usuarios
 *
 * @author diego
 */
@Service
public class UserServiceImpl implements IUserService {

    private final List<UserDTO> listUserInMemoryStorage = new ArrayList<>();

    @Serial
    private static final long serialVersionUID = -7953997590860275848L;

    @Autowired
    private UserProducer userProducer;

    @Override
    public UserDTO create(UserDTO userDTO) {
        userDTO.setId(this.listUserInMemoryStorage.size());
        this.listUserInMemoryStorage.add(userDTO);
        this.userProducer.sendEventFromCommand(new UserCommand(EnumUserCommandType.CREATED, userDTO));
        return userDTO;
    }

    /**
     * Método para buscar el usuario filntrando por id
     *
     * @param userDTO para obtener el id
     * @return el usuario a buscar por id o null
     */
    private UserDTO findUserDTOById(UserDTO userDTO) {
        return this.listUserInMemoryStorage.stream().filter(v -> v.getId().equals(userDTO.getId())).findFirst().orElse(null);
    }

    @Override
    public UserDTO edit(UserDTO userDTO) {
        UserDTO userDtoEdit = this.findUserDTOById(userDTO);

        if (userDtoEdit == null) {
            throw new RuntimeException("No se ha podido encontrar usuario a modificar");
        }

        this.listUserInMemoryStorage.set(this.listUserInMemoryStorage.indexOf(userDtoEdit), userDTO);

        this.userProducer.sendEventFromCommand(new UserCommand(EnumUserCommandType.EDITED, userDTO));
        return userDTO;
    }

    @Override
    public boolean delete(UserDTO userDTO) {
        UserDTO userDtoDelete = this.findUserDTOById(userDTO);

        if (userDtoDelete == null) {
            throw new RuntimeException("No se ha podido encontrar usuario a borrar");
        }

        this.listUserInMemoryStorage.remove(userDtoDelete);

        this.userProducer.sendEventFromCommand(new UserCommand(EnumUserCommandType.DELETED, userDtoDelete));

        return true;
    }

    @Override
    public List<UserDTO> list() {
        return this.listUserInMemoryStorage;
    }
}
