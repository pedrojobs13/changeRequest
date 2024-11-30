package br.ufes.moduloDescontoEntrega;

import br.ufes.model.Pedido;

import java.util.Map;

public interface FormaCalculoDescontoEntrega {
    Map<String, Double> calcularDesconto(Pedido pedido);

    boolean seAplica(Pedido pedido);
}
