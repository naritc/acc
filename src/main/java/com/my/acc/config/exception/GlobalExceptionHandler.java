package com.my.acc.config.exception;

import com.my.acc.model.BaseResponse;
import com.my.acc.model.ValidDetail;
import com.my.acc.model.ValidResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

        List<ValidDetail> dtls = new ArrayList<>();

        validationErrorList.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String validationMsg = error.getDefaultMessage();
            ValidDetail dtl = new ValidDetail();
            dtl.setFieldName(fieldName);
            dtl.setMessage(validationMsg);
            dtls.add(dtl);
        });

        ValidResponse resp = new ValidResponse();
        resp.setStatus(HttpStatus.BAD_REQUEST.toString());
        resp.setMessage("Validation Error");
        resp.setDetails(dtls);

        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> internalGlobalException(Exception exception, WebRequest webRequest) {
        BaseResponse errorResponseDTO = new BaseResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                exception.getMessage()
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BaseResponse> handleGlobalException(BusinessException exception,
                                                                  WebRequest webRequest) {
        BaseResponse errorResponseDTO = new BaseResponse(
                exception.getError().getCode(),
                exception.getError().getDescription()
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
