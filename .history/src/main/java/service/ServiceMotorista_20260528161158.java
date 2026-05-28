package service;

import model.Motorista;
import repository.MotoristaDAO;
import repository.PedidoDAO;

public class ServiceMotorista {
    
    public Motorista ServiceMotorista(Motorista motorista){

        var motoristaDAO = new MotoristaDAO();
        
        if(motorista.getNome().isBlank())
    }
}
