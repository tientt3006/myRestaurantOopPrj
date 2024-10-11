package com.nolaneg.myrestaurantprj.exceptions;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author $_{user}
 */
public class Experiment_AppException extends RuntimeException{
    public Experiment_AppException() {
    }

    public Experiment_AppException(String message) {
        super(message);
    }

    public Experiment_AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public Experiment_AppException(Throwable cause) {
        super(cause);
    }

    public Experiment_AppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
