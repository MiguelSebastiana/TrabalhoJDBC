package service;

import java.sql.SQLException;

import model.Cliente;
import model.Motorista;
import repository.ClienteDAO;

public class ServiceCliente {

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

    public Cliente 

    if(!clienteDAO.deletarCliente(id)){
        
    }

}