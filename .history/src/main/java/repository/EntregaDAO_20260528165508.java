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

                stmt.setInt(1, entrega.getPedido_id());
                stmt.setInt(2, entrega.getMotorista_id());
                stmt.setDate(3, entrega.getData_saida());
                stmt.setDate(4, entrega.getData_entrega());
                stmt.set
            }
    }
}
