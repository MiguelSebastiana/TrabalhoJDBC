package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

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
                (?,?,?,?)
                """;

            try(Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)){

                    stmt.setInt(1, pedido.getCliente_id());
                    stmt.setDate(2, pedido.getData_pedido());
                    stmt.setDouble(3, pedido.getVolume_m3());
                    stmt.setDouble(4, pedido.getPeso_kg());
                    stmt.setString(5, pedido.getStatus().getDescricao());

                    stmt.executeUpdate();

                    ResultSet rs = stmt.getGeneratedKeys();

                    if(rs.next()){
                        pedido.setId(rs.getInt(1));
                    }
                }

            return pedido;
    }

    public Pedido buscarPedidoPorId(int id) throws SQLException{

        String command = """
                SELECT (
                    id,
                    cliente_id,
                    volume_m3,
                    peso_kg,
                    status
                    )
                FROM Pedido
                WHERE id = ?
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)){

                stmt.setInt(1, id);
                stmt.executeQuery();

                ResultSet rs = stmt.executeQuery();

                if(rs.next(){
                    return new Pedido (
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.get
                    )
                }
            }
    }
}
