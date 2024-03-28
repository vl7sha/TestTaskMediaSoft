package ru.vl7sha.testmediasoftacademia.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UIExceptionHandler {

    @ExceptionHandler(UIException.class)
    public ResponseEntity<UIExceptionDTO> handlerException(UIException apiException) {
        return new ResponseEntity<UIExceptionDTO>(
                new UIExceptionDTO(
                        apiException.getMessage(),
                        apiException.getStatus()
                ),
                apiException.getStatus()
        );
    }
}
