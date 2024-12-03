package br.ufes.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JSONLog implements ILog {
    @Override
    public void escrever(String message) {
        System.out.println("JSONLog: " + message);
    }


}
