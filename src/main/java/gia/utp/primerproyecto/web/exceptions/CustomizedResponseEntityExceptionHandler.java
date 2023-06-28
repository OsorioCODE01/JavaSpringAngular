package gia.utp.primerproyecto.web.exceptions;

import gia.utp.primerproyecto.web.exceptions.type.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestException(BadRequestException exception, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(), //Fecha
                exception.getMessage(), //Tomo el mensaje de la excepcion para mi excepcion
                webRequest.getDescription(true), //Le digo al  WebRequest que me regrese la descripcion.. de que.. no c
                HttpStatus.BAD_REQUEST.getReasonPhrase()); // tomo la razon del porque del badRequest

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST); //Regreso la respuesta con la info que monte para el error BAD_REQUEST
    }
}
