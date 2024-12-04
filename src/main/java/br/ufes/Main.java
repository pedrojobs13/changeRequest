package br.ufes;

import br.ufes.log.ILog;
import br.ufes.log.DBLog;
import br.ufes.log.JSONLog;
import br.ufes.log.XMLLog;
import br.ufes.model.Cliente;
import br.ufes.model.Item;
import br.ufes.model.Pedido;
import br.ufes.moduloDescontoEntrega.FormaCalculoDescontoEntregaValorPedidoImpl;
import br.ufes.moduloDescontoEntrega.FormaDescontoTaxaPorTipoClienteImpl;
import br.ufes.moduloDescontoEntrega.FormaDescontoTipoItemPresenteImpl;
import br.ufes.service.UsuarioLogadoService;
import br.ufes.util.GeradorDeLog;

import java.time.LocalDate;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            ILog log = new JSONLog();

            Cliente cliente = new Cliente(
                    "Maria Oliveira",
                    "Pessoa Física",
                    "Centro",
                    "Ouro",
                    "Vitória",
                    "Rua das Flores, 123"
            );

            double taxaEntrega = 15.0;
            LocalDate dataPedido = LocalDate.now();
            Pedido pedido = new Pedido(taxaEntrega, dataPedido, cliente);

            Item item1 = new Item("Notebook", 1, 3000.0, "Eletrônicos");
            Item item2 = new Item("Teclado", 2, 150.0, "Periféricos");
            Item item3 = new Item("Cadeira Gamer", 1, 800.0, "Móveis");
            pedido.adicionarItem(item1);
            pedido.adicionarItem(item2);
            pedido.adicionarItem(item3);

            FormaCalculoDescontoEntregaValorPedidoImpl descontoValorPedido = new FormaCalculoDescontoEntregaValorPedidoImpl(250.0);
            FormaDescontoTaxaPorTipoClienteImpl descontoTipoCliente = new FormaDescontoTaxaPorTipoClienteImpl();
            FormaDescontoTipoItemPresenteImpl descontoTipoItem = new FormaDescontoTipoItemPresenteImpl();

            Map<String, Double> descontosAplicados = descontoValorPedido.calcularDesconto(pedido);
            descontosAplicados.putAll(descontoTipoCliente.calcularDesconto(pedido));
            descontosAplicados.putAll(descontoTipoItem.calcularDesconto(pedido));

            double totalDesconto = descontosAplicados.values().stream().mapToDouble(Double::doubleValue).sum();
            double valorTotalPedido = pedido.getValorPedido() - totalDesconto;

            String nomeMetodo = "getValorPedido";
            String logMensagem = GeradorDeLog.execute(
                    UsuarioLogadoService.getNomeUsuario(),
                    pedido.getId(),
                    nomeMetodo,
                    pedido.getCliente().getNome(),
                    valorTotalPedido
            );

            log.escrever(logMensagem);
            
        } catch (Exception e) {
            System.err.println("Erro ao executar a aplicação: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
