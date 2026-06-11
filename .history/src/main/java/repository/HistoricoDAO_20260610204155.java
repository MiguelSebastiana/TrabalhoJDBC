package repository;

import java.net.ConnectException;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.Entrega;

public class HistoricoDAO {
    
    public Entrega inserirEntrega(Entrega entrega) throws SQLException {
        String command = """
                INSERT INTO HistoricoEntrega 
                (entrega_id,
                 data_evento,
                 descricao)
                VALUES
                (?, ?, ?)
                """;
            
            try(ConnectException conn = ConnectionFactory.getConnection()){
                
            }
    }
}
