package br.ufes.model;

import java.time.LocalDate;
import java.util.*;

public class Pedido {
    private final String id;
    private final Double taxaEntrega;
    private final LocalDate dataPedido;
    private final Cliente cliente;
    private final List<Item> itens = new ArrayList<>();
    private CupomDescontoEntrega cuponsDescontoEntrega;

    public Pedido(double taxaEntrega, LocalDate dataPedido, Cliente cliente) {
        if (taxaEntrega < 0 || dataPedido == null || cliente == null) {
            throw new IllegalArgumentException("Valores inválidos para criar o pedido.");
        }
        this.id = UUID.randomUUID().toString();
        this.taxaEntrega = taxaEntrega;
        this.dataPedido = dataPedido;
        this.cliente = cliente;

    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public double getValorPedido() {
        double valorPedido = 0.0;
        for (Item item : itens) {
            valorPedido += item.getValorTotal();
        }
        return valorPedido + taxaEntrega;
    }


    public double getDescontoConcedido() {
        double descontoTotal = 0.0;
        if (cuponsDescontoEntrega != null) {
            descontoTotal = cuponsDescontoEntrega.getValorDesconto();
        }
        return descontoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Pedido{" + "taxaEntrega=" + taxaEntrega + ", cliente=" + cliente + ", itens=" + itens + '}';
    }

}
