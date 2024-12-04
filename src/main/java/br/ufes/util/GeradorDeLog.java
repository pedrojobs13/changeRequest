package br.ufes.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeradorDeLog {
    public static String execute(String nomeUsuario, String codigoPedido, String nomeMetodo, String nomeCliente, double valorTotalPedido) {
        final LocalDateTime agora = LocalDateTime.now();
        final String data = agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        final String hora = agora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));


        return String.format(
            "NOME_USUARIO: %s | Data: %s | Hora: %s | codigo_pedido: %s | Nome de Operação: Calculo do valor total do pedido (%s) | Nome_Cliente: %s | ValorTotalPedido (%.2f)\n",
            nomeUsuario, data, hora, codigoPedido, nomeMetodo, nomeCliente, valorTotalPedido
        );
    }
}
