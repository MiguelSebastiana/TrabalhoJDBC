package service;

import java.sql.Date;
import java.sql.SQLException;

import model.HistoricoEntrega;
import repository.HistoricoDAO;

public class ServiceHistorico {

    private HistoricoDAO historicoDAO = new HistoricoDAO();

    public HistoricoDAO registrarEvento(int entregald, String descricao) throws SQLException {
        
        if(descricao.isBlank()){
            throw new IllegalArgumentException("A descricao do evento nao pode estar em branco");
        }

        HistoricoEntrega historico = new HistoricoEntrega(entregald, Date.valueOf(Local), descricao)

    }
}
