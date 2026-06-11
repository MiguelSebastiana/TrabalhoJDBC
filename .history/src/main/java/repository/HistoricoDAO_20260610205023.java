package repository;

import java.net.ConnectException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            
            try(ConnectException conn = ConnectionFactory.getConnection()
                PreparedStatement stmt = conn.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)){
                    
                stmt.setInt(1, historico.getEntrega_id());
                stmt.setDate(2, historico.getData_evento());
                stmt.setString(3, historico.getDescricao());
                stmt.executeUpdate();

                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if(rs.next()){
                        historico.setId(rs.getInt(1));
                    }
                }
            }
        return historico;    
    }

    public void deletarPorEntregaId(int entregaId) throws SQLException {
        String command = """
                DELETE FROM HistoricoEntrega WHERE entrega_id = ?
                """;
            
            try(ConnectException conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatementC(command)) {
                    
                }
            )
    }
}
