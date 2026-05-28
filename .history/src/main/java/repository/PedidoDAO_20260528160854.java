package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionFactory;
import model.Pedido;

public class PedidoDAO {
    
    public Pedido inserirPedido(Pedido pedido) throws SQLException{

        String command = """
                INSERT INTO Pedido
                    (cliente_id,
                    data_pedido,
                    volume_m3,
                    peso_kg
                    status)
                VALUES
                (?,?,?,?,?)
                """;

            try(Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)){

                    stmt.setInt(1, pedido.getCliente_id());
                    stmt.setDate(2, pedido.getData_pedido());
                    stmt.setDouble(3, pedido.getVolume_m3());
                }
    }
}
