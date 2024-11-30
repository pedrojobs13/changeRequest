package br.ufes.log;

public interface ILog {
    void escrever(String message);

    void registrarLog(String nomeUsuario, String codigoPedido, Double nomeMetodo, String nomeCliente);
}
