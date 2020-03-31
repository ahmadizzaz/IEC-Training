package com.izzaz.mission8.exception;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(int gameId){
        super(String.format("Game with Id = %d not found.",gameId));
    }
}
