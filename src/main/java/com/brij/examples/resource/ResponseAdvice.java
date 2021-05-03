package com.brij.examples.resource;

import com.brij.examples.resource.domain.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ResponseAdvice extends ResponseEntityExceptionHandler {


    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return this.handleExceptionInternal(ex, (Object) null, headers, status, request);
    }

    @Override
    public ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindException ex1 = (BindException) ex;
        List<String> invalidFields = ex1.getAllErrors().stream().map(this::buildError).collect(Collectors.toList());
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute("javax.servlet.error.exception", ex, 0);
        }
        ApiError apiError = new ApiError();
        apiError.setMessage("Invalid request");
        apiError.setInvalidFields(invalidFields);
        return new ResponseEntity(apiError, status);
    }

    private String buildError(ObjectError objectError) {
        if (objectError instanceof FieldError) {
            FieldError error = (FieldError) objectError;
            return error.getField();
        }
        return String.format("%s %s", objectError.getObjectName(), objectError.getDefaultMessage());
    }
}
