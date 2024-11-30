package br.ufes.moduloDescontoEntrega;

import br.ufes.model.Pedido;

import java.util.HashMap;
import java.util.Map;

public class FormaCalculoDescontoEntregaValorPedidoImpl implements FormaCalculoDescontoEntrega {

    private double limiteValorPedido;
    private static final double VALOR_DESCONTO = 5.0;

    public FormaCalculoDescontoEntregaValorPedidoImpl(double limiteValorPedido) {
        this.limiteValorPedido = limiteValorPedido;
    }

    @Override
    public Map<String, Double> calcularDesconto(Pedido pedido) {
        Map<String, Double> descontoData = new HashMap<>();
        if (pedido.getValorPedido() > this.limiteValorPedido) {
            descontoData.put("Desconto por Valor de Pedido", VALOR_DESCONTO);
        }
        return descontoData;
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return pedido.getValorPedido() > this.limiteValorPedido && pedido.getDescontoConcedido() < 10;
    }


}
