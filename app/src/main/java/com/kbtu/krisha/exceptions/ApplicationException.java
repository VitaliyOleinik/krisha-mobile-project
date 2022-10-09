package com.kbtu.krisha.exceptions;

class ApplicationException extends RuntimeException {
    private String status = "";

    public ApplicationException(String message) {
        super(message);
        this.status = "INTERNAL_SERVER_ERROR";
    }

    public ApplicationException(String message, String status) {
        super(message);
        this.status = status;
    }

}
