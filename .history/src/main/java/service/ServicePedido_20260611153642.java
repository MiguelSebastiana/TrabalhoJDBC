package service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Pedido;
import repository.ClienteDAO;
import repository.PedidoDAO;

public class ServicePedido {
    
    private PedidoDAO pedidoDAO = new PedidoDAO();

    public Pedido serviceInserirPedido(Pedido pedido){

        Cliente cliente = null;
    

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

    public List<Pedido> serviceListarTodos() throws SQLException{
        return pedidoDAO.listarPedidos();
    }

    public boolean serviceCancelarPedido (int id) throws SQLException{

        if(id <= 0){
            throw new IllegalArgumentException("O id não pode ser menor ou igual a 0");
        }

        try{
            pedidoDAO.cancelarPedido(id);
        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    public Pedido serviceBuscarPorCpfCnpj(String CpfCnpj) throws SQLException{

        Pedido pedido = null;

        if(CpfCnpj.isBlank()){
            throw new IllegalArgumentException("O cpf/cnpj não pode ser vazio!");
        }

        try{
            pedido = pedidoDAO.buscarPorCpfCnpj(CpfCnpj);
        }catch(SQLException e){
            e.printStackTrace();
        }

        return pedido;
          
        
    }
}
