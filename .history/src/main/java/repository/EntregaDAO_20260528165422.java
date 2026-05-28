package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionFactory;
import model.Entrega;

public class EntregaDAO {
    
    public Entrega inserirEntrega(Entrega entrega) throws SQLException {

        String command = """
                INSERT INTO Entrega
                    (pedido_id
                     motorista_id
                     data_saida
                     data_entrega
                     status);
                VALUES 
                (?,?,?,?,?)
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)){

                stmt.setInt(1, entrega.get);
            }
    }
}
