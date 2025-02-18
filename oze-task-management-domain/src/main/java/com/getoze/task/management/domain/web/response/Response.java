package com.getoze.task.management.domain.web.response;

import lombok.Data;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Data
public class Response<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -8166980726123446321L;

    private boolean isSuccessful;

    private String message;

    private transient T payload;

    public Response(boolean isSuccessful, String message) {
        this.isSuccessful = isSuccessful;
        this.message = message;
    }

    public Response(boolean isSuccessful, String message, T payload) {
        this.isSuccessful = isSuccessful;
        this.message = message;
        this.payload = payload;
    }
}
