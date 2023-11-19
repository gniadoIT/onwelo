package it.gniado.onwelo.controller;

import it.gniado.onwelo.exception.SaveInterruptedException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class ExceptionResolver extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = Logger.getLogger(ExceptionResolver.class.getName());

    @ExceptionHandler(value = {SaveInterruptedException.class})
    protected ResponseEntity<Object> handle(RuntimeException ex, HttpServletRequest servletRequest){
        LOGGER.log(Level.SEVERE, ex.getMessage());
        servletRequest.getSession().setAttribute("Sort", getSort((SaveInterruptedException) ex));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/");
        return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
    }

    private String getSort(SaveInterruptedException ex) {
        return ex.getSort().name();
    }

}