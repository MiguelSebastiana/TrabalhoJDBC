package service;

import java.sql.SQLException;

import repository.EntregaDAO;

public class ServiceEntrega {
    
    public static void serviceCancelarEntrega(int id){

        if(id <= 0){
            throw new IllegalArgumentException("")
        }
        var entregaDAO = new EntregaDAO();

        try{
            entregaDAO.excluirEntrega(id);
        }catch(SQLException e){

        }
    }
}
