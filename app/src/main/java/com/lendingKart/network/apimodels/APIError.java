package com.lendingKart.network.apimodels;

public class APIError {

    private int statusCode;
    private String message;

    public APIError() {
    }

    public int status() {
        return statusCode;
    }

    public String message() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}