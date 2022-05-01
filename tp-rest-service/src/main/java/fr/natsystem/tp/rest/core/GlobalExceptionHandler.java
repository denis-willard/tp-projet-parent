package fr.natsystem.tp.rest.core;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import fr.natsystem.tp.core.exception.GenericException;
import fr.natsystem.tp.core.exception.NotFoundException;
import fr.natsystem.tp.core.exception.TechnicalException;
import fr.natsystem.tp.core.exception.ValidationEntityException;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LogManager.getLogger(GlobalExceptionHandler.class);

    private String version = "1.0";
    private String env = "dev";

    @ExceptionHandler(TechnicalException.class)
    protected ResponseEntity<ErrorResponse> handleTechnicalException(TechnicalException ex) {
        LOGGER.warn("TechnicalException {}", ex.getMessage(), ex);
        return error(HttpStatus.INTERNAL_SERVER_ERROR, ex.getErrorCode(), ex.getDetail());
    }
    
    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex) {
        LOGGER.warn("NotFoundException {}", ex.getMessage(), ex);
        return error(HttpStatus.NOT_FOUND, ex.getErrorCode(), ex.getDetail());
    }

    @ExceptionHandler(ValidationEntityException.class)
    protected ResponseEntity<ErrorResponse> handleValidation(ValidationEntityException ex) {
        LOGGER.warn("ValidationEntityException {}", ex.getMessage(), ex);
        return error(HttpStatus.BAD_REQUEST, ex.getErrorCode(), ex.getDetail(), ex.getListeViolations());
    }
   
    @ExceptionHandler(GenericException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessLogic(GenericException ex) {
        LOGGER.warn("GenericException {}", ex.getMessage(), ex);
        return error(HttpStatus.BAD_REQUEST, ex.getErrorCode(), ex.getDetail());
    }
   
    
    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<ErrorResponse> handleNotFound(RuntimeException ex) {
        LOGGER.warn("RuntimeException {}", ex.getMessage(), ex);
        return error(HttpStatus.NOT_FOUND, ex.toString(), ex.getMessage());
    }

    private ResponseEntity<ErrorResponse> error(HttpStatus status, String code, String message) {
        LOGGER.error("error {}", message);
        final ErrorResponse error = new ErrorResponse();
        return getErrorResponseResponseEntity(status, code, message, error);
    }

    private ResponseEntity<ErrorResponse> getErrorResponseResponseEntity(HttpStatus status, String code, String message, ErrorResponse error) {
        error.setTimestamp(LocalDateTime.now());
        error.setErrorCode(code);
        error.setErrorMessage(message);
        error.setStatus(status.value());
        error.setVersion(version + "-" + env);
        return new ResponseEntity<>(error, status);
    }

    private ResponseEntity<ErrorResponse> error(HttpStatus status, String code, String message, List<String> listeViolations) {
        LOGGER.error("error avec liste{} et {} messages", message, listeViolations.size());
        final ErrorResponse error = new ErrorResponse();
        error.setListeViolations(listeViolations);
        return getErrorResponseResponseEntity(status, code, message, error);
    }

}

