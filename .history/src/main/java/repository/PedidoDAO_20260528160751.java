package repository;

import java.sql.Connection;
import java.sql.SQLException;

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

            try(Connection conn = Conne)
    }
}
