package com.devsu.commons.infra.messaging.dto;

public class CuentaMessage extends MessageBase {

    private long clienteid;

    public CuentaMessage(String operation, long clienteid) {
        super();
        super.setOperation(operation);
        this.clienteid = clienteid;
    }

    public long getClienteid() {
        return clienteid;
    }

    public void setClienteid(long clienteid) {
        this.clienteid = clienteid;
    }

    @Override
    public String toString() {
        return "CuentaMessage{" +
                "clienteid=" + clienteid +
                "} " + super.toString();
    }
}
