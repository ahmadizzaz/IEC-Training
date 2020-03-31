package com.izzaz.mission8.exception;

public class EmptyParamException extends RuntimeException{

    public EmptyParamException(){
        super("One or more parameter(s) are empty.");
    }
}
