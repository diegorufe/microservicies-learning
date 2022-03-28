package com.users.api.core.beans.commands;

import java.io.Serial;
import java.io.Serializable;

/**
 * Clase base para eventos a enviar en productor y transformar en consumidores
 *
 * @author diego
 */
public abstract class BaseCommand<COMMAND_TYPE extends ICommandType, DATA> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1979353256040372091L;

    private COMMAND_TYPE commandType;

    private DATA data;

    public BaseCommand() {
        this(null, null);
    }

    public BaseCommand(COMMAND_TYPE commandType, DATA data) {
        this.commandType = commandType;
        this.data = data;
    }


    public COMMAND_TYPE getCommandType() {
        return commandType;
    }

    public void setCommandType(COMMAND_TYPE commandType) {
        this.commandType = commandType;
    }

    public DATA getData() {
        return data;
    }

    public void setData(DATA data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseCommand{" +
                "commandType=" + commandType +
                ", data=" + data +
                '}';
    }
}
