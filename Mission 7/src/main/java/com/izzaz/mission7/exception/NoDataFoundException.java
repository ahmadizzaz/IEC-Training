package com.izzaz.mission7.exception;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException(){
        super("There are no records in the database.");
    }
}
