package com.izzaz.mission5.exception;

public class EmptyParamException extends RuntimeException{

    public EmptyParamException(){
        super("One or more parameter(s) are empty.");
    }
}
