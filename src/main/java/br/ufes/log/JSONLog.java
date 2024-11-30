package br.ufes.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JSONLog implements ILog {
    @Override
    public void escrever(String message) {
        System.out.println("JSONLog: " + message);
    }

    public void registrarLog(String nomeUsuario, String codigoPedido, Double nomeMetodo, String nomeCliente) {

        LocalDateTime agora = LocalDateTime.now();
        String data = agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String hora = agora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        StringBuilder log = new StringBuilder();
        log.append("{");
        log.append("\"NOME_USUARIO\":\"").append(nomeUsuario).append("\",");
        log.append("\"Data\":\"").append(data).append("\",");
        log.append("\"Hora\":\"").append(hora).append("\",");
        log.append("\"codigo_pedido\":\"").append(codigoPedido).append("\",");
        log.append("\"Nome de Operação\":\"Calculo do valor total do pedido (").append(nomeMetodo).append(")\",");
        log.append("\"Nome_Cliente\":\"").append(nomeCliente).append("\"");
        log.append("}");


        escrever(log.toString());
    }
}
