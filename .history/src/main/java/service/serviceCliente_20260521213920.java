package service;

import model.Cliente;

public class serviceCliente {

    public Cliente serviceInserir(Cliente cliente){

        if(cliente.getId() <= 0){
            throw new IllegalArgumentException("O id não pode ser menor que zero");
        }

        if(cliente.getNome().isBlank()){
            throw new IllegalArgumentException("O nome do cliente nçao pode ser vazio");
        }
        
        if(cliente.getCpf_cnpj().isBlank()){
            throw new IllegalArgumentException("O cpf/cnpj do cliente nçao pode ser vazio");
        }

        if(cliente.getEndereco().isBlank()){
            t
        }
        
        return cliente;
    }
}