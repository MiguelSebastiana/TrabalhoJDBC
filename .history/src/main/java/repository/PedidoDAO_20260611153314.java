package repository;

import java.io.ObjectInputFilter.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import connection.ConnectionFactory;
import model.Pedido;
import model.enums.StatusEntrega;
import model.enums.StatusPedido;

public class PedidoDAO {
    
    public Pedido inserirPedido(Pedido pedido) throws SQLException{

        String command = """
                INSERT INTO Pedido
                    (cliente_id,
                    data_pedido,
                    volume_m3,
                    peso_kg,
                    status)
                VALUES
                (?,?,?,?,?)
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
                 SELECT
                     id,
                     cliente_id,
                     data_pedido,
                     volume_m3,
                     peso_kg,
                     status
                 FROM Pedido
                 WHERE id = ?
                 """;

         try(Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(command)){

                 stmt.setInt(1, id);
                 stmt.executeQuery();

                 ResultSet rs = stmt.executeQuery();

                  if(rs.next()){
                      return new Pedido (
                          rs.getInt("id"),
                          rs.getInt("cliente_id"),
                          rs.getDate("data_pedido"),
                          rs.getDouble("volume_m3"),
                          rs.getDouble("peso_kg"),
                          StatusPedido.fromDesc(rs.getString("status")));
                  }
             }

        return null;
     }

     public Pedido buscarPorCpfCnpj(String CpfCnpj) throws SQLException{

        String command = """
                SELECT
                     p.id,
                     cliente_id,
                     data_pedido,
                     volume_m3,
                     peso_kg,
                     status
                FROM Pedido
                WHERE cpf_cnpj = ?
                 """;

                try(Connection conn = ConnectionFactory.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(command)){

                        stmt.setString(1, CpfCnpj);
                        stmt.executeQuery();

                        ResultSet rs = stmt.executeQuery();

                        if(rs.next()){
                            return new Pedido
                            (rs.getInt("id"),
                            rs.getInt("cliente_id"),
                            rs.getDate("data_pedido"),
                            rs.getDouble("volume_m3"),
                            rs.getDouble("peso_kg"),
                            StatusPedido.fromDesc(rs.getString("status")));
                        }
                    }

                return null; 
     }

     public List<Pedido> listarPedidos() throws SQLException{

        
        List<Pedido> pedidos = new ArrayList<>();

        String command = """
                 SELECT 
                     id,
                     cliente_id,
                     data_pedido,
                     volume_m3,
                     peso_kg,
                     status
                 FROM Pedido
                 """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)){

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        rs.getInt("cliente_id"),
                        rs.getDate("data_pedido"),
                        rs.getDouble("volume_m3"),
                        rs.getDouble("peso_kg"),
                        StatusPedido.fromDesc(rs.getString("status")));       
                        
                        pedidos.add(pedido);
                }

                return pedidos;

            }
     }

     public boolean atualizarStatusPedido(int id, StatusPedido status) throws SQLException {
        String command = """
                    UPDATE Pedido SET status = ? WHERE id = ?
                """;

                try(Connection conn = ConnectionFactory.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(command)){

                        stmt.setString(1, status.name());
                        stmt.setInt(2, id);
                        return stmt.executeUpdate() > 0;
                    }
     }

     public boolean cancelarPedido(int id) throws SQLException{
        String command = """
                DELETE FROM Pedido
                WHERE id = ?
                """;
        
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)){

                stmt.setInt(1, id);
                
                int linnhasAlteradas = stmt.executeUpdate();

                if(linnhasAlteradas > 0){
                    return true;
                }
            }

        return false;
     }
}
