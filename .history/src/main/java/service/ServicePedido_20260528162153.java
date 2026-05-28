package service;

import java.sql.Date;
import java.time.LocalDate;

import model.Pedido;
import repository.PedidoDAO;

public class ServicePedido {
    
    public Pedido serviceInserirPedido(Pedido pedido){

        var pedidoDAO = new PedidoDAO();

        if(pedido.getCliente_id() <= 0){
            throw new IllegalArgumentException("O id do cliente não pode ser menor ou igual a 0");
        }

        LocalDate data = LocalDate.now();
        Date dataAtual = Date.valueOf(data);

        if(pedido.getData_pedido().after(null))
    }
}
