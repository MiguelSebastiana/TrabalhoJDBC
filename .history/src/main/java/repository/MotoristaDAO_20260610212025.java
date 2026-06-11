package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.cj.protocol.Resultset;

import connection.ConnectionFactory;
import model.Motorista;

public class MotoristaDAO {

    public Motorista inserirMotorista(Motorista motorista) throws SQLException{
        String command = """
                INSERT INTO Motorista
                    (nome,
                    cnh,
                    veiculo,
                    cidade_base)
                VALUES
                (?,?,?,?)
                """;

                try(Connection conn = ConnectionFactory.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)){

                        stmt.setString(1, motorista.getNome());
                        stmt.setString(2, motorista.getCnh());
                        stmt.setString(3, motorista.getVeiculo());
                        stmt.setString(4, motorista.getCidade_base());

                        stmt.executeUpdate();
                        
                        ResultSet rs = stmt.getGeneratedKeys();

                        if(rs.next()){
                            motorista.setId(rs.getInt(1));
                        }
                    
                    }

        return motorista;
    }

    public Motorista buscarMotoristaPorID(int id) throws SQLException{

        String command = """
                SELECT 
                    id,
                    nome,
                    cnh,
                    veiculo
                    cidade_base
                FROM Motorista
                WHERE id = ?
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)){

                stmt.setInt(1, id);
                stmt.executeQuery();

                ResultSet rs = stmt.executeQuery();

                if(rs.next()){
                    return new Motorista (
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                    ); 
                }
            }

            return null;
    }

    public List<Motorista> listarTodosMotoristas() throws SQLException{

            Motorista motorista = null;
            List<Motorista> motoristas = new ArrayList<>();

            String command = """
                    SELECT 
                        id,
                        nome,
                        cnh,
                        veiculo,
                        cidade_base
                    FROM Motorista
                    """;
                
            try(Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(command)){

                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()) {
                        motorista = new Motorista(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5));
                            motoristas.add(motorista);
                    }
                }

            return motoristas;
    }

    public boolean deletarMotorista(int id) throws SQLException{

        String command = """
                DELETE FROM Motorista
                WHERE id = ?
                """;

            try(Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(command)){

                    stmt.setInt(1, id);
                    
                    int linhasAfetadas = stmt.executeUpdate();

                    if(linhasAfetadas > 0){
                        return true;
                    }

                    return false;

                }
    }

    public boolean possuiEntregas(int idMotorista) throws SQLException {
        String command = """
                    SELECT COUNT(*) FROM Entrega 
                    WHERE motorista_id = ?;
                """;
    }
}
