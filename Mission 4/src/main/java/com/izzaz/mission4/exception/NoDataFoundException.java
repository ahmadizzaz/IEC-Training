package com.izzaz.mission4.exception;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException(){
        super("There are no records in the database.");
    }
}
