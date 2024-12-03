package br.ufes.log;

public class XMLLog implements ILog {


    @Override
    public void escrever(String message) {
        System.out.println("XMLLog: " + message);
    }
}
