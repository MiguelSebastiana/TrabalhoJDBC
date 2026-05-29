package service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Cliente;
import model.Pedido;
import repository.ClienteDAO;
import repository.PedidoDAO;

public class ServicePedido {
    
    public Pedido serviceInserirPedido(Pedido pedido){

        Cliente cliente = null;
        var clienteDAO = new ClienteDAO();
        var pedidoDAO = new PedidoDAO();

        try{
            cliente = clienteDAO.buscarClientePorId(pedido.getCliente_id());
        }catch(SQLException e){

        }
        LocalDate data = LocalDate.now();
        Date dataAtual = Date.valueOf(data);

        if(pedido.getData_pedido().after(dataAtual)){
            throw new IllegalArgumentException("A data não pode ser antes da data atual");
        }

        if(pedido.getVolume_m3() < 0){
            throw new IllegalArgumentException("O volume não pode ser negativo");
        }

        if(pedido.getPeso_kg() < 0){
            throw new IllegalArgumentException("O pesso não pode ser negativo");
        }

        try{
            pedidoDAO.inserirPedido(pedido);
        }catch(SQLException e){
            e.printStackTrace();
        }

        return pedido;
    }

    public Pedido serviceProcurarPorId(int id){

        Pedido pedido = null;
        var pedidoDAO = new PedidoDAO();

        if(id <= 0){
            throw new IllegalArgumentException("O id do pedido não pode ser menor ou igual a 0");
        }

        try{
            pedido = pedidoDAO.buscarPedidoPorId(id);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return pedido;
    }

    public boolean serviceCancelarPedido (int id) throws SQLException{

        var pedidoDAO = new PedidoDAO();

        if(id <= 0){
            throw new IllegalArgumentException("O id não pode ser menor ou igual a 0");
        }

        try{

        }catch(SQLException e){

        }


    }
}
