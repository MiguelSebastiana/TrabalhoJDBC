package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                stmt.setString(5, entrega.getStatus().getDescricao());

                ResultSet rs = stmt.getGeneratedKeys();

                if(rs.next()){
                    entrega.setId(rs.getInt(1));
                }
            }

        return entrega;
    }

    public Entrega buscarEntregaPorId(int id) throws SQLException{
        
        String command = """
                SELECT
                    (id,
                    pedido_id,
                    motorista_id,
                    data_saida,
                    data_entrega,
                    status
                WHERE id = ?); 
                """;

                try(Connection conn = ConnectionFactory.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(command)){

                        stmt.setInt(1, id);
                        stmt.executeUpdate();

                        ResultSet rs = stmt.executeQuery();

                        if(rs.next()){
                            return new Entrega(
                                rs.getInt(1), 
                                rs.getInt(2),
                                rs.getInt(3), 
                                rs.getDate(4)
                                rs.get
                                null);
                        }
                    }


    }
}
