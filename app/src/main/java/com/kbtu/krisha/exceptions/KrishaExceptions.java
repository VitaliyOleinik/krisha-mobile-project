package com.kbtu.krisha.exceptions;

class UserNotFoundExceptions extends ApplicationException {
    public UserNotFoundExceptions(String message) {
        super("not_found.user");
    }
}
