package service;

import java.sql.SQLException;

import repository.HistoricoDAO;

public class ServiceHistorico {

    private HistoricoDAO historicoDAO = new HistoricoDAO();

    public HistoricoDAO registrarEvento(int entregald, String descricao) throws SQLException {
        
        if(descricao.isBlank()){
            throw new IllegalArgumentException()
        }
    }
}
