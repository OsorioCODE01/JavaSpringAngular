package gia.utp.primerproyecto.web.exceptions.type;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) //En este ma baso para crear mas Response  de Excepciones
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
