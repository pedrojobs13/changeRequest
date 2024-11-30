package br.ufes.model;

public class Item {
    private final String nome;
    private final Integer quantidade;
    private final Double valorUnitario;
    private final String tipo;

    public Item(String nome, Integer quantidade, Double valorUnitario, String tipo) {
        if (nome == null || quantidade == null || valorUnitario == null || tipo == null) {
            throw new IllegalArgumentException("Valores inválidos para criar o item.");
        }

        this.nome = nome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getValorTotal() {
        return quantidade * valorUnitario;
    }
}
