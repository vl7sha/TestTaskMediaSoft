package ru.vl7sha.testmediasoftacademia.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UIException extends RuntimeException {
    private final HttpStatus status;

    public UIException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public UIException() {
        super(HttpStatus.BAD_REQUEST.getReasonPhrase());
        status = HttpStatus.BAD_REQUEST;
    }

    public UIException(String msg) {
        super(msg);
        status = HttpStatus.BAD_REQUEST;
    }
}
