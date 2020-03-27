package com.izzaz.mission5.exception;

public class IdParamException extends RuntimeException{

    public IdParamException(){
        super("The id parameter is either empty or duplicates with an existing record");
    }
}
