package service;

import java.sql.SQLException;

import model.Motorista;
import repository.MotoristaDAO;
import repository.PedidoDAO;

public class ServiceMotorista {
    
    public Motorista serviceMotorista(Motorista motorista){

        var motoristaDAO = new MotoristaDAO();
        
        if(motorista.getNome().isBlank()){
            throw new IllegalAccessException("O nome do cliente não pode ser vazio");
        }

        if(motorista.getCnh().isBlank()){
            throw new IllegalArgumentException("O CNH nao pode ser vazio");
        }

        if(motorista.getVeiculo().isBlank()){
            throw new Ill
        }


    }
}
