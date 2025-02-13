package com.boot.start.config;

import com.boot.start.dto.ExceptionDto;
import com.boot.start.service.bundel.LocalBundleMessageService;
import jakarta.transaction.SystemException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerConfig  {

    @ExceptionHandler(Exception.class)
    ResponseEntity<ExceptionDto> handleSystemException(Exception exception) {
        return ResponseEntity.internalServerError().body(LocalBundleMessageService.getMessages("invalid.id"));
    }



        @ExceptionHandler(MethodArgumentNotValidException.class)
        ResponseEntity<List<ExceptionDto>> handleSystemException(MethodArgumentNotValidException methodArgumentNotValidException) {
            List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();

            List<ExceptionDto> exceptionDtos = new ArrayList<>();

            for (FieldError error : fieldErrors) {
                exceptionDtos.add(LocalBundleMessageService.getMessages(error.getDefaultMessage()));
            }


            return ResponseEntity.internalServerError().body(exceptionDtos);
        }
    }

