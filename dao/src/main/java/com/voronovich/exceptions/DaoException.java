package com.voronovich.exceptions;

/**
 * Class designed to create own exception
 *
 * @author Dmitry V
 * @version 1.0
 */
public class DaoException extends Exception {

    private Exception exception;

    public DaoException(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
