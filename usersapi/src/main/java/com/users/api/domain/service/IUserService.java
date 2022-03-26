package com.users.api.domain.service;

import com.users.api.domain.dto.UserDTO;

import java.io.Serializable;

/**
 * Interfaz para definir el servicio de usuarios
 *
 * @author diego
 */
public interface IUserService extends Serializable {

    /**
     * Método para crear un usuario
     *
     * @param userDTO dto que contiene los datos para crear el usuario
     * @return el usuario dto con los datos de usuario ya creado
     */
    UserDTO create(UserDTO userDTO);
}
