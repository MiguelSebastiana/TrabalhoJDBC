package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Entrega;
import model.enums.StatusEntrega;

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
                 FROM Entrega
                 WHERE id = ?); 
                 """;
                 try(Connection conn = ConnectionFactory.getConnection();
                     PreparedStatement stmt = conn.prepareStatement(command)){
                         stmt.setInt(1, id);
                         stmt.executeUpdate();
                         ResultSet rs = stmt.executeQuery();
                          if(rs.next()){
                              return new Entrega(
                                  rs.getInt("id"), 
                                  rs.getInt("pedido_id"),
                                  rs.getInt("motorista_id"), 
                                  rs.getDate("data_saida"),
                                  rs.getDate("data_entrega"),
                                  StatusEntrega.fromDesc(rs.getString("status")));              
                          }
                      }

            return null;
    }

    public List<Entrega> listarEntregas () throws SQLException {

        Entrega entrega = null;
        List<Entrega> entregas = new ArrayList<>();

        String command = """
                 SELECT
                     (id,
                     pedido_id,
                     motorista_id,
                     data_saida,
                     data_entrega,
                     status)
                 FROM Entrega
                 """;
                 try(Connection conn = ConnectionFactory.getConnection())
    }

    public boolean excluirEntrega(int id) throws SQLException{
        String command = """
                DELETE FROM Entrega
                WHERE id = ?
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)){

                stmt.setInt(1, id);

                int linhasAlteradas = stmt.executeUpdate();

                if(linhasAlteradas > 0){
                    return true;
                }
                return false;
            }
    }
}
