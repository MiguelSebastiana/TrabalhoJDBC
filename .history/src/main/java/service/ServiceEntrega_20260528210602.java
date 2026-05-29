package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repository.EntregaDAO;

public class ServiceEntrega {
    
    public static void serviceCancelarEntrega(int id){

        if(id <= 0){
            throw new IllegalArgumentException("O id não pode ser menor ou igual a 0");
        }
        var entregaDAO = new EntregaDAO();

        try{
            entregaDAO.excluirEntrega(id);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Entrega> entregas(){

        List<Entrega> entras = new ArrayList();
        var entregaDAO = new EntregaDAO();

        try{
            entregaDAO.listarEntregas();
        }catch(SQLException e){
            e.printStackTrace();
        }


    }
}
