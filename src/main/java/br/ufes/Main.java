package br.ufes;

import br.ufes.log.ILog;
import br.ufes.log.JSONLog;
import br.ufes.model.Cliente;
import br.ufes.model.Item;
import br.ufes.model.Pedido;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
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



    log.registrarLog("x", "adsad", pedido.getValorPedido(), cliente.getNome());


    }
}