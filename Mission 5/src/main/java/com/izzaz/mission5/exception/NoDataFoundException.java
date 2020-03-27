package com.izzaz.mission5.exception;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException(){
        super("There are no records in the database.");
    }
}
