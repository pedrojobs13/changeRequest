package br.ufes.log;

public class DBLog implements ILog {
    @Override
    public void escrever(String message) {
        System.out.println("Logando no banco de dados: " + message);
    }
}
