package com.users.api.core.beans.event;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * Clase para guardar el evento producido por el productor y leido por el consumidor
 *
 * @author diego
 */
public class Event<DATA> implements Serializable {
    @Serial
    private static final long serialVersionUID = -6481732092393047136L;

    /**
     * Datos del evento
     */
    private DATA data;

    /**
     * Fecha en la que se origino el evento
     */
    private Date date;

    /**
     * En el caso de necesitarse un identificador uno de succesión de eventos
     */
    private String processId;

    /**
     * Orden en el que se tiene que ejecutar un evento en el caso de que {@link #processId tenga un valor}
     */
    private int order;

    public Event(){

    }

    public Event(DATA data) {
        this.data = data;
        this.date = new Date();
    }

    public Event(DATA data, String processId) {
        this(data);
        this.processId = processId;
    }

    public Event(DATA data, String processId, int order) {
        this(data);
        this.processId = processId;
        this.order = order;
    }


    public DATA getData() {
        return data;
    }

    public void setData(DATA data) {
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Event{" +
                "data=" + data +
                ", date=" + date +
                ", processId='" + processId + '\'' +
                ", order=" + order +
                '}';
    }
}
