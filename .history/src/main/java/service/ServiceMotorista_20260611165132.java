package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Motorista;
import repository.MotoristaDAO;
import repository.PedidoDAO;

public class ServiceMotorista {
    
    private MotoristaDAO motoristaDAO = new MotoristaDAO();

    public Motorista serviceInserirMotorista(Motorista motorista){
        
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

        if(id <= 0){
            throw new IllegalArgumentException("O id não pode ser menor ou igual a 0!");
        }

        try{
            motorista = motoristaDAO.buscarMotoristaPorID(id);
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return motorista;

    }

    public List<Motorista> serviceListarMotoristas(){

        List<Motorista> motoristas = new ArrayList();

        motoristas = motoristaDAO.listarTodosMotoristas();
        
        return clientes;
    }

    public void serviceExcluirMotorista(int id) throws SQLException{

        if(id <= 0){
            throw new IllegalArgumentException("O id não pode ser menor ou igual a 0!");
        }

        if(motoristaDAO.possuiEntregas(id)){
            throw new IllegalArgumentException("Não é possivel excluir o motorista. Ele esta vinculado a uma entrega");
        }

        try{
            motoristaDAO.deletarMotorista(id);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
