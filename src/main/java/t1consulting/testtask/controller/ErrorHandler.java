package t1consulting.testtask.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * Класс предназначен для обработки ошибок.
 */
@RestControllerAdvice
@Slf4j
public class ErrorHandler {
    /**
     * Обработка ошибок, связанных с валидацией.
     *
     * @param e обрабатываемое исключение.
     * @return сообщение об исключении.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidationException(final ConstraintViolationException e) {
        log.info("Error: " + e.getMessage());
        return e.getMessage();
    }

    /**
     * Обработка остальных исключений.
     *
     * @param e выбрасывамое исключение.
     * @return сообщение об исключении.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(final Throwable e) {
        log.info("Error: " + e.getMessage());
        return e.getMessage();
    }
}
