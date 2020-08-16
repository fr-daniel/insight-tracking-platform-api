package br.com.insight.trackingplatform.exception;

import org.springframework.http.HttpStatus;

public class InsightTrackingPlatformException extends Exception {

    private final String message;
    private final HttpStatus status;

    public InsightTrackingPlatformException(String message) {
        this.message = message;
        this.status = HttpStatus.BAD_REQUEST;
    }

    public InsightTrackingPlatformException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
