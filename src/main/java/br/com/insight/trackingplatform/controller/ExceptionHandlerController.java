package br.com.insight.trackingplatform.controller;

import br.com.insight.trackingplatform.exception.InsightTrackingPlatformException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = InsightTrackingPlatformException.class)
    public ResponseEntity handleInsightTrackingPlatformException(InsightTrackingPlatformException ex) {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), ex.getStatus());
    }

}
