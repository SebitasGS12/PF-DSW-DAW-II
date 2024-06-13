package com.skillswap.skillswap_core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.skillswap.skillswap_core.transacciones.Logger;

 
@ControllerAdvice
public class ControllerExceptionHandler {

    Logger LOG = Logger.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
            ex.getErrorCode().getCodigo(),
            ex.getErrorCode().getMensaje(),
            ex.getErrorCode().getDetalle() + ": \n" + ex.getMessage()
        );
        LOG.error(errorResponse.getMensaje());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
    // Manejar otras excepciones
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        
        
        ErrorResponse errorResponse = new ErrorResponse(
                50000, // Código de error genérico para errores del servidor
                ex.getMessage(),
                request.getDescription(false)
        );
        LOG.error(errorResponse.getMensaje());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
