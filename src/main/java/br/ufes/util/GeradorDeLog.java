package br.ufes.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeradorDeLog {
    public static String execute(String nomeUsuario, String codigoPedido, Double nomeMetodo, String nomeCliente) {

        final LocalDateTime agora = LocalDateTime.now();
        final String data = agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        final String hora = agora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        StringBuilder log = new StringBuilder();
        log.append("{");
        log.append("\"NOME_USUARIO\":\"").append(nomeUsuario).append("\",");
        log.append("\"Data\":\"").append(data).append("\",");
        log.append("\"Hora\":\"").append(hora).append("\",");
        log.append("\"codigo_pedido\":\"").append(codigoPedido).append("\",");
        log.append("\"Nome de Operação\":\"Calculo do valor total do pedido (").append(nomeMetodo).append(")\",");
        log.append("\"Nome_Cliente\":\"").append(nomeCliente).append("\"");
        log.append("}");


        return log.toString();
    }
}
