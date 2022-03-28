package com.users.api.domain.service;

import com.users.api.domain.dto.UserDTO;

import java.io.Serializable;
import java.util.List;

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

    /**
     * Método para editar un usuario
     *
     * @param userDTO dto que contiene los datos para editar el usuario
     * @return el usuario dto con los datos de usuario ya editado
     */
    UserDTO edit(UserDTO userDTO);

    /**
     * Método para borrar un usuario
     *
     * @param userDTO dto que contiene los datos para borrar el usuario
     * @return true si se ha podido borrar el usuario
     */
    boolean delete(UserDTO userDTO);

    /**
     * Método para listar los usuarios
     *
     * @return los usuarios de la aplicación a listar
     */
    List<UserDTO> list();
}
