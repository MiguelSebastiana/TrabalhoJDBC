package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Motorista;
import repository.ClienteDAO;

public class ServiceCliente {

    private ClienteDAO clienteDAO = new ClienteDAO();

    public Cliente serviceInserirCliente(Cliente cliente){

        var clienteDao = new ClienteDAO(); 

        if(cliente.getNome().isBlank()){
            throw new IllegalArgumentException("O nome do cliente não pode ser vazio");
        }
        
        if(cliente.getCpf_cnpj().isBlank()){
            throw new IllegalArgumentException("O cpf/cnpj do cliente nçao pode ser vazio");
        }

        if(cliente.getEndereco().isBlank()){
            throw new IllegalArgumentException("O endereço não pode ser vazio");
        }

        if(cliente.getCidade().isBlank()){
            throw new IllegalArgumentException("A cidade não pode ser vazia");
        }

        if(cliente.getEstado().isBlank()){
            throw new IllegalArgumentException("O estado do cliente nçao pode ser vazio");
        }

        try{
        clienteDao.inserirCliente(cliente);
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return cliente;
    }

    public Cliente serviceProcurarClientePorId(int id){

        Cliente cliente = null;
        var clienteDao = new ClienteDAO(); 

        if(id <= 0){
            throw new IllegalArgumentException("O id não pode ser igual ou menor que zero");
        }

        try{
             cliente = clienteDao.buscarClientePorId(id);
        }catch(SQLException e){
            e.printStackTrace();
        }

        return cliente;
    }

    public List<Cliente> serviceListarClientes() throws SQLException{

        var clienteDAO = new ClienteDAO();
        List<Cliente> clientes = new ArrayList();

        clientes = clienteDAO.listarTodosClientes();
        
        return clientes;
    }

    public boolean serviceDeletarCliente(int id) throws SQLException{

        var clienteDAO = new ClienteDAO(); 

        if(id <= 0){
            throw new IllegalArgumentException("ID Inválido !");
        }

        if(clienteDAO.possuiPedidos(id)){
            throw new IllegalArgumentException("Nao é possivel excluir o cliente. Ele possui pedidos ")
        }

        return clienteDAO.deletarCliente(id);
        
    }

}