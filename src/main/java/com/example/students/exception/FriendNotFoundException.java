package com.example.students.exception;


public class FriendNotFoundException extends RuntimeException {

    public FriendNotFoundException(String message) {
        super(message);
    }
}
