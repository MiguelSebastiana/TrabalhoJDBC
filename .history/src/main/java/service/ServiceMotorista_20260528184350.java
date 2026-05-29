package service;

import java.sql.SQLException;

import model.Motorista;
import repository.MotoristaDAO;
import repository.PedidoDAO;

public class ServiceMotorista {
    
    public Motorista serviceInserirMotorista(Motorista motorista){

        var motoristaDAO = new MotoristaDAO();
        
        if(motorista.getNome().isBlank()){
            throw new IllegalArgumentException("O nome do cliente não pode ser vazio");
        }

        if(motorista.getCnh().isBlank()){
            throw new IllegalArgumentException("O CNH nao pode ser vazio");
        }

        if(motorista.getVeiculo().isBlank()){
            throw new IllegalArgumentException("O veiculo não pode ser vazio");
        }

        if(motorista.getCidade_base().isBlank()){
            throw new IllegalArgumentException("A cidade base não pode ser vazia");
        }

        try{
            motoristaDAO.inserirMotorista(motorista);
        }catch(SQLException e){
            e.printStackTrace();
        }

        return motorista;
    }

    public Motorista serviceBuscarPorId(int id){

        Motorista motorista = null;
        var motoristaDAO = new MotoristaDAO();

        if(id <= 0){
            throw new IllegalArgumentException("O id não pode ser menor ou igual a 0!");
        }

        try{
            motorista = 
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
