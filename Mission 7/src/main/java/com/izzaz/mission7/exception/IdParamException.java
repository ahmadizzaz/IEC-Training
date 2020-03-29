package com.izzaz.mission7.exception;

public class IdParamException extends RuntimeException{

    public IdParamException(){
        super("The id parameter is either empty or duplicates with an existing record");
    }
}
