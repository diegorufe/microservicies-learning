package com.users.api.domain.dto;

import com.users.api.core.dto.BaseDTO;

import java.io.Serial;

/**
 * Clase de datos para usuarios
 *
 * @author diego
 */
public class UserDTO extends BaseDTO {
    @Serial
    private static final long serialVersionUID = 3905459423668981452L;

    private String nick;

    private String name;


    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "nick='" + nick + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
