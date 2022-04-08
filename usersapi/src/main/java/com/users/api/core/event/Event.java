package com.users.api.core.event;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Clase para guardar el evento producido por el productor y leido por el consumidor
 *
 * @author diego
 */
public abstract class Event<EVENT_TYPE extends IEventType, DATA> implements Serializable {
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

    /**
     * Tipo de evento
     */
    private EVENT_TYPE eventType;


    public Event(DATA data, String processId, int order) {
        this.data = data;
        this.processId = processId;
        this.order = order;
        this.date = new Date();
        this.generateProcessId();
    }

    public Event() {
        this(null, null, 0);
    }


    public Event(EVENT_TYPE eventType, DATA data) {
        this(data, null, 0);
        this.eventType = eventType;
    }

    public Event(DATA data) {
        this(data, null, 0);
    }

    public Event(DATA data, String processId) {
        this(data, processId, 0);
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

    public EVENT_TYPE getEventType() {
        return eventType;
    }

    public void setEventType(EVENT_TYPE eventType) {
        this.eventType = eventType;
    }

    /**
     * Si el id de processo es null generamos un id aleatorio.
     *
     * <p>{Threadname}_{RandomUUID}_{NanoTIme}</p>
     */
    private void generateProcessId() {
        if (this.processId == null) {
            this.processId = Thread.currentThread().getId() + "_" + UUID.randomUUID() + "_" + System.nanoTime();
        }
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
