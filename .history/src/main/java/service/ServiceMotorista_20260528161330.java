package service;

import java.sql.SQLException;

import model.Motorista;
import repository.MotoristaDAO;
import repository.PedidoDAO;

public class ServiceMotorista {
    
    public Motorista ServiceMotorista(Motorista motorista) throws SQLException{

        var motoristaDAO = new MotoristaDAO();
        
        if(motorista.getNome().isBlank()){
            throw new IllegalAccessException("O nome do cliente não pode ser vazio");
        }
    }
}
