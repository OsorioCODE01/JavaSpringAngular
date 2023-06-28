package gia.utp.primerproyecto.web.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse { // Estructura base para nuestras propias excepciones
    private Date timeStamp;

    private String message;

    private String description;

    private String httpCodeMessage;
}
