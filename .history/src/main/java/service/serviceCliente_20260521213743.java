package service;

import model.Cliente;

public class serviceCliente {

    public Cliente serviceInserir(Cliente cliente){

        if(cliente.getId() <= 0){
            throw new Ill
        }
        
        return cliente;
    }
}