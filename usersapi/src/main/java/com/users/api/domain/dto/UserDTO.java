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

    private Integer id;

    private String nick;

    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
