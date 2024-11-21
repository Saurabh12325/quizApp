package com.CloudQuest.quizApp.Exceptions;



public class RandomExceptions extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String message;
    private int statusCode;

    public RandomExceptions(String message, int statusCode) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
}
}