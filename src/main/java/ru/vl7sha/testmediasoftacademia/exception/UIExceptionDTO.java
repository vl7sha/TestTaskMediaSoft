package ru.vl7sha.testmediasoftacademia.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class UIExceptionDTO {
    private String message;
    private HttpStatus httpStatus;
}
