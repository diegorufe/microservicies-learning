package com.users.api.core.beans;

import java.io.Serial;
import java.io.Serializable;

/**
 * Clase para respuesta de petición
 *
 * @param <DATA> a alojar en la respusta
 * @author diego
 */
public class ResponseRequest<DATA> implements Serializable {

    @Serial
    private static final long serialVersionUID = 4508327121374913374L;

    private DATA data;

    public ResponseRequest() {
        this(null);
    }

    public ResponseRequest(DATA data) {
        this.data = data;
    }

    public DATA getData() {
        return data;
    }

    public void setData(DATA data) {
        this.data = data;
    }
}
