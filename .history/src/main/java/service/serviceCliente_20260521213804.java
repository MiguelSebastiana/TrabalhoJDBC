package service;

import model.Cliente;

public class serviceCliente {

    public Cliente serviceInserir(Cliente cliente){

        if(cliente.getId() <= 0){
            throw new IllegalArgumentException("O id não pode ser menor que zero");
        }

        if(cliente.getNome().isBlank()){
            
        }
        
        return cliente;
    }
}