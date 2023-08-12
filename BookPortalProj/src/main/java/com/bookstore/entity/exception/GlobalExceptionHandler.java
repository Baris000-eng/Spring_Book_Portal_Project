package com.bookstore.entity.exception;

import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@ControllerAdvice
@ComponentScan
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?>handleArithmeticException(HttpServletRequest request, Throwable t) {
         LOGGER.error(t.getMessage(),t);
         var map = new HashMap<>();
         map.put("error","Arithmetic Error Occurred !!!");
         return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?>handleRuntimeException(HttpServletRequest request,Throwable t) {
         LOGGER.error(t.getMessage(),t);
         var map = new HashMap<>();
         map.put("error","unknown error occurred");
         return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}



